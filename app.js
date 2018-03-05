const express = require('express')
const pug = require('pug');
const mongoose = require('mongoose');
const path = require('path')
const index = require('./routes/index');
const bodyParser = require('body-parser')

//const mongoDB = 'mongodb://127.0.0.1/crones';
const mongoDB = "mongodb://heroku_k3pmt2zh:rodomunfr47qb0lani3sk6v5m0@ds155268.mlab.com:55268/heroku_k3pmt2zh"
mongoose.connect(mongoDB);
mongoose.Promise = global.Promise;
const db = mongoose.connection;
db.on('error', console.error.bind(console, 'MongoDB connection error:'));

const PORT = process.env.PORT || 3003
const app = express()

app.use(bodyParser.urlencoded({ extended: true }))
app.use(bodyParser.json())

app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'pug')

app.use('/', index);

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
  res.send(res.locals.message);
});

module.exports = app;

app.listen(PORT, () => console.log('Crones listening on port 3000!'))