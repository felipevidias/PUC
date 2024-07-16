#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

bool palindromo(char* s)
{
    int length = strlen(s);

    for(int i = 0; i < length; i++)
    {
        int j = length - 1 - i;
        if(s[i] != s[j])
        {
            return false; // nao é palindromo
        } // end if 
    } // end for
    return true; // é palindromo  
} // end palindromo 

int main(void)
{
    // definir dados 
    char s[1000];
    // obter dados e aplicar função auxiliar
     while(true)
    {
        scanf (" %[^\n]", s); 
        
        if(strcmp(s, "FIM") == 0)
        {
            break; // Saindo do loop se a entrada for "FIM"
        } // end if 

        // Limpar o buffer de entrada
        while (getchar() != '\n');

        // Verificando se a entrada é um palíndromo
        bool result = palindromo(s);
        
        // Imprimindo resultado
        if(result)
        {
            printf("SIM\n");
        }
        else
        {
            printf("NAO\n");
        } // end if 
    } // end while
    
    return 0;
} // end main