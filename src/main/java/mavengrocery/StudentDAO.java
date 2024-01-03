package mavengrocery;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO {
	
  public int saveRecord(Student stu) {
	  int z=0;
	  try {
	  Connection con=DAO.createConnection();
	  PreparedStatement ps=con.prepareStatement("insert into itemlist values(?,?)");
	  ps.setString(1,stu.getItem());
	  ps.setString(2,stu.getQuantity());
	  z=ps.executeUpdate();
	  con.close();
	  }
	  catch(Exception e) {
		  e.printStackTrace();	  }
	  return z;
  }
  

// public int editRecord(Student stu1) {
//     int z = 0;
//    try {
//          Connection con = DAO.createConnection();
//          PreparedStatement ps = con.prepareStatement("UPDATE itemlist SET item = ?, quantity = ? WHERE item = ?");
//          ps.setString(1, stu1.getItem());
//          ps.setString(2, stu1.getQuantity());
//          z = ps.executeUpdate();
//          con.close();
//      } catch (Exception e) {
//         e.printStackTrace();
//      }
//      return z;
// }

  public boolean editRecord(Student stu1) throws SQLException {
	    boolean updated = false;
	   
	    try {
	    	Connection con = DAO.createConnection();
          
	        con = DAO.createConnection();
	        PreparedStatement   ps = con.prepareStatement("UPDATE itemlist SET quantity = ? WHERE item = ?");
	        ps.setString(1, stu1.getQuantity());
	        ps.setString(2, stu1.getItem());

	        updated = ps.executeUpdate() > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	    } 

	    return updated;
	}
	

  
  public int deleteRecord(String item) {
      int z = 0;
      try {
          Connection con = DAO.createConnection();
          PreparedStatement ps = con.prepareStatement("DELETE FROM itemlist WHERE item= ?");
          ps.setString(1, item);
          z = ps.executeUpdate();
          con.close();
      } catch (Exception e) {
          e.printStackTrace();
      }
      return z;
  }
}
