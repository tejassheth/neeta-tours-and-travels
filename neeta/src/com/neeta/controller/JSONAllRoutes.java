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

import com.neeta.beans.RouteBean;
import com.neeta.beans.StationBean;
import com.neeta.model.TblRoute;
import com.neeta.model.TblStation;

/**
 * Servlet implementation class JSONAllRoutes
 */
//@WebServlet("/JSONAllRoutes")
public class JSONAllRoutes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSONAllRoutes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		JSONObject jo=new JSONObject();
		JSONArray jary=new JSONArray();
		ArrayList<RouteBean> routeList=TblRoute.getAllRoutes();
		if(routeList!=null)
		{	jo.put("Result","True");
			Iterator<RouteBean> it = routeList.iterator();
			while (it.hasNext()) {
				JSONObject j=new JSONObject();
				RouteBean routeBean = (RouteBean) it.next();
				j.put("routeId", routeBean.getRouteId());
				StationBean stationBean = TblStation.getStation(routeBean.getSourceId());
				if(stationBean!=null)
					j.put("source",stationBean.getStationName() );
				stationBean = TblStation.getStation(routeBean.getDestinationId());
				if(stationBean!=null)
				j.put("desti",stationBean.getStationName() );
				jary.add(j);
				
			}
		}
		else
		{
			jo.put("Result","False");	
		}
		jo.put("Data", jary);
		out.print(jo);
		out.close();
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
