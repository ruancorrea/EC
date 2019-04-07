#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
typedef unsigned char byte;
typedef struct btree btree;
typedef struct node node;
typedef struct hash_table hash;

int hash_index = 0;
 
struct btree
{
    char c;
    struct btree *left;
    struct bbtree *right;
};
 
struct node
{
    char sequencia[300];
};
 
struct hash_table
{
    node *membro[256];
};
 
btree *create_t_node(char c, btree* left, btree* right, int *indice)
{
    btree *novo = (btree *) malloc(sizeof(btree));
    novo->c = c;
    novo->left = left;
    novo->right = right;
    *indice += 1;
    return novo;
}
 
void contruct_print(btree *bt)
{
    if(bt != NULL)
    {  
        contruct_print(bt->left);
        contruct_print(bt->right);
        printf("%c", bt->c);
    }
}
 
void p_con(btree *bt)
{
    if(bt == NULL)
    {
        return;
    }
    else
    {
        printf("------------------------------");
        printf("\nThe tree ");
        contruct_print(bt);
        printf(" has:");   
        printf("\n- Left subtree: ");
        contruct_print(bt->left);
        printf("\n- Right subtree: ");
        contruct_print(bt->right);
        puts("\n------------------------------");
       
       
        p_con(bt->left);
        p_con(bt->right);
    }
}
 
hash *create_hash()
{
    hash *new_hash = (hash*) malloc(sizeof(hash));
    int i;
    for(i = 0; i < 257; i++)
    {
        new_hash->membro[i] = NULL;
    }
    return new_hash;
}
 
void set_hash(hash *ht){
    int i, j;
    for(i = 0; i < 257; i++)
    {
        for(j = 0; j < 301; j++)
        {
            ht->membro[i]->sequencia[j] = -1;
        }
    }
}
 
 
 
btree *montar_arvore(char *str, btree *bt, int tree_size, hash *ht, int map, int *indice) //descomprimir
{
    if(str[*indice] != '*')
    {  
        return create_t_node(str[*indice], NULL, NULL,indice);
    }
    else if(bt == NULL)
    {
        bt = create_t_node(str[*indice], NULL, NULL,indice);
       
        bt->right = montar_arvore(str, bt->right, tree_size, ht, 1,indice);
        bt->left = montar_arvore(str, bt->left, tree_size, ht, 0, indice);
    }
    return bt;
}
 
 
void inverter(char *buffer)
{
    int i;
    int size = strlen(buffer);
    for(i = 0; i < size / 2; i++)
    {
       char tmp = buffer[i]; //armazena o character inicial
       buffer[i] = buffer[size - i - 1]; //Troca o character da ponta oposta
       buffer[size - i - 1] = tmp; //Armazena o character inicial no buffer
    }
}
 
int main () {
    hash *ht = create_hash ();
    btree *arv = NULL;
 
    char str [300];
    char formato[25];
    scanf ("%s",str);
    inverter (str);
    int indice = 0;
    arv = montar_arvore (str, arv, 200, ht, 0,&indice);
    p_con (arv);
    printf("Decoding Tree is:\n");
    return 0;
    
}
