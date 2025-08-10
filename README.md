# SistemaFilmesSpringMVC

Projeto Web **Spring MVC (JSP)** com **JDBC/MySQL** – Etapa 9 do PI.  
Listagem e CRUD simples de filmes.

## Stack
- Java 8, Apache Tomcat 9
- Spring MVC 5.3, Spring JDBC
- JSP + JSTL
- MySQL 8
- Maven

## Requisitos
- JDK 8+
- Tomcat 9
- MySQL 8
- NetBeans (ou Maven CLI)

- ## Como rodar
- JDK 8 + Tomcat 9
- Deploy do projeto e acessar: `http://localhost:8080/SistemaFilmesSpringMVC/filmes`
- (No NetBeans: Project Properties → Run → **Relative URL** = `/filmes`)
- Config do banco está em `WEB-INF/dispatcher-servlet.xml` (user/senha padrão `root`/`root`)

## Rotas
- **GET** `/filmes` – listar
- **GET** `/filmes/novo` – formulário
- **POST** `/filmes` – salvar (criar/editar)
- **GET** `/filmes/{id}/editar` – editar
- **POST** `/filmes/{id}/excluir` – exclui

## Banco de dados
```sql
CREATE DATABASE IF NOT EXISTS cenaflix CHARACTER SET utf8mb4;
USE cenaflix;

CREATE TABLE IF NOT EXISTS filme (
  id INT AUTO_INCREMENT PRIMARY KEY,
  titulo  VARCHAR(120) NOT NULL,
  sinopse TEXT,
  genero  VARCHAR(60),
  ano     INT
);


