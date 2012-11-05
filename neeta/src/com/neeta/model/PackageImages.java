/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neeta.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.http.Part;

/**
 *
 * @author Ritz
 */
public class PackageImages
{
    public static String getValue(Part part) throws IOException 
        {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(part.getInputStream(), "UTF-8"));
	    StringBuilder value = new StringBuilder();
	    char[] buffer = new char[1024];
	    for (int length = 0; (length = reader.read(buffer)) > 0;) 
            {
	        value.append(buffer, 0, length);
	    }
	    return value.toString();
	}
    
    public static String getFilename(Part part,String path) 
    {
	    
            for (String cd : part.getHeader("content-disposition").split(";")) 
            {
	        if (cd.trim().startsWith("filename")) 
                {
	            String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
	            return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
	        }
	    }
	    return null;
    }
    
    public static boolean uploadImage(String path,String id,Part filePart,String filename) throws IOException
    {
        File file=new File(path+"//images//package"+id);
        if(!(file.isDirectory()))
        {
            file.mkdir();
            System.out.println(path);
        }
        path=path+"//images//package"+id;
        //System.out.println(path);
	InputStream filecontent = filePart.getInputStream();
        OutputStream out = new FileOutputStream(new File(path+"//"+filename));
	int read = 0;
	byte[] bytes = new byte[1024];	 
	while ((read = filecontent.read(bytes)) != -1) 
        {
            out.write(bytes, 0, read);
	}	 
	filecontent.close();
	out.flush();
	out.close();
        return true;
    }
    
    public static ArrayList<String> getPath(int pid,String path)
    {
        //System.out.println(path);
        File file = new File(path);
        //System.out.println(file.getPath());
	File[] files = file.listFiles();  
	ArrayList<String> imageList=new ArrayList<String>();
	 for (int fileInList = 0; fileInList < files.length; fileInList++)  
	 {  
             imageList.add(files[fileInList].getName());  
             //System.out.println(path);
	 }
        return imageList;
    }
    
    public static String deleteImages(ArrayList<String> imagename,String path)
    {
        Iterator ir=imagename.iterator(); 
        String pkg=null;
        while(ir.hasNext())
        {
            String str=(String)ir.next();
            if(str.equals("submit"))
            {                
            }                
            else
            {            
                String[] part=str.split("_");
                //System.out.println(part[0]);
                //System.out.println(part[1]);
                //System.out.println(path);
                pkg=part[1];
                path=path+"//images//package"+part[1]+"//"+part[0];
                File f=new File(path);
                f.delete();
            }
            
        }
        return pkg;
    }
}
