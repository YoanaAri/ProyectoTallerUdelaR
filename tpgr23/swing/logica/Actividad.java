package logica;
import java.util.*;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

import java.time.*;

public class Actividad {
	private String name;
	private String descripcion;
	private int duracion;
	private int costo;
	private String ciudad;
	private LocalDate fechaAlta;
	private String fechaAltaString;
	private HashMap<String, SalidaTuristica> salidas;
	private HashMap<String, Categoria> categorias;
	private EstadoActividad estado;

	public Actividad(String name, String descripcion, int duracion, int costo, String ciudad, LocalDate fechaAlta) {
		this.name = name;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.costo = costo;
		this.ciudad = ciudad;
		this.fechaAlta = fechaAlta;
		this.salidas = new HashMap<String, SalidaTuristica>();
		this.categorias = new HashMap<String, Categoria>();
		this.estado = EstadoActividad.Agregada;
		this.fechaAltaString = fechaAlta.toString();
	}

	public String getName() {
		return name;
	}

	public String getDescripcion() {
		return descripcion;
	}
	public int getDuracion() {
		return duracion;
	}

	public int getCosto() {
		return costo;
	}

	public String getCiudad() {
		return ciudad;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void altaSalida(String nombre, DTInfo lugar, LocalDateTime fecha, int cupos) {
		SalidaTuristica s = new SalidaTuristica(nombre, lugar, cupos, fecha);
		salidas.put(nombre, s);
	}

	public boolean existeSalida(String nombre) {
		return salidas.containsKey(nombre);
	}
	public HashMap<String, SalidaTuristica> getSalidas() {
		return salidas;
	}

	public SalidaTuristica getSalida(String nombre) {
		return salidas.get(nombre);
	}

	public Map<String, SalidaTuristica> getSalidasXfecha(LocalDateTime today) {
		Map<String, SalidaTuristica> sali = new HashMap<String, SalidaTuristica>();
		for (Map.Entry<String, SalidaTuristica> sal : salidas.entrySet()) {
			if (sal.getValue().getFechaSalida().isAfter(today))
				sali.put(sal.getKey(), sal.getValue());
		}
		return sali;
	}

	public HashMap<String, Categoria> getcategorias() {
		return categorias;
	}

	public Set<String> getCategoriasDeActividad() {
		return categorias.keySet();
	}

	public void setEstado(EstadoActividad est) {
		this.estado = est;
	}

	public EstadoActividad getEstado() {
		return estado;
	}

	public void addCategoria(String string, Categoria cat) {
		// TODO Auto-generated method stub
		categorias.put(string, cat);

	}
}
