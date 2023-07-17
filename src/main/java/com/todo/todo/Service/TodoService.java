package com.todo.todo.Service;

import com.todo.todo.DAO.ToDo;
import com.todo.todo.Entity.ToDoEntity;
import com.todo.todo.Repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private ToDoRepository toDoRepository;
    public List<ToDoEntity> getAllTodos(){
        return toDoRepository.findAll();
    }
    public void addTodo(ToDo todo) throws Exception{
        try {
            ToDoEntity temp = new ToDoEntity();
            temp.setActive(todo.getActive());
            temp.setDescription(todo.getDescription());
            toDoRepository.save(temp);
        } catch (Exception e){
        }
    }

    public String deleteTodo(Integer id) throws Exception{
        try{
            Optional<ToDoEntity> temp = toDoRepository.findById(id);
            if(temp.get()==null) throw new Exception("Not Found");
            toDoRepository.deleteById(temp.get().getId());
            return "Done";
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }

    public String updateDescription(ToDo todo, Integer id) throws Exception{
        try{
            Optional<ToDoEntity> temp = toDoRepository.findById(id);
            if(temp.get()==null) throw new Exception("Not Found");
            temp.get().setDescription(todo.getDescription());
            toDoRepository.save(temp.get());
            return "Done";
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }

    public String updateStatus(ToDo todo, Integer id) throws Exception{
        try{
            Optional<ToDoEntity> temp = toDoRepository.findById(id);
            if(temp.get()==null) throw new Exception("Not Found");
            temp.get().setActive(todo.getActive());
            toDoRepository.save(temp.get());
            return "Done";
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }

    public String clearCompleted(){
        this.toDoRepository.deleteByActive(false);
        return "";
    }


}
