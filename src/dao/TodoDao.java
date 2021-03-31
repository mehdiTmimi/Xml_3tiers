package dao;

import java.util.List;

import models.Todo;

public interface TodoDao {

	public boolean add(Todo todo);
	public List<Todo> getAll();
}
