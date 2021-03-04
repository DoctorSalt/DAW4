package es.studium.practica;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ConfirmarPedido
 */
@WebServlet("/ConfirmarPedido")
public class ConfirmarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConfirmarPedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idPedido = request.getParameter("idPedido");
		HttpSession session = request.getSession(true);
		String usuario = (String) session.getAttribute("usuario");
		Connection conn = null;
		Statement stmt = null;
		Boolean fallo=false;

		try {
			Class.forName(ConexionValores.clasesforName);
			String userName = ConexionValores.userName;
			String password =  ConexionValores.passName;
			// URL de la base de datos
			String url = ConexionValores.url;
			conn = DriverManager.getConnection(url, userName, password);
			// Paso 3: Crear las sentencias SQL utilizando objetos de la clase Statement
			stmt = conn.createStatement();
			// Paso 4: Ejecutar las sentencias
			String sqlStr = "Update tiendalibros.pedidos set enviadoPedido = 1 where idPedido="+idPedido+";";
			System.out.println(sqlStr);
			int rs = stmt.executeUpdate(sqlStr);
			if(rs==0) {
				fallo=true;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			fallo=true;
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fallo=true;
			e.printStackTrace();
		}
		finally {
			String ruta="/Pedido.jsp";
			String resultado ="";
			if(fallo==true) {
				request.setAttribute("Mensaje", "Fallo");
				resultado= "Fallo";
			}else{
				request.setAttribute("Mensaje", "Exito");
				resultado= "Exito";
			}
			request.setAttribute("usuario", usuario);			
			ServletContext servletContext = getServletContext();
			RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(ruta+"?usuario="+usuario+"&mensaje="+resultado);
			requestDispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
