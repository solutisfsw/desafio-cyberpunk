declare const jQuery:any;

import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormBuilder } from '@angular/forms';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/switchMap';
import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/distinctUntilChanged';

import { Page } from './../domain/shared/page.model';
import { Clone } from './../domain/clone/clone.model';
import { getAdicional } from './../domain/clone/adicional.enum';
import { ClonesService } from './../domain/clone/clones.service';
import { NotificationService } from './../snackbar/notification.service';

@Component({
  selector: 'app-tabela-clones',
  templateUrl: './tabela-clones.component.html',
  styleUrls: ['./tabela-clones.component.css']
})
export class TabelaClonesComponent implements OnInit {

  page: Page;
  cloneRemove: Clone;
  searchControl: FormControl;
  searchForm: FormGroup;

  constructor(private fb: FormBuilder,
              private clonesService: ClonesService, 
              private notificationService: NotificationService) { }

  ngOnInit() {
    this.listaClones();
    this.configSearchControl();    
  }

  remove(id: number) {
    this.clonesService.remove(id)
      .subscribe(() => {
        this.notificationService.notify('Clone removido com sucesso');
        this.listaClones();
      }, err => 
        this.notificationService.notify('Error ao tentar realizar a operação')
      , () => jQuery('#deleteModal').modal('toggle'));
  }

  listaClones(pagina = 0, busca = '') {
    this.clonesService.buscaTodos(pagina, busca)
      .subscribe((page: Page) => this.page = page
      , err => this.notificationService.notify('Erro ao tentar listar os clones'));
  }

  mudaPagina(numeroDaPagina: number) {
    this.listaClones(numeroDaPagina);
  }

  getTextoDoAdicional(key) {
    return getAdicional(key);
  }

  configSearchControl() {
    this.searchControl = this.fb.control('');
    this.searchForm = this.fb.group({
      searchControl: this.searchControl
    });
    this.searchControl.valueChanges
      .debounceTime(500)
      .distinctUntilChanged()
      .switchMap(query => this.clonesService.buscaTodos(0, query))
      .subscribe((page: Page) => this.page = page);
  }
}
