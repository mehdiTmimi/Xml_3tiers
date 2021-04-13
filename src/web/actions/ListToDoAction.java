package web.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

import business.DefaultServices;
import models.Todo;

public class ListToDoAction {

	public String list(HttpServletRequest request) {
		request.setAttribute("todos", DefaultServices.getInstance().getAll());
		return "list.jsp";
	}
	public String listJson(HttpServletRequest request) {
		List<Todo> todos=DefaultServices.getInstance().getAll();
		Gson g=new Gson();
		return g.toJson(todos);
	}
}
