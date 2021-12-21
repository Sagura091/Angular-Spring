import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from "@angular/core";
import { Observable} from 'rxjs';
import { TokenStorageService } from './token.storage.service';

const AUTH_API = 'http://localhost:8080/employees/auth/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class AuthService {

   Isloggedin: boolean = false;
  constructor(private http: HttpClient, private tokenStorage: TokenStorageService) {}

  login(credentials: { username: any; password: any; }) : Observable<any> {
    return this.http.post(AUTH_API + 'signin', {
      username: credentials.username,
      password: credentials.password
    },httpOptions);

  }

  register(user: { username: any; email: any; password: any; }): Observable<any> {
    return this.http.post(AUTH_API + 'signup', {
      username: user.username,
      email: user.email,
      password: user.password
    }, httpOptions);
  }

  isUserLoggedIn() {


    return this.Isloggedin;//this.router.navigate(['']);;
  }

  setUserLogin(login: boolean)
  {
    this.Isloggedin = login;
  }
  getAuthToken():string | null {
    return  window.sessionStorage.getItem('token');
    }




}
