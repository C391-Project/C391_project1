package servlets.usermanage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utilities.StateManager;
import db.DataSource;
import db.JDBC;
import db.Person;

/**
 * Servlet implementation class dblogin
 */
public class PersonsEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonsEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		StateManager sm = new StateManager(request, response);
		if (!sm.verifyPage()) return;
		
		Integer personId = Integer.parseInt(request.getParameter("id"));
		
		DataSource dataSource = new DataSource();
		Person person = dataSource.getPersonById(personId);
		
		request.setAttribute("person", person);
		RequestDispatcher view = request.getRequestDispatcher("/UserManage/persons-edit.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
			
			

}