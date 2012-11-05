package com.neeta.model;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.neeta.beans.HotelInfoBean;


public class TblHotel 
{

	Statement st=null;
	ResultSet rs=null;
	static Connection con=DBConnection.getConnection();
	/*get connection class object*/
	
	public boolean add_Hotel(HotelInfoBean hib) throws SQLException
	{
		
		
		
		String add_htl="insert into hotel_info(Hname,Type,Address,Contact_det,info) values(?,?,?,?,?)";
		 
		 PreparedStatement psmt=con.prepareStatement(add_htl);

		 	psmt.setString(1,hib.getHname());
	        psmt.setInt(2,hib.getType());
	        psmt.setString(3,hib.getAddress());
	        psmt.setString(4,hib.getContact_det());
	        psmt.setString(5,hib.getInfo());
	      
	        psmt.executeUpdate();
	        con.commit();
	        	        
	        return true;
	        // add_image(image_path);
		
		
	}
	
	/*private void add_image(String path )
	{
		
        
	      
	      
	      

		
	}*/
	
	public boolean update(HotelInfoBean hib,int h_id) throws SQLException
	{
		
		String update="update Hotel_info set Hname=?,Type=?,Address=?,Contact_det=?,info=? where H_id="+h_id;
		
		PreparedStatement pst=con.prepareStatement(update);
		pst.setString(1,hib.getHname());
        pst.setInt(2,hib.getType());
        pst.setString(3,hib.getAddress());
        pst.setString(4,hib.getContact_det());
        pst.setString(5,hib.getInfo());
        pst.executeUpdate();
		con.commit();
		return true;
		
	}

	public void remove_hotel(int hotel_id) throws SQLException
	{
		String remove="delete from hotel_info where H_id="+hotel_id;
		
		st=con.createStatement();
		st.executeUpdate(remove);
		
		
		
		
	}
	
	public List<HotelInfoBean> edit_hotel(int hotel_id) throws SQLException
	{
		List<HotelInfoBean> upd_list=new ArrayList<HotelInfoBean>();
		HotelInfoBean hib2=null;
		String upd_select="Select *  from hotel_info where H_id="+hotel_id;
		st=con.createStatement();
		rs=st.executeQuery(upd_select);
		while(rs.next())
		{
			hib2=new HotelInfoBean();
			hib2.setH_id(rs.getInt("H_id"));
			hib2.setHname(rs.getString("Hname"));
			hib2.setType(rs.getInt("Type"));
			hib2.setAddress(rs.getString("Address"));
			hib2.setContact_det(rs.getString("Contact_det"));
			hib2.setInfo(rs.getString("info"));
			upd_list.add(hib2);
			
		}
	
		return upd_list;
	}
	
	public List<HotelInfoBean> hotel_data() throws SQLException
	{
		List<HotelInfoBean> l=new ArrayList<HotelInfoBean>();
		HotelInfoBean hib=null;
		String details="Select * from hotel_info";
		st=con.createStatement();
		rs=st.executeQuery(details);
		while(rs.next())
		{
			hib=new HotelInfoBean();
			hib.setH_id(rs.getInt("H_id"));
			hib.setHname(rs.getString("Hname"));
			hib.setType(rs.getInt("Type"));
			hib.setAddress(rs.getString("Address"));
			hib.setContact_det(rs.getString("Contact_det"));
			hib.setInfo(rs.getString("info"));
			l.add(hib);
		}
		con.commit();
		
		
		return l;
	}
	
	
	
	
}
