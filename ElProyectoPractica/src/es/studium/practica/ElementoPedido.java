package es.studium.practica;


public class ElementoPedido {
	private int idLibro;
	private int cantidad;
	public ElementoPedido(int idLibro, int cantidad)
	{
		this.idLibro = idLibro;
		this.cantidad = cantidad;
	}
	public int getIdLibro()
	{
		return idLibro;
	}
	public void setIdLibro(int idLibro)
	{
		this.idLibro = idLibro;
	}
	public int getCantidad()
	{
		return cantidad;
	}
	public void setCantidad(int cantidad)
	{
		this.cantidad = cantidad;
	}
	public String getAutor()
	{
		String result="";
		for (Libro item: CarritoMVC.tabla) {
			if(item.idLibro==idLibro) {
				result=item.getNombreAutor();
			}
		}
		return result;
	}
	public String getEditorial()
	{
		String result="";
		for (Libro item: CarritoMVC.tabla) {
			if(item.idLibro==idLibro) {
				result=item.getNombreEditorial();
			}
		}
		return result;
	}
	public String getTitulo()
	{
		String result="";
		for (Libro item: CarritoMVC.tabla) {
			if(item.idLibro==idLibro) {
				result=item.getNombreLibro();
			}
		}
		return result;
	}
	public double getPrecio()
	{
		Double result=0.0;
		for (Libro item: CarritoMVC.tabla) {
			if(item.idLibro==idLibro) {
				result=item.getPrecioLibro();
			}
		}
		return result;
	}
	public int getCantidadExistente()
	{
		int result=0;
		for (Libro item: CarritoMVC.tabla) {
			if(item.idLibro==idLibro) {
				result=item.getCantidadLibro();
			}
		}
		return result;
	}
}
