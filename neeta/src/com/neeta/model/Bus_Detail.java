package com.neeta.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

import com.neeta.beans.Bus_DetailBean;
import com.neeta.beans.Route_BusesBean;

public class Bus_Detail {

	private static Connection con;
	
	public static boolean modifyBusDetail(Bus_DetailBean bus, Route_BusesBean routebus)
	{
		Savepoint sp = null;
		try
		{
			con = DBConnection.getConnection();
			sp = con.setSavepoint("routemodify");
			PreparedStatement st = con.prepareStatement("update bus_detail set bus_no=?, seating=?, sleeper=? where bus_id=?");
			st.setString(1,bus.getBus_no());
			st.setInt(2,bus.getSeating());
			st.setInt(3, bus.getSleeper());
			st.setInt(4, bus.getBus_id());
			st.execute();
			
			PreparedStatement st2 = con.prepareStatement("update route_buses set route_id=?, source_time=? where bus_id=?");
			st2.setInt(1, routebus.getRoute_id());
			st2.setString(2, routebus.getSource_time());
			st2.setInt(3, routebus.getBus_id());
			st2.execute();
			
			con.commit();
			return true;
		}
		catch(Exception e)
		{
			System.out.print(e.toString());
			try {
				con.rollback(sp);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
		}
	}
	public static boolean getBusData(int busid, Bus_DetailBean bus, Route_BusesBean routebus)
	{
		try
		{
			con = DBConnection.getConnection();
			PreparedStatement st = con.prepareStatement("select bus_id, bus_no, seating, sleeper from bus_detail where bus_id=?");
			st.setInt(1, busid);
			ResultSet rs = st.executeQuery();
			rs.next();
			bus.setBus_id(rs.getInt(1));
			bus.setBus_no(rs.getString(2));
			bus.setSeating(rs.getInt(3));
			bus.setSleeper(rs.getInt(4));
			
			PreparedStatement st2 = con.prepareStatement("select route_id, bus_id, status, source_time from route_buses where bus_id=?");
			st2.setInt(1, busid);
			ResultSet rs1 = st2.executeQuery();
			rs1.next();
			routebus.setRoute_id(rs1.getInt(1));
			routebus.setBus_id(rs1.getInt(2));
			routebus.setStatus(rs1.getInt(3));
			routebus.setSource_time(rs1.getString(4));

			return true;
		}
		catch(Exception e)
		{
			System.out.print(e.toString());
			e.printStackTrace();
			return false;
		}
	}
	public static boolean addNewBus(Bus_DetailBean bus, Route_BusesBean routebus)
	{
		Savepoint sp=null;
		try
		{
			con = DBConnection.getConnection();
			sp = con.setSavepoint("routeadd");
			PreparedStatement st = con.prepareStatement("insert into bus_detail (bus_no, seating, sleeper) values (?,?,?)");
			st.setString(1, bus.getBus_no());
			st.setInt(2, bus.getSeating());
			st.setInt(3, bus.getSleeper());
			st.execute();
			
			PreparedStatement st1 = con.prepareStatement("select max(bus_id) from bus_detail");
			ResultSet rs = st1.executeQuery();
			rs.next();
			int rtid = rs.getInt(1);
			
			PreparedStatement st2 = con.prepareStatement("insert into route_buses (route_id, bus_id, status, source_time) values (?,?,?,?)");
			st2.setInt(1, routebus.getRoute_id());
			st2.setInt(2, rtid);
			st2.setInt(3, 0);
			st2.setString(4, routebus.getSource_time());
			st2.execute();
			
			con.commit();
			return true;
		}
		catch(Exception e)
		{
			System.out.print(e.toString());
			try {
				con.rollback(sp);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
		}
	}
}
