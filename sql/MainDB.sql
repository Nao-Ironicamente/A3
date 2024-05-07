#Drop database if exists A3;

CREATE DATABASE A3;

Use A3;

CREATE TABLE Pessoa (
  id INT NOT NULL,
  nome VARCHAR(80) NULL DEFAULT NULL,
  idade INT NULL DEFAULT NULL,
  telefone VARCHAR(20) NULL DEFAULT NULL,
  endereco VARCHAR(250) NULL DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE Aluno (
  id INT NOT NULL,
  Pessoa_id INT,
  curso VARCHAR(80),
  fase VARCHAR(20),
  matricula VARCHAR(50),
  PRIMARY KEY (id),
  foreign key (Pessoa_id) references Pessoa (id)
);


#compatibilidade
CREATE TABLE tb_alunos (
  id INT NOT NULL,
  nome varchar(80),
  idade int,
  curso VARCHAR(80),
  fase VARCHAR(20),
  matricula VARCHAR(50),
  PRIMARY KEY (id)
);

CREATE TABLE Produto (
  id INT NOT NULL,
  nome VARCHAR(50),
  descricao TEXT,
  estoque INT,
  preço DECIMAL(10,3),
  cadastro DATE,
  PRIMARY KEY (id)
);