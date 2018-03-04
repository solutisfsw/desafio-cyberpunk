import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';
import { ClonesService } from './domain/clone/clones.service';
import { NotificationService } from './snackbar/notification.service';
import { TabelaClonesComponent } from './tabela-clones/tabela-clones.component';
import { FormClonesComponent } from './form-clones/form-clones.component';
import { ModalDeleteComponent } from './modal-delete/modal-delete.component';
import { SnackbarComponent } from './snackbar/snackbar.component';
import { PaginacaoComponent } from './paginacao/paginacao.component';
import { InputComponent } from './input/input.component';

const ROUTES: Routes = [
  { path: '', component: TabelaClonesComponent },
  { path: 'novo', component: FormClonesComponent },
  { path: 'edita/:id', component: FormClonesComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    TabelaClonesComponent,
    FormClonesComponent,
    SnackbarComponent,
    ModalDeleteComponent,
    PaginacaoComponent,
    InputComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot(ROUTES),
    BrowserAnimationsModule
  ],
  providers: [ClonesService, NotificationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
