-- Criação do banco de dados
CREATE DATABASE Hospital;
USE Hospital;

-- Criação da tabela Médicos
CREATE TABLE Medicos (
    idMedico INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    especialidade VARCHAR(100),
    numeroAmbulatorio INT
);

-- Inserção de 3 médicos
INSERT INTO Medicos (nome, especialidade, numeroAmbulatorio)
VALUES ('Dr. João', 'Cardiologia', 1),
       ('Dra. Maria', 'Pediatria', 2),
       ('Dr. Carlos', 'Ortopedia', 3);

-- Criação da tabela Ambulatorios
CREATE TABLE Ambulatorios (
    numeroA INT PRIMARY KEY,
    nome VARCHAR(100)
);

-- Inserção de 4 ambulatórios
INSERT INTO Ambulatorios (numeroA, nome)
VALUES (1, 'Ambulatório 1'),
       (2, 'Ambulatório 2'),
       (3, 'Ambulatório 3'),
       (4, 'Ambulatório 4');

-- Criação da tabela Pacientes
CREATE TABLE Pacientes (
    idPaciente INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    idade INT
);

-- Inserção de 2 pacientes
INSERT INTO Pacientes (nome, idade)
VALUES ('Ana Souza', 30),
       ('José Lima', 45);

-- Criação da tabela Consultas
CREATE TABLE Consultas (
    idConsulta INT AUTO_INCREMENT PRIMARY KEY,
    idMedico INT,
    idPaciente INT,
    dataConsulta DATE,
    FOREIGN KEY (idMedico) REFERENCES Medicos(idMedico),
    FOREIGN KEY (idPaciente) REFERENCES Pacientes(idPaciente)
);

-- Inserção de 3 consultas
INSERT INTO Consultas (idMedico, idPaciente, dataConsulta)
VALUES (1, 1, '2024-10-24'),
       (2, 2, '2024-10-25'),
       (3, 1, '2024-10-26');

-- Alteração do número do ambulatório de todos os médicos para 3
UPDATE Medicos SET numeroAmbulatorio = 3;

-- Alteração do nome do paciente 1 para Pedro da Silva
UPDATE Pacientes SET nome = 'Pedro da Silva' WHERE idPaciente = 1;
