# Projeto_Solutis_Wallace_Nery
PROJETO SOLUTIS CLONE - WALLACE NERY

## Instalação
Testado apenas no Windows
```sh
Navegadores testados: Mozilla Firefox e Google Chrome
```
```sh
Instalação do Eclipse EE
Importar o projeto no Eclipse
```
## Configuração
Dentro do Projeto deverá ser adicionado as seguintes configurações:
```sh
Ao adicionar o projeto ao eclipse EE, provavelmente irá ocorrer 2 erros comuns, Versão do Java diferente e o Javax.servlet-api.jar. É
necessário que clique nas propriedades - java build patch - Libraries, nessa opção aparecerá os erros tanto da versão diferente do java, que apenas será necessário selecionar
a versão instalada no pc de teste. O arquivo javax.servlet-api.jar está no seguinte caminho - WEB CONTENT/lib. após adicionar o projeto estará quase funcionando.
```
```sh
se arquivos como por exemplo mysql-connector-java-5.1.27-bin estiverem dando erro ou jstl, eles estarão na pasta WEB-INF/lib
```
```sh
Eu fiz questão de adicionar ao projeto o Apache Tomcat 9, para auxiliar quem for testar. Caso precise quebrar um galho :v.
```
```sh
A próxima configuração é ir no caminho java Resources/src/dao. No dao, será encontrado um simples banco de dados(SOLUTIS.sql), que será necessário para o funcionamento do banco e da aplicação, então é apenas necessário copiar o codigo, colar e executar no MySQL workbench.
```
```sh
Última instrução - Também dentro do dao tem um arquivo chamado "ConexaoSingleton", este está configurado com a senha e usuário do meu banco,
então é necessário ir no seu pequeno código, este: 
try{
		 	Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SOLUTIS",
					"root", "root");
			System.out.println("Banco Conectado com sucesso!");
      
      NA PARTE QUE TEM "root"(nome do banco) - "root" (senha do banco) alterar respectivamente.
```
```sh
Após estes passos, MYSQL devidamente configurado, Apache também. A Aplicação pode ser executada. (Aproveitem as referências :v)
```
## Meta
Wallace Nery de Brito Passos – jellnery123@hotmail.com

