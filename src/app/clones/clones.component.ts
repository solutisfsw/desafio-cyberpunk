import { Component, OnInit } from '@angular/core';
import { Clone } from '../clone';
import { CloneService } from '../clone.service';

@Component({
  selector: 'app-clones',
  templateUrl: './clones.component.html',
  styleUrls: ['./clones.component.css']
})

export class ClonesComponent implements OnInit {
  clones: Clone[];

  constructor(private cloneService: CloneService) { }

  ngOnInit() {
    this.getClones();
  }

  getClones(): void {
    this.cloneService.getClones()
      .subscribe(clones => this.clones = clones);
  }

}
