#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
typedef unsigned char byte;
typedef struct btree btree;
typedef struct node node;
typedef struct hash_table hash;

//int hash_index = 0;
 
struct btree
{
    char c;
    struct btree *left;
    struct btree *right;
};
 
struct node
{
    char seq[300];
};
 
struct hash_table
{
    node *table[256];
};

hash* create_dictionary()
{
    hash *new_hash = (hash*) malloc(sizeof(hash));
    int i;
    for (i = 0; i < 256; i++) new_hash->table[i] = NULL;//MUDAR OS NOMES MEMBRO E SEQUENCIA
    return new_hash;
}

void put_string_in_hash(hash *ht, char index, char *binary)
{
    node *new_element = (node*) malloc(sizeof(node));
    strcpy(new_element->seq, binary);
    ht->table[index] = new_element;
}

void print_dictionary(hash *ht)
{
    int i;
    for(i=0;i <= 255;i++)
    {
        if(ht->table[i] != NULL) printf("%c : %s\n",i,ht->table[i]->seq);
    }
}

char* add_left(char *binary, long long int *i)
{
    binary[*i] = '0';
    *i += 1;
    return binary;
}

char* add_right(char *binary, long long int *i)
{
    binary[*i] = '1';
    *i += 1;
    return binary;
}

void dicionario(hash *ht, btree *huff, char *binary, long int *i)
{
    if(huff != NULL)
    {
        if(huff->left == NULL && huff->right == NULL)
        {
            put_string_in_hash(ht, huff->c, binary);
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
 
btree *create_btree(char c, btree* left, btree* right, int *indice)
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
 
void con(btree *bt)
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
       
        con(bt->left);
        con(bt->right);
    }
}
 
btree *montagem(char *string, btree *bt, int tree_size, hash *ht, int map, int *indice) //descomprimir
{
    if(string[*indice] != '*')
    {  
        return create_btree(string[*indice], NULL, NULL,indice);
    }
    else if(bt == NULL)
    {
        bt = create_btree(string[*indice], NULL, NULL,indice);
       
        bt->right = montagem(string, bt->right, tree_size, ht, 1,indice);
        bt->left = montagem(string, bt->left, tree_size, ht, 0, indice);
    }
    return bt;
}
 
int main () {
    hash *ht = create_dictionary ();
    btree *arv = NULL;
 
    char entrada[400];
    scanf ("%s",entrada);
    char string[400];
    int j=0,k;
    
    for(k=strlen(entrada) - 1; k>=0; k--)
    {
        string[j] = entrada[k];
        j++;
    }
    
    long int i=0;
    arv = montagem (string, arv, 200, ht, 0,&i);
    btree *aux = arv;
    con (aux);
    printf("Decoding Tree is:\n");
    char binario[40] = {0};
    i=0;
    dicionario(ht, arv, binario, &i);
    print_dictionary(ht);
    return 0;
}
