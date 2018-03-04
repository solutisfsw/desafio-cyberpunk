import { Component, OnInit } from '@angular/core';
import { Clone } from '../clone';
import { CloneService } from './clone.service';
import { ExtraEquipService } from './extra-equip.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  
  constructor(private cloneService  : CloneService,private extraEquipService : ExtraEquipService ){
  }
  
  clonesA: Clone[];
  title = 'app';
  clone : Clone;

  ngOnInit(): void {
   this.getClones();
  }

  getClones()  {
    this.cloneService.getAllClones().subscribe(x => {
      this.clonesA = x;
      console.log(this.clonesA);
      console.log("função getClones chamada com sucesso.");
    });
  }

  deleteClone(id: number) {
    this.cloneService.deleteClone(id);
  }

  getExtraEquip(){
    this.extraEquipService.getAllExtraEquip().subscribe(x => {
      console.log("Função getExtraEquip chamada com sucesso.");
    });
  }

  getExtraEquipById(id: number){
    this.extraEquipService.getExtraEquipbyId(id);

  }
}
