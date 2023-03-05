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
import { HttpClientModule } from '@angular/common/http';
import { CookieService } from 'ngx-cookie-service';
import { FoodComponent } from './food/food.component';
import { DonationCategoryComponent } from './donation-category/donation-category.component';

@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
    NavigationbarComponent,
    CategoriesComponent,
    SignuppageComponent,
    SignupcompletepageComponent,
    UseraccountpageComponent,
    FoodComponent,
    DonationCategoryComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule],
  providers: [CookieService],
  bootstrap: [AppComponent],
})
export class AppModule {}
