import { Component, OnInit } from '@angular/core';
import { TokenService } from '../../service/token.service';

@Component({
  selector: 'app-headers',
  templateUrl: './headers.component.html',
  styleUrls: ['./headers.component.css']
})
export class HeadersComponent implements OnInit {

  constructor(private tokenService: TokenService) { }

  ngOnInit() {
    
  }

  checkLogin(){
    //this.tokenService.isLoggedIn(JSON.parse(sessionStorage.getItem('jsessionid')).access_token).subscribe(res=>{console.log(res)}, err=>{console.log(err)});
  }

  

  

}
