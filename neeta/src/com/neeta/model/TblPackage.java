/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neeta.model;

import com.neeta.beans.HotelInfoBean;
import com.neeta.beans.PackageBean;
import com.neeta.beans.PackageDetailsBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ritz
 */
public class TblPackage 
{
    public static boolean savePackage(PackageBean pb,ArrayList<String> days) 
    {
        Connection con=DBConnection.getConnection();
        Savepoint sp=null;        
        try 
        {
            sp=con.setSavepoint("package");
            //System.out.println("savePackage1");
            String query="insert into fixed_package(Name,Information,Incl_exclusion,Duration,Fare,H_id,min_person) values(?,?,?,?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(query);
            pst.setString(1, pb.getName());
            pst.setString(2, pb.getInformation());
            pst.setString(3, pb.getIncl_excl());
            //System.out.println(pb.getDuration());
            pst.setInt(4,pb.getDuration());
            pst.setFloat(5, pb.getFare());
            pst.setInt(6,pb.getHotelId());
            pst.setInt(7, pb.getMinperson());
            pst.execute();
            //System.out.println("savePackage2");
            con.commit();
            query="select max(P_id) from fixed_package";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            
            if(rs.next())
            {
                int pid=rs.getInt(1);
                //System.out.println(pid);                
                //query="insert into fixedpackage_details(P_id,day,desc) values(?,?,?)";
                Iterator ir=days.iterator();
                int day=1;
                sp=con.setSavepoint("packageDetail");
                while(ir.hasNext())
                {
                    /*query="INSERT INTO fixedpackage_details(P_id,day,desc) values("+pid+","+day+++",'"+(String)ir.next()+"') ";
                    System.out.println(query);
                    st=con.createStatement();
                    st.execute(query);*/
                    query="INSERT INTO fixedpackage_details (P_id,day,description) values(?,?,?) ";
                    pst=con.prepareStatement(query);
                    pst.setInt(1, pid);                    
                    pst.setInt(2, day++);
                    String str=(String)ir.next();
                    //System.out.println(str);
                    pst.setString(3, str);                    
                    pst.execute();                    
                }
                con.commit();
                return true;
            }
            else
                con.rollback();
                
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
            /*try 
            {
                con.rollback(sp);
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(TblPackage.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            return false;
        }
        return false;
        
    }
    
    public static ArrayList<PackageBean> getPackage() 
    {
        Connection con=DBConnection.getConnection();
        String query="select P_id,Name from fixed_package";
        Statement st;
        try 
        {
            st = con.createStatement();
            ResultSet rs=st.executeQuery(query);
            ArrayList<PackageBean> plist=new ArrayList<PackageBean>();
            while(rs.next())
            {
                PackageBean pb=new PackageBean();
                pb.setP_id(rs.getInt("P_id"));
                pb.setName(rs.getString("Name"));
                plist.add(pb);
            }
            return plist;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
            return null;
        }
        
    }
    
    public static boolean updatePackage(PackageBean pb,ArrayList<String> upd_days,int pkg_id) throws SQLException 
    {
        Connection con=DBConnection.getConnection();
        Savepoint sp=null;        
        try 
        {
            sp=con.setSavepoint("package");
            //System.out.println(pkg_id);
            String query="update fixed_package set Name=?,Information=?,Incl_exclusion=?,Duration=?,Fare=?,H_id=?,min_person=? where P_id="+pkg_id;
            PreparedStatement pst=con.prepareStatement(query);
            pst.setString(1, pb.getName());
            pst.setString(2, pb.getInformation());
            pst.setString(3, pb.getIncl_excl());
            pst.setInt(4,pb.getDuration());
            pst.setFloat(5, pb.getFare());
            pst.setInt(6,pb.getHotelId());
            pst.setInt(7, pb.getMinperson());
            pst.execute();
            //System.out.println("savePackage2");
            con.commit();
            
            
            query="delete from fixedpackage_details where P_id="+pkg_id;
            System.out.println(query);
            Statement st=con.createStatement();
            st.executeUpdate(query);
               
                System.out.println(pkg_id);                
                //query="insert into fixedpackage_details(P_id,day,desc) values(?,?,?)";
                Iterator ir=upd_days.iterator();
                int day=1;
                sp=con.setSavepoint("packageDetail");
                while(ir.hasNext())
                {
                    //System.out.println((String)ir.next());
                    query="insert into fixedpackage_details(P_id,day,description) values(?,?,?) ";
                    pst=con.prepareStatement(query) ;
                    pst.setInt(1, pkg_id);
                    String str=(String)ir.next();
                    System.out.println(str);
                    pst.setInt(2, day++);                    
                    pst.setString(3, str);                    
                    //System.out.println(query);
                    //st=con.createStatement();
                    pst.execute();
                                       
                }
                con.commit();
                return true;
            
               
                
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
            con.rollback();
            return false;
        }
      
        }
    
    public List<HotelInfoBean> curr_hotel_data(int hotel_id) throws SQLException
    {
    	List<HotelInfoBean> list=new ArrayList<HotelInfoBean>();
    	Connection con1=DBConnection.getConnection();
    	
    	String query="select H_id,Hname from hotel_info where H_id="+hotel_id;
    	Statement st=con1.createStatement();
    	ResultSet rs=st.executeQuery(query);
    	HotelInfoBean hib=null;
    	while(rs.next())
    	{
    		hib=new HotelInfoBean();
    		hib.setH_id(rs.getInt("H_id"));
    		hib.setHname(rs.getString("Hname"));
    		list.add(hib);
    		
    		
    	}
    	
    	return list;
    }
    public List<PackageBean> package_data(int pkg_id) throws SQLException
    {
    	List<PackageBean>  pkg_list=new ArrayList<PackageBean>();
    	Connection con2=DBConnection.getConnection();
    	
    	String pkg_data="select Name,Information,Incl_exclusion,Duration,Fare,H_id,min_person from fixed_package where P_id="+pkg_id;
    	Statement st1=con2.createStatement();
    	ResultSet rs1=st1.executeQuery(pkg_data);
    	PackageBean pb=new PackageBean();
    	while(rs1.next())
    	{
    		pb.setName(rs1.getString("Name"));
    		pb.setInformation(rs1.getString("Information"));
    		pb.setIncl_excl(rs1.getString("Incl_exclusion"));
    		pb.setDuration(rs1.getInt("Duration"));
    		pb.setFare(rs1.getFloat("Fare"));
    		pb.setHotelId(rs1.getInt("H_id"));
    		pb.setMinperson(rs1.getInt("min_person"));
    		pkg_list.add(pb);
    	}
    return pkg_list;
      }
    
    
    
    public boolean pkg_delete(int pkg_id) throws SQLException
    {
    	Connection con=DBConnection.getConnection();
    	String pkg="delete from fixed_package where P_id="+pkg_id;
    	Statement st=con.createStatement();
    	st.executeUpdate(pkg);
    	con.commit();
    	return true; 	
    }
    
    public List<PackageBean>  Package_Details() throws SQLException
    {
    	List<PackageBean> pb=new ArrayList<PackageBean>();
    	Connection con=DBConnection.getConnection();
    	String detail="select P_id,Name,Duration,Fare,H_id,min_person from fixed_package";
    	Statement st=con.createStatement();
    	ResultSet rs=st.executeQuery(detail);
    	PackageBean pb1=null;
    	while(rs.next())
    	{
    		pb1=new PackageBean();
    		pb1.setP_id(rs.getInt("P_id"));
    		pb1.setName(rs.getString("Name"));
    		pb1.setDuration(rs.getInt("Duration"));
    		pb1.setFare(rs.getFloat("Fare"));
    		pb1.setHotelId(rs.getInt("H_id"));
    		System.out.println(rs.getInt("min_person"));
    		pb1.setMinperson(rs.getInt("min_person"));
    		pb.add(pb1);
    		
    	}
    	
    	//System.out.println(pb1.toString());
    	return pb;
    	
    }
    
    public List<PackageDetailsBean> pkg_desc_details(int pkg_id) throws SQLException
    {
    	List<PackageDetailsBean>  pkg_desc_details=new ArrayList<PackageDetailsBean>();
    	Connection con=DBConnection.getConnection();
    	
    	
    	String pkg_details="select description from fixedpackage_details where P_id="+pkg_id+" order by day";
    	Statement st=con.createStatement();
    	ResultSet rs=st.executeQuery(pkg_details);    	
    	while(rs.next())
    	{
    		PackageDetailsBean pdb=new PackageDetailsBean();
    		//pdb.setDuration(rs.getInt("Duration"));
    		pdb.setDescription(rs.getString("description"));
    		pkg_desc_details.add(pdb);
    		
    	}
    	
    	
    	return pkg_desc_details;
    }
}
