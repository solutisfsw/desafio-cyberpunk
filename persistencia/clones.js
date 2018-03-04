module.exports=function() {
  var clones={
      listaDeClones:[],
      inserir:function(clone){
        clone.criado=new Date;
        clone.id=this.listaDeClones.length;
        for(var i=0; i<this.listaDeClones.length; i++) {
          if(this.listaDeClones[i].nome == clone.nome) {
              return false;
          }
        }
        this.listaDeClones.push(clone);
        return clone;
      },
      listar:function() {
        return this.listaDeClones;
      },
      consultar:function(id) {
        for(var i=0; i<this.listaDeClones.length; i++) {
          if(this.listaDeClones[i].id == id) {
              return this.listaDeClones[i];
          }
        }
        return false;
      },
      deletar:function(id) {
        for(var i=0; i<this.listaDeClones.length; i++) {
          if(this.listaDeClones[i].id == id) {
              return this.listaDeClones.splice(i,1);
          }
        }
        return false;
      },
      alterar:function(id,clone) {
        for(var i=0; i<this.listaDeClones.length; i++) {
          if(this.listaDeClones[i].nome == clone.nome && id!=this.listaDeClones[i].id) {
              return false;
          }
        }
        var cloneParaAlterar=this.consultar(id);
        if(cloneParaAlterar){
          cloneParaAlterar.nome=clone.nome;
          cloneParaAlterar.idade=clone.idade;
          cloneParaAlterar.adicionais=clone.adicionais;
          return cloneParaAlterar;
        }
        return false;
      }
    }
    return clones;
}
