package org.rcb.Inventories;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InventoryServlet")
public class InventoryServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		long cost = Long.parseLong(req.getParameter("cost"));
		int availability =Integer.parseInt("availability");
		
		InventoryHibernate ib = new InventoryHibernate();
		ib.addInventory(name, cost, availability);
		
		resp.getWriter().print("Data added");;
		
		
	}
}
