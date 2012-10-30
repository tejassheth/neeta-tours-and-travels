package com.neeta.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.neeta.beans.Route_MapBeans;
import com.neeta.beans.StationBean;
import com.neeta.model.TblRoute_Map;
import com.neeta.model.TblStation;

/**
 * Servlet implementation class JSONRouteData
 */
// @WebServlet("/JSONRouteData")
public class JSONRouteData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JSONRouteData() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		int routeId=Integer.parseInt(request.getParameter("routeId"));
		ArrayList<Route_MapBeans> routeDataList = TblRoute_Map.getRouteData(routeId);
		JSONObject jo = new JSONObject();
		JSONArray jary = new JSONArray();

		if (routeDataList != null) {
			jo.put("Result", "True");
			Iterator<Route_MapBeans> it = routeDataList.iterator();
			while (it.hasNext()) {
				Route_MapBeans route_MapBeans = (Route_MapBeans) it.next();
				JSONObject j = new JSONObject();
				j.put("routeId",route_MapBeans.getRoute_id());
				j.put("mapId",route_MapBeans.getMap_id());
				StationBean stationBean = TblStation.getStation(route_MapBeans.getStation_id());
				if(stationBean!=null)
					j.put("station",stationBean.getStationName() );
				j.put("seatingFare", route_MapBeans.getSeating_fare());
				j.put("sleepingFare",route_MapBeans.getSleeping_fare());
				j.put("distance",route_MapBeans.getDistance());
				j.put("duration", ""+route_MapBeans.getDuration()+"");
				jary.add(j);
			}
		} else {
			jo.put("Result", "True");
		}
		jo.put("Data", jary);
		out.print(jo);
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
