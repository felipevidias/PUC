#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

void arquivoLer(char* fileName,int n)
{
    FILE* entrada = fopen(fileName,"wt");
    double valor;
    while (n > 0)
    {
        scanf("%lf", &valor);
        fprintf(entrada,"%.14g\n", valor);
        n--;
    } // end while
    fclose(entrada);
} // end arquivoEscrever

void arquivoEscrever(char* fileName,int n)
{
    FILE* saida = fopen(fileName,"rt");
    double valores[n];
    double valor;
    int i = 0;
   while (i < n && fscanf(saida, "%lf", &valor) == 1)
   {
        valores[i] = valor;
        i++;
   } // end while

    for(int i = n - 1; i >= 0; i = i - 1)
    {
        printf("%.14g\n", valores[i]); // limita até 14 casas decimais, e poe so o necessario   
    } // end for                       // sem casas decimais extras
    fclose(saida);
} // end arquivoLer

int main(void)
{
    int n; 
    scanf("%d", &n);
    arquivoLer("ENTRADA.TXT", n);
    arquivoEscrever("ENTRADA.TXT",n);
    return 0;
} // end main 