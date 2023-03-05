import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-signupcompletepage',
  templateUrl: './signupcompletepage.component.html',
  styleUrls: ['./signupcompletepage.component.css'],
})
export class SignupcompletepageComponent implements OnInit {
  constructor(private route: Router) {}

  ngOnInit(): void {}

  goToCategory(category: string) {
    this.route.navigateByUrl('/donation/' + category);
  }
}
