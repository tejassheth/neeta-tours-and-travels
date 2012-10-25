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
 * Servlet implementation class JSONEditStation
 */
@WebServlet("/JSONEditStation")
public class JSONEditStation extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSONEditStation() {
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
		JSONObject jo=new JSONObject();
		StationBean oldStation= new StationBean();
		StationBean newStation=new StationBean();
		oldStation.setStationId(Integer.parseInt(request.getParameter("station_id")));
		oldStation.setStationName(request.getParameter("station_name"));
		newStation.setStationId(oldStation.getStationId());
		newStation.setStationName(request.getParameter("new_station_name"));
		/*oldStation.setStationId(2);
		oldStation.setStationName("Limbdi");
		newStation.setStationId(2);
		newStation.setStationName("Vastrapur");*/
		System.out.print(newStation.getStationId());
		System.out.print(oldStation.getStationId());
		System.out.print(newStation.getStationName());
		System.out.print(oldStation.getStationName());
		if(TblStatation.updateStation(oldStation, newStation))
			jo.put("Result","True");
		else
			jo.put("Result", "False");
		out.print(jo);
	}

}
