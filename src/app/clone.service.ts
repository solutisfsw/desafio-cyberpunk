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
    // Todo: send the message _after_ fetching the heroes
    this.messageService.add('CloneService: fetched heroes');
    return of (CLONES);
  }

}
