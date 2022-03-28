package com.ibm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
	List<Todo> findAllByUser(String username);
}
