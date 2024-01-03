package mavengrocery;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class DAO {
		//public static void main(String [] args) throws ClassNotFoundException, SQLException {
			public static Connection createConnection() {
				Connection con=null;

				try {
	               Class.forName("com.mysql.jdbc.Driver");
	               con=DriverManager.getConnection("jdbc:mysql://localhost:3306/grocery","root","Tiger");
				}
				catch(Exception e) {
					e.printStackTrace();
					} 
				return con; 
				}
		
}
