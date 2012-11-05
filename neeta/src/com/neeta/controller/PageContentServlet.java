/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neeta.controller;

import com.neeta.model.TBLPageContent;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "PageContentServlet", urlPatterns = {"/admin/PageContentServlet"})
public class PageContentServlet extends HttpServlet {

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
            out.println("<title>Servlet PageContentServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PageContentServlet at " + request.getContextPath() + "</h1>");
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
        PrintWriter out = response.getWriter();        
        int id=Integer.parseInt(request.getParameter("id"));
        String content=TBLPageContent.getContent(id);        
        request.setAttribute("homecontent", content);
        RequestDispatcher rd;
        switch(id)
        {
            case 1:content="edithome.jsp";
                break;
            case 2:content="editaboutus.jsp";
                break;
            case 3:content="editcontactus.jsp";
                break;
            case 4:content="edittermsandcondition.jsp";
                break;
            default:content="edithome.jsp";
        }
        rd=request.getRequestDispatcher(content);
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
        int id=Integer.parseInt(request.getParameter("hiddenvalue"));
        String content=request.getParameter("editcontent");
        System.out.println(content);
        TBLPageContent.setContent(content, id);                                 
        content=TBLPageContent.getContent(id);        
        request.setAttribute("homecontent", content);
        RequestDispatcher rd;
        switch(id)
        {
            case 1:content="edithome.jsp";
                break;
            case 2:content="editaboutus.jsp";
                break;
            case 3:content="editcontactus.jsp";
                break;
            case 4:content="edittermsandcondition.jsp";
                break;
            default:content="edithome.jsp";
        }
        rd=request.getRequestDispatcher(content);
        rd.forward(request, response); 
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
