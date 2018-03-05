const mongoose = require('mongoose');
const assureConnection = require('../db').assureConnection;

class CloneDAO {
	constructor() {
		this.model = mongoose.model('Clone' , new mongoose.Schema({
			nome: String,
		    idade: Number,
		    data: { type: Date, default: Date.now },
		    acessorios : [Number]
		}, { collection: 'clone', versionKey: false }));		
	}

	async all() {
		await assureConnection();
		return this.model.find({}).lean().exec();
	}


	async findById(id) {
		await assureConnection();
		return this.model.findOne({ _id: id }).lean().exec();
	}

	async update(id, args) {
		await assureConnection();
		return this.isValid(args) && this.model.update({ _id: id }, {
	        nome: args.nome,
	        idade: args.idade,
	        acessorios: args.acessorios || [],
	    });
	}

	async deleteById(id) {
		await assureConnection();
		return this.model.findOne({ _id: id }).remove().exec();
	}

	async create(args) {
		await assureConnection();
		return this.isValid(args) && this.model.create({ 
			nome: args.nome, 
			idade: args.idade, 
			date: new Date(), 
			acessorios: args.acessorios,
		});
	}

	async isValid(args) {
		const validateName = /^[A-Z]{3}[0-9]{4}/;
		console.log(args);
		return args.nome.match(validateName) && args.idade >=10 && args.idade <= 20;
	}
}

module.exports = new CloneDAO();