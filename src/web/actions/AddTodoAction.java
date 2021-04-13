package web.actions;



import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

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

	public String addJson(HttpServletRequest req) throws IOException {

		for(long i=0;i<999999999999999L;i++)
		{
		
		}
		Gson gson=new Gson();
		Map<String, String> map=new HashMap<String, String>();
		
		Todo t=gson.fromJson(req.getReader(), Todo.class);

		if(t!=null && t.getMessage()!=null && !t.getMessage().equals(""))
		{
		DefaultServices.getInstance().add(t);
		map.put("message", "reussi");
		return gson.toJson(map);
		}
		map.put("message", "echec");
		
		return gson.toJson(map);
	}
}

	

