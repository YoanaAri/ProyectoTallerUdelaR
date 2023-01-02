package Service;



//import java.util.Set;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.ParameterStyle;
import jakarta.jws.soap.SOAPBinding.Style;
import jakarta.xml.ws.Endpoint;
/*
import logica.Actividad;
import logica.ControladorUsuario;
import logica.DTInfo;
import logica.SalidaTuristica;
import logica.Usuario;
*/
import logica.*;

@WebService
@SOAPBinding(style= Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class UsuarioService {
	private ControladorUsuario ctrlUsu = new ControladorUsuario();
	private Endpoint endpoint=null;
	
	public void UsuarioService() {
		
	}
	
	@WebMethod(exclude = true)
	public void publicar(String url){
		endpoint= Endpoint.publish(url, this);
		
	}
	
	@WebMethod(exclude = true)
	public Endpoint getendpoint() {
		return this.endpoint;
	}
	
	@WebMethod
	//public void altaTuristaService(String nickname, String name, String lastName, String mail, LocalDate date, String nacionalidad, String contrasena) {
	public void altaTuristaService(String nickname, String name, String lastName, String mail, String fecha, String nacionalidad, String contrasena) {
		LocalDate date = LocalDate.parse(fecha);
		ctrlUsu.altaTurista(nickname, name, lastName, mail, date, nacionalidad, contrasena);
	}
	
	@WebMethod
	public void altaProveedorService(String nickname, String name, String lastName, String mail, String fecha, String descG, String link, String contrasena) {
		LocalDate date = LocalDate.parse(fecha);
		ctrlUsu.altaProveedor(nickname, name, lastName, mail, date, descG, link, contrasena);
	}
	
	@WebMethod
	public ListaString getSetProveedorService() {
		return new ListaString(ctrlUsu.getSetProveedor());
	}
	
	@WebMethod
	public boolean existeNicknameService(String nickname) {
		return ctrlUsu.existeNickname(nickname);
	}
	
	@WebMethod
	public boolean existeMailService(String mail) {
		return ctrlUsu.existeMail(mail);
	}
	
	@WebMethod
	public ListaString getTuristasService() {
		return new ListaString(ctrlUsu.getTuristas());
	}
	
	@WebMethod
	public ListaString getProveedoresService() {
		return new ListaString(ctrlUsu.getProveedores());
	}
	
	@WebMethod
	public void registrarInscripService(int cant, String fecha, String dpto, String actividad, String salidaT, String turista) {
		LocalDateTime date = LocalDateTime.parse(fecha);
		ctrlUsu.registrarInscrip(cant, date, dpto, actividad, salidaT, turista);
	}
	
	@WebMethod
	public boolean existeInscripService(String salidaT, String turista) {
		return ctrlUsu.existeInscrip(salidaT, turista);
	}
	
	@WebMethod
	public DataMapUsuario getUsuarioService() {
		return new DataMapUsuario(ctrlUsu.getUsuario());
	}
	
	@WebMethod
	public DTUsuario getUsuarioNickService(String nick) {
		if(ctrlUsu.getUsuario(nick).getClass() == Turista.class) {
			return (DTUsuario) new DTTurista((Turista) ctrlUsu.getUsuario(nick));
		}
		else {
			return (DTUsuario) new DTProveedor((Proveedor) ctrlUsu.getUsuario(nick));
		}
	}
	
	@WebMethod
	public DataMapSalida getSalidasUsuService(String nick) {
		return new DataMapSalida(ctrlUsu.getSalidasUsu(nick));
	}
	
	@WebMethod
	public DataMapActividad getAvtividadesUsuService(String nick) {
		return new DataMapActividad(ctrlUsu.getAvtividadesUsu(nick));
	}
	
	@WebMethod
	public DataMapActividad getActividadesAceptadasService(String nombreUser) {
		return new DataMapActividad(ctrlUsu.getActividadesAceptadas(nombreUser));
	}
	
	@WebMethod
	public boolean verificarContrasenia(String nickOMail, String contrasenia) {
		return (ctrlUsu.getUsuario(nickOMail).getContrasena().equals(contrasenia));
	}
	
	@WebMethod
	public boolean esTurista(String nickname) {
		return ctrlUsu.getUsuario(nickname).getClass() == Turista.class;
	}
	
	@WebMethod 
    public DTTurista getTurista(String nickname) {

        if ( ctrlUsu.getUsuario(nickname).getClass() == Turista.class ) {
            return new DTTurista((Turista) ctrlUsu.getUsuario(nickname));
        } else {
            return null;
        }
    }

    @WebMethod 
    public DTProveedor getProveedor(String nickname) {

        if ( ctrlUsu.getUsuario(nickname).getClass() == Proveedor.class ) {
            return new DTProveedor((Proveedor) ctrlUsu.getUsuario(nickname));
        } else {
            return null;
        }
    }
}
