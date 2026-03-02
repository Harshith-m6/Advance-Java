package org.rcb.ecommerce;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		double cost = Double.parseDouble(req.getParameter("cost"));
		int ratings = Integer.parseInt(req.getParameter("ratings"));
		String brand = req.getParameter("brand");
		resp.setContentType("text/html");
		
		ProductHibernate ph = new ProductHibernate();
		ph.addStudent(name, cost, brand, ratings);
		
		
		resp.getWriter().print("<h1>data added</h1>");
		RequestDispatcher dispatcher = req.getRequestDispatcher("addProduct.html");
		dispatcher.include(req, resp);
		
	}
}
