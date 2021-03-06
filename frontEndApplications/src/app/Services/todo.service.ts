import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders, HttpParams} from '@angular/common/http';
import { TokenData } from '../TokenData';
import { UserData } from '../UserData';
import { Router } from '../../../node_modules/@angular/router';

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  todoLists=[];

  isError:boolean = false;
  names =["Joko", "chandra"];

  domainname='http://localhost:8080';

  constructor(private http:HttpClient, private router:Router) { }

  load(){
    const token = sessionStorage.getItem('jsessionid');

    const tokenJSON = JSON.parse(token);

    console.log(tokenJSON);

    if (token != null || tokenJSON.expires_in < new Date().getTime()) {

      const getTaskUrl = 'http://localhost:8080/getTasks';

      const getTaskHeaders: HttpHeaders = new HttpHeaders()
        .append('Authorization', 'Bearer' + tokenJSON.access_token);

      this.http.post(getTaskUrl, {
        withCredentials: true
      }, {
          headers: getTaskHeaders
        }).subscribe((res) => {
          console.log(res);
          for (let i = 0; ; i++) {
            if (res[i] == null) {
              break;
            }
            console.log('adding task' + res[i]);

            this.todoLists.unshift(res[i].task);
          }
        }, (error) =>{
          console.log(error);
          this.router.navigateByUrl("/login");
          console.log("error from todo-services");

        }
      
      );

    }


  }

  addItem(task: string, token: string){
    this.todoLists.unshift(task);

    const getTokenUrl = this.domainname+'/insertTask';
    const getTokenParameters: HttpParams = new HttpParams().append('task', task);

    console.log(getTokenParameters.toString());


    const getTokenHeaders: HttpHeaders = new HttpHeaders().append('Authorization', 'Bearer ' + token);

    console.log(getTokenHeaders);


   this.http.post(getTokenUrl, {withCredentials: true}
      , {headers: getTokenHeaders, params : getTokenParameters}).subscribe((res)=>{
        console.log(res);
      });

  }


}
