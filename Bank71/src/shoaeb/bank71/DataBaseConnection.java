package shoaeb.bank71;
import java.sql.*;

import javax.swing.*;
public class DataBaseConnection {

	
	
	
	Connection connection=null;
	public static Connection dbConnector(){
		try {
			Class.forName("org.sqlite.JDBC");//find the class to connect with the  sqlite database
			Connection connection=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Public\\Bank71.sqlite");
			
			return connection;
			
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Failed to connect to the database");
			return null;
		}
	}
	
	
	
}
