var express=require('../config/custom-express')();
var request=require('supertest')(express);
describe('#ClonesController',function() {
  it('#listagem json',function(done) {
    request.get('/clones').set('Accept','application/json')
    .expect('Content-Type',/json/).expect(200,done);
  });
  it('#cadastro de clone com dados invalidos',function(done) {
    request.post('/clones/clone').set({nome:"",idade:"25j",adicionais:"braço mecanico"})
    .expect(400,done);
  });
  it('#cadastro de clone com dados validos',function(done) {
    request.post('/clones/clone').set({nome:"zack3",idade:"25",adicionais:"braço mecanico"})
    .expect(201,done);
  });
  it('#consulta de clone',function(done) {
    request.get('/clones/clone/0').set('Accept','application/json').expect('Content-Type',/json/)
    .expect(200,done);
  });
  it('#alteração de clone com dados invalidos',function(done) {
    request.put('/clones/clone/0').set({nome:"alisson",idade:"c",adicionais:"braço mecanico"}).expect(400,done);
  });
  it('#alteração de clone com dados validos',function(done) {
    request.put('/clones/clone/0').set({nome:"alisson",idade:"30",adicionais:"braço mecanico"}).expect('Content-Type',/json/)
    .expect(200,done);
  });
  it('#exclusão de clone',function(done) {
    request.delete('/clones/clone/0').expect(204,done);
  });
});
