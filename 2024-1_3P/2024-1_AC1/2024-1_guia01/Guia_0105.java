// 03/02/2024   817294_Felipe_Vilhena_Dias   Guia_01

import java.util.Scanner;

public class ConversorASCII {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um caractere (letra ou dígito): ");
        char caractere = scanner.next().charAt(0);

        int valorASCII = obterValorASCII(caractere);

        System.out.println("O valor ASCII de '" + caractere + "' é: " + valorASCII);
    } // end main

    // Método para obter o valor ASCII de um caractere
    public static int obterValorASCII(char caractere)
    {
        return (int) caractere;
    } // end obterValorASCII
} // end class
