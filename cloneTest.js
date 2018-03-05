

process.env.NODE_ENV = 'test';
 

var mongoose = require('mongoose');
var clone = require('./servidor');

var chai = require('chai');
//var chaiHttp = require('chai-http');
var server = require('./servidor');
var should = chai.should();




    describe('/GET clone', function() {
        it('Deve retornar todos os clones', function(done) {
            chai.request(server)
            app.get('/clones')
            .end(function(error, res) {
                //Se tudo der certo deve retornar o status: 200 - OK
                res.should.have.status(200);
                //E em seguida retornar em um array todos os livros cadastrados na base de dados:
                res.body.should.be.a('array');
                res.body.length.should.be.eql(0);
            done();
            })
        })
    })









