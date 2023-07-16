import { Injectable } from '@angular/core';
import { Todo } from './todo';

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  private allTodos: Todo[] = [];

  constructor() { }

  addTodo(todo: Todo) {
    this.allTodos.push(todo);
  }

  deleteTodo(todo: Todo) {
    for(let i=0; i<this.allTodos.length; i++) {
      if(this.allTodos[i].getId() === todo.getId()){
        this.allTodos.splice(i, 1);
      }
    }
  }

  updateDescription(todo: Todo, description: string) {
    for(let ele of this.allTodos) {
      if(ele.getId() === todo.getId()){
        ele.setDescription(description);
      }
    }
  }

  updateStatus(todo: Todo, isActive: boolean) {
    for(let ele of this.allTodos) {
      if(ele.getId() === todo.getId()){
        ele.setIsActive(isActive);
      }
    }
  }

  getTodos(): Todo[] {
     return this.allTodos;
  }

  clearCompleted() {
    this.allTodos = this.allTodos.filter(todo => todo.getIsActive()===true);
  }
}
