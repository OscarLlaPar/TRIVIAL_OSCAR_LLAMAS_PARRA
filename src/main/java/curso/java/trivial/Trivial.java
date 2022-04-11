package curso.java.trivial;

import java.util.Scanner;

import curso.java.trivial.controlador.PreguntaControlador;
import curso.java.trivial.controlador.UsuarioControlador;
import curso.java.trivial.menu.Menu;

public class Trivial {
	public static void main(String[] args) {
		String[] opciones= {
				"Jugar",
				"Ver instrucciones",
				"Ver records"
		};
		Menu menu=new Menu(opciones);
		int opcion=-1;
		Scanner teclado=new Scanner(System.in);
		
		do {
			menu.mostrarOpciones();
			opcion=teclado.nextInt();
			if(menu.manejarOpcion(opcion)) {
				switch(opcion) {
					case 1: teclado.nextLine();
							UsuarioControlador.insertarUsuario(PreguntaControlador.jugar());
						break;
					case 2: System.out.println("Trivial de definiciones y palabras");
							System.out.println("Cuando comienza el juego, se preguntará una definición y se darán tres posibles respuestas.");
							System.out.println("Cuando el jugador introduzca el número correspondiente a una de ellas, el juego dirá si ha aciertado o ha fallado.");
							System.out.println("RESPUESTA CORRECTA: +100 puntos.");
							System.out.println("RESPUESTA INCORRECTA: -50 puntos.");
						break;
					case 3: UsuarioControlador.mostrarRanking();
						break;
				}
			}
		}while(!menu.salir());
		
	}
}
