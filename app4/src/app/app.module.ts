import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import{HttpModule} from '@angular/http'
import {FormsModule} from '@angular/forms'
import{RouterModule}from '@angular/router'
import {ROUTES} from './app.routes'


import { AppComponent } from './app.component';
import {TopoComponent} from './topo/topo.component';
import { PainelComponent } from './painel/painel.component';



import{AngularFireModule} from 'angularfire2';
import { environment } from '../environments/environment';
import { ConsultaComponent } from './consulta/consulta.component';
//import{AngularFireModule} from '../../node_modules/angularfire2';
//import { FirebaseConfig } from '../environments/firebase.config';



export const FirebaseConfig  = {
  apiKey: "AIzaSyBQgbQLPr82j7FeFLWVV_F_CXszy9X14ds",
  authDomain: "testando-85949.firebaseapp.com",
  databaseURL: "https://testando-85949.firebaseio.com",
  projectId: "testando-85949",
  storageBucket: "testando-85949.appspot.com",
  messagingSenderId: "706820937167"
};


@NgModule({
  declarations: [
    AppComponent,
    TopoComponent,
    PainelComponent,
    ConsultaComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AngularFireModule.initializeApp(FirebaseConfig),
    RouterModule.forRoot(ROUTES)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
