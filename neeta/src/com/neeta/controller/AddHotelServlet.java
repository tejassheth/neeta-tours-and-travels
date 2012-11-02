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


@WebServlet("/AddHotelServlet")
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
		 System.out.println("button name"+fun_type);
			if(fun_type.equals("add"))
		{
			String s= "playlist/";
			String saveFile="p:/";
			String contentType = request.getContentType();
			//System.out.println(contentType);
			if((contentType != null)&&(contentType.indexOf("multipart/form-data") >= 0))
			{
			    DataInputStream in = new DataInputStream(request.getInputStream());
			    int formDataLength = request.getContentLength();
			    byte dataBytes[] = new byte[formDataLength];
			    int byteRead = 0;
			    int totalBytesRead = 0;
			    while(totalBytesRead < formDataLength)
			    {
			        byteRead = in.read(dataBytes, totalBytesRead,formDataLength);
			        totalBytesRead += byteRead;
			    }
			    String file = new String(dataBytes);
			    
			    saveFile += file.substring(file.indexOf("filename=\"")+ 10);
			    saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
			    saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1,saveFile.indexOf("\""));
			    
			    int lastIndex = contentType.lastIndexOf("=");
			    String boundary = contentType.substring(lastIndex + 1,contentType.length());
			    int pos;
			    pos = file.indexOf("filename=\"");
			    pos = file.indexOf("\n", pos) + 1;
			    pos = file.indexOf("\n", pos) + 1;
			    pos = file.indexOf("\n", pos) + 1;
			    int boundaryLocation = file.indexOf(boundary, pos) - 4;
			    int startPos = ((file.substring(0, pos)).getBytes()).length;
			    int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;
			    System.out.println(saveFile);
			    System.out.println(saveFile);
			
			
			
			
			
			
			
			int type=Integer.parseInt(request.getParameter("hotel_type"));
			//String path=request.getParameter("image_path");
			String path=saveFile;
			hib.setHname(request.getParameter("hotel_name"));
			hib.setAddress(request.getParameter("address"));
			hib.setType(type);
			hib.setContact_det("contact");
			//hib.setpath(path);
		try {
					boolean res=ah.add_Hotel(hib);
		
					if(res==true)
					{
						File ff = new File(saveFile);
						FileOutputStream fileOut = new FileOutputStream(ff);
						fileOut.write(dataBytes, startPos, (endPos - startPos));
						fileOut.flush();
						fileOut.close();
						message="Hotel added Successfully";
		            }
					else
						message="Could not upload hotel";
					request.setAttribute("h_add",message);
					rd=request.getRequestDispatcher("hotel_add.jsp");
					rd.forward(request, response);
					
		}
		 catch (SQLException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		  
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
			//String old_path=request.getParameter("old_path");
			//System.out.println("oldpath"+old_path);
			//String new_path=request.getParameter("new_path");
			//System.out.println("new_path"+new_path);
			//String path1=null;
			//if(new_path.equals(null)||new_path=="")
			//	path1=old_path;
		//	else
			//	path1=new_path;
			//System.out.println(hotel_id);
			//System.out.println(path1);
			try {
				//hib.setH_id(Integer.parseInt(hotel_id));
				hib.setHname(request.getParameter("Hotel_name"));
				hib.setAddress(request.getParameter("address"));
				hib.setType(Integer.parseInt(request.getParameter("type")));
				hib.setContact_det("contact");
				
				
				
			upd_res=ah.update(hib,Integer.parseInt("hotel_id"));
			} catch (NumberFormatException | SQLException e)
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

