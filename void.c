#include <stdio.h>

void main( )
{
    int x = 5;
    void *y = (void *) &x;
    int *z;

    z = (int *) y;
    printf("%d \n\n",*z);//printa 5
    *z = 9;
    printf("%d \n\n",*z);//printa 9
}
