package com.neeta.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class FetchModifyBusData
 */
@WebServlet("/admin/FetchModifyBusData")
public class FetchModifyBusData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchModifyBusData() {
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
			int busid = Integer.parseInt(request.getParameter("busid"));
			//int busid = 3;
			Bus_DetailBean d = new Bus_DetailBean();
			Route_BusesBean rmb = new Route_BusesBean();
			
			boolean b = Bus_Detail.getBusData(busid, d, rmb);
			
			List<Bus_DetailBean> d1 = new ArrayList<Bus_DetailBean>();
			d1.add(d);
			List<Route_BusesBean> rmb1 = new ArrayList<Route_BusesBean>();
			rmb1.add(rmb);
			
			request.setAttribute("d1", d1);
			request.setAttribute("rmb1", rmb1);
			RequestDispatcher rd = request.getRequestDispatcher("modifybus.jsp");
			rd.forward(request, response);

	}

}
