#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
typedef struct queue queue;
typedef unsigned char byte;
typedef struct node node;
typedef struct element element;
typedef struct hash_table hash;

struct queue
{
    node *head;
};

struct node
{
    byte item;
    long int priority;
    node *left;
    node *right;
    node *next;
};

struct element
{
    byte binary[100];
};

struct hash_table
{
    element *table[256];
};

hash* create_dictionary()
{
    hash *new_hash = (hash*) malloc(sizeof(hash));
    int i;
    for (i = 0; i < 256; i++) new_hash->table[i] = NULL;
    return new_hash;
}

void put_string_in_hash(hash *ht, byte index, byte *binary)
{
    element *new_element = (element*) malloc(sizeof(element));
    strcpy(new_element->binary, binary);
    ht->table[index] = new_element;
}

void print_dictionary(hash *ht)
{
    int i;
    for(i=0;i <= 255;i++)
    {
        if(ht->table[i] != NULL)
        {
            printf("%c	-	%s\n",i,ht->table[i]->binary);
        }
    }
}

queue* create_queue()
{
    queue *new_queue = (queue*) malloc(sizeof(queue));
    new_queue->head = NULL;
    return new_queue;
}

void print(node *aux)
{
    if(aux != NULL)
    {
        printf("%d %c\n",aux->priority, aux->item);
        print(aux->left);
        print(aux->right);
    }
}

node* dequeue(queue *pq)
{
    if (pq == NULL) {
        printf("Priority Queue underflow");
        return NULL;
    } else {
        node *node = pq->head;
        pq->head = pq->head->next;
        node->next = NULL;
        return node;
    }
}

void enqueue(queue *pq, byte item, long int freq, node *left, node *right)
{
    node *new_node = (node*) malloc(sizeof(node));
    new_node->item = item;//o//v
    new_node->priority = freq;//2//1
    new_node->left = left;
    new_node->right = right;
    
    if (pq->head == NULL || freq < pq->head->priority) {
        new_node->next = pq->head;
        pq->head = new_node;
    } else {
        node *current = pq->head;
        while (current->next != NULL && current->next->priority < freq) {
            current = current->next;
        }
        new_node->next = current->next;
        current->next = new_node;
    }
}

void print_in_order(node *bt)
{
    if (bt != NULL) {
        print_in_order(bt->left);
        printf("%c", bt->item);
        print_in_order(bt->right);
        
    }
}

byte* add_left(byte *binary, long long int *i)
{
    binary[*i] = '0';
    *i += 1;
    return binary;
}

byte* add_right(byte *binary, long long int *i)
{
    binary[*i] = '1';
    *i += 1;
    return binary;
}

void dicionario(hash *ht, node *huff, byte *binary, long int *i)
{
    if(huff != NULL)
    {
        if(huff->left == NULL && huff->right == NULL)
        {
            put_string_in_hash(ht, huff->item, binary);
            //printf("%c	-	%s\n",huff->item,binary);
            binary[*i] = NULL;
            *i -= 1;
            return;
        }
        binary = add_left(binary,i);
        dicionario(ht,huff->left, binary, i);
        
        binary = add_right(binary,i);
        dicionario(ht,huff->right, binary, i);
        
        binary[*i] = NULL;
        *i -= 1;
    }
}


void btree_huff(queue *fila)
{
    node *aux = fila->head;
    node *aux2 = aux->next;
    
    while(aux2 != NULL){
        enqueue(fila,'*', aux->priority + aux2->priority, aux, aux2);
        dequeue(fila);
        dequeue(fila);
        aux = fila->head;
        aux2= aux->next;
    }
    
    node *huffman = fila->head;
    aux = huffman;
    printf("Tree	-	");
    print_in_order(aux);
    printf("\n");
    
    byte binary[30] = {0};
    long int cont=0;
    
    hash *dictionary = create_dictionary();
    dicionario(dictionary, huffman, binary, &cont);
    print_dictionary(dictionary);
}

void huff(long int *freq)
{
    int i,flag = 0;
    queue *fila = create_queue();
    
    
    for(i=0;i<256;i++)
    {
        if(freq[i] != 0) enqueue(fila,i,freq[i], NULL, NULL);
        
    }
    
    btree_huff(fila);
}

int main() {
    char string[256];
    long int freq[256] = {0};
    scanf("%s",string);
    
    int i,j,tam = strlen(string);
    
    for(i=0;i<tam;i++)
    {  
        for(j=0;j<256;j++)
        {
            if(string[i] == j) freq[j]++;
        }
    }
    
    huff(freq);
    
	return 0;
}
