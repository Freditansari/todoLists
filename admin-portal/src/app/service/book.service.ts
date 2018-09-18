import { Injectable } from '@angular/core';
import { Book } from '../models/book';
import { HttpHeaders, HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private http:HttpClient) { }
  addBook(book:Book, token:string){
        const Url = 'http://localhost:8080/books/insertBook';
        const saveBookHeaders=new HttpHeaders().set('Authorization', 'Bearer ' + token);
       
        return this.http.post(Url,book, {headers: saveBookHeaders, withCredentials:true})
    
  }
  getBook(id: number, token:string){
    const Url = 'http://localhost:8080/books/getBook/'+id;
    const saveBookHeaders=new HttpHeaders().set('Authorization', 'Bearer ' + token);
   
    return this.http.post(Url,id, {headers: saveBookHeaders, withCredentials:true})

  }
}
