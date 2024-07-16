// 17/02/2024   817294_Felipe_Vilhena_Dias   Guia_02

public class Main
{
    public static void main(String[] args)
    {
        double x = 0.625; // decimal
        int b = 0b10100000; // binary
        int[] q = new int[4];

        System.out.println("Guia_0204 - Tests");
        System.out.printf("x = %f\n", x);
        System.out.printf("b = 0.%8s\n", Integer.toBinaryString(b));

        String hexHigh = Integer.toHexString((b >> 4) & 0xF);
        String hexLow = Integer.toHexString(b & 0xF);
        System.out.printf("b = 0.%s%s (16)\n", hexHigh, hexLow);

        // Converting binary b to four 2-bit binary numbers in array q
        q[3] = (b >> 6) & 0b11;
        q[2] = (b >> 4) & 0b11;
        q[1] = (b >> 2) & 0b11;
        q[0] = b & 0b11;

        System.out.printf("b = 0.%2s %2s %2s %2s (2)\n", Integer.toBinaryString(q[3]), Integer.toBinaryString(q[2]), Integer.toBinaryString(q[1]), Integer.toBinaryString(q[0]));
        System.out.printf("q = 0.%2d %2d %2d %2d (4)\n", q[3], q[2], q[1], q[0]);
    } // end main 
} // end class
