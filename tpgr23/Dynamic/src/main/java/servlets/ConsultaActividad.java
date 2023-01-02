package servlets;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.DataActividad;
import service.DataMapActividad;
import service.DataMapSalida;
import service.DepartamentoService;
import service.DepartamentoServiceService;
import service.DtProveedor;
import service.DtUsuario;
import service.UsuarioService;
import service.UsuarioServiceService;

/**
 * Servlet implementation class ConsultaActividad
 */
@WebServlet("/ConsultaActividad")
public class ConsultaActividad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaActividad() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public static EstadoSesion getEstado(HttpServletRequest request) {
   		return (EstadoSesion) request.getSession().getAttribute("estado_sesion");
   	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		UsuarioServiceService UsuService = new UsuarioServiceService();
		UsuarioService ICU = UsuService.getUsuarioServicePort();
		DepartamentoServiceService DepService = new DepartamentoServiceService();
		DepartamentoService ICD = DepService.getDepartamentoServicePort();
		
		Set<DataActividad> actividades = new HashSet<DataActividad>();
		
		if (request.getParameter("finalizarActividad") != null ) {
			
			String actividad = (String) request.getParameter("finalizarActividad");
			ICD.finalizarActividadService(actividad);
			request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
			
		}
		
		//Si tiene parametro name (nombre de actividad), muestra la actividad en detalle
		if (request.getParameter("name") != null) {
				String actividad = request.getParameter("name");
				String dep = ICD.getDepartamentoXActividadService(actividad);
				
				DataMapActividad buscarActi = ICD.getActividadesXDepService(dep);
				List<DataActividad> actividades1 = buscarActi.getActividades();
				DataActividad consulActi = null;
				for(DataActividad acti1 : actividades1) {
					if(acti1.getName().equals(actividad)) {
						consulActi = acti1;
					}
				}
				//DataActividad consulActi = buscarActi.get(request.getParameter("name"));
				
				DataMapSalida salidasActi = ICD.getSalidaXActividadDeptoService(dep, request.getParameter("name"));
				request.setAttribute("actividad", consulActi);
				request.setAttribute("salidas", salidasActi);
				request.setAttribute("departamento", dep);
				
				DataMapActividad dataMapActi = ICD.getActividadesAceptadasSinSalidaService();
				boolean bandera = false;
				for(DataActividad dataActi : dataMapActi.getActividades()) {
					if(dataActi.getName().equals(actividad)) {
						bandera = true;
					}
				}
				
				request.setAttribute("finalizable", false);
				HttpSession session = request.getSession();
				DtUsuario usu = (DtUsuario) session.getAttribute("usuario_logueado");
				if(usu != null) {

					if ( bandera && (usu.getClass() == DtProveedor.class)) {
						
						request.setAttribute("finalizable", true);
						//DataMapActividad activi =  ICU.getAvtividadesUsuService(usu.getName());
						request.setAttribute("ListaActividadesF", ICU.getAvtividadesUsuService(usu.getNickname()).getActividades());
					}				
				}
				
				
				request.getRequestDispatcher("/WEB-INF/jsp/actividad.jsp").forward(request, response);
		}
		
		//Si tiene parametro dep, lista todas las actividades del departamento
		Set<String> departamentos;		
		if (request.getParameter("dep") != null) {
			departamentos = new HashSet<String>();
			departamentos.add(request.getParameter("dep"));
			for (String departamento: departamentos) {
				DataMapActividad actividadesDep = ICD.getActividadesXDepService(departamento);
				for (DataActividad actividad: actividadesDep.getActividades()) {
					if(actividad.getEstado() == service.EstadoActividad.ACEPTADA) {
						actividades.add(actividad);
					}					
					/*
					 * if (ICD.getActividadesAceptadasService().get(actividad.getName()) != null) {
					 * actividades.add(actividad); }
					 */
				}
			}
		}
		
		//Si tiene parametro cat, lista todas las actividades de la categoria
		if (request.getParameter("cat") != null) {
			Set<DataActividad> actividadesNombre = new HashSet<DataActividad>();
			DataMapActividad actividadesCat = ICD.getActividadesXCatService(request.getParameter("cat"));
			
			
			for (DataActividad actividad: actividadesCat.getActividades()) {
				if(actividad.getEstado() == service.EstadoActividad.ACEPTADA) {
					actividadesNombre.add(actividad);
					actividades.add(actividad);
				}
				
				/*
				 * if (ICD.getActividadesAceptadasService().get(actividad.getName()) != null) {
				 * actividadesNombre.add(actividad); actividades.add(actividad); }
				 */
			}
		}
		request.setAttribute("ActOSal", "Actividades");
		request.setAttribute("departamentos", ICD.getSetDepartamentosService());
		request.setAttribute("categorias", ICD.getCategoriasService());
		request.setAttribute("actividades", actividades);
		request.getRequestDispatcher("/WEB-INF/jsp/actividades.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
