import java.sql.*;

public class CRUDExample {

    // Credenciais do banco de dados
    static final String HOST = "testemusic.postgres.database.azure.com";
    static final int PORT = 5432;
    static final String DB_NAME = "postgres";
    static final String USERNAME = "felipe";
    static final String PASSWORD = "Empirico28";
    static final String SSL_MODE = "require";

    // URL de conexão JDBC
    static final String JDBC_URL = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DB_NAME +
                                    "?user=" + USERNAME + "&password=" + PASSWORD + "&sslmode=" + SSL_MODE;

    public static void main(String[] args) {
        try {
            // Registrar o driver JDBC
            Class.forName("org.postgresql.Driver");

            // Exemplo de CRUD
            // Criar um novo artista
            int novoArtistaId = criarArtista("Nome do Artista");

            // Criar uma nova música associada ao artista
            int novaMusicaId = criarMusica("Título da Música", novoArtistaId, "Gênero da Música", Time.valueOf("00:04:30"));

            // Ler todas as músicas de um artista
            lerMusicasPorArtista(novoArtistaId);

            // Atualizar o nome de um artista
            atualizarNomeArtista(novoArtistaId, "Novo Nome do Artista");

            // Deletar a música recém-criada
            deletarMusica(novaMusicaId);

            // Deletar o artista recém-criado
            deletarArtista(novoArtistaId);

        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC não encontrado.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados.");
            e.printStackTrace();
        }
    }

    // Métodos CRUD para artistas
    public static int criarArtista(String nome) throws SQLException {
        try (Connection connection = DriverManager.getConnection(JDBC_URL)) {
            String query = "INSERT INTO Artistas (nome) VALUES (?);";
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, nome);
            int rowsAffected = statement.executeUpdate();

            // Obter o ID do artista recém-criado
            int novoArtistaId = -1;
            if (rowsAffected > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    novoArtistaId = generatedKeys.getInt(1);
                }
            }

            return novoArtistaId;
        }
    }

    public static void deletarArtista(int artistaId) throws SQLException {
        try (Connection connection = DriverManager.getConnection(JDBC_URL)) {
            String query = "DELETE FROM Artistas WHERE artista_id = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, artistaId);
            statement.executeUpdate();
        }
    }

    public static void atualizarNomeArtista(int artistaId, String novoNome) throws SQLException {
        try (Connection connection = DriverManager.getConnection(JDBC_URL)) {
            String query = "UPDATE Artistas SET nome = ? WHERE artista_id = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, novoNome);
            statement.setInt(2, artistaId);
            statement.executeUpdate();
        }
    }

    // Métodos CRUD para músicas
    public static int criarMusica(String titulo, int artistaId, String genero, Time duracao) throws SQLException {
        try (Connection connection = DriverManager.getConnection(JDBC_URL)) {
            String query = "INSERT INTO Musicas (titulo, artista_id, genero, duracao) VALUES (?, ?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, titulo);
            statement.setInt(2, artistaId);
            statement.setString(3, genero);
            statement.setTime(4, duracao);
            int rowsAffected = statement.executeUpdate();

            // Obter o ID da música recém-criada
            int novaMusicaId = -1;
            if (rowsAffected > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    novaMusicaId = generatedKeys.getInt(1);
                }
            }

            return novaMusicaId;
        }
    }

    public static void deletarMusica(int musicaId) throws SQLException {
        try (Connection connection = DriverManager.getConnection(JDBC_URL)) {
            String query = "DELETE FROM Musicas WHERE musica_id = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, musicaId);
            statement.executeUpdate();
        }
    }

    public static void lerMusicasPorArtista(int artistaId) throws SQLException {
        try (Connection connection = DriverManager.getConnection(JDBC_URL)) {
            String query = "SELECT * FROM Musicas WHERE artista_id = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, artistaId);
            ResultSet resultSet = statement.executeQuery();

            // Processar os resultados
            while (resultSet.next()) {
                int musicaId = resultSet.getInt("musica_id");
                String titulo = resultSet.getString("titulo");
                String genero = resultSet.getString("genero");
                Time duracao = resultSet.getTime("duracao");
                System.out.println("Música ID: " + musicaId + ", Título: " + titulo + ", Gênero: " + genero + ", Duração: " + duracao);
            }
        }
    }
}
