package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.actions.AddTodoAction;
import web.actions.ListToDoAction;

@WebServlet( {"/"})
public class ControlerServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		String route =req.getRequestURI().substring(req.getRequestURI().lastIndexOf("/")+1);
		String destination="404.jsp";
		if(route.equals("addTodo"))
		{
			AddTodoAction addTodoAction=new AddTodoAction();
			destination = addTodoAction.add(req);
		}
		else if(route.equals("lists"))
		{
			ListToDoAction listToDoAction=new ListToDoAction();
			destination = listToDoAction.list(req);
		}
		else if(route.equals("listsJson"))
		{
			ListToDoAction listToDoAction=new ListToDoAction();
			resp.getWriter().append(listToDoAction.listJson(req));
			return;
		}
		else if(route.equals("addJson"))
		{
		//	resp.setHeader(", value);
			AddTodoAction addTodoAction=new AddTodoAction();
			resp.getWriter().append(addTodoAction.addJson(req));
			return ;
		}
		
		//resp.getWriter().append(destination);
		req.getRequestDispatcher("/views/"+destination).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
