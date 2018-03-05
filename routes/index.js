const express = require('express');
const cloneController = require('../controllers/cloneController');
const router = express.Router();

router.get('/', (req, res) => res.render('index'))
router.route('/clones')
			.get(cloneController.clone_list)
			.post(cloneController.clone_create)
router.route('/clones/:cloneName')
			.get(cloneController.clone_update_get)
			.post(cloneController.clone_update_post)
			.put(cloneController.clone_update_put)
			.delete(cloneController.clone_delete_delete)

router.route('/create')
			.get(cloneController.clone_create_get)
			.post(cloneController.clone_create_post)
router.route('/delete/:cloneName')
			.get(cloneController.clone_delete_get)

/*
router.route('/edit/:cloneName')
			.get(cloneController.clone_update_get)
			.post(cloneController.clone_update_post)

router.get('/list', cloneController.clone_list)
router.route('/create')
			.get(cloneController.clone_create_get)
			.post(cloneController.clone_create_post)
router.route('/user/:userId')
			.get(cloneController.clone_update_get)
			.post(cloneController.clone_update_post)
*/
module.exports = router;