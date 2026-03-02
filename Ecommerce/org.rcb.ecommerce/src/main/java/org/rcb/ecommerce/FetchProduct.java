package org.rcb.ecommerce;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FetchProductServlet")
public class FetchProduct extends HttpServlet {
	
	ProductHibernate ph = new ProductHibernate();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		int id =Integer.parseInt(req.getParameter("id"));
		Product p = ph.fetchProduct(id);
		if(p!=null)
		{
			resp.getWriter().print("<h1> Name :"+p.getName()+"</h1>");
			resp.getWriter().print("<h1> brand :"+p.getBrand()+"</h1>");
			resp.getWriter().print("<h1> rating :"+p.getRating()+"</h1>");
			resp.getWriter().print("<h1> cost :"+p.getCost()+"</h1>");
		}else {
			resp.getWriter().print("id not found");
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("fetchProduct.html");
		dispatcher.include(req, resp);
	}
}
