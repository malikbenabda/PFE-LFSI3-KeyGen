package persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class AccesBD {

	
	String url = "jdbc:sqlite:generateur.sqlite"; 
    //url change en fnction d nom de bd : dans ce cas generateur.sqlite
    String  driver="org.sqlite.JDBC";		
	Connection con ;Statement stmt ;
	public void MAJ(String maRequeteSql)
	  {
		try
			{
			Class.forName(driver).newInstance();
			con = DriverManager.getConnection(url);
			stmt = con.createStatement();
			stmt.executeUpdate(maRequeteSql);
			System.out.println("connexion etablie");
		
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, ex);}

}
	
	public ResultSet getStatment(String maRequeteSql)
	  {

		    ResultSet monResultSet=null; 

			try
			{
			Class.forName(driver).newInstance();
			con = DriverManager.getConnection(url);
			stmt = con.createStatement();
			monResultSet = stmt.executeQuery(maRequeteSql);
			System.out.println("connexion getstatement etablie");
			
			}
			catch(Exception ex)
			{
				System.out.println("erreur ");
				
			}
			return monResultSet;

}

	
	 public void disconnect(){
		 try {
			 stmt.close();
			 con.close();
		 } catch(Exception e){
			 System.out.println(e);
		 }
	 }
	
}
