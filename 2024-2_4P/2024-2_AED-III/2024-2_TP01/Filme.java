import java.time.LocalDate;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

/* Used to store recorded Movies from the Arquivo database
 * Contains:
 *   id: Attribute given only by Arquivo to indicate its position
 *   titulo: Title of the movie
 */
public class Filme implements Registro {
    private int id;

    // Atributos da classe Filme
    private String titulo;
    private LocalDate lancamento;
    private LocalDate duracao;
    private Byte classificacao;
    private Byte avaliacao;

    // Métodos Set's
    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setLancamento(LocalDate lancamento) {
        this.lancamento = lancamento;
    }

    public void setDuracao(LocalDate duracao) {
        this.duracao = duracao;
    }

    public void setClassificacao(Byte classificacao) {
        this.classificacao = classificacao;
    }

    public void setAvaliacao(Byte avaliacao) {
        this.avaliacao = avaliacao;
    }
    // Fim Métodos Set's

    // Métodos Get's
    public int getId() {
        return this.id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public LocalDate getLancamento() {
        return this.lancamento;
    }

    public LocalDate getDuracao() {
        return this.duracao;
    }

    public Byte getClassificacao() {
        return this.classificacao;
    }

    public Byte getAvaliacao() {
        return this.avaliacao;
    }
    // Fim Métodos Get's

    // Método toByteArray
    public byte[] toByteArray() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        try {
            dos.writeInt(this.id);
            dos.writeUTF(this.titulo);
            dos.writeInt((int) this.lancamento.toEpochDay());
            dos.writeInt((int) this.duracao.toEpochDay());
            dos.writeByte(this.classificacao);
            dos.writeByte(this.avaliacao);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return baos.toByteArray();
    }

    // Método fromByteArray
    public void fromByteArray(byte[] array) {
        ByteArrayInputStream bais = new ByteArrayInputStream(array);
        DataInputStream dis = new DataInputStream(bais);
        try {
            this.id = dis.readInt();
            this.titulo = dis.readUTF();
            this.lancamento = LocalDate.ofEpochDay(dis.readInt());
            this.duracao = LocalDate.ofEpochDay(dis.readInt());
            this.classificacao = dis.readByte();
            this.avaliacao = dis.readByte();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Construtores
    public Filme(String titulo, LocalDate lancamento, LocalDate duracao, byte classificacao, byte avaliacao) {
        this.titulo = titulo;
        this.lancamento = lancamento;
        this.duracao = duracao;
        this.classificacao = classificacao;
        this.avaliacao = avaliacao;
    }

    public Filme() {
        this.id = -1;
        this.lancamento = null;
        this.duracao = null;
        this.classificacao = -1;
        this.avaliacao = -1;
    }
    // Fim Construtores

    @Override
    public String toString() {
        return getEntity();
    }

    // Método toString
    private String getEntityAsLines() {
        String s = "";
        s += Integer.toString(this.id);
        s += "\n";
        s += this.titulo;
        s += "\n";
        s += this.lancamento;
        s += "\n";
        s += this.duracao;
        s += "\n";
        s += Byte.toString(this.classificacao);
        s += "\n";
        s += Byte.toString(this.avaliacao);
        s += "\n";
        return s;
    }

    private String getEntity() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(Integer.toString(this.id)).append("\n");
        sb.append("titulo: ").append(titulo).append("\n");
        sb.append("lancamento: ").append(lancamento).append("\n");
        sb.append("duracao: ").append(duracao).append("\n");
        sb.append("classificacao: ").append(classificacao).append("\n");
        sb.append("avaliacao: ").append(avaliacao).append("\n");
        return sb.toString();
    }

}
