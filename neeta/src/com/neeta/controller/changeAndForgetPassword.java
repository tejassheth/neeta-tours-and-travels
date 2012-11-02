package com.neeta.controller;



import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.neeta.model.TblLogin;


@WebServlet("/admin/changeAndForgetPassword")
public class changeAndForgetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       TblLogin login=new TblLogin();
       RequestDispatcher rd=null; 
       RequestDispatcher rd1=null; 
       String result_message=null;
    
    public changeAndForgetPassword()
    {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String action_type=request.getParameter("request_type");
		//String action_type1=request.getParameter("request_type1");
		//System.out.println(action_type);
		
		
		if(action_type.equals("ChangePassword"))
		{
			String new_password=request.getParameter("new_password");
			String confirm_password=request.getParameter("confirm_password");
			if(new_password.equals(confirm_password))
			{
				String old_password=request.getParameter("old_password");
				boolean success=login.changePassword(old_password,new_password);
				if(success==true)
					result_message="Your password has been changed successfully";
				else
					result_message="Could not change your password ";
				request.setAttribute("result", result_message);
			}
			else
			{
			result_message="Password doesnot match";
			request.setAttribute("result", result_message);
			
			}
			rd1=request.getRequestDispatcher("changepassword.jsp");
			rd1.forward(request,response);
			
			//System.out.println(action_type);
			//return ;
		}
		else if (action_type.equals("SendRequest"))
		{
			//System.out.println(action_type);
			String curr_email=request.getParameter("curr_email");
			boolean result=login.forgetPassword(curr_email);
			if(result==true)
			result_message="Your password has been sent successfully";
			else
			result_message="Could not got your details/password ";
			request.setAttribute("result", result_message);
			rd=request.getRequestDispatcher("forgotpassword.jsp");
			rd.forward(request, response);
		}
	}
}
