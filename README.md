Sumário
=======
   * [Considerações](#considerações)
   * [Dependências](#dependências)
   * [Instalação](#instalação)
      * [Rodando o Projeto](#rodando-o-projeto)
      * [Testes automatizados](#testes-automatizados)

Considerações
============

1- O projeto foi desenvolvido utilizando Ionic.

2- O armazenamento local utiliza [POUCHDB](https://pouchdb.com/).

3- O testes de unidade utilizam Jest (+tecnologias associadas).

4- Os testes e2e utilizam Protractor (+tecnologias associadas).

Extras:

5- Esta disponível uma sincronização dos dados locais com o [COUCHDB](http://couchdb.apache.org/), para isto é preciso configurar o script (database.ts), com seu ip e o nome do seu banco local. Utilizaria o Docker para esta configuração, contudo fiquei sem tempo (tive somente o dia 4/03/18 para desenvolvimento), então conforme indicado, mantive o foca apenas no Frontend.


Dependências
============

1) Node : v8.9.4

2) Npm  : 5.6.0 

Recomendo fortemente a utilização do NVM. Siga as instruções para instalar em [NVM](https://github.com/creationix/nvm/blob/master/README.md), de acordo com seu Sistema Operacional.


Instalação
==========

Baixe o projeto: 

```
$ git clone https://github.com/solutisfsw/desafio-cyberpunk.git
```

```
$ npm install
```

## Rodando o Projeto


```
## In Project

ionic serve
```

Feito isso, será aberto o navegador padrão com: http://localhost:8100


## Testes automatizados

Os testes realizados nesse projetos são unitários e E2E (End to End). 

```
## Para os testes e2e (apenas conceitual)

protractor
```

```
## Para os testes unitários (apenas conceitual)

npm test
```

## Meta
Danilo Silva dos Santos – [Danilo Silva dos Santos](https://www.linkedin.com/in/daniloitj/) – daniloitj@gmail.com


