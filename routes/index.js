var express = require('express');
var router = express.Router();
var mongoose = require('mongoose');
var clones = require('../models/clones.js');

/* GET ALL CLONES */
router.get('/', function(req, res, next) {
  clones.find(function (err, products) {
    if (err) return next(err);
    res.json(products);
  });
});

/* GET SINGLE CLONE BY ID */
router.get('/:id', function(req, res, next) {
  clones.findById(req.params.id, function (err, post) {
    if (err) return next(err);
    res.json(post);
  });
});

/* SAVE CLONE */
router.post('/', function(req, res, next) {
  clones.create(req.body, function (err, post) {
    if (err) return next(err);
    res.json(post);
  });
});

/* UPDATE CLONE */
router.put('/:id', function(req, res, next) {
  clones.findByIdAndUpdate(req.params.id, req.body, function (err, post) {
    if (err) return next(err);
    res.json(post);
  });
});

/* DELETE CLONE */
router.delete('/:id', function(req, res, next) {
  clones.findByIdAndRemove(req.params.id, req.body, function (err, post) {
    if (err) return next(err);
    res.json(post);
  });
});

module.exports = router;