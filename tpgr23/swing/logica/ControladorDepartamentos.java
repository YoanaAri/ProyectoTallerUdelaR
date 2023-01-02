package logica;
import java.util.*;
import java.time.*;

public class ControladorDepartamentos implements IControladorDepartamentos {

	ManejadorDepartamento md = ManejadorDepartamento.getInstancia();
	ManejadorUsuario mu = ManejadorUsuario.getinstance();
	public void altaDepartamento(String nombre, String descripcion, String url) {
		Departamento dep = new Departamento(nombre, descripcion, url);
		md.addDepartamento(dep);
	}

	public Set<String> getSetDepartamentos() {
		return md.setDepartamento();
	}

	public void altaCategoria(String nombre) {

		md.setCategoria(nombre);

	}

	public Set<String> getCategorias() {
		return md.getCategorias();
	}

	public Map<String, Categoria> getMapCategorias() {
		return md.getCategoriasMap();
	}

	public void altaActividad(String dep, String prov, String name, String descripcion, int duracion, int costo, String ciudad, LocalDate fechaAlta, List<String> categorias) {
		Departamento depObj = md.getDepartamento(dep);
		Proveedor provObj = (Proveedor) mu.getUsuarioNickname(prov);
		Actividad a = new Actividad(name, descripcion, duracion, costo, ciudad, fechaAlta);
		a.setEstado(EstadoActividad.Agregada);

		if (categorias != null) {
			int cat = categorias.size();

			for (int i = 0; i < cat; i++) {
				Categoria categ = md.getCategoria(categorias.get(i));
				a.addCategoria(categorias.get(i), categ);
				categ.setactividades(a, name);
			}
		}

		provObj.addActividad(a);
		depObj.addActividad(a);
	}

	public boolean existeDepartamento(String name) {
		return !(md.getDepartamento(name) == null);
	}

	public boolean existeActividadEnDepartamento(String nameActividad, String nameDepartamento) {
		return !(md.getActividadEnDepartamento(nameActividad, nameDepartamento) == null);
	}
	public Map<String, Actividad> getActividadesXCategoria(String cat) {

		HashMap<String, Actividad> res = new HashMap<String, Actividad>();

		for (Map.Entry<String, Actividad> ac : md.getCategoria(cat).getactividades().entrySet()) {

			if (ac.getValue().getEstado() == EstadoActividad.Aceptada) {
				res.put(ac.getKey(), ac.getValue());
			}

		}

		return res;
	}

	//son las actividades aceptadas por depto
	public Map<String, Actividad> getActividadesAgregadasXDep(String dep) {

		HashMap<String, Actividad> res = new HashMap<String, Actividad>();

		for (Map.Entry<String, Actividad> ac : md.getDepartamento(dep).getActividades().entrySet()) {

			if (ac.getValue().getEstado() == EstadoActividad.Aceptada) {
				res.put(ac.getKey(), ac.getValue());
			}

		}

		return res;

	}

	public Map<String, Actividad> getActividadesXDep(String dep) {

		return md.getDepartamento(dep).getActividades();

	}

	public void crearSalida(String dep, String act, String nombreSalida, DTInfo lugarSalida, LocalDateTime fecha, int cupos) {

		Actividad a = md.getDepartamento(dep).getActividades().get(act);
		a.altaSalida(nombreSalida, lugarSalida, fecha, cupos);

	}

	public boolean existeSalida(String sal) {
		return getsalidas().containsKey(sal);
	}

	// gaston

	public Map<String, SalidaTuristica> getSalidaXActividadDepto(String dep, String act) {
		return md.getDepartamento(dep).getSalidasXActividad(act);
	}
	public Map<String, SalidaTuristica> getsalidas() {
		Map<String, SalidaTuristica> sal = new HashMap<String, SalidaTuristica>();
		sal = md.getsalidas();
		return sal;
	}
	// ----------
	/////////////////////
	public Map<String, SalidaTuristica> getSalidasXFecha(String dep, String act, LocalDateTime today) {
		return md.getActividadEnDepartamento(act, dep).getSalidasXfecha(today);
	}

	//////////////////////
	public String getDepartamentoXActividad(String actividad) {
		String depto = "";
		for (String d : md.setDepartamento()) {
			for (String ac : getActividadesXDep(d).keySet()) {
				if (ac.equals(actividad)) {
					depto = d;
				}
			}
		}
		return depto;
	}
	public String getActividadXSalida(String salida) {
		String act = "";
		for (String d : md.setDepartamento()) {
			for (Map.Entry<String, Actividad> ac : getActividadesXDep(d).entrySet()) {
				if (ac.getValue().existeSalida(salida)) {
					act = ac.getKey();
				}
			}
		}

		return act;
	}
	public SalidaTuristica getSalidaXActividad(String sal, String act, String dpto) {
		return md.getActividadEnDepartamento(act, dpto).getSalida(sal);
	}

	public Map<String, Actividad> getActividadesAgregadas() {
		String act = "";

		HashMap<String, Actividad> agreg = new HashMap<String, Actividad>();
		for (String d : md.setDepartamento()) {
			for (Map.Entry<String, Actividad> ac : getActividadesXDep(d).entrySet()) {
				if (ac.getValue().getEstado() == EstadoActividad.Agregada) {

					act = ac.getKey();
					Actividad a;
					a = ac.getValue();
					agreg.put(act, a);
				}
			}
		}

		return agreg;

	}

	public Map<String, Actividad> getActividadesAceptadas() {
		String act = "";

		HashMap<String, Actividad> agreg = new HashMap<String, Actividad>();
		for (String d : md.setDepartamento()) {
			for (Map.Entry<String, Actividad> ac : getActividadesXDep(d).entrySet()) {
				if (ac.getValue().getEstado() == EstadoActividad.Aceptada) {

					act = ac.getKey();
					Actividad a;
					a = ac.getValue();
					agreg.put(act, a);
				}
			}
		}

		return agreg;

	}

	public void aceptarActividad(String nameAct, EstadoActividad estado) {
		Actividad act = getActividadesAgregadas().get(nameAct);
		act.setEstado(estado);
	}

	public Actividad encontrarActividad(String nombreAct) {

		Actividad activ = null;

		for (String d : md.setDepartamento()) {

			for (Map.Entry<String, Actividad> ac : getActividadesXDep(d).entrySet()) {

				if (ac.getValue().getName().equals(nombreAct)) {

					activ = ac.getValue();

				}
			}
		}

		return activ;

	}

	public void agregarActividadACategoria(String nombreAct, String nombreCat) {
		md.getCategoria(nombreCat).setactividades(encontrarActividad(nombreAct), nombreAct);
		encontrarActividad(nombreAct).addCategoria(nombreCat, md.getCategoria(nombreCat));
	}

	public SalidaTuristica getSalidaNombre(String nombreSal) {

		SalidaTuristica salida = null;

		for (String d : md.setDepartamento()) {

			for (Map.Entry<String, Actividad> ac : getActividadesXDep(d).entrySet()) {

				for (Map.Entry<String, SalidaTuristica> sal : getSalidaXActividadDepto(d, ac.getValue().getName()).entrySet()) {

					if (nombreSal.equals(sal.getKey())) {
						salida = sal.getValue();
					}
				}
			}
		}

		return salida;

	}

	public boolean existeCategoria(String nombreCat) {
		return md.getCategorias().contains(nombreCat);
	}

	public Map<String, Actividad> getActividadesXCat(String nombreCat) {

		return md.getCategoria(nombreCat).getactividades();

	}
	
	
	public Map<String, Actividad> getActividadesAceptadasSinSalida(){
			
		Map<String, Actividad> aceptadas = getActividadesAceptadas();
		
		Map<String, Actividad> res = new HashMap<String, Actividad>();
		
		String departamento;
		
		Map<String, SalidaTuristica> salidas;
		
		for( Map.Entry<String, Actividad> ac : aceptadas.entrySet()) {
			
			departamento = getDepartamentoXActividad(ac.getKey());
			
			salidas = getSalidasXFecha(departamento, ac.getKey(), LocalDateTime.now());
			
			if( salidas.isEmpty() ) {
				res.put(ac.getKey(), ac.getValue());
			}
			
		}
		
		return res;
		
	}
	
	
	public void finalizarActividad(String actividad) {
		getActividadesAceptadas().get(actividad).setEstado(EstadoActividad.Finalizada);
	}

	
	
}
