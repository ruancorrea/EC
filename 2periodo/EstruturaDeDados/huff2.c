#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <stdbool.h>

typedef struct binary_tree binary_tree;
typedef struct node node;
typedef unsigned char byte;
typedef struct heap heap;

struct heap {
    int size;
    unsigned data[256];
    byte c[256];
};

struct binary_tree
{
    unsigned frequence;
    byte c;
    binary_tree *left;
    binary_tree *right;
};

struct node
{
    binary_tree *item;
    node *next;
};

heap* create_heap(){
    heap *new_heap = (heap*)malloc(sizeof(heap));
    new_heap->size=0;
    return new_heap;
}

binary_tree* create_binary_tree(byte c, unsigned freq, binary_tree *left, binary_tree *right)
{
    binary_tree *new_binary_tree = (binary_tree*) malloc(sizeof(binary_tree));

    if(new_binary_tree == NULL) return NULL;

    new_binary_tree->c = c;
    new_binary_tree->frequence = freq;
    new_binary_tree->left = left;
    new_binary_tree->right = right;
    return new_binary_tree;
}

node* add_node(node *list, binary_tree *bt)
{
    node *new_node = (node*) malloc(sizeof(node));
    if(new_node == NULL) return NULL;


    new_node->item = bt;
    new_node->next = list;

    return new_node;
}

void swap(byte *a, byte *b, int *c, int *d){
    byte aux = *a;
    *a = *b;
    *b = aux;

    int aux1 = *c;
    *c = *d;
    *d = aux1;

}

int get_parent_index(heap *heap, int i)
{
    return i/2;
}

int get_left_index(heap *heap, int i)
{
    return 2*i;
}

int get_right_index(heap *heap, int i)
{
    return 2*i + 1;
}

int item_of(heap *heap, int i)
{
    return heap->data[i];
}

void max_heapify(heap *hp, int i)
{
    int largest;
    int left_index = get_left_index(hp, i);
    int right_index = get_right_index(hp, i);
    if (left_index <= hp->size && hp->data[left_index] > hp->data[i]) largest = left_index;
        else largest = i;

    if (right_index <= hp->size && hp->data[right_index] > hp->data[largest]) largest = right_index;

    if (hp->data[i] != hp->data[largest]) {
        swap(&hp->c[i], &hp->c[largest], &hp->data[i], &hp->data[largest]);
        max_heapify(hp, largest);
    }
}

void max_heap(heap* heap)
{
    int i;
    for(i=(heap->size/2) ; i ; i--) max_heapify(heap,i);
}

binary_tree* adc(node *list)
{
    binary_tree *arv = list->item;
    list=list->next;

    return arv;
}

void ordenando(node *headA)
{
    node *aux = headA;
    node *headB = headA;

    while(headB != NULL)
    {
        while(headA != NULL)
        {
            if(headA->item->frequence > headB->item->frequence)
            {
                binary_tree* copy= headA->item;
                headA->item = headB->item;
                headB->item = copy;
            }
            headA = headA->next;
        }
        headB = headB->next;
        headA = aux;
    }

}

void print_node(node *head)
{
    while(head!=NULL)
    {
        printf("%d %c\n",head->item->frequence,head->item->c);
        head = head->next;
    }
}

binary_tree* create_huffman_tree(heap *hp)
{
    int i;
    binary_tree *arv;
    node *list = NULL;

    for(i=hp->size;i>0;i--)
    {
        arv = create_binary_tree(hp->c[i],hp->data[i],NULL,NULL);
        list = add_node(list,arv);

    }
    
    i=1;
    
    while(i < hp->size)
    {
        binary_tree *l = adc(list);
        list=list->next;
        binary_tree *r = adc(list);
        list=list->next;
        binary_tree *soma = create_binary_tree('*', l->frequence + r->frequence, l, r);
        list = add_node(list,soma);
        ordenando(list);
        i++;
    }
    return list->item;
}

void freq(FILE *entrada, unsigned *bytes)
{
	byte c;
	while(fread(&c,1,1,entrada)) bytes[c]+=1;//le o arquivo ate o final
//e atribui a frequencia ao caracter c
	rewind(entrada);// volta o arquivo ao seu comeco
}

void print(heap *heap){
    int i;
    for(i=1;i<=heap->size;i++) printf("%d %c\n",heap->data[i],heap->c[i]);
}

void heapsort(heap *hp)
{
    int i;
    for (i = hp->size; i >= 2; i--) {
        swap(&hp->c[1], &hp->c[i], &hp->data[1], &hp->data[i]);
        hp->size--;
        max_heapify(hp, 1);
    }
}

void transformers(unsigned *bytes, heap *hp)
{
    int i,j,aux=-1,flag=0;

    for(i=1;i<256;i++)
    {
        for(j=aux+1;j<256;j++)
        {
            if(bytes[j]!=0)
            {
                hp->data[i] = bytes[j];
                hp->c[i]=j;
                hp->size+=1;
                flag+=1;
                aux=j;
                j=256;
            }
        }
    }
    max_heap(hp);
    heapsort(hp);
    hp->size = flag;
}

void print_pre_order(binary_tree *bt)
{
    if(bt != NULL)
    {
        printf("%d %c\n", bt->frequence, bt->c);
        print_pre_order(bt->left);
        print_pre_order(bt->right);
    }
}

void compact(FILE *entrada, unsigned *bytes)
{
    heap *hp = create_heap();
	freq(entrada,bytes);
	int i;
    transformers(bytes, hp);

	binary_tree *arv = create_huffman_tree(hp);
	print_pre_order(arv);
}

int main()
{
	FILE *entrada;
	char arq[500];//nome do arquivo e seu tipo(ex: arquivo.txt)
	scanf("%s",arq);
	entrada = fopen(arq, "rb");//fopen "chama" o arquivo, fopen("arquivo.tipo", "forma") forma- r,w,a (rb,wb,ab) binario
	if(entrada == NULL) exit(0);//verifica se o arquivo eh valido

	//scanf("%s",caminho);//ainda falta arrumar, escolha para compactar ou descompactar
	unsigned bytes[256] = {0};
    compact(entrada,bytes);
	fclose(entrada);
	return 0;
}
