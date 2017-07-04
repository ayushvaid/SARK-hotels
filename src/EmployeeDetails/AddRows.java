package EmployeeDetails;

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
		
		PreparedStatement psmt=con.prepareStatement("insert into EmployeeDetails values('01','Ayush','M','Delhi',110084,'','vaid.ayush@gmail.com','monika',8826723274,'')");
		boolean b =psmt.execute();
		System.out.println("Inserted");
	}
	public static void main(String args[]) throws ClassNotFoundException, SQLException{
		AddRows ar=new AddRows();
	}

}
