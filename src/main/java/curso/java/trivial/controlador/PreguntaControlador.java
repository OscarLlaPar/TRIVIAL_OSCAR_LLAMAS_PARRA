package curso.java.trivial.controlador;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import curso.java.trivial.modelo.Pregunta;
import curso.java.trivial.modelo.PreguntaDB;

public class PreguntaControlador {
	public static int jugar() {
		PreguntaDB modelo=new PreguntaDB();
		Scanner teclado=new Scanner(System.in);
		int respuesta;
		int puntuacion=0;
		HashMap<Integer, Pregunta> preguntas=modelo.obtenerPreguntas();
		Iterator it=preguntas.keySet().iterator();
		while(it.hasNext()) {
			Integer clave=(Integer)it.next();
			Pregunta p=preguntas.get(clave);
			System.out.println(p.getTexto());
			System.out.println("1.- "+p.getRespuesta1());
			System.out.println("2.- "+p.getRespuesta2());
			System.out.println("3.- "+p.getRespuesta3());
			respuesta=teclado.nextInt();
			while(respuesta>3||respuesta<1) {
				System.out.println("Error: Respuestas del 1 al 3.");
				respuesta=teclado.nextInt();
			}
			puntuacion+=procesarRespuesta(p,respuesta);
			System.out.println("Puntuación: "+puntuacion);
		}
		return puntuacion;
	}
	
	public static int procesarRespuesta(Pregunta pregunta, int respuesta) {
		int puntuacion=0;
		if(respuesta==pregunta.getRespuestaCorrecta()) {
			System.out.println("¡Correcto! +100 puntos");
			puntuacion+=100;
		}
		else {
			System.out.println("Incorrecto. -50 puntos");
			puntuacion-=50;
		}
		return puntuacion;
	}
}
