import pyodbc
from colorama import Fore, Style, init

# Dados da conexão
server = 'bancofilmes.database.windows.net'
database = 'DB_Filmes'
username = 'adm'
password = '!Filmes123'
driver = '{ODBC Driver 17 for SQL Server}'

# String de conexão
connection_string = f'DRIVER={driver};SERVER={server};DATABASE={database};UID={username};PWD={password};Encrypt=yes;TrustServerCertificate=no;Connection Timeout=30;'

# Conectando e executando uma consulta
try:
    # Conectar ao banco de dados
    conn = pyodbc.connect(connection_string)
    cursor = conn.cursor()
except pyodbc.Error as e:
    print("Erro ao conectar ao banco de dados:", e)


# Criar tabelas dos filmes
def create_table():
    # Criar a tabela se não existir
        cursor.execute('''
            IF NOT EXISTS (
                SELECT * FROM INFORMATION_SCHEMA.TABLES 
                WHERE TABLE_NAME = 'filmes'
            )
            BEGIN
                CREATE TABLE filmes (
                    id INT IDENTITY(1,1) PRIMARY KEY,
                    titulo VARCHAR(100) NOT NULL,
                    diretor VARCHAR(100),
                    ano INT,
                    genero VARCHAR(50)
                );
            END;
        ''')
        conn.commit()

# Função para criar filme novo
def create_filme():
    titulo = input("Digite o titulo: ")
    diretor = input("Digite o diretor: ")
    ano = input("Digite o ano: ")
    genero = input("Digite o genero: ")

    # Inserir filme na tabela
    # Inserir dados na tabela
    insert_query = '''
        INSERT INTO filmes (titulo, diretor, ano, genero)
        VALUES (?, ?, ?, ?);
    '''
    cursor.execute(insert_query, (titulo, diretor, ano, genero))
    conn.commit()
    print(Fore.BLUE + "DEU BAO DA SILVA JR!")

# Função para mostrar os filmes
def list_filme():
    cursor.execute("SELECT * FROM filmes")
    filmes = cursor.fetchall()
    print("\n" + Fore.GREEN + "Lista de Filmes:")
    for filme in filmes:
        print(f"ID: {filme[0]}\nTitulo: {filme[1]}\nDiretor: {filme[2]}\nAno: {filme[3]}\nGenero: {filme[4]}\n")

# Função para atualizar o filme
def atualizar_filme():
    list_filme()
    filme_id = int(input("Digite o ID que deseja atualizar: "))
    novo_titulo = input("Novo Titulo: ")
    novo_diretor = input("Novo Diretor: ")
    novo_ano = input("Novo Ano: ")
    novo_genero = input("Novo Genero:")

    # Construir a consulta de atualização dinamicamente
    update_fields = []
    params = []

    if novo_titulo:
        update_fields.append("titulo = ?")
        params.append(novo_titulo)
    if novo_diretor:
        update_fields.append("diretor = ?")
        params.append(novo_diretor)
    if novo_ano:
        update_fields.append("ano = ?")
        params.append(novo_ano)
    if novo_genero:
        update_fields.append("genero = ?")
        params.append(novo_genero)

    # Verificar se há campos a atualizar
    if not update_fields:
        print("Nenhum campo fornecido para atualizar.")
        return

    # Adicionar o ID aos parâmetros e construir a consulta final
    params.append(filme_id)
    update_query = f"UPDATE filmes SET {', '.join(update_fields)} WHERE id = ?"

    # Executar a atualização
    cursor.execute(update_query, params)
    conn.commit()

    print(Fore.BLUE + "Filme atualizado")

# Função para deletar o filme
def delete_filme():
    list_filme()
    filme_id = int(input("Digite o ID que deseja deletar: "))
    # Consulta de exclusão
    delete_query = "DELETE FROM filmes WHERE id = ?"
    cursor.execute(delete_query, (filme_id,))
    conn.commit()

    print(f"Filme com ID {id} deletado com sucesso.")

# Menu principal
def menu():
    create_table()
    while True:
        print(Fore.YELLOW + "\n----FILMES-DO-ILO----")
        print("1. Adicionar Filme")
        print("2. Listar Filme")
        print("3. Atualizar Filme")
        print("4. Deletar Filme")
        print("5. Sair")

        opcao = input("Digite uma Opcao: ")

        if opcao == '1':
            create_filme()
        elif opcao == '2':
            list_filme()
        elif opcao == '3':
            atualizar_filme()
        elif opcao == '4':
            delete_filme()
        elif opcao == '5':
            print(Fore.CYAN + "MIM DE BIS ILO")
            break
        else:
            print(Fore.RED + "Opcao Invalida")

try:
    # Executando o menu
    menu()

    # Fechando a conexão com o banco de dados
    cursor.close()
    conn.close()
except pyodbc.Error as e:
    print("Erro a mexer no BD:", e)

