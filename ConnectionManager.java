package ConnectionManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	Connection cn = null;
	public Connection establishConnection() throws SQLException,ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mobile","root","Surya@555");
		return cn;
	}
	
	public void closeConnection() throws SQLException
	{
		cn.close();
	}
}