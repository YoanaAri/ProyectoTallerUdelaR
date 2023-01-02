package Service;

import java.time.LocalDateTime;

import jakarta.xml.bind.annotation.XmlAccessorType;
import logica.DTSalida;
import logica.Fabrica;
import logica.IControladorDepartamentos;
import logica.Inscripcion;
import jakarta.xml.bind.annotation.XmlAccessType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTInscripcion {
	private int cantidadInscriptos;
	private LocalDateTime fechaInscripcion;
	private String fechaInscripcionString;
	private DTSalida salidaTuristica;
	private int costo;
	
	
	public DTInscripcion(int cant, LocalDateTime date, String dpto, String actividad, String salidaT) {
		
		this.cantidadInscriptos = cant;
		this.fechaInscripcion = date;
		Fabrica fabrica = Fabrica.getInstance();
	    IControladorDepartamentos icd = fabrica.getIControladorDepartamentos();
	    this.salidaTuristica = icd.getActividadesXDep(dpto).get(actividad).getSalida(salidaT).getDTSalida();
		int costoA = icd.getActividadesXDep(dpto).get(actividad).getCosto();
		this.costo = costoA * cant;
		this.fechaInscripcionString = date.toString();	
	}
	
	public DTInscripcion(Inscripcion insc) {
		this.cantidadInscriptos = insc.getCantidadInscriptos();
		this.fechaInscripcion = insc.getFechaInscripcion();
		this.salidaTuristica = insc.getSalida().getDTSalida();
		this.costo = insc.getCosto();
		this.fechaInscripcionString = insc.getFechaInscripcion().toString();	
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
	public DTSalida getSalida() {
		return this.salidaTuristica;
	}
	
	public void setCantidadInscriptos(int cant) {
		this.cantidadInscriptos = cant;
	}
	
	public void setCosto(int costo) {
		this.costo = costo;
	}
	
	public void setFechaInscripcion( LocalDateTime fecha) {
		this.fechaInscripcion = fecha;
	}
	
	public String getFechaInscripcionString() {
		return this.fechaInscripcionString;
	}
	
	
	
	
	
	
	
	
}
