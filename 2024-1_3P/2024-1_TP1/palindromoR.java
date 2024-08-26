public class palindromoR
{
    public static boolean palindromo(String s, int i )
    {
        int length = s.length();
        if(i >= length) // se chegar até metade da string sem diferenças é palindromo
        {
            return true; 
        } // end if 
        int j = length - 1 - i;
        if(s.charAt(i) != s.charAt(j))
        {
            return false;
        } // end if
        return palindromo(s, i + 1);
    } // end palindromo

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
        result = palindromo(s,0);

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
} // end palindromoR
