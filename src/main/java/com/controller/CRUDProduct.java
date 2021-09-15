package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.AdminDao;
import com.common.ResponseString;
import com.google.gson.Gson;
import com.modal.Product;

/**
 * Servlet implementation class CRUDProduct
 */
@WebServlet("/admin/CRUDProduct")
public class CRUDProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CRUDProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		Gson gson = new Gson();
		Product p = gson.fromJson(request.getReader(), Product.class);
		if(AdminDao.addProduct(p)) {
			writer.write(gson.toJson(new ResponseString("Success")));
		} else {
			writer.write(gson.toJson(new ResponseString("Failed")));
		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		Product p = gson.fromJson(request.getReader(), Product.class);
		System.out.println(p);
		AdminDao.updateProduct(p);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		Gson gson = new Gson();
		Product p = gson.fromJson(request.getReader(), Product.class);
		AdminDao.deleteProduct(p.getId());
		
	}

}
