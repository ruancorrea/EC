#include <stdio.h>

void verificar_candidatos(int *tabuleiro, int col,  int *c, int *n)
{
	int linha_candidata, conflito, col_ant, d;
	*n = 0;
	for (linha_candidata=1; linha_candidata <=8 ; ++linha_candidata)
	{
		conflito = 0;
		for (col_ant=1; col_ant < col && !conflito; col_ant++)
		{
			d = col - col_ant;

			if (linha_candidata == tabuleiro[col_ant] || 
				tabuleiro[col_ant] == (linha_candidata + d) || 
				tabuleiro[col_ant] == (linha_candidata - d))
			{
				conflito = 1;
			}
		}
		if (!conflito)
		{
			c[*n] = linha_candidata;
			(*n) ++;
		}
	}
}

void rainhas(int *tabuleiro, int col)
{
	int j;
	int candidatos[8];
	int n_candidatos, i;

	if (col == 9)
	{
		for (j=1; j<9; ++j)
		{
			printf("%d ", tabuleiro[j]);
		}
		printf("\n");
		return;
	}
	
	verificar_candidatos(tabuleiro, col, candidatos,  &n_candidatos);
	for (i = 0; i < n_candidatos; i++)
	{
		tabuleiro[col] = candidatos[i];
		rainhas(tabuleiro, col +1);
	}
}

int main()
{
	int t[9];
	rainhas(t, 1);
	return 0;
}
