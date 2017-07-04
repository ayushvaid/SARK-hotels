package EmployeeDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTable {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String ur1="jdbc:oracle:thin:@localhost:1521:xe";
		String user="SYSTEM";
		String pwd="vaid@0884";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con= DriverManager.getConnection(ur1, user, pwd);
		
		PreparedStatement psmt= con.prepareStatement("create table EmployeeDetails(EmployeeID varchar2(15),Name varchar2(30),Gender varchar2(1),Address varchar2(70),PinCode number(6),DOB varchar2(10),EmailID varchar2(25),Password varchar2(20),PNumber number(10),Image blob)");
		psmt.execute();

	}

}
