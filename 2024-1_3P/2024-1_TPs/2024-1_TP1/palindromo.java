
public class palindromo
{
    public static boolean palin(String s)
    {
        int length = s.length();
        for(int i = 0; i < length / 2; i++)
        {
            if(s.charAt(i) != s.charAt(length - i - 1))
            {
                return false; // não é palíndromo
            } // end if
        } // end for
        return true; // é palindromo 
    } // end palindromo( )


    public static void main(String[] args)
    {
        String s; boolean result; 
        while(true)
        {
        // definir dados 
        s = MyIO.readLine();

        if(s.equals("FIM"))
        {
            break;
        } // end if

        // aplicar funções auxiliares
        result = palin(s);

        if(result == true)
        {
            MyIO.println("SIM");
        }
        else
        {
            MyIO.println("NAO");
        } // end if 
        } // 
    } // end main( )
} // end class