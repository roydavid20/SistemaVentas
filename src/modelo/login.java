package modelo;

public class login {
	
	private int id;
	private String nombre;
	private String correo;
	private String contrase�a;
	
	
	public login(int id, String nombre, String correo, String contrase�a) {
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.contrase�a = contrase�a;
	}


	public login() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getContrase�a() {
		return contrase�a;
	}


	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	
	

}
