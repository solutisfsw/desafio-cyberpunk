import { Component, OnInit } from '@angular/core';
import { DialogUtilsComponent } from '../dialog-utils/dialog-utils.component';

import {AttributeService} from './service/attribute.service';
import { FormGroup, Form } from '@angular/forms';

@Component({
  selector: 'app-attribute-mng',
  templateUrl: './attribute-mng.component.html',
  styleUrls: ['./attribute-mng.component.css']
})
export class AttributeMngComponent implements OnInit {
  
  public attributes = [];
  public attributeTypes = [];
  public attrModel = <any>{ attributeType: {}};

  constructor(private attributeService: AttributeService, private dialogUtilsComponent: DialogUtilsComponent) { }

  ngOnInit() {
    this.consult();
  }

  consult(){
    this.attributeService.listAll().subscribe(retorno => {
      this.attributes = retorno;
      //console.log(retorno);
    })  

    this.attributeService.listType().subscribe(retorno => {
      this.attributeTypes = retorno;
      //console.log(retorno);
    }) 

    /*
      this.attributeService.listAll().subscribe(function(retorno) {
        this.attributes = retorno;
    })
    */
  }

  adicionarAttr(){
    //console.log(this.attrModel);
    
    this.attributeService.addNew(this.attrModel).subscribe(
      retorno => {
        this.dialogUtilsComponent.openSimpleDialog("Attribute created succesfully");
        this.attrModel.name = undefined;
        this.consult();
      },
      error => {
        this.dialogUtilsComponent.openSimpleDialog("This attribute could not be created, cause: "+error.error.message);
      })    
  }

  delete(attribute: any){
    //console.log(attribute);
    this.attributeService.delete(attribute).subscribe(
      retorno => {
        this.dialogUtilsComponent.openSimpleDialog("Attribute deleted succesfully");
        this.consult();
      },
      error => {
        this.dialogUtilsComponent.openSimpleDialog("This attribute cannot be deleted, cause: "+error.error.message);
      })
  }

}
