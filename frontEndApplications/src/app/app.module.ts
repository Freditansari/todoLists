import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http'

import { AppComponent } from './app.component';
import {RouterModule, Routes} from '@angular/router';


const appRoutes:Routes =[
  // {path:"home", component:HomeComponent},
  // {path:"contact", component:ContactComponent},
  // {path:"*", component:NotFoundComponent}
]

@NgModule({
  declarations: [
    AppComponent
   
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
