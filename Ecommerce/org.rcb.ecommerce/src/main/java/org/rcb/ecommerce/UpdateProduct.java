package org.rcb.ecommerce;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateProductServlet")
public class UpdateProduct extends HttpServlet {
	ProductHibernate ph = new ProductHibernate();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int rating = Integer.parseInt(req.getParameter("ratings"));
		String brand = req.getParameter("brand");
		
		boolean flag = ph.updateProduct(id, name, rating, brand);
		
	
		if(flag)
		{
			resp.getWriter().print("<h1>Data updated</h1>");
		}else {
			resp.getWriter().print("<h1>Data not found</h1>");
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("updateProduct.html");
		dispatcher.include(req, resp);
	}
	

}
