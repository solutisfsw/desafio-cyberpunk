$(document).ready(function(){
	'use strict';

	function getIdPage() {
		var baseUrl = (window.location).href;
		var Id = baseUrl.substring(baseUrl.lastIndexOf('?') + 1);
		return Id;
	}

	$('.btn-danger').on('click', function() {
	  $.ajax({ url: '/clone/'+ $(this).attr('data-val'), method: 'DELETE' })
	    .done(function() { location.href = '/' });
	});

	$('.edit').on('click', function(e) {
	  e.preventDefault();
	  const form = document.getElementById('edit-form');

	  const acessorios = [];
	  
	  for(let i=0; i<5; i++){
	  	form.acessorios[i].checked && acessorios.push(form.acessorios[i].value);
	  }
	  $.ajax({ 
	  	url: '/clone/'+ $(this).attr('data-val'),
	  	method: 'PUT', 
	  	data: {
	  		nome: form.inputNome.value,
	  		idade: form.inputIdade.value,
	  		acessorios: acessorios,
	  	}
	  })
	    .done(function() { location.href = '/' });
	});

});