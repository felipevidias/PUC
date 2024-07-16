// 03/02/2024   817294_Felipe_Vilhena_Dias   Guia_01

import java.util.Scanner;

public class main
{
    // Função auxiliar para obter o caractere correspondente ao dígito
    public static char getCharForDigit(int digit)
    {
        if(digit < 10)
        {
            return (char) ('0' + digit);
        }
        else
        {
            return (char) ('A' + digit - 10);
        } // end if 
    } // end getCharForDigit()

    public static String dec2base(int decimal, int base)
    {
        StringBuilder result = new StringBuilder();

        while(decimal > 0)
        {
        int remainder = decimal % base;
        result.insert(0, getCharForDigit(remainder));
        decimal /= base; // Adiciona esta linha para reduzir o valor de decimal
        } // end while

    return result.toString();
    } // end dec2base( )


    public static void main(String[] args)
    {
       Scanner sc = new Scanner(System.in);

        // Leitura do número decimal
        System.out.print("Digite um número decimal: ");
        int decimal = sc.nextInt();

        // Conversão para base 4
        String base4 = dec2base(decimal, 4);
        System.out.println("Em base 4: " + base4);

        // Conversão para base 8
        String base8 = dec2base(decimal, 8);
        System.out.println("Em base 8: " + base8);

        // Conversão para base 16
        String base16 = dec2base(decimal, 16);
        System.out.println("Em base 16: " + base16);

        sc.close();
    } // end main
} // end class