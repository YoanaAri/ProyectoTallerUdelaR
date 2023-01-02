package Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import jakarta.xml.bind.annotation.XmlAccessorType;
import logica.Actividad;
import logica.Departamento;
import logica.Inscripcion;
import logica.Usuario;
import jakarta.xml.bind.annotation.XmlAccessType;


@XmlAccessorType(XmlAccessType.FIELD)
public abstract class DTUsuario {
	
	private String nickname;
	private String name;
	private String lastName;
	private String mail;
	private String contrasena;
	private LocalDate date;
	private String dateString;

	public DTUsuario(String nickname, String name, String lastName, String mail, LocalDate date, String contrasena) {
		
		this.nickname = nickname;
		this.name = name;
		this.lastName = lastName;
		this.mail = mail;
		this.date = date;
		this.contrasena=contrasena;
		this.dateString = date.toString();
	};
	
	public DTUsuario( Usuario user) {
		
		this.nickname = user.getNickname();
		this.name = user.getnombre();
		this.lastName = user.getapellido();
		this.mail = user.getMail();
		this.date = user.getFecha();
		this.contrasena= user.getContrasena();
		this.dateString = date.toString();		
	}
	
	public String getNickname() {
		return this.nickname;
	}
	
	public String getMail() {
		return this.mail;
	}
	public String getnombre() {
		return this.name;
	}
	public String getapellido() {
		return this.lastName;
	}
	public LocalDate getFecha() {
		return this.date;
	}
	
	public String getContrasena() {
		return this.contrasena;
	}
	 
	public String getDateString() {
	    return this.dateString;
	}
	
	public void setNickname(String nick) {
		 this.nickname = nick;
	}
	
	public void setMail(String email) {
		 this.mail = email;
	}
	public void setnombre(String nombre) {
		 this.name = nombre;
	}
	public void setapellido(String apellido) {
		 this.lastName = apellido;
	}
	public void setFecha(LocalDate fecha) {
		 this.date = fecha;
	}
	
	public void setContrasena(String pass) {
		 this.contrasena = pass;
	}
}
