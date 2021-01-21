package com.klu.insert;
import java.sql.PreparedStatement;
import com.klu.Bean.StudentBean;
import com.klu.Connections.DBUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
public class StudentInsertion {
     public int StudentInsert(StudentBean student) throws ClassNotFoundException, SQLException{
    	Connection con=DBUtil.DBConnection();
    		PreparedStatement ps=con.prepareStatement("Insert into student values(?,?,?)");
    		ps.setInt(1, student.getRegno());
    		ps.setString(2, student.getName());
    		ps.setString(3, student.getEmail());
    		int i=ps.executeUpdate();
    		System.out.println(i+"records inserted");
    		return i;
     }
    	
    	public void StudentDisplay(StudentBean student) throws ClassNotFoundException, SQLException{
        	Connection con=DBUtil.DBConnection();
        	PreparedStatement ps=con.prepareStatement("Select * from StudentBean");
        	ResultSet rs=ps.executeQuery();
        	while(rs.next())
        	{
        		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
        	}
    }
}
