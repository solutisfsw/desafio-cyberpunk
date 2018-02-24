module.exports = function (application) {
    application.get('/clones', (req, res) => {
        res.send(application.app.models.clone.getClones())
    })

    application.get('/clone/:id', (req, res, next) => {
        res.send(application.app.models.clone.getClone(req.params.id))
    })

    application.post('/clone', (req, res) => {
        const isValido = validaDados(application, req, res)
        if (isValido) {
            const clone = application.app.models.clone.salvar({
                nome: req.body.nome,
                idade: req.body.idade,
                dataCriacao: new Date().toISOString().substr(0, 10).split('-').reverse().join('/'),
                adicionais: req.body.adicionais || []
            })
            res.send(clone)
        }
    })

    application.put('/clone/:id', (req, res) => {
        const isValido = validaDados(application, req, res)
        if (isValido) {
            const clone = application.app.models.clone.salvar({
                id: req.params.id,
                nome: req.body.nome,
                idade: req.body.idade,
                dataCriacao: new Date().toISOString().substr(0, 10).split('-').reverse().join('/'),
                adicionais: req.body.adicionais || []
            })
            res.send(clone)
        }
    })

    application.delete('/clone/:id', (req, res, next) => {
        res.send(application.app.models.clone(req.params.id))
    })

    function validaDados(application, req, res) {
        const dados = req.body

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
            let cloneJaCadastrado = clones.filter(function (clone) {
                if(clone.nome === dados.nome && !req.params.id){
                    return true
                }
            })
    
            if(cloneJaCadastrado) {
                res.send('Já existe esse clone já cadastrado')
                cloneJaCadastrado = false
                return false
            }
        }        

        return true
    }
}