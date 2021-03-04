package es.studium.practica;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import javax.swing.text.StyledEditorKit.BoldAction;

/**
 * Servlet implementation class LoginFuncionamiento
 */
@WebServlet("/LoginFuncionamiento")
public class LoginFuncionamiento extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataSource pool;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginFuncionamiento() {
		super();
	}
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			InitialContext ctx = new InitialContext();
			pool = (DataSource)ctx.lookup("java:comp/env/jdbc/mysql_tiendalibros");
			if(pool == null) {
				throw new ServletException("DataSource desconocida 'mysql_tiendalibros'");
			}
		}
		catch(NamingException ex){}
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String variableUsuario="";
		String variableTipoUsuario="";
		Connection conn = null;
		Statement stmt = null;
		ServletContext servletContext = getServletContext();
		RequestDispatcher requestDispatcher = null;
		String errorCodigo;
		try {			
			conn = pool.getConnection();
			stmt = conn.createStatement();
			String password = request.getParameter("passwordElegido");
			String login = request.getParameter("loginElegido");
			if(login.length()==0)
			{
				errorCodigo = "01";
				requestDispatcher = servletContext.getRequestDispatcher("/login.jsp?"+"error="+errorCodigo);
			}else if(password.length()==0){
				errorCodigo = "02";
				requestDispatcher = servletContext.getRequestDispatcher("/login.jsp?"+"error="+errorCodigo);
			}else {
				StringBuilder sqlStr = new StringBuilder();
				sqlStr.append("SELECT * FROM usuarios WHERE ");
				sqlStr.append("STRCMP(usuarios.loginUsuario,'").append(login).append("') = 0");
				sqlStr.append(" AND STRCMP(usuarios.passwordUsuario,MD5('").append(password).append("')) = 0");
				ResultSet rset = stmt.executeQuery(sqlStr.toString());
				if(!rset.next())
				{
					errorCodigo = "03";					
					requestDispatcher = servletContext.getRequestDispatcher("/login.jsp?"+"error="+errorCodigo);
				}else {					
					HttpSession session = request.getSession(false);					
					if(session != null)	{
						session.invalidate();
					}
					session = request.getSession(true);					
					String tipoUsuario = rset.getString("tipoUsuario");
					variableUsuario=login;
					variableTipoUsuario=tipoUsuario;
					System.out.println(variableTipoUsuario+" UNO");
					System.out.println("-"+variableTipoUsuario+"-");
					System.out.println("admin"+"<==>"+variableTipoUsuario+"-->"+(variableTipoUsuario.equals("admin")));
					synchronized(session){
						session.setAttribute("usuario", login);
						session.setAttribute("tipoUsuario",tipoUsuario);
					}
					if(variableTipoUsuario.equals("admin")) {
						try {
							requestDispatcher = servletContext.getRequestDispatcher("/opcionesComprobantes?"+"lugarRedireccion="+"general");
							System.out.println(variableTipoUsuario+"ENTRO");

						}catch(Exception ed) {
							ed.printStackTrace();				
						}
					}else if(variableTipoUsuario.equals("usuario")) {
						try {
							requestDispatcher = servletContext.getRequestDispatcher("/Carrito?"+"login="+variableUsuario);
						}catch(Exception ed) {
							ed.printStackTrace();				
						}
					}else {
						System.out.println(variableTipoUsuario);
					}					
				}

			}
		}catch(SQLException ex)
		{
			errorCodigo = "04";
			requestDispatcher = servletContext.getRequestDispatcher("/login.jsp?"+"error="+errorCodigo);
		}finally {
			try {
				if(stmt != null){
					stmt.close();
				}
				if(conn != null)
				{
					conn.close();
				}
			}
			catch(SQLException ex){}			
		}
		requestDispatcher.forward(request, response);	
	}	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}