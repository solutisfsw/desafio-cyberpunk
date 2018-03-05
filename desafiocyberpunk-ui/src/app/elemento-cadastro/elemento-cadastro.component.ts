import { Component, OnInit } from '@angular/core';
import { Elemento } from '../elemento/elemento';
import { ElementoService } from '../elemento/elemento.service';

@Component({
  selector: 'app-elemento-cadastro',
  templateUrl: './elemento-cadastro.component.html',
  styleUrls: ['./elemento-cadastro.component.css']
})
export class ElementoCadastroComponent implements OnInit {

  constructor(private elementoService: ElementoService) { }

  resposta;
  elemento: Elemento;
  elementos = [];;
  public novoElemento = <any>{};
  elementoSelecionado: Elemento;
  displayDialog: boolean;

  ngOnInit() {
    this.consultar();
  }

  consultar() {
    this.elementoService.listar().subscribe(dados => this.elementos = dados);
  }

  adicionar(frm: any) {
    this.elementoService.adicionar(this.novoElemento).subscribe(error => {
      console.log(error);
      frm.reset();
      this.consultar();
    });
  }

  deletar(id) {
    this.elementoService.deletar(id).subscribe(() => {
      this.consultar();
      this.displayDialog = false;
    })
  }

  atualizar() {
    this.elementoService.atualizar(this.elemento).subscribe(() => {
      this.consultar();
      this.displayDialog = false;
    })
  }

  //dialogo primeng
  showDialogToAdd() {
    this.elemento = {};
    this.displayDialog = true;
  }

  dBClick(event) {
    this.elemento = this.elementoSelecionado;
    this.displayDialog = true;
  }

}
