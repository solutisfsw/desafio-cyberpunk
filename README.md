# Sistema para encomenda de clones Web API com NodeJS


## Projeto NodeJs v8

* NodeJS v8.9.4
* body-parser v1.18.2
* consign v0.1.6
* express v4.16.2,
* express-validator v5.0.2
* mocha v5.0.1
* supertest v3.0.0


## Executando o Projeto

* NodeJs.

Navege entre as pastas pelo terminal e entre na pasta do projeto, depois instale todas as dependencias com o comando:

```
npm install
```

Inicie o projeto com o comando:

```
node index
```
## Cadastrando
Faça uma requisição post para http://localhost:3000/clones/clone passando os dados com um JSON,exemplo:

```
{
    "nome":"alisson",
    "idade":"25",
    "adicionais":["braço mecanico","raio laser"]
}
```

# Listando
Faça uma requisição get para http://localhost:3000/clones

# Alterando
Faça uma requisição put para http://localhost:3000/clones/clone/:id passando o id do clone que deseja alterar os dados com um Json,exemplo

```
{
    "nome":"alisson27",
    "idade":"25",
    "adicionais":["braço mecanico"]
}
```
# Consultando

Faça uma requisição get para  http://localhost:3000/clones/:id passando o id do clone que deseja consultar

# Deletando

Faça uma requisição delete para  http://localhost:3000/clones/:id passando o id do clone que deseja destruir

# Executando o teste do sistema
Inicie o projeto com o comando:

```
node index
```
Abra outra tela no terminal e navege entre as pastas e entre na pasta do projeto e execute o comando:

```
node node_modules/mocha/bin/mocha
```


```
Duvidas? alisonuniversal@hotmail.com 
```







