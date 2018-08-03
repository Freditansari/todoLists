import { Component, OnInit } from '@angular/core';
import { TodoService } from '../../Services/todo.service';

@Component({
  selector: 'app-add-task',
  templateUrl: './add-task.component.html',
  styleUrls: ['./add-task.component.css']
})
export class AddTaskComponent implements OnInit {

  constructor(private todo:TodoService) { }
  item: string;

  //todo: perform add task logi
  add() {
   this.todo.addItem(this.item,'')
  }

  ngOnInit() {
  }

}
