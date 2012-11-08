package com.neeta.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neeta.beans.Bus_DetailBean;
import com.neeta.beans.Route_BusesBean;
import com.neeta.model.Bus_Detail;

/**
 * Servlet implementation class ModifyBusDetail
 */
@WebServlet("/admin/ModifyBusDetail")
public class ModifyBusDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyBusDetail() {
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
		RequestDispatcher rd=request.getRequestDispatcher("GetAllBus");
		try
		{
		Bus_DetailBean d = new Bus_DetailBean();
		d.setBus_id(Integer.parseInt(request.getParameter("busid")));
		d.setBus_no(request.getParameter("busno"));
		d.setSeating(Integer.parseInt(request.getParameter("seating")));
		d.setSleeper(Integer.parseInt(request.getParameter("sleeper")));
		
		Route_BusesBean rmb = new Route_BusesBean();
		rmb.setBus_id(Integer.parseInt(request.getParameter("busid")));
		rmb.setSource_time(request.getParameter("time"));
		rmb.setRoute_id(Integer.parseInt(request.getParameter("route")));
		
		boolean b = Bus_Detail.modifyBusDetail(d, rmb);
		request.setAttribute("resulr","Not Edit , Please Try Again !!!");
		//rd.forward(request, response);
		response.sendRedirect("GetAllBus");
		//System.out.println(b);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			request.setAttribute("resulr","Not Edit , Please Try Again !!!");
			//rd.forward(request, response);
			response.sendRedirect("GetAllBus");
		}
		
	}
}
