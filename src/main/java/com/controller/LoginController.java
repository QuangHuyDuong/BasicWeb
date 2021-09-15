package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.CustomerDao;
import com.common.ResponseString;
import com.google.gson.Gson;
import com.modal.Customer;


/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		PrintWriter writer = response.getWriter();
		Customer c= gson.fromJson(request.getReader(),Customer.class);
		String username = c.getUsername();
		String password = c.getPassword();
		Customer customer = CustomerDao.logIn(username, password);
		if( customer == null) {
			writer.write(gson.toJson(new ResponseString("Dang nhap that bai")));
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("customer", customer);
			
			writer.write(gson.toJson(customer));
		}
	
	}

}
