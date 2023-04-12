package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	conexion cn = new conexion();

	public boolean RegistrarProveedor(Proveedor pr){
		String sql = "INSERT INTO proveedores(ruc , nombre, telefono , dirreccion ,razon ) VALUES (?,?,?,?,?)";
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, pr.getRuc());
			ps.setString(2, pr.getNombre());
			ps.setInt(3, pr.getTelefono());
			ps.setString(4, pr.getDireccion());
			ps.setString(5, pr.getRazon());
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
	
	public List ListarProveedor(){

		List<Proveedor> Listpr = new ArrayList();
		String sql = "SELECT * FROM proveedores";
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Proveedor pr = new Proveedor();
				pr.setId(rs.getInt("idprove"));
				pr.setRuc(rs.getInt("ruc"));
				pr.setNombre(rs.getString("nombre"));
				pr.setTelefono(rs.getInt("telefono"));
				pr.setDireccion(rs.getString("dirreccion"));
				pr.setRazon(rs.getString("razon"));
				Listpr.add(pr);
				
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return Listpr;
	}
	
	public boolean EliminarProveedor( int id ){
		String sql = "DELETE FROM proveedores WHERE idprove=?";
		try {
			con =cn.getConnection();
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
	
	public boolean ModificarProveedor(Proveedor pr){
		String sql = "UPDATE proveedores SET ruc =?, nombre =?, telefono =?, dirreccion =?, razon =? WHERE idprove =?";
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, pr.getRuc());
			ps.setString(2, pr.getNombre());
			ps.setInt(3, pr.getTelefono());
			ps.setString(4, pr.getDireccion());
			ps.setInt(5, pr.getId());
			ps.setString(6, pr.getRazon());
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
