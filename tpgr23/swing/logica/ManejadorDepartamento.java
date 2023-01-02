package logica;
import java.util.*;

public class ManejadorDepartamento {
	private Map<String, Departamento> departamentosName;
	private static ManejadorDepartamento instancia = null;
	private Map<String, Categoria> categoriasName;

	private ManejadorDepartamento() {
		departamentosName = new HashMap<String, Departamento>();
		categoriasName = new HashMap<String, Categoria>();
	}

	public static ManejadorDepartamento getInstancia() {
		if (instancia == null) {
			instancia = new ManejadorDepartamento();
		}
		return instancia;
	}

	public void addDepartamento(Departamento dep) {
		String name = dep.getName();
		departamentosName.put(name, dep);
	}

	public Departamento getDepartamento(String name) {
		return (Departamento) departamentosName.get(name);
	}

	public Set<String> setDepartamento() {
		return departamentosName.keySet();
	}

	public Actividad getActividadEnDepartamento(String nameActividad, String nameDepartamento) {
		Departamento dep = departamentosName.get(nameDepartamento);
		if (dep != null) {
			Map<String, Actividad> actividadesDep = dep.getActividades();
			if (actividadesDep != null) {
				return actividadesDep.get(nameActividad);
			}
		}
		return null;
	}
	public Map<String, SalidaTuristica> getsalidas() {
		Map<String, SalidaTuristica> sal = new HashMap<String, SalidaTuristica>();
		for (Map.Entry<String, Departamento> dep : departamentosName.entrySet()) {
			sal.putAll(dep.getValue().getSalidas());
		}
		return sal;
	}

	public void setCategoria(String categ) {

		Categoria cat = new Categoria(categ);
		categoriasName.put(categ, cat);
	}

	public Categoria getCategoria(String string) {
		// TODO Auto-generated method stub
		return (Categoria) categoriasName.get(string);
	}

	public Set<String> getCategorias() {

		return categoriasName.keySet();
	}

	public Map<String, Categoria> getCategoriasMap() {
		return categoriasName;
	}
}
