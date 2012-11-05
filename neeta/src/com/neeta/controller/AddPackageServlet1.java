package com.neeta.controller;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neeta.beans.HotelInfoBean;
import com.neeta.beans.PackageBean;
import com.neeta.beans.PackageDetailsBean;
import com.neeta.model.TblHotel;
import com.neeta.model.TblPackage;


@WebServlet(name = "AddPackageServlet", urlPatterns = {"/admin/AddPackageServlet"})
public class AddPackageServlet1 extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addPackageServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addPackageServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {        
        TblHotel ah=new TblHotel();
      
        List<HotelInfoBean> hb = null;
		try {
			hb = ah.hotel_data();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
        if(hb==null)
        {
            //System.out.println("123");
        RequestDispatcher rd=request.getRequestDispatcher("newpackage.jsp");
        
        request.setAttribute("hotelinfo", hb);
       
        rd.forward(request, response);
        }
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {        
    	
    	String pkg_req=request.getParameter("pkg_req");
    	
    	
    	if(pkg_req.equals("add"))
    	{
        int totalDay=Integer.parseInt(request.getParameter("theValue"));     
        ArrayList<String> days=new ArrayList<String>();
        int i;
        for(i=1;i<=totalDay+1;i++)
        {
            days.add(request.getParameter("day"+i));
            //System.out.println("day"+i+": "+request.getParameter("day"+i));
           
        }
         i--;
        PackageBean pb=new PackageBean();
        pb.setName(request.getParameter("package_name"));  
        pb.setDuration(i);
        pb.setFare(Integer.parseInt(request.getParameter("fare")));
        pb.setIncl_excl(request.getParameter("incl_excl"));
        pb.setInformation(request.getParameter("package_info"));
        pb.setIncl_excl(request.getParameter("incl_excl"));
        pb.setHotelId(Integer.parseInt(request.getParameter("hotel")));
        if(TblPackage.savePackage(pb,days))
        {
            System.out.println("success");
        }
        else
        {
            System.out.println("fail");
        }
    }
    	else if(pkg_req.equals("edit"))
    	{
    		int id=Integer.parseInt(request.getParameter("hotel_id"));
    		//HotelInfoBean hib=new HotelInfoBean();
    		//hib.setH_id(id);
    		TblPackage p=new TblPackage();
    		
    		try 
    		{
    			List<HotelInfoBean> curr_hotel_data=p.curr_hotel_data(id);
    			int pkg_id=Integer.parseInt(request.getParameter("package_id"));
    			
    			List<PackageBean> package_list=p.package_data(pkg_id);
    			
    			List<PackageDetailsBean> pkg_desc=p.pkg_desc_details(pkg_id);
    			
    			
    			request.setAttribute("curr_hotel_data", curr_hotel_data);
    			request.setAttribute("package_list",package_list);
    			request.setAttribute("pkg_desc",pkg_desc);
    			
    			RequestDispatcher rd=request.getRequestDispatcher("pacakge_edit.jsp");
    			rd.forward(request, response);
    			
    			
    			
			}
    		
    		
    		
    		
    		
    		catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    	}
    	else if(pkg_req.equals("update"))
    	{
    		int total_Day=Integer.parseInt(request.getParameter("theValue"));    
    		int pkg_id=Integer.parseInt(request.getParameter("pkg_id"));
            ArrayList<String> upd_days=new ArrayList<String>();
            int i;
            for(i=1;i<=total_Day+1;i++)
            {
                upd_days.add(request.getParameter("day"+i));
                //System.out.println("day"+i+": "+request.getParameter("day"+i));
               
            }
             i--;
            PackageBean pb=new PackageBean();
            pb.setName(request.getParameter("package_name"));  
            pb.setDuration(i);
            pb.setFare(Integer.parseInt(request.getParameter("fare")));
            pb.setIncl_excl(request.getParameter("incl_excl"));
            pb.setInformation(request.getParameter("package_info"));
            pb.setIncl_excl(request.getParameter("incl_excl"));
            pb.setHotelId(Integer.parseInt(request.getParameter("hotel")));
            if(TblPackage.updatePackage(pb,upd_days,pkg_id))
            {
                System.out.println("success");
                response.sendRedirect("AddPackageServlet");
                
            }
            else
            {
                System.out.println("fail");
            }
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    	}
    	else if(pkg_req.equals("delete"))
    	{
    		int packageId=Integer.parseInt(request.getParameter("id"));
    		
    		TblPackage tblpkg=new TblPackage();
    		try {
    			
				boolean res2=tblpkg.pkg_delete(packageId);
			if(res2==true)
				response.sendRedirect("");
    		} 
    		catch (SQLException e) 
    		{
				
				e.printStackTrace();
			}
    		
    	}
    
    
    }
   
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
