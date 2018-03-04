module.exports=function() {
  return validaClone;
}
function validaClone(req) {
  this.req=req;
}
validaClone.prototype.validar=function() {
  this.req.assert('nome',"nome e obrigatorio").notEmpty();
  this.req.assert("idade","idade e obrigatorio e deve ser um decimal").notEmpty().toInt();
  return this.req.validationErrors();
}
