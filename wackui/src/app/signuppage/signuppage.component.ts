import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/types/User';

import { UserAccountAuthService } from '../user-account-auth.service';

@Component({
  selector: 'app-signuppage',
  templateUrl: './signuppage.component.html',
  styleUrls: ['./signuppage.component.css'],
})
export class SignuppageComponent implements OnInit {
  scenario = 'signup';

  constructor(
    private userAuth: UserAccountAuthService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    var sce = this.route.snapshot.paramMap.get('scenario');
    if (sce != null) this.scenario = sce;
    else this.scenario = 'sign up';
  }

  register(
    firstname: string,
    lastname: string,
    email: string,
    password: string
  ) {
    var user: User = {
      userId: 0,
      firstname: firstname,
      lastname: lastname,
      email: email,
      password: password,
      points: 0,
    };
    var result = this.userAuth.registerAndCheck(user).subscribe();
    if (result != null) {
      console.log('going to the comfirmation page');
      this.router.navigateByUrl('/signupcomplete');
    }
  }

  login(email: String, password: String) {
    var result = this.userAuth.loginAndCheck(email, password).subscribe();
    if (result != null) {
      console.log('going to the food page');
      this.router.navigateByUrl('/donation/food');
    }
  }
}
