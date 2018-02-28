import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { Clone } from './clone';
import { CLONES } from './mock-clones';

@Injectable()
export class CloneService {

  constructor() { }

  getClones(): Observable<Clone[]> {
    return of (CLONES);
  }

}
