package CustomerDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowRows {

	public ShowRows() throws ClassNotFoundException, SQLException {
		String ur1="jdbc:oracle:thin:@localhost:1521:xe";
		String user="SYSTEM";
		String pwd="karan01";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con= DriverManager.getConnection(ur1, user, pwd);
		
		PreparedStatement ps =con.prepareStatement("select * from CustomerDetails");
		ResultSet rs = ps.executeQuery();
		/*while(rs.next()){
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getInt(8)+" "+rs.getString(9)+" "+rs.getString(10)+" "+rs.getString(11)+" "+rs.getString(12)+" "+rs.getString(13));
		}*/
	}
	
	/*public static void main(String args[]) throws ClassNotFoundException, SQLException{
		ShowRows sr=new ShowRows();
	}*/

}