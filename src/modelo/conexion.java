package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
	
	Connection con;
	
	public Connection getConnection (){
		try {
			String myBD = "jdbc:mysql://localhost:3306/minimarket?serverTimezone=UTC";
			con = DriverManager.getConnection(myBD,"root","123456");
			return con;
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return null;
	}
	

}
