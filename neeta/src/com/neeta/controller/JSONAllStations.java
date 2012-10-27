package com.neeta.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.neeta.beans.StationBean;
import com.neeta.model.TblStatation;

/**
 * Servlet implementation class JSONAllStations
 */
//@WebServlet("/JSONAllStations")
public class JSONAllStations extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSONAllStations() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/json");
		PrintWriter out = response.getWriter();
		JSONObject j = new JSONObject();
		JSONArray jary = new JSONArray();
		ArrayList<StationBean> stationList = TblStatation.getAllStations();
		if (stationList != null) {
			j.put("Result", "True");
			Iterator<StationBean> it = stationList.iterator();
			while (it.hasNext()) {
				JSONObject jo = new JSONObject();
				StationBean sb = (StationBean)it.next();
				jo.put("stationName",sb.getStationName());
				jo.put("staionId", sb.getStationId());
				//out.print(cb.getCityName()+"   " +cb.getCityId()+" ");
				jary.add(jo);
		}
		} else {
			j.put("Result","False");
		}
		j.put("Data", jary);
		out.print(j);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}*/

}
