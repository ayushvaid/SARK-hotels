package CustomerFeedback;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTable {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url1="jdbc:oracle:thin:@localhost:1521:xe";
		String user="SYSTEM";
		String pwd="vaid@0884";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url1, user, pwd);
		PreparedStatement pmst = con.prepareStatement("Create table CustomerFeedback(CustomerID varchar2(20),Rate number(1),Feedback varchar2(200))");
		pmst.execute();		
}
}