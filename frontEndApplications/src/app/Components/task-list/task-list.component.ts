import { Component, OnInit } from '@angular/core';
import { TodoService } from '../../Services/todo.service';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {

  constructor(public todo: TodoService) { }

  ngOnInit() {
  }

}
