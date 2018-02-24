module.exports = function (application) {
	application.get('/', function (req, res) {
		res.format({
			html: function () {
				res.send('Bem vindo a api-smp');
			}
		});
	});
}