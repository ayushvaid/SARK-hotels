package RoomDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowRows {

	public ShowRows() throws ClassNotFoundException, SQLException {
		String ur1="jdbc:oracle:thin:@localhost:1521:xe";
		String user="SYSTEM";
		String pwd="vaid@0884";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con= DriverManager.getConnection(ur1, user, pwd);
		
		PreparedStatement ps =con.prepareStatement("select * from RoomDetails where RoomAvailability =0");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			System.out.println(""+rs.getInt(1)+","+rs.getInt(2)+","+rs.getInt(3)+","+rs.getInt(4)+","+rs.getInt(5)+",");
		}
	}
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException{
		ShowRows sr=new ShowRows();
	}

}
