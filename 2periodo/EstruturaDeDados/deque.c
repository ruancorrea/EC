#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <limits.h>

typedef struct _deque deque_t;
typedef struct _node   node_t;

//Guarda um ponteiro pro node anterior, para o proximo node e o valor guardado
struct _node {
	node_t *prev;
  	node_t *next;
  	int    value;
};

//Guarda um ponteiro para o primeiro node, um ponteiro para o ultimo node, e o tamanho do deque
struct _deque {
  	node_t *front;
  	node_t  *rear;
  	int      size;
};

//Cria um node que guarda os valores que s�o enfileirados no deque
node_t*  node_new     (int value);

//Cria um deque dinamicamente e retorna seu endere�o de memoria
deque_t* construct    ();
//Libera a mem�ria do conte�do e do pr�prio deque
void     destruct     (deque_t *deque);

//Retorna o tamanho do deque
int      size         (deque_t *deque);
//Retorna verdadeiro se o deque esta vazio, caso contr�rio, retorna falso
bool     empty        (deque_t *deque);

//Retorna o valor da frente da lista, retorna int_min quando a lista estiver vazia
int      front        (deque_t *deque);
//Retorna o valor do fim da lista, retorna int_min quando a lista estiver vazia
int      rear         (deque_t *deque);

//Cria um n� que guarda um valor e o adiciona ao fim do deque
void     enqueue_rear (deque_t *deque, int value);
//Cria um n� que guarda um valor e o adiciona ao inicio do deque
void     enqueue_front(deque_t *deque, int value);
//Retira o valor do final caso n�o esteja vazia
void     dequeue_rear (deque_t *deque);
//Retira o valor da frente caso n�o esteja vazia
void     dequeue_front(deque_t *deque);
//Limpa o conteudo do deque(deixa ele vazio)
void     erase        (deque_t *deque);

//Imprime o deque em uma unica linha, com os elementos separados por um espa�o,
//terminando com um \n, lembrando de respeitar os conceitos de fila.
void     print        (deque_t *deque);

int main() {
 	int i, num;
  	scanf("%d", &num);
  
  	deque_t* deque = construct();
  
  	int vector[num];
  	for(i = 0; i < num; ++i)
      	scanf("%d", &vector[i]);
  
  	for(i = 0; i < num; ++i)
      	enqueue_rear(deque, vector[i]);
  
 	printf("%d\n", front(deque));
  	printf("%d\n", rear (deque));
  
  	if(!empty(deque))
  		printf("The size of the deque %d\n", size(deque));
  	else
       	printf("The deque is empty\n");
  	
    scanf("%d", &num);
    for(i = 0; i < num; ++i)
       enqueue_front(deque, i);
  	print(deque);
    dequeue_front(deque);
    print(deque);
    dequeue_rear (deque);
    print(deque);
    
  	erase(deque);
  	for(i = 0; i < 3; ++i)
  		enqueue_rear(deque, i);
  		
  	print(deque);
    destruct(deque);
       
	return 0;
}






//Cria um node que guarda os valores que s?o enfileirados no deque
node_t*  node_new     (int value);


deque_t* construct    ()
{
    deque_t* new_deque = (deque_t*) malloc(sizeof(deque_t));
    new_deque->front = NULL;
    new_deque->rear = NULL;
    new_deque->size = 0;
    return new_deque;
}

void     destruct     (deque_t *deque){
    free(deque);
}
int size(deque_t *deque)
{
    return deque->size;
}

bool empty(deque_t *deque)
{
    if(deque->size==0)
    {
        return 1;
    }
    else return 0;
}

//Retorna o valor da frente da lista, retorna int_min quando a lista estiver vazia
int      front        (deque_t *deque){
    node_t *aux=deque->rear;
    if(aux==NULL){
        return -1;
    }else while(aux != NULL)
    {
        //printf("%d\n",aux->value);
        if(aux->prev==NULL)
        {
            deque->front=aux;
            return aux->value;
        }
        aux=aux->prev;
    }
}
//Retorna o valor do fim da lista, retorna int_min quando a lista estiver vazia
int rear(deque_t *deque)
{
    if(deque->rear==NULL)
    {
        return -1;
    }
    return deque->rear->value;
}

//Cria um n? que guarda um valor e o adiciona ao fim do deque
void enqueue_rear(deque_t *deque, int value)
{
    node_t *new_node = (node_t*) malloc(sizeof(node_t));
    new_node->value=value;
    new_node->prev=deque->rear;
    new_node->next=NULL;
    if(deque->rear!=NULL)
    {
        deque->rear->next=new_node;
        if(deque->size==1){
        deque->front=deque->rear;
        }
    }
    deque->rear=new_node;
    deque->size++;
    
}
//Cria um n? que guarda um valor e o adiciona ao inicio do deque
void     enqueue_front(deque_t *deque, int value){
    
    node_t *new_node = (node_t*) malloc(sizeof(node_t));
    new_node->value=value;
    new_node->next=deque->front;
    new_node->prev=NULL;
    if(deque->front!=NULL)
    {
        deque->front->prev=new_node;
    }
    deque->front=new_node;
    deque->size++;
}


//Retira o valor do final caso n?o esteja vazia
void     dequeue_rear (deque_t *deque){
    deque->rear=deque->rear->prev;
    deque->rear->next=NULL;
    
        
}

//Retira o valor da frente caso n?o esteja vazia
void     dequeue_front(deque_t *deque){
    deque->front=deque->front->next;
    deque->front->prev=NULL;
}
//Limpa o conteudo do deque(deixa ele vazio)
void     erase        (deque_t *deque)
{
    deque->front=NULL;
    deque->rear=NULL;
    deque->size=0;
    
}

//Imprime o deque em uma unica linha, com os elementos separados por um espa?o,
//terminando com um \n, lembrando de respeitar os conceitos de fila.
void     print        (deque_t *deque){
    node_t *aux = deque->front;
    if(deque->front==NULL)
    {
        puts("Front NULL");
    }
    while(aux!=NULL){
        if(aux->next==NULL){
            printf("%d",aux->value);
        } else printf("%d ",aux->value);
        aux=aux->next;
    }
    printf("\n");
}
