import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { Clone } from './clone';
import { CLONES } from './mock-clones';
import { MessageService } from './message.service';

@Injectable()
export class CloneService {

  constructor(private messageService: MessageService) { }

  getClones(): Observable<Clone[]> {
    // Todo: send the message _after_ fetching the clones
    this.messageService.add('CloneService: fetched clones');
    return of (CLONES.sort((function(a,b) {return (a.date > b.date) ? -1 : ((b.date > a.date) ? 1 : 0);} )));
  }

  getClone(id: number): Observable<Clone> {
    // Todo: send the message _after_ fetching the clone
    this.messageService.add(`CloneService: fetched clone id=${id}`);
    return of(CLONES.find(clone => clone.id === id));
  }

  createClone(clone: Clone): Observable<Clone> {
    this.messageService.add(`CloneService: added new clone `);
    const newId = this.getNextId();
    clone.id = newId;
    console.log('clone no service ' + clone);
    CLONES.push(clone);
    console.log(CLONES);
    return of(clone);
  }

  getNextId(): number {
    return CLONES.reduce((max, c) => Math.max(max, c.id), CLONES[0].id) + 1;
  }

  getTotal(): number {
    return CLONES.length;
  }

}
