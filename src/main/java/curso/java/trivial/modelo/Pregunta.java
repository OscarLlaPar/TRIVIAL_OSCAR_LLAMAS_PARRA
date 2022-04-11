package curso.java.trivial.modelo;

public class Pregunta {
	private String texto;
	private String respuesta1;
	private String respuesta2;
	private String respuesta3;
	private int respuestaCorrecta;
	
	public Pregunta(String texto, String respuesta1, String respuesta2, String respuesta3, int respuestaCorrecta) {
		super();
		this.texto = texto;
		this.respuesta1 = respuesta1;
		this.respuesta2 = respuesta2;
		this.respuesta3 = respuesta3;
		this.respuestaCorrecta = respuestaCorrecta;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getRespuesta1() {
		return respuesta1;
	}

	public void setRespuesta1(String respuesta1) {
		this.respuesta1 = respuesta1;
	}

	public String getRespuesta2() {
		return respuesta2;
	}

	public void setRespuesta2(String respuesta2) {
		this.respuesta2 = respuesta2;
	}

	public String getRespuesta3() {
		return respuesta3;
	}

	public void setRespuesta3(String respuesta3) {
		this.respuesta3 = respuesta3;
	}

	public int getRespuestaCorrecta() {
		return respuestaCorrecta;
	}

	public void setRespuestaCorrecta(int respuestaCorrecta) {
		this.respuestaCorrecta = respuestaCorrecta;
	}

	@Override
	public String toString() {
		return "Pregunta [texto=" + texto + ", respuesta1=" + respuesta1 + ", respuesta2=" + respuesta2
				+ ", respuesta3=" + respuesta3 + ", respuestaCorrecta=" + respuestaCorrecta + "]";
	}
	
	
}
