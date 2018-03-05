const mongoose = require('mongoose');

const MLAB_URL = process.env.NODE_ENV === 'production'
	? 'mongodb://admin:admin@ds153948.mlab.com:53948/clones'
	: 'mongodb://admin:admin@ds155278.mlab.com:55278/clones-teste';

const connectDB = function() {
	mongoose.connect(MLAB_URL);
}

const assureConnection = function() {
	if (!mongoose.connection.readyState) {
		connectDB();
	}
}

module.exports = { assureConnection, connectDB };
