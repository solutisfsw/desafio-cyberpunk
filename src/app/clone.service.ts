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
    return of (CLONES);
  }

  getClone(id: number): Observable<Clone> {
    // Todo: send the message _after_ fetching the clone
    this.messageService.add(`CloneService: fetched clone id=${id}`);
    return of(CLONES.find(clone => clone.id === id));
  }

}
