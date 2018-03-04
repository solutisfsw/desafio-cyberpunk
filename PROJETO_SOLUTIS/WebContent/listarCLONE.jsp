<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar todos os CLONES</title>
</head>
<body>
<section>
<TABLE BORDER="1" BORDERCOLOR="#ffffff" width=70% height=30% BGCOLOR="#CAFF70">
	     <tr> 
	     <center>
	     <th>ID</th> 
		 <th>NOME</th>  
		 <th>skill</th> 
		 <th>IDADE</th>
		 <th>criacao</th>
		 <th>genero</th>
		 <th>especial</th>
		 
		 
	<c:forEach items="${clones}" var="clones">
	<tr>
		 <td><center> <c:out value="${clones.idClone}" /></td>
         <td><center> <c:out value="${clones.nome}" /></td>
         <td><center> <c:out value="${clones.skill}" /></td>
         <td><center> <c:out value="${clones.idade}" /></td>
         <td><center> <c:out value="${clones.criacao}" /></td>
         <td><center> <c:out value="${clones.genero}" /></td>
         <td><center> <c:out value="${clones.especial}" /></td>
         

         
          
	     <td><center> 
	     	<a href="clonesControlador?action=edit&idClone=${clones.idClone}">Editar</a>
	     	<a href="clonesControlador?action=delete&idClone=${clones.idClone}">Excluir</a>
	     	
	     </td></tr>
	</c:forEach>
	
</table>
</section>
<a href="MENU.jsp">VOLTAR AO MENU</a>
<a href="listarCLONE2.jsp">Busca com Filtros</a>
</body>
</html>