#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

typedef struct btree btree;
struct btree{
    char item;
    btree *left;
    btree *right;
};

btree* create_empty_binary_tree()
{
    return NULL;
}

btree* create_binary_tree(char item, btree *left, btree *right)
{
    btree *new_binary_tree = (btree*) malloc(sizeof(btree));
    new_binary_tree->item = item;
    new_binary_tree->left = left;
    new_binary_tree->right = right;
    return new_binary_tree;
}

btree* pre_order(btree *bt, char *string, int *i)
{

    if(*i < 27)
    {
        bt = create_binary_tree(string[*i], NULL, NULL);
         *i += 1;
    }
    
    return bt;
}

void print(btree *bt)
{
    if(bt != NULL)
    {
        printf("%c",bt->item);
        print(bt->left);
        //print(bt->right);
    }
}

void conversao(btree *arv, char *code)
{
    int i=0,size;
    size = strlen(code);
    printf("%d  ",size);
    btree *aux = arv;
    //for(i=0;i<size;i++)
    //{
        while(1)
        {
            if(code[i] == '*') break;
            if(code[i] == '-')
            {
                aux = aux->left;
            }
            if(code[i] == '||')
            {
                aux = aux->right;
            }
            i++;
        }
        //i--;
        printf("%c",aux->item);
        aux = arv;
    //}
}

int main() {
    btree *arv = create_empty_binary_tree();
    char geradora[28] = "MGTCKQWAEILORUY BDFHJNPSVXZ";
    
    char code[2000];
    scanf("%s",code);
    
    int i=0;
    
    arv = pre_order(arv,geradora,&i);
    arv= arv->right;
    printf("%c ",arv->item);
    
   // print(arv);
   // conversao(arv,code);
	return 0;
}
