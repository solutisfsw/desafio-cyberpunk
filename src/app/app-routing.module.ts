import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClonesComponent }      from './clones/clones.component';
import { DashboardComponent }   from './dashboard/dashboard.component';

const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'clones', component: ClonesComponent },
  { path: 'dashboard', component: DashboardComponent },
];

@NgModule({
  exports: [ RouterModule ],
  imports: [ RouterModule.forRoot(routes)] 
})
export class AppRoutingModule {}
