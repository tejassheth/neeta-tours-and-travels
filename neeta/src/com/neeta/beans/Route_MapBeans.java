package com.neeta.beans;

import java.sql.Time;

public class Route_MapBeans {
private int map_id;
private int route_id;
private int station_id;
private int  seating_fare;
private int sleeping_fare;
private int distance; 
private String duration;
public String getDuration() {
	return duration;
}
public void setDuration(String duration) {
	this.duration = duration;
}
public int getMap_id() {
	return map_id;
}
public void setMap_id(int map_id) {
	this.map_id = map_id;
}
public int getRoute_id() {
	return route_id;
}
public void setRoute_id(int route_id) {
	this.route_id = route_id;
}
public int getStation_id() {
	return station_id;
}
public void setStation_id(int station_id) {
	this.station_id = station_id;
}
public int getSeating_fare() {
	return seating_fare;
}
public void setSeating_fare(int seating_fare) {
	this.seating_fare = seating_fare;
}
public int getSleeping_fare() {
	return sleeping_fare;
}
public void setSleeping_fare(int sleeping_fare) {
	this.sleeping_fare = sleeping_fare;
}
public int getDistance() {
	return distance;
}
public void setDistance(int distance) {
	this.distance = distance;
}

}
