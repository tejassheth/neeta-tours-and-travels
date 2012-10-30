package com.neeta.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.neeta.beans.RolesBeans;

public class TblRoles {
	public static RolesBeans getRole(int rolesId) {
		RolesBeans rolesBeans=new RolesBeans();
		Connection con=DBConnection.getConnection();
		try
		{
			String sql="SELECT roleid, role_type FROM roles WHERE roleid=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, rolesId);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				rolesBeans.setRolesId(rs.getInt("roleid"));
				rolesBeans.setRoleName(rs.getString("role_type"));
				
			}
			else
				rolesBeans=null;
			
		}
		catch(SQLException e)
		{
			rolesBeans=null;
		}
	return rolesBeans;
	}
}
