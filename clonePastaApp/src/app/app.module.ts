import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {CloneService} from './clone.service';
import {ExtraEquipService} from './extra-equip.service'; 
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { AppComponent } from './app.component';
import {MatInputModule} from '@angular/material/input';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatSelectModule} from '@angular/material/select';




@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatInputModule,
    FormsModule,
    MatInputModule,    
    MatSelectModule,
    ReactiveFormsModule,

  ],
  providers: [CloneService,ExtraEquipService, HttpClientModule],
  bootstrap: [AppComponent],
})
export class AppModule { }
