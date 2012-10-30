package com.neeta.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neeta.beans.Bus_DetailBean;
import com.neeta.beans.Route_BusesBean;
import com.neeta.model.TblBus_Detail;

/**
 * Servlet implementation class AddNewBus
 */
//@WebServlet("/admin/AddNewBus")
public class AddNewBus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewBus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("busno")!=null)
		{
			Bus_DetailBean d = new Bus_DetailBean();
			d.setBus_no(request.getParameter("busno"));
			d.setSeating(Integer.parseInt(request.getParameter("seating")));
			d.setSleeper(Integer.parseInt(request.getParameter("sleeper")));
			
			Route_BusesBean rmb = new Route_BusesBean();
			rmb.setSource_time(request.getParameter("time"));
			//System.out.print(request.getParameter("route"));
			rmb.setRoute_id(Integer.parseInt(request.getParameter("route")));
			boolean b = TblBus_Detail.addNewBus(d, rmb);
			//System.out.println(b);
			response.sendRedirect("newbus.jsp");
		}
	}

}
