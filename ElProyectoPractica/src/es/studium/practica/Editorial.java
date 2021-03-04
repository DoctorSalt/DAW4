package es.studium.practica;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Editorial
 */
@WebServlet("/Editorial")
public class Editorial extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Editorial() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		String usuario = request.getParameter("usuario");
		PrintWriter out = response.getWriter();
		Connection conn = null;
		Statement stmt = null;
		inicioPágina(out,usuario);			
		out.println(busquedaBaseDatos(conn,stmt));
		finPágina(out);
		out.close();
		try {
			if(stmt != null) {
				stmt.close();
			}if(conn != null){
				conn.close();
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

	private void inicioPágina(PrintWriter out, String usuario) {
		String cabeza ="<!DOCTYPE html>"+"<html lang='es'>"+
				"<head>"+
				"<meta charset='UTF-8'><meta name='viewport content='width=device-width, initial-scale=1, shrink-to-fit=no'>"
				+"<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'	integrity='sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z' crossorigin='anonymous'>"
				+"<title>Los Libros Hueones</title>"
				+"</head> <body>"+
				"<div class='container'>"
				+ "<div class='row text-right p-2 pt-3 mb-lg-2 mt-lg-2'>"
				+"<div class='col-12'>"+
				"<a href='/ElProyectoPractica/Deslogarse' class='btn btn-danger'>Deslogarse</a>"
				+"</div></div>"
				+ "</div>"+
				"<div class='container'>"
				+ "<div class='row'>"+
				"<div class='col-12 text-center'>"+
				"<h4 class='text-left'>Usuario:"+usuario+"</h4>"+
				"<h1 class='mt-3'>Editoriales</h1>"+
				"</div></div>";
		out.println(cabeza);				
	}

	private String busquedaBaseDatos(Connection conn,Statement stmt) {
		String result="";
		String userName = ConexionValores.userName;
		String password =  ConexionValores.passName;
		// URL de la base de datos
		String url =  ConexionValores.url;
		try	{
			Class.forName(ConexionValores.clasesforName);	
			conn = DriverManager.getConnection(url, userName, password);
			// Paso 3: Crear las sentencias SQL utilizando objetos de la clase Statement
			stmt = conn.createStatement();
			// Paso 4: Ejecutar las sentencias
			String sqlStr = "SELECT * FROM editoriales";
			// Generar una página HTML como resultado de la consulta
			ResultSet rs = stmt.executeQuery(sqlStr);
			System.out.println("Hizo consulta");

			int count = 0;
			result+="<div class='row'><div class='col-12'>";
			result+=tablaIniciada();		
			while(rs.next())
			{
				System.out.println("Entro en rs");
				result+="<tr>";
				result+="<td>"+rs.getString("nombreEditorial")+"</td>";
				result+="<td>"+fechaEspaniol(rs.getString("fechaEditorial"))+"</td>";
				result+="</tr>";			
				count++;			
			}
			result+=tablaFinal();
		}
		catch(Exception ex)
		{
			result+="<h3>El error ha sido</h3>";			
			ex.printStackTrace();
		}
		finally {
			result+="</div></div>"+
					"<div class='row text-center p-2 pt-3 mb-lg-2 mt-lg-2'>"+
					"<div class='col-12'>"+
					"<a href='/ElProyectoPractica/opcionesComprobantes?lugarRedireccion=general' class='btn btn-danger' >Volver</a>"
					+ "</div></div>";			
		}
		return result;

	}
	private void finPágina(PrintWriter out) {
		String fin ="</body></html>";
		out.println(fin);				
	}

	private String tablaIniciada() {
		String result="<table class='table text-center'>"+
				"<thead class='thead-dark'>"+
				"<tr>"+
				"<th scope='col'>Nombres</th>"+
				"<th scope='col'>Fecha de Creación</th>"+
				"</thead><tbody>";	
		return result;
	}
	private String tablaFinal() {
		String result="</tbody><table>";	
		return result;
	}
	private String fechaEspaniol(String fechaMandada) {
		String result="";
		String [] fechaArray=fechaMandada.split("-");
		result = fechaArray[2]+"/"+fechaArray[1]+"/"+fechaArray[0];
		return result;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
