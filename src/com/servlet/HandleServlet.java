package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDAO;
import com.daoimpl.StudentDAOImpl;
import com.model.Student;

/**
 * Servlet implementation class HandleServlet
 */
@WebServlet("/Handle")
public class HandleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	StudentDAO studentDAOImpl = new StudentDAOImpl();
	Student student = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HandleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String rollNo = request.getParameter("rollNo");
		String name = request.getParameter("name");
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");

		System.out.println("Action : " + request.getParameter("action") + "/nId : " + request.getParameter("id"));

		String id = request.getParameter("id");
		String action = request.getParameter("action");

		if (action.equals("update")) {

			Integer studentId = Integer.parseInt(id);
			
			student = studentDAOImpl.getStudentById(studentId);

			student.setRollNo(rollNo);
			student.setName(name);
			student.setEmail(email);
			student.setContact(contact);

			int result = studentDAOImpl.updateStudent(student);

			if (result > 0) {
				response.sendRedirect("view-all.jsp");
			} else {
				response.getWriter().print("<h1>Error</h1>");
			}
		} else if (action.equals("delete")) {
			Integer studentId = Integer.parseInt(id);
			int result = studentDAOImpl.deleteStudent(studentId);

			if (result > 0) {
				response.sendRedirect("view-all.jsp");
			} else {
				response.getWriter().print("<center><h1>ERROR</h1></center>");
			}
		} else if (action.equals("add")) {
			student = new Student();

			student.setRollNo(rollNo);
			student.setName(name);
			student.setEmail(email);
			student.setContact(contact);

			int result = studentDAOImpl.addStudent(student);

			if (result > 0) {
				response.sendRedirect("view-all.jsp");
			} else {
				response.getWriter().print("<h1>Error</h1>");
			}

		} else if (action.equals("view")) {
			response.sendRedirect("view-all.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
