#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <time.h>


void alteracao(char *s, int i, char escolhida, char trocada)
{
    // Caso base: Se atingirmos o final da string, retornamos a string modificada
    if (s[i] == '\0')
    {
        return s;
    } // end if 

    char caractere = s[i];

    if (caractere == escolhida)
    {
        // Troca o caractere se for igual ao random1
        s[i] = trocada;
    } // end if 
    alteracao(s, i + 1, escolhida, trocada);
} // end alteracao
   

int main(void)
{
    bool control = false; 
    char s[1000];
    scanf(" %[^\r\n]%*c", s);

    while (!control)
    {
     srand(time(NULL));  // inicializa a semente do gerador de números aleatórios
     char escolhida = 'a' + rand() % 26; // gera uma letra aleatória entre 'a' e 'z'
     char trocada = 'a' + rand() % 26;  
        if (strcmp(s, "FIM") == 0)
        {
            control = true;
        } // end if 
        alteracao(s, 0, escolhida, trocada); // Realiza a alteração recursiva
        printf("%s\n", s);
        scanf ( " %[^\r\n]%*c", s);
    } // end while

    return 0;
} // end main
