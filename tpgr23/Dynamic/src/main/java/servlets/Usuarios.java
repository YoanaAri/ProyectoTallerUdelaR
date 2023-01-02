package servlets;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import service.DtInscripcion;
import service.DtSalida;
import service.DtTurista;
import service.DtUsuario;
import service.UsuarioService;
import service.UsuarioServiceService;

/**
 * Servlet implementation class Usuarios
 */
@WebServlet("/Usuarios")
public class Usuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Usuarios() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		Fabrica fabrica = Fabrica.getInstance();
//		IControladorUsuario ICU = fabrica.getIControladorUsuario();
		UsuarioServiceService UsuService = new UsuarioServiceService();
		UsuarioService ICU = UsuService.getUsuarioServicePort();
		
		HttpSession session = request.getSession();
		String user = request.getParameter("user");
		if (user != null) { // que es lo que quiero ver? lista o usuario
							// particular
			// chequear si es mi perfil o no
			//Usuario userLog = (Usuario) session.getAttribute("usuario_logueado");
			DtUsuario userLog = (DtUsuario) session.getAttribute("usuario_logueado");
			DtUsuario userConsultado = ICU.getUsuarioNickService(user);
			request.setAttribute("mi_perfil", false);
			if (userLog != null) {
				String nickname = userLog.getNickname();
				if (nickname.equals(user)) {
					request.setAttribute("mi_perfil", true);
					if (!ICU.esTurista(nickname)) {
						request.setAttribute("actividades", ICU.getAvtividadesUsuService(user)); // verificar
																							// funcion
					} else {
						DtTurista turista = ICU.getTurista(userConsultado.getNickname());						
						List<DtInscripcion> inscripciones = turista.getInscripciones();			
						request.setAttribute("inscripciones", inscripciones);
					}
				}
				else if (!ICU.esTurista(userConsultado.getNickname())) {
					request.setAttribute("actividades", ICU.getActividadesAceptadasService(user)); // getActividadesAceptadas(user));
				}
				else if (userConsultado.getClass() == DtTurista.class) {
					List<DtSalida> salidas = ICU.getSalidasUsuService(user).getSalidas();
					request.setAttribute("salidas", salidas);
				}
			} else if (!ICU.esTurista(userConsultado.getNickname())) {
				request.setAttribute("actividades", ICU.getActividadesAceptadasService(user)); // getActividadesAceptadas(user));
			}
			if (userConsultado.getClass() == DtTurista.class) {
				List<DtSalida> salidas = ICU.getSalidasUsuService(user).getSalidas();
				request.setAttribute("salidas", salidas);
			}
			request.setAttribute("usuario", ICU.getUsuarioNickService(user));
			request.getRequestDispatcher("/WEB-INF/jsp/usuario.jsp").forward(request, response);
		} else {
			List<DtUsuario> usuarios = (List<DtUsuario>) ICU.getUsuarioService().getUsuarios();
			request.setAttribute("usuarios", usuarios);
			request.getRequestDispatcher("/WEB-INF/jsp/usuarios.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
