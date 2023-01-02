package Service;

import java.util.List;
import java.util.Set;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class ListaString {
	private Set<String> lista;
	
	public ListaString(Set<String> set) {
		this.lista = set;
	}
	
	public ListaString() {
		this.lista = null;
	}
	
	public List<String> getLista(){
		return (List<String>)this.lista;
		
	}
	public Set<String> getSet(){
		return this.lista;
	}

}
