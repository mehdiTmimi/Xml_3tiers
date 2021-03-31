package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.actions.AddTodoAction;
import web.actions.ListToDoAction;

@WebServlet( {"/addTodo","/lists"})
public class ControlerServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("appppppel");
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
		//resp.getWriter().append(destination);
		req.getRequestDispatcher("/views/"+destination).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
