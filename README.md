# DESAFIO: CRUD de clientes

Deverá ser entregue um projeto Spring Boot contendo um CRUD completo de web services REST para acessar um recurso de clientes, contendo as cinco operações básicas:

##

### :gear: - ENDPOINT'S CLIENT:

- [GET] - findById;
- [GET] - findByAll;
- [POST] - insert;
- [PUT] - update;
- [DELETE] - delete

##

### :page_with_curl: - CLASS CLIENT: 

Um cliente possui nome, cpf, renda, data de nascimento, e quantidade de filhos. Segue as especificações abaixo:

![client drawio](https://github.com/carloshenriquefs/challenge-crud-client/assets/54969405/b6428c51-5617-4232-857b-34e11b99563e)

##

### :globe_with_meridians: - URL'S:

##

- Busca de client por id:<br />
GET / http://localhost:8080/clients/1

##

- Busca paginada de clientes:<br />
GET / http://localhost:8080/clients?page=0&size=6&sort=name

##

- Inserção de novo cliente:<br />
POST / http://localhost:8080/clients

```
{
    "name" : "Alfredo Jackson",
    "cpf" : "23695845622",
    "income" : 698.00,
    "birthDate" : "2004-02-12",
    "children" : 1
}
```

##

- Atualização de cliente:<br />
PUT / http://localhost:8080/clients/1

```
{
    "name" : "Michael Jackson",
    "cpf" : "446495845633",
    "income" : 620.00,
    "birthDate" : "2000-02-12",
    "children" : 3
}
```
##

- Deleção de cliente:<br />
DELETE / http://localhost:8080/clients/1

##

### :heavy_check_mark: - Critérios:

- [x] - Busca por id retorna cliente existente <br />
- [X] - Busca por id retorna 404 para cliente inexistente <br />
- [X] - Busca paginada retorna listagem paginada corretamente <br />
- [X] - Inserção de cliente insere cliente com dados válidos <br />
- [X] - Inserção de cliente retorna 422 e mensagens customizadas com dados inválidos <br />
- [X] - Atualização de cliente atualiza cliente com dados válidos <br />
- [X] - Atualização de cliente retorna 404 para cliente inexistente <br />
- [X] - Atualização de cliente retorna 422 e mensagens customizadas com dados inválidos <br />
- [X] - Deleção de cliente deleta cliente existente <br />
- [X] - Deleção de cliente retorna 404 para cliente inexistente <br />
