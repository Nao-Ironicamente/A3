
#   Esse Script foi feito para gerar o banco de dados usado na A3 do grupo Não Ironicamente
#	  Para mais informações cheque o Github do projeto https://github.com/Nao-Ironicamente/A3
#
#	  Esse Script também depende de você criar o usuário pub manualmente com os seguintes comandos:
#	  IMPORTANTE! CADA COMANDO DE SER RODADO INDIVIDUALMENTE!
#
#	  Create User 'pub' IDENTIFIED BY 'pub';
#	  GRANT ALL PRIVILEGES ON A3.* TO 'pub';


CREATE DATABASE A3;

Use A3;

CREATE TABLE Funcionario (
  id INT NOT NULL,
  nome VARCHAR(80),
  cargo VARCHAR(80),
  salario DECIMAL(20,3),
  email VARCHAR(20),
  senha VARCHAR(33),
  PRIMARY KEY (id)
);

CREATE TABLE Cliente(
  id INT NOT NULL,
  nome VARCHAR(80),
  endereco VARCHAR(250),
  email VARCHAR(100),
  telefone VARCHAR(20),
  senha VARCHAR(33),
  PRIMARY KEY (id)
)

#Compatibilidade
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
  peso DECIMAL(10,4),
  imagem LONGBLOB,
  PRIMARY KEY (id)
);