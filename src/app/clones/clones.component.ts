import { Component, OnInit } from '@angular/core';
import { Clone } from '../clone';

@Component({
  selector: 'app-clones',
  templateUrl: './clones.component.html',
  styleUrls: ['./clones.component.css']
})

export class ClonesComponent implements OnInit {

  clone: Clone = {
    id: 1,
    name: 'Cyber01A'
  }
  constructor() { }

  ngOnInit() {
  }

}
