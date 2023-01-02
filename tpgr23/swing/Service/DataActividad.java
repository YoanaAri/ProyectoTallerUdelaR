package Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAccessType;
import logica.Actividad;
import logica.Categoria;
import logica.DTSalida;
import logica.EstadoActividad;
import logica.SalidaTuristica;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataActividad {
	private String name;
	private String descripcion;
	private int duracion;
	private int costo;
	private String ciudad;
	private LocalDate fechaAlta;
	private List<DTSalida> salidas;
	private List<String> categorias;
	private EstadoActividad estado;
	
	
	public DataActividad() {
		
	}
	public DataActividad(String name, String descripcion,int duracion, int costo, String ciudad,LocalDate fechaAlta) {
		this.name=name;
		this.descripcion=descripcion;
		this.duracion=duracion;
		this.costo=costo;
		this.ciudad=ciudad;
		this.salidas = new ArrayList<DTSalida>();
		this.categorias = new ArrayList<String>();
		this.estado=estado.Agregada;
	}
	public DataActividad(Actividad act) {
		this.name=act.getName();
		this.descripcion=act.getDescripcion();
		this.duracion=act.getDuracion();
		this.costo=act.getCosto();
		this.ciudad=act.getCiudad();
		this.salidas = new ArrayList<DTSalida>();
		for(Map.Entry<String, SalidaTuristica> salida : act.getSalidas().entrySet()) {
			this.salidas.add(salida.getValue().getDTSalida());
		}
		this.categorias = new ArrayList<String>();
		for(Map.Entry<String, Categoria> categoria : act.getcategorias().entrySet()) {
			this.categorias.add(categoria.getKey());
		}
		this.estado=act.getEstado();
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
	
	public List<String> getCategorias() {
		return categorias;
	}
	
	public List<DTSalida> getSalidas() {
		return salidas;
	}
	
}
