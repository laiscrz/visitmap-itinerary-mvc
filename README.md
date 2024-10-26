# 🌍 VisitMap

**VisitMap** é uma aplicação desenvolvida em Spring Boot e Thymeleaf que permite aos usuários planejar e explorar roteiros turísticos de forma fácil e interativa. A aplicação oferece uma interface amigável para visualizar locais turísticos, suas informações e criar itinerários personalizados.

## 📚 Estrutura do Banco de Dados

A aplicação utiliza um modelo de banco de dados relacional para gerenciar as informações das locais turisticos, Itnerários e suas interações. Abaixo está o diagrama de Entidade e Relacionamento com as tabelas principais da estrutura do banco de dados:

```mermaid
erDiagram
    PLACE {
        Long id PK "Identificador único"
        String nome "Nome da atração"
        String descricao "Descrição da atração"
        String cidade "Cidade onde a atração está localizada"
        String estado "Estado onde a atração está localizada"
        String rua "Rua onde a atração está localizada"
        String tipo "Tipo da atração (enum)"
        String description "Descrição adicional"
        String entrada "Tipo de entrada (enum)"
        String urlImagem "URL da imagem da atração"
    }

    ITINERARY {
        Long id PK "Identificador único"
        String nome "Nome do itinerário"
        LocalDate data_criacao "Data de criação do itinerário"
        String pais "País do itinerário (enum)"
    }

    ITINERARY_PLACE {
        Long itinerary_id FK "Referência ao itinerário"
        Long place_id FK "Referência ao local"
    }

    PLACE ||--o{ ITINERARY_PLACE : "é incluído em"
    ITINERARY ||--o{ ITINERARY_PLACE : "inclui"
```
---
## 🛤️ Rotas da Aplicação

### 🏠 Home (`index.html`)
- **Página Inicial**: `GET /`  
  Acesso à página inicial do VisitMap.

### 🗺️ Itinerários (`/itineraries`)
- **Listar Itinerários**: `GET /itineraries`  
- **Detalhes do Itinerário**: `GET /itineraries/{id}`  
- **Criar Novo Itinerário**: `GET /itineraries/new`  
- **Salvar Itinerário**: `POST /itineraries`  
- **Editar Itinerário**: `GET /itineraries/edit/{id}`  
- **Atualizar Itinerário**: `POST /itineraries/{id}`  
- **Deletar Itinerário**: `GET /itineraries/delete/{id}`  

### 🏛️ Lugares Turisticos (`/places`)
- **Listar Lugares**: `GET /places`  
- **Detalhes do Lugar**: `GET /places/{id}`  
- **Criar Novo Lugar**: `GET /places/new`  
- **Salvar Lugar**: `POST /places`  
- **Editar Lugar**: `GET /places/edit/{id}`  
- **Atualizar Lugar**: `POST /places/{id}`  
- **Deletar Lugar**: `GET /places/delete/{id}`  

---
## 🧪 Testes Unitários

A aplicação **VisitMap** inclui uma suíte de testes unitários que garante a qualidade e o funcionamento adequado dos serviços. Foram implementados testes para as classes `ItineraryService` e `PlaceService` utilizando **JUnit** e **Mockito**. 

No total, 12 testes foram executados com sucesso, confirmando que as funcionalidades principais estão funcionando conforme o esperado.

![Terminal com comando `mvn clean test`](https://github.com/user-attachments/assets/f03da1d2-d8c9-4a78-bec9-4cc4b63b6a80)

---

## Funcionalidades ✨

- **🗺️ Cadastro de Itinerários**: Crie itinerários com nomes, descrições e datas programadas.
- **🏛️ Gerenciamento de Atrações**: Adicione, edite e remova atrações turísticas, incluindo informações detalhadas como nome, cidade, endereço, tipo, custo de entrada, horário de funcionamento e imagens.
- **🔍 Exploração de Atrações**: Visualize todas as atrações disponíveis, filtrando por tipo e cidade.
- **⭐ Avaliações**: Classifique atrações turísticas e veja a média das avaliações de outros usuários.

## Tecnologias Utilizadas 🛠️

- **Spring Boot**: Framework para desenvolvimento de aplicações Java.
- **Thymeleaf**: Motor de templates para gerar páginas HTML dinâmicas.
- **Hibernate**: ORM para mapeamento objeto-relacional.
- **Oracle Database**: Banco de dados relacional utilizado para armazenar informações de itinerários e atrações turísticas.

