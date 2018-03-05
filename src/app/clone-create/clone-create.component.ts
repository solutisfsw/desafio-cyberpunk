import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';
import { Clone } from '../clone';
import { CloneService } from '../clone.service';
import { PARTS } from '../mock-parts';
import { AppComponent } from '../app.component';



@Component({
  selector: 'app-clone-create',
  templateUrl: './clone-create.component.html',
  styleUrls: ['./clone-create.component.css']
})
export class CloneCreateComponent implements OnInit {
  parts: String[] = [
    'raio laser', 'braço mecânico', 'esqueleto reforçado', 'sentidos aguçados', 'pele adaptativa'];
  selectedPart: string;
  cloneName: string;
  cloneAge: number;
  @Input() clone: Clone;

  constructor(
    private route: ActivatedRoute,
    private cloneService: CloneService,
    private location: Location,
    private appComponent: AppComponent,
    private router: Router) { }


  ngOnInit() {

    this.clone = new Clone();
    this.clone.date = new Date();
    this.clone.parts = [];
  }

  addClone(): void {
    this.clone.name = this.cloneName;
    this.clone.age = this.cloneAge;
    this.cloneService.createClone(this.clone)
      .subscribe(clone => this.clone = clone);
    this.appComponent.countClones = this.cloneService.getTotal();  
    this.router.navigate(['dashboard']);
  }

  addPart(): void {
    if (this.selectedPart != undefined) {
      let partAdded = this.clone.parts.find((e) => e === this.selectedPart);
      if (partAdded != this.selectedPart){
        this.clone.parts.push(this.selectedPart);
      }
    }
  }

  goBack(): void {
    this.location.back();
  }

}