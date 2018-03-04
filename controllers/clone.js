module.exports=function(app) {
  app.post("/clones/clone",function(req,res) {
      var dados=req.body;
      var validacao=new app.validação.validaClone(req);
      var erro=validacao.validar();
      if(erro){
        res.status(400).send(erro);
        return;
      }
      var cloneCadastrado=app.persistencia.clones.inserir(dados);
      if (!cloneCadastrado) {
          var erro={
            erro:"nome ja existente no banco de dados",
            msg:"clone não foi cadastrado no sistema"
          };
          res.status(500).send(erro);
          return;
      }else {
        var dadosDoCadastro={
                                  dados_do_clone:cloneCadastrado,
                                  links:[
                                      {
                                          href:'/clones',
                                          rel:'listar',
                                          method:"GET"
                                      },
                                      {
                                          href:'/clones/clone/'+cloneCadastrado.id,
                                          rel:'excluir',
                                          method:"DELETE"
                                      },
                                      {
                                          href:'/clones/clone/'+cloneCadastrado.id,
                                          rel:'consultar',
                                          method:"GET"
                                      },
                                      {
                                          href:'/clones/clone/'+cloneCadastrado.id,
                                          rel:'alterar',
                                          method:"PUT"
                                      }
                                  ]
                              };
              res.location('/clones/clone/'+cloneCadastrado.id);
              res.status(201).send(dadosDoCadastro);
      }
  });
  app.get("/clones",function(req,res) {
      var listaClones=app.persistencia.clones.listar();
      res.status(200).send(listaClones);
  });
  app.get("/clones/clone/:id",function(req,res) {
      var id=req.params.id;
      var cloneCadastrado=app.persistencia.clones.consultar(id);
      if(!cloneCadastrado){
        var erro={
          erro:"clone não cadastrado no sistema",
          msg:"clone não encontrado"
        };
        res.status(500).send(erro);
        return;
      }
      res.status(200).send(cloneCadastrado);
  });
  app.delete("/clones/clone/:id",function(req,res) {
      var id=req.params.id;
      var cloneDeletado=app.persistencia.clones.deletar(id);
      if(!cloneDeletado){
        var erro={
          erro:"clone não cadastrado no sistema",
          msg:"clone não encontrado e não deletado"
        };
        res.status(500).send(erro);
        return;
      }
      res.status(204).json();
  });
  app.put("/clones/clone/:id",function(req,res) {
      var dados=req.body;
      var id=req.params.id;
      var validacao=new app.validação.validaClone(req);
      var erroValidacao=validacao.validar();
      if(erroValidacao){
        res.status(400).send(erroValidacao);
        return;
      }
      var cloneAlterado=app.persistencia.clones.alterar(id,dados);
      if(!cloneAlterado){
        var erro={
          erro:"clone não cadastrado no sistema ou nome ja existente no banco de dados",
          msg:"clone não encontrado e não alterado"
        };
        res.status(500).send(erro);
        return;
      }
      res.status(200).send(cloneAlterado);
  });
}
