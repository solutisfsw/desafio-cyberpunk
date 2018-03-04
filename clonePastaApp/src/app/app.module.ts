import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {CloneService} from './clone.service';
import {ExtraEquipService} from './extra-equip.service'; 


import { AppComponent } from './app.component';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,

  ],
  providers: [CloneService,ExtraEquipService, HttpClientModule],
  bootstrap: [AppComponent],
})
export class AppModule { }
