package Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import logica.Categoria;


@XmlAccessorType(XmlAccessType.FIELD)
public class DataMapCategoria {
	private List<DTCategoria> categorias;

	public DataMapCategoria(Map<String, Categoria> cat) {
		this.categorias = new ArrayList<DTCategoria>();
		for(Map.Entry<String, Categoria> categoria : cat.entrySet()) {
			this.categorias.add(new DTCategoria(categoria.getValue()));
		}
	}
	
	public List<DTCategoria> getDTCategorias(){
		return this.categorias;
	}
	
}
