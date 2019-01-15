package ca.sheridancollege.controllers;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.sheridancollege.beans.Person;

/**
 * Servlet implementation class EchoServlet
 */
@WebServlet("/EchoServlet")
public class EchoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	List<Person> personList = new CopyOnWriteArrayList<Person>();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EchoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String myName = "Ian";
		request.getSession().setAttribute("myName", myName);
		
		request.setAttribute("personList", personList);
		request.getRequestDispatcher("Output").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String color = request.getParameter("color");
		String age = request.getParameter("age");
		String[] skills = request.getParameterValues("skills");
		
		personList.add(new Person(email, color, age, skills));
		doGet(request, response);
	}

}
