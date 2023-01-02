package logica;

import java.time.*;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

public class Usuario{
	
	private String nickname;
	private String name;
	private String lastName;
	private String mail;
	private String contrasena;
	private LocalDate date;
	private String dateString;
	
	public Usuario(String nickname, String name, String lastName, String mail, LocalDate date, String contrasena2) {
		this.nickname = nickname;
		this.name = name;
		this.lastName = lastName;
		this.mail = mail;
		this.date = date;
		this.contrasena=contrasena2;
		this.dateString = date.toString();
	}
	
	public String getNickname() {
		return this.nickname;
	}
	
	public String getMail() {
		return this.mail;
	}
	///////////////////////////////
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
	//////////////////////////////////
//	public boolean esTurista() {
//		return this.getClass() == Turista.class;
//	}
}