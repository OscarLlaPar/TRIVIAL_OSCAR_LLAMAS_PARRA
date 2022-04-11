package curso.java.trivial.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;



public class PreguntaDB {
	private static Connection conexion=Conexion.getConexion();
	private static Statement statement;
	
	public PreguntaDB() {
		Conexion.conectar();
	}
	
	public HashMap<Integer,Pregunta> obtenerPreguntas(){
		try {
			Statement statement=conexion.createStatement();
			
			if(conexion!=null) {
				PreparedStatement ps = conexion.prepareStatement("SELECT * FROM pregunta");
				
				HashMap<Integer,Pregunta> preguntas = new HashMap<Integer,Pregunta>();
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					Pregunta p=new Pregunta(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
					preguntas.put(rs.getInt(1), p);
				}
				return preguntas;
			}
			return null;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
}


