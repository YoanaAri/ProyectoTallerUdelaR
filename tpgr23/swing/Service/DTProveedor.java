package Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.xml.bind.annotation.XmlAccessorType;
import logica.Actividad;
import logica.Departamento;
import logica.Inscripcion;
import logica.Proveedor;
import logica.Usuario;
import jakarta.xml.bind.annotation.XmlAccessType;
import logica.Turista;



@XmlAccessorType(XmlAccessType.FIELD)
public class DTProveedor extends DTUsuario {
	
	private String descripcionGeneral;
	private String link;
	private List<DataActividad> actividades;

	public DTProveedor(String nickname, String name, String lastName, String mail, LocalDate date, String descG, String link, String contrasena) {
	
		super(nickname, name, lastName, mail, date, contrasena); 
		this.descripcionGeneral = descG;
		this.link = link;
		this.actividades = new ArrayList<DataActividad>();
	
	
	}
	
	public DTProveedor(Proveedor user) {
		
		super(user.getNickname(), user.getnombre(), user.getapellido(), user.getMail(), user.getFecha(), user.getContrasena());
		this.descripcionGeneral = user.getdescripcion();
		this.link = user.getLink();
		this.actividades = new ArrayList<DataActividad>();
		for(Map.Entry<String, Actividad> actividad : user.getActividades().entrySet()) {
			this.actividades.add(new DataActividad(actividad.getValue()));
		}	
	}
	
	public String getDescripcion() {
		return this.descripcionGeneral;
	}
	
	public List<DataActividad> getActividades() {
		return this.actividades;
	}
	
	public void setDescripcion(String desc) {
		 this.descripcionGeneral = desc;
	}
	
	public void setLink(String link) {
		 this.link = link;
	}
	
}
