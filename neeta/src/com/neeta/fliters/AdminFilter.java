package com.neeta.fliters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neeta.validation.Validation;

/**
 * Servlet Filter implementation class AdminFliter
 */
public class AdminFilter implements Filter {
	/**
	 * Default constructor.
	 */
	public AdminFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 *  
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		String uri = ((HttpServletRequest) request).getRequestURI();
		if(!Validation.isJsp(uri)&&(uri.contains(".")))
		{
			chain.doFilter(request, response);
		}
		else
		{
		if (session != null) {
			String isLogged = (String) session.getAttribute("role");
			if (isLogged != null) {
				{
					
						if(isLogged.equalsIgnoreCase("admin"))
						{
							chain.doFilter(request, response);
						}
						else
						{
				((HttpServletResponse) response)
						.sendRedirect("../login/index.jsp");
						}
					}
			} 			// pass the request along the filter chain*/
			else
				((HttpServletResponse) response).sendRedirect("../login/index.jsp");
		}	
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
