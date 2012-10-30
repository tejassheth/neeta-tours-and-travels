package com.neeta.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import com.neeta.beans.RouteBean;
import com.neeta.beans.Route_MapBeans;


public class TblRoute {
	public static ArrayList<RouteBean> getAllRoutes() {
		ArrayList<RouteBean> routeList = new ArrayList<RouteBean>();
		try {
			Connection con = DBConnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT route_id, source, destination FROM route;");
			while (rs.next()) {
				RouteBean routeBean = new RouteBean();
				routeBean.setRouteId(rs.getInt("route_id"));
				routeBean.setSourceId(rs.getInt("source"));
				routeBean.setDestinationId(rs.getInt("destination"));
				routeList.add(routeBean);
			}
			rs.close();
			return routeList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			routeList = null;
			e.printStackTrace();
			return routeList;
		}
	}
	public static boolean addNewRoute(RouteBean route, Route_MapBeans [] stations)
	{
		Savepoint sp=null;
		Connection  con=null; 
		try
		{
			con = DBConnection.getConnection();
			sp = con.setSavepoint("routeadd");	
			
			PreparedStatement st = con.prepareStatement("insert into route (source, destination) values (?,?)");
			st.setInt(1, route.getSourceId());
			st.setInt(2, route.getDestinationId());
			st.execute();
			
			PreparedStatement st1 = con.prepareStatement("select max(route_id) from route where source=? and destination=?");
			st1.setInt(1, route.getSourceId());
			st1.setInt(2, route.getDestinationId());
			ResultSet rs = st1.executeQuery();
			rs.next();
			int route_id = rs.getInt(1);
			
			for(int i=0; i<stations.length; i++)
			{
				PreparedStatement st2 = con.prepareStatement("insert into route_map(route_id, station_id, seating_fare, sleeping_fare, distance, duration) values (?,?,?,?,?,?)");
				st2.setInt(1, route_id);
				st2.setInt(2, stations[i].getStation_id());
				st2.setInt(3, stations[i].getSeating_fare());
				st2.setInt(4, stations[i].getSleeping_fare());
				st2.setInt(5, stations[i].getDistance());
				st2.setString(6, stations[i].getDuration());
				st2.execute();
			}
			con.commit();
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			try {
				con.rollback(sp);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return false;
		}
		
	}
	public static boolean deleteRoute(int routeId) {
		Savepoint sv=null;
		Connection con=null;
		try
		{
			con=DBConnection.getConnection();
			sv=con.setSavepoint("deelteRoute");
			String sql="DELETE FROM route WHERE route_id= ?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, routeId);
			pst.execute();
			con.commit();
			return true;
		}
		catch(SQLException e)
		{
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			return false;
		}
	}


public static RouteBean getRoute(int route_id) {
	RouteBean routeBean  =null;
	try {
		Connection con = DBConnection.getConnection();
		String sql="SELECT route_id, source, destination FROM route where route_id = ?;";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1,route_id);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			routeBean= new RouteBean();
			routeBean.setRouteId(rs.getInt("route_id"));
			routeBean.setSourceId(rs.getInt("source"));
			routeBean.setDestinationId(rs.getInt("destination"));
			
		}
		pst.close();
		rs.close();
		return routeBean;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		routeBean = null;
		e.printStackTrace();
		return routeBean;
	}
}

public static int getRouteByBusId(int busId)
{
    Connection con;
    try 
    {
        //System.out.println("Bus Id:"+busId);
    	con=DBConnection.getConnection();
        String query="select route_id from route_buses where bus_id=?";
        PreparedStatement pst=con.prepareStatement(query);
        pst.setInt(1, busId);                
        ResultSet rs=pst.executeQuery();
        int routeId=0;
        if(rs.next())
            routeId=rs.getInt("route_id");
        //System.out.println("Route ID:"+routeId);
        return routeId;
    }
    catch (SQLException ex) 
    {
        ex.printStackTrace();
        return 0;
    }
}

public static RouteBean getSourceDestinationId(int routeId)
{
    Connection con;            
    try 
    {
        con=DBConnection.getConnection();
        RouteBean rb=new RouteBean();
        String query="select * from route where route_id=?";
        //System.out.println(routeId);
        PreparedStatement pst=con.prepareStatement(query);
        pst.setInt(1, routeId);
        ResultSet rs=pst.executeQuery();
        if(rs.next())
        {
            rb.setRouteId(rs.getInt("route_id"));
            //System.out.println(rs.getInt("route_id"));
            rb.setSourceId(rs.getInt("source"));
            rb.setDestinationId(rs.getInt("destination"));
        }
        else
            return null;
        return rb;
    }
    catch (SQLException ex) 
    {
        ex.printStackTrace();
        return null;
    }
}

public static boolean modifyRoute(RouteBean route, Route_MapBeans [] stations)
{
	Savepoint sp=null;
	Connection con=null;;
	try
	{
		con = DBConnection.getConnection();
		sp = con.setSavepoint("routeadd");	
		
		PreparedStatement st = con.prepareStatement("update route set source=?, destination=? where route_id=?");
		st.setInt(1, route.getSourceId());
		st.setInt(2, route.getDestinationId());
		st.setInt(3, route.getRouteId());
		st.execute();
		
		PreparedStatement st1 = con.prepareStatement("delete from route_map where route_id=?");
		st1.setInt(1, route.getRouteId());
		st1.execute();
		
		int route_id = route.getRouteId();
		
		for(int i=0; i<stations.length; i++)
		{
			PreparedStatement st2 = con.prepareStatement("insert into route_map(route_id, station_id, seating_fare, sleeping_fare, distance, duration) values (?,?,?,?,?,?)");
			st2.setInt(1, route_id);
			st2.setInt(2, stations[i].getStation_id());
			st2.setInt(3, stations[i].getSeating_fare());
			st2.setInt(4, stations[i].getSleeping_fare());
			st2.setInt(5, stations[i].getDistance());
			st2.setString(6, stations[i].getDuration());
			st2.execute();
		}
		con.commit();
		//System.out.println("route updated");
		return true;
	}
	catch(Exception e)
	{
		System.out.println(e);
		try {
			con.rollback(sp);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;
	}
	
}

}