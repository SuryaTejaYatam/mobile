package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ConnectionManager.ConnectionManager;
import Module.Product;

public class ProductDAO {
	public void addProduct(Product p) throws ClassNotFoundException, SQLException
	{
		ConnectionManager cm=new ConnectionManager();
		Connection con=cm.establishConnection();
		
		String que="insert into Product(Pro_ID,Pro_Name,Pro_Quantity,Pro_Price) values(?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(que);
		ps.setInt(1, p.getPro_ID());
		ps.setString(2, p.getPro_Name());
		ps.setInt(3, p.getPro_Quantity());
		ps.setInt(4, p.getPro_Price());
		ps.executeUpdate();
		cm.closeConnection();
	}
	
	public void display() throws ClassNotFoundException, SQLException
	{
				//1.JDBC Connection
				ConnectionManager cm = new ConnectionManager();
				Connection con = cm.establishConnection();
				
				//2.Create the Statement
				Statement st = con.createStatement();
				
				//3.Write and Execute the Query
				ResultSet rt = st.executeQuery("select * from Product");
				
				//4.Check Username and Password
				while(rt.next())
				{
					System.out.println(rt.getInt("Pro_ID")+"|"+ rt.getString("Pro_Name")+"|"+rt.getInt("Pro_Quantity")+"|"+ rt.getInt("Pro_Price"));
				}
	}
	public void updateProduct(Product p) throws SQLException, ClassNotFoundException
	{
		ConnectionManager cm=new ConnectionManager();
		Connection con=cm.establishConnection();
		
		String que="update Product set Pro_Name=?,Pro_Quantity=?,Pro_Price=? where Pro_ID=?";
		PreparedStatement ps=con.prepareStatement(que);
		ps.setString(1, p.getPro_Name());
		ps.setInt(2, p.getPro_Quantity());
		ps.setInt(3, p.getPro_Price());
		ps.setInt(4, p.getPro_ID());
		ps.executeUpdate();
		cm.closeConnection();
	}
	
	public void deleteProduct(Product p) throws ClassNotFoundException, SQLException
	{
		ConnectionManager cm=new ConnectionManager();
		Connection con=cm.establishConnection();
		
		String que="delete from Product where Pro_ID=?";
		PreparedStatement ps=con.prepareStatement(que);
		ps.setInt(1, p.getPro_ID());
		ps.executeUpdate();
		cm.closeConnection();
	}
}