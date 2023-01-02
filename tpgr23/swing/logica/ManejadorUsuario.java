package logica;

//import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.*;

public final class ManejadorUsuario {

	private Map<String, Usuario> usuariosNickname;
	private Map<String, Usuario> usuariosMail;
	private Set<String> listaProveedores;
	private static ManejadorUsuario instancia = null;

	private ManejadorUsuario() {
		usuariosNickname = new HashMap<String, Usuario>();
		usuariosMail = new HashMap<String, Usuario>();
		listaProveedores = new HashSet<String>();
	}

	public static ManejadorUsuario getinstance() {
		if (instancia == null)
			instancia = new ManejadorUsuario();
		return instancia;
	}

	public void addUsuario(Usuario user) {
		String nickname = user.getNickname();
		usuariosNickname.put(nickname, user);
		String mail = user.getMail();
		usuariosMail.put(mail, user);
	}

	public void addProveedor(String name) {
		listaProveedores.add(name);
	}

	public Set<String> getSetProveedor() {
		return this.listaProveedores;
	}

	/////////////////////////////
	public Map<String, Usuario> getUsuario() {
		return usuariosNickname;
	}

	///////////////////////////

	public Usuario getUsuarioNickname(String nickname) {
		return (Usuario) usuariosNickname.get(nickname);
	}
	public Usuario getUsuarioMail(String mail) {
		return (Usuario) usuariosMail.get(mail);
	}

	public Set<String> getTuristas() {
		Set<String> turistas = new HashSet<String>();
		for (Map.Entry<String, Usuario> user : usuariosNickname.entrySet()) {
			if (user.getValue().getClass() == Turista.class) {
				turistas.add(user.getKey());
			}
		}
		return turistas;
	}

	public Set<String> getProveedores() {
		Set<String> proveedores = new HashSet<String>();
		for (Map.Entry<String, Usuario> user : usuariosNickname.entrySet()) {
			if (user.getValue().getClass() == Proveedor.class) {
				proveedores.add(user.getKey());
			}
		}
		return proveedores;
	}

}