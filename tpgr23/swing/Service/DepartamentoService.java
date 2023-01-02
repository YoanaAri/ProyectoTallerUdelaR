package Service;



//import java.util.Set;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.ParameterStyle;
import jakarta.jws.soap.SOAPBinding.Style;
import jakarta.xml.ws.Endpoint;
/*
import logica.Actividad;
import logica.ControladorDepartamentos;
import logica.DTInfo;
import logica.EstadoActividad;
import logica.SalidaTuristica;
*/
import logica.*;

@WebService
@SOAPBinding(style= Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class DepartamentoService {
	private ControladorDepartamentos ctrlDep = new ControladorDepartamentos();
	private Endpoint endpoint=null;
	
	public void DepartamentosService() {
		
	}
	@WebMethod(exclude = true)
	public void publicar(String url){
		endpoint= Endpoint.publish(url, this);
		
	}
	@WebMethod(exclude = true)
	public Endpoint getendpoint() {
		return this.endpoint;
	}
	@WebMethod
	public void altaDepartamentoService(String nombre, String descripcion, String url) {
		ctrlDep.altaDepartamento(nombre, descripcion, url);
	}
	@WebMethod
	public ListaString getSetDepartamentosService(){
		return new ListaString(ctrlDep.getSetDepartamentos());
	}
	@WebMethod
	public void altaCategoriaService(String nombre) {
		ctrlDep.altaCategoria(nombre);
	}
	@WebMethod
	public ListaString getCategoriasService(){
		return new ListaString(ctrlDep.getCategorias());
	}
	@WebMethod
	public DataMapCategoria getMapCategoriasService(){
		return new DataMapCategoria(ctrlDep.getMapCategorias());
	}
	@WebMethod
	public void altaActividadService(String dep, String prov, String name, String descripcion, int duracion, int costo, String ciudad, String fechaAlta) {
		LocalDate fecha = LocalDate.parse(fechaAlta);
		List<String> cats = new ArrayList<String>();
		ctrlDep.altaActividad(dep, prov, name, descripcion, duracion, costo, ciudad, fecha, cats);
	}
	@WebMethod
	public boolean existeDepartamentoService(String name) {
		return ctrlDep.existeDepartamento(name);
	}
	@WebMethod
	public boolean existeActividadEnDepartamentoService(String nameActividad, String nameDepartamento) {
		return ctrlDep.existeActividadEnDepartamento(nameActividad, nameDepartamento);
	}
	@WebMethod
	public DataMapActividad getActividadesXDepService(String departamento){
		return new DataMapActividad(ctrlDep.getActividadesXDep(departamento));
		
	}
	@WebMethod
	public void crearSalidaService(String dep, String act, String nombreSalida, String lugarSalida, String fechaSalida, String fechaAlta, int cupos) {
		LocalDateTime fechaS = LocalDateTime.parse(fechaSalida);
		LocalDateTime fechaA = LocalDateTime.parse(fechaAlta);
		DTInfo lugar = new DTInfo(fechaS, lugarSalida);
		ctrlDep.crearSalida(dep, act, nombreSalida, lugar, fechaA, cupos);
	}
	@WebMethod
	public boolean existeSalidaService(String sal) {
		return ctrlDep.existeSalida(sal);
	}
	@WebMethod
	public  DataMapSalida getSalidaXActividadDeptoService(String dep, String act){
		return new DataMapSalida(ctrlDep.getSalidaXActividadDepto(dep, act));
	}
	@WebMethod
	public DataMapSalida getsalidasService(){
		return new DataMapSalida(ctrlDep.getsalidas());
	}
	
	@WebMethod
	public String getDepartamentoXActividadService(String actividad) {
		return ctrlDep.getDepartamentoXActividad(actividad);
	}
	@WebMethod
	public String getActividadXSalidaService(String salida) {
		return ctrlDep.getActividadXSalida(salida);
	}
	@WebMethod
	public DataMapSalida getSalidasXFechaService(String dep, String act, String fecha) {
		LocalDateTime today = LocalDateTime.parse(fecha);
		return new DataMapSalida(ctrlDep.getSalidasXFecha(dep, act, today));
	}
	@WebMethod
	public DTSalida getSalidaXActividadService(String sal, String act, String dpto) {
		return ctrlDep.getSalidaXActividad(sal, act, dpto).getDTSalida();
	}
	@WebMethod
	public DataMapActividad getActividadesAgregadasService() {
		return new DataMapActividad(ctrlDep.getActividadesAgregadas());
	}
	@WebMethod
	public DataMapActividad getActividadesAceptadasService() {
		return new DataMapActividad(ctrlDep.getActividadesAceptadas());
	}
	
	@WebMethod
	public void agregarActividadACategoriaStringService(String nombreAct, String nombreCat) {
		ctrlDep.agregarActividadACategoria(nombreAct, nombreCat);
	}
	@WebMethod
	public DataActividad encontrarActividadService(String nombreActividad) {
		//DataActividad f=new DataActividad(ctrlDep.encontrarActividad(nombreActividad));
		return new DataActividad(ctrlDep.encontrarActividad(nombreActividad));
	}
	@WebMethod
	public DTSalida getSalidaNombreService(String nombreSalida) {
		return ctrlDep.getSalidaNombre(nombreSalida).getDTSalida();
	}
	@WebMethod
	public boolean existeCategoriaService(String nombreCat) {
		return ctrlDep.existeCategoria(nombreCat);
	}
	@WebMethod
	public DataMapActividad getActividadesXCatService(String nombreCat) {
		return new DataMapActividad(ctrlDep.getActividadesXCat(nombreCat));
	}
	@WebMethod
	public DataMapActividad getActividadesAgregadasXDepService(String dep){
		return new DataMapActividad(ctrlDep.getActividadesAgregadasXDep(dep));
	}//son las aceptadas
	@WebMethod
	public DataMapActividad getActividadesAceptadasSinSalidaService() {
		return new DataMapActividad(ctrlDep.getActividadesAceptadasSinSalida());
	}
	@WebMethod
	public void finalizarActividadService(String actividad) {
		ctrlDep.finalizarActividad(actividad);
	}
	
	@WebMethod
	public void aceptarActividadService(String nameAct, String estado) {
		EstadoActividad est;
		switch (estado) {
		case "Aceptada":
			est = EstadoActividad.Aceptada;
		break;
		case "Agregada":
			est = EstadoActividad.Agregada;
		break;
		case "Rechazada":
			est = EstadoActividad.Rechazada;
		break;
		case "Finalizada":
			est = EstadoActividad.Finalizada;
		break;
		default:
			est = EstadoActividad.Aceptada;
		}
		ctrlDep.aceptarActividad(nameAct, est);
	}
	

}
