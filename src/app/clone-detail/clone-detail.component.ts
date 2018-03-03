import { Component, OnInit, Input } from '@angular/core';
import { Clone } from '../clone';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { CloneService }  from '../clone.service';

@Component({
  selector: 'app-clone-detail',
  templateUrl: './clone-detail.component.html',
  styleUrls: ['./clone-detail.component.css']
})
export class CloneDetailComponent implements OnInit {

  @Input() clone: Clone;
  
  constructor(
    private route: ActivatedRoute,
    private cloneService: CloneService,
    private location: Location
  ) { }

  ngOnInit(): void {
    this.getClone();
  }

  getClone(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.cloneService.getClone(id)
      .subscribe( clone => this.clone = clone);

  }

  goBack(): void {
    this.location.back();
  }

}
