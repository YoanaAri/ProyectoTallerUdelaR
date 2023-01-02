package logica;

import java.time.*;
import java.util.Map;
import java.util.Set;

public interface IControladorUsuario {

	public abstract void altaTurista(String nickname, String name, String lastName, String mail, LocalDate date, String nacionalidad, String contrasena);
	public abstract void altaProveedor(String nickname, String name, String lastName, String mail, LocalDate date, String descG, String link, String contrasena);
	public Set<String> getSetProveedor();
	public abstract boolean existeNickname(String nickname);
	public abstract boolean existeMail(String mail);
	public abstract Set<String> getTuristas();
	public abstract Set<String> getProveedores();
	public abstract void registrarInscrip(int cant, LocalDateTime date, String dpto, String actividad, String salidaT, String turista);
	public abstract boolean existeInscrip(String salidaT, String turista);
	public abstract Map<String, Usuario> getUsuario();
	public abstract Usuario getUsuario(String nick);
	public abstract Map<String, SalidaTuristica> getSalidasUsu(String nick);
	public abstract Map<String, Actividad> getAvtividadesUsu(String nick);
	public abstract Map<String, Actividad> getActividadesAceptadas(String nombreUser);

}
