import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatButtonModule, MatCheckboxModule, MatFormFieldModule, MatInputModule, MatMenuModule} from '@angular/material';
import {MatToolbarModule} from '@angular/material/toolbar';

import { AppComponent } from './app.component';
import { HeadersComponent } from './components/headers/headers.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import {Routes, RouterModule} from '@angular/router';
import {FormsModule} from '@angular/forms';
import { TokenService } from './service/token.service';
import { HttpClientModule } from '@angular/common/http';

const appRoutes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: '**', component: HomeComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    HeadersComponent,
    HomeComponent,
    LoginComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatToolbarModule,
    MatFormFieldModule,
    MatInputModule,
    MatCheckboxModule,
    HttpClientModule,
    MatMenuModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [TokenService],
  bootstrap: [AppComponent]
})
export class AppModule { }
