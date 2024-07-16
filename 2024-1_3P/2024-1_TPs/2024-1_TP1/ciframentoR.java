public class ciframentoR
{
    public static String cifra(String s, int i, int chave)
    {
        // Caso base: se o índice for igual ao comprimento da string, retorna uma string vazia
        if (i == s.length())
        {
            return "";
        }
        else
        {
            char c = s.charAt(i);
            char base = 32; // Define a base como o primeiro caractere imprimível
    
            // Verifica se o caractere é imprimível na tabela ASCII
            if (c >= 32 && c <= 126)
            {
                c = (char) ((c - base + chave) % 95 + base); // 95 é a quantidade de caracteres imprimíveis
            } // end if 
    
            // Chama recursivamente cifra para processar o próximo caractere
            return c + cifra(s, i+ 1, chave);
        } // end if
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
       cifra = cifra(s,0, 3);
       MyIO.println(cifra);
       } // end while
    } // end main
} // end ciframentoR
