import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  todoLists=[]

  constructor(private http:HttpClient) { }

  load(){

  }

  addItem(task: string, token: string){
    this.todoLists.unshift(task);

  }


}
