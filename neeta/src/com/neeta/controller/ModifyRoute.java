package com.neeta.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neeta.beans.*;
import com.neeta.model.TblRoute;
/**
 * Servlet implementation class ModifyRoute
 */
@WebServlet("/admin/ModifyRoute")
public class ModifyRoute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyRoute() {
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
		PrintWriter out = response.getWriter();
		if(request.getParameter("sourcecity")!=null && request.getParameter("destinationcity")!=null)
		{
			try
			{
				RouteBean rb = new RouteBean();
				rb.setSourceId(Integer.parseInt(request.getParameter("sourcecity")));
				rb.setDestinationId(Integer.parseInt(request.getParameter("destinationcity")));
				rb.setRouteId(Integer.parseInt(request.getParameter("routeid")));
				ArrayList<Route_MapBeans> r = new ArrayList<Route_MapBeans>();
				for(int i=1; i<50; i++)
				{
					if(request.getParameter("station" + i)==null)
						break;
					Route_MapBeans rmb = new Route_MapBeans();
					rmb.setStation_id(Integer.parseInt(request.getParameter("station" + i)));
					rmb.setSleeping_fare(Integer.parseInt(request.getParameter("sleepingfare" + i)));
					rmb.setSeating_fare(Integer.parseInt(request.getParameter("seatingfare" + i)));
					rmb.setDistance(Integer.parseInt(request.getParameter("distance" + i)));
					rmb.setDuration(request.getParameter("time"+i));
					r.add(rmb);
				}
				Route_MapBeans []rmbarray = new Route_MapBeans[r.size()];
				r.toArray(rmbarray);
				out.println(rmbarray.length);
				if(rmbarray.length>=2 && rmbarray[0].getStation_id()==rb.getSourceId() && rmbarray[rmbarray.length-1].getStation_id()==rb.getDestinationId())
				{
					if(TblRoute.modifyRoute(rb, rmbarray)==true)
						out.println("Route Modified");
					else
						out.println("Route modified, some error occurs");
				}
				else
				{
					out.println("Invalid and Insufficient data");
				}
				response.sendRedirect("manageroute.jsp");
			}
			catch (Exception e) {
				out.println("Invalid data");
				response.sendRedirect("manageroute.jsp");
				e.printStackTrace();
			}
		}
	}

}
