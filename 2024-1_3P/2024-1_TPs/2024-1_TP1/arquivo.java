import java.io.RandomAccessFile;


class arquivo
{

    public static void arquivoLer(String fileName, int n) throws Exception // joga qualquer 
                                                                           // excessao fora
    {
        RandomAccessFile arq = new RandomAccessFile(fileName, "rw"); // criar um arquivo
        double valor; int i = 0;
        while( i <  n)
        {
            valor = MyIO.readDouble();
            arq.writeDouble(valor);
            i++;
        } // end while
        
        while(n > 0)
        {
            arq.seek(8 * (n - 1));
            double numero = arq.readDouble();
            if(numero == (int) numero)
            {
                MyIO.println((int) numero); 
            }
            else
            {
                MyIO.println(numero);
            }
            n--;
        } // end while
        arq.close();
    } // end arquivoLer

    public static void main(String[] args)
    {
        int n; 
        n = MyIO.readInt();
        try{
            arquivoLer("SAIDA.TXT", n);
        }
        catch(Exception E)
        {
            System.out.println("ERROR");
        }
        
    } // end main
} // end arquivo
    