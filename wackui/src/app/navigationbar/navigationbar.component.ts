import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { UserAccountAuthService } from '../user-account-auth.service';

@Component({
  selector: 'app-navigationbar',
  templateUrl: './navigationbar.component.html',
  styleUrls: ['./navigationbar.component.css'],
})
export class NavigationbarComponent implements OnInit {
  isLoggedIn: boolean = false;

  constructor(
    private userAuth: UserAccountAuthService,
    private router: Router
  ) {}

  ngOnInit(): void {
    var email = this.userAuth.getUserData('email');
    if (email != null) this.isLoggedIn = true;
    else this.isLoggedIn = false;
    // location.reload();
  }

  tabClicked(tab: string) {
    if (tab == 'signup') {
      this.router.navigateByUrl('/acc/signup');
      window.location.reload();
    } else if (tab == 'login') {
      this.router.navigateByUrl('/acc/login');
    } else if (tab == 'logout') {
      this.userAuth.clearCookies();
      this.router.navigateByUrl('');
    } else {
      this.router.navigateByUrl('/donation/' + tab);
    }
  }
}
