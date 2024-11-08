package br.com.liviazeviani.lista_tarefas.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.liviazeviani.lista_tarefas.entity.Todo;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/todos")
public class TodoController {
    private br.com.liviazeviani.lista_tarefas.service.TodoService todoService;

    public TodoController(br.com.liviazeviani.lista_tarefas.service.TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    List<Todo> create(@RequestBody @Valid Todo todo){
        return todoService.create(todo);
        
    }

    @GetMapping
    List<Todo> list(){
        return todoService.list();

    }

    @PutMapping
    List<Todo> update(@RequestBody Todo todo){
        return todoService.update(todo);

    }

    @DeleteMapping("{id}")
    List<Todo> delete(@PathVariable("id") Long id){
        return todoService.delete(id);

    }
    
}
