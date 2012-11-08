package com.neeta.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.neeta.beans.RoomInfoBean;


public class TblRoom 
{
	
	//List<RoomInfoBean> rim=new ArrayList<RoomInfoBean>();
	java.sql.Connection con=DBConnection.getConnection();
	public boolean insert(RoomInfoBean rim1) throws SQLException
	{
		//RoomInfoBean ri=new RoomInfoBean();
		
		String r_query="select H_id from rooms where H_id=? and Room_type=?";
		PreparedStatement pr=con.prepareStatement(r_query);
		pr.setInt(1,rim1.getH_id());
		pr.setString(2,rim1.getRoom());
		ResultSet rs=pr.executeQuery();
		if(rs.next())
		{
			//System.out.println("already present...");
			r_query="delete from rooms where H_id=? and Room_type=?";
			pr=con.prepareStatement(r_query);
			pr.setInt(1,rim1.getH_id());
			pr.setString(2,rim1.getRoom());
			pr.execute();
		}
		r_query="insert into rooms(H_id,Room_type,Fare) values(?,?,?)";
		pr=con.prepareStatement(r_query);
		pr=con.prepareStatement(r_query);
		pr.setInt(1,rim1.getH_id());
		pr.setString(2,rim1.getRoom());
		pr.setFloat(3,rim1.getFare());
		pr.executeUpdate();
		con.commit();
		
		
		
		return true;
	}
	

}
