package com.epam.jjp.sjspt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BattleServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/DomainServlet");
		dispatcher.include(request, response);
		
		//HttpSession session = request.getSession();
		//request.setAttribute("battlefield", session.getAttribute("battlefield"));

		RequestDispatcher viewDispatcher = request.getRequestDispatcher("/battle.jsp");
		viewDispatcher.forward(request, response);
	}
}
