
const mongoose = require('mongoose')
const Schema =  mongoose.Schema



const cloneSchema = new Schema({
    nome: String,
    idade: Number,
    adcionais: String,
    data: String
});

module.exports = mongoose.model('clone-BD', cloneSchema)