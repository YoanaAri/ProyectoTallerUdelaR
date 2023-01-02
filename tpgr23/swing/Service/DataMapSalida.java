package Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import logica.DTSalida;
import logica.SalidaTuristica;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataMapSalida {
	private List<DTSalida> salidas;

	public DataMapSalida(Map<String, SalidaTuristica> sal) {
		this.salidas = new ArrayList<DTSalida>();
		for(Map.Entry<String, SalidaTuristica> salida : sal.entrySet()) {
			this.salidas.add(salida.getValue().getDTSalida());
		}
	}
	
	public List<DTSalida> getDataMapSalida(){
		return this.salidas;
	}
}
