// 17/02/2024   817294_Felipe_Vilhena_Dias   Guia_02

public class Main 
{
    public static void main(String[] args)
    {
        double x = 0; // decimal
        double power2 = 1.0; // power of 2
        int y = 7; // counter
        int[] b = {1, 0, 1, 0, 0, 0, 0, 0}; // binary (only fraction part, Big Endian)
        
        System.out.println("Guia_0201 - Tests");
        System.out.println("x = " + x);
        System.out.printf("b = 0.");
        for (int bit : b)
        {
            System.out.print(bit);
        } // end for 
        System.out.println();
        
        while (y >= 0)
        {
            power2 /= 2.0;
            if (b[y] == 1)
            {
                x += power2;
            } // end if 
            System.out.println("x = " + x);
            y--;
        }  // end while 
    } // end main
} // end class 
