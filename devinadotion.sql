CREATE TABLE usuario(
 id bigserial PRIMARY KEY ,
 nome varchar (100) NOT NULL ,
 email varchar (100) NOT NULL,
 senha varchar (30) NOT NULL
);

CREATE TABLE armazem(
 id bigserial PRIMARY KEY,
 nome varchar (30) NOT NULL,
 animal varchar(20) NOT NULL ,
 ativo bool
);

CREATE TABLE estoque(
 id bigserial PRIMARY KEY,
 armazem_id bigint NOT NULL REFERENCES armazem(id) ,
 produto_id bigint NOT NULL REFERENCES produto(id),
 quantidade int NOT NULL 
);

CREATE TABLE produto(
 id bigserial PRIMARY KEY,
 animal varchar (8) NOT NULL,
 categoria varchar (7) NOT NULL ,
 tipo varchar(15) NOT NULL
);

