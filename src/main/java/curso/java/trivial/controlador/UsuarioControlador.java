package curso.java.trivial.controlador;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

import curso.java.trivial.modelo.Usuario;
import curso.java.trivial.modelo.UsuarioDB;

public class UsuarioControlador {
	public static void insertarUsuario(int puntuacion) {
		String nombre;
		Scanner teclado=new Scanner(System.in);
		System.out.println("Introduzca tres caracteres para su nombre (Ejemplo: ABC):");
		nombre=teclado.nextLine();
		while(nombre.length()!=3) {
			System.out.println("Nombre no válido");
			System.out.println("Introduzca tres caracteres para su nombre (Ejemplo: ABC):");
			nombre=teclado.nextLine();
		}
		UsuarioDB modelo=new UsuarioDB();
		if(usuarioNoRepetido(nombre)) {
			Usuario u=new Usuario(nombre,puntuacion);
			modelo.insertarUsuario(u);
		}
		else {
			modelo.actualizarUsuario(nombre, puntuacion);
		}
		System.out.println("Usuario registrado.");
	}
	
	public static void mostrarRanking() {
		UsuarioDB modelo=new UsuarioDB();
		int posicion=1;
		LinkedHashSet<Usuario> ranking=modelo.mostrarRanking();
		Iterator<Usuario> it=ranking.iterator();
		System.out.println("----------");
		while(it.hasNext()) {
			Usuario u=it.next();
			System.out.println(posicion+".- "+u.getNombre()+": "+u.getPuntuacion()+" puntos");
			posicion++;
		}
		System.out.println("----------");
	}
	
	private static boolean usuarioNoRepetido(String nombre) {
		UsuarioDB modelo=new UsuarioDB();
		LinkedHashSet<Usuario> ranking=modelo.mostrarRanking();
		Iterator<Usuario> it=ranking.iterator();
		while(it.hasNext()) {
			Usuario u=it.next();
			if(u.getNombre().equals(nombre)) {
				return false;
			}
		}
		
		return true;
	}
	
}
