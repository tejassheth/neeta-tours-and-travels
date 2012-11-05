/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neeta.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ritz
 */
public class TBLPageContent 
{
    private static Connection con=DBConnection.getConnection();
    private static Savepoint svPoint;
    public static String getContent(int id)
    {
        String query;
        
        switch(id)
        {
            case 1:query="select home from page_content";
                break;
            case 2:query="select aboutus from page_content";
                break;
            case 3:query="select contactus from page_content";
                break;
            case 4:query="select terms from page_content";
                break;
            default:query="select home from page_content";
        }
        try
        {       
            Statement st = con.createStatement();            
            ResultSet rs=st.executeQuery(query);
            String str=null;
            while(rs.next())
            {
                switch(id)
                {
                    case 1:str=rs.getString("home");
                        break;
                    case 2:str=rs.getString("aboutus");
                        break;
                    case 3:str=rs.getString("contactus");
                        break;
                    case 4:str=rs.getString("terms");
                        break;
                    default:str=rs.getString("home");
                }
            }
                
            return str;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return "Not Loaded...from databases this is fake entry....";
        }
        
    }
    
    
    public static void setContent(String content,int id)
    {
        String query;
        System.out.println(content);
        switch(id)
        {
            case 1:query="update page_content set home=?";
                break;
            case 2:query="update page_content set aboutus=?";
                break;
            case 3:query="update page_content set contactus=?";
                break;
            case 4:query="update page_content set terms=?";
                break;
            default:query="update page_content set home=?";
        }
        try 
        {
        	//System.out.println("1");
        	svPoint = con.setSavepoint("content");
        	//System.out.println("2");
            PreparedStatement pst=con.prepareStatement(query);
            //System.out.println("3");
            pst.setString(1,content);
            //System.out.println("4");
            pst.executeUpdate();
            //System.out.println("5");
            con.commit();
        }
        catch (SQLException e) 
        {
            try 
            {
                con.rollback(svPoint);
            } 
            catch (SQLException e1) 
            {
		return;
            }
            return;
        }
    }
}
