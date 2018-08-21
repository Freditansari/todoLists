import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatButtonModule, MatCheckboxModule, MatFormFieldModule, MatInputModule, MatMenuModule, MatDatepicker, MatDatepickerModule, MatIconModule, MatSelectModule, MatGridListModule} from '@angular/material';
import {MatToolbarModule} from '@angular/material/toolbar';

import { AppComponent } from './app.component';
import { HeadersComponent } from './components/headers/headers.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import {Routes, RouterModule} from '@angular/router';
import {FormsModule} from '@angular/forms';
import { TokenService } from './service/token.service';
import { HttpClientModule } from '@angular/common/http';
import { AddBookComponent } from './components/add-book/add-book.component';
import { BookService } from './service/book.service';
import { UploadImageService } from './service/upload-image.service';


const appRoutes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'add-book', component: AddBookComponent},
  {path: '**', component: HomeComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    HeadersComponent,
    HomeComponent,
    LoginComponent,
    AddBookComponent
  ],
  imports: [
    FormsModule,
    MatGridListModule,
    MatIconModule,
    MatSelectModule,
    BrowserModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatToolbarModule,
    MatFormFieldModule,
    MatInputModule,
    MatCheckboxModule,
    HttpClientModule,
    MatDatepickerModule,
    MatMenuModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [TokenService, BookService, UploadImageService],
  bootstrap: [AppComponent]
})
export class AppModule { }
