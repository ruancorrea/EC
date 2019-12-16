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

int i=0;
int maior=-99;
int menor=9999;
binary_tree* add(binary_tree *bt, char *string)
{
    char *v = (char*) malloc(10*sizeof(char));
    int t=0,b;
    if(string[i]==')'){
        i++;
        bt = add(bt,string);
    }
    if(string[i]== '('){
        if(string[i]== '(' && string[i+1]==')'){
            i+=2;
            return NULL;
        }
        else{
            i++;
        bt= add(bt,string);
        bt->left = add(bt->left,string);
        bt->right = add(bt->right,string);
        }
    }
    
    else if(string[i]!='(' && string[i]!=')')
    {
        //printf("%d ",i);
        while(string[i] != '(' && string[i] != ')'){
            v[t]=string[i];
            t++;
            i++;
        }
        b = atoi(v);
        if(b>maior){
            maior=b;
        }
        if(b<menor){
            menor=b;
        }
        //printf("%d b\n",b);
        free(v);
        bt = create_binary_tree(b,NULL,NULL);
    }
    return bt;
}
  
int pesquisa(binary_tree *bt, int m, int M)  
{  
    if (bt==NULL){
        return 1;
    }
    if(bt->item < m || bt->item > M){
        return 0;
    }
    return pesquisa(bt->left, m, bt->item-1) && pesquisa(bt->right, bt->item+1, M); 
}  

void print_pre_order(binary_tree *bt){
    if(bt!=NULL){
        printf("%d ",bt->item);
        print_pre_order(bt->left);
        print_pre_order(bt->right);
    }
}

int main() 
{
    binary_tree *arv = create_empty_binary_tree();
    char string[10000];
    gets(string);
    arv = add(arv,string);
    //print_pre_order(arv);
    if(pesquisa(arv,menor,maior)){
        printf("VERDADEIRO"); 
    }else printf("FALSO"); 
	return 0;
}
