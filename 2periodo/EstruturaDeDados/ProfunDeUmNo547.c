#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
typedef struct binary_tree binary_tree;

struct binary_tree {
    int item;
    binary_tree *left;
    binary_tree *right;
};

binary_tree* create_empty_binary_tree()
{
    return NULL;
}

binary_tree* create_binary_tree(int item, binary_tree *left, binary_tree *right)
{
    binary_tree *new_binary_tree = (binary_tree*) malloc(sizeof(binary_tree));
    new_binary_tree->item = item;
    new_binary_tree->left = left;
    new_binary_tree->right = right;
    return new_binary_tree;
}

binary_tree* add(binary_tree *bt, int item)
{
    if (bt == NULL) {
        bt = create_binary_tree(item, NULL, NULL);
    }
    else if (bt->item > item) {
        bt->left = add(bt->left, item);
        } else if (bt->item < item){
            bt->right = add(bt->right, item);
            }
    return bt;
}

int print_pre_order(binary_tree *bt,int i,int item, int j,int x)
{
    if (bt!=NULL) {
        i++;
        if(bt->item==item){
            //printf("ESTA NA ARVORE\n%d",i-1);
            return i-1;
        }
        if(bt->left!=NULL){
            x=print_pre_order(bt->left,i,item,j,x);
        }
        if(bt->right!=NULL){
            x=print_pre_order(bt->right,i,item,j,x);
        }
        return x;
    }
}

int main() 
{
    binary_tree *arv= create_empty_binary_tree();
    char string[1000];
    char *vector = (char*) malloc(999999*sizeof(char));
    int n,i,t=0,tam=0,b,k,x;
    int a[1000];
    scanf("%s\n",string);
    for(i=0;i<strlen(string);i++)
    {
        if(string[i] != '(' && string[i] != ')')
        {
            while(string[i] != '(' && string[i] != ')')
            {
                vector[t]=string[i];
                t++;
                i++;
            }
            b=atoi(vector);
            free(vector);
            vector = (char*) malloc(1000*sizeof(char));
            t=0;
            a[tam]=b;
            tam++;
        }
    }
    scanf("%d",&n);
    for(i=0;i<tam;i++){
        arv = add(arv,a[i]);
        //printf("%d ",a[i]);
    }
    x=print_pre_order(arv,0,n,a[tam-1],0);
    //printf("%d",x);
    if(x!=0)
    {
        printf("ESTA NA ARVORE\n%d\n",x);
    }
    else if(x==0 && arv->item==n)
    {
        printf("ESTA NA ARVORE\n0\n");
        
    }
    else
    {
        printf("NAO ESTA NA ARVORE\n-1\n");
    }
    free(vector);
	return 0;
}
