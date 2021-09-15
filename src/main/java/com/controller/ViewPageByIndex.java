package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.CustomerDao;
import com.DAO.ProductDao;
import com.common.PageIndex;
import com.google.gson.Gson;
import com.modal.Product;

@WebServlet("/ViewPageByIndex")
public class ViewPageByIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Gson gson = new Gson();	
		PrintWriter writer = response.getWriter();	
		PageIndex pi = gson.fromJson(request.getReader(), PageIndex.class);
		int index = pi.getIndex();
		writer.write(gson.toJson(ProductDao.viewByIndex(index)));
		
		
	}


}
