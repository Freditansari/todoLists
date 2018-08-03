import { Component } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { TokenService } from './Services/token.service';
import {TokenData} from './TokenData';
import { UserData } from './UserData';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontEndApplications';

  constructor() {
  }

}
