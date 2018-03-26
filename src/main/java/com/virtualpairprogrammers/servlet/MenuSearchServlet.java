package com.virtualpairprogrammers.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.data.MenuDataService;
import com.virtualpairprogrammers.domain.MenuItem;

public class MenuSearchServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String searchTerm = request.getParameter("searchTerm");
		
		out.println("<html><body><h1>Ricky's Restaurant</h1>");
		out.println("<h2>Dishes containing " + searchTerm + "</h2><ul>");
		MenuDataService menu = new MenuDataService();
		List<MenuItem> list = menu.find(searchTerm);
		out.println();
		for(MenuItem menuItem: list){
		out.println("<li>"+menuItem + " " +menuItem.getDescription() + "</li>");
		}
		
		out.println("</ul></body></html>");
		out.close();
	}
	
	
}
