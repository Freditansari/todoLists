import { Component, OnInit } from '@angular/core';
import { Book } from '../../models/book';
import { BookService } from '../../service/book.service';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {

  constructor(private bookService: BookService) { }

  book:Book= new Book();

  onSubmit(){
    console.log(this.book);
    this.bookService.addBook(this.book, JSON.parse(sessionStorage.getItem('jsessionid')).access_token).subscribe(
      result=>{
        this.book= new Book();

      }, error=>{
        console.log(error);

      }
    );
  }

  ngOnInit() {
  }

}
