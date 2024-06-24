CREATE DATABASE IF NOT EXISTS Locadora;
USE Locadora ;


CREATE TABLE IF NOT EXISTS Produtora (
  nome VARCHAR(45) NOT NULL,
  CNPJ VARCHAR(45) NOT NULL,
  PRIMARY KEY (CNPJ));
  
CREATE TABLE IF NOT EXISTS Filme (
  idFilme INT NOT NULL,
  nome VARCHAR(45) NOT NULL,
  categoria VARCHAR(45) NOT NULL,
  classificacaoIdade INT NOT NULL,
  anoLancamento INT NOT NULL,
  preco FLOAT NOT NULL,
  Produtora_CNPJ VARCHAR(45) NOT NULL,
  PRIMARY KEY (idFilme),
  CONSTRAINT fk_Filme_Produtora
  FOREIGN KEY (Produtora_CNPJ) REFERENCES Produtora (CNPJ) ON DELETE CASCADE ON UPDATE CASCADE);

CREATE TABLE IF NOT EXISTS Cliente (
  CPF VARCHAR(45) NOT NULL,
  nome VARCHAR(45) NOT NULL,
  idade INT NOT NULL,
  telefone VARCHAR(45) NOT NULL,
  PRIMARY KEY (CPF));

CREATE TABLE IF NOT EXISTS Pedido (
  idPedido INT NOT NULL,
  dataPedido DATE NOT NULL,
  diasDevolucao INT NOT NULL,
  Cliente_CPF VARCHAR(45) NOT NULL,
  PRIMARY KEY (idPedido),
  CONSTRAINT fk_Pedido_Cliente1
  FOREIGN KEY (Cliente_CPF) REFERENCES Cliente (CPF) ON DELETE CASCADE ON UPDATE CASCADE);


CREATE TABLE IF NOT EXISTS Filme_has_Pedido (
  Filme_idFilme INT NOT NULL,
  Pedido_idPedido INT NOT NULL,
  PRIMARY KEY (Filme_idFilme, Pedido_idPedido),
  CONSTRAINT fk_Filme_has_Pedido_Filme1
  FOREIGN KEY (Filme_idFilme) REFERENCES Filme (idFilme) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT fk_Filme_has_Pedido_Pedido1
  FOREIGN KEY (Pedido_idPedido) REFERENCES Pedido (idPedido) ON DELETE CASCADE ON UPDATE CASCADE);

INSERT INTO Produtora(nome, CNPJ) VALUES ('Dreamworks', '428');
INSERT INTO Produtora(nome, CNPJ) VALUES ('Universal Pictures', '906');
INSERT INTO Produtora(nome, CNPJ) VALUES ('Walt Disney Pictures', '135');
INSERT INTO Produtora(nome, CNPJ) VALUES ('Warner Bros', '279');

INSERT INTO Filme(idFilme, nome, categoria, classificacaoIdade, anoLancamento, preco, Produtora_CNPJ) VALUES (1, 'Shrek', 'Animação, Comédia', 0, '2001', 8.0, '428');
INSERT INTO Filme(idFilme, nome, categoria, classificacaoIdade, anoLancamento, preco, Produtora_CNPJ) VALUES (2, 'Megamente', 'Animação, Ação', 0, '2010', 7.50, '428');
INSERT INTO Filme(idFilme, nome, categoria, classificacaoIdade, anoLancamento, preco, Produtora_CNPJ) VALUES (3, 'Oppenheimer', 'Drama, História', 18, '2023', 12.00, '906');
INSERT INTO Filme(idFilme, nome, categoria, classificacaoIdade, anoLancamento, preco, Produtora_CNPJ) VALUES (4, 'Velozes e Furiosos 9', 'Ação, Crime', 14, '2021', 10.00, '906');
INSERT INTO Filme(idFilme, nome, categoria, classificacaoIdade, anoLancamento, preco, Produtora_CNPJ) VALUES (5, 'Moana', 'Animação, Aventura', 0, '2016', 10.00, '135');
INSERT INTO Filme(idFilme, nome, categoria, classificacaoIdade, anoLancamento, preco, Produtora_CNPJ) VALUES (6, 'Os incríveis', 'Animação, Super-Herói', 0, '2004', 8.00, '135');
INSERT INTO Filme(idFilme, nome, categoria, classificacaoIdade, anoLancamento, preco, Produtora_CNPJ) VALUES (7, 'Coringa', 'Drama, Suspense', 17, '2019', 12.00, '279');
INSERT INTO Filme(idFilme, nome, categoria, classificacaoIdade, anoLancamento, preco, Produtora_CNPJ) VALUES (8, 'Como eu era antes de você', 'Drama romântico', 12, '2016', 10.50, '279');







