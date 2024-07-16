// 03/02/2024   817294_Felipe_Vilhena_Dias   Guia_01

import java.util.Locale;
import java.util.Scanner;

public class Main
{
    // Função para converter decimal para binario 
    public static String dec2bin(int decimal)
    {
        if(decimal == 0)
        {
            return "0";
        } // end if

        StringBuilder binario = new StringBuilder();

        while(decimal > 0)
        {
            int resto = decimal % 2;
            binario.insert(0,resto); // insere o resto no inicio da string
            decimal /= 2;
        } // end while

        return binario.toString();
    } // end dec2bin( )

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um numero decimal: ");
        int decimal = sc.nextInt();

        String binario = dec2bin(decimal);

        System.out.println("Binario: " + binario);
    } // end void main
} // end  class main