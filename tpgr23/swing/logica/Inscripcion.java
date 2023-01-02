package logica;

import java.time.*;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

public class Inscripcion {
	
	private int cantidadInscriptos;
	private LocalDateTime fechaInscripcion;
	private String fechaInscripcionString;
	private SalidaTuristica salidaTuristica;
	private int costo;
	
	public Inscripcion(int cant, LocalDateTime date, String dpto, String actividad, String salidaT) {
		this.cantidadInscriptos = cant;
		this.fechaInscripcion = date;
		Fabrica fabrica = Fabrica.getInstance();
	    IControladorDepartamentos icd = fabrica.getIControladorDepartamentos();
	    this.salidaTuristica = icd.getActividadesXDep(dpto).get(actividad).getSalida(salidaT);
		this.salidaTuristica.setCuposRestantes(cant);
		int costoA = icd.getActividadesXDep(dpto).get(actividad).getCosto();
		this.costo = costoA * cant;
		this.fechaInscripcionString = fechaInscripcion.toLocalDate().toString();
	}
	
	public int getCosto() {
		return this.costo;
	}
	
	public int getCantidadInscriptos() {
		return this.cantidadInscriptos;
	}
	
	public LocalDateTime getFechaInscripcion() {
		return this.fechaInscripcion;
	}
	////////////////////
	public SalidaTuristica getSalida() {
		return this.salidaTuristica;
	}
	////////////////////
}

