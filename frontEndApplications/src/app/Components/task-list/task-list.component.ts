import { Component, OnInit } from '@angular/core';
import { TodoService } from '../../Services/todo.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {

  constructor(private router: Router, public todo: TodoService) {
     let token = sessionStorage.getItem('jsessionid');

     if (token == null || JSON.parse(token).expires_in < new Date().getTime()){
       router.navigateByUrl('/login');
     }
   }

  ngOnInit() {
  }

}
