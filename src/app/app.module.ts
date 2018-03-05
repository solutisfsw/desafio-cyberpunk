import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { ClonesComponent } from './clones/clones.component';
import { ClonesDetailComponent } from './clones-detail/clones-detail.component';
import { ClonesCreateComponent } from './clones-create/clones-create.component';
import { ClonesEditComponent } from './clones-edit/clones-edit.component';

const appRoutes: Routes = [
  {
    path: 'clones',
    component: ClonesComponent,
    data: { title: 'Clones List' }
  },
  {
    path: 'clones-details/:id',
    component: ClonesDetailComponent,
    data: { title: 'Clone Details' }
  },
  {
    path: 'clones-create',
    component: ClonesCreateComponent,
    data: { title: 'Create Clone' }
  },
  {
    path: 'clones-edit/:id',
    component: ClonesEditComponent,
    data: { title: 'Edit Clone' }
  },
  { path: '',
    redirectTo: '/clones',
    pathMatch: 'full'
  }
];

@NgModule({
  declarations: [
    AppComponent,
    ClonesComponent,
    ClonesDetailComponent,
    ClonesCreateComponent,
    ClonesEditComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
  	HttpClientModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } // <-- debugging purposes only
    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
