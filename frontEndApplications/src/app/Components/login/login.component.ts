import { Component, OnInit } from '@angular/core';
import { UserData } from '../../UserData';
import { TokenService } from '../../Services/token.service';
import {Router } from '@angular/router'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private tokenService: TokenService, private router: Router) { }

  userData:UserData = new UserData();
  error=false;
  ngOnInit() {
  }

  login(){
    if(this.userData.username.length > 0 && this.userData.password.length>0){
      this.tokenService.getToken(this.userData).subscribe(res =>{
        res.expires_in= new Date().getTime()+ res.expires_in*1000;
        sessionStorage.setItem('jsessionid', JSON.stringify(res));
        this.router.navigateByUrl('/home');
      }, error=>this.error=true);
    }
  }

}
