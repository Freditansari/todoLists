import { Component, OnInit } from '@angular/core';
import {Book} from '../../models/book';
import {Router} from '@angular/router'
import { TokenService } from "../../service/token.service";
import { GetBookListService } from '../../service/get-book-list.service';
import { MatDialog, MatDialogRef } from '@angular/material';


@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {
  // private getBookListService: GetBookListService,
  // private removeBookService: RemoveBookService,
  private selectedBook:Book;
  private checked: boolean;
  public bookList:Book[];
  private allChecked:boolean;
  private removeBookList:Book[] = new Array();
  private loginStatus:boolean =false;


  constructor(private getBookListService : GetBookListService, private router: Router, private tokenService:TokenService, public dialog:MatDialog) { }

  ngOnInit() {
    
    try{
      console.log(JSON.parse(sessionStorage.getItem('jsessionid')));
      this.tokenService.isLoggedIn(JSON.parse(sessionStorage.getItem('jsessionid')).access_token).subscribe(res=>{
        this.getBookListService.getBook(JSON.parse(sessionStorage.getItem('jsessionid')).access_token).subscribe(res=>{
          this.bookList =JSON.parse(JSON.stringify(res));
        },error=>{
          console.log(error);
  
        });
      }, err=>{
        console.log("err");
      });

    }catch(exception){
      console.log(exception);
      this.router.navigateByUrl("/login");
    }
    


  
  }
  //NOTE:how to pass data from angular urls
  onSelect(book:Book) {
    this.selectedBook=book;
    console.log(this.selectedBook);
    this.router.navigate(['/view-book', this.selectedBook.id]);
  }

  openDialog(book:Book) {
    let dialogRef = this.dialog.open(DialogResultExampleDialog);
    dialogRef.afterClosed().subscribe(
      result => {
        console.log(result);
        if(result=="yes") {
          // this.removeBookService.sendBook(book.id).subscribe(
          //   res => {
          //     console.log(res);
          //     this.getBookList();
          //   }, 
          //   err => {
          //     console.log(err);
          //   }
          //   );
        }
      }
      );
  }
 

  // updateSelected(checked: boolean) {
  //   if(checked) {
  //     this.allChecked = true;
  //     this.removeBookList=this.bookList.slice();
  //   } else {
  //     this.allChecked=false;
  //     this.removeBookList=[];
  //   }
  // }

  // removeSelectedBooks() {
  //   let dialogRef = this.dialog.open(DialogResultExampleDialog);
  //   dialogRef.afterClosed().subscribe(
  //     result => {
  //       console.log(result);
  //       if(result=="yes") {
  //         for (let book of this.removeBookList) {
  //           this.removeBookService.sendBook(book.id).subscribe(
  //             res => {

  //             }, 
  //             err => {
  //             }
  //             );
  //         }
  //         location.reload();
  //       }
  //     }
  //     ); 
  // }

  updateRemoveBookList(checked:boolean, book:Book) {    
    if(checked) {
      console.log(book);
      this.removeBookList.push(book);
    } else {
      this.removeBookList.splice(this.removeBookList.indexOf(book), 1);
    }
  }

}
export class DialogResultExampleDialog {
  constructor(public dialogRef: MatDialogRef<DialogResultExampleDialog>) {}
}
