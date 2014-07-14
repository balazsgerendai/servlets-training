package com.epam.jjp.sjspt;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecondServlet extends HttpServlet{
	private String value;
	private String adminEmail;
	
	@Override
	public void init() throws ServletException {
		super.init();
		value = getServletConfig().getInitParameter("NAME");
		adminEmail = getServletContext().getInitParameter("adminEmail");
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			HttpSession session = request.getSession();
			Date oldTime = (Date) session.getAttribute("time");
			request.setAttribute("oldTime",oldTime);
			
			Date newTime = new Date();
			request.setAttribute("newTime",newTime);
			session.setAttribute("time", newTime);
			
			RequestDispatcher dispatcher =	request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request,response);

			/*	PrintWriter writer = response.getWriter();
			writer.println("<html>");
			writer.println("<head>");	
			writer.println("<title>Hello from servlet</title>");
			writer.println("</head>");
			writer.println("<body>");
			writer.println("<h1>Hello from servlet</h1>");
			writer.println("<p>"+today+"</p>");
			writer.println("<p>"+value+"</p>");
			writer.println("<p>"+adminEmail+"</p>");
			writer.println("</body>");
			writer.println("</html>");*/
	}
}
