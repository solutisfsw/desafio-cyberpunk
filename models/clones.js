var mongoose = require('mongoose');

var CloneSchema = new mongoose.Schema({
  name: String,
  idade: Number,
  data_de_criacao: { type: Date, default: Date.now },
  braco: { type: Boolean, default: false},
  esqueleto: { type: Boolean, default: false},
  sentidos: { type: Boolean, default: false},
  pele: { type: Boolean, default: false},
  raio: { type: Boolean, default: false}
});

module.exports = mongoose.model('Clones', CloneSchema);