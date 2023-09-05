package Controller;

import java.sql.SQLException;
import java.util.Scanner;

import Module.Login;
import Module.Product;
import dao.LoginDAO;
import dao.ProductDAO;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		Scanner sc = new Scanner(System.in);
		int choice,option;
		Login l=new Login();
		LoginDAO ldao=new LoginDAO();
		Product p=new Product();
		ProductDAO pdao=new ProductDAO();
		do
		{
			System.out.println("1. Admin");
			System.out.println("2. Agent");
			System.out.println("5. Exit");

			System.out.println("****************************************************");
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			switch(choice)
			{
				case 1:
					System.out.println("Admin Login");
					System.out.println("Enter your username");
					String username = sc.next();
					System.out.println("Enter your password");
					String password = sc.next();
					l.setUsername(username);
					l.setPassword(password);
					if(ldao.checkCredential(l))
					{
						System.out.println("Login Successful!");
						do
						{
							System.out.println("****************************************************");
							System.out.println("1. Add Product");
							System.out.println("2. Display Product");
							System.out.println("3. Update Product");
							System.out.println("4. Delete Product");
							System.out.println("5. Logout");
							System.out.println("****************************************************");
							System.out.println("Enter your option");
							option = sc.nextInt();
							switch(option)
							{
								case 1:
									System.out.println("Add Product");
									System.out.println("Enter the Product ID");
									int Pro_ID = sc.nextInt();
									sc.nextLine();
									System.out.println("Enter the Product Name");
									String Pro_Name = sc.nextLine();
									System.out.println("Enter the Product Quantity");
									int Pro_Quantity = sc.nextInt();
									System.out.println("Enter the Price");
									int Pro_Price = sc.nextInt();
									p.setPro_ID(Pro_ID);
									p.setPro_Name(Pro_Name);
									p.setPro_Quantity(Pro_Quantity);
									p.setPro_Price(Pro_Price);
									pdao.addProduct(p);
									
									break;
								case 2:
									System.out.println("Display Product");
									pdao.display();
									break;
								case 3:
									System.out.println("Update Product");
									sc.nextLine();
									System.out.println("Enter the Product Name");
									String Pro_Name1 = sc.nextLine();
									System.out.println("Enter the Product Quantity");
									int Pro_Quantity1 = sc.nextInt();
									System.out.println("Enter the Price");
									int Pro_Price1 = sc.nextInt();
									System.out.println("Enter the Product ID");
									int Pro_ID1 = sc.nextInt();
									
									
									p.setPro_Name(Pro_Name1);
									p.setPro_Quantity(Pro_Quantity1);
									p.setPro_Price(Pro_Price1);
									p.setPro_ID(Pro_ID1);
									pdao.updateProduct(p);
									break;
								case 4:
									System.out.println("Delete Product");
									System.out.println("Enter the product id to delete");
									int id = sc.nextInt();
									p.setPro_ID(id);
									pdao.deleteProduct(p);
									break;
								case 5:
									System.out.println("Logout");
									break;
							}
						
						}while(option!=5);
					}
					else
					{
						System.out.println("Incorrect Username/Password");
					}
					break;
				case 2: 
					System.out.println("Agent Login");
					sc.nextLine();
					System.out.println("Enter your username");
					String username1 = sc.nextLine();
					System.out.println("Enter your password");
					String password1 = sc.nextLine();
					l.setUsername(username1);
					l.setPassword(password1);
					if(ldao.checkCredential(l))
					{
						System.out.println("Login Successful!");
						do
						{
							System.out.println("****************************************************");
							System.out.println("1. Display Product");
							System.out.println("2. Logout");
							System.out.println("****************************************************");
							System.out.println("Enter your option");
							option = sc.nextInt();
							switch(option)
							{
								case 1:
									System.out.println("Display Product");
									pdao.display();
									break;
								case 2:
									System.out.println("Logout");
									break;
							}
						
						}while(option!=2);
					}	
					else
					{
						System.out.println("Incorrect Username/Password");
					}
					break;
				case 3: 
					System.out.println("Exit");
					break;
				}
			}while(choice!=3);
			sc.close();
		}

}