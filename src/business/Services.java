package business;

import java.util.List;

import models.Todo;

public interface Services {
	
	public boolean add(Todo todo);
	public List<Todo> getAll();

}
