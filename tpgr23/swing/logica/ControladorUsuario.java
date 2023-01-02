package logica;

import java.time.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ControladorUsuario implements IControladorUsuario {

	private ManejadorUsuario mu = ManejadorUsuario.getinstance();
	public ControladorUsuario() {
	}
	public Set<String> getTuristas() {
		return mu.getTuristas();
	}
	public Set<String> getProveedores() {
		return mu.getProveedores();
	}
	////////////////////////
	public Map<String, Usuario> getUsuario() {
		return mu.getUsuario();
	}

	public Usuario getUsuario(String nick) {
		if (nick.contains("@")) {
			return mu.getUsuarioMail(nick);
		}
		return mu.getUsuarioNickname(nick);

	}

	public Map<String, SalidaTuristica> getSalidasUsu(String nick) {
		Usuario user = mu.getUsuarioNickname(nick);
		if (user.getClass() == Turista.class) {
			return ((Turista) user).getSalidaTurista();
		} else {
			return ((Proveedor) user).getSalidas();
		}
	}
	public Map<String, Actividad> getAvtividadesUsu(String nick) {
		Usuario user = mu.getUsuarioNickname(nick);
		if (user.getClass() == Proveedor.class) {
			return ((Proveedor) user).getActividades();
		} else {
			return null;
		}
	}
	///////////////////////////

	public void altaTurista(String nickname, String name, String lastName, String mail, LocalDate date, String nacionalidad, String contrasena) {
		Usuario user = new Turista(nickname, name, lastName, mail, date, nacionalidad, contrasena);
		mu.addUsuario(user);
	}

	public void altaProveedor(String nickname, String name, String lastName, String mail, LocalDate date, String description, String link, String contrasena) {
		Usuario user = new Proveedor(nickname, name, lastName, mail, date, description, link, contrasena);
		mu.addProveedor(nickname);
		mu.addUsuario(user);
	}

	public Set<String> getSetProveedor() {
		return mu.getSetProveedor();
	}

	public boolean existeNickname(String nickname) {
		return !(mu.getUsuarioNickname(nickname) == null);
	}

	public boolean existeMail(String mail) {
		return !(mu.getUsuarioMail(mail) == null);
	}

	public void registrarInscrip(int cant, LocalDateTime date, String dpto, String actividad, String salidaT, String turista) {
		Usuario user = mu.getUsuarioNickname(turista);
		//if(!((Turista) user).existeInscripcion(salidaT)) {
			((Turista) user).registrarInscripcion(cant, date, dpto, actividad, salidaT);
		//}
	}

	public boolean existeInscrip(String salidaT, String turista) {
		Usuario user = mu.getUsuarioNickname(turista);
		return ((Turista) user).existeInscripcion(salidaT);
	}

	public Map<String, Actividad> getActividadesAceptadas(String nombreUser) {

		Proveedor prov = (Proveedor) mu.getUsuarioNickname(nombreUser);

		HashMap<String, Actividad> res = new HashMap<String, Actividad>();

		for (Entry<String, Actividad> ac : prov.getActividades().entrySet()) {
			if (ac.getValue().getEstado() == EstadoActividad.Aceptada) {
				res.put(ac.getKey(), ac.getValue());
			}
		}

		return res;
	}
	
	public boolean verificarContrasenia(String nickOMail, String contrasenia) {
		return (getUsuario(nickOMail).getContrasena().equals(contrasenia));
	}

}
