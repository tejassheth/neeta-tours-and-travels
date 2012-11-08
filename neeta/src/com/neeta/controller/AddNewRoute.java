package com.neeta.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.taglibs.standard.tag.common.core.CatchTag;

import com.neeta.beans.RouteBean;
import com.neeta.beans.Route_MapBeans;
import com.neeta.model.TblRoute;

/**
 * Servlet implementation class AddNewRoute
 */
@WebServlet("/admin/AddNewRoute")
public class AddNewRoute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewRoute() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.print("TEjas");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		try{
		if(request.getParameter("sourcecity")!=null && request.getParameter("destinationcity")!=null)
		{
			try
			{
				RouteBean rb = new RouteBean();
				rb.setSourceId(Integer.parseInt(request.getParameter("sourcecity")));
				rb.setDestinationId(Integer.parseInt(request.getParameter("destinationcity")));
			
				ArrayList<Route_MapBeans> r = new ArrayList<Route_MapBeans>();
				//int no=Integer.parseInt(request.getParameter("theValue"));
				for(int i=1; i<=50; i++)
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
				System.out.println("rmblength " + rmbarray.length);
				//out.println(rmbarray[0].getStation_id() + " " +rb.getSourceId());
				//out.println(rmbarray[rmbarray.length-1].getStation_id()+" "+rb.getDestinationId());
				if(rmbarray.length>=2 && rmbarray[0].getStation_id()==rb.getSourceId() && rmbarray[rmbarray.length-1].getStation_id()==rb.getDestinationId())
				{
					if(TblRoute.addNewRoute(rb, rmbarray)==true){
						request.setAttribute("result","Route inserted successfully");
						//System.out.println("Route Added");
						//request.setAttribute("Result","Route Added");
					}
					else{
						System.out.println("Route not added, some error occurs");
						new Exception("Not Inserted");
						//request.setAttribute("Result","Route not added, some error occurs");
					}
				}
				else
				{
					System.out.println("invalid insufficient data");
					request.setAttribute("result","Invalid data Insufficient");
				}
				
			}
			catch (Exception e) {
				request.setAttribute("result","Invalid data");
				e.printStackTrace();
			}
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("newroute.jsp");
		rd.forward(request, response);
	}
		catch(Exception e)
		{
			request.setAttribute("result","New Route Can't inserted,Please Try Again  !!");
			RequestDispatcher rd=request.getRequestDispatcher("newroute.jsp");
			rd.forward(request, response);
		}
	}
	
}
