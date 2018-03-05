const mongoose = require('mongoose');
const chai = require('chai');
const chaiHttp = require('chai-http');

const server = require('../index');

const should = chai.should();
chai.use(chaiHttp);
 
//Aqui é o bloco principal que executará o nossos testes:
describe('clone', function() {
    afterEach(function(done) {    });

    describe('/GET clone', function() {
    it('Deve retornar todos os clones', function(done) {
        chai.request(server)
        .get('/clone')
        .end(function(error, res) {
            //Se tudo der certo deve retornar o status: 200 - OK
            res.should.have.status(200);
            //E em seguida retornar em um array todos os livros cadastrados na base de dados:
            res.body.should.be.a('obj');
            res.body.length.should.be.eql(0);
        done();
        });
    });
}); 

/**
 * Teste da rota: /GET
 */
