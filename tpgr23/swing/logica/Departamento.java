package logica;
import java.util.HashMap;
import java.util.Map;

public class Departamento {
	private String nombre;
	private String descripcion;
	private String url;
	private HashMap<String, Actividad> actividades;

	public Departamento(String nombre, String descripcion, String url) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.url = url;
		this.actividades = new HashMap<String, Actividad>();
	}

	// Gets
	public String getName() {
		return this.nombre;
	}
	public String getDescripcion() {
		return this.descripcion;
	}
	public String getUrl() {
		return this.url;
	}

	public void addActividad(Actividad at) {
		String name = at.getName();
		actividades.put(name, at);
	}

	public Map<String, Actividad> getActividades() {
		return this.actividades;
	}

	// gaston
	public Map<String, SalidaTuristica> getSalidasXActividad(String act) {
		return this.actividades.get(act).getSalidas();
	}
	// --------
	public Map<String, SalidaTuristica> getSalidas() {
		Map<String, SalidaTuristica> sal = new HashMap<String, SalidaTuristica>();
		for (Map.Entry<String, Actividad> act : actividades.entrySet()) {
			sal.putAll(act.getValue().getSalidas());
		}
		return sal;
	}

	//////////////
	public Actividad getActividadEsp(String act) {
		Actividad activi = null;
		for (Map.Entry<String, Actividad> a : actividades.entrySet()) {
			if (a.getValue().getName() == act) {
				activi = a.getValue();
			}
		}
		return activi;
	}

	////////////////
}
