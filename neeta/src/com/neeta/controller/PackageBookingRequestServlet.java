package com.neeta.controller;



import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neeta.beans.PackageBookingDetailsBean;
import com.neeta.model.PackageBookingRequest;

import java.sql.SQLException;
import java.util.*;


@WebServlet("/admin/PackageBookingRequestServlet")
public class PackageBookingRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   PackageBookingRequest pbr=new PackageBookingRequest();
   RequestDispatcher rd;
   String packageBooking_id=null;
	String email_id=null;
    public PackageBookingRequestServlet() 
    {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		List<PackageBookingDetailsBean> pkg_book_list = null;
		try {
			
			pkg_book_list = pbr.Package_Booking_Data();
			//System.out.print(pkg_book_list);
			request.setAttribute("pkg_book_details", pkg_book_list);
			rd=request.getRequestDispatcher("showrequests.jsp");
			rd.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String req_name=request.getParameter("req_type");
		
		if(req_name.equals("Accept"))
		{
			 packageBooking_id=request.getParameter("pb_id");
			email_id=request.getParameter("Email_id");
			String fare=request.getParameter("fare");
			try 
			{
				
				pbr.Request_Accept(Integer.parseInt(packageBooking_id),email_id,fare);
				response.sendRedirect("PackageBookingRequestServlet");
			} 
			catch (NumberFormatException | MessagingException e)
			{
				
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		if(req_name.equals("Reject"))
		{
			packageBooking_id=request.getParameter("pb_id");
			email_id=request.getParameter("Email_id");
			try {
				
				pbr.Request_Reject(Integer.parseInt(packageBooking_id),email_id);
				response.sendRedirect("PackageBookingRequestServlet");
				
			} 
			catch (NumberFormatException| MessagingException e)
			{
				
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
		


	}

}
