package com.virtualpairprogrammers.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.data.MenuDataService;
import com.virtualpairprogrammers.domain.MenuItem;

public class ViewMenuServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body><h1>Ricky's Restaurant</h1>");
		out.println("<h2>Menu</h2><ul>");
		
		MenuDataService menu = new MenuDataService();
		List<MenuItem> list = menu.getFullMenu();
		out.println();
		for(MenuItem l: list){
		out.println("<li>"+l +"</li>");
		}
		out.println("</ul>");
		out.println("<a href='searchResults.html?searchTerm=veg'>Click here to get all veg recepies</a>");
		out.println("</body></html>");
		out.close();
	}
	
}
