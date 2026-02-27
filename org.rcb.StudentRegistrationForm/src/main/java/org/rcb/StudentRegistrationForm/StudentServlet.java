package org.rcb.StudentRegistrationForm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String course = req.getParameter("role");
		double percentage = Double.parseDouble(req.getParameter("percentage"));
		
		StudentHibernate sb = new StudentHibernate();
		sb.addStu(name, email, course, percentage);
		
		resp.getWriter().print("Data added to database");
		
	}
}
