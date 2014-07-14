package com.epam.jjp.sjspt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.jjp.sjspt.domain.Battlefield;

public class LoggerServlet  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/DomainServlet");
		dispatcher.include(request, response);
		
		HttpSession session = request.getSession();
		
		Battlefield battlefield =  (Battlefield) session.getAttribute("battlefield");
		battlefield.doBattle();
		response.sendRedirect("Battle");
	}
}
