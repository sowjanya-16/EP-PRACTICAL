import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FeedbackDAO {
	 public int feedbackInsert(FeedBackBean fb) throws ClassNotFoundException ,SQLException{
  	   Connection con=DBUtil.DBConnection();
  	   String sql="insert into feedback values(?,?)";
  	   PreparedStatement ps=con.prepareStatement(sql);
         ps.setString(1,fb.getName());
         ps.setString(2,fb.getMessage());
        
         int i=ps.executeUpdate();
         return i;//insert rows
     }
}
