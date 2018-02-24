process.env.NODE_ENV = 'test'

const chai = require('chai')
const chaiHttp = require('chai-http')
var server = require('../config/server')
var should = chai.should()

chai.use(chaiHttp)

//Aqui é o bloco principal que executará o nossos testes:
describe('Clones', () => {
    /**
     * Teste da rota: /GET
     */
    describe('/GET clones', function () {
        it('Deve retornar todos os clones ou vazio', function (done) {
            chai.request(server)
                .get('/clones')
                .end(function (error, res) {
                    res.should.have.status(200)
                    res.body.should.be.a('array')
                    res.body.length.should.be.eql(0)
                    done()
                })
        })
    })

    describe('/POST clone', function () {
        it('Deve cadastrar um clone sem erros', function (done) {
            var clone = {
                nome: 'TOZ0099',
                idade: 20,
                dataCriacao: new Date(),
                adicionais: ['braço mecânico', 'esqueleto', 'sentidos aguçados', 'pele adaptativa', 'raio laser']
            }
            chai.request(server)
                .post('/clone')
                .send(clone)
                .end( function(error, res) {
                    res.should.have.status(200)
                    res.body.should.be.a('object')
                    done()
                })
        })
    })

    describe('/POST clone', function () {
        it('NÃO Deve cadastrar um clone, nome inválido', function (done) {
            var clone = {
                nome: 'Maria Silva',
                idade: 20,
                dataCriacao: new Date(),
                adicionais: ['braço mecânico', 'esqueleto', 'sentidos aguçados', 'pele adaptativa', 'raio laser']
            }
            chai.request(server)
                .post('/clone')
                .send(clone)
                .end( function(error, res) {
                    res.should.have.status(200)
                    res.body.should.be.a('object')
                    done()
                })
        })
    })
})   