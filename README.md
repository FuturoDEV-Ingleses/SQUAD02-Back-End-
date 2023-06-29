# Squad02-Back-End
Projeto Avaliativo Senai-Lab365.
## Sobre o projeto
Aplicação para controle de estoque de materiais para ongs, desenvolvido em grupo.

## Funcionalidades
- exibir,
- cadastrar,
- editar e
-  excluir informações no cadastro de usuário, cadastro de estoque e cadastro de armazenamento;


## Tecnologias utilizadas:
- Spring: Boot, MVC, Data - para o projeto back-end;
- Java;
- API Rest (centralizando as regras do negócio);
- Git com GitHub;
- PostgreSQL para o banco de dados;
- Trello para organização e divisão das atividades

## Instalação
1. Clone o repositório para sua máquina local.
2. Navegue até o diretório raiz do projeto.
3. Precisa ter JDK instalada
4. Instalado Maven
   
## Dependências
1. Spring Web
2. Spring Data JPA
3. PostgreSQL Driver
4. Spring Boot DevTools
5. Lombock

## Endpoints
Usuario :
POST  http://localhost:8080/usuario/cadastro
POST  http://localhost:8080/usuario/login
Armazem
GET http://localhost:8080/armazem/ar  
POST http://localhost:8080/armazem/cadastrar
PUT http://localhost:8080/armazem/editar/{Id}
PUT http://localhost:8080/armazem/desativar/{Id}

Estoque

GET  http://localhost:8080/estoque/listar
POST http://localhost:8080/estoque/cadastrar
PUT http://localhost:8080/estoque/editar/{id}

Dashboard

GET http://localhost:8080/dashboard/relatorio


## Estrutura do projeto

## Modelagem do Banco de dados 
<img width="464" alt="Devin-adoptionTabelas" src="https://github.com/FuturoDEV-Ingleses/SQUAD02-Back-End-/assets/118769908/b8a854f2-c400-4200-a2af-46b6afafc4dd">



## Integrantes da Squad02
O projeto é dividido em front-end e back-end:
#### Time front-end:
    Otávio e Rosa
#### Time Back-end: 
    Neli e Victor
#### Testes: 
    Yoslandy

## Licença
