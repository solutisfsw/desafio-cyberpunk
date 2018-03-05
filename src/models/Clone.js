const mongoose = require('mongoose');

class CloneDAO {

	static schema = new mongoose.Schema({
		nome: String,
	    idade: Number,
	    data: { type: Date, default: Date.now },
	    acessorios : [Number]
	}, { collection: 'clone', versionKey: false });

	static find(args, callback) {

		this.schema.find(args).lean().exec(callback);

	}

}