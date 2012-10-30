package com.neeta.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.neeta.model.TblBus_Detail;

/**
 * Servlet implementation class JSONDeleteBus
 */
@WebServlet("/JSONDeleteBus")
public class JSONDeleteBus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JSONDeleteBus() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		JSONObject jo = new JSONObject();
		try {
			int bus_id = Integer.parseInt(request.getParameter("busid"));
			// System.out.print(request.getParameter("busid"));
			if (TblBus_Detail.deleteBus(bus_id)) {
				jo.put("Result", "True");
			} else {
				jo.put("Result", "False");
			}
		} catch (Exception e) {
			jo.put("Result", "False");
		}
		out.print(jo);
	}

}
