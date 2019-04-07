#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int indice = 0;
int hash_index = 0;
 
typedef struct h_tree
{
    char c;
    struct h_tree *left;
    struct h_tree *right;
}h_tree;
 
typedef struct node
{
    char sequencia[300];
}node;
 
typedef struct hash_tree
{
    node *membro[256];
}hash_tree;
 
h_tree *create_t_node(char c, h_tree* left, h_tree* right)
{
    h_tree *novo = (h_tree *) malloc(sizeof(h_tree));
    novo->c = c;
    novo->left = left;
    novo->right = right;
    indice += 1;
    return novo;
}
 
void contruct_print(h_tree *tree)
{
    if((tree) != NULL)
    {  
        contruct_print(tree->left);
        contruct_print(tree->right);
        printf("%c", tree->c);
    }
}
 
void p_con(h_tree *tree)
{
    if(tree == NULL)
    {
        return;
    }
    else
    {
        printf("------------------------------");
        printf("\nThe tree ");
        contruct_print(tree);
        printf(" has:");   
        printf("\n- Left subtree: ");
        contruct_print(tree->left);
        printf("\n- Right subtree: ");
        contruct_print(tree->right);
        puts("\n------------------------------");
       
       
        p_con(tree->left);
        p_con(tree->right);
    }
}
 
hash_tree *create_hash()
{
    hash_tree *new_hash = (hash_tree*) malloc(sizeof(hash_tree));
    int i;
    for(i = 0; i < 257; i++)
    {
        new_hash->membro[i] = NULL;
    }
    return new_hash;
}
 
void set_hash(hash_tree *ht){
    int i, j;
    for(i = 0; i < 257; i++)
    {
        for(j = 0; j < 301; j++)
        {
            ht->membro[i]->sequencia[j] = -1;
        }
    }
}
 
 
 
h_tree *montar_arvore(char *str, h_tree *tree, int tree_size, hash_tree *ht, int map) //descomprimir
{
    if(str[indice] != '*')
    {  
        //ht->membro[str[indice]]->sequencia[hash_index] = map;
        //hash_index = 0;
        return create_t_node(str[indice], NULL, NULL);
    }
    else if(tree == NULL)
    {
        tree = create_t_node(str[indice], NULL, NULL);
       
        tree->right = montar_arvore(str, tree->right, tree_size, ht, 1);
        tree->left = montar_arvore(str, tree->left, tree_size, ht, 0);
    }
    return tree;
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
    hash_tree * ht = create_hash ();
    h_tree *arv = NULL;
 
    char str [300];
    char formato[25];
    scanf ("%s",str);
    inverter (str);
    indice = 0;
    arv = montar_arvore (str, arv, 200, ht, 0);
    p_con (arv);
    printf("Decoding Tree is:\n");
    return 0;
    
}
