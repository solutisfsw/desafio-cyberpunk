import { Component, OnInit } from '@angular/core';
import { DialogUtilsComponent } from '../dialog-utils/dialog-utils.component';

import {CyberpunkService} from './service/cyberpunk.service';
import {AttributeService} from '../attribute-mng/service/attribute.service';
import { FormGroup, Form } from '@angular/forms';

@Component({
  selector: 'app-cyberpunk-mng',
  templateUrl: './cyberpunk-mng.component.html',
  styleUrls: ['./cyberpunk-mng.component.css']
})
export class CyberpunkMngComponent implements OnInit {

  public attributes = [];
  public models = [];
  public cyberpunks = [];
  public cyberModel = <any>{ additional: <any>[]};
  public selCyberModel = <any>{};
  public clonedCyberpunk = <any>{};
  public attrModel = { attributeType: {}};
  public isEdition = false;

  constructor(private cyberpunkService: CyberpunkService,
              private attributeService: AttributeService, 
              private dialogUtilsComponent: DialogUtilsComponent) { }

  ngOnInit() {
    this.consult();
    this.fillAttr();
  }

  fillAttr(){
    this.attributeService.listAll().subscribe(retorno => {
      this.attributes = retorno;
      //console.log(retorno);
    })
  }

  addAtribute(selAttr: any){
    //console.log(selAttr);
    let allAddit = this.cyberModel.additional;
    if(!this.isEdition){
      allAddit = allAddit.concat(this.selCyberModel.additional);
    }
    //console.log(allAddit);
    if(selAttr.code){
      //verifica se já foi selecionado em ambas as listas
      for (let add of allAddit){
        if(add.attribute.code == selAttr.code){
          this.dialogUtilsComponent.openSimpleDialog("Attribute Already Selected");
          return;
        }
      }
      //busca o atributo na lista da combo
      for (let attrList of this.attributes){
        if(attrList.code == selAttr.code){
          let newAdditional = {attribute: attrList};
          this.cyberModel.additional.push(newAdditional);
         // console.log(this.cyberModel);
        }
      }
    }
    else{
      this.dialogUtilsComponent.openSimpleDialog("Select Attribute to Add");
    }
  }

  consult(){
    this.cyberpunkService.listAll().subscribe(retorno => {
      this.cyberpunks = retorno;
      //console.log(retorno);
    })  
    
    this.cyberpunkService.listModels().subscribe(retorno => {
      this.models = retorno;
      //console.log(retorno);
    })  
  }

  fillClone(selectedCP: any){
    this.clear();
    this.selCyberModel = Object.assign({}, selectedCP);
    this.isEdition = false;
    //console.log(this.selCyberModel);
  }

  editClone(selectedCP: any){
    this.clear();
    this.cyberModel = Object.assign({}, selectedCP);
    this.isEdition = true;
    //console.log(this.selCyberModel);
  }

  validateClone(){
    if(this.cyberModel.age<10||this.cyberModel.age>20){
      this.dialogUtilsComponent.openSimpleDialog("Age must be between 10 and 20");
      return;
    }
    if(!this.isEdition){
      this.clone(this.selCyberModel);
    }
    else{
      this.update(this.cyberModel);
    }
  }

  update(cbToClone: any){
    //Limpa os codigos dos atributos
    for (let additional of cbToClone.additional){
      //console.log(additional);      
      additional.cyberpunkCode = cbToClone.id;
    }

    this.cyberpunkService.update(cbToClone).subscribe(
      retorno => {
        this.dialogUtilsComponent.openSimpleDialog("Update proceeded with success");
        this.clonedCyberpunk = {};
        this.clear();
        this.consult();
      },
      error => {
        //console.log(error);
        this.dialogUtilsComponent.openSimpleDialog("This cyberpunk could not be updated, cause: "+error.error.message);
      })  
  }

  clone(cbToClone: any){
    //console.log(cbToClone);    
    this.clonedCyberpunk = Object.assign({}, cbToClone);    
    this.clonedCyberpunk.name = this.cyberModel.name;
    this.clonedCyberpunk.parentId = cbToClone.id;
    this.clonedCyberpunk.age = this.cyberModel.age;
    this.clonedCyberpunk.version = undefined;
    this.clonedCyberpunk.additional = this.cyberModel.additional.concat(cbToClone.additional);

    //Limpa os codigos dos atributos
    for (let additional of this.clonedCyberpunk.additional){
      //console.log(additional);
      additional.id = undefined;
      additional.cyberpunkCode = undefined;
    }
    this.clonedCyberpunk.id = undefined;
    this.cyberpunkService.clone(this.clonedCyberpunk).subscribe(
      retorno => {
        this.dialogUtilsComponent.openSimpleDialog("Clone proceeded with success");
        this.clonedCyberpunk = {};
        this.clear();
        this.consult();
      },
      error => {
        //console.log(error);
        this.dialogUtilsComponent.openSimpleDialog("This cyberpunk could not be cloned, cause: "+error.error.message);
      })    
  }

  cancelClone(){
    this.clear();
  }

  deleteClone(cbToClone: any){
    this.cyberpunkService.delete(cbToClone).subscribe(
      retorno => {
        this.dialogUtilsComponent.openSimpleDialog("Deletion proceeded with success");
        this.clonedCyberpunk = {};
        this.clear();
        this.consult();
      },
      error => {
        //console.log(error);
        this.dialogUtilsComponent.openSimpleDialog("This cyberpunk could not be deleted, cause: "+error.error.message);
      })    
  }

  clear(){
    this.selCyberModel = <any>{}
    this.cyberModel = <any>{ additional: <any>[]};
  }
}
