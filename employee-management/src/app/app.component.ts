import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from './service/token.storage.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  private roles!: string[];
  isLoggedIn = false;
  showAdminBoard = false;
  showModeratorBoard = false;
  username!: string;

  constructor(private tokenStorageService: TokenStorageService) { }

  ngOnInit() {


    }


}
