<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>atualizar</title>

<!-- Bootstrap -->
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<!--Main styles-->
<link rel="stylesheet" type="text/css" href="css/main3.css">
<!--Adaptive styles-->
<link rel="stylesheet" type="text/css" href="css/adaptive.css">
<!--Swipe menu-->
<link rel="stylesheet" type="text/css" href="css/pushy.css">
<!--fonts-->
<link rel="stylesheet" type="text/css" href="css/font-awesome.css">
	<meta name="author" content="pixelhint.com">
	<meta name="description" content="Sublime Stunning free HTML5/CSS3 website template"/>
	<link rel="stylesheet" type="text/css" href="css/reset.css">
	<link rel="stylesheet" type="text/css" href="css/fancybox-thumbs.css">
	<link rel="stylesheet" type="text/css" href="css/fancybox-buttons.css">
	<link rel="stylesheet" type="text/css" href="css/fancybox.css">
	<link rel="stylesheet" type="text/css" href="css/animate.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/fancybox.js"></script>
    <script type="text/javascript" src="js/fancybox-buttons.js"></script>
    <script type="text/javascript" src="js/fancybox-media.js"></script>
    <script type="text/javascript" src="js/fancybox-thumbs.js"></script>
    <script type="text/javascript" src="js/wow.js"></script>
    <script type="text/javascript" src="js/main.js"></script>
     <script type="text/javascript" src="js/numero.js"></script> 
     <script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript" src="jquery.maskedinput.js"></script>
</head>
<script type="text/javascript">
$(document).ready(function(){
        $("input.nome").mask("aaa 9999");
});
</script>
     
</head>
<body onload="initialize()">

<section class="billboard dark">
		
		
		<div class="shadow"></div>
	</section><
<!--navigation swipe-->
<div class="menu-btn">&#9776;</div>
<nav class="pushy pushy-left">
<div class="profile">
<div class="avatar"><img src="img/avatar/ava_16.jpg" alt="#"><span>2b</span></div>

<a href="MENU.jsp" class="log_btn">Menu</a>
</div>

</nav>



<div class="add_place rr" id="autorized">
<div class="place_form login_form">
<i class="fa fa-times close_window" id="closeau"></i>
<h3>Atualize os dados do seu Clone<span></span></h3>
<form id="contact" method="post" action="clonesControlador?action=edic">
<label><input type="hidden" name="idClone" value="${clones.idClone}" ></label>
<label>O NOME DO SEU CLONE NEM O SEU ID PODERÁ SER MODIFICADO 
<input type="text" style='text-transform:uppercase' name="nome" value="${clones.nome})"  class="nome" id="nome" disabled required></label>
<label>Habilidade:<select name="skill" value="${clones.skill}" required>
  <option value="Braço Mecânico" >Braço Mecânico</option>
  <option value="Esqueleto Reforçado" >Esqueleto Reforçado</option>
  <option value="Sentidos Aguçados" >Sentidos Aguçados</option>
   <option value="Hackeamento" >Hackeamento</option>
    <option value="Invisibilidade" >Invisibilidade</option>
     <option value="Velocidade" >Velocidade</option>
      <option value="Visão Noturna" >Visão Noturna</option>
</select> </label>
<label>Idade:<select name="idade" value="${clones.idade}" required>
  <option value="10" >10</option>
  <option value="11" >11</option>
  <option value="12" >12</option>
   <option value="13" >13</option>
    <option value="14" >14</option>
     <option value="15" >15 </option>
      <option value="16" >16 </option>
      <option value="17" >17 </option>
      <option value="18" >18</option>
      <option value="19" >19</option>
      <option value="20" >20</option>
</select> </label>
<label>Data de criação:<input type="date" name="criacao" value="${clones.criacao}"required></label>
<label>Gênero:<select name="genero" value="${clones.genero}" required>
  <option value="Homem" >Homem</option>
  <option value="Mulher" >Mulher</option>
  <option value="Transsexual" >Transsexual</option>
   <option value="Não Definido" >Não quero</option>
</select> </label>
<label>Habilidade Especial:<select name="especial" value="${clones.especial}" required>
  <option value="Raio Lazer" >Raio Lazer</option>
  <option value="Voar" >Voar</option>
  <option value="Super Força" >Super Força</option>
   <option value="A prova de balas" >Prova de balas</option>
</select> </label>
<a><center><button class="btn btn-success" type="submit">Editar Clone</button></center></a>
</form>
</div>
</div>
<script src="js/all_scr.js"></script>



</body>
</html>