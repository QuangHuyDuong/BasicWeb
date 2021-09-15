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
import com.google.gson.Gson;
import com.modal.Customer;


@WebServlet("/client/viewCart")
public class ViewCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ViewCart() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter writer = response.getWriter();
    	Gson gson = new Gson();
    	HttpSession session = request.getSession();
    	Customer c = (Customer) session.getAttribute("customer");
    	if(c== null) {
    		writer.write(gson.toJson(null));
    	} else {
    		writer.write(gson.toJson(CustomerDao.viewCart(c)));
    	}
		
	}


}
