package servlets;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import service.DataActividad;
import service.DataMapActividad;
import service.DepartamentoService;
import service.DepartamentoServiceService;
import service.DtUsuario;
import service.EstadoActividad;
import service.UsuarioService;
import service.UsuarioServiceService;

/**
 * Servlet implementation class AltaSalida
 */
@WebServlet("/AltaSalida")
public class AltaSalida extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AltaSalida() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DepartamentoServiceService DepService = new DepartamentoServiceService();
		DepartamentoService ICD = DepService.getDepartamentoServicePort();
		
		UsuarioServiceService UsuService = new UsuarioServiceService();
		UsuarioService ICU = UsuService.getUsuarioServicePort();
		
		if (request.getSession().getAttribute("usuario_logueado") != null) {
			DtUsuario usr = (DtUsuario) request.getSession().getAttribute("usuario_logueado");
			if (!ICU.esTurista(usr.getNickname())) {
				List<String> setDep = ICD.getSetDepartamentosService().getLista();
				String departamento = "";
				String act = "";
				request.setAttribute("departamentos", setDep);
				
				// Si se tiene departamento pero no actividad, se envia al formulario de Alta Salida
				if (request.getParameter("dep") != null && request.getParameter("act") == null) {
					DataMapActividad mapAct = ICD.getActividadesXDepService(request.getParameter("dep"));
					List<String> setAct = new ArrayList<String>();
					for (DataActividad actividad: mapAct.getActividades()) {
						if(actividad.getEstado() == EstadoActividad.ACEPTADA) {
							setAct.add(actividad.getName());
						}
						
						/*
						 * if (ICD.getActividadesAceptadasService().get(actividad.getName()) != null) {
						 * setAct.add(actividad.getName()); }
						 */
					}
					System.out.println(setAct);
					request.setAttribute("actividades", setAct);
					request.setAttribute("departamentos", null);
					request.setAttribute("dep", request.getParameter("dep"));
					request.getRequestDispatcher("/WEB-INF/jsp/ProvAltaSalida.jsp").forward(request, response);
		
					
				}
				
				// Si tiene actividad, se agrega la Salida y se envia a Home
				if (request.getParameter("act") != null) {
					departamento = (String) request.getParameter("dep");
					act = (String) request.getParameter("act");
					
					String nombre = request.getParameter("nombre");
					//String fechaAlta = request.getParameter("fechaAlta");
					String fechaSalida = request.getParameter("fechaSalida");
					System.out.printf(fechaSalida);
					String lugarSalida = request.getParameter("lugarSalida");
					DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
					String fechaAltaLDTString = LocalDateTime.now().toString();
					LocalDateTime fechaAltaLDT = LocalDateTime.now();
					String fechaSalidaLDTString = LocalDateTime.parse(fechaSalida, dateFormatter).toString();
					LocalDateTime fechaSalidaLDT = LocalDateTime.parse(fechaSalida, dateFormatter);
//////////////////	//DtInfo infoSalida = new DtInfo(fechaSalidaLDT,lugarSalida);
					int cantTuristas = Integer.parseInt(request.getParameter("cant"));
					if (ICD.existeSalidaService(nombre)) { //ICD.getActividadesXDepService(departamento).get(act).existeSalida(nombre)
						DataMapActividad mapAct = ICD.getActividadesXDepService(request.getParameter("dep"));
						List<String> setAct = new ArrayList<String>();
						for (DataActividad actividad: mapAct.getActividades()) {
							if (actividad.getEstado() == EstadoActividad.ACEPTADA) {
								setAct.add(actividad.getName());
							}
						}
						request.setAttribute("dep", departamento);
						request.setAttribute("actividades", setAct);
						request.setAttribute("error", "SalYaExiste");
						request.getRequestDispatcher("/WEB-INF/jsp/ProvAltaSalida.jsp").forward(request, response);
					}
					else if (fechaAltaLDT.isAfter(fechaSalidaLDT)) {
						DataMapActividad mapAct = ICD.getActividadesXDepService(request.getParameter("dep"));
						Set<String> setAct = new HashSet<String>();
						for (DataActividad actividad: mapAct.getActividades()) {
							if (actividad.getEstado() == EstadoActividad.ACEPTADA) {
								setAct.add(actividad.getName());
							}
						}
						request.setAttribute("act", act);
						request.setAttribute("dep", departamento);
						request.setAttribute("actividades", setAct);
						request.setAttribute("error", "errorEnFechas");
						request.getRequestDispatcher("/WEB-INF/jsp/ProvAltaSalida.jsp").forward(request, response);
					}
					else  {
						ICD.crearSalidaService(departamento, act, nombre, lugarSalida, fechaSalidaLDTString, fechaAltaLDTString, cantTuristas);
						request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
					}

				}
				
				//Si no se tiene departamento, se envia a la selecci�n de departamento
				else {
					request.getRequestDispatcher("/WEB-INF/jsp/ProvAltaSalida.jsp").forward(request, response);
				}
			}
		}
		else {
			request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
