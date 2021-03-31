package business;

import java.util.List;

import dao.TodoDao;
import dao.TodoXmlDao;
import models.Todo;

public class DefaultServices implements Services{

	private TodoDao todoDao;
	private static DefaultServices instance=null;
	public static DefaultServices getInstance()
	{
		if(instance==null)
			instance=new DefaultServices();
		return instance;
	}
	 private DefaultServices() {
		 this.todoDao=new TodoXmlDao();
	 }
	@Override
	public boolean add(Todo todo) {
		List<Todo> todos=todoDao.getAll();
		if(todos.size()==0)
		{
			todo.setId(1);
			
		}
		else {
			int max=todos.get(0).getId();
			for (int i = 1; i < todos.size(); i++) {
				if(todos.get(i).getId()>max)
					max=todos.get(i).getId();
			}
			max++;
			todo.setId(max);
			//todo.setId(++max);
		}
		return todoDao.add(todo);
		
	}

	@Override
	public List<Todo> getAll() {
		return todoDao.getAll();
	}

}
