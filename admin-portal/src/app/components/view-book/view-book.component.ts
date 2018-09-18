import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { BookService } from '../../service/book.service';
import { Book } from '../../models/book';

@Component({
  selector: 'app-view-book',
  templateUrl: './view-book.component.html',
  styleUrls: ['./view-book.component.css']
})
export class ViewBookComponent implements OnInit {

  private selectedBook:Book = new Book();
 
  constructor(private route:ActivatedRoute, private bookService: BookService) { }

  ngOnInit() {
    /*
    how to read data from url parameter. 
     */
    console.log(this.route.snapshot.paramMap.get('id'));
    this.bookService.getBook(parseInt( this.route.snapshot.paramMap.get('id')),JSON.parse(sessionStorage.getItem('jsessionid')).access_token).subscribe(res=>{
      this.selectedBook = JSON.parse(JSON.stringify(res));
      
    }, err=>{
      console.log(err);

    });
  }

}
