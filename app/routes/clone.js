module.exports = function (application) {
    application.get('/clones', (req, res) => {
        res.send(application.app.models.clone.getClones())
    })

    application.get('/clone/:id', (req, res, next) => {
        res.send(application.app.models.clone.getClone(req.params.id))
    })

    application.post('/clone', (req, res) => {
        const dados = {
            nome: req.body.nome,
            idade: req.body.idade,
            dataCriacao: new Date().toISOString().substr(0, 10).split('-').reverse().join('/'),
            adicionais: req.body.adicionais || []
        }
        const isValido = validaDados(application, dados, res)
        if (isValido) {
            const clone = application.app.models.clone.salvar(dados)
            res.send(clone)
        }
    })

    application.put('/clone/:id', (req, res) => {
        const cloneUpdate = application.app.models.clone.getClone(req.params.id)
        if (Object.keys(cloneUpdate).length === 0) {
            res.send('Não foi encontrado esse clone para alteração')
            return
        }
        const dados = {
            id: req.params.id,
            nome: req.body.nome,
            idade: req.body.idade,
            dataCriacao: new Date().toISOString().substr(0, 10).split('-').reverse().join('/'),
            adicionais: req.body.adicionais || []
        }
        const isValido = validaDados(application, dados, res)
        if (isValido) {
            const clone = application.app.models.clone.salvar(dados)
            res.send(clone)
        }
    })

    application.delete('/clone/:id', (req, res, next) => {
        const cloneDelete = application.app.models.clone.getClone(req.params.id)
        if (Object.keys(cloneDelete).length === 0) {
            res.send('Não foi encontrado esse clone para exclusão')
            return
        }
        res.send(application.app.models.clone.excluir(req.params.id))
    })

    function validaDados(application, dados, res) {
        if (!dados.nome || !dados.idade) {
            res.send('Nome e idade são obrigatórios')
            return false
        }

        let nomeValido = dados.nome.match('[A-Z]{3}[0-9]{4}')

        if (!nomeValido) {
            res.send('Nome inválido')
            return false
        }

        if (!parseInt(dados.idade)) {
            res.send('Para idade, informe apenas números inteiros')
            return false
        }

        let idade = parseInt(dados.idade)

        if (idade < 10 || idade > 20) {
            res.send('Favor informar idade entre 10 e 20')
            return false
        }

        const clones = application.app.models.clone.getClones()

        if (clones.length > 0) {
            let cloneJaCadastrado = clones.filter(function (c) {
                return c.nome === dados.nome && (!dados.id || 
                    (dados.id && c.id && dados.id != c.id))
            })
            
            if(cloneJaCadastrado.length > 0) {
                res.send('Já existe esse clone já cadastrado')
                cloneJaCadastrado = false
                return false
            }
        }        

        return true
    }
}