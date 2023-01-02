package logica;
import java.util.*;
import java.time.*;

public interface IControladorDepartamentos {
		public abstract void altaDepartamento(String nombre, String descripcion, String url);
		public abstract Set<String> getSetDepartamentos();
		public abstract void altaCategoria(String nombre);
		public abstract Set<String> getCategorias();
		public abstract Map<String, Categoria> getMapCategorias(); 
		public abstract void altaActividad(String dep, String prov, String name, String descripcion, int duracion, int costo, String ciudad, LocalDate fechaAlta, List<String> categorias);
		public abstract boolean existeDepartamento(String name);
		public abstract boolean existeActividadEnDepartamento(String nameActividad, String nameDepartamento);
		public abstract Map<String, Actividad> getActividadesXDep(String departamento);
		public abstract void crearSalida(String dep, String act, String nombreSalida, DTInfo lugarSalida, LocalDateTime fecha, int cupos);
		public abstract boolean existeSalida(String sal);
		public abstract Map<String, SalidaTuristica> getSalidaXActividadDepto(String dep, String act);
		public abstract Map<String, SalidaTuristica> getsalidas();
		public abstract String getDepartamentoXActividad(String actividad);
		public abstract String getActividadXSalida(String salida);
		public abstract Map<String, SalidaTuristica> getSalidasXFecha(String dep, String act, LocalDateTime today);
		public abstract SalidaTuristica getSalidaXActividad(String sal, String act, String dpto);
		public abstract Map<String, Actividad> getActividadesAgregadas();
		public abstract Map<String, Actividad> getActividadesAceptadas();
		public abstract void aceptarActividad(String nameAct, EstadoActividad estado);
		public abstract void agregarActividadACategoria(String nombreAct, String nombreCat);
		public abstract Actividad encontrarActividad(String nombreActividad);
		public abstract SalidaTuristica getSalidaNombre(String nombreSalida);
		public abstract boolean existeCategoria(String nombreCat);
		public abstract Map<String, Actividad> getActividadesXCat(String nombreCat);
		public abstract Map<String, Actividad> getActividadesAgregadasXDep(String dep); //son las aceptadas
		public abstract Map<String, Actividad> getActividadesAceptadasSinSalida();
		public abstract void finalizarActividad(String actividad);
}
