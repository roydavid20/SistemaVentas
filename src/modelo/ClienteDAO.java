package modelo;

import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ClienteDAO {
	
	conexion cn = new conexion();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	
	public boolean RegistrarCliente(Cliente cl){

		String sql = "INSERT INTO clientes(dni, nombre, telefono, dirreccion, razon) VALUES(?,?,?,?,?)";
		
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, cl.getDni());
			ps.setString(2, cl.getNombre());
			ps.setInt(3, cl.getTelefono());
			ps.setString(4, cl.getDireccion());
			ps.setString(5, cl.getRazon());
			ps.setInt(6, cl.getId());
			ps.execute();
		    return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString());
			return false;
		}finally {
		 try {
			con.close();
		} catch (SQLException e2) {
			System.out.println(e2.toString());
		}
		}
				
		
	}

	
	public List ListarCliente(){

		List<Cliente> ListaCL = new ArrayList();
		String sql = "SELECT * FROM clientes";
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
	        rs = ps.executeQuery();
	        while (rs.next()) {
				Cliente cl = new Cliente();
                cl .setId(rs.getInt("idcliente"));
                cl.setDni(rs.getInt("dni"));
                cl.setNombre(rs.getString("nombre"));
                cl.setTelefono(rs.getInt("telefono"));
                cl.setDireccion(rs.getString("dirreccion"));
                cl.setRazon(rs.getString("razon"));
                ListaCL.add(cl);
				
			}
	        
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return ListaCL;
		
	}
	
	public boolean EliminarCliente(int id){
		String sql = "DELETE FROM clientes WHERE idcliente = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			return true;
		} catch (SQLException e) {
			System.out.println(e.toString());
			return false;
		}finally{
			try {
				con.close();
			} catch (SQLException e2) {
				System.out.println(e2.toString());
			}
		}
			
	}
	
	public boolean ModificarCliente(Cliente cl){
		String sql = "UPDATE clientes SET dni=?,nombre=?,telefono=?,dirreccion=?,razon=? WHERE idcliente=?";
		try {
			ps = con.prepareCall(sql);
			ps.setInt(1, cl.getDni());
			ps.setString(2, cl.getNombre());
			ps.setInt(3, cl.getTelefono());
			ps.setString(4, cl.getDireccion());
			ps.setString(5, cl.getRazon());
			ps.setInt(6,cl.getId());
			ps.execute();
			return true;
		} catch (SQLException e) {
			System.out.println(e.toString());
			return false;
		}finally{
			try {
				con.close();
			} catch (SQLException e2) {
				System.out.println(e2.toString());
			}
		}
	}
}

