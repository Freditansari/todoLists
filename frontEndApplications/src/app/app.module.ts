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
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { MatToolbarModule} from '@angular/material/toolbar';
import {MatMenuModule} from '@angular/material/menu';
import {MatButtonModule} from '@angular/material/button';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatOptionModule } from '../../node_modules/@angular/material/core';
import {MatSelectModule} from '@angular/material/select';
import {MatInputModule, MatRadioButton, MatIcon, MatIconModule, _MatRadioButtonMixinBase, MatRadioButtonBase} from '@angular/material';
import {MatRadioModule} from '@angular/material/radio';
import { CreateBookComponent } from './Components/create-book/create-book.component';


const appRoutes: Routes = [
   {path: 'login', component: LoginComponent},
   {path: 'home', component: HomeComponent},
   {path: 'book', component: CreateBookComponent},
   {path: 'header', component: HeaderComponent},
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
    AddBookComponent,
    CreateBookComponent
  ],
  imports: [
    BrowserModule,
    MatRadioModule,
    MatButtonModule,
    MatIconModule,
    MatInputModule,
    BrowserAnimationsModule,
    FormsModule,
    MatToolbarModule,
    MatMenuModule,
    HttpClientModule,
    MatFormFieldModule,
    MatOptionModule,
    MatSelectModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [TokenService,TodoService, BookService],
  bootstrap: [AppComponent]
})
export class AppModule { }
