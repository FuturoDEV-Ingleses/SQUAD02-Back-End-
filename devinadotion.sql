CREATE TABLE usuario(
id bigserial PRIMARY KEY ,
nome varchar (100) NOT NULL ,
email varchar (100) NOT NULL,
senha varchar (30) NOT NULL
);

CREATE TABLE estoque(
id bigserial PRIMARY KEY,
armazem_id bigint NOT NULL REFERENCES armazem(id) ,
produto varchar (20) NOT NULL ,
quantidade int NOT NULL ,
animal varchar (20) NOT NULL ,
categoria varchar (10) NOT NULL
);

CREATE TABLE armazem(
id bigserial PRIMARY KEY,
nome varchar (30) NOT NULL,
tipo_animal varchar NOT NULL,
ativo bool 
);
