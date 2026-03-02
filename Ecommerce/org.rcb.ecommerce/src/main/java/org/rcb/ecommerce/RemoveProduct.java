package org.rcb.ecommerce;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteProductServlet")
public class RemoveProduct extends HttpServlet{
	ProductHibernate ph = new ProductHibernate();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		int id = Integer.parseInt(req.getParameter("id"));
		boolean flag = ph.removeProduct(id);
		if(flag)
		{
			resp.getWriter().print("<h1>Product deleted</h1>");
		}else {
			resp.getWriter().print("<h1>Data not found</h1>");
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("deleteProduct.html");
		dispatcher.include(req, resp);
	}

}
