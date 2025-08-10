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
