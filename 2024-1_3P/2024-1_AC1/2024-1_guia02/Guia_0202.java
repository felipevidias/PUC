// 17/02/2024   817294_Felipe_Vilhena_Dias   Guia_02

public class Main
{
    public static void main(String[] args)
    {
        double x = 0.75; // decimal
        int y = 7; // counter
        int[] b = new int[8]; // binary
        
        System.out.println("Guia_0202 - Tests");
        System.out.println("x = " + x);
        System.out.printf("b = 0.");
        for (int bit : b)
        {
            System.out.print(bit);
        }  // end for 
        System.out.println();
        
        while (x > 0 && y >= 0)
        {
            if (x * 2 >= 1)
            {
                b[y] = 1;
                x = x * 2.0 - 1.0;
            } 
            else
            {
                b[y] = 0;
                x = x * 2.0;
            } // end if
            System.out.printf("b = 0.");
            for (int bit : b)
            {
                System.out.print(bit);
            } // end for 
            System.out.println();
            y--;
        } // end while
    } // end main
} // end class
