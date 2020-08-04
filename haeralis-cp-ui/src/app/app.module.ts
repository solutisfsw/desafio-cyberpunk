import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, FormGroup }   from '@angular/forms';
import { MatDialogModule } from '@angular/material';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations'


import { AppComponent } from './app.component';
import { MenubarComponent } from './menubar/menubar.component';
import { AttributeMngComponent } from './attribute-mng/attribute-mng.component';
import { AttributeService } from './attribute-mng/service/attribute.service';
import { CyberpunkService } from './cyberpunk-mng/service/cyberpunk.service';
import { DialogUtilsComponent } from './dialog-utils/dialog-utils.component';
import { SimpleMessageDialog } from './dialog-utils/dialog-utils.component';
import { CyberpunkMngComponent } from './cyberpunk-mng/cyberpunk-mng.component';

const routes: Routes = [
  { path: '', redirectTo: '/', pathMatch: 'full' },
  { path: 'attribute', component: AttributeMngComponent },
  { path: 'cyberpunk', component: CyberpunkMngComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    MenubarComponent,
    AttributeMngComponent,
    DialogUtilsComponent,
    SimpleMessageDialog,
    CyberpunkMngComponent
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    HttpClientModule,
    MatDialogModule,
    BrowserAnimationsModule,
    FormsModule
  ], 
  exports: [
     RouterModule 
  ], 
  entryComponents: [
    SimpleMessageDialog
  ],
  providers: [
    AttributeService,
    CyberpunkService,
    DialogUtilsComponent
  ],
  bootstrap: [
    AppComponent]
})

export class AppModule { }
