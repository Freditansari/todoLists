import { Component, OnInit } from '@angular/core';
import { Book } from '../../book.model';
import { BookService } from '../../Services/book.service';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {

  book: Book = new Book();
  constructor(private bookService: BookService) { }

  add(){
     this.bookService.addBook(this.book, JSON.parse(sessionStorage.getItem('jsessionid')).access_token)

  }

  ngOnInit() {
  }

}
