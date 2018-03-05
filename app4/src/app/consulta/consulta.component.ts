import { Component, OnInit } from '@angular/core';
import{AngularFireDatabaseModule,AngularFireDatabase,AngularFireList} from 'angularfire2/database';
import{FirebaseListObservable} from 'angularfire2/database/es2015';
import {Clone} from '../shared/clone.model'

@Component({
  selector: 'app-consulta',
  templateUrl: './consulta.component.html',
  styleUrls: ['./consulta.component.css'],
  providers:[AngularFireDatabase]

  
})
export class ConsultaComponent implements OnInit {

  private cloneListBanco: AngularFireList<any>;
   cloneList: Clone[];
   public mostrarInformacao:boolean=false;
   public mostrar:boolean=true;
   public adicionaisSelecionados:string;
   cloneSelecionado:Clone;
  

  constructor(private firebase: AngularFireDatabase)
  { 
     
  }
  onSelect(clone)
  {
    this.cloneSelecionado=clone;
    this.adicionaisSelecionados=clone.adicionais;
    this.mostrarInformacao=true;
    
  }

  ngOnInit() {
    
    this.cloneListBanco=this.firebase.list("/clone");
    var x = this.cloneListBanco;
    x.snapshotChanges().subscribe(item =>{
      this.cloneList=[];
      item.forEach(element=>{
        var y=element.payload.toJSON();
        this.cloneList.push(y as Clone);
        
      });
    });
  }



}
