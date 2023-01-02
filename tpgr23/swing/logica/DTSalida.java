package logica;

import java.time.LocalDateTime;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTSalida {

	//Atributos
			private String nombre;
			private DTInfo salida;
			private int cupos;
			private LocalDateTime fechaAlta;
			private int cuposRestantes;
			private String fechaAltaString;
			
	//Metodos
			public DTSalida() {
				
			}
			
			public DTSalida(String nombre, DTInfo salida, int cupos, LocalDateTime fechaAlta) {
				this.nombre = nombre;
				this.salida = salida;
				this.cupos = cupos;
				this.fechaAlta = fechaAlta;
				this.fechaAltaString = fechaAlta.toString();
			}
			
			//GETTERS 
			public String getNombre() {
				return this.nombre;
			}
			
			public DTInfo getSalida() {
				return this.salida;
			}
			
			public int  getCupos() {
				return this.cupos;
			}
			
			public LocalDateTime getFechaAlta() {
				return this.fechaAlta;
			}
			
			public int getCuposRestantes() {
				return this.cuposRestantes;
			}
			
			public String getFechaAltaString() {
				return this.fechaAltaString;
			}
}
