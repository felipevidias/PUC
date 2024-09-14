import java.io.*;
import java.time.LocalDate;

public class App {

    // Arquivo declarado fora de main() para ser poder ser usado por outros métodos
    private static Arquivo<Filme> arqFilme;

    public static void main(String[] args) {
        LocalDate lancamento1, lancamento2;
        lancamento1 = LocalDate.of(1994, 10, 14); // Data de lançamento de Pulp Fiction
        lancamento2 = LocalDate.of(2010, 7, 16); // Data de lançamento de A Origem

        // Filmes de exemplo
        Filme f1 = new Filme("Pulp Fiction", lancamento1, lancamento1, (byte) 18, (byte) 5);
        Filme f2 = new Filme("A Origem", lancamento2, lancamento2, (byte) 12, (byte) 5);
        Filme f3 = new Filme("O Poderoso Chefão", LocalDate.of(1972, 3, 24), LocalDate.of(1972, 3, 24), (byte) 18,
                (byte) 5);
        int id1, id2, id3;

        try {
            File arq = new File("dados/filmes.db");
            if (arq.exists()) {
                arq.delete();
                File hashDirectory = new File("dados/filmes.hash_d.db");
                hashDirectory.delete();
                File hashBuckets = new File("dados/filmes.hash_c.db");
                hashBuckets.delete();
            }

            arqFilme = new Arquivo<Filme>(Filme.class.getConstructor(), "filmes");

            // Insere os três filmes
            id1 = arqFilme.create(f1);
            f1.setId(id1);
            id2 = arqFilme.create(f2);
            f2.setId(id2);
            id3 = arqFilme.create(f3);
            f3.setId(id3);

            System.out.println(arqFilme.read(id3));
            System.out.println(arqFilme.read(id1));

            // Altera um filme e exibe o resultado
            f2.setTitulo("Interestelar");
            arqFilme.update(f2);
            System.out.println(arqFilme.read(id2));

            // Altera um filme para um nome diferente e exibe o resultado
            f1.setTitulo("Clube da Luta");
            arqFilme.update(f1);
            System.out.println(arqFilme.read(id1));

            // Excluir um filme e mostra que não existe mais
            arqFilme.delete(id3);
            Filme f = arqFilme.read(id3);
            if (f == null)
                System.out.println("Filme excluído");
            else
                System.out.println(f.getTitulo());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
