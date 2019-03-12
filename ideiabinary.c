#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <stdbool.h>

/*char palindromo(char *cod, int tam)
{
    char aux[tam],j=0;

    for(i=tam-1;i>=0;i--)
    {
        aux[j] = cod[i];
        j++;
    }

    return aux;
}*/

char add_l(char *cod, int *i)
{
    cod[*i] = '0';
    *i+=1;

    return cod;
}

char add_r(char *cod, int *i)
{
    cod[*i] = '1';
    *i+=1;

    return cod;
}

void codigo(bt *arv, char *cod, int *i)
{
    if(arv->left == NULL && arv->right == NULL)
    {
        hash = (arv->c, cod);
        *i -= 1;
    }

    codigo(arv->left, add_l(cod,i), i);
    codigo(arv->right, add_r(cod,i), i);

    *i -=1 ;
}

int main()
{
    int i=0;

    bt *huf = blabla(huf);//ondestamos

    char cod[100]; // sla quanto

    cod[0] = 0;

    codigo(huf, cod, &i);
}

//https://hastebin.com/hasodaxutu.cpp
