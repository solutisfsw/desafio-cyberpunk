import { Component, OnInit } from '@angular/core';
import { Clone } from '../clone';
import { CloneService } from './clone.service';
import { ExtraEquipService } from './extra-equip.service';
import { ExtraEquip } from '../extra-equip';
import { FormControl } from '@angular/forms';
import { NgModel } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  
  constructor(private cloneService  : CloneService,private extraEquipService : ExtraEquipService ){
  
  }
  
  clones: Clone[];
  title = 'app';
  clone : Clone;
  equipamentos: ExtraEquip[];
  cloneForm = new FormControl();


  ngOnInit(): void {
   this.getClones();
   this.clone = new Clone();
   this.getExtraEquip();
  }

  getClones()  {
    this.cloneService.getAllClones().subscribe(x => {
      this.clones = x;
    });
  }

  deleteClone(clone: Clone) {
    this.cloneService.deleteClone(clone.id);
    this.getClones();
    alert("Clone deletado com sucesso");
  }

  getExtraEquip(){
    this.extraEquipService.getAllExtraEquip().subscribe(x => {
      this.equipamentos = x;
    });
  }

  getExtraEquipById(id: number){
    this.extraEquipService.getExtraEquipbyId(id);

  }

  salvarClone(){
    this.cloneService.postClone(this.clone).subscribe(result =>{},
      err => {
        if(err.error.errors == undefined)
          alert(err.error.message);
        else{
          console.log(err.error.errors);
          err.error.errors.forEach(error => {
            alert(error.defaultMessage);
        });
      }
    },

      () => { 
        alert('Salvo com sucesso');
        this.getClones();
        this.clone = new Clone();
      });
  }

  editarClone(clone: Clone){
    this.clone = new Clone();
    this.clone = clone;
  }

  cancelar(){
    this.clone = new Clone();
  }

}
