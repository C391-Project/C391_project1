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
 * Servlet implementation class Persons
 */
public class Persons extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataSource dataSource = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Persons() {
        super();
        this.dataSource = new DataSource();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StateManager sm = new StateManager(request, response);
		if (!sm.verifyPage()) return;
		
		List<Person> personList = dataSource.getPersonList();
		request.setAttribute("personList", personList);
		RequestDispatcher view = request.getRequestDispatcher("/UserManage/persons.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StateManager sm = new StateManager(request, response);
		HttpSession session = request.getSession();
		
		//Check Security and DB Connection
		sm.verifyPage();
		
		// Add Person
		boolean isPersonSubmit = (request.getParameter("person_submit") != null);
		if (isPersonSubmit) {
			Integer nextPersonId = dataSource.getNextPersonId();
			Person personToSubmit = new Person(nextPersonId, request);
			if (personToSubmit.isValid()) {
				dataSource.submitPerson(personToSubmit);
			} else {
				session.setAttribute("error", "Person Information Not Valid");
			}
			response.sendRedirect("/usermanage/persons");
		}
		
		// Edit Person
		boolean isPersonEdit = (request.getParameter("person_edit") != null);
		if (isPersonEdit) {
			Integer personId = Integer.parseInt(request.getParameter("p_person_id"));
			Person personToEdit = new Person(personId, request);
			if (personToEdit.isValid()) {
				dataSource.updatePerson(personToEdit);
			} else {
				session.setAttribute("error", "Person Information Not Valid");
			}
		}
	}
			
			

}