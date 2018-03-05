import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import {Clone} from '../shared/clone.model'
import{Http} from '@angular/http'
import{Injectable} from '@angular/core'
import 'rxjs/add/operator/map';
import{AngularFireAuthModule, AngularFireAuth} from 'angularfire2/auth';
import{AngularFireModule} from 'angularfire2';
import{Observable} from 'rxjs/observable'
import{AngularFireDatabaseModule,AngularFireDatabase,AngularFireList} from 'angularfire2/database';
import{FirebaseListObservable} from 'angularfire2/database/es2015';
import{} from '@angular/';
//angularfire2/index';
import * as firebase from 'firebase/app';
//import { query } from '@angular/core/src/animation/dsl';




@Component({
  selector: 'app-painel',
  templateUrl: './painel.component.html',
  styleUrls: ['./painel.component.css'],
  providers:[AngularFireDatabase]

})






@Injectable()
export class PainelComponent implements OnInit {

  cloneList:AngularFireList<any>;
  
  //constructor(private http:Http) { }
  
  constructor(private firebase: AngularFireDatabase)
   { 
      
   }
   
  

  ngOnInit() {
  }

  public cadastroTeste(resposta:Event): void
  {
    console.log("Cadastro com sucesso")
  }


  public solicitarClone(formulario:NgForm):void
  {
    let adicionais:Array<string>=new Array<string>();
    if(formulario.value.braco)
    {
      adicionais.push("braço mecânico");
    }
    if(formulario.value.raio)
    {
      adicionais.push("raio laser");
    }
    if(formulario.value.esqueleto)
    {
      adicionais.push("esqueleto reforçado");
    }
    if(formulario.value.pele)
    {
      adicionais.push("pele adaptativa");
    }
    if(formulario.value.sentido)
    {
      adicionais.push("sentido aguçado");
    }

   
    let clone:Clone= new Clone(
      formulario.value.nome,
      formulario.value.idade,
      formulario.value.data,
      adicionais
    );
 
    this.cloneList= this.firebase.list('clone');
   
    this.cloneList.push({
      nome:clone.nome,
      idade:clone.idade,
      data:clone.dataCriacao,
      adicionais:clone.adicionais
    });

    

    
    }

}
