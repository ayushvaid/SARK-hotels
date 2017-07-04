package RoomDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateTable {
	public static void main(String ar[]) throws ClassNotFoundException, SQLException{
	String ur1="jdbc:oracle:thin:@localhost:1521:xe";
	String user="SYSTEM";
	String pwd="vaid@0884";
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con= DriverManager.getConnection(ur1, user, pwd);
	
	PreparedStatement psmt= con.prepareStatement("create table RoomDetails(RoomNumber number(3), RoomType number(1),Cost number(5), RoomAvailability number(1), RoomReserved number(1))");
	psmt.execute();
	
	}
}
