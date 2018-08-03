import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add-task',
  templateUrl: './add-task.component.html',
  styleUrls: ['./add-task.component.css']
})
export class AddTaskComponent implements OnInit {

  constructor() { }
  item: string;

  //todo: perform add task logi
  add() {
   console.log(this.item);
  }

  ngOnInit() {
  }

}
