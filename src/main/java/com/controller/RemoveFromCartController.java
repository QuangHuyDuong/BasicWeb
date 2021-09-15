package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.CustomerDao;
import com.google.gson.Gson;
import com.modal.Customer;
import com.modal.Product;

/**
 * Servlet implementation class RemoveFromCartController
 */
@WebServlet("/client/removeProduct")
public class RemoveFromCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFromCartController() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		HttpSession session = request.getSession();
		Customer c= (Customer) session.getAttribute("customer");
		Product p = gson.fromJson(request.getReader(), Product.class);
		CustomerDao.deleteProduct(c, p);
		
	}

}
