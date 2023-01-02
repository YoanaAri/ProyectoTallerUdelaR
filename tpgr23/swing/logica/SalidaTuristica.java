package logica;

import java.time.*;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

public class SalidaTuristica {

	// Atributos
	private String nombre;
	private DTInfo salida;
	private int cupos;
	private LocalDateTime fechaAlta;
	private String fechaAltaString;
	private int cuposRestantes;

	// Metodos
	public SalidaTuristica() {
	}

	public SalidaTuristica(String nombre, DTInfo salida, int cupos, LocalDateTime fechaAlta) {
		this.nombre = nombre;
		this.salida = salida;
		this.cupos = cupos;
		this.fechaAlta = fechaAlta;
		this.cuposRestantes = cupos;
		this.fechaAltaString = fechaAlta.toString();
	}

	// SETTERS

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setSalida(DTInfo salida) {
		this.salida = salida;
	}

	public void setCupos(int cupos) {
		this.cupos = cupos;
	}

	public void setFechaAlta(LocalDateTime fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public void setCuposRestantes(int x) {
		this.cuposRestantes = this.cuposRestantes - x;
	}

	// GETTERS
	public LocalDateTime getFechaSalida() {
		return this.salida.getFecha();
	}

	public String getNombre() {
		return this.nombre;
	}

	public DTInfo getSalida() {
		return this.salida;
	}

	public int getCupos() {
		return this.cupos;
	}

	public LocalDateTime getFechaAlta() {
		return this.fechaAlta;
	}

	public int getCuposRestantes() {
		return this.cuposRestantes;
	}

	public DTSalida getDTSalida() {
		DTSalida dts = new DTSalida(this.nombre, this.salida, this.cupos, this.fechaAlta);
		return dts;
	}
}
