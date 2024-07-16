public class Guia_0302
{
    public static void main(String[] args)
    {
        byte a = 0x0A; // hexadecimal
        byte b = 015;   // octal
        byte c = 13;    // decimal

        byte d = complementoDeDois(a);
        byte e = complementoDeDois(b);
        byte f = complementoDeDois(c);

        System.out.println("Guia_0302 - Tests");
        System.out.printf("a = %8s -> C1(a) = %8s -> C2(a) = %8s%n", toBinaryString(a), toBinaryString((byte) ~a), toBinaryString(d));
        System.out.printf("b = %7s -> C1(b) = %7s -> C2(b) = %7s%n", toBinaryString(b), toBinaryString((byte) ~b), toBinaryString(e));
        System.out.printf("c = %6s -> C1(c) = %6s -> C2(c) = %6s%n", toBinaryString(c), toBinaryString((byte) ~c), toBinaryString(f));
    } // end main

    // Método para calcular o complemento de dois
    public static byte complementoDeDois(byte num)
    {
        return (byte) (~num + 1);
    } // end complementoDeDois

    // Método para representar um byte como uma string de 8 bits
    public static String toBinaryString(byte num)
    {
        return String.format("%8s", Integer.toBinaryString(num & 0xFF)).replace(' ', '0');
    } // end toBinaryString
} // end Guia_0302
