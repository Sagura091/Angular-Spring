import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = 'javainuse'
  password = '';
  invalidLogin = false;

  constructor(private router: Router,
    private loginservice: AuthenticationService) { }

  ngOnInit(): void {
  }

  checkLogin() {

    console.log("CheckLogin");
    console.log(this.username);
    console.log(this.password);


    if(this.loginservice.authenticate(this.username,this.password))
    {
      console.log(" this.invalidLogin = false;");
      this.router.navigate([''])
      this.invalidLogin = false;
    }
    else
    {
      console.log("  this.invalidLogin = true;");
      this.invalidLogin = true;
    }



  }

}
