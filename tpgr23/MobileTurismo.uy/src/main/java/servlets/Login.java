package servlets;

import java.io.IOException;
import service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class IniciarCerrarSesion
 */
@WebServlet("/IniciarSesion")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp/iniciarSesion.jsp").
		forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession objSesion = request.getSession();
		String login = (String) request.getParameter("usuario");
		String password = request.getParameter("password");
		EstadoSesion nuevoEstado;
		
		UsuarioServiceService UsuService = new UsuarioServiceService();
		UsuarioService ICU = UsuService.getUsuarioServicePort();
		System.out.println(login);

		if (login != null) { //si alguien quizo loguearse chequea contrasena
			if (ICU.existeNicknameService(login) || ICU.existeMailService(login)) {
				DtUsuario usr = ICU.getUsuarioNickService(login);
				if (usr != null && usr.getClass() == DtTurista.class) {
					if (!usr.getContrasena().equals(password)) {
						nuevoEstado = EstadoSesion.LOGIN_INCORRECTO;
					} else {
						nuevoEstado = EstadoSesion.LOGIN_CORRECTO;
						// setea el usuario logueado
						request.getSession().setAttribute("usuario_logueado", usr);
					}
				}else {
					nuevoEstado = EstadoSesion.LOGIN_INCORRECTO;
				}
				} else {
					nuevoEstado = EstadoSesion.LOGIN_INCORRECTO;
				}
			} 
		else {
			nuevoEstado = EstadoSesion.NO_LOGIN;
		}
		objSesion.setAttribute("estado_sesion", nuevoEstado);
		
		// redirige a la página principal para que luego redirija a la página
		// que corresponde
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/home");
		dispatcher.forward(request, response);
		
	}

}
