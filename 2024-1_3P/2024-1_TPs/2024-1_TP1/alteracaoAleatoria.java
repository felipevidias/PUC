
import java.util.Random;

public class alteracaoAleatoria
{
    public static String alteracao(String s,char escolhida,char trocada)
    {
        String result = "";
        for(int i = 0; i < s.length(); i = i + 1)
        {
            if(escolhida == s.charAt(i))
            {
                result += trocada; 
            }
            else
            {
                result += s.charAt(i);
            } // end if 
        } // end for 
        return result;
    } // end alteracao

    public static void main(String[] args)
        {
            String s;
            Random gerador = new Random();
            gerador.setSeed(4);
            
            while(true)
            {
            s = MyIO.readLine();
            if(s.equals("FIM"))
            {
                break;
            } // end if 
            char escolhida = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));
            char trocada = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));
            String alteracao = alteracao(s,escolhida,trocada);
            MyIO.println(alteracao);
            }
        } // end main
} // end alteracaoAleatoria 