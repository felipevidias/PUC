public class Guia_0303
{
    public static void main(String[] args)
    {
        byte a = (byte) 0b11111010; // binary
        byte b = (byte) 0b1111101 ; // binary
        byte c = (byte) 0b111110 ; // binary

        byte d;
        int e;

        d = complementoDeDois(a);
        e = complementoMenosUm(a);
        System.out.printf("a = %8s -> C1(a) = %8s -> C2(a) = %8s = %d = %d%n", toBinaryString(a), toBinaryString((byte) ~a), toBinaryString(d), d, e);

        d = complementoDeDois(b);
        e = complementoMenosUm(b);
        System.out.printf("b = %7s -> C1(b) = %7s -> C2(b) = %7s = %d = %d%n", toBinaryString(b), toBinaryString((byte) ~b), toBinaryString(d), d, e);

        d = complementoDeDois(c);
        e = complementoMenosUm(c);
        System.out.printf("c = %6s -> C1(c) = %6s -> C2(c) = %6s = %d = %d%n", toBinaryString(c), toBinaryString((byte) ~c), toBinaryString(d), d, e);
    } // end main

    // Método para calcular o complemento de dois
    public static byte complementoDeDois(byte num)
    {
        return (byte) (~num + 1);
    } // end complementoDeDois

    // Método para calcular o complemento menos um
    public static int complementoMenosUm(byte num)
    {
        return -(num - 1);
    } // end complementoMenosUm

    // Método para representar um byte como uma string de 8 bits
    public static String toBinaryString(byte num)
    {
        return String.format("%8s", Integer.toBinaryString(num & 0xFF)).replace(' ', '0');
    } // end toBinaryString
} // end Guia_0304
