import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; // <-- NgModel lives here

import { AppComponent } from './app.component';
import { ClonesComponent } from './clones/clones.component';
import { CloneDetailComponent } from './clone-detail/clone-detail.component';
import { CloneService } from './clone.service';
import { MessagesComponent } from './messages/messages.component';
import { MessageService } from './message.service';
import { AppRoutingModule } from './/app-routing.module';
import { DashboardComponent } from './dashboard/dashboard.component';
import { CloneCreateComponent } from './clone-create/clone-create.component';


@NgModule({
  declarations: [
    AppComponent,
    ClonesComponent,
    CloneDetailComponent,
    MessagesComponent,
    DashboardComponent,
    CloneCreateComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [
    CloneService,
    MessageService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
