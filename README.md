# Nome do projeto

O projeto foi desenvolvido como solicitado na seleção Solutis. 
O Backend foi implementado em Java com o uso do Springboot, maven e Hibernate e tem seu banco MySQL online.
O Frontend foi desenvolvido para a plataforma Android com o uso da linguagem Kotlin.

## Instalação
Linux & Windows

A implantação do backend pode ser feita pelo Docker, já que uma imagem já foi gerada no projeto.
O usuário tem apenas que abrir o docker na pasta do projetodo backend e executar o seguinte código

docker run -p 8080:8080 -t mnmatos/cyberpunk

para executar o app (frontend), deve-se instalar o cyberpunk.apk presente na pasta cyberpunk_app.

## Configuração
A única configuração necessária diz respeito ao IP do backend. Quando o app é aberto no android uma
alert aparece solicitando o endereço de IP do servidor onde o backend estará funcionando. 
Neste parte há duas possibilidades:
1. Caso o app esteja sendo rodado em um emulador na mesma máquina que o servidor não há razão para
configurar o endereço, pois o endereço padrão do app já é o local, desta forma pode ser pressionado 
o botão "cancelar" na tela de prompt.
2. Caso o app esteja sendo utilizado em um dispositivo diverso, deve ser inserido o IP da máquina que 
está rodando o servidor. Lembrando que o dispositivo deve estar na mesma rede local que o backend.

Obs.:A execução dos testes deve ser feita em um banco zerado.

## Meta
Mateus – [Mateus Neves de Matos](https://www.linkedin.com/in/mateus-matos-b4412864/) – mnmatos17@hotmail.com

Distribuído sob a licença MIT License. Veja `LICENSE` para mais informações.