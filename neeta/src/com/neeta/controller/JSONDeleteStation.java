package com.neeta.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.neeta.beans.StationBean;
import com.neeta.model.TblStation;

/**
 * Servlet implementation class JSONDeleteStation
 */
//@WebServlet("/JSONDeleteStation")
public class JSONDeleteStation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSONDeleteStation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		StationBean stationBean =new StationBean();
		stationBean.setStationId(Integer.parseInt(request.getParameter("station_id")));
		stationBean.setStationName(request.getParameter("station_name"));
		JSONObject jo=new JSONObject();
		if(TblStation.deleteStation(stationBean))
			jo.put("Result","True");
		else
			jo.put("Result","False");
		out.print(jo);
	}

}
