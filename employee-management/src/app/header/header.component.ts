import { Component, OnInit } from '@angular/core';
import { AuthService } from '../service/auth.service';
import { AuthenticationService } from '../service/authentication.service';
import { TokenStorageService } from '../service/token.storage.service';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  private roles!: string[];
  isLoggedIn = false;
  showAdminBoard = false;
  showModeratorBoard = false;
  username!: string;
  Role!: string;
  constructor(public loginService: AuthService,private tokenStorageService: TokenStorageService) { }

  ngOnInit(): void {


   this.isLoggedIn = !!this.tokenStorageService.getToken();
    console.log(this.isLoggedIn);
        if (this.isLoggedIn) {
          const user = this.tokenStorageService.getUser();
          this.roles = user.roles;

          //this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
          //this.showModeratorBoard = this.roles.includes('ROLE_MODERATOR');

          this.username = user.username;
  }
}
logout() {
  console.log("Logging out");
  this.isLoggedIn = false;
  this.tokenStorageService.signout();
  window.location.reload();
}
}
