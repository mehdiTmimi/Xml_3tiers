package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.DefaultServices;
import models.Todo;


@WebServlet("/addTodo")
public class AjouterProduitServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	super.doGet(req, resp);
		String message=req.getParameter("message");
		//System.out.println("message = "+message);
		//resp.getWriter().append(" <h1> message = "+message +"</h1>");
		Todo t=new Todo();
		t.setMessage(message);
		DefaultServices.getInstance().add(t);
		req.setAttribute("todos", DefaultServices.getInstance().getAll());
		req.getRequestDispatcher("list.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		doGet(req, resp);
	}

	
}
