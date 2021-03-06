package com.virtualpairprogrammers.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.data.MenuDataService;
import com.virtualpairprogrammers.domain.MenuItem;

public class OrderServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
	PrintWriter out = response.getWriter();
	response.setContentType("text/html");
	
	out.println("<html><body>");
	out.println("<h1>Ricky's Restaurant </h1> " );
	out.println("<h2>Order your food</h2>");
	out.println("<form action='orderReceived.html' method='POST'>");
	out.println("<ul>");
	
	MenuDataService menu = new MenuDataService();
	List<MenuItem> list = menu.getFullMenu();

	for(MenuItem menuItem: list){
	out.println("<li>"+menuItem + " " +"<input type='text' name='item_"+menuItem.getId() +"'/>" + "</li>");
	
	}
	out.println("</ul>");
	out.println("<input type='submit'/>");
	
	out.println("</form>");
	
	out.println("</body></html>");
	
	out.close();
	
	} 
}
