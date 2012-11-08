package com.neeta.controller;



 import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neeta.beans.BusBookingDetailBean;
import com.neeta.model.BusBooking;



@WebServlet("/admin/FetchBusBookingDetail")
public class FetchBusBookingDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    BusBooking bb=null;
    RequestDispatcher rd=null;
    public FetchBusBookingDetail() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
 	{
		bb=new BusBooking();
		List<BusBookingDetailBean> bus_data_details = null;
		try {
			
			bus_data_details = bb.bus_data();
			} 
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		
		request.setAttribute("BusList",bus_data_details);
		request.setAttribute("load", "false");
		rd=request.getRequestDispatcher("viewbusdetails.jsp");
		rd.forward(request, response);		



	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int busid = Integer.parseInt(request.getParameter("busno"));
		String date = request.getParameter("date");
		//BusBookingDetail []details = BusBooking.getBusBooking(busid, date); 
		BusBooking bb1=new BusBooking();
		List<BusBookingDetailBean> booking_details=bb1.getBusBooking(busid,date);

		List<BusBookingDetailBean> bus_data_details=null ;
		try {
			
			bus_data_details = bb.bus_data();
			
			} 
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		request.setAttribute("load", "true");
		request.setAttribute("BusList",bus_data_details);
		request.setAttribute("BookingDetails",booking_details);
		RequestDispatcher rd=request.getRequestDispatcher("viewbusdetails.jsp");
		rd.forward(request, response);
		
		
		
	}

}
