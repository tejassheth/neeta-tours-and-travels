package com.neeta.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.mail.MessagingException;

import com.neeta.beans.LoginBean;

public class TblLogin {
	private static Connection con;
	PackageBookingRequest pbr=null;
public static LoginBean  checkLogin(LoginBean login )
{
	try {
		Connection cn=DBConnection.getConnection();
		con =DBConnection.getConnection();
		PreparedStatement pst=con.prepareStatement("select * from login where email_id = ? and password = ? ");
		pst.setString(1,login.getEmailid());
		pst.setString(2,login.getPassword());
		ResultSet rs=pst.executeQuery();
		if(rs.next())
		{
			login.setRolesid(rs.getInt("roleid"));
			rs.close();
			return login;
		}
		else
		{
			rs.close();
			return login=null;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return login=null;
	}
}
public boolean forgetPassword(String email) 
{	
	ResultSet rs=null;
	try {
		String sql="select email_id from login where email_id=?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1,email);
		rs=pst.executeQuery();
		if(rs.next())
		{	ResultSet prs;
			String psql="select password from login where email_id=?";
			PreparedStatement ppst=con.prepareStatement(psql);
			ppst.setString(1, email);
			prs=pst.executeQuery();
			String password=null;
			while(prs.next())
			 password=prs.getString("password");
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
	PreparedStatement pst=null;
	ResultSet rs=null;
	String sql="select email_id from login where password=?";
	try {
		pst =con.prepareStatement(sql);
		pst.setString(1, old);
		rs=pst.executeQuery();
		if(rs.next())
		{
			String e_id=rs.getString("email_id");
			String change="update login set password=? where email_id=?'";
			PreparedStatement ps=con.prepareStatement(change);
			ps.setString(1,new_password);
			ps.setString(2, e_id);
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
