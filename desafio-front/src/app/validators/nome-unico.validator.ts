import { Observable } from 'rxjs/Observable';
import { AbstractControl } from '@angular/forms';

import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/of'; 

import { Clone } from './../domain/clone/clone.model';
import { ClonesService } from './../domain/clone/clones.service';

export class NomeUnicoValidator {
  static criaValidador(service: ClonesService, id: number) {
    return (control: AbstractControl) => {
      return service.buscaPorNome(control.value)
        .debounceTime(500)
        .map(clone => 
          clone == null || clone.id == id ? null : { nomeRepetido: true }
        )
        .catch(err => Observable.of(null))
    } 
  }
}
