package Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import logica.Actividad;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataMapActividad {
	private List<DataActividad> actividades;

	public DataMapActividad() {
		this.actividades=null;
	}
	
	public DataMapActividad(Map<String, Actividad> act) {
		this.actividades = new ArrayList<DataActividad>();
		for(Map.Entry<String, Actividad> actividad : act.entrySet()) {
			this.actividades.add(new DataActividad(actividad.getValue()));
		}
	}
	
	public List<DataActividad> GetDataMapActividad() {
		return this.actividades;
	}

}
