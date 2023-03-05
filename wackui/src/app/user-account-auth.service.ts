import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';

import { catchError, Observable, of, tap } from 'rxjs';
import { User } from 'src/types/User';

@Injectable({
  providedIn: 'root',
})
export class UserAccountAuthService {
  private userAuthUrl = 'http://localhost:8080/users'; // URL to web api
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

  registerAndCheck(user: User): Observable<User> {
    this.clearCookies();
    const registrationURL = `${this.userAuthUrl}/new`;
    return this.http.post<User>(registrationURL, user, this.httpOptions).pipe(
      tap((newUser: User) => {
        this.cookieService.deleteAll();
        this.setUserCookies(newUser);
      }),
      catchError(this.handleError<User>('register'))
    );
  }

  loginAndCheck(username: String, password: String): Observable<User> {
    this.clearCookies();
    const loginURL = `${this.userAuthUrl}/login/?username=${username}&password=${password}`;
    return this.http.get<User>(loginURL, this.httpOptions).pipe(
      tap((returningUser: User) => {
        this.cookieService.deleteAll();
        this.setUserCookies(returningUser);
      }),
      catchError(this.handleError<User>('login'))
    );
  }

  setUserCookies(user: User): void {
    this.cookieService.set('userid', user.userId.toString());
    this.cookieService.set('email', user.email.toString());
    this.cookieService.set('password', user.password.toString());
  }

  getUserData(query: String): string {
    var result = this.cookieService.get(query.toString());
    if (result != null) return result;
    return '';
  }

  clearCookies(): void {
    this.cookieService.deleteAll();
  }
}
