package es.studium.practica;

public class ItemPosible {
	String nombreLibroA;
	int cantidadLibroA;
	ItemPosible(){
		
	}
	ItemPosible(String nombreLibro, int cantidad){
		nombreLibroA=nombreLibro;
		cantidadLibroA=cantidad;
	}
	public String getNombreLibroR() {
		return nombreLibroA;
	}
	public int getCantidadLibroR() {
		return cantidadLibroA;
	}
}
