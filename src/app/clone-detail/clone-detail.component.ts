import { Component, OnInit, Input } from '@angular/core';
import { Clone } from '../clone';

@Component({
  selector: 'app-clone-detail',
  templateUrl: './clone-detail.component.html',
  styleUrls: ['./clone-detail.component.css']
})
export class CloneDetailComponent implements OnInit {

  @Input() clone: Clone;
  
  constructor() { }

  ngOnInit() {
  }

}
