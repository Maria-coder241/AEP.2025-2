CREATE DATABASE Banco;
USE Banco;

CREATE TABLE Escola (
    id_escola INT PRIMARY KEY AUTO_INCREMENT,
    nome_escola VARCHAR(100) NOT NULL
);

CREATE TABLE Professores (
    RP INT PRIMARY KEY AUTO_INCREMENT,
    nome_professor VARCHAR(50),
    email VARCHAR(50) UNIQUE,
    materia VARCHAR(30),
    senha VARCHAR(20) NOT NULL,
    id_escola INT,
    FOREIGN KEY (id_escola) REFERENCES Escola(id_escola)
);

CREATE TABLE Alunos (
    RA INT PRIMARY KEY AUTO_INCREMENT,
    nome_aluno VARCHAR(50),
    email VARCHAR(50) UNIQUE,
    ano_escolar VARCHAR(10),
    senha VARCHAR(20) NOT NULL,
    id_escola INT,
    FOREIGN KEY (id_escola) REFERENCES Escola(id_escola)
);

CREATE TABLE Turmas (
    id_turma INT PRIMARY KEY AUTO_INCREMENT,
    nome_turma VARCHAR(50),
    ano VARCHAR(10),
    id_professor INT,
    FOREIGN KEY (id_professor) REFERENCES Professores(RP)
);

CREATE TABLE Aluno_Turma (
    id_turma INT,
    id_aluno INT,
    PRIMARY KEY (id_turma, id_aluno),
    FOREIGN KEY (id_turma) REFERENCES Turmas(id_turma),
    FOREIGN KEY (id_aluno) REFERENCES Alunos(RA)
);

CREATE TABLE Atividades (
    id_atividade INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(100),
    descricao TEXT,
    data_postagem DATE,
    id_turma INT,
    id_professor INT,
    FOREIGN KEY (id_turma) REFERENCES Turmas(id_turma),
    FOREIGN KEY (id_professor) REFERENCES Professores(RP)
);

CREATE TABLE Respostas (
    id_resposta INT PRIMARY KEY AUTO_INCREMENT,
    conteudo TEXT,
    data_envio DATE,
    id_atividade INT,
    id_aluno INT,
    FOREIGN KEY (id_atividade) REFERENCES Atividades(id_atividade),
    FOREIGN KEY (id_aluno) REFERENCES Alunos(RA)
);

CREATE TABLE Duvidas (
    id_duvida INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(100),
    conteudo TEXT,
    data_envio DATETIME,
    id_aluno INT,
    id_professor INT,
    FOREIGN KEY (id_aluno) REFERENCES Alunos(RA),
    FOREIGN KEY (id_professor) REFERENCES Professores(RP)
);

CREATE TABLE Mensagens (
    id_mensagem INT PRIMARY KEY AUTO_INCREMENT,
    conteudo TEXT,
    data_envio DATETIME,
    id_remetente INT,
    tipo_remetente ENUM('Aluno','Professor'),
    id_destinatario INT,
    tipo_destinatario ENUM('Aluno','Professor')
);

CREATE TABLE Calendario (
    id_evento INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(100),
    descricao TEXT,
    data_evento DATE,
    id_escola INT,
    FOREIGN KEY (id_escola) REFERENCES Escola(id_escola)
);
