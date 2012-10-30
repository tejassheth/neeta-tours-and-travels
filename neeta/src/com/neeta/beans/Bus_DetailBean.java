package com.neeta.beans;

public class Bus_DetailBean {

	int bus_id;
	String bus_no;
	int seating;
	int sleeper;
        String route;

    public void setRoute(String route) {
        this.route = route;
    }

    public String getRoute() {
        return route;
    }
	public int getBus_id() {
		return bus_id;
	}
	public void setBus_id(int bus_id) {
		this.bus_id = bus_id;
	}
	public String getBus_no() {
		return bus_no;
	}
	public void setBus_no(String bus_no) {
		this.bus_no = bus_no;
	}
	public int getSeating() {
		return seating;
	}
	public void setSeating(int seating) {
		this.seating = seating;
	}
	public int getSleeper() {
		return sleeper;
	}
	public void setSleeper(int sleeper) {
		this.sleeper = sleeper;
	}
	
}
