package Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import logica.SalidaTuristica;
import logica.Turista;
import logica.Proveedor;
import logica.Usuario;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataMapUsuario {
	private List<DTUsuario> usuarios;

	public DataMapUsuario(Map<String, Usuario> usu) {
		this.usuarios = new ArrayList<DTUsuario>();
		for(Map.Entry<String, Usuario> usuario : usu.entrySet()) {
			if(usuario.getValue().getClass() == Turista.class) {
				DTTurista dtTuri = new DTTurista((Turista) usuario.getValue());
				this.usuarios.add((DTUsuario) dtTuri);
			}
			else {
				DTProveedor dtProv = new DTProveedor((Proveedor) usuario.getValue());
				this.usuarios.add((DTUsuario) dtProv);
			}
		}
	}
	
	public List<DTUsuario> getDataMapUsuario(){
		return this.usuarios;
	}

}
