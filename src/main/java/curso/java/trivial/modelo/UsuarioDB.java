package curso.java.trivial.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;

public class UsuarioDB {
	private static Connection conexion=Conexion.getConexion();
	private static Statement statement;
	
	public UsuarioDB() {
		Conexion.conectar();
	}
	
	public LinkedHashSet<Usuario> mostrarRanking(){
		try {
			Statement statement=conexion.createStatement();
			
			if(conexion!=null) {
				PreparedStatement ps = conexion.prepareStatement("SELECT * FROM usuario ORDER BY puntuacion DESC");
				
				LinkedHashSet<Usuario> ranking = new LinkedHashSet<Usuario>();
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					Usuario u=new Usuario(rs.getString(1),rs.getInt(2));
					ranking.add(u);
				}
				return ranking;
			}
			return null;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public void insertarUsuario(Usuario u) {
		try {
			Statement statement=conexion.createStatement();
			
			if(conexion!=null) {
				PreparedStatement ps = conexion.prepareStatement("INSERT INTO usuario VALUES(?,?)");
				
				ps.setString(1, u.getNombre());
				ps.setInt(2, u.getPuntuacion());
				
				ps.execute();
				
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void actualizarUsuario(String nombre, int puntuacion) {
		try {
			Statement statement=conexion.createStatement();
			
			if(conexion!=null) {
				PreparedStatement ps = conexion.prepareStatement("UPDATE usuario SET puntuacion=? WHERE nombre=?");
				
				ps.setInt(1, puntuacion);
				ps.setString(2, nombre);
				
				ps.execute();
				
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
