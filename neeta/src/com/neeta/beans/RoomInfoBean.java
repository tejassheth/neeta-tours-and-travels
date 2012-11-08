package com.neeta.beans;


public class RoomInfoBean 

{
	int h_id=0;
	String roomType=null;
	float fare=0;
	
	
	public String getRoom()
	{
	return roomType;
	}	
	
	public String setRoom(String roomType)
	{
	return this.roomType=roomType;	
	}
			
	
	public float getFare()
	{
	return fare;
	}	
	
	public float setFare(float fare)
	{
	return this.fare=fare;	
	}
	
	
	public int getH_id()
	{
	return h_id;
	}	
	
	public int setH_id(int h_id)
	{
	return this.h_id=h_id;	
	}
	
	
	
	
	
	
	

}
