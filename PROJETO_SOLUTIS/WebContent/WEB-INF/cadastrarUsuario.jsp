<link rel="stylesheet" type="text/css" href="css/cadC.css">

<div class="container">  

  <form id="contact" method="post" action="profissionaisControlador">
    <h3>Cadastro de Profissionais</h3>
    <h4>Nos contrate para uma pesquisa customizada</h4>
    
    <input type=hidden name="idPROFISSIONAL" value="${profissionais.idPROFISSIONAL}">
    <fieldset>
      <input type="text" name="nome" placeholder="Seu Nome" value="${profissionais.nome}">
    </fieldset>
    <fieldset>
      <input type="text" name="area" placeholder="Sua Área" value="${profissionais.area}">
    </fieldset>
    <fieldset>
      <input type="text" name="idade" placeholder="Sua Idade" value="${profissionais.idade}">
    </fieldset>
    <fieldset>
      <input type="text" name="formacao" placeholder="Sua Formação" value="${profissionais.formacao}">
    </fieldset>
    <fieldset>
     <input type="text" name="email" placeholder="Seu Email" value="${profissionais.email}">
    </fieldset>
    <fieldset>
     <input type="password" name="senha" placeholder="Seu Senha" value="${profissionais.senha}">
    </fieldset>
    <fieldset>
      <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Cadastrar</button>
    </fieldset>
    
  </form>
</div>