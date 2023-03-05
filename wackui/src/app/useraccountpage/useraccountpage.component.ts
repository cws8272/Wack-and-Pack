import { Component, OnInit } from '@angular/core';
import { UserAccountAuthService } from '../user-account-auth.service';

@Component({
  selector: 'app-useraccountpage',
  templateUrl: './useraccountpage.component.html',
  styleUrls: ['./useraccountpage.component.css'],
})
export class UseraccountpageComponent implements OnInit {
  name: String = 'Janette DoaAnne';
  email: String = 'janedoe@gmail.com';
  address: String = '1234 Main Street, Plano Texas';
  points: String = '60';

  constructor(private userAuth: UserAccountAuthService) {}

  ngOnInit(): void {
    this.name =
      this.userAuth.getUserData('firstname') +
      ' ' +
      this.userAuth.getUserData('lastname');
    this.email = this.userAuth.getUserData('email');
    this.address = this.userAuth.getUserData('address');
    this.points = this.userAuth.getUserData('points');
  }
}
