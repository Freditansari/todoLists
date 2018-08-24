import { Component, OnInit } from '@angular/core';
import {Book} from '../../models/book';
import {Router} from '@angular/router'
import { TokenService } from "../../service/token.service";
import { GetBookListService } from '../../service/get-book-list.service';


@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {
  private selectedBook:Book;
  private checked: boolean;
  private bookList:Book[];
  private allChecked:boolean;
  private removeBookList:Book[] = new Array();

  constructor(private getBookListService : GetBookListService, private router: Router, private tokenService:TokenService) { }

  ngOnInit() {
    this.getBookListService.getBook(JSON.parse(sessionStorage.getItem('jsessionid')).access_token).subscribe(res=>{
      this.bookList =JSON.parse(JSON.stringify(res));
    },error=>{

    });
  }

}
