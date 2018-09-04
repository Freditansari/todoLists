import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {UserData} from '../models/user-data';
import { HttpHeaders, HttpParams} from '@angular/common/http';
import {TokenData} from '../models/token-data'

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  private loggedIn;
  domainname='http://localhost:8080';
  public loggedInUserName;

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

    isLoggedIn(token: string){

      const Url = 'http://localhost:8080/api/getUserName';
      const loginHeaders=new HttpHeaders().set('Authorization', 'Bearer ' + token);
      return this._http.get(Url, {headers: loginHeaders, withCredentials:true, responseType:'text'})
      // .subscribe(
      //   res=>{
      //     this.loggedIn=true;
      //     this.loggedInUserName=res.toString();
          

      //   }, err=>{
      //      console.log(err); 
      //   });
   
      


    }


}
