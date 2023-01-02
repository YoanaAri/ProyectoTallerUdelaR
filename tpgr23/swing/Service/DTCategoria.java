package Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.xml.bind.annotation.XmlAccessorType;
import logica.Actividad;
import logica.Categoria;
import logica.DTSalida;
import logica.SalidaTuristica;
import jakarta.xml.bind.annotation.XmlAccessType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTCategoria {
	
	private String nombre;
	private List<DataActividad> actividades;
	
	public DTCategoria(String nom) {
		this.nombre = nom;
		this.actividades = new ArrayList<DataActividad>();
	}
	
	public DTCategoria(Categoria cat) {
		this.nombre = cat.getnombre();
		this.actividades = new ArrayList<DataActividad>();
		for(Map.Entry<String, Actividad> actividad : cat.getactividades().entrySet()) {
			this.actividades.add(new DataActividad(actividad.getValue()));
		}
	}
	
	public String getnombre() {
		return this.nombre;
	}
	
	public List<DataActividad> getactividades(){
		return this.actividades;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
