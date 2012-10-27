package com.neeta.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.neeta.beans.LoginBean;

public class TblLogin {
	private static Connection con;
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
}
