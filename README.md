# CyberPunk

O [CyberPunk](/#) é o melhor sistema para gerenciar clones de modo agradável e intuitivo. Nesses tempos desafiadores, a nossa ferramenta avança em velocidade implacável. Se o mundo precisa de mais clones, o mundo precisa do CyberPunk.

## Instalação
Linux & Windows
- Mova o arquivo DockerFile para o diretório docker e execute o build
```sh
docker build --rm=true -t ubuntu/postgresql:9.3 .
```
- Inicie o container configurando a porta do host local
```sh
docker run -i -t -p 5432:5432 ubuntu/postgresql:9.3
```
- Após fazer o build e resolver todas as depencias no projeto, execute a class CyberPunkApplication.java
- Digite em um navegador o seguinte caminho: 
```sh
http://localhost:8080/
```
## Configuração
- JDK 8 ou superior
- Docker (testado na versão 17)

## Meta
Ezequias Sampaio – ezequiassam@gmail.com

Distribuído sob a licença `Apache License 2.0`. Veja `LICENSE` para mais informações.
