import { Component, OnInit } from '@angular/core';
import { Clone } from '../clone';
import { CloneService } from '../clone.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: [ './dashboard.component.css' ]
})
export class DashboardComponent implements OnInit {
  clones: Clone[] = [];

  constructor(private cloneService: CloneService) { }

  ngOnInit() {
    this.getClones();
  }

  getClones(): void {
    this.cloneService.getClones()
      .subscribe(clones => this.clones = clones.slice(1, 5));
  }
}