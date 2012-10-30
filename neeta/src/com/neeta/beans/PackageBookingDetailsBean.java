package com.neeta.beans;


public class PackageBookingDetailsBean 
{

	private int packagebooking_id=0;
	private int package_id=0;
	private String email_id=null;
	private float fare=0;
	private String booking_date=null;
	private String journey_date=null;
	private int no_of_persons=0;
	private String status=null;
	
	public int getpackagebooking_id()
	{
		return packagebooking_id;
	
	}
	public int setpackagebooking_id(int packagebooking_id)
	{
		return this.packagebooking_id=packagebooking_id;
		
	}
	
	
	
	public int getPackage_id()
	{
	return package_id;
	}	
	public int setPackage_id(int package_id)
	{
	return this.package_id=package_id;	
	}
	
	public String getemail_id()
	{
		
		return email_id;
	}
	public String setemail_id(String email_id)
	{
		
		return this.email_id=email_id;
	}
	
	
	public float getfare()
	{
		return fare;
		
	}
	public float setfare(float fare)
	{
	return this.fare=fare;	
	}
	
	
	public String getbooking_date()
	{
		return booking_date;
		
	}
	public String setbooking_date(String booking_date)
	{
	return this.booking_date=booking_date;	
	}
	
	public String getjourney_date()
	{
		return journey_date;
		
	}
	public String setjourney_date(String journey_date)
	{
	return this.journey_date=journey_date;	
	}
	
	
	public int getno_of_persons()
	{
		return no_of_persons;
		
	}
	public int setno_of_persons(int no_of_persons)
	{
	return this.no_of_persons=no_of_persons;	
	}
	
	
	public String getstatus()
	{
		return status;
		
	}
	public String setstatus(String status)
	{
	return this.status=status;	
	}
	
	
	
	
	
	
	
	
}
