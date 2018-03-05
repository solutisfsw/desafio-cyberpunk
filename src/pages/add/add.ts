import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, ToastController } from 'ionic-angular';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { DatabaseProvider } from '../../providers/database/database';

import { NameValidator } from  '../../app/validators/name';

@IonicPage()
@Component({
  selector: 'page-add',
  templateUrl: 'add.html'
})
export class AddPage {

   public form            : FormGroup;
   public cloneName       : any;
   public cloneAdditional : any;
   public cloneAge        : any;
   public recordId        : any;
   public revisionId      : any;
   public isEdited        : boolean = false;
   public hideForm        : boolean = false;
   public pageTitle       : string;


   constructor( public navCtrl   : NavController,
            public NP            : NavParams,
            public fb            : FormBuilder,
            public DB            : DatabaseProvider,
            public toastCtrl     : ToastController)
     {

      this.form = fb.group({
          name:       ['', Validators.compose([Validators.required, Validators.pattern('[A-Z]{3}[0-9]{4}')]), NameValidator.checkName.bind(this)],       
          additional: [""],
          age:        [""],
      });

      this.resetFields();

      if(NP.get("key") && NP.get("rev"))
      {
         this.recordId      = NP.get("key");
         this.revisionId    = NP.get("rev");
         this.isEdited      = true;
         this.selectClone(this.recordId);
         this.pageTitle     = 'Editar Registro';
      }
      else
      {
         this.recordId      = '';
         this.revisionId    = '';
         this.isEdited      = false;
         this.pageTitle     = 'Criar Registro';
      }
   }

   selectClone(id)
   {
      this.DB.retrieveClone(id)
      .then((doc)=>
      {
         this.cloneName         = doc[0].name;
         this.cloneAdditional   = doc[0].additional;
         this.cloneAge          = doc[0].age;
         this.recordId          = doc[0].id;
         this.revisionId        = doc[0].rev;
      });
   }

   saveClone()
   {
      let name            : string  = this.form.controls["name"].value,
          additional      : string  = this.form.controls["additional"].value,
          age             : number  = this.form.controls["age"].value,
          revision        : string  = this.revisionId,
          id              : any     = this.recordId;

      if(!this.form.valid){
          console.log("form invalido 1");
      }
      else{
        console.log("form valido 2");
      }

      if(this.recordId !== '')
      {
         this.DB.updateClone(id, additional, name, age, revision)
           .then((data) =>
           {
              this.hideForm = true;
              this.sendNotification(`${name} foi atualizado em sua lista de Clones.`);
           });
      }
      else
      {
         this.DB.addClone(additional, name, age)
           .then((data) =>
           {
              this.hideForm = true;
              this.resetFields();
              this.sendNotification(`${name} foi adicionado em sua lista de Clones.`);
           });
      }
   }

   deleteClone()
   {
      let name;

      this.DB.retrieveClone(this.recordId)
      .then((doc)=>
      {
         name = doc[0].name;
         return this.DB.removeClone(this.recordId, this.revisionId);
      })
      .then((data) =>
      {
         this.hideForm  = true;
         this.sendNotification(`${name} foi removido com sucesso de sua lista de Clones`);
      })
      .catch((err)=>
      {
         console.log(err);
      });
   }



   resetFields() : void
   {
      this.cloneAdditional   = "";
      this.cloneAge          = "";
      this.cloneName         = "";
   }



   sendNotification(message)  : void
   {
      let notification = this.toastCtrl.create({
             message    : message,
             duration   : 3000
        });
      notification.present();
   }

}
