import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl, AbstractControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

import { Clone } from './../domain/clone/clone.model';
import { ClonesService } from './../domain/clone/clones.service';
import { NotificationService } from './../snackbar/notification.service';
import { todosOsAdicionais } from './../domain/clone/adicional.enum';
import { NomeUnicoValidator } from './../validators/nome-unico.validator';

@Component({
  selector: 'app-form-clones',
  templateUrl: './form-clones.component.html'
})
export class FormClonesComponent implements OnInit {

  cloneForm: FormGroup;
  id: undefined;
  listaDeAdicionais = todosOsAdicionais;

  constructor(private fb: FormBuilder, 
              private activatedRoute: ActivatedRoute,
              private router: Router,
              private clonesServices: ClonesService, 
              private notificationService: NotificationService) { }

  ngOnInit() {
    this.id = this.activatedRoute.snapshot.params['id'];
    this.cloneForm = this.fb.group({
      nome: this.fb.control('', 
        [Validators.required, Validators.pattern('[A-Z]{3}[0-9]{4}')],
        NomeUnicoValidator.criaValidador(this.clonesServices, this.id)
      ),
      idade: this.fb.control('10', [Validators.required, Validators.min(10), Validators.max(20)]),
      adicionais: this.fb.control('')
    });
    this.preencheCampos();
  }

  salva(clone: Clone) {
    if(!this.id) {
      this.clonesServices.salva(clone)
        .subscribe((clone: Clone) => {
          this.router.navigateByUrl('/');
          this.notificationService.notify('Clone cadastrado com sucesso');
        }, err => 
          this.notificationService.notify('Erro ao tentar cadastrar clone')
        );
    } else {
      this.clonesServices.edita(clone, this.id)
        .subscribe(() => {
          this.router.navigateByUrl('/');
          this.notificationService.notify('Clone editado com sucesso');
        }, err => 
          this.notificationService.notify('Erro ao tentar editar clone') 
      );
    }
  }

  preencheCampos() {
    if(this.id) {
      this.clonesServices.buscaPorId(this.id)
        .subscribe((clone: Clone) => {
          this.cloneForm.get('nome').setValue(clone.nome),
          this.cloneForm.get('idade').setValue(clone.idade),
          this.cloneForm.get('adicionais').setValue(clone.adicionais)
        });
    }
  }

  temErros(control: AbstractControl, ...erros): boolean {
    return erros.some(erro => 
      control.hasError(erro) && this.campoUtilizado(control));
  }

  campoUtilizado(control: AbstractControl): boolean {
    return (control.dirty || control.touched);
  }
}
