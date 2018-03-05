  //Variável para nos ajudar no update de registros
  var posicaoObjetoNaLista;

  //Variável para  nos ajudar na exibição das imagens do perfil e poderes do clone em que o mouse está em cima
  var objetoClone;

  //Lista de Clones
  var listaClones = new Array();

  var app = new function() {


    this.el = document.getElementById('listaClones');
    var tbody = document.getElementById('listaClones');

    //Contador
    this.Count = function(data) {
      var el   = document.getElementById('counter');
      var name = 'CLONE';
      if (data) {
        if (data > 1) {
          name = 'CLONES';
        }
        el.innerHTML = data + ' ' + name ;
      } else {
        el.innerHTML = 'NENHUM ' + name;
      }
    };
    
    this.FetchAll = function() {

      var data = '';
      if (listaClones.length > 0) {
        for (i = 0; i < listaClones.length; i++) {


          objetoClone = listaClones[i];

          data += '<tr onmouseover="over(' + objetoClone.poderBraco + ',' + objetoClone.poderEsqueleto + ',' + objetoClone.poderSentido + ',' + objetoClone.poderPele + ',' + objetoClone.poderRaio + ')"';


          data += ' onmouseout="out(this)">';
          data += '<th scope="row">' + (i+1) + '</th>';
          //data += '<td>' + this.countries[i] + '</td>';
          data += '<td>' + listaClones[i].nome + '</td>';
          data += '<td>' + listaClones[i].idade + '</td>';
          data += '<td>' + listaClones[i].dtCriacao + '</td>';

          data += '<td style="text-align: center;">';

          if (listaClones[i].poderBraco){
            data += '<div style="display: flex;"><div style="width: 40px; height: 40px;"><img  title="Braço Mecânico" style="width: 76%; padding: 3px;" src="poder_braco.png"></div>';
          }
          if (listaClones[i].poderEsqueleto){
            data += '<div style="display: flex;"><div style="width: 40px; height: 40px;"><img  title="Esqueleto Reforçado" style="width: 76%; padding: 3px;" src="poder_esqueleto.png"></div>';
          }
          if (listaClones[i].poderSentido){
            data += '<div style="display: flex;"><div style="width: 40px; height: 40px;"><img  title="Sentidos Apurados" style="width: 76%; padding: 3px;" src="poder_sentido.png"></div>';
          }
          if (listaClones[i].poderPele){
            data += '<div style="display: flex;"><div style="width: 40px; height: 40px;"><img  title="Pele Adaptativa" style="width: 76%; padding: 3px;" src="poder_sentido.png"></div>';
          }
          if (listaClones[i].poderRaio){
            data += '<div style="display: flex;"><div style="width: 40px; height: 40px;"><img  title="Raio Laser" style="width: 76%; padding: 3px;" src="poder_laser.png"></div>';
          }
          data += '</row></div></td>';


          data += '<td><button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal02" onclick="app.Edit(' + i + ')">Editar</button>' + '<button class="btn btn-default" onclick="app.Delete(' + i + ')">Delete</button>' + '</td>';
          data += '</tr>';

        }
      }
      this.Count(listaClones.length);
      tbody.innerHTML = data;
 
    };


    this.getDataAtual = function(){
      now = new Date();
      dataAtual = ( now.getDate() + "/" + (now.getMonth() +1) + "/" + now.getFullYear() );
      el3 = document.getElementById('add-dtCriacao');
      el3.value = dataAtual;
    }

    this.Add = function () {
      el = document.getElementById('add-name');
      el2 = document.getElementById('add-idade');

      el4 = document.getElementById('add-poder-braco');
      el5 = document.getElementById('add-poder-esqueleto');
      el6 = document.getElementById('add-poder-sentido');
      el7 = document.getElementById('add-poder-pele');
      el8 = document.getElementById('add-poder-laser');

      // Get the value
      var clone = new Clone(el.value, el2.value, dataAtual, el4.value, el5.value, el6.value, el7.value, el8.value);

      if (clone.nome.length > 0) {
        addListaClones(clone);

        // Reset input value
        el.value = '';
        // Dislay the new list
        this.FetchAll();
      }

    };

    this.Edit = function (item) {

      posicaoObjetoNaLista = listaClones.indexOf(listaClones[item]);

      var el  = document.getElementById('edit-name');
      var el2 = document.getElementById('edit-idade');
      var el3 = document.getElementById('edit-dtCriacao');
      var el4 = document.getElementById('edit-poder-braco');
      var el5 = document.getElementById('edit-poder-esqueleto');
      var el6 = document.getElementById('edit-poder-sentido');
      var el7 = document.getElementById('edit-poder-pele');
      var el8 = document.getElementById('edit-poder-laser');


      // Display value in the field
      el.value = listaClones[item].nome;
      el2.value = listaClones[item].idade;
      el3.value = listaClones[item].dtCriacao;

      // Display fields
      document.getElementById('spoiler').style.display = 'block';
      self = this;
      document.getElementById('saveEdit').onsubmit = function() {   //The onsubmit event occurs when a form is submitted.
        // Get value
        var country = el.value;
        if (country) {

          // Display the new list
          self.FetchAll();
          // Hide fields
          CloseInput();
        }
      }
    };


    this.update = function() {
      
      var el  = document.getElementById('edit-name').value;
      var el2 = document.getElementById('edit-idade').value;
      var el3 = document.getElementById('edit-dtCriacao').value;

      listaClones[posicaoObjetoNaLista].nome = el;
      listaClones[posicaoObjetoNaLista].idade = el2;
      listaClones[posicaoObjetoNaLista].dtCriacao = el3;

      $('.close').click();

      // Dislay the new list
      this.FetchAll();
    }


    this.Delete = function (item) {
      // Delete the current row 
      listaClones.splice(listaClones.indexOf(listaClones[item]), 1);
      //The splice() method adds/removes items to/from an array, and returns the removed item(s).

      // Display the new list
      this.FetchAll();
    };
    
  }
  app.FetchAll();

  function CloseInput() {
    document.getElementById('spoiler').style.display = 'none';
  }

  function over(imgBraco, imgEsqueleto, imgSentido, imgPele, imgRaio){
    
    var imgPerfil = document.getElementById('imgDetalhe');

    //Passando para o painel de exibição a imagem de perfil do clone que está localizado embaixo do cursor do mouse
    if (imgBraco == true){
      imgPerfil.src = "poder_braco.gif";
    }

    else if (imgEsqueleto == true){
      imgPerfil.src = "poder_esqueleto.gif";
    }
    else if (imgSentido == true){
      imgPerfil.src = "poder_laser.gif";
    }
    else if (imgPele == true){
      imgPerfil.src = "poder_pele.gif";
    }
    else if (imgRaio == true){
      imgPerfil.src = "poder_laser.gif";
    }
    else {
      imgPerfil.src = "not_found_quadrado.gif";
    }


    //Passando para o painel de exibição dos poderes os respectivos poderes do clone que está localizado embaixo do curso do mouse
    //Braço
    var imgPainelBraco = document.getElementById('imgPainelBraco');
    if (imgBraco == true){
      imgPainelBraco.src = "poder_braco.gif";
    }
    else {
      imgPainelBraco.src = "not_found_quadrado.gif";
    }
    //Esqueleto
    var imgPainelEsqueleto = document.getElementById('imgPainelEsqueleto');
    if (imgEsqueleto == true){
      imgPainelEsqueleto.src = "poder_esqueleto.gif";
    }
    else {
      imgPainelEsqueleto.src = "not_found_quadrado.gif";
    }
    //Sentido
    var imgPainelSentido = document.getElementById('imgPainelSentido');
    if (imgSentido == true){
      imgPainelSentido.src = "poder_laser.gif";
    }
    else {
      imgPainelSentido.src = "not_found_quadrado.gif";
    }
    //Pele
    var imgPainelPele = document.getElementById('imgPainelPele');
    if (imgPele == true){
      imgPainelPele.src = "poder_pele.gif";
    }
    else {
      imgPainelPele.src = "not_found_quadrado.gif";
    }
    //Raio Laser
    var imgPainelRaio = document.getElementById('imgPainelRaio');
    if (imgRaio == true){
      imgPainelRaio.src = "poder_laser.gif";
    }
    else {
      imgPainelRaio.src = "not_found_quadrado.gif";
    }


    //Preenchendo Peso, Foco/Atenção, Cor de Pele e Cor dos Olhos do clone:
    //Peso
    var peso = 70;
    var textoPeso = document.getElementById('descricaoPeso');
    if (imgBraco) {
      peso += 15;
    }
    if (imgEsqueleto) {
      peso += 40;
    }
    textoPeso.innerHTML = 'Peso: ' + peso + 'kg';
    //Foco/Atenção:
    var textoFoco = document.getElementById('descricaoFoco');
    if(imgSentido){
      textoFoco.innerHTML = 'Foco/Atenção: Alto';
    }
    else {
      textoFoco.innerHTML = 'Foco/Atenção: Médio';  
    }
    //Cor de Pele
    var textoPele = document.getElementById('descricaoPele');
    if(imgPele){
      textoPele.innerHTML = 'Cor de Pele: Metálico';
    }
    else {
      textoPele.innerHTML = 'Cor de Pele: Caucasiano';  
    }
    //Cor dos Olhos
    var textoRaio = document.getElementById('descricaoOlho');
    if(imgRaio){
      textoRaio.innerHTML = 'Cor dos Olhos: Vermelhos';
    }
    else {
      textoRaio.innerHTML = 'Cor dos Olhos: Castanhos';  
    }



  }


  function out(that){
    var imagem = document.getElementById('imgDetalhe');
    if (imagem.src != "") {
    var imagem = document.getElementById('imgDetalhe');
    imagem.src = "not_found_quadrado.gif";

    var imgPainelBraco = document.getElementById('imgPainelBraco');
    imgPainelBraco.src = "not_found_quadrado.gif";

    var imgPainelEsqueleto = document.getElementById('imgPainelEsqueleto');
    imgPainelEsqueleto.src = "not_found_quadrado.gif";

    var imgPainelSentido = document.getElementById('imgPainelSentido');
    imgPainelSentido.src = "not_found_quadrado.gif";

    var imgPainelPele = document.getElementById('imgPainelPele');
    imgPainelPele.src = "not_found_quadrado.gif";

    var imgPainelRaio = document.getElementById('imgPainelRaio');
    imgPainelRaio.src = "not_found_quadrado.gif";

    var textoNome = document.getElementById('descricaoNome');
    textoNome.innerHTML = 'CLONE:';

    var textoPeso = document.getElementById('descricaoPeso');
    textoPeso.innerHTML = 'Peso:';

    var textoFoco = document.getElementById('descricaoFoco');
    textoFoco.innerHTML = 'Foco/Atenção:';

    var textoPele = document.getElementById('descricaoPele');
    textoPele.innerHTML = 'Cor de Pele:';

    var textoOlho = document.getElementById('descricaoOlho');
    textoOlho.innerHTML = 'Cor dos Olhos:'


  }

}



  //Construtor de objetos Clone
  function Clone(nome, idade, dtCriacao, poderBraco, poderEsqueleto, poderSentido, poderPele, poderRaio){
    this.nome = nome;
    this.idade = idade;
    this.dtCriacao = dtCriacao;
    this.poderBraco = document.querySelector('#add-poder-braco').checked;
    this.poderEsqueleto = document.querySelector('#add-poder-esqueleto').checked;
    this.poderSentido = document.querySelector('#add-poder-sentido').checked;
    this.poderPele = document.querySelector('#add-poder-pele').checked;
    this.poderRaio = document.querySelector('#add-poder-laser').checked;
  }

  //
  function addListaClones(clone){
    listaClones.push(clone);
  }
 
