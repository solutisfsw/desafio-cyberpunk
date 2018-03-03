import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClonesComponent }      from './clones/clones.component';
import { DashboardComponent }   from './dashboard/dashboard.component';
import { CloneDetailComponent }  from './clone-detail/clone-detail.component';

const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'clones', component: ClonesComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'detail/:id', component: CloneDetailComponent }
];

@NgModule({
  exports: [ RouterModule ],
  imports: [ RouterModule.forRoot(routes)] 
})
export class AppRoutingModule {}
