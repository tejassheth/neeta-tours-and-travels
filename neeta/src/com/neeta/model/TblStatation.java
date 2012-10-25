package com.neeta.model;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import com.neeta.beans.StationBean;


public class TblStatation {
	static Connection con;

	/**
	 * @param args
	 */
	TblStatation() {
	}

	public static boolean saveStation(StationBean stationBean) {
		try {
			con = DBConnection.getConnection();
			Savepoint svPoint = con.setSavepoint("savestation");
			if (stationBean.getStationName().equalsIgnoreCase("")) {
				return false;
			}
			String query = "insert into stations (station_name) values (?);";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, stationBean.getStationName());
			pst.execute();
			con.commit();
			return true;
		} catch (SQLException e) {
			try {
				e.printStackTrace();
				con.rollback();
				return false;
			} catch (SQLException e1) {
				e.printStackTrace();
				return false;
			}
		}
	}

	public static StationBean getState() {
		StationBean state = new StationBean();
		return state;
	}

	public static boolean deleteStation(StationBean stationBean) {
		try {
			con = DBConnection.getConnection();
			Savepoint svPoint = con.setSavepoint("deletestation");
			if (stationBean.getStationName().equalsIgnoreCase("")) {
				return false;
			}
			String query = "delete from stations where station_id = ? and station_name = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, stationBean.getStationId());
			pst.setString(2, stationBean.getStationName());
			pst.execute();
			con.commit();
			return true;
		} catch (SQLException e) {
			try {
				e.printStackTrace();
				con.rollback();
				return false;
			} catch (SQLException e1) {
				e.printStackTrace();
				return false;
			}

		}
	}

	public static boolean updateStation(StationBean oldStation,
			StationBean newStation) {
		try {
			con = DBConnection.getConnection();
			Savepoint svPoint = con.setSavepoint("deletestation");
			if (oldStation.getStationName().equalsIgnoreCase("")
					&& (oldStation.getStationId() == 0)
					&& (newStation.getStationName().equalsIgnoreCase(""))) {
				return false;
			}
			String query = "update stations set station_name =? where station_id =? and station_name= ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, newStation.getStationName());
			pst.setInt(2, oldStation.getStationId());
			pst.setString(3, oldStation.getStationName());
			pst.execute();
			con.commit();
			return true;
		} catch (SQLException e) {
			try {
				e.printStackTrace();
				con.rollback();
				return false;
			} catch (SQLException e1) {
				e.printStackTrace();
				return false;
			}
		}
	}

	public static ArrayList<StationBean> getAllStations() {
		ArrayList<StationBean> station = new ArrayList<StationBean>();
		try {
			con = DBConnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st
					.executeQuery("select * from stations order by station_name");
			while (rs.next()) {
				StationBean stationBeans = new StationBean();
				stationBeans.setStationName(rs.getString("station_name"));
				stationBeans.setStationId(rs.getInt("station_id"));
				station.add(stationBeans);
			}
			return station;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			station = null;
			e.printStackTrace();
			return station;
		}
	}
}