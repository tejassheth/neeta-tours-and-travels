/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neeta.controller;

import com.neeta.beans.HotelInfoBean;
import com.neeta.beans.PackageBean;
import com.neeta.model.TblHotel;
import com.neeta.model.TblPackage;
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

/**
 *
 * @author Ritz
 */
@WebServlet(name = "AddPackageServlet", urlPatterns = {"/admin/AddPackageServlet"})
public class AddPackageServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {        
        TblHotel ah=new TblHotel();
        System.out.println("123");
        List<HotelInfoBean> hb;
		try {
			hb = ah.hotel_data();
			if(hb==null)
	            System.out.println("123");
	        RequestDispatcher rd=request.getRequestDispatcher("newpackage.jsp");
	        //System.out.println("123");
	        request.setAttribute("hotelinfo", hb);
	        //System.out.println("123");
	        rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
        
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
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
        //System.out.println(request.getParameter("package_name"));
        
        pb.setDuration(i);
        //System.out.println(i);
        pb.setFare(Integer.parseInt(request.getParameter("fare")));
        //System.out.println(request.getParameter("fare"));
        pb.setIncl_excl(request.getParameter("incl_excl"));
        //System.out.println(request.getParameter("incl_excl"));
        pb.setInformation(request.getParameter("package_info"));
        pb.setIncl_excl(request.getParameter("incl_excl"));
        //System.out.println(request.getParameter("package_info"));
        //System.out.println(request.getParameter("hotel"));
        pb.setHotelId(Integer.parseInt(request.getParameter("hotel")));
        System.out.println(Integer.parseInt(request.getParameter("minperson")));
        
        pb.setMin_person(Integer.parseInt(request.getParameter("minperson")));
        if(TblPackage.savePackage(pb,days))
        {
            System.out.println("success");
            TblHotel ah=new TblHotel();
            System.out.println("123");
            List<HotelInfoBean> hb;
    		try {
    			hb = ah.hotel_data();
    			if(hb==null)
    	            System.out.println("123");
    	        RequestDispatcher rd=request.getRequestDispatcher("newpackage.jsp");
    	        //System.out.println("123");
    	        request.setAttribute("hotelinfo", hb);
    	        //System.out.println("123");
    	        rd.forward(request, response);
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} 
        }
        else
        {
            System.out.println("fail");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
