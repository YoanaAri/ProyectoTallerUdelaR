package servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UsuarioService;
import service.UsuarioServiceService;

/**
 * Servlet implementation class AltaUsuarioServlet
 */
@WebServlet("/AltaUsuarioServlet")
public class AltaUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaUsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				//doGet(request, response);
				
		UsuarioServiceService UsuService = new UsuarioServiceService();
		UsuarioService ICU = UsuService.getUsuarioServicePort();
				String nombre = request.getParameter("nombre");

				if (nombre != null) {
					String apellido = request.getParameter("apellido");
					String nickname = request.getParameter("nickname");
					String correo = request.getParameter("correo");
					String password = request.getParameter("password");
					String passwordcon = request.getParameter("passwordcon");
					
					String fechaNac = LocalDate.parse(request.getParameter("fechaNac")).toString();
					System.out.printf(nickname);
	
					String user = request.getParameter("user");
					if (user.equals("turista")) {
						if (ICU.existeNicknameService(nickname)) {
							request.setAttribute("error", "errorNick");
							request.getRequestDispatcher("/WEB-INF/jsp/altaUsuario.jsp").forward(request, response);			
						}
						else if (ICU.existeMailService(correo)) {
							request.setAttribute("error", "errorCorreo");
							request.getRequestDispatcher("/WEB-INF/jsp/altaUsuario.jsp").forward(request, response);			
						}
						else {
							String nacionalidad = request.getParameter("nacionalidad");
							ICU.altaTuristaService(nickname, nombre, apellido, correo, fechaNac, nacionalidad, password);
							request.getRequestDispatcher("/home").forward(request, response);			
						}
						
					} else if (user.equals("proveedor")){
						if (ICU.existeNicknameService(nickname)) {
							request.setAttribute("error", "errorNick");
							request.getRequestDispatcher("/WEB-INF/jsp/altaUsuario.jsp").forward(request, response);			
						}
						else if (ICU.existeMailService(correo)) {
							request.setAttribute("error", "errorCorreo");
							request.getRequestDispatcher("/WEB-INF/jsp/altaUsuario.jsp").forward(request, response);			
						}
						else {
							String descripcion = request.getParameter("descripcion");
							String link = request.getParameter("link");
							ICU.altaProveedorService(nickname, nombre, apellido, correo, fechaNac, descripcion, link, password);
							request.getRequestDispatcher("/home").forward(request, response);			
						}
						
					}
					
				}
				request.getRequestDispatcher("/WEB-INF/jsp/altaUsuario.jsp").forward(request, response);					
					
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
		
	}

}
