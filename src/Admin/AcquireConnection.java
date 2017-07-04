package Admin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AcquireConnection {

	public Connection acquireConnection() throws ClassNotFoundException, SQLException 
	{
		String ur1="jdbc:oracle:thin:@localhost:1521:xe";
		String user="SYSTEM";
		String pwd="vaid@0884";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con= DriverManager.getConnection(ur1, user, pwd);
		
		return con;
	}
}
