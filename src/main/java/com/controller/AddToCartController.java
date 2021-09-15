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
import com.DAO.ProductDao;
import com.common.ResponseString;
import com.google.gson.Gson;
import com.modal.Customer;
import com.modal.Product;

@WebServlet("/client/addToCart")
public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public AddToCartController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Gson gson = new Gson();
		PrintWriter writer = response.getWriter();
		Product p = gson.fromJson(request.getReader(), Product.class);
		Customer c= (Customer) session.getAttribute("customer");
		
		CustomerDao.addToCart(p.getId(), c.getUsername());
		writer.write(gson.toJson(new ResponseString("Them thanh cong")));
	}

}
