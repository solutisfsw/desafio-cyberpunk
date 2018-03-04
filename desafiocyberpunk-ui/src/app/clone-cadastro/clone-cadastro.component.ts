import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { CloneService } from '../clone/clone.service';
import { Clone } from '../clone/clone';
import { NgModel } from '@angular/forms';
import { NgIf } from '@angular/common';
import { SelectItem } from 'primeng/api';
import { NgForOf } from '@angular/common';
import { ElementoService } from '../elemento/elemento.service';
import { HttpErrorResponse } from '@angular/common/http';




@Component({
  selector: 'app-clone-cadastro',
  templateUrl: './clone-cadastro.component.html',
  styleUrls: ['./clone-cadastro.component.css']
})
export class CloneCadastroComponent implements OnInit {
  clones = [];
  resposta;
  elementos = [];
  public clone = <any>{ elementos: <any>[] };
  public novoClone = <any>{ elementos: <any>[] };
  cloneSelecionado: Clone;
  displayDialog: boolean;
  display: boolean = false;
  erro;

  constructor(private cloneService: CloneService, private elementoService: ElementoService) { }

  ngOnInit() {
    this.consultar();
    this.consultarElemento();
    console.log(this.clone)
  }
  consultarElemento() {
    this.elementoService.listar().subscribe(dados => this.elementos = dados);
  }

  consultar() {
    this.cloneService.listar().subscribe(dados => this.clones = dados);
  }

  adicionar(frm: any) {
    if (this.novoClone.idade < 10 || this.novoClone.idade > 20) {
      this.erro = "A idade deve ser entre 10 e 20 anos";
      this.display = true;
    } else {
      this.cloneService.adicionar(this.novoClone).subscribe((result => {
        if (result != null) {
          frm.reset();
          this.consultar();
          return;
        }
        this.erro = "Este clone ja está cadastrado";
        this.display = true;
      }));
    }
  }

  deletar(id) {

    this.cloneService.deletar(id).subscribe(() => {
      this.consultar();
      this.displayDialog = false;
    })
  }


  atualizar() {
    if (this.clone.idade < 10 || this.clone.idade > 20) {
      this.erro = "A idade deve ser entre 10 e 20 anos";
      this.display = true;
    }else{
      this.cloneService.atualizar(this.clone).subscribe(() => {
        this.consultar();
        this.displayDialog = false;
      })
    }
   
  }

  

  showDialog() {
    this.display = true;
  }

  showDialogToAdd() {
    this.clone = {};
    this.displayDialog = true;
  }
  dBClick(event) {
    console.log(this.cloneSelecionado);
    this.clone = this.cloneSelecionado;
    this.displayDialog = true;
  }

}
