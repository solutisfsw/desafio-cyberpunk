var express = require('express');
var path = require('path');
var favicon = require('serve-favicon');
var logger = require('morgan');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');
var index = require('./routes/index');
var users = require('./routes/users');
var app = express();
const mysql = require('mysql');



// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'pug');

// uncomment after placing your favicon in /public
//app.use(favicon(path.join(__dirname, 'public', 'favicon.ico')));
app.use(logger('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

app.use('/', index);
app.use('/users', users);

// definindo as rotas
const router = express.Router();
router.get('/', (req, res) => res.json({ message: 'API funcionando!' }));
app.use('/', router);
// Metodo que lista todos os clones ou um clone especifico passando seu ID pela URL.
router.get('/clones/:id?', (req, res) =>{
    let filter = '';
    if(req.params.id) filter = ' and clo_id=' + parseInt(req.params.id);
    execSQLQuery('select clo_id, clo_nome, clo_idade, created_at from clones where deleted_at is null' + filter, res.status(200));
});
// Metodo para deletar um clone passando seu ID pela URL.
router.delete('/clones/:id', (req, res) =>{
    execSQLQuery('delete from clones where clo_id=' + parseInt(req.params.id), res.json({ response: 'Clone deletado com sucesso!'}));
});
// Metodo para inserir um clone no sistema.
router.post('/clones', (req, res) => {
    const nome = req.body.nome.substring(0, 7);
    const idade = req.body.idade.substring(0, 2);
    execSQLQuery(`insert into clones(clo_nome, clo_idade, created_at) VALUES('${nome}','${idade}', now())`, res.json({ response: 'Clone adicionado com sucesso!'}));
});
// Metodo para atualizar um clone no sistema passando seu ID pela URL.
router.put('/clones/:id', (req, res) => {
    const id = parseInt(req.params.id);
    const nome = req.body.nome.substring(0, 7);
    const idade = req.body.idade.substring(0, 2);
    execSQLQuery(`update clones set clo_nome='${nome}', clo_idade='${idade}', updated_at=now() where clo_id=${id}`, res.json({ response: 'Clone atualizado com sucesso!'}));
});
// Metodo para inserir uma habilidades no sistema.
router.post('/habilidades', (req, res) => {
    const clone = parseInt(req.body.clone.substring(0, 7));
    const add = parseInt(req.body.add.substring(0, 2));
    execSQLQuery(`insert into melhorias(clo_id, add_id, created_at) VALUES('${clone}','${add}', now())`, res.json({ response: 'Habilidade adicionada com sucesso!'}));
});

// inicia o servidor
console.log('API funcionando!');

function execSQLQuery(sqlQry, res) {
    const connection = mysql.createConnection({
        host: 'localhost',
        port: 3306,
        user: 'root',
        password: '',
        database: 'crud_solutis'
    });
    
    connection.query(sqlQry, function(error, results, fields) {
        if(error) {
            res.json(error);
        }else {
            res.json(results);
            connection.end();
            console.log('Executou!');
        }
    });
}

// catch 404 and forward to error handler
app.use(function(req, res, next) {
  var err = new Error('Not Found');
  err.status = 404;
  next(err);
});

// error handler
app.use(function(err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render('error');
});

module.exports = app;
