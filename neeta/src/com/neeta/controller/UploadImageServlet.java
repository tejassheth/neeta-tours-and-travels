package com.neeta.controller;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UploadImageServlet
 */
@WebServlet("/UploadImageServlet")
public class UploadImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
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
		    
		    
		    File ff = new File(saveFile);
			FileOutputStream fileOut = new FileOutputStream(ff);
			fileOut.write(dataBytes, startPos, (endPos - startPos));
			fileOut.flush();
			fileOut.close();
		}

	}

}
