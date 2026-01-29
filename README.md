# API de Agendamento de Transferências Bancárias

## Tecnologias utilizadas

- Java 25
- Spring Boot
- Spring Web
- Spring Data MongoDB
- MongoDB
- Maven

---

## Requisitos para execução

- Java 25 configurado no ambiente (JAVA_HOME)
- Maven
- MongoDB em execução localmente na porta padrão (27017)

---

## Configuração do banco de dados

A aplicação utiliza MongoDB local com a seguinte configuração:

mongodb://localhost:27017/test

Essa configuração pode ser encontrada no arquivo `application.yml`.

As collections são criadas automaticamente no primeiro insert válido.

---

## Como executar a aplicação

No diretório raiz do projeto, execute:

mvn spring-boot:run

A aplicação ficará disponível em:

http://localhost:8080

---

## Endpoints disponíveis

### Criar agendamento

POST /agendamentos

Exemplo de request:

{
"contaOrigem": "123",
"contaDestino": "456",
"valor": 1500,
"dataAgendamento": "2026-02-05"
}

---

### Listar agendamentos

GET /agendamentos

---

### Buscar agendamento por ID

GET /agendamentos/{id}

---

### Atualizar agendamento

PUT /agendamentos/{id}

Exemplo de request:

{
"contaOrigem": "123",
"contaDestino": "789",
"valor": 1800,
"dataAgendamento": "2026-02-06"
}

---

### Remover agendamento

DELETE /agendamentos/{id}

---

## Regras de cálculo de taxa

O cálculo da taxa é realizado automaticamente no momento da criação ou atualização do agendamento, de acordo com as seguintes regras:

Desenvolva APIs que permitam incluir, alterar, deletar e consultar agendamento de transações bancárias.

Para cada transação, uma taxa de transferencia deve ser cobrada da seguinte forma:
Taxa A (valor da transferencia entre 0€ e 1000€)
- Data do Agendamento igual Data Atual - 3% do valor da transação + 3€
  Taxa B (valor da transferencia entre 1001€ e 2000€)
- Data de agendamento entre 1 e 10 dias da data atual - 9%
  Taxa C (valor da transferencia maior que 2000€)
- Data de agendamento entre 11 e 20 dias da data atual - 8.2% do valor da transação
- Data de agendamento entre 21 e 30 dias da data atual - 6.9% do valor da transação
- Data de agendamento entre 31 e 40 dias da data atual - 4.7% do valor da transação
- Data de agendamento maior que 40 dias da data atual - 1.7% do valor da transação

Caso nenhuma regra seja aplicável, a API retorna erro de regra de negócio.
