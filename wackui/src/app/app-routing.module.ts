import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomepageComponent } from './homepage/homepage.component';
import { SignupcompletepageComponent } from './signupcompletepage/signupcompletepage.component';
import { SignuppageComponent } from './signuppage/signuppage.component';
import { UseraccountpageComponent } from './useraccountpage/useraccountpage.component';

const routes: Routes = [
  {path: '', component: HomepageComponent},
  {path: 'signup', component: SignuppageComponent},
  {path: 'signupcomplete', component: SignupcompletepageComponent},
  {path: 'useraccount', component: UseraccountpageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
