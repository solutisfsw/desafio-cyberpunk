const test = require('tape')
const supertest = require('supertest')
const app = require('./app')

test('POST /clones [ Nome: FAU1234  Idade: 25 ]', (t) => {
    supertest(app)
      .post('/clones/')
      .send({name: "FAU1234", age: "25"})
      .end((err, res) =>{
        t.error(err, 'Sem erros')
        t.assert(res.body[0].msg === "Idade do Clone invalida", "Clone com idade invalida (não cadastrado)")
        t.end()  
      })
})

/* Teste com erros
test('POST /clones [ Nome: FBC1234  Idade: 15 ]', (t) => {
    supertest(app)
      .post('/clones/')
      .send({name: "FBC1234", age: "15"})
      .end((err, res) =>{
        t.error(err, 'Sem erros')
		t.assert((Object.keys(res.body).length === 0 && res.body.constructor === Object) == true, "Clone Cadastrado com Sucesso")
        t.end()  
      })
})
*/

test('PUT /clones/XAU1234 [ Nome: XAU1234 Idade: 12 ]', (t) => {
	supertest(app)
		.put('/clones/XAU1234')
		.send({name: "XAU1234", age: "12"})
		.end((err, res) =>{
			t.error(err, 'Sem erros')
			t.assert((Object.keys(res.body).length === 0 && res.body.constructor === Object) == true, "Clone Inexistente Criado")
			//t.assert(res.body != "X atualizado com sucesso", "Clone Inexistente Criado")
			t.end()  
		})
})