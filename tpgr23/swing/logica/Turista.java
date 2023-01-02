package logica;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

public class Turista extends Usuario{
	
	private String nacionalidad;
	private HashMap<String, Inscripcion> inscripciones;

	public Turista(String nickname, String name, String lastName, String mail, LocalDate date, String nacionalidad, String contrasena) {
		super(nickname, name, lastName, mail, date, contrasena);
		this.nacionalidad = nacionalidad;
		this.inscripciones =  new  HashMap<String, Inscripcion>();
	};
	
	public void registrarInscripcion(int cant, LocalDateTime date, String dpto, String actividad, String salidaT) {
		if(!this.existeInscripcion(salidaT)) {
			Inscripcion insc = new Inscripcion(cant, date, dpto, actividad, salidaT);
			inscripciones.put(salidaT, insc);	
		}
	}
	
    public boolean existeInscripcion(String salidaT) {
    		return inscripciones.containsKey(salidaT);
	}

    public String getnacionalidad() {
    	return this.nacionalidad;
    }
    
    public Map<String, SalidaTuristica> getSalidaTurista(){
    	Map<String, SalidaTuristica> salidas= new HashMap<String, SalidaTuristica>();
    	for (Map.Entry<String, Inscripcion> insc: inscripciones.entrySet()) {
    		salidas.put(insc.getValue().getSalida().getNombre(), insc.getValue().getSalida());
    	}
    	return salidas;
    }
    
    public Map<String, Inscripcion> getInscripcionesUsu(){
    	return this.inscripciones;
    }
}