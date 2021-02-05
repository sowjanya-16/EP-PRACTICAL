package com.klu.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.klu.Bean.Bean;
import com.klu.DBUtil.DBUtil;

public class DAO {
	public int Insert(Bean supermarket) throws ClassNotFoundException, SQLException{
    	Connection con=DBUtil.DBConnection();
    		PreparedStatement ps=con.prepareStatement("Insert into supermarket values(?,?,?)");
    		ps.setInt(1, supermarket.getItemid());
    		ps.setString(2, supermarket.getItemname());
    		ps.setInt(3, supermarket.getCostofitems());
    		int i=ps.executeUpdate();
    		System.out.println(i+"records inserted");
    		return i;
     }
	public void Display(Bean supermarket) throws ClassNotFoundException, SQLException{
    	Connection con=DBUtil.DBConnection();
    	PreparedStatement ps=con.prepareStatement("Select * from supermarket");
    	ResultSet rs=ps.executeQuery();
    	while(rs.next())
    	{
    		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
    	}
	}
	public void totalSum() throws ClassNotFoundException, SQLException{
		Connection con=DBUtil.DBConnection();
    	PreparedStatement ps=con.prepareStatement("Select sum(costofitems) from supermarket");
    	ResultSet rs=ps.executeQuery();
    	while(rs.next()) {
    		System.out.println(rs.getInt(1));
    	}
	}
}
