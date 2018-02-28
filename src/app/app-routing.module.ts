import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClonesComponent }      from './clones/clones.component';

const routes: Routes = [
  { path: 'clones', component: ClonesComponent }
];

@NgModule({
  exports: [ RouterModule ],
  imports: [ RouterModule.forRoot(routes)] 
})
export class AppRoutingModule {}
