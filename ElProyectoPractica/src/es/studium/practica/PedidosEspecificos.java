package es.studium.practica;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PedidosEspecificos
 */
@WebServlet("/PedidosEspecificos")
public class PedidosEspecificos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PedidosEspecificos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext servletContext = getServletContext();
		RequestDispatcher requestDispatcher = null;
		HttpSession session = request.getSession();
		String nombreUsuario = (String) session.getAttribute("usuario");
		String idPedidoElegido =  request.getParameter("idPedido");
		String estadoPedido = request.getParameter("estadoPedido");
		System.out.println("El pedido es "+idPedidoElegido);
		if(idPedidoElegido!=null) {		
			String rutaRedirrecion = "/PedidoEspecifico.jsp?usuario="+nombreUsuario+"&idPedido="+idPedidoElegido+"&estadoPedido="+estadoPedido;
			requestDispatcher = servletContext.getRequestDispatcher(rutaRedirrecion);
		}else {
			String rutaRedirrecion = "/Pedido.jsp?usuario="+nombreUsuario;
			requestDispatcher = servletContext.getRequestDispatcher(rutaRedirrecion);
		}
		requestDispatcher.forward(request, response);	
	}

}
