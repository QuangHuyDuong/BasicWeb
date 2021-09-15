package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.ProductDao;
import com.common.PageIndex;
import com.google.gson.Gson;

/**
 * Servlet implementation class TotalPage
 */
@WebServlet("/TotalPage")
public class TotalPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TotalPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		Gson gson = new Gson();
		pw.write(gson.toJson(new PageIndex(ProductDao.countProduct())));
	}


}
