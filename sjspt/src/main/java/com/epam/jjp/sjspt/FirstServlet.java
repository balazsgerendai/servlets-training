package com.epam.jjp.sjspt;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{
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
			
			Date today = new Date();
			request.setAttribute("time", today);
			
			ServletContext context = getServletContext();
			
			InputStream pdfStream = context.getResourceAsStream("WEB-INF/sample.pdf");
	        ByteArrayOutputStream bos = new ByteArrayOutputStream();
	        
	        byte[] buf = new byte[1024];
            for (int readNum; (readNum = pdfStream.read(buf)) != -1;) {
                bos.write(buf, 0, readNum); //no doubt here is 0
            }
	       
	        byte[] bytes = bos.toByteArray();
			ServletOutputStream servletOutputStream = response.getOutputStream();
			servletOutputStream.write(bytes);
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment; filename=output.pdf");
			
			
			//RequestDispatcher dispatcher =	request.getRequestDispatcher("index.jsp");
			//dispatcher.forward(request,response);

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
