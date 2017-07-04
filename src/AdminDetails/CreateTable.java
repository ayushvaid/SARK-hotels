package AdminDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateTable {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String ur1="jdbc:oracle:thin:@localhost:1521:xe";
		String user="SYSTEM";
		String pwd="vaid@0884";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(ur1, user, pwd);
		
		/*PreparedStatement psmt = con.prepareStatement("create table AdminDetail(AdminID varchar2(20),Password varchar2(20))");
		psmt.execute();
		con.prepareStatement("insert into AdminDetail values('ayushvaid','vaid@0884')").executeUpdate();*/
		
		PreparedStatement ps =con.prepareStatement("select * from AdminDetail");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString(1)+" "+rs.getString(2));
		}
	}

}
