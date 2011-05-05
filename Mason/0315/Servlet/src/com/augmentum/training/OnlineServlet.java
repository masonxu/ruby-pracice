package com.augmentum.training;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Online2Servlet
 */
public class OnlineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OnlineServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserManager um = UserManagerFactory.getUserManager();
		String type = request.getParameter(Const.TYPE);
		String userName = request.getParameter(Const.USER_NAME);
		String password = request.getParameter(Const.PASSWORD);
		boolean register = false;
		User user = null;
		if (type != null) {
			if (type.equals(Const.REGISTER)) {
				register = um.register(userName,password);
				if (register) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp"); 
					dispatcher.forward(request, response);
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp?result=failure"); 
					dispatcher.forward(request, response);
				}
			} else if(type.equals(Const.LOGIN)) {
				user = um.login(userName, password);
				if (user != null) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/webpage.jsp?userName=" + userName);
					dispatcher.forward(request, response);
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp?result=failure"  );
					dispatcher.forward(request, response);
				}
			} else if(type.equals(Const.EXIT)) {
				um.offLine(userName);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp?");
				dispatcher.forward(request, response);
			}
		} 
		
	}
	
}
