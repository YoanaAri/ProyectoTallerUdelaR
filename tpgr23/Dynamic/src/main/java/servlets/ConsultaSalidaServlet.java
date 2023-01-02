package servlets;

import service.*;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ConsultaSalidaServlet
 */
@WebServlet("/ConsultaSalidaServlet")
public class ConsultaSalidaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ConsultaSalidaServlet() {
    	super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	UsuarioServiceService UsuService = new UsuarioServiceService();
		UsuarioService icu = UsuService.getUsuarioServicePort();
		
		DepartamentoServiceService DepService = new DepartamentoServiceService();
		DepartamentoService icd = DepService.getDepartamentoServicePort();
		
		DtUsuario user = (DtUsuario) request.getSession().getAttribute("usuario_logueado");
		if (user == null) {
			// no existe el usuario, se trata como deslogueado
			request.getSession().setAttribute("estado_sesion", EstadoSesion.NO_LOGIN);
		}
		request.setAttribute("usuario", user);

		DtSalida salida;
		String nombreSal = (String) request.getParameter("nombreSalida");
		if (request.getParameter("nombreSalida") != null && request.getParameter("nombreActividad") == null) {
			String nombreUsuario = request.getParameter("nombreUsuario");
			System.out.printf(nombreUsuario);
			String nombreSalida = request.getParameter("nombreSalida");
			salida = icd.getSalidaNombreService(nombreSalida); //getSalidasUsuService(nombreUsuario).get(nombreSalida);
			request.setAttribute("salida", salida);
			request.setAttribute("nombreAct", icd.getActividadXSalidaService(request.getParameter("nombreSalida")));
			String nombreDep = icd.getDepartamentoXActividadService(icd.getActividadXSalidaService(request.getParameter("nombreSalida")));
			request.setAttribute("nombreDep", nombreDep);
			request.getRequestDispatcher("/WEB-INF/jsp/salida.jsp").forward(request, response);
		}
		if (request.getParameter("dep") != null || request.getParameter("cat") != null) {
			request.getRequestDispatcher("/ConsultaActividad").forward(request, response);
		}
		if (request.getParameter("salidaDesdeActividad") != null) {
			
			
			String nombreAct = (String) request.getParameter("nombreActividad");
			String nombreDep = (String) request.getParameter("nombreDepartamento");
			salida = icd.getSalidaXActividadService(nombreSal, nombreAct, nombreDep);
			request.setAttribute("nombreAct", nombreAct);
			request.setAttribute("nombreDep", nombreDep);
			request.setAttribute("salida", salida);
			request.getRequestDispatcher("/WEB-INF/jsp/salida.jsp").forward(request, response);



		} 
		LocalDateTime hoy = LocalDateTime.now();
		request.setAttribute("hoy", hoy);
		request.setAttribute("ActOSal", "Salidas");
		request.setAttribute("departamentos", icd.getSetDepartamentosService());
		request.setAttribute("categorias", icd.getCategoriasService());					
		request.setAttribute("nombreSalida", nombreSal);
		request.getRequestDispatcher("/WEB-INF/jsp/actividades.jsp").forward(request, response);
		
	}
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
