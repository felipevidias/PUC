CREATE DATABASE Biblioteca;

USE Biblioteca;

CREATE TABLE Livro (
    ISBN CHAR(13) PRIMARY KEY,
    Titulo VARCHAR(255) NOT NULL,
    Autor VARCHAR(255),
    Ano_Publicacao YEAR
);

CREATE TABLE Usuario (
    ID_Usuario INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(255) NOT NULL,
    Endereco VARCHAR(255),
    Telefone VARCHAR(15)
);

CREATE TABLE Emprestimo (
    ID_Emprestimo INT AUTO_INCREMENT PRIMARY KEY,
    Data_Emprestimo DATE NOT NULL,
    Data_Devolucao DATE,
    ISBN CHAR(13),
    ID_Usuario INT,
    FOREIGN KEY (ISBN) REFERENCES Livro(ISBN),
    FOREIGN KEY (ID_Usuario) REFERENCES Usuario(ID_Usuario)
);
