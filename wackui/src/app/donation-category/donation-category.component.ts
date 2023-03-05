import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Location } from 'src/types/Location';
import { LocationSearchService } from '../location-search.service';

@Component({
  selector: 'app-donation-category',
  templateUrl: './donation-category.component.html',
  styleUrls: ['./donation-category.component.css'],
})
export class DonationCategoryComponent implements OnInit {
  category: string = 'Food';

  searchResults: Location[] = [
    {
      locationId: '22',
      locationName: 'Rochester Food Drive',
      address: '123 Main Stree',
      longitude: '90',
      latitude: '99',
      donationType: 'Food',
    },
    {
      locationId: '22',
      locationName: 'Rochester Food Drive',
      address: '123 Main Stree',
      longitude: '90',
      latitude: '99',
      donationType: 'Food',
    },
  ];

  constructor(
    private locationSearch: LocationSearchService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    // window.location.reload();

    var cat = this.route.snapshot.paramMap.get('type');
    if (cat != null) {
      this.category = cat;
      this.category = this.category;
    }
  }

  search(query: string) {
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition((position) => {
        const longitude = position.coords.longitude;
        const latitude = position.coords.latitude;
        var pinnedLocation: Location = {
          locationId: '22',
          locationName: query,
          address: '123 Main Street',
          longitude: longitude.toString(),
          latitude: latitude.toString(),
          donationType: this.category,
        };
        this.locationSearch
          .searchNearbyLocation(pinnedLocation)
          .subscribe((locationResults) => {
            this.searchResults = locationResults;
            this.searchResults = this.searchResults;
          });
      });
    }
  }
}
