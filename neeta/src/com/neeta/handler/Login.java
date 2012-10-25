package com.neeta.handler;
import org.json.simple.*;
import com.neeta.beans.LoginBean;
import com.neeta.model.TblLogin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		LoginBean login =new LoginBean();
		login.setEmailid(request.getParameter("emailid"));
		login.setPassword(request.getParameter("password"));
		login=TblLogin.checkLogin(login);
		JSONObject jo=new JSONObject();
		if(login!=null)
		{
			jo.put("Result","True");
			HttpSession session=request.getSession();
			session.setAttribute("UserName", login.getEmailid());
			session.setAttribute("Role",login.getRolesid());
		}
		else
			jo.put("Result","False");
		out.print(jo);
	}
}
