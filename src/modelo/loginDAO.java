package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginDAO {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	conexion cn = new conexion();
	
	public login log (String correo,String contrase�a){
		login l = new login();
		String sql = "SELECT * FROM usuarios WHERE correo = ? AND contrase�a = ?";
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, correo);
			ps.setString(2, contrase�a);
			rs = ps.executeQuery();
			if(rs.next()){
				l.setId(rs.getInt("iduser"));
				l.setNombre(rs.getString("nombre"));
				l.setCorreo(rs.getString("correo"));
				l.setContrase�a(rs.getString("contrase�a"));
			}
		} catch (SQLException e) {
			
			System.out.println(e.toString());
			
		}
		return l;
		
	}

}


