package ca.sheridancollege.views;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.sheridancollege.beans.Person;

/**
 * Servlet implementation class Output
 */
@WebServlet("/Output")
public class Output extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Output() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().append("<head><title>About Persons</title></head>");
		response.getWriter().append("<body><h1>ex91 Output</h1>");

		List<Person> personList = (List<Person>) request.getAttribute("personList");

		for (Person person : personList) {
			response.getWriter().append("<h3>" + person.toString() + "</h3>");
		}

		String myName = (String) request.getSession().getAttribute("myName");
		if (myName != null) {
			response.getWriter().append("<h3>" + myName + " is still here!</h3></body>");
		}
		response.getWriter().append("<a href=\"aboutMe.html\">Home</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
