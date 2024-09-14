import java.io.RandomAccessFile;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Livro l1 = new Livro(1, "Eu, Robô", "Isaac Asimov", 14.90F);
        Livro l2 = new Livro(2, "Eu Sou a Lenda", "Richard Matheson", 21.99F);

        RandomAccessFile arq;
        byte[] ba;

        try {

            // ESCRITA
            arq = new RandomAccessFile("livros.db", "rw"); // read , write

            long pos1 = arq.getFilePointer(); // pegar a posição do ponteiro no arquivo
            ba = l1.toByteArray(); // transforma informação em vetor de byte
            arq.writeInt(ba.length); // mostra o tamanho de bytes que tera na escrita
            arq.write(ba); // escreve o vetor de bytes

            long pos2 = arq.getFilePointer();
            ba = l2.toByteArray();
            arq.writeInt(ba.length);
            arq.write(ba);

            // LEITURA
            Livro l3 = new Livro();
            Livro l4 = new Livro();
            int tam;

            arq.seek(pos2); // procura pela posição no arquivo
            tam = arq.readInt();
            ba = new byte[tam]; // pega o tamanho de bytes que terá na leitura
            arq.read(ba);
            l3.fromByteArray(ba); // le do vetor de bytes

            arq.seek(pos1);
            tam = arq.readInt();
            ba = new byte[tam];
            arq.read(ba);
            l4.fromByteArray(ba);

            System.out.println(l3);
            System.out.println(l4);

            arq.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
