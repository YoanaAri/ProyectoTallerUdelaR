package servlets;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.*;



/**
 * Servlet implementation class Inscripcion
 */
@WebServlet("/Inscripcion")
public class Inscripcion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscripcion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DepartamentoServiceService DepService = new DepartamentoServiceService();
		DepartamentoService ICD = DepService.getDepartamentoServicePort();
		
		HttpSession session = request.getSession();
		List<String> departamentos = ICD.getSetDepartamentosService().getLista(); //(Set<String>) session.getAttribute("departamentos");
		List<String> categorias = ICD.getCategoriasService().getLista();
		List<DataActividad> actividades = ICD.getActividadesAceptadasService().getActividades();
		LocalDateTime now = LocalDateTime.now();
		
		HashMap<String, List<DataActividad>> departamentosMap = new HashMap<String, List<DataActividad>>();
		HashMap<String, List<DataActividad>> categoriasMap = new HashMap<String, List<DataActividad>>();
		HashMap<String, List<DtSalida>> actividadesMap = new HashMap<String, List<DtSalida>>();
		
		if (departamentos != null) {
			for (String departamento : departamentos ) {
				departamentosMap.put(departamento, (List<DataActividad>) ICD.getActividadesAgregadasXDepService(departamento).getActividades());
				for (DataActividad actividad: ICD.getActividadesAgregadasXDepService(departamento).getActividades()) {
					actividadesMap.put(actividad.getName(), (List<DtSalida>) ICD.getSalidasXFechaService(departamento, actividad.getName(), now.toString()).getSalidas());//getSalidaXActividadDepto(departamento, actividad.getKey()));
				}
			}
		}
		if (categorias != null) {
			for (String categoria : categorias ) {
				categoriasMap.put(categoria, (List<DataActividad>) ICD.getActividadesXCatService(categoria).getActividades());
			}
		}
		
		request.setAttribute("departamentosMap", departamentosMap);
		request.setAttribute("categoriasMap", categoriasMap);
		request.setAttribute("actividadesMap", actividadesMap);

		if (request.getSession().getAttribute("usuario_logueado") != null) {
			
			
			request.getRequestDispatcher("/WEB-INF/jsp/inscripcion.jsp").forward(request, response);
		}else {
			//////////////////////Chequear estoooooooo/////////////////////////////////////////
			request.getRequestDispatcher("/home").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		UsuarioServiceService UsuService = new UsuarioServiceService();
		UsuarioService ICU = UsuService.getUsuarioServicePort();
		
		DepartamentoServiceService DepService = new DepartamentoServiceService();
		DepartamentoService ICD = DepService.getDepartamentoServicePort();
		
		
		
		int cant = Integer.parseInt(request.getParameter("cantidad"));
		
		LocalDateTime date = LocalDateTime.now();
		String actividad = ICD.getActividadXSalidaService((String) request.getParameter("comboSali"));
		String dpto = ICD.getDepartamentoXActividadService(actividad);
		String salidaT = (String) request.getParameter("comboSali");
		DtUsuario user = (DtUsuario) request.getSession().getAttribute("usuario_logueado");
		String turista = user.getNickname();
		DtSalida objetoSalida = ICD.getSalidaNombreService(salidaT);
		if(cant <= objetoSalida.getCuposRestantes()) {
			ICU.registrarInscripService(cant, date.toString(), dpto, actividad, salidaT, turista);
			request.getRequestDispatcher("/home").forward(request, response);
			
		} else {
			request.setAttribute("cupos", objetoSalida.getCuposRestantes());
			request.getRequestDispatcher("/cuposLlenos").forward(request, response);
		}
		
	}

}
