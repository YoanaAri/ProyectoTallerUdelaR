package logica;

import java.util.HashMap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

public class Categoria {
	private String nombre;
	private HashMap<String, Actividad> actividades;
	
	public Categoria(String nom) {
		this.nombre=nom;
		this.actividades=new HashMap<String, Actividad>();
	}
	public String getnombre() {
		return this.nombre;
	}
	public HashMap<String, Actividad> getactividades(){
		return this.actividades;
	}
	public void setactividades(Actividad act, String nom) {
		actividades.put(nom, act);
	}
}
