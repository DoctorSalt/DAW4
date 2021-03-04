package es.studium.practica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CarritoMVC {
	static ArrayList<Libro> tabla = new ArrayList<Libro>();
	public static void cargarDatos() {
		// TODO Auto-generated method stub
		// Creamos objetos para la conexión
		if(tabla.size()>0) {
			tabla.clear();
		}
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(ConexionValores.clasesforName);
			String userName = ConexionValores.userName;
			String password = ConexionValores.passName;
			// URL de la base de datos
			String url =ConexionValores.url;
			conn = DriverManager.getConnection(url, userName, password);
			// Paso 3: Crear las sentencias SQL utilizando objetos de la clase Statement
			stmt = conn.createStatement();
			// Paso 4: Ejecutar las sentencias
			String sqlStr = "SELECT idLibro, nombreLibro, precioLibro, cantidadLibro, fechaLibro, nombreAutor, nombreEditorial FROM "
					+ "tiendalibros.libros, tiendalibros.autores, tiendalibros.editoriales where idAutor=idAutorFK AND idEditorial=idEditorialFK;";
			ResultSet rs = stmt.executeQuery(sqlStr);
			Libro libro;
			while(rs.next())
			{
				libro = new Libro(rs.getInt("idLibro"), rs.getString("nombreLibro"), 
						rs.getDouble("precioLibro"),rs.getInt("cantidadLibro"),rs.getString("fechaLibro"),
						rs.getString("nombreAutor"),rs.getString("nombreEditorial"));
				tabla.add(libro);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				// Cerramos el resto de recursos
				if(stmt != null)
				{
					stmt.close();
				}
				if(conn != null)
				{
					conn.close();
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}

	public static int tamano()
	{
		return tabla.size();
	}
	/**
	 * Devuelve el título del libro identificado con idLibro
	 */
	public static String getTitulo(int idLibro)
	{
		return tabla.get(idLibro).getNombreLibro();
	}
	/**
	 * Devuelve el autor del libro identificado con idLibro
	 */
	public static String getAutor(int idLibro)
	{
		return tabla.get(idLibro).getNombreAutor();
	}
	public static String getEditorial(int idLibro)
	{
		return tabla.get(idLibro).getNombreEditorial();
	}
	/**
	 * Devuelve el precio del libro identificado con idLibro
	 */
	public static double getPrecio(int idLibro)
	{
		return tabla.get(idLibro).getPrecioLibro();
	}
	public static int getCantidadExistente(int idLibro)
	{
		return tabla.get(idLibro).getCantidadLibro();
	}
	public static int getIdLibro(int idLibro)
	{
		return tabla.get(idLibro).getIdLibro();
	}
	
}
