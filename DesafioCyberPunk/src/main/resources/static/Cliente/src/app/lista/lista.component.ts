import { Component, OnInit } from '@angular/core';
import { CloneService } from '../servicos/clone.service';
import { Clone } from '../clone'
import { Router } from '@angular/router';

@Component({
  selector: 'app-lista',
  templateUrl: './lista.component.html',
  styleUrls: ['./lista.component.css']
})
export class ListaComponent implements OnInit {

  private clones:Clone[];



  constructor(private _cloneService: CloneService, private _router: Router) {

  }

  ngOnInit() {
  	this._cloneService.getClones().subscribe((Clones) => {
      console.log(Clones);
      this.clones = Clones;
    },(Error)=>{
      console.log(Error)
    });  	
  }

  deleteClone(clone:Clone){
    this._cloneService.deleteclone(clone.id).subscribe((data)=>{
      this.clones.splice(this.clones.indexOf(clone), 1);
    }, (error)=>{
      console.log(error);
    })
  }

  updateClone(clone:Clone){
    this._cloneService.setter(clone);
    this._router.navigate(['/op']);
  }

  novoClone(){
    let clone = new Clone();
    this._cloneService.setter(clone);
    this._router.navigate(['/op']);
  }

}
