import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http'

import { AppComponent } from './app.component';
import {RouterModule, Routes} from '@angular/router';
import { NotFoundComponent } from './Components/not-found/not-found.component';
import { ContactComponent } from './Components/contact/contact.component';
import { HomeComponent } from './Components/home/home.component';

const appRoutes:Routes =[
  {path:"home", component:HomeComponent},
  {path:"contact", component:ContactComponent},
  {path:"*", component:NotFoundComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    NotFoundComponent,
    ContactComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule, 
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
