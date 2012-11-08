package com.neeta.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.neeta.beans.BusBookingDetailBean;

public class BusBooking {
	public ArrayList<BusBookingDetailBean> getBusBooking(int busid, String date) {
		try {
			BusBookingDetailBean temp = null;
			Connection con = DBConnection.getConnection();
			String query = "select passenger_name, passenger_contactno, email_id,(select station_name from stations where station_id=source_id) as Source,(select station_name from stations where station_id=destination_id) as Destination, passengers, status, booked_date, journey_date,total_fare, transaction_id from booking_detail where bus_id= ? and journey_date= ? ";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, busid);
			pst.setString(2, date);
			// st.setString(2,date);
			ResultSet rs = pst.executeQuery();
			ArrayList<BusBookingDetailBean> ar = new ArrayList<BusBookingDetailBean>();
			while (rs.next()) {
				temp = new BusBookingDetailBean();
				
				temp.setPassenger_name(rs.getString("passenger_name"));
				temp.setPassenger_contactno(rs.getString("passenger_contactno"));
				temp.setEmailid(rs.getString("email_id"));
				temp.setSource(rs.getString(4));
				temp.setDestination(rs.getString(5));
				temp.setPassenger(rs.getInt("passengers"));
				temp.setStatus(rs.getString("status"));
				temp.setBooked_date(rs.getString("booked_date"));
				temp.setJourney_date(rs.getString("journey_date"));
				temp.setTotal_fare(rs.getInt("total_fare"));
				System.out.println(rs.getInt("transaction_id"));
				temp.setTransaction_id(rs.getInt("transaction_id"));
				ar.add(temp);
			}
			// BusBookingDetailBean []temparray = new
			// BusBookingDetailBean[ar.size()];
			// ar.toArray(temparray);
			return ar;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public List<BusBookingDetailBean> bus_data() throws SQLException 
	{
		List<BusBookingDetailBean> bus_list = new ArrayList<BusBookingDetailBean>();
		String bus_data = "select bus_id,bus_no from bus_detail";
		Connection con1 = DBConnection.getConnection();
		BusBookingDetailBean bbdb = null;
		Statement st = con1.createStatement();
		ResultSet rs = st.executeQuery(bus_data);
		while (rs.next()) 
		{
			bbdb = new BusBookingDetailBean();
			// System.out.println(rs.getInt("bus_id"));
			bbdb.setBus_id(rs.getInt("bus_id"));
			//System.out.println(rs.getString("bus_no"));
			bbdb.setBus_no(rs.getString("bus_no"));
			bus_list.add(bbdb);
		}
		return bus_list;
	}
}
