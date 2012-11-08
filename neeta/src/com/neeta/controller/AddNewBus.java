package com.neeta.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.taglibs.standard.lang.jstl.ELException;
import org.apache.taglibs.standard.tag.common.core.CatchTag;

import com.neeta.beans.Bus_DetailBean;
import com.neeta.beans.Route_BusesBean;
import com.neeta.model.TblBus_Detail;
import com.neeta.validation.Validation;

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
		RequestDispatcher rd=request.getRequestDispatcher("newbus.jsp");
		try
		{
			
		if(request.getParameter("busno")!=null)
		{
			Bus_DetailBean d = new Bus_DetailBean();
			String Bus_no=request.getParameter("busno");
			d.setBus_no(Bus_no);
			String seating=request.getParameter("seating");
			String sleeping=request.getParameter("sleeper");
			if(Validation.isNumber(seating))
			d.setSeating(Integer.parseInt(seating));
			else
				throw new Exception("Seating seat is wrong");
			if(Validation.isNumber(sleeping))
				d.setSleeper(Integer.parseInt(sleeping));
			else
				throw new Exception("Sleeping seating is wrong");
			Route_BusesBean rmb = new Route_BusesBean();
			String time=request.getParameter("time");
			if(Validation.isTime24(time))
				rmb.setSource_time(time);
			else 
				throw new Exception("Time is wrong");
			
			//System.out.print(request.getParameter("route"));
			rmb.setRoute_id(Integer.parseInt(request.getParameter("route")));
			boolean b = TblBus_Detail.addNewBus(d, rmb);
			//System.out.println(b);
			request.setAttribute("result","Bus is Inserted");
			rd.forward(request, response);
		}
	}catch(Exception e)
	{
		e.printStackTrace();
		request.setAttribute("result","Bus is not Inserted, Please Try Again  !!!");
		rd.forward(request, response);
	}
	}
	

}
