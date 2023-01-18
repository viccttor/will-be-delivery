# Will Be Delivery
<p>Sua API para entrega de Pedidos</p>

##  🛠 Tecnologias e Ferramentas

* Java 11
* Spring Boot
* JPA Hibernate
* H2
* Swagger
* Lombok
* OpenFeign
* Intellij


##  Funcionalidades

* Pedido
    * Criar um pedido
    * Atualizar pedido
    * Atualizar status de entrega
    * Encontrar um pedido
    * Listar pedidos
    * deletar pedido


### Pedido Controller

| Rest   | URL                     | Função                                |
|--------|-------------------------|---------------------------------------|
| PUT    | /atualizarPedido        | Atualizar um pedido                   |
| PATCH  | /atualizarStatusEntrega | Atualizar status de entrega do pedido |
| GET    | /buscarPedido           | Buscar um pedido                      |
| GET    | /buscarTodosPedidos     | Listar todos os pedidos               |
| DELETE | /deletarPedido          | Deletar um pedido                     |
| POST   | /inserirPedido          | Cadastrar um pedido                   |

<br>

![01](https://github.com/viccttor/will-be-delivery/blob/main/img/0.png)

## Utilizando a API 

### Cadastrando um pedido 

* No método Post - /inserirPedido
<p>JSON para teste:</p>

```
{
  "destinatario": "Nome do destinatario teste",
  "enderecoDTO": {
    "cep": "55819000"
  }
}
```
* Expectativa
<p>Código HTPP: 200</p>
<p>Corpo:</p>

```
{
  "id": 1,
  "detinatario": "Nome do destinatario teste",
  "statusEntrega": "RECEBIDO",
  "enderecoEntrega": {
    "cep": "55819-000",
    "logradouro": "Avenida Congresso Eucarístico Internacional",
    "complemento": "até 99998 - lado par",
    "bairro": "Bairro Novo",
    "localidade": "Carpina",
    "uf": "PE",
    "ibge": "2604007",
    "gia": "",
    "ddd": "81",
    "siafi": "2379"
  }
}
```

* No método PUT - /atualizarPedido

<p>Parâmetro - ID</p>

```
ID: 1
```

<p>JSON para teste:</p>

```
{
  "destinatario": "Nome do destinatario teste editado",
  "enderecoDTO": {
  "cep": "55818000"
  }
}
```
<p>Parâmentro - ENUM </p>

```
ENUM: Enviado
```

* Expectativa
<p>Código HTPP: 200</p>
<p>Corpo:</p>

```
{
  "id": 1,
  "detinatario": "Nome do destinatario teste editado",
  "statusEntrega": "ENVIADO",
  "enderecoEntrega": {
    "cep": "55819-000",
    "logradouro": "Avenida Congresso Eucarístico Internacional",
    "complemento": "até 99998 - lado par",
    "bairro": "Bairro Novo",
    "localidade": "Carpina",
    "uf": "PE",
    "ibge": "2604007",
    "gia": "",
    "ddd": "81",
    "siafi": "2379"
  }
}
```

* No método GET - /buscarPedido
<p>Parâmetro - ID</p>

```
ID: 1
```
* Expectativa
<p>Código HTPP: 200</p>
<p>Corpo:</p>

```
{
  "id": 1,
  "detinatario": "Nome do destinatario teste editado",
  "statusEntrega": "ENVIADO",
  "enderecoEntrega": {
    "cep": "55819-000",
    "logradouro": "Avenida Congresso Eucarístico Internacional",
    "complemento": "até 99998 - lado par",
    "bairro": "Bairro Novo",
    "localidade": "Carpina",
    "uf": "PE",
    "ibge": "2604007",
    "gia": "",
    "ddd": "81",
    "siafi": "2379"
  }
}
```

* No método PATCH - /atualizarStatusEntrega

<p>Parâmetro - ID</p>

```
ID: 1
```

<p>Parâmentro - ENUM </p>

```
ENUM: ENTREGUE
```

* Expectativa
<p>Código HTPP: 200</p>
<p>Corpo:</p>

```
{
  "id": 1,
  "detinatario": "Nome do destinatario teste editado",
  "statusEntrega": "ENTREGUE",
  "enderecoEntrega": {
    "cep": "55819-000",
    "logradouro": "Avenida Congresso Eucarístico Internacional",
    "complemento": "até 99998 - lado par",
    "bairro": "Bairro Novo",
    "localidade": "Carpina",
    "uf": "PE",
    "ibge": "2604007",
    "gia": "",
    "ddd": "81",
    "siafi": "2379"
  }
}

```

* No método DELETE - /deletarPedido
<p>Parâmetro - ID</p>

```
ID: 1
```

* No método Post - /buscarTodosPedidos
* Expectativa
<p>Código HTPP: 200</p>
<p>Response body:</p>

```
[]
```


