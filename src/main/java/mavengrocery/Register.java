package mavengrocery;


import java.sql.Connection;
import java.sql.PreparedStatement;

public class Register {

//	public int saveRecord1(Student stu) {
//		  int z=0;
//		  try {
//		  Connection con=DAO.createConnection();
//		  PreparedStatement ps=con.prepareStatement("insert into userdetails values(?,?)");
//		  ps.setString(1,stu.getName());
//		  ps.setString(2,stu.getPossword());
//		  z=ps.executeUpdate();
//		  con.close();
//		  }
//		  catch(Exception e) {
//			  e.printStackTrace();	  }
//		  return z;
//	  }
//	
	//edit records
	public int editRecord(Student stu) {
	    int z = 0;
	    try {
	        Connection con = DAO.createConnection();
	        PreparedStatement ps = con.prepareStatement("UPDATE userdetails SET item = ? WHERE quantity = ?");
	        ps.setString(1, stu.getPossword());
        ps.setString(2, stu.getName());
	        z = ps.executeUpdate();
	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return z;
	}

	

}
