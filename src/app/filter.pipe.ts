import { Pipe, PipeTransform } from '@angular/core';
import { Todo } from './todo';

@Pipe({
  name: 'filter',
  pure: false
})
export class FilterPipe implements PipeTransform {

  transform(todos: Todo[], filterType: number): Todo[] {
    if(filterType === 1){
      return todos;
    } else if(filterType === 2){
      return todos.filter(todo => todo.getIsActive()===true);
    } 
    return todos.filter(todo => todo.getIsActive()===false);
  }

}
