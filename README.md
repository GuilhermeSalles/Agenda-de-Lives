
# 📺 Agenda Live
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/GuilhermeSalles/Tomas-BigPizza/blob/main/LICENSE) 

Este é um projeto para o agendamento de lives, desenvolvido com **Spring Boot**, **JPA** e **PostgreSQL**. O sistema fornece uma API REST para gerenciar eventos de live, com suporte a filtros por data e paginação.

---

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.3.6**
- **JPA / Hibernate**
- **PostgreSQL**
- **Docker**
- **H2 (Testes)**
- **Swagger (para documentação futura)**

---

## ⚙️ Como Executar o Projeto

### Requisitos:

- Java 17+
- Docker (para PostgreSQL)
- Maven 3.8+

### Passos:

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/agendalive.git
   cd agendalive
   ```

2. Suba o container do PostgreSQL:
   ```bash
   docker-compose up -d
   ```

3. Execute a aplicação:
   ```bash
   ./mvnw spring-boot:run
   ```

4. Acesse a aplicação em `http://localhost:8080`.

---

## 📖 Endpoints da API

Abaixo estão os principais endpoints da API:

| Método   | Endpoint          | Descrição                                  |
|----------|-------------------|--------------------------------------------|
| `GET`    | `/lives`          | Retorna todas as lives (paginação e flag). |
| `GET`    | `/lives?flag=next`| Retorna todas as lives futuras.            |
| `GET`    | `/lives?flag=previous`| Retorna todas as lives passadas.       |
| `GET`    | `/lives/{id}`     | Retorna uma live pelo ID.                  |
| `POST`   | `/lives`          | Cadastra uma nova live.                    |
| `PUT`    | `/lives/{id}`     | Atualiza uma live existente.               |
| `DELETE` | `/lives/{id}`     | Remove uma live pelo ID.                   |

---

## 📂 Estrutura do Projeto

```plaintext
src
├── main
│   ├── java/com/guilhermebaltazar/demo
│   │   ├── controllers    # Controladores da API
│   │   ├── entities       # Classes de modelo
│   │   ├── enums          # Definições de enums
│   │   ├── repositories   # Interfaces do repositório JPA
│   │   ├── services       # Lógica de negócio
│   │   ├── exceptions     # Manipulação de exceções globais
│   │   └── config         # Configurações adicionais
│   └── resources
│       ├── application.properties  # Configurações da aplicação
│       └── import.sql              # Dados de exemplo
└── test
    ├── java/com/guilhermebaltazar/demo # Testes automatizados
```

---

## 🗂️ Exemplos de Uso

### Criar uma Live
**POST** `/lives`
```json
{
  "liveName": "Explorando Resident Evil",
  "channelName": "Alanzoka",
  "liveDate": "2024-12-01T19:00:00",
  "liveLink": "http://twitch.tv/alanzoka",
  "liveStatus": "SCHEDULED"
}
```

### Buscar Todas as Lives Futuras
**GET** `/lives?flag=next`
```json
{
  "content": [
    {
      "id": 1,
      "liveName": "Explorando Resident Evil",
      "channelName": "Alanzoka",
      "liveDate": "2024-12-01T19:00:00",
      "liveLink": "http://twitch.tv/alanzoka",
      "registrationDate": "2024-11-26T15:00:00",
      "liveStatus": "SCHEDULED"
    }
  ]
}
```

### Atualizar uma Live
**PUT** `/lives/{id}`
```json
{
  "liveName": "Explorando Resident Evil 2",
  "channelName": "Alanzoka",
  "liveDate": "2024-12-02T19:00:00",
  "liveLink": "http://twitch.tv/alanzoka",
  "liveStatus": "FINISHED"
}
```

---


## 👨‍💻 Autor
**Guilherme Baltazar Vericimo de Sales**

<a href="https://www.linkedin.com/in/guilherme-baltazar-0028361a1" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a> 
<a href="https://instagram.com/yguilhermeb" target="_blank"><img src="https://img.shields.io/badge/-Instagram-%23E4405F?style=for-the-badge&logo=instagram&logoColor=white" target="_blank"></a>
