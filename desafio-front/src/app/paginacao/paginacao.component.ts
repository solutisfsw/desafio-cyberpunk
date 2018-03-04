import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

import { Page } from './../domain/shared/page.model';

@Component({
  selector: 'app-paginacao',
  templateUrl: './paginacao.component.html'
})
export class PaginacaoComponent implements OnInit {

  numeros: Array<number>;

  @Input() page: Page;
  @Output() mudancaDePagina = new EventEmitter<number>();

  constructor() { }

  ngOnInit() {
  }

  geraIndices(totalDePaginas: number) {
    if(totalDePaginas)
      return this.numeros = Array(totalDePaginas).fill(1).map((x,i)=>i);

    return [];
  }

  mudaPagina(numeroDaPagina: number) {
    if(numeroDaPagina !== this.page.number)
      this.mudancaDePagina.emit(numeroDaPagina);
  }

  mudaParaAnterior() {
    if(!this.page.first)
      this.mudancaDePagina.emit(this.page.number - 1);
  }

  mudaParaProxima() {
    if(!this.page.last)
      this.mudancaDePagina.emit(this.page.number + 1);
  }
}
