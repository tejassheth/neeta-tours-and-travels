package com.neeta.controller;
import com.neeta.beans.HotelInfoBean;
import com.neeta.beans.PackageBean;
import com.neeta.beans.PackageDetailsBean;
import com.neeta.model.TblHotel;
import com.neeta.model.TblPackage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/admin/ManagePackageServlet")
public class ManagePackageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ManagePackageServlet() 
    {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		TblPackage tpg=new TblPackage();
                System.out.println("12345");
		
		try {
			
			List<PackageBean> pb_data=tpg.Package_Details();
			request.setAttribute("PackageDetails",pb_data);
			//System.out.println(pb.toString());
			RequestDispatcher rd=request.getRequestDispatcher("managepackage.jsp");
			rd.forward(request, response);
			
			
		}
		catch (SQLException e) 
		{
				e.printStackTrace();
		}
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String pkg_req=request.getParameter("pkg_fun_type");
		System.out.println(pkg_req);
		
	 if(pkg_req.equals("edit"))
    	{
    		int id=Integer.parseInt(request.getParameter("hotel_id"));
    		
    		TblPackage p=new TblPackage();
    		TblHotel ah=new TblHotel();
    		try 
    		{
    			List<HotelInfoBean> curr_hotel_data=p.curr_hotel_data(id);
    			int pkg_id=Integer.parseInt(request.getParameter("pkg_id"));
    			List<HotelInfoBean> hb=ah.hotel_data();
    			List<PackageBean> package_list=p.package_data(pkg_id);
    			
    			List<PackageDetailsBean> pkg_desc=p.pkg_desc_details(pkg_id);    			
    			request.setAttribute("curr_hotel_data", curr_hotel_data);
    			request.setAttribute("package_list",package_list);
    			request.setAttribute("pkg_desc",pkg_desc);
                        request.setAttribute("hb",hb);
    			request.setAttribute("pkg_id", pkg_id);
    			RequestDispatcher rd=request.getRequestDispatcher("editpackage.jsp");
    			rd.forward(request, response);
    			
    			
    			
			}
    		
    		
    		
    		
    		
    		catch (SQLException e)
    		{
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
                System.out.println("day"+i+": "+request.getParameter("day"+i));
               
            }
             i--;
            PackageBean pb=new PackageBean();
        pb.setName(request.getParameter("package_name"));
        //System.out.println(request.getParameter("package_name"));
        
        pb.setDuration(i);
        //System.out.println(i);
        pb.setFare(Float.parseFloat(request.getParameter("fare")));
        //System.out.println(request.getParameter("fare"));
        pb.setIncl_excl(request.getParameter("incl_excl"));
        //System.out.println(request.getParameter("incl_excl"));
        pb.setInformation(request.getParameter("package_info"));
        pb.setIncl_excl(request.getParameter("incl_excl"));
        pb.setMinperson(Integer.parseInt(request.getParameter("minperson")));
        //System.out.println(request.getParameter("package_info"));
        //System.out.println(request.getParameter("hotel"));
        pb.setHotelId(Integer.parseInt(request.getParameter("hotel")));
                try {
                    if(TblPackage.updatePackage(pb,upd_days,pkg_id))
                    {
                        System.out.println("success");
                        response.sendRedirect("ManagePackageServlet");
                    }
                    else
                    {
                        System.out.println("fail");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ManagePackageServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                
    	}
    	else if(pkg_req.equals("delete"))
    	{
    		int package_id=Integer.parseInt(request.getParameter("pkg_id"));
    		TblPackage tp=new TblPackage();
    		try {
    			
				boolean pkg_result=tp.pkg_delete(package_id);
				if(pkg_result==true)
					response.sendRedirect("ManagePackageServlet");
				
			} 
    		catch (SQLException e)
    		{
				
				e.printStackTrace();
			}
    	}
    
   }

}
