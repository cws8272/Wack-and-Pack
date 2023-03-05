import { Component, OnInit } from '@angular/core';
import { Location } from 'src/types/Location';

@Component({
  selector: 'app-donation-category',
  templateUrl: './donation-category.component.html',
  styleUrls: ['./donation-category.component.css'],
})
export class DonationCategoryComponent implements OnInit {
  category: string = 'Food';

  searchResults: Location[] = [
    { locationName: 'Rochester Food Drive', address: '123 Main Street' },
    { locationName: 'Rochester Food Drive', address: '123 Main Street' },
  ];

  constructor() {}

  ngOnInit(): void {}
}
