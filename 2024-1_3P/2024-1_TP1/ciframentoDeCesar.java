public class ciframentoDeCesar
{
    public static String cifra(String s, int chave)
    {
        String result = "";
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (c >= 32 && c <= 126) // Verifica se o caractere é imprimível na tabela ASCII
            {                   
                char base = 32; // Define a base como o primeiro caractere imprimível
                c = (char) ((c - base + chave) % 95 + base); // 95 é a quantidade de caracteres imprimíveis
            } // end if 
            result += c; // concatena o resultado com o char 
        } // end for 
        return result;
    } // end cifra
     public static void main(String[] args)
     {
        String s;
        while(true)
        {
        s = MyIO.readLine();
        if(s.equals("FIM"))
        {
            break;
        } // end if
        String cifra;
        cifra = cifra(s, 3);
        MyIO.println(cifra);
        } // end while
     } // end main
} // end ciframentoDeCesar


