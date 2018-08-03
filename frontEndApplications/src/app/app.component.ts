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

  constructor(private _http: HttpClient, private tokenService: TokenService) {
  }
  userData: UserData = new UserData();
  token = '';
  error = '';


  getToken() {
   this.tokenService.getToken(this.userData).subscribe(res => {
      this.token = res.access_token;
      this.error = '';
    }, err => {
      this.token = '';
      this.error = 'Error';
    }
  );
  }

  getUsernameOfToken(tokenInfo) {

    this._http.post('http://localhost:8080/api/getUserName',
    {withCredentials: true},
    {headers: new HttpHeaders(
      {'Authorization': 'Bearer ' + tokenInfo['access_token']
  })
  })
    .subscribe(res => {
      console.log(res);
     });

  }


}
