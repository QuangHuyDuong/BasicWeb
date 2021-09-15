package com.Fillter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.modal.Customer;

@WebFilter(urlPatterns = {"/ProductManager.html","/AddProduct.html","/admin/CRUDProduct","/CustomerManager.html","/admin/CRUDCustomer"})
public class AdminFilter implements Filter {

    public AdminFilter() {
     
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession sesion = request.getSession();
		Customer customer = (Customer) sesion.getAttribute("customer");
		if(customer == null || customer.getIsAdmin() != 1) {
			response.getWriter().write("Khong phai admin");
		} else {
			chain.doFilter(request, response);
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
