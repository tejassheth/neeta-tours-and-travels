package com.neeta.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import com.neeta.beans.Route_MapBeans;

public class TblRoute_Map {

	public static ArrayList<Route_MapBeans> getRouteData(int routeId) {
		ArrayList<Route_MapBeans> routeData = new ArrayList<Route_MapBeans>();
		try {
			Connection con = DBConnection.getConnection();
			String sql = "SELECT map_id, route_id, station_id, seating_fare, sleeping_fare, distance, duration FROM  route_map WHERE route_id =? ORDER BY distance";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, routeId);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Route_MapBeans route_MapBeans = new Route_MapBeans();
				route_MapBeans.setMap_id(rs.getInt("map_id"));
				route_MapBeans.setRoute_id(rs.getInt("route_id"));
				route_MapBeans.setStation_id(rs.getInt("station_id"));
				route_MapBeans.setSeating_fare(rs.getInt("seating_fare"));
				route_MapBeans.setSleeping_fare(rs.getInt("sleeping_fare"));
				route_MapBeans.setDistance(rs.getInt("distance"));
				route_MapBeans.setDuration(rs.getString("duration"));
				routeData.add(route_MapBeans);
			}
			return routeData;
		} catch (SQLException e) {
			return routeData = null;
		}

	}
}
