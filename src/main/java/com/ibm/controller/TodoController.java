package com.ibm.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ibm.model.Todo;
import com.ibm.service.TodoService;

@CrossOrigin
@RestController
public class TodoController {

	@Autowired
	TodoService todoService;
	
	@GetMapping("todos")
	public ResponseEntity<List<Todo>> getTodos(){
		return ResponseEntity.ok(todoService.getTodos());
	}
	
	@GetMapping("todos/{id}")
	public ResponseEntity<Todo> getTodoById(@PathVariable int id){
		return ResponseEntity.ok(todoService.getTodo(id));
	}
	
	@GetMapping("todos/user/{user}")
	public ResponseEntity<List<Todo>> getTodosByUser(@PathVariable String user){
		return ResponseEntity.ok(todoService.getTodosByUser(user));
	}
	
	@PostMapping("todos")
	public ResponseEntity<Todo>  addTodo(@Valid @RequestBody Todo todo){
		Todo result = todoService.addTodo(todo);
		URI link = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(result.getId()).toUri();
		return ResponseEntity.created(link).body(result);
	}
	
	@PutMapping("todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable int id, @Valid @RequestBody Todo todo){
		return ResponseEntity.ok(todoService.updateTodo(id, todo));
	}
	
	@DeleteMapping("todos/{id}")
	public  ResponseEntity<?> deleteTodo(@PathVariable int id)
	{
		if(todoService.deleteTodo(id))
			return ResponseEntity.noContent().build();
		else
			return ResponseEntity.notFound().build();
	}

}