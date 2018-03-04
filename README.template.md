# Crud dos Clones - desafio Solutis

O crud foi feito usando Java com Spring boot e montagem de ambiente e banco usando docker

## Instalação
Linux & Windows

```sh
Precisa excutar o script start.h, no caso do windows é preciso executar o script pelo prompt do docker.
```
## Configuração
No windows eu so precisei do docker instalado.
Será preciso iniciar a máquina, navegar até o repositório desafioSolutis e executar o script.

No linux deve ser o mesmo procedimento.

Obs1: eu não precisei instalar o maven, a própia maquina docker toolbox já tinha instalado. Mas talvez precise.

Obs2: no final do script surge um ip que pode ser usado para acessar o servico rest. No windows funciona com o ip mostrado no final script. No linux creio que deve aparecer localhost ou 127.0.0.1 ou 0.0.0.0 . A porta sempre será 8080. 
Foi usado a ferramenta postman para simular as requisições.

Obs3: as rotas para acessar o servico também estão no script

Exemplo de formato da requisição:

```sh
{    
    "bracoMecanico": false,
    "esqueletoReforcado": false,
    "sentidosAgucados": false,
    "peleAdaptativa": true,
    "raioLaser": false,
    "clone": {        
        "nome": "AAA1234",
        "idade": 11        
    }
}
```


## Meta
Lucas Pereira – [Lucas Pereira da Silva Souza](https://www.linkedin.com/in/lucas-souza-277806142/) – lucas.siva@hotmail.com

Distribuído sob a licença `Tipo da licença`. Veja `LICENSE` para mais informações.