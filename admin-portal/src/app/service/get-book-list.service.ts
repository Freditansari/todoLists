import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Book } from '../models/book';

@Injectable({
  providedIn: 'root'
})
export class GetBookListService {

  constructor(private http:HttpClient) { }

  getBook(token:string){
    const Url = 'http://206.189.35.230:8080/books/getBooks';
    const saveBookHeaders=new HttpHeaders().set('Authorization', 'Bearer ' + token);
   
    return this.http.get(Url, {headers: saveBookHeaders, withCredentials:true})

}
}
