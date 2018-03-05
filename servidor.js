const porta = 3003

const express = require('express')
const app = express() //geral
const bodyParser = require('body-parser')
//const BancoDados = require('./BancoDados')
const mongoose = require('mongoose')
const cloneCute = require('./clone-BD')

//cloud mlab

mongoose.connect('mongodb://solutis:fagner123@ds012538.mlab.com:12538/clone-crud-api')  


app.use(bodyParser.urlencoded({extended: true}))


app.route('/clones')

    .post( (req, res)=>{
        const clone = new cloneCute()
        const _val = Validar_dados(app,req, res)        
        if(_val){

        clone.nome = req.body.nome
        clone.idade = req.body.idade
        clone.adcionais = req.body.adcionais
        clone.data = new Date().toISOString().substr(0, 10).split('-').reverse().join('/')

        clone.save(function(error){
            if(error)
                res.send('erro ao tentar salvar o clone  ' + error)
            res.json({message:'clone cadastrado com sucesso!' } )    
        });
    }
    })

    .get( (req, res)=>{        
        cloneCute.find(function( error, clones){
            if(error)
                res.send('erro ao selecionar todos os clones...' + error)
            res.json(clones)    
        });
        
    });

app.get('/clones/:id', (req,res)=>{
        cloneCute.findById(req.params.id, function(error, clone){
            if(error)
                res.send('erro ao selecionar o clone pelo ID'+ error)
            res.json(clone)    
        });
    });    

app.put('/clones/:id', (req, res)=>{
    cloneCute.findById(req.params.id, function(error, clone){
        if(error)
            res.send('nao foi possivel alterar  o clone'+error)
        clone.nome = req.body.nome
        clone.idade = req.body.idade    
        clone.adcionais = req.body.adcionais

        clone.save(function(error){
            if(error)
                res.send('erro ao atualizar o clone  '+ error)
            res.json('clone alterado com sucesso no banco')    
        })
    })
})

 
app.delete('/clones/:id',(req,res)=>{
    cloneCute.remove({_id: req.params.id,
    }, function(error){
        if(error)
            res.send('nao foi possivel deletar....'+ error)
       
        res.json('clone removido do banco com sucesso')
    })  
}) 

function Validar_dados(app, req, res){
    const dados = req.body

    if (!dados.nome || !dados.idade) {
        res.send('Nome e idade são obrigatórios')
        return false
        }

        // stringObj.match(rgExp)
    var validarNome = dados.nome.match('[A-Z]{3}[0-9]{4}')

    if(!validarNome){
        res.send('nome invalido')
        return false
    }
    
    if(dados.idade < 10 || dados.idade > 20){
        res.send('idade permitida apenas entre 10 e 20 anos')
        return false

    }
    
    /*
    var array = ['braçoo','esqueleto reforçado','sentidos aguçados','pele adaptativa','raio laser']
    let i 
    for( i = 0 ; i< array.length ; i++)
        if((dados.adcionais != array[1]) ){
            res.send('adcionais invalido')
            return false     
        }
        */
    


        return true
     }
     


module.exports = app;

app.listen(porta, () =>{
    console.log(`servidor esta ainda  executando na porta ${porta}.`)
})