package com.neeta.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neeta.beans.RouteBean;
import com.neeta.beans.Route_BusesBean;
import com.neeta.beans.Route_MapBeans;
import com.neeta.model.TblRoute;
import com.neeta.model.TblRoute_Map;
/**
 * Servlet implementation class FetchRoute
 */
//@WebServlet("/admin/FetchRoute")
public class FetchRoute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchRoute() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			int route_id =Integer.parseInt(request.getParameter("route_id"));
			//System.out.print(route_id);
			RouteBean routeBean = TblRoute.getRoute(route_id);
			ArrayList<Route_MapBeans> route_MapList= TblRoute_Map.getRouteData(route_id);
			request.setAttribute("Route",routeBean);
			request.setAttribute("Route_Map",route_MapList);
			RequestDispatcher rd= request.getRequestDispatcher("editroute.jsp");
			rd.forward(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
