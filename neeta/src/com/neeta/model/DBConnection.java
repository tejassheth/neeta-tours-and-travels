package com.neeta.model;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;


public class DBConnection {
	private static Connection con;

	public static synchronized Connection getConnection() {
		if (con == null) {
			try {

				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(
						"jdbc:mysql://localhost/neetadb", "root", "");
				con.setAutoCommit(false);
			} catch (ClassNotFoundException ex) {
				System.out.println("Class not found in DBConnection:-"
						+ ex.getMessage());
			} catch (SQLException ex) {
				System.out.println("Sql Exception in DBConnection:- "
						+ ex.getMessage());

			}

		}
		return con;
	}
	public static void main(String [] args) throws SQLException {
		Connection cn=getConnection();
		Savepoint svpoint=cn.setSavepoint("savepoint");
		   Statement stmt= con.createStatement();
		   stmt.execute("insert into Login(emailid,password,roleid)values ('tejas@gmail.com','sheth',1);");
		   cn.commit();
		  
		   
		System.out.print("Tejas");
	}
}
