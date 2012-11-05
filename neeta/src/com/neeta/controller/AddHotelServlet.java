package com.neeta.controller;


import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neeta.beans.HotelInfoBean;
import com.neeta.model.TblHotel;



//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.FileUploadException;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;


@WebServlet("/admin/AddHotelServlet")
public class AddHotelServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
      TblHotel ah=new TblHotel();
      HotelInfoBean hib=new HotelInfoBean();
      File file;
      String filePath;
      RequestDispatcher rd=null;
    String hotel_id=null;
    String message=null;
    boolean upd_res=false;
    public AddHotelServlet() 
    {
        super();


    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List<HotelInfoBean> list = null;
		try {
			
			list = ah.hotel_data();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("Hotel_List", list);
		rd=request.getRequestDispatcher("managehotel.jsp");
		rd.forward(request, response);
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		String fun_type=request.getParameter("fun_type");
		 System.out.println("button name "+fun_type);
			if(fun_type.equals("AddHotel"))
		{
			int type=Integer.parseInt(request.getParameter("hotel_type"));
			
			hib.setHname(request.getParameter("hotel_name"));
			hib.setAddress(request.getParameter("address"));
			hib.setType(type);
			hib.setContact_det("contact");
			hib.setInfo(request.getParameter("hotel_info"));
			
		try {
					boolean res=ah.add_Hotel(hib);
		System.out.print(res);
					if(res==true)
					{
						
						message="Hotel added Successfully";
		            }
					else
						message="Could not upload hotel";
					request.setAttribute("h_add",message);
					rd=request.getRequestDispatcher("addhotel.jsp");
					rd.forward(request, response);
					
		}
		 catch (SQLException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		  

		
		
}
		
		else if(fun_type.equals("delete"))
		{
			hotel_id=request.getParameter("h_id");
			//System.out.println(hotel_id);
			try {
				ah.remove_hotel(Integer.parseInt(hotel_id));
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//String h_remove_success="Hotel removed Successfully";
			//request.setAttribute("h_add", h_remove_success);
			//rd=request.getRequestDispatcher("/hotel_remove.jsp");
			
			
			//rd.forward(request, response);
			response.sendRedirect("AddHotelServlet");
			
		}
		else if(fun_type.equals("edit"))
		{
			hotel_id=request.getParameter("h_id");
			System.out.println(hotel_id);
			List<HotelInfoBean> upd = null;
			try {
				upd = ah.edit_hotel(Integer.parseInt(hotel_id));
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("update",upd);
			rd=request.getRequestDispatcher("edithotel.jsp");
			rd.forward(request, response);
			
			
			
			
			/*ah.edit_hotel(Integer.parseInt(request.getParameter("hotel_id")));
			String h_edit_success="Hotel details updated Successfully";
			request.setAttribute("h_add", h_edit_success);
			rd=request.getRequestDispatcher("/hotel_edit.jsp");
			rd.forward(request, response);*/
				
		}
		else if(fun_type.equals("Update"))
		{
			hotel_id=request.getParameter("h_id");
			
			try {
				//hib.setH_id(Integer.parseInt(hotel_id));
				hib.setHname(request.getParameter("Hotel_name"));
				hib.setAddress(request.getParameter("address"));
				hib.setType(Integer.parseInt(request.getParameter("type")));
				hib.setContact_det(request.getParameter("contact"));
				hib.setInfo(request.getParameter("info"));
				
				
				
			upd_res=ah.update(hib,Integer.parseInt(hotel_id));
			}
			catch (NumberFormatException | SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			if(upd_res==true)
			
			response.sendRedirect("AddHotelServlet");
			//rd=request.getRequestDispatcher("/hotel_manipulate.jsp");
			//rd.forward(request, response);
			
		}
	}
	}

