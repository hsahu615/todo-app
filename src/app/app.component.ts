import { Component, OnInit } from '@angular/core';
import { TodoService } from './todo.service';
import { Todo } from './todo';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'client';
  filterType: number = 1;
  itemsLeft: number = 0;
  theme: boolean = false;

  todos: Todo[] = [];

  constructor(private _service: TodoService){}
  
  ngOnInit(): void {
    this._service.getTodos();
  }

  addTodo(description: string){
    if(description.trim().length > 0){
      let todo = new Todo(true, description);
      this._service.addTodo(todo);
      this.updateModel();
    }
  }

  updateDescription(todo: Todo, description: string): void {
    if(description.trim().length > 0){
      this._service.updateDescription(todo, description);
      this.updateModel();
    }
  }
  

  updateStatus(todo: Todo, isActive: boolean): void {
    this._service.updateStatus(todo, isActive);
    this.updateModel();
  }

  deleteTodo(todo: Todo): void {
    this._service.deleteTodo(todo);
    this.updateModel();
  }

  clearCompleted(){
    this._service.clearCompleted();
    this.updateModel();
  }
  
  updateModel(){
    this.todos = this._service.getTodos(); 
    let count = 0;
    for(let todo of this.todos){
      if(todo.getIsActive()){
        count++;
      }
    }
    this.itemsLeft = count;
  }
}