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
    byte c;
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
    node *next;
};

btree* create_empty_btree(){
    return NULL;
}


queue* create_queue()
{
    queue *new_queue = (queue*) malloc(sizeof(queue));
    new_queue->head = NULL;
    return new_queue;
}

void print(queue *fila)
{
    node *aux = fila->head;
    while(aux != NULL)
    {
        printf("%d %c\n",aux->priority, aux->item);
        aux = aux->next;
    }
}

void enqueue(queue *pq, byte item, long int freq)
{
    node *new_node = (node*) malloc(sizeof(node));
    new_node->item = item;//o//v
    new_node->priority = freq;//2//1
    
    if (pq->head == NULL || freq < pq->head->priority) {
        //printf("oi\n");
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

void huff(btree *bt, long int *freq)
{
    int i,flag = 0;
    queue *fila = create_queue();
    
    
    for(i=0;i<256;i++)
    {
        if(freq[i] != 0)
        {
            enqueue(fila,i,freq[i]);
        }
        
    }
    print(fila);
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
    
   /* for(i=0;i<256;i++)
    {
        if(freq[i] != 0){
            printf("%c %d\n",i, freq[i]);
        }
    }*/
    
    huff(arv,freq);
    
	return 0;
}
