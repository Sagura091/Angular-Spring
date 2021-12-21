import { Injectable } from "@angular/core";

const TOKEN_KEY = 'auth-token';
const USER_KEY = 'auth-user'

@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {

  constructor() { window.sessionStorage.clear()}

  signout() {

    window.sessionStorage.clear();
    window.sessionStorage.clear();
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.removeItem(USER_KEY);

  }

  public saveToken(token: string)
  {

    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.setItem(TOKEN_KEY,token);

  }

  public getToken(): string | null {

    if(sessionStorage.getItem(TOKEN_KEY) === null)
    {
      return "No Item in session";
    }
    return sessionStorage.getItem(TOKEN_KEY);
  }

  public saveUser(user: any) {

    console.log("Saving the tokem");
    window.sessionStorage.removeItem(USER_KEY);
    window.sessionStorage.setItem(USER_KEY, JSON.stringify(user));
  }



  public getUser() {

    // used let so that it can store either a string or a null;
    let returnurl = sessionStorage.getItem(USER_KEY);
    return JSON.parse(returnurl || '{}');
  }



}
