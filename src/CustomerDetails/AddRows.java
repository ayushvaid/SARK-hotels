package CustomerDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddRows {

	public AddRows() throws ClassNotFoundException, SQLException {
		String ur1="jdbc:oracle:thin:@localhost:1521:xe";
		String user="SYSTEM";
		String pwd="vaid@0884";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con= DriverManager.getConnection(ur1, user, pwd);
		
		PreparedStatement psmt=con.prepareStatement("insert into CustomerDetails values('shreya1','Shreya','Khanna','F','Sector-18','Rohini','Delhi',110085,'','shreya.khana123@gmail.com','udit','Boyfriend name?','Punjabi',9818578706,'')");
		boolean b =psmt.execute();
		System.out.println("inserted");
	}
	/*public static void main(String args[]) throws ClassNotFoundException, SQLException{
		AddRows ar=new AddRows();
	}*/

}
