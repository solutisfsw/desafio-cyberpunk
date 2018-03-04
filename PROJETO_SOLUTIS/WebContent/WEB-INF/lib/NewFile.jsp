<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Usando máscaras com jquery</title>
<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript" src="jquery.maskedinput.js"></script>
</head>
<script type="text/javascript">
$(document).ready(function(){
	$("input.data").mask("99/99/9999");
        $("input.cpf").mask("999.999.999-99");
        $("input.cep").mask("99.999-999");
        $("input.placa").mask("aaa-9999");
});
</script>
<body>
<h1>Usando máscaras com jquery</h1>
<label for="data">Data:</label><br>
<input type="text" class="data" id="data" name="data" /><br><br>
 
<label for="cpf">CPF:</label><br>
<input type="text" class="cpf" id="cpf" name="cpf" /><br><br>
 
<label for="cep">CEP:</label><br>
<input type="text" class="cep" id="cep" name="cep" /><br><br>

<label for="placa">PLACA:</label><br>
<input style='text-transform:uppercase' type="text" class="placa" id="cep" name="placa" /><br><br>
 
<p align="center"><a href="http://www.rafaelwendel.com">www.rafaelwendel.com</a></p>
<p align="center">Twitter: <a href="http://www.twitter.com/rafaelwendel">@rafaelwendel</a></p>
</body>
</html>