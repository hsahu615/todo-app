package com.todo.todo.Controller;

import com.todo.todo.DAO.ToDo;
import com.todo.todo.Entity.ToDoEntity;
import com.todo.todo.Service.TodoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Transactional
@RequestMapping("todo")
@CrossOrigin("*")
public class ToDoController {

    @Autowired
    private TodoService todoService;
    @GetMapping("/")
    public ResponseEntity<List<ToDoEntity>> getAllTodos(){
        return new ResponseEntity<>(todoService.getAllTodos(), HttpStatus.OK);
    }
    @PostMapping(value = "/")
    public void addTodo(@RequestBody ToDo todo) throws Exception{
        todoService.addTodo(todo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Integer id) throws Exception{
        return new ResponseEntity<>(todoService.deleteTodo(id), HttpStatus.OK);
    }

    @PutMapping("/description/{id}")
    public ResponseEntity<String> updateDescription(@RequestBody ToDo todo, @PathVariable("id") Integer id) throws Exception {
        return new ResponseEntity<>(todoService.updateDescription(todo, id), HttpStatus.OK);
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<String> updateStatus(@RequestBody ToDo todo, @PathVariable("id") Integer id) throws Exception {
        return new ResponseEntity<>(todoService.updateStatus(todo, id), HttpStatus.OK);
    }

    @GetMapping("/clear/")
    public ResponseEntity<String> clearCompleted(){
        return new ResponseEntity<>(this.todoService.clearCompleted(), HttpStatus.OK);
    }
}
