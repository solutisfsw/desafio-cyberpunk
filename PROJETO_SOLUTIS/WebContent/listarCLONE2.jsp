<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>LISTA</title>
<!-- Bootstrap -->
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<!--Main styles-->
<link rel="stylesheet" type="text/css" href="css/main4.css">
<!--Adaptive styles-->
<link rel="stylesheet" type="text/css" href="css/adaptive.css">
<!--Swipe menu-->
<link rel="stylesheet" type="text/css" href="css/pushy.css">
<!--fonts-->
<link rel="stylesheet" type="text/css" href="css/font-awesome.css">
	<meta name="author" content="pixelhint.com">
	
	 <script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript" src="jquery.maskedinput.js"></script>
	
	<script type="text/javascript">
$(document).ready(function(){	
        $("input.nome").mask("aaa 9999");
});
</script>
	
	
</head>
<body>
<form id="contact" method="post" action="clonesControlador?action=port">
<label>FILTRO DE PESQUISA DO SEU ROBÔ</label>
<p></p>
<p></p>
<label> Nome
<input type="text" style='text-transform:uppercase' name="nome" value=""  class="nome" id="nome"></label><p></p>
<label> Habilidade:<select name="skill">
<option value="" >Não Selecionado</option>
  <option value="Braço Mecânico" >Braço Mecânico</option>
  <option value="Esqueleto Reforçado" >Esqueleto Reforçado</option>
  <option value="Sentidos Aguçados" >Sentidos Aguçados</option>
   <option value="Hackeamento" >Hackeamento</option>
    <option value="Invisibilidade" >Invisibilidade</option>
     <option value="Velocidade" >Velocidade</option>
      <option value="Visão Noturna" >Visão Noturna</option>
</select> </label><p></p>
<label> Idade:<select name="idade" >
<option value="" >Não Selecionado</option>
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
</select> </label><p></p>
<label> Data de criação:<input type="date" name="criacao" value=""></label><p></p>
<label> Gênero:<select name="genero" >
<option value="" >Não Selecionado</option>
  <option value="Homem" >Homem</option>
  <option value="Mulher" >Mulher</option>
  <option value="Transsexual" >Transsexual</option>
   <option value="Não Definido" >Não quero</option>
</select> </label><p></p>
<label> Habilidade Especial:<select name="especial" >
<option value="" >Não Selecionado</option>
<option value="Raio Lazer" >Raio Lazer</option>
  <option value="Voar" >Voar</option>
  <option value="Super Força" >Super Força</option>
   <option value="A prova de balas" >Prova de balas</option>
</select> </label><p></p>
<label>ID:<input type="text" name="idClone" value="" ></label>
<label><button class="btn btn-success" type="submit">Pesquisar</button></label>
</form>

<section>
<TABLE  BORDER="4" BORDERCOLOR="#100c08" width=80% height=40% BGCOLOR="#100c08">
	     <tr> 
	     <center>
	     <th>ID</th> 
		 <th>NOME</th>  
		 <th>Skill</th>
		 <th>IDADE</th> 
		 <th>CRIACAO</th>  
		 <th>GENERO</th>
		  <th>ESPECIAL</th>
		 
		 
		 
	<c:forEach items="${clones}" var="clones">
	<tr>
		 <td BGCOLOR="#ffffff"><center> <c:out value="${clones.idClone}" /></td>
         <td BGCOLOR="#ffffff"><center> <c:out value="${clones.nome}" /></td>
         <td BGCOLOR="#ffffff"><center> <c:out value="${clones.skill}" /></td>
         <td BGCOLOR="#ffffff"><center> <c:out value="${clones.idade}" /></td>
         <td BGCOLOR="#ffffff"><center> <c:out value="${clones.criacao}" /></td>
         <td BGCOLOR="#ffffff"><center> <c:out value="${clones.genero}" /></td>
        <td BGCOLOR="#ffffff"><center> <c:out value="${clones.especial}" /></td>
         

         
          
	     <td BGCOLOR="#ffffff"><center> 
	     	<a href="clonesControlador?action=edit&idClone=${clones.idClone}">Editar</a>
	     	<a href="clonesControlador?action=delete&idClone=${clones.idClone}">Excluir</a>
	    
	     	
	     </td></tr>
	</c:forEach>
	<a BGCOLOR="#000000" href="MENU.jsp">MENU PRINCIPAL</a><p></p>
<a href="clonesControlador?action=listou">TODOS OS CLONES</a>
</table>

</section>








</body>
</html>
