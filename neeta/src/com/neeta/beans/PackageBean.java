package com.neeta.beans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Ritz
 */
public class PackageBean 
{
    String name;
    String information;
    String incl_excl;
    int duration;
    float fare;
    int hotelId;
    int p_id=0;

    
    

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public void setName(String name) {
        this.name = name;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public void setIncl_excl(String incl_excl) {
        this.incl_excl = incl_excl;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setFare(float fare) {
        this.fare = fare;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public String getInformation() {
        return information;
    }

    public String getIncl_excl() {
        return incl_excl;
    }

    public int getDuration() {
        return duration;
    }

    public float getFare() {
        return fare;
    }

    public int getHotelId() {
        return hotelId;
    }

	public void setMin_person(int parseInt) {
		// TODO Auto-generated method stub
		
	}
}
