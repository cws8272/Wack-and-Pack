import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CategoriesComponent } from './categories/categories.component';
import { HomepageComponent } from './homepage/homepage.component';
import { NavigationbarComponent } from './navigationbar/navigationbar.component';
import { SignuppageComponent } from './signuppage/signuppage.component';
import { SignupcompletepageComponent } from './signupcompletepage/signupcompletepage.component';
import { UseraccountpageComponent } from './useraccountpage/useraccountpage.component';

@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
    NavigationbarComponent,
    CategoriesComponent,
    SignuppageComponent,
    SignupcompletepageComponent,
    UseraccountpageComponent,
  ],
  imports: [BrowserModule, AppRoutingModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
