package Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.xml.bind.annotation.XmlAccessorType;
import logica.Actividad;
import logica.Departamento;
import jakarta.xml.bind.annotation.XmlAccessType;


@XmlAccessorType(XmlAccessType.FIELD)
public class DTDepartamento {

	private String nombre;
	private String descripcion;
	private String url;
	private List<DataActividad> actividades;
	
	public DTDepartamento(String nombre, String descripcion, String url) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.url = url;
		this.actividades = new ArrayList<DataActividad>();
	}
	
	public DTDepartamento(Departamento dep) {
		this.nombre = dep.getName();
		this.descripcion = dep.getDescripcion();
		this.url = dep.getUrl();
		this.actividades = new ArrayList<DataActividad>();
		for(Map.Entry<String, Actividad> actividad : dep.getActividades().entrySet()) {
			this.actividades.add(new DataActividad(actividad.getValue()));
		}
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
	
		public List<DataActividad> getActividades() {
			return this.actividades;
		}
	
		public void setName(String name) {
			this.nombre = name;
		}
		
		public void setDescripcion(String desc)  {
			this.descripcion = desc;
		}
		
		public void setUrl(String url) {
			this.url = url;
		}
		
}
