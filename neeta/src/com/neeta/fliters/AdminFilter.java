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
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession(false);
		if (session != null) {
			String ses= session.getAttribute("Role").toString();
			System.out.print(ses);
			
					if(ses.equals(new String("admin"))) {
				System.out.print(session.getAttribute("Role"));
				// pass the request along the filter chain
				chain.doFilter(request, response);
			} else {
				// System.out.print("Else");
				((HttpServletResponse) response)
						.sendRedirect("../user/bus.jsp");
			}
		} else {
			((HttpServletResponse) response).sendRedirect("../user/bus.jsp");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
