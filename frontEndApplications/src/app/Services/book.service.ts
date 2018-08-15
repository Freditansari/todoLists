import { Injectable } from '@angular/core';
import { Book } from '../models/book';

import { HttpHeaders, HttpParams, HttpClient} from '@angular/common/http';
/*
*this is the sample to send http post using oauth2 with json body
*/
@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private http:HttpClient) { }

  addBook(book:Book, token:string){
    const Url = 'http://localhost:8080/insertBook';
    const saveBookHeaders=new HttpHeaders().set('Authorization', 'Bearer ' + token);

   

    this.http.post(Url, book, {headers: saveBookHeaders, withCredentials:true}).subscribe((res)=>{
      console.log(res);

    }, (err)=>{
      console.log(err);
    });
    
  }
}
