package com.neeta.controller;

import com.neeta.beans.PackageBean;
import com.neeta.model.TblPackage;
import com.neeta.model.PackageImages;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class AddPackageImages
 */

@WebServlet(name = "AddPackageImages", urlPatterns = {"/admin/AddPackageImages"})
@MultipartConfig
public class AddPackageImages extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPackageImages() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
        {
			System.out.println("12345");
			ArrayList<PackageBean> pb=TblPackage.getPackage();
            RequestDispatcher rd=request.getRequestDispatcher("addpackageimage.jsp");
            request.setAttribute("plist", pb);
            rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
        {   // TODO Auto-generated method stub            
            
            String id = PackageImages.getValue(request.getPart("package"));  // Retrieves <input type="text" name="description">
            //System.out.println(request.getParameter("package"));
            //System.out.println("12345");
            //System.out.println(PackageImages.getValue(request.getPart("theValue1")));
            String str=PackageImages.getValue(request.getPart("theValue1"));
            System.out.println(str);
            int val=Integer.parseInt(str);
            String path = request.getRealPath("");       
            for(int i=1;i<=val+1;i++)
            {
                Part filePart = request.getPart("imgpath_"+i); // Retrieves <input type="file" name="file">
                String filename = PackageImages.getFilename(filePart,path);
                if(PackageImages.uploadImage(path,id,filePart,filename))
                {
                    System.out.println("uploaded");
                }                
            }
            
           ArrayList<PackageBean> pb=TblPackage.getPackage();
            RequestDispatcher rd=request.getRequestDispatcher("addpackageimage.jsp");
            request.setAttribute("plist", pb);
            rd.forward(request, response);
        }
	
}
