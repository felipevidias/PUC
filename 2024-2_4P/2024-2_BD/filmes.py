import mysql.connector  # type: ignore
from colorama import Fore, Style, init

# Inicializa o colorama
init(autoreset=True)

# Configuração da conexão com o banco de dados
db_config = {
    'host': 'bancofilmes.database.windows.net',
    'port': '1433',
    'user': 'adm',
    'password': '!Filmes123',
    'database': 'DB_FIlmes',
    'connection_timeout': 5
}

# Conexão com o banco de dados
try:
    connection = mysql.connector.connect(**db_config)
    cursor = connection.cursor()
    print(Fore.BLUE + "DEU BAO!!!")
except mysql.connector.Error as err:
    print(Fore.RED + f"DEU RUIM: {err}")
    exit()

# Criar tabelas dos filmes
def create_table():
    cursor.execute('''CREATE TABLE IF NOT EXISTS filmes(
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      titulo VARCHAR(100) NOT NULL,
                      diretor VARCHAR(100),
                      ano INT,
                      genero VARCHAR(50))''')
    connection.commit()

# Função para criar filme novo
def create_filme():
    titulo = input("Digite o titulo: ")
    diretor = input("Digite o diretor: ")
    ano = input("Digite o ano: ")
    genero = input("Digite o genero: ")

    # Inserir filme na tabela
    cursor.execute("INSERT INTO filmes(titulo, diretor, ano, genero) VALUES(%s, %s, %s, %s)", (titulo, diretor, ano, genero))
    connection.commit()
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

    cursor.execute('''UPDATE filmes SET titulo = %s,
                      diretor = %s,
                      ano = %s,
                      genero = %s WHERE id = %s''',
                   (novo_titulo, novo_diretor, novo_ano, novo_genero, filme_id))
    connection.commit()
    print(Fore.BLUE + "Filme atualizado")

# Função para deletar o filme
def delete_filme():
    list_filme()
    filme_id = int(input("Digite o ID que deseja deletar: "))
    cursor.execute("DELETE FROM filmes WHERE id = %s", (filme_id,))
    connection.commit()
    print(Fore.RED + "Filme deletado")

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

# Executando o menu
menu()

# Fechando a conexão com o banco de dados
cursor.close()
connection.close()
