var mongoose = require('mongoose');

var Schema = mongoose.Schema;

var CloneSchema = new Schema({
	//id: { type: Number, unique: true, index:true },
    name: { type: String, match: /[A-Z]{3}[0-9]{4}/, required: true, unique: true, index:true },
    age: { type: Number, min: 10, max: 20, required: true },
    creationDate: { type: Date, default: Date.now},
    arms: { type: Number, default: 0 },
    skeleton: { type: Number, default: 0 }, 
    senses: { type: Number, default: 0 }, 
    skin: { type: Number, default: 0 }, 
    laser: { type: Number, default: 0 }, 
});

CloneSchema
.virtual('editURL')
.get(function () {
  return "/clones/" + this.name;
});

CloneSchema
.virtual('deleteURL')
.get(function () {
  return "../delete/" + this.name;
});

module.exports = mongoose.model('Clone', CloneSchema );