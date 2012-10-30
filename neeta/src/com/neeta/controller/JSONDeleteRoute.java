package com.neeta.controller;

import java.awt.print.Printable;
import java.io.IOException;
import java.io.PrintWriter;

import javax.lang.model.type.PrimitiveType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.neeta.model.TblRoute;
import com.neeta.model.TblRoute_Map;

/**
 * Servlet implementation class JSONDeleteRoute
 */
// @WebServlet("/JSONDeleteRoute")
public class JSONDeleteRoute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JSONDeleteRoute() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // TODO Auto-generated
	 * method stub }
	 * 
	 * /**
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 * response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		RequestDispatcher rd;
		JSONObject jo=new JSONObject();
		try {
			int routeId =Integer.parseInt(request.getParameter("routeid"));
			if(	TblRoute.deleteRoute(routeId))
				jo.put("Result","True");
			else
				jo.put("Result","False");
			
			} catch (Exception e) {
			e.printStackTrace();
			jo.put("Result","False");
		}
		out.print(jo);
	}
}
