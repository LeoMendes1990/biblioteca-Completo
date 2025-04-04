# 📚 API RESTful de Biblioteca - Bootcamp Decola Tech Avanade 2025

Este projeto tem como objetivo construir uma API RESTful simples para gerenciamento de livros e suas categorias. Foi desenvolvido com fins educacionais para o bootcamp **Decola Tech Avanade 2025**, da **DIO**.

## 🚀 Tecnologias Utilizadas

- **Java 17**: Versão LTS moderna e robusta da linguagem.
- **Spring Boot 3**: Framework para aplicações Java com foco em produtividade.
- **Spring Data JPA**: Abstração da camada de persistência com JPA e Hibernate.
- **OpenAPI (Swagger)**: Documentação clara e acessível das rotas da API.
- **Railway**: Plataforma de deploy e monitoramento de aplicações na nuvem.

## 🎨 Modelagem da Aplicação

A modelagem da aplicação foi realizada com base na abstração do domínio apresentada no Figma. A seguir, o **diagrama de classes** da aplicação:

```mermaid
classDiagram
  class Categoria {
    -Integer id
    -String nome
    -String descricao
    -Livro[] livro
  }

  class Livro {
    -Integer id
    -String titulo
    -String nome_autor
    -String texto
    -Tamanho tamanho
    -Categoria categoria
  }

  Categoria "1" *-- "N" Livro
