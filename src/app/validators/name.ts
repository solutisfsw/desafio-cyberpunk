import { FormControl } from '@angular/forms';
 
export class NameValidator {
 
  static checkName(control: FormControl): any {
 
    return new Promise(resolve => {
 
      //TO DO
      //console.log("--> " + this.DB.retrieveClone(control.value));

      if(control.value.toLowerCase() === "danilo"){

        resolve({
          "Nome precisa ser unico": true
        });

      } else {
        resolve(null);
      }
 
    });
  }
 
}