
package logica;
import java.time.*;
import java.util.*;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

public class Proveedor extends Usuario {
	private String descripcionGeneral;
	private String link;
	private HashMap<String, Actividad> actividades;

	public Proveedor(String nickname, String name, String lastName, String mail, LocalDate date, String descG, String link, String contrasena) {
		super(nickname, name, lastName, mail, date, contrasena);
		this.descripcionGeneral = descG;
		this.link = link;
		this.actividades = new HashMap<String, Actividad>();
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void addActividad(Actividad at) {
		String name = at.getName();
		actividades.put(name, at);
	}

	public Map<String, Actividad> getActividades() {
		return this.actividades;
	}
	/////////////////////////
	public String getdescripcion() {
		return this.descripcionGeneral;
	}
	public String getLink() {
		return this.link;
	}
	public Map<String, SalidaTuristica> getSalidas() {
		Map<String, SalidaTuristica> salidas = new HashMap<String, SalidaTuristica>();
		for (Map.Entry<String, Actividad> act : actividades.entrySet()) {
			salidas.putAll(act.getValue().getSalidas());
		}
		return salidas;
	}
	//////////////////////////

}