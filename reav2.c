#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

typedef struct btree btree;
typedef struct node node;
typedef struct hash_table hash;
 
struct btree
{
    char item;
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
    for (i = 0; i < 256; i++) new_hash->table[i] = NULL;
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
    for(i=0;i <= 255;i++) if(ht->table[i] != NULL) printf("%c : %s\n",i,ht->table[i]->seq);
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
            put_string_in_hash(ht, huff->item, binary);
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
 
btree *create_btree(char item, btree* left, btree* right, int *indice)
{
    btree *new_btree = (btree *) malloc(sizeof(btree));
    new_btree->item = item;
    new_btree->left = left;
    new_btree->right = right;
    *indice += 1;
    return new_btree;
}
 
void print_pos_order(btree *bt)
{
    if(bt != NULL)
    {  
        print_pos_order(bt->left);
        print_pos_order(bt->right);
        printf("%c", bt->item);
    }
}
 
void print(btree *bt)
{
    if(bt == NULL)
    {
        return;
    }
    else
    {
        printf("------------------------------\nThe tree ");
        print_pos_order(bt);
        printf(" has:\n- Left subtree: ");   
        print_pos_order(bt->left);
        printf("\n- Right subtree: ");
        print_pos_order(bt->right);
        puts("\n------------------------------");
       
        print(bt->left);
        print(bt->right);
    }
}
 
btree *montagem(char *string, btree *bt, int *indice) //descomprimir
{
    if(string[*indice] != '*')
    {  
        return create_btree(string[*indice], NULL, NULL,indice);
    }
    else if(bt == NULL)
    {
        bt = create_btree(string[*indice], NULL, NULL,indice);
       
        bt->right = montagem(string, bt->right,indice);
        bt->left = montagem(string, bt->left, indice);
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
    
    for(k=strlen(entrada) - 1; k>=0; k--, j++) string[j] = entrada[k];
    
    long int i=0;
    arv = montagem (string, arv,&i);
    btree *aux = arv;
    print(aux);
    printf("Decoding Tree is:\n");
    char binario[40] = {0};
    i=0;
    dicionario(ht, arv, binario, &i);
    print_dictionary(ht);
    return 0;
}
