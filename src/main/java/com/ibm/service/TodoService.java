package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.exception.TodoNotFoundException;
import com.ibm.model.Todo;
import com.ibm.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	TodoRepository todorepo;

	public List<Todo> getTodos() {
		return todorepo.findAll();
	}

	public Todo getTodo(int id) {
		return todorepo.findById(id).orElseThrow(TodoNotFoundException::new);
	}

	public List<Todo> getTodosByUser(String user) {
		return todorepo.findAllByUser(user);
	}

	public Todo addTodo(Todo todo) {
		return todorepo.save(todo);
	}

	public Todo updateTodo(int id, Todo todo) {
		if (getTodo(id) != null) {
			return todorepo.saveAndFlush(todo);
		}
		return null;
	}

	public boolean deleteTodo(int id) {
		if (getTodo(id) != null) {
			todorepo.deleteById(id);
			return true;
		}
		return false;
	}
}
