const express = require('express')
const consign = require('consign')
const bodyParser = require('body-parser')
const expressValidator = require('express-validator')

const app = express()

/* configurar o middleware body-parser */
app.use(bodyParser.urlencoded({extended: true}))
app.use(bodyParser.json())//para aceitar dados via json

/* configurar o middleware express-validator */
app.use(expressValidator())

/* efetua o autoload das rota(s) e do(s) model(s) para o objeto app */
consign()
    .include('app/routes')
    .then('app/models')
    .into(app)

/* middlaware que configura página de status*/
app.use(function (req, res, next) {
	res.status(404).send('Á página não foi encontrada. Verifique a url!');
	next();
})

/* middlaware que configura msgs de erro interno */
app.use(function (err, req, res, next) {
	res.status(500).send('Desculpe, houve um erro interno na aplicação.');
	next();
})

module.exports = app