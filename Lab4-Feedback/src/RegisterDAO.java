
	import java.sql.Connection;
	import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
	public class RegisterDAO {
	           public int registerInsert(RegisterBean rb) throws ClassNotFoundException ,SQLException{
	        	   Connection con=DBUtil.DBConnection();
	        	   String sql="insert into registerdetails values(?,?,?,?,?,?)";
	        	   PreparedStatement ps=con.prepareStatement(sql);
	               ps.setInt(1, rb.getRegno());
	               ps.setString(2, rb.getName());
	               ps.setString(3, rb.getEmail());
	               ps.setLong(4, rb.getMobile());
	               ps.setString(5, rb.getUsername());
	               ps.setString(6, rb.getPassword());
	               int i=ps.executeUpdate();
	               return i;//insert rows
	           }
	           public boolean loginUser(String username,String password) throws ClassNotFoundException ,SQLException{
	        	   Connection con=DBUtil.DBConnection();
	        	   String sql="select * from registerdetails where username=? and password=?";
	        	   PreparedStatement ps=con.prepareStatement(sql);
	        	   ps.setString(1,username);
	               ps.setString(2,password);
	               ResultSet rs=ps.executeQuery();
	               boolean res=rs.next();
	               return res;
	           }
	           
	}


