package com.neeta.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;

import com.neeta.beans.StationBean;
import com.neeta.model.TblStatation;


/**
 * Servlet implementation class JSONSaveStation
 */
//@WebServlet("/JSONSaveStation")
public class JSONSaveStation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSONSaveStation() {
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
		response.setContentType("text/json");
		PrintWriter out=response.getWriter();
		JSONObject jo=new JSONObject();
		StationBean stationBean = new StationBean();
		stationBean.setStationName(request.getParameter("stationname"));
		//stationBean.setStationName("Limbdi");
		if(TblStatation.saveStation(stationBean))
			jo.put("Result","True");
		else
			jo.put("Result","False");
		//System.out.print(stationBean.getStationName());
		out.print(jo);
	}

}
