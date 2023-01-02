package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DepartamentoService;
import service.DepartamentoServiceService;
import service.DtUsuario;
import service.UsuarioService;
import service.UsuarioServiceService;

/**
 * Servlet implementation class AltaActividad
 */
@WebServlet("/AltaActividad")
public class AltaActividad extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AltaActividad() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// TODO Auto-generated method stub
		DepartamentoServiceService DepService = new DepartamentoServiceService();
		DepartamentoService ICD = DepService.getDepartamentoServicePort();
		
		UsuarioServiceService UsuService = new UsuarioServiceService();
		UsuarioService ICU = UsuService.getUsuarioServicePort();
		// Borrar despues

		if (request.getSession().getAttribute("usuario_logueado") != null) {
			DtUsuario usr = (DtUsuario) request.getSession().getAttribute("usuario_logueado");
			if (!ICU.esTurista(usr.getNickname())) {
				List<String> setDep = ICD.getSetDepartamentosService().getLista();
				List<String> setCat = ICD.getCategoriasService().getLista();

				request.setAttribute("categorias", setCat);
				request.setAttribute("departamentos", setDep);
				request.setAttribute("proveedor", usr.getNickname());
				System.out.println("antes de entrar");
				if (!(request.getParameter("dep") != null)) {
					System.out.println("entre a ProvAltaActividad.jsp");
					request.getRequestDispatcher("/WEB-INF/jsp/ProvAltaActividad.jsp").forward(request, response);
				} else {
					String dep = request.getParameter("dep");
					String prov = request.getParameter("prov");
					String nombre = request.getParameter("nombre");
					List<String> departamentos = ICD.getSetDepartamentosService().getLista();
					Boolean existeactividad = false;
					for (String departamento : departamentos) {
						if (ICD.existeActividadEnDepartamentoService(nombre, departamento)) {
							existeactividad = true;
						}
					}
					if (!existeactividad) {
						String descripcion = request.getParameter("descripcion");
						int duracion = Integer.parseInt(request.getParameter("duracion"));
						int costo = Integer.parseInt(request.getParameter("costo"));
						String ciudad = request.getParameter("ciudad");
						String fechaAlta = LocalDate.now().toString();
						ArrayList<String> categorias = new ArrayList<String>();
						for (String nombreCat : setCat) {
							if (request.getParameter(nombreCat) != null)
								categorias.add(nombreCat);
						}
						ICD.altaActividadService(dep, prov, nombre, descripcion, duracion, costo, ciudad, fechaAlta);
						for (String categoria : categorias) {
							ICD.agregarActividadACategoriaStringService(nombre, categoria);
						}
						request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
					} else {
						System.out.println("entre al penultimo else");
						request.setAttribute("error", "ActYaExiste");
						request.getRequestDispatcher("/WEB-INF/jsp/ProvAltaActividad.jsp").forward(request, response);
					}
				}
			}
		} else {
			request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
