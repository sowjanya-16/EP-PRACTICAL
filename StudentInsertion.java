package com.klu.insert;
import java.sql.PreparedStatement;
import com.klu.Bean.StudentBean;
import com.klu.Connections.DBUtil;
import java.sql.Connection;
import java.sql.SQLException;

public class StudentInsertion {
     public int StudentInsert(StudentBean student) throws ClassNotFoundException, SQLException{
    	Connection con=DBUtil.DBConnection();
    	try {
    		PreparedStatement ps=con.prepareStatement("Insert into student values(student)");
    		return 1;
    	}
    	catch(SQLException sql)
    	{
    	 return 0;
    	}
    } 
}
