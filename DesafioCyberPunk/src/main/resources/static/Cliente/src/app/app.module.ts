import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HttpModule } from '@angular/http';
import { AppComponent } from './app.component';
import { ListaComponent } from './lista/lista.component';
import { CloneFormComponent } from './clone-form/clone-form.component';
import { CloneService } from './servicos/clone.service';
import { FormsModule, ReactiveFormsModule, Validator} from '@angular/forms';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';
import { SortableModule } from 'ngx-bootstrap';
const appRoutes: Routes =[
{ path : '', component   : ListaComponent},
{ path : 'op', component : CloneFormComponent}
]

@NgModule({
  declarations: [

    AppComponent,
    ListaComponent,
    CloneFormComponent,
     
  ],
  imports: [
     SortableModule.forRoot(),
     BsDatepickerModule.forRoot(),
     FormsModule,
     BrowserModule,
     HttpModule,
     ReactiveFormsModule,
     RouterModule.forRoot(appRoutes)
  ],
  providers: [CloneService],
  bootstrap: [AppComponent]
})
export class AppModule { }
