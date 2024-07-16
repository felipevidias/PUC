// 17/02/2024   817294_Felipe_Vilhena_Dias   Guia_02

public class Main
{
    public static void main(String[] args)
    {
        double x = 0.625; // decimal
        int b = 0b10100000; // binary

        System.out.println("Guia_0203 - Tests");
        System.out.printf("x = %f\n", x);
        System.out.printf("b = 0.%8s\n", Integer.toBinaryString(b));

        // Exibir em hexadecimal
        String hexHigh = Integer.toHexString((b >> 4) & 0xF);
        String hexLow = Integer.toHexString(b & 0xF);
        System.out.printf("b = 0.%s%s (16)\n", hexHigh, hexLow);

        // Exibir em octal
        String octalHigh = Integer.toOctalString((b >> 6) & 0b11);
        String octalMid = Integer.toOctalString((b >> 3) & 0b111);
        String octalLow = Integer.toOctalString(b & 0b111);
        System.out.printf("b = 0.%s%s%s (8)\n", octalHigh, octalMid, octalLow);
    } // end main
} // end class
