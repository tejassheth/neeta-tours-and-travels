package com.neeta.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetAllImages
 */
@WebServlet("/GetAllImages")

public class GetAllImages extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllImages() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
		File file = new File(request.getRealPath("")+"\\images\\"+"package_1");
		//System.out.print(file.getPath());
		File[] files = file.listFiles();  
		ArrayList<String> imagList=new ArrayList<String>();
		 for (int fileInList = 0; fileInList < files.length; fileInList++)  
		 {  
			 imagList.add(files[fileInList].getName());  
		 }  
		 request.setAttribute("path",".\\images\\"+"package_1");
		 request.setAttribute("imgList",imagList);
		 RequestDispatcher rd=request.getRequestDispatcher("admin/packageimages.jsp");
		 rd.forward(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
