package logica;

import java.time.*;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTInfo {
	
	//Atributos
		private LocalDateTime fecha;
		private String fechaString;
		private String lugarSalida;
		
		//Metodos
		public DTInfo() {}
		
		public DTInfo(LocalDateTime fecha, String lugarSalida) {
			this.fecha = fecha;
			this.lugarSalida = lugarSalida;
			this.fechaString = fecha.toString();
		}
		
		//SETTERS
		public void setFecha(LocalDateTime fecha) {
			this.fecha=fecha;
		}
		
		public void setLugarSalida(String lugarSalida) {
			this.lugarSalida=lugarSalida;
		}
		
		//GETTERS
		
		public LocalDateTime getFecha() {
			return this.fecha;
		}
		
		public String getLugarSalida() {
			return this.lugarSalida;
		}

}
