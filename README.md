[![N|Solid](http://solutis.com.br/images/logo.png)](http://solutis.com.br)

# NOSSO DESAFIO
Bem vindo. Estamos interessados em ver como você desenvolve com as tecnologias que domina. Que jeito melhor do que apresentando um projeto feito por você memso?
Queremos que você nos aprensente uma aplicação que realize o CRUD de uma entidade. Aqui vão as regras

## REGRAS GERAIS
- Faça a [cópia](https://help.github.com/articles/fork-a-repo/) do repositório (fork), desenvolva e submeta uma [solicitação de mudança](https://help.github.com/articles/creating-a-pull-request/) (pull request) no branch master.
- A aplicação deve ser composta por Backend e/ou Frontend. Caso ache que so vai conseguir fazer um dos dois no tempo disponível, foque nele.
- O Backend deve prover uma [API REST](https://pt.wikipedia.org/wiki/REST)
- Você deve cumprir no mínimo os requisitos abaixo.
- Items marcados com (+) não são obrigatórios, mas servem como diferencial.
- Nas instruções para execução da aplicação é essêncial conter o seu nome e email utilizado no cadastro [Gupy](https://gupy.io/)

## REQUISITOS

Tempos desafiadores. A tecnologia avança em velocidade implacável. O mundo precisa de mais clones. Nossos clientes encomendam seus clones conosco e esperam um serviço de alta qualidade. Os atributos de um clone são:

- nome : Deve atender a seguinte expressão regular [A-Z]{3}[0-9]{4}. O nome de um clone deverá ser único no nosso sistema.
- idade: Número inteiro entre 10 e 20.
- data de criacao: Data na qual o clone foi cadastrado no sistema. 
- adicionais: Lista contendo zero ou mais dos elementos a seguir: [ braço mecânico, esqueleto reforçado, sentidos aguçados, pele adaptativa, raio laser]

A interface + backend da aplicação deverão permitir recuperação da lista de clones, remoção / atualização dos clones cadastrados e cadastro de clones.
Considere que só um usuário vai usar a aplicação e que este usuário não precisa de login. Considere também que nós sabemos como relacionar um clone aos nossos clientes, não é preciso programar essa relação.

## LINGUAGENS
  - JAVA 8
  - Kotlin (+)
  - C#
  - JavaScript/Typescript
  - Swift 4
  
## FRAMEWORKS

### BACKEND
São válidos para o backend os seguintes frameworks:

- JavaEE 7
- Node 8.9.4+ (+)
- Springboot (+)
- .NET WebApi

### FRONTEND
O frontend pode ser Web ou Mobile. Sugerimos as seguintes tecnologias:

- Angular 5
- Android (+)
- iOS (+)

### TESTES
- Sua aplicaçao deve conter arquivos de testes unitários
- Sua aplicação deve conter arquivos de testes de integração (+)

### BANCO DE DADOS
- Não é obrigatório o uso de um SGBD. Caso deseje, pode salvar os dados na memória.
- Caso utilize um banco de dados (e.g. MySQL, PostgreSQL, MongoDB, Redis), você deve fornecer um Dockerfile que rode o ambiente já configurado com o seu banco. (+)
- Caso utilize um banco de dados na nuvem (e.g. Firebase), a aplicação já deve ter o acesso ao banco configurado. (+)

### BUILD E EXECUÇÃO
- Envie as instruções para o build/execução da sua aplicação, disponibilizamos um [exemplo](README.template.md) para ajudar você. Cuidado com dependências externas que inviabilizem ou dificultem essas atividades.
- De preferência utilize um ferramenta como Gradle, Maven, npm para realizar as tarefas necessárias de build.
- Caso deseje, envie um Dockerfile que monte o ambiente já em execução da sua aplicação (+)


# BOA SORTE!