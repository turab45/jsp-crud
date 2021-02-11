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
import com.sun.org.apache.xerces.internal.parsers.IntegratedParserConfiguration;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	StudentDAO studentDAOImpl = new StudentDAOImpl();
	Student student = null;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		System.out.print("id : "+id);
		String rollNo = request.getParameter("rollNo");
		String name = request.getParameter("name");
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");
		
		if (rollNo != null && name != null && contact != null && email != null && !rollNo.equalsIgnoreCase("")) {
			student = studentDAOImpl.getStudentById(id);
			
			student.setRollNo(rollNo);
			student.setName(name);
			student.setEmail(email);
			student.setContact(contact);
			
			int result = studentDAOImpl.updateStudent(student);
			
			if (result > 0) {
				response.sendRedirect("view-all.jsp");
			}else {
				response.getWriter().print("<h1>Error</h1>");
			}
			
		}else {
			response.sendRedirect("add.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
