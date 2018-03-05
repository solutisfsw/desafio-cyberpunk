import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { DatabaseProvider } from '../../providers/database/database';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

   public hasClone    : boolean = false;
   public clones        : any;

   constructor( public navCtrl    : NavController,
              public DB       : DatabaseProvider)
   {

   }

   ionViewWillEnter()
   {
      this.displayClones();
   }

   displayClones()
   {
      this.DB.retrieveClones().then((data)=>
      {
         let existingData = Object.keys(data).length;
         if(existingData !== 0)
   {
            this.hasClone  = true;
            this.clones   = data;
   }
   else
   {
      console.log("Sem Clones Cadastrados!");
   }
      });
   }



   addClone()
   {
      this.navCtrl.push('AddPage');
   }



   viewClone(param)
   {
      this.navCtrl.push('AddPage', param);
   }

}