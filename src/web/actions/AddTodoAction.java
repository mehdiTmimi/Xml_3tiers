package web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.DefaultServices;
import models.Todo;

public class AddTodoAction {

	public String add(HttpServletRequest req) {
		String message=req.getParameter("message");
		//System.out.println("message = "+message);
		//resp.getWriter().append(" <h1> message = "+message +"</h1>");
		Todo t=new Todo();
		t.setMessage(message);
		if(message!=null && !message.equals(""))
		{
		DefaultServices.getInstance().add(t);
		req.setAttribute("todos", DefaultServices.getInstance().getAll());
		return "list.jsp";
		}
		
		req.setAttribute("messageErreur","veuillez remplir tous les champs");
		return "addTodo.jsp";
	}
}
