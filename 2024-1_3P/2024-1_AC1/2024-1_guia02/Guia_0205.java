// 17/02/2024   817294_Felipe_Vilhena_Dias   Guia_02

public class Guia_0205 {
    public static void main(String[] args) {
        byte a = (byte) Integer.parseInt("0001010", 2);
        byte b = (byte) Integer.parseInt("0001100", 2);
        byte c;

        System.out.println("Guia_0205 - Tests");
        System.out.printf("a = %8s%n", Integer.toBinaryString(a & 0xFF));
        System.out.printf("b = %8s%n", Integer.toBinaryString(b & 0xFF));

        // Addition
        c = (byte) (a + b);
        System.out.printf("c = a+b = %8s%n", Integer.toBinaryString(c & 0xFF));

        // Subtraction
        c = (byte) (a - b);
        System.out.printf("c = a-b = %8s%n", Integer.toBinaryString(c & 0xFF));

        // Subtraction (b - a)
        c = (byte) (b - a);
        System.out.printf("c = b-a = %8s%n", Integer.toBinaryString(c & 0xFF));

        // Multiplication
        c = (byte) (a * b);
        System.out.printf("c = a*b = %8s%n", Integer.toBinaryString(c & 0xFF));

        // Division
        c = (byte) (b / a);
        System.out.printf("c = b/a = %8s%n", Integer.toBinaryString(c & 0xFF));

        // Modulo
        c = (byte) (b % a);
        System.out.printf("c = b%%a = %8s%n", Integer.toBinaryString(c & 0xFF));
    }
}