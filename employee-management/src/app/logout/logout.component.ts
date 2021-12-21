import { TokenStorageService } from './../service/token.storage.service';
import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../service/authentication.service';
import { Router } from '@angular/router';
import { AuthService } from '../service/auth.service';
@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private authentocationService: AuthService,
    private router: Router, private token: TokenStorageService) { }

  ngOnInit(): void {

   console.log("Logging out");
   this.token.signout();
   this.router.navigate(['login']);
   this.authentocationService.setUserLogin(false);
   //window.location.reload();
  }

}
