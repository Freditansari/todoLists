import { Injectable } from '@angular/core';
import { HttpHeaders, HttpParams} from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
import { TokenData } from '../TokenData';
import { UserData } from '../UserData';

@Injectable({
  providedIn: 'root'
})
export class TokenService {
  
  domainname='http://localhost:8080';
  constructor( private _http: HttpClient) { }

  getToken(userData: UserData) {
    const getTokenUrl = this.domainname+'/oauth/token';
    const getTokenParameters: HttpParams = new HttpParams()
    .append('grant_type', 'password')
    .append('username', userData.username)
    .append('password', userData.password);

    const getTokenHeaders: HttpHeaders = new HttpHeaders()
    .append('Authorization', 'Basic ' + btoa('client:secret'));


    return this._http.post<TokenData>(getTokenUrl, {withCredentials: true}
      , {headers: getTokenHeaders, params : getTokenParameters});
  }

  }
