public class Guia_0304 {
    public static void main(String[] args) {
        // Definindo os dados
        byte a = (byte) 0b1111_1010; // binary
        byte b = (byte) 0b1111_101;  // binary
        byte c = (byte) 0b0001_10;   // binary
        byte d;

        // Exibindo os valores originais
        System.out.println("Guia_0304 - Tests");
        System.out.println("a = " + Integer.toBinaryString(a) + " = " + a);
        System.out.println("b = " + Integer.toBinaryString(b) + " = " + b);
        System.out.println("c = " + Integer.toBinaryString(c) + " = " + c);

        // Realizando as operações
        d = (byte) (a - b);
        System.out.println("d = a-b = " + Integer.toBinaryString(d) + " = " + d);
        d = (byte) (b - a);
        System.out.println("d = b-a = " + Integer.toBinaryString(d) + " = " + d);
        d = (byte) (a - c);
        System.out.println("d = a-c = " + Integer.toBinaryString(d) + " = " + d);
        d = (byte) (c - a);
        System.out.println("d = c-a = " + Integer.toBinaryString(d) + " = " + d);
    }
}