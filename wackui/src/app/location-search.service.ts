import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { catchError, Observable, of, tap } from 'rxjs';
import { Location } from 'src/types/Location';

@Injectable({
  providedIn: 'root',
})
export class LocationSearchService {
  private locationSearchUrl = 'http://localhost:8080/location'; // URL to web api
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
  };

  constructor(private http: HttpClient, private cookieService: CookieService) {}

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  searchNearbyLocation(loc: Location): Observable<Location[]> {
    var searchURL =
      `${this.locationSearchUrl}/search?` +
      `locationName=${loc.locationName}&longitude=${loc.longitude}&` +
      `latitude=${loc.latitude}&donationType=${loc.donationType}&`;
    return this.http.get<Location[]>(searchURL, {}).pipe(
      tap((locations: Location[]) => {}),
      catchError(this.handleError<Location[]>('search'))
    );
  }
}
