package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ConnectionManager.ConnectionManager;
import Module.Login;

public class LoginDAO {
	public boolean checkCredential(Login l) throws ClassNotFoundException, SQLException
	{
		//1.Get the details from Login Details
		String username = l.getUsername();
		String password = l.getPassword();
		
		//2.JDBC Connection
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.establishConnection();
		
		//3.Create the Statement
		Statement st = con.createStatement();
		
		//4.Write and Execute the Query
		ResultSet rt = st.executeQuery("select * from login");
		
		//5.Check Username and Password
		while(rt.next())
		{
			if(username.equals(rt.getString("username")) && password.equals(rt.getString("password")))
			{
				cm.closeConnection();
				return true;
			}
		}
		cm.closeConnection();
		return false;
	}
}