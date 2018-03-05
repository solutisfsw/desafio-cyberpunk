import { Injectable } from '@angular/core';
import { AlertController } from 'ionic-angular';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';
import PouchDB from 'pouchdb';


@Injectable()
export class DatabaseProvider {

   public _DB          : any;
   private success     : boolean = true;
   private _remoteDB   : any;
   private _syncOpts   : any;

   constructor(public http      : Http,
               public alertCtrl : AlertController)
   {
      this.initialiseDB();
   }

   initialiseDB()
   {
      this._DB            = new PouchDB('clone');
      this._remoteDB      = 'http://192.168.0.39:5984/cllone';  
      this._syncOpts      = { live            : true,
                              retry            : true,
                              continuous    : true };
      this._DB.sync(this._remoteDB, this._syncOpts)
      .on('change', (info) =>
      {
         console.log('Handling syncing change');
         console.dir(info);
      })
      .on('paused', (info) =>
      {
         console.log('Handling syncing pause');
         console.dir(info);
      })
      .on('active', (info) =>
      {
         console.log('Handling syncing resumption');
         console.dir(info);
      })
      .on('denied', (err) =>
      {
         console.log('Handling syncing denied');
         console.dir(err);
      })
      .on('complete', (info) =>
      {
         console.log('Handling syncing complete');
         console.dir(info);
      })
      .on('error', (err)=>
      {
         console.log('Handling syncing error');
         console.dir(err);
      });
   }



   handleSyncing()
   {
      this._DB.changes({
         since          : 'now',
         live           : true,
         include_docs   : true
      })
      .on('change', (change) =>
      {
         // handle change
         console.log('Handling change');
         console.dir(change);
      })
      .on('complete', (info) =>
      {
         // changes() was canceled
         console.log('Changes complete');
         console.dir(info);
      })
      .on('error',  (err) =>
      {
         console.log('Changes error');
         console.log(err);
      });
   }



   addClone(additional, name, age)
   {
      var timeStamp   = new Date().toISOString(),
          clone     = {
             _id         : timeStamp,
             additional  : additional,
             name        : name,
             age         : age
          };

      return new Promise(resolve =>
      {
         this._DB.put(clone).catch((err) =>
         {
            console.log('error is: ' + err);
            this.success = false;
         });


         if(this.success)
         {
            this.handleSyncing();
            resolve(true);
         }

      });
   }

   updateClone(id, additional, name, age, revision)
   {
      var clone = {
             _id          : id,
             _rev         : revision,
             additional   : additional,
             name         : name,
             age          : age,
          };

      return new Promise(resolve =>
      {
         this._DB.put(clone)
         .catch((err) =>
         {
            console.log('error is: ' + err);
            this.success = false;
         });

         if(this.success)
         {
            this.handleSyncing();
            resolve(true);
         }
      });
   }


   retrieveClone(id)
   {
      return new Promise(resolve =>
      {
         this._DB.get(id)
         .then((doc)=>
         {
            var item       = [];

            item.push(
            {
               id          : id,
               rev         : doc._rev,
               name        : doc.name,
               additional  : doc.additional,
               age         : doc.age
            });

            resolve(item);
         })
      });
   }


    // I reverse the given string value.
    retrieveClonebyName( name: string )
    {

      return new Promise(resolve =>
      {
         this._DB.get(name)
         .catch((err) =>
         {
            console.log('error is: ' + err);
            
            resolve(false);
         });

         if(this.success)
         {
            this.handleSyncing();
            resolve(true);
         }
      });      
    }



   retrieveClones()
   {
      return new Promise(resolve =>
      {
         this._DB.allDocs({include_docs: true, descending: true}, function(err, doc)
         {
            let k,
                items   = [],
                row   = doc.rows;

            for(k in row)
            {
               var item          = row[k].doc;

               items.push(
               {
                  id          : item._id,
                  rev         : item._rev,
                  name        : item.name,
                  additional  : item.additional,
                  age         : item.age
               });
            }

            resolve(items);
         });
      });
   }



   removeClone(id, rev)
   {
      return new Promise(resolve =>
      {
         var clone   = { _id: id, _rev: rev };

         this._DB.remove(clone)
         .catch((err) =>
         {
            console.log('error is: ' + err);
            this.success = false;
         });

         if(this.success)
         {
            resolve(true);
         }
      });
   }



   errorHandler(err)
   {
      let headsUp = this.alertCtrl.create({
          title: 'Atencao!',
          subTitle: err,
          buttons: ['Solicitar!']
      });

      headsUp.present();
   }


}