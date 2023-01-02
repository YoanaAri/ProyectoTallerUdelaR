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
import logica.Usuario;
import jakarta.xml.bind.annotation.XmlAccessType;
import logica.Turista;



@XmlAccessorType(XmlAccessType.FIELD)
public class DTTurista extends DTUsuario {
	
	private String nacionalidad;
	private List<DTInscripcion> inscripciones;

	public DTTurista (String nickname, String name, String lastName, String mail, LocalDate date, String nacionalidad, String contrasena) {
		
		super(nickname, name, lastName, mail, date, contrasena); 
		this.nacionalidad = nacionalidad;
		this.inscripciones =  new ArrayList<DTInscripcion>();
	};
	
	public DTTurista( Turista user) {
		
		super(user.getNickname(), user.getnombre(), user.getapellido(), user.getMail(), user.getFecha(), user.getContrasena());
		this.nacionalidad = user.getnacionalidad();
		this.inscripciones = new ArrayList<DTInscripcion>();
		for(Map.Entry<String, Inscripcion> inscripcion : user.getInscripcionesUsu().entrySet()) {
			this.inscripciones.add(new DTInscripcion(inscripcion.getValue()));
		}		
	}
	
	public String getNacionalidad() {
	    return this.nacionalidad;
	}
	 
	public void setNacionalidad(String nacionalidad) {
	   	 this.nacionalidad = nacionalidad;
	}
    
    public List<DTInscripcion> getInscripcionesUsu(){
    	return this.inscripciones;
    }

}
