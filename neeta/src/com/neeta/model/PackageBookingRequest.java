package com.neeta.model;


import java.util.*;
import java.sql.*;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.activation.*;

import com.neeta.beans.PackageBookingDetailsBean;


public class PackageBookingRequest 

{
	Statement st=null;
	ResultSet rs=null;
	List<PackageBookingDetailsBean>  details=new ArrayList<PackageBookingDetailsBean>();
	String user_email=null,status=null;
	String Book_status=null;
	static Connection con1=DBConnection.getConnection();
	public List<PackageBookingDetailsBean> Package_Booking_Data() throws SQLException
	{
		//String status1="pending";
		String pkg_book_details="select * from pkg_booking where status='pending'";
		
		st=con1.createStatement();
		PackageBookingDetailsBean pbd=null;
		rs=st.executeQuery(pkg_book_details);
		while(rs.next())
		{
			
			pbd=new PackageBookingDetailsBean();
			
			
			pbd.setpackagebooking_id(rs.getInt("PB_id"));
			
			pbd.setPackage_id(rs.getInt("P_id"));
			
			pbd.setemail_id(rs.getString("email_id"));
			
			pbd.setfare(rs.getFloat("Fare"));
			pbd.setbooking_date(rs.getString("Booking_date"));
			pbd.setjourney_date(rs.getString("Journey_date"));
			pbd.setno_of_persons(rs.getInt("no_of_person"));
			//pbd.setstatus(rs.getString("status"));
			details.add(pbd);
		}
		
		
		st.clearBatch();
		rs.close();
		
		
		return details;		
	}
	
	public void Request_Accept(int PB_id,String email,String fare) throws AddressException, MessagingException, SQLException
	{
		
		 user_email=email;
		 status="confirmed";
		
		boolean result=sendEmail(user_email,status,null,fare);
		if(result==true)
		{
		Book_status="update pkg_booking set status=? where PB_id="+PB_id;
			PreparedStatement ps=con1.prepareStatement(Book_status);
			
			ps.setString(1, status);
			ps.executeUpdate();
			con1.commit();
			ps.clearBatch();
		ps.close();	
		}
		
		
		
		
		
		st.clearBatch();
		
		
	}
	public void Request_Reject(int id,String email_address) throws AddressException, MessagingException, SQLException
	{
		user_email=email_address;
		status="Rejected";
		
		boolean result1=sendEmail(user_email,status,null,null);
		if(result1==true)
		{
			Book_status="update Pkg_Booking set status=? where PB_id="+id;
			PreparedStatement ps1=con1.prepareStatement(Book_status);
			ps1.setString(1, status);
			ps1.executeUpdate();
			con1.commit();
			ps1.clearBatch();
ps1.close();
		}
		
		st.clearBatch();
		
		
	}
	
	
	boolean sendEmail(String email,String output,String password,String fare) throws AddressException, MessagingException
	
	{
		String fromAddress = "dante21vergil@gmail.com";
	    	  String toAddress =email;
	    	  String subject=null ; 
	    	  String message=null;
	    	  if(output.equals("confirmed"))
	    	  {
	    	  message = "<h1>Respected sir," +
	    	  		" Your requested hotel booking has been approved" +
	    	  		" This is the email confirming your booking" +
	    	  		" Please pay amount of Rs"+fare+" at the main office" +
	    	  		"Have a good Day" +
	    	  		"<br>Regards<br>" +
	    	  		"Team Neeta</h1>" ;
	    	  subject="Package Booking Updates";
	    	  }
	    	  else if(output.equals("Rejected"))
	    	  {
	    	  message="Respected sir," +
		    	  		"Your requested hotel booking has been  not approved due to unavailbilty of any room" +
		    	  		"Sorry for the inconvience" +
		    	  		"Have a good Day" +
		    	  		"Regards " +
		    	  		"Team Neeta" ;
	    	  subject="Package Booking Updates";
	    	  }
	    	  else if(output.equals("gotpassword"))
	    	  {
	    		  message="Respected sir, your password is "+password;
	    		  subject="Neeta Bus-Your Password";
	    	
	    	  }
	    	  Properties properties = System.getProperties();
	    	  properties.put("mail.smtps.host","smtp.gmail.com");
	    	  properties.put("mail.smtps.auth", "true");

	    	  Session session2 = Session.getInstance(properties);
	    	  MimeMessage msg = new MimeMessage(session2);

	    	  msg.setFrom(new InternetAddress(fromAddress));
	    	  msg.addRecipients(Message.RecipientType.TO, toAddress);
	    	  msg.setSubject(subject);
	    	  msg.setText(message);
				
	    	  Transport tr1 = session2.getTransport("smtps");
	    	  
	    	  tr1.connect("smtp.gmail.com", "dante21vergil@gmail.com", "wesker0265");
	    	  tr1.sendMessage(msg, msg.getAllRecipients());
	    	  tr1.close(); 
	    	 
			
		
		
		
		return true;
	}
	

}
