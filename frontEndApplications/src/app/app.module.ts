import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import { AppComponent } from './app.component';
import {RouterModule, Routes} from '@angular/router';
import { LoginComponent } from './Components/login/login.component';
import { HeaderComponent } from './Components/header/header.component';
import { FooterComponent } from './Components/footer/footer.component';
import { TaskListComponent } from './Components/task-list/task-list.component';
import { AddTaskComponent } from './Components/add-task/add-task.component';
import { HomeComponent } from './Components/home/home.component';
import { FormsModule } from '@angular/forms';
import { TokenService } from './Services/token.service';
import { TodoService } from './Services/todo.service';
import { AddBookComponent } from './Components/add-book/add-book.component';
import { BookService } from './Services/book.service';


const appRoutes: Routes = [
   {path: 'login', component: LoginComponent},
   {path: 'home', component: HomeComponent},
   {path: 'book', component: AddBookComponent},
   {path: '**', component: HomeComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HeaderComponent,
    FooterComponent,
    TaskListComponent,
    AddTaskComponent,
    HomeComponent,
    AddBookComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [TokenService,TodoService, BookService],
  bootstrap: [AppComponent]
})
export class AppModule { }
