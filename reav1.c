#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
typedef struct btree btree;
typedef struct queue queue;
typedef unsigned char byte;
typedef struct node node;

struct btree
{
    node *c;
    btree *left;
    btree *right;
};

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

btree* create_empty_btree(){
    return NULL;
}

/*btree* create_btree(byte item, long int freq, btree *left, btree *right)
{
    btree *new_binary_tree = (btree*) malloc(sizeof(btree));
    new_binary_tree->c = item;
    new_binary_tree->freq = freq;
    new_binary_tree->left = left;
    new_binary_tree->right = right;
    return new_binary_tree;
}*/

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

void btree_huff(btree *bt, queue *fila)
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
    
    print(huffman);
}

void huff(btree *bt, long int *freq)
{
    int i,flag = 0;
    queue *fila = create_queue();
    
    
    for(i=0;i<256;i++)
    {
        if(freq[i] != 0) enqueue(fila,i,freq[i], NULL, NULL);
        
    }
    
    btree_huff(bt,fila);
    
    
    //print(fila);
}

int main() {
    btree *arv = create_empty_btree();
    char string[256];
    long int freq[256] = {0};
    scanf("%s",string);
    
    int i,j,tam = strlen(string);
    
    for(i=0;i<tam;i++)
    {  
        for(j=0;j<256;j++)
        {
      
            if(string[i] == j)
            {
                freq[j]++;
            }
        }
    }
    
    huff(arv,freq);
    
	return 0;
}
