import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DonationCategoryComponent } from './donation-category/donation-category.component';
import { HomepageComponent } from './homepage/homepage.component';
import { SignupcompletepageComponent } from './signupcompletepage/signupcompletepage.component';
import { SignuppageComponent } from './signuppage/signuppage.component';
import { UseraccountpageComponent } from './useraccountpage/useraccountpage.component';

const routes: Routes = [
  { path: '', component: HomepageComponent },
  { path: 'acc/:scenario', component: SignuppageComponent },
  { path: 'donation/:type', component: DonationCategoryComponent },
  { path: 'signupcomplete', component: SignupcompletepageComponent },
  { path: 'useraccount', component: UseraccountpageComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
