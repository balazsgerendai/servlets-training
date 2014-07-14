package com.epam.jjp.sjspt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.jjp.sjspt.domain.Battlefield;
import com.epam.jjp.sjspt.factory.BattlefieldFactory;

public class DomainServlet extends HttpServlet{
	private Battlefield battlefield;
	private ApplicationContext context;
	@Override
	public void init() throws ServletException {
		context = new ClassPathXmlApplicationContext("beans.xml");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BattlefieldFactory factory = context.getBean("battlefieldFactory", BattlefieldFactory.class);
		battlefield = factory.createBattlefield();
		HttpSession session = request.getSession();
		if(session.getAttribute("battlefield") == null){
			session.setAttribute("battlefield", battlefield);
		}
		
	}

}
