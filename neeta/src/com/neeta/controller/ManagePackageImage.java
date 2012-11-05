/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neeta.controller;

import com.neeta.beans.PackageBean;
import com.neeta.model.PackageImages;
import com.neeta.model.TblPackage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
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
@WebServlet(name = "ManagePackageImage", urlPatterns = {"/admin/ManagePackageImage"})
public class ManagePackageImage extends HttpServlet {

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
            out.println("<title>Servlet ManagePackageImage</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManagePackageImage at " + request.getContextPath() + "</h1>");
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
        ArrayList<PackageBean> pb=TblPackage.getPackage();
        RequestDispatcher rd=request.getRequestDispatcher("managepackageimages.jsp");
        request.setAttribute("plist", pb);
        request.setAttribute("load", "true");
        request.setAttribute("pid", 0);
        rd.forward(request, response);
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
        String name=request.getParameter("submit");        
        if(name.equals("Delete"))
        {
            Enumeration e=request.getParameterNames();
            ArrayList<String> param=new ArrayList<String>();
            String str=null;
            String path=request.getRealPath("");
            while(e.hasMoreElements())
            {                
                //System.out.println(e.nextElement());
                str=(String)e.nextElement();
                System.out.println(str);
                param.add(str);                
            }
            String pid=PackageImages.deleteImages(param,path);
            //System.out.println(pid);
            path = request.getRealPath("")+"//images//package"+pid+"//";      
            System.out.println(path);
            ArrayList<String> imgList=PackageImages.getPath(Integer.parseInt(pid),path);
            ArrayList<PackageBean> pb=TblPackage.getPackage();        
            RequestDispatcher rd=request.getRequestDispatcher("managepackageimages.jsp");
            request.setAttribute("path","../images/"+"package"+pid);
            request.setAttribute("imgList",imgList);        
            request.setAttribute("load", "false");
            request.setAttribute("plist", pb);
            request.setAttribute("pid", pid);
            rd.forward(request, response);
            
        }
        else
        {
            String pid=request.getParameter("package");
            System.out.println(pid);
            String path = request.getRealPath("")+"//images//package"+pid+"//";      
            System.out.println(path);
            ArrayList<String> imgList=PackageImages.getPath(Integer.parseInt(pid),path);
            ArrayList<PackageBean> pb=TblPackage.getPackage();        
            RequestDispatcher rd=request.getRequestDispatcher("managepackageimages.jsp");
            request.setAttribute("path","../images/"+"package"+pid);
            request.setAttribute("imgList",imgList);        
            request.setAttribute("load", "false");
            request.setAttribute("plist", pb);
            request.setAttribute("pid", pid);
            rd.forward(request, response);
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
