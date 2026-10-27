# 🎓 Sistema Acadêmico — API REST Spring Boot & MongoDB

![Java](https://img.shields.io/badge/Java-25-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green?style=for-the-badge&logo=springboot)
![MongoDB](https://img.shields.io/badge/MongoDB-Local-brightgreen?style=for-the-badge&logo=mongodb)
![Insomnia](https://img.shields.io/badge/Insomnia-REST_Client-purple?style=for-the-badge&logo=insomnia)

API RESTful completa desenvolvida para gestão acadêmica de estudantes, cursos e professores. Projeto prático focado na integração de rotas CRUD com **Spring Data MongoDB** e persistência de documentos.

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java
* **Framework Backend:** Spring Boot
* **Persistência de Dados:** Spring Data MongoDB
* **Banco de Dados:** MongoDB (NoSQL)
* **Client de Testes:** Insomnia

---

## 📚 Mapeamento do Domínio

A API gerencia três entidades principais representadas como documentos NoSQL:

* 👨‍🎓 **Estudante:** Nome, Idade, E-mail
* 📖 **Curso:** Descrição
* 👨‍🏫 **Professor:** Nome, E-mail, Idade

---

## 🔗 Endpoints da API

Todas as rotas possuem o prefixo base `/api`.

### 👨‍🎓 Estudantes (`/api/estudantes`)

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `POST` | `/api/estudantes` | Cadastrar novo estudante |
| `GET` | `/api/estudantes` | Listar todos os estudantes |
| `GET` | `/api/estudantes/{id}` | Buscar estudante por ID |
| `PUT` | `/api/estudantes/{id}` | Atualizar dados do estudante |
| `DELETE` | `/api/estudantes/{id}` | Remover estudante por ID |

---

### 📖 Cursos (`/api/cursos`)

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `POST` | `/api/cursos` | Cadastrar novo curso |
| `GET` | `/api/cursos` | Listar todos os cursos |
| `GET` | `/api/cursos/{id}` | Buscar curso por ID |
| `PUT` | `/api/cursos/{id}` | Atualizar dados do curso |
| `DELETE` | `/api/cursos/{id}` | Remover curso por ID |

---

### 👨‍🏫 Professores (`/api/professores`)

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `POST` | `/api/professores` | Cadastrar novo professor |
| `GET` | `/api/professores` | Listar todos os professores |
| `GET` | `/api/professores/{id}` | Buscar professor por ID |
| `PUT` | `/api/professores/{id}` | Atualizar dados do professor |
| `DELETE` | `/api/professores/{id}` | Remover professor por ID |

---

## 📁 Estrutura do Projeto

```text
src/
└── main/
    └── java/
        └── com/example/demo_integracao_mongodb/
            ├── controllers/   # Endpoints e controle das requisições HTTP
            ├── models/        # Entidades/Documentos representados no MongoDB
            └── repositories/  # Interfaces do Spring Data MongoDB
