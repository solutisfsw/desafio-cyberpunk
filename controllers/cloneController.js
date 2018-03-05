var Clone = require('../models/clone');

const { body, validationResult } = require('express-validator/check');
const { sanitizeBody } = require('express-validator/filter');
const moment = require('moment');

exports.clone_list = function(req, res) {
	Clone.find({}, '')
    .exec(function (err, list_clones) {
      if (err) { return next(err); }
      //console.log(list_clones)
      res.render('list', { clones: (list_clones), moment: moment });
    });
};

exports.clone_create_get = function(req, res) {
    res.render("create");
};

exports.clone_create_post = [
	body('name', 'Nome do Clone invalido').isLength({ min: 1 }).trim(),
	body('age', 'Idade do Clone invalida').isInt({min:10, max:20}),
	sanitizeBody('name').trim().escape(),
	(req, res, next) => {
		var errors = validationResult(req);
      	if (!errors.isEmpty()) {
            res.render('create', { clone: req.body, errors: errors.array()});
        	return false;
    	}
    	else {
    		var clone = new Clone (
      		{ 	
      			name: req.body.name,
	          	age: req.body.age,
	          	arms: req.body.arms,
	          	skeleton: req.body.skeleton,
	          	senses: req.body.senses,
	          	skin: req.body.skin,
	          	laser: req.body.laser}
	        );
			
			Clone.findOne({ 'name': req.body.name })
				.exec( function(err, found_clone) {
					if (err) { return next(err); }
					if (found_clone) {
						res.redirect(found_clone.editUrl);
						return false;
					}})

			clone.save(function (err) {
                if (err) return next(err);
                res.redirect("../clones");
                return true;
            });    		
    	}
	}];

exports.clone_create = [
	body('name', 'Nome do Clone invalido').isLength({min: 7, max: 7}).trim(),
	body('age', 'Idade do Clone invalida').isInt({min:10, max:20}),
	sanitizeBody('name').trim().escape(),
	(req, res, next) => {
		var errors = validationResult(req);

      	if (!errors.isEmpty()) {
      		//console.log(errors.array)
      		res.send(errors.array())
        	return false;
    	}
    	else {
    		var clone = new Clone (
      		{ 	
      			name: req.body.name,
	          	age: req.body.age,
	          	arms: req.body.arms,
	          	skeleton: req.body.skeleton,
	          	senses: req.body.senses,
	          	skin: req.body.skin,
	          	laser: req.body.laser}
	        );
			
			Clone.findOne({ 'name': req.body.name })
				.exec( function(err, found_clone) {
					if (err) { return next(err); }
					if (found_clone) {
						res.send("Clone " + req.body.name + " ja existe")
						return false;
					}})

			clone.save(function (err) {
                if (err) return next(err);
                res.send("Clone cadastrado com sucesso");
                return true;
            });    		
    	}
	}];

exports.clone_delete_get = function(req, res, next) {
	Clone.deleteOne({name : req.params.cloneName}, function (err,clone) {
                if (err) { return next(err); }
                   res.redirect("../clones/");
                   return true;
                });
};

exports.clone_delete_delete = function(req, res, next) {
	Clone.deleteOne({name : req.params.cloneName}, function (err,clone) {
                if (err) { return res.send(err); }
                   res.send(req.params.cloneName + " removido com sucesso");
                   return true;
                });
};

exports.clone_update_get = function(req, res, next) {
	Clone.findOne({ 'name': req.params.cloneName })
		.exec( function(err, found_clone) {
			//console.log("Found Clone:  \n" + found_clone)
			//console.log(err)
			if (err) { return next(err); }
			if (found_clone) {
	            res.render('create', { btnText: "Editar Clone", title: "Editar um Clone", clone: found_clone});
	            return true;
			}
			if (found_clone == null)
				res.send("Clone não encontrado")
		})
};

exports.clone_update_post = [
	body('name', 'Nome do Clone invalido').isLength({ min: 1 }).trim(),
	body('age', 'Idade do Clone invalida').isInt({min:10, max:20}),
	sanitizeBody('name').trim().escape(),
	(req, res, next) => {
		var errors = validationResult(req);
      	if (!errors.isEmpty()) {
            res.render('create', { btnText: "Editar Clone", title: "Editar um Clone", clone: req.body, errors: errors.array()});
        	return false;
    	}
    	else {
 			Clone.findOneAndUpdate({name : req.params.cloneName}, req.body, {}, function (err,clone) {
                if (err) { return next(err); }
                   res.redirect("../clones/");
                   return true;
                });    		
    	}
	}];

exports.clone_update_put = [
	body('name', 'Nome do Clone invalido').isLength({ min: 1 }).trim(),
	body('age', 'Idade do Clone invalida').isInt({min:10, max:20}),
	sanitizeBody('name').trim().escape(),
	(req, res, next) => {
		var errors = validationResult(req);

      	if (!errors.isEmpty()) {
            res.send(errors.array());
        	return false;
    	}
    	else {
 			Clone.findOneAndUpdate({name : req.params.cloneName}, req.body, {upsert: true}, function (err,clone) {
                if (err) { return next(err); }
                   res.send(req.params.cloneName + " atualizado com sucesso");
                   return true;
                });    		
    	}
	}];