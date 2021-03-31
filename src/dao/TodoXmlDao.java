package dao;

import java.util.List;

import models.Todo;
import outils.XMLParser;

public class TodoXmlDao implements TodoDao{
	public final String PATH="todos.xml";
	
	@Override
	public boolean add(Todo produit) {
		List<Todo> todos=XMLParser.lire(PATH, Todo.class);
		todos.add(produit);
		return XMLParser.ecrire(PATH, todos);
	}

	@Override
	public List<Todo> getAll() {
		return XMLParser.lire(PATH, Todo.class);
	}

}
