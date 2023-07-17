package com.todo.todo.Repository;

import com.todo.todo.Entity.ToDoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Optional;

@Repository
public interface ToDoRepository extends CrudRepository<ToDoEntity, Integer> {
    List<ToDoEntity> findAll();
    Optional<ToDoEntity> findById(Integer id);
    void deleteById(Integer id);
    void deleteByActive(boolean b);

}
