package curso.java.trivial.menu;

public class Menu {
	private int indice=0;
	private String[] opciones;
	
	public Menu(String[] opciones) {
		this.opciones=opciones;
	}
	
	public void mostrarOpciones() {
		for(int i=1;i<=this.opciones.length;i++) {
			System.out.println(i+".- "+opciones[i-1]);
		}
                System.out.println("0.- Salir");
		System.out.println("Introduzca opción:");
	}
	
	public boolean manejarOpcion(int opcion) {
		boolean valido=true;
		this.indice=opcion;
		if(this.indice<=0 && this.indice>this.opciones.length) {
			valido=false;
		}
		return valido;
	}
	
	public boolean salir() {
		boolean salida =false;
                if (this.indice==0){
                    salida=true;
                }
                return salida;
	}
	
	public int getIndice() {
		return this.indice;
	}
	
	public void setIndice(int indice) {
		this.indice=indice;
	}
}
