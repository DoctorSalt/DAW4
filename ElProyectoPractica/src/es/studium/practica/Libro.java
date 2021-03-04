package es.studium.practica;

public class Libro {
	 public String nombreLibro, fechaLibro;
	 public double precioLibro;
	 public int idLibro;
	String idEditorial;
	 public String idAutorFK;
	 static int cantidadLibro;
	 Libro()
	 {
		 super();
	 }
	 Libro(int idLibroR, String nombreLibroR, double precioLibroR, int cantidadLibroR, 
			 String fechaLibroR, String idAutorFKR, String idEditorialFKR){
		 idLibro=idLibroR;
		 nombreLibro=nombreLibroR;
		 precioLibro=precioLibroR;
		 cantidadLibro=cantidadLibroR;
		 fechaLibro=fechaLibroR;
		 idAutorFK=idAutorFKR;
		 idEditorial=idEditorialFKR;
	 }
	 Libro(int idLibroR, String nombreLibroR, double precioLibroR){
		 idLibro=idLibroR;
		 nombreLibro=nombreLibroR;
		 precioLibro=precioLibroR;		 
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
		Libro.cantidadLibro = cantidadLibro;
	}
	public String getNombreAutor() {
		return idAutorFK;
	}
	public void setIdAutorFK(String idAutorFK) {
		this.idAutorFK = idAutorFK;
	}
	public String getNombreEditorial() {
		return idEditorial;
	}
	public void setIdEditorial(String idEditorial) {
		this.idEditorial = idEditorial;
	}
	 
}
