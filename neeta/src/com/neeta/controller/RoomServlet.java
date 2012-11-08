package com.neeta.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neeta.beans.HotelInfoBean;
import com.neeta.beans.RoomInfoBean;
import com.neeta.model.TblHotel;
import com.neeta.model.TblRoom;


@WebServlet("/admin/RoomServlet")
public class RoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   TblHotel ah=new TblHotel();
   RequestDispatcher rd=null; 
   public RoomServlet()
    {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	try {
		List<HotelInfoBean> hlist=ah.hotel_data();
		request.setAttribute("hlist",hlist);
		rd=request.getRequestDispatcher("addRoom.jsp");
		rd.forward(request, response);
		}
	catch (SQLException e)
	
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RoomInfoBean rim=new RoomInfoBean();
		System.out.println(request.getParameter("room_type"));
		rim.setH_id(Integer.parseInt(request.getParameter("hotel_id")));
		rim.setRoom(request.getParameter("room_type"));
		rim.setFare(Float.parseFloat(request.getParameter("fare")));
		TblRoom ro=new TblRoom();
		try {
			
			boolean res=ro.insert(rim);
			if(res==true)
			{
				List<HotelInfoBean> hlist=ah.hotel_data();
				String success="Room added successfully";
				request.setAttribute("message", success);
				request.setAttribute("hlist",hlist);
				rd=request.getRequestDispatcher("addRoom.jsp");
				rd.forward(request, response);
				
			}
				
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
