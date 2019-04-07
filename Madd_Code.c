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

btree* create_btree(char item, btree *left, btree *right)
{
    btree *new_binary_tree = (btree*) malloc(sizeof(btree));
    new_binary_tree->item = item;
    new_binary_tree->left = left;
    new_binary_tree->right = right;
    return new_binary_tree;
}

btree* pre_order(btree *bt, char *s)
{

    if(bt == NULL)
    {
        bt = create_btree(s,NULL,NULL);
    }else if(s < bt->item)
        {
            bt->left = pre_order(bt->left,s);
        }else if(s > bt->item)
        {
            bt->right = pre_order(bt->right,s);
        }
    
    return bt;
}

void conversao(btree *arv, char *code)
{
    int i=0,size;
    size = strlen(code);
    btree *aux = arv;
    for(i=0;i<size;i++)
    {
        while(1)
        {
            if(code[i] == '*') break;
            if(code[i] == '-')
            {
                aux = aux->left;
            }
            if(code[i] == '|')
            {
                aux = aux->right;
            }
            i++;
        }
        printf("%c",aux->item);
        aux = arv;
    }
}

int main() {
    btree *arv = create_empty_binary_tree();
    char geradora[28] = "MGTCKQWAEILORUY BDFHJNPSVXZ";
    char code[2000];
    scanf("%s",code);
    
    int i;
    
    for(i=0;i<strlen(geradora);i++) arv = pre_order(arv,geradora[i]);
    
    i=0;

    conversao(arv,code);
	return 0;
}
