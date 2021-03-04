package es.studium.practica;

public class LibroElegido {
	
	 public String nombreLibro, fechaLibro;
	 public double precioLibro;
	 public int idLibro, cantidadLibro, idAutorFK, idEditorial;
	 LibroElegido()
	 {
		 super();
	 }
	 public LibroElegido(int idLibroR, String nombreLibroR, double precioLibroR, int cantidadLibroR, 
			 String fechaLibroR, int idAutorFKR, int idEditorialFKR){
		 idLibro=idLibroR;
		 nombreLibro=nombreLibroR;
		 precioLibro=precioLibroR;
		 cantidadLibro=cantidadLibroR;
		 fechaLibro=fechaLibroR;
		 idAutorFK=idAutorFKR;
		 idEditorial=idEditorialFKR;
	 }
	public String getNombreLibro() {
		return nombreLibro;
	}
	public void setNombreLibro(String nombreLibro) {
		this.nombreLibro = nombreLibro;
	}
	public String getFechaLibro() {
		return fechaLibro;
	}
	public void setFechaLibro(String fechaLibro) {
		this.fechaLibro = fechaLibro;
	}
	public double getPrecioLibro() {
		return precioLibro;
	}
	public void setPrecioLibro(double precioLibro) {
		this.precioLibro = precioLibro;
	}
	public int getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
	public int getCantidadLibro() {
		return cantidadLibro;
	}
	public void setCantidadLibro(int cantidadLibro) {
		this.cantidadLibro = cantidadLibro;
	}
	public int getIdAutorFK() {
		return idAutorFK;
	}
	public void setIdAutorFK(int idAutorFK) {
		this.idAutorFK = idAutorFK;
	}
	public int getIdEditorial() {
		return idEditorial;
	}
	public void setIdEditorial(int idEditorial) {
		this.idEditorial = idEditorial;
	}
	 
}
