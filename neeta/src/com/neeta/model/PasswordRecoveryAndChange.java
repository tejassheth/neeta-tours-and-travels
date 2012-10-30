package com.neeta.model;


import java.sql.*;

import javax.mail.MessagingException;

public class PasswordRecoveryAndChange 
{
	Connection con=DBConnection.getConnection();
	Statement st=null;
	ResultSet rs=null;
PackageBookingRequest pbr=null;
	public boolean forgetPassword(String email) 
	{
		try {
			String f_p="select email_id from login where email_id='"+email+"'";
			st=con.createStatement();
			rs=st.executeQuery(f_p);
			if(rs.next())
			{
				String p="select password from login where email_id='"+email+"'";
				st=con.createStatement();
				rs=st.executeQuery(p);
				String password=null;
				while(rs.next())
				 password=rs.getString("password");
				
				pbr=new PackageBookingRequest();
				boolean email_sent=pbr.sendEmail(email, "gotpassword", password,null);// calling the send email method of PackageBookingRequest class
				if(email_sent==true)
				return true;
				else
				return false;	
			}
			else return false;
			
			
		} 
		catch (SQLException | MessagingException e)
		{
			
			e.printStackTrace();
		}
		return false;
		
	

		
	}
	public boolean changePassword(String old,String new_password)
	{
		String confirm_id="select email_id from login where password='"+old+"'";
		try {
			
			st=con.createStatement();
			rs=st.executeQuery(confirm_id);
			if(rs.next())
			{
				String e_id=rs.getString("email_id");
				String change="update login set password=? where email_id='"+e_id+"'";
				PreparedStatement ps=con.prepareStatement(change);
				ps.setString(1,new_password);
				ps.executeUpdate();
				con.commit();
				return true;
			}
			else
				return false;
			
			
			
			
			
		} 
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		finally
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		return false;
	}
	
	
	
	
	
}
