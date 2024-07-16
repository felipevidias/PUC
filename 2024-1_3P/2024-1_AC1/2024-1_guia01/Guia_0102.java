// 03/02/2024   817294_Felipe_Vilhena_Dias   Guia_01

import java.util.Locale;
import java.util.Scanner;

public class Main
{
    // Funcão para transformar binario para decimal
    public static int bin2dec(String binario)
    {
        int pos = binario.length();
        int total = 0;

        if(binario.equals("0"))
        {
            return 0;
        }
        else if(binario.equals("1"))
        {
            return 1;
        } // end if

       for (int i = pos - 1; i >= 0; i--)
       {
        total += ((int) binario.charAt(i) - '0') * Math.pow(2, pos - 1 - i);
       } // end for 


        return total;
    } // end bin2dec()

    public static void main(String[] args )
    {
        Scanner sc = new Scanner(System.in);
        String binario;
        int decimal;
        System.out.print("Digite um numero binario: ");
        binario = sc.nextLine();

        // chamar função auxiliar
        decimal = bin2dec(binario);

        System.out.println("Decimal: " + decimal);

        sc.close();
    } // end main 
} // end class


