#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

#ifndef _TRYCATCH_H_
#define _TRYCATCH_H_
#include <setjmp.h>

#define try       jmp_buf jmp; switch(setjmp(jmp)){case 0:
#define catch(e)   break;case e:
#define throw(e)   longjmp(jmp,e)
#endif

//#include "trycatch.h"

#define EXCECAO  1001


struct informacoes
{
    float velocidade; // m/s
    float aceleracao; // m/s
    float angulo;
};

float transformando(float ang)
{
    return (ang * M_PI)/180;
}

float alcance (float rad, float v, float a)
{
    float cosseno=cos(rad);
    float seno = sin(rad);
    return (2*pow(v,2)*(cosseno*seno)/a);
}

float alturaMAX(float rad, float v, float a)
{
    float seno = sin(rad);
    return (pow(v,2)*(pow(seno,2)))/(2*a);

}

float tempo(float rad, float v, float a)
{
    float seno = sin(rad);
    return (2*v*seno)/a;
}

float verificando()
{
    float x;
    while(1)
    {
        scanf("%f",&x);
        if(x>=0) break;
    }
    /*bool valido = true;
    float v;
    while(valido)
    {
        try {
          scanf("%f", &v);
          valido = false;
          if(v < 0)
          {
            printf("Insira um numero maior que zero!");
            valido = true;
          }
          printf("Disparando exceção\n");
          throw(EXCECAO);
          printf("Essa linha nao será executada");
       }
       catch(EXCECAO) {
          printf("Exceção tratada\n");
       }
    }*/

    return x;
}

void Lancamento()
{
    int x;
    printf("Seja bem-vindo!\n");
    while(1)
    {
        printf("\nInsira a velocidade do lancamento! (em m/s)\n");
        float vel = verificando();
        printf("Insira a aceleracao do lancamento! (em m/s²)\n");
        float ace = verificando();
        printf("Insira o angulo (em graus)!\n");
        float ang = verificando();
        float rad = transformando(ang);
        printf("Velocidade: %.2f m/s\nAceleracao: %.2f m/s\nAngulo: %.2f°\nrad: %.2f\n\n", vel, ace, ang, rad);
        float x = alcance(rad, vel, ace);
        float y = alturaMAX(rad, vel, ace);
        printf("X = %.15f\nY = %.15f\nTempo de voo: %.15f\n\n",x,y,tempo(rad,vel,ace));

        printf("| Deseja testar novamente o programa? |\n");
        printf("| 0 - Nao                             |\n");
        printf("| 1 - Sim                             |\n\n");
        scanf("%d",&x);
        if(x==0) break;

    }

}

void main()
{
    Lancamento();
}
