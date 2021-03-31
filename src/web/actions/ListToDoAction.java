package web.actions;

import javax.servlet.http.HttpServletRequest;

import business.DefaultServices;

public class ListToDoAction {

	public String list(HttpServletRequest request) {
		request.setAttribute("todos", DefaultServices.getInstance().getAll());
		return "list.jsp";
	}
}
