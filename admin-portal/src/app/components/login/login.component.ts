import { Component, OnInit } from '@angular/core';
import { TokenService } from '../../service/token.service';
import{Router} from '@angular/router';
import{UserData} from '../../models/user-data'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  constructor( private router:Router, private tokenService:TokenService) { }

  userData:UserData = new UserData();
  isError=false;
  error_message;

  ngOnInit() {
  }
  
  login(){
    if(this.userData.username.length > 0 && this.userData.password.length>0){
      this.tokenService.getToken(this.userData).subscribe(res =>{
        res.expires_in= new Date().getTime()+ res.expires_in*1000;
        sessionStorage.setItem('jsessionid', JSON.stringify(res));
        sessionStorage.setItem('UserData', JSON.stringify(UserData));
        this.router.navigateByUrl('/home');
      }, (error)=>this.error_message =JSON.parse(JSON.stringify(error)).error.error_description);
    }
  }

}
