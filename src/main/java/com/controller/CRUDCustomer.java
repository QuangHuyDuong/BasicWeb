package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.AdminDao;
import com.google.gson.Gson;
import com.modal.Customer;

/**
 * Servlet implementation class CRUDCustomer
 */
@WebServlet("/admin/CRUDCustomer")
public class CRUDCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CRUDCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		response.getWriter().write(gson.toJson(AdminDao.getAllCustomers()));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OK");
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Gson gson = new Gson();
		Customer c = gson.fromJson(req.getReader(), Customer.class);
		AdminDao.updateCustomer(c);
		HttpSession session =req.getSession();
		Customer cus = (Customer) session.getAttribute("customer");	
		if(cus.getUsername().equals(c.getUsername())) {
			session.removeAttribute("customer");
		}
	}

}
