import { Component, OnInit } from '@angular/core';
import { Clone } from '../clone';
import { CLONES } from '../mock-clones';

@Component({
  selector: 'app-clones',
  templateUrl: './clones.component.html',
  styleUrls: ['./clones.component.css']
})

export class ClonesComponent implements OnInit {

  selectedClone: Clone;

  onSelect(clone, Clone): void {
    this.selectedClone = clone;
  }

  clones = CLONES;

  constructor() { }

  ngOnInit() {
  }

}
