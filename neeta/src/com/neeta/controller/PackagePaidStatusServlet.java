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
import javax.swing.JOptionPane;

import com.neeta.beans.PackageBookingDetailsBean;
import com.neeta.model.PackageBookingRequest;


@WebServlet("/admin/PackagePaidStatusServlet")
public class PackagePaidStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    PackageBookingRequest pbr=null;
    RequestDispatcher rd=null;
    public PackagePaidStatusServlet()
    {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		List<PackageBookingDetailsBean> pkg_book_list1 = null;
		try {
			
			pbr=new PackageBookingRequest();
			pkg_book_list1 = pbr.payment_status();
			//System.out.print(pkg_book_list);
			request.setAttribute("pkg_book_details1", pkg_book_list1);
			rd=request.getRequestDispatcher("showpaidstatus.jsp");
			rd.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String req=request.getParameter("paid_status");
		if(req.equals("PayConfirm"))
		{
			int pb_id=Integer.parseInt(request.getParameter("pb_id"));
			pbr=new PackageBookingRequest();
			try {
				
				boolean res=pbr.upd_pay_status(pb_id);
				if(res==true)
					response.sendRedirect("PackagePaidStatusServlet");
				
				
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}

}
