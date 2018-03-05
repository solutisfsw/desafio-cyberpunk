const express = require('express');
const bodyParser = require("body-parser");
const db = require('./db');
const app = express();
const path = require('path');
const port = process.env.PORT || 3000;

app.use(express.static('views'));

app.set('view engine', 'ejs');
app.engine('html', require('ejs').renderFile);

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

db.connectDB();

const CloneDAO = require('./src/clone-dao');

//Main route
app.get('/',async function(req,res, next){
  const clones = await CloneDAO.all();
  res.render('home', { 'cloneList': clones });
});

//Rota cadastro
app.get('/cadastro', function(req,res, next){
  res.render('cadastro');
});

//Get clone by ID
app.get('/clone/:id/edit', async function(req,res,next){
    const clone = await CloneDAO.findById(req.params.id);
    res.render('cadastro', clone);
});

//Create Clone
app.post('/clone', async function (req, res) {
    console.log(req.body);
    const clone = {
      nome : req.body.inputNome,
      idade : req.body.inputIdade,
      acessorios : req.body.acessorios
    }
    await CloneDAO.create(clone) ? res.redirect('/') : res.send('erro');
});

/* Delete clone. */
app.delete('/clone/:id', async function (req, res, next) {
    await CloneDAO.deleteById(req.params.id);
    res.send('ok');
});

/* Edit clone. */
app.put('/clone/:id', async function (req, res, next) {   
    await CloneDAO.update(req.params.id, req.body);
    res.send('ok');
});

app.listen(port, () => {
  console.log(`Rodando em: http://localhost:${port}`);
});
