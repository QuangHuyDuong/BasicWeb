package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.common.ResponseString;
import com.google.gson.Gson;
import com.modal.Customer;


/**
 * Servlet implementation class CheckLoginController
 */
@WebServlet("/check_login")
public class CheckLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CheckLoginController() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute(getServletInfo(), session);
		PrintWriter writer = response.getWriter();
		Customer c = (Customer) session.getAttribute("customer");
		
		Gson gson = new Gson();
		if( c== null) {
			writer.write(gson.toJson(new ResponseString("Chua dang nhap")));
		} else if (c.getIsAdmin() == 0) {
			writer.write(gson.toJson(new ResponseString("La khach hang")));
		} else if (c.getIsAdmin() == 1) {
			writer.write(gson.toJson(new ResponseString("La quan tri vien")));
		} 
	
	}
}
