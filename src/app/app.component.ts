import { Component } from '@angular/core';
import { CLONES } from './mock-clones';
import { CloneService } from './clone.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'iClone';
  countClones = CLONES.length;

}
