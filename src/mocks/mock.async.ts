import { Injectable } from '@angular/core';


export class AsyncMockProvider {

   constructor()
   { }

   fetchByPromise(val : number) : Promise
   {
      return new Promise((resolve, reject) =>
      {
         let outcome : string;

         if(val == 1)
         {
            outcome = "First";
         }
         else
         {
            outcome = "second";
         }
         resolve(outcome);
      });
   }


}