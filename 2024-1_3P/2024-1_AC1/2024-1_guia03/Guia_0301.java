
public class Guia_0301
{
    public static void main(String[] args)
    {
        byte a = (byte) 0b00001010; // 10 em binário de 8 bits
        byte b = (byte) 0b00010101; // 21 em binário de 8 bits
        byte c = (byte) 0b00100101; // 37 em binário de 8 bits

        byte d = complementoDeDois(a);
        byte e = complementoDeDois(b);
        byte f = complementoDeDois(c);

        System.out.println("a = " + toBinaryString(a) + " -> C1(a) = " + toBinaryString((byte) ~a) + " -> C2(a) = " + toBinaryString(d));
        System.out.println("b = " + toBinaryString(b) + " -> C1(b) = " + toBinaryString((byte) ~b) + " -> C2(b) = " + toBinaryString(e));
        System.out.println("c = " + toBinaryString(c) + " -> C1(c) = " + toBinaryString((byte) ~c) + " -> C2(c) = " + toBinaryString(f));
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
} // end Guia_0301
