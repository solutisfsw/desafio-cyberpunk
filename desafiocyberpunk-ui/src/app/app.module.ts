import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';



import { DataTableModule, ButtonModule, InputTextModule,
  InputMaskModule, CalendarModule, DialogModule,DropdownModule, MultiSelectModule, PanelModule, ToolbarModule} from 'primeng/primeng';


import { AppComponent } from './app.component';
import { CloneCadastroComponent } from './clone-cadastro/clone-cadastro.component';
import { CloneService } from './clone/clone.service';
import { IndexComponent } from './index/index.component';
import { ElementoService } from './elemento/elemento.service';
import { ElementoCadastroComponent } from './elemento-cadastro/elemento-cadastro.component';

const appRoutes: Routes = [
  { path: 'cadastroClone', component: CloneCadastroComponent },
  { path: 'cadastroElemento', component: ElementoCadastroComponent },
];

@NgModule({
  declarations: [
    AppComponent,
    CloneCadastroComponent,
    IndexComponent,
    ElementoCadastroComponent,
  ],
  imports: [
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } // <-- debugging purposes only
    ),
    BrowserModule,
    DataTableModule,
    ButtonModule,
    DialogModule,
    FormsModule,
    BrowserAnimationsModule,
    InputTextModule,
    InputMaskModule,
    CalendarModule,
    HttpClientModule,
    MultiSelectModule,
    DropdownModule,
    PanelModule,
    ToolbarModule
  ],
  providers: [
    CloneService,
    ElementoService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
