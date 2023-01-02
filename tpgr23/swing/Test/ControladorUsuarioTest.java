package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;

import logica.Actividad;
import logica.DTInfo;
import logica.EstadoActividad;
import logica.Fabrica;
import logica.IControladorDepartamentos;
import logica.IControladorUsuario;
import logica.ManejadorDepartamento;
import logica.SalidaTuristica;
import logica.Turista;
import logica.Usuario;

class ControladorUsuarioTest {
	
	private static IControladorUsuario cu;
	private static IControladorDepartamentos cd;

	@BeforeAll
	public static void iniciar() {
		Fabrica fabrica = Fabrica.getInstance();
		cu = fabrica.getIControladorUsuario();
		cd = fabrica.getIControladorDepartamentos();
	}
	

	@Test
	void testAltaTurista() {
		LocalDate date = LocalDate.of(1995, 6, 8);
		cu.altaTurista("ari", "yoana", "aristimuno","ya@gmail.com", date, "uruguay", "1234");
		assertTrue(cu.existeNickname("ari"));
		
		LocalDate date2 = LocalDate.of(1995, 7, 31);
		cu.altaTurista("pepe", "yoana", "aristimuno","pepe@gmail.com", date2, "uruguay", "12345");
		assertEquals(cu.getTuristas().size(), 2);
	}

	@Test
	void testAltaProveedor() {
		LocalDate date = LocalDate.of(1995, 6, 8);
		cu.altaProveedor("ari", "yoana", "aristimuno","ya@gmail.com", date, "ventas","link", "123");
		assertTrue(cu.existeMail("ya@gmail.com"));
		
		LocalDate date2 = LocalDate.of(1995, 7, 31);
		cu.altaProveedor("pepe", "yoana", "aristimuno","pepe@gmail.com", date2, "ventas","link", "123ew");
		assertEquals(cu.getProveedores().size(), 2);
		
	}

	@Test
	void testGetSetProveedor() {
		LocalDate date = LocalDate.of(1995, 6, 8);
		cu.altaProveedor("ari", "yoana", "aristimuno","ya@gmail.com", date, "ventas","link", "1234");
		
		LocalDate date2 = LocalDate.of(1995, 7, 31);
		cu.altaProveedor("pepe", "yoana", "aristimuno","pepe@gmail.com", date2, "ventas","link", "1234");
		assertEquals(cu.getSetProveedor().size(), 2);
	}

	@Test
	void testRegistrarInscrip() {
		cd.altaDepartamento("montevideo", "re lindo", "si");
		LocalDate date2 = LocalDate.of(1995, 7, 31);
		cu.altaProveedor("pepe", "yoana", "aristimuno","pepe@gmail.com", date2, "ventas","link", "abcd");
		LocalDateTime date = LocalDateTime.of(1995, 6, 8, 1, 1, 0);
		cd.altaActividad("montevideo", "pepe", "salir", "salida", 2, 350, "montevideo", date2, null);
		cd.aceptarActividad("salir", EstadoActividad.Aceptada);
		DTInfo dti = new DTInfo(date, "plaza cagancha");
		cd.crearSalida("montevideo", "salir", "s1", dti, date, 5);
		LocalDate date3 = LocalDate.of(1995, 6, 8);
		cu.altaTurista("ari", "yoana", "aristimuno","ya@gmail.com", date3, "uruguay", "abcde");
		cu.registrarInscrip(3, date, "montevideo", "salir", "s1", "ari");
		assertTrue(cu.existeInscrip("s1", "ari"));
	}
	
	@Test
	void testgetSalidasUsu() {
		cd.altaDepartamento("montevideo", "re lindo", "si");
		LocalDate date2 = LocalDate.of(1995, 7, 31);
		cu.altaProveedor("pepe", "yoana", "aristimuno","pepe@gmail.com", date2, "ventas","link", "hola");
		LocalDateTime date = LocalDateTime.of(1995, 6, 8, 1, 1, 0);
		cd.altaActividad("montevideo", "pepe", "salir", "salida", 2, 350, "montevideo", date2, null);
		cd.aceptarActividad("salir", EstadoActividad.Aceptada);
		DTInfo dti = new DTInfo(date, "plaza cagancha");
		cd.crearSalida("montevideo", "salir", "s1", dti, date, 5);
		LocalDate date3 = LocalDate.of(1995, 6, 8);
		cu.altaTurista("ari", "yoana", "aristimuno","ya@gmail.com", date3, "uruguay", "tprog");
		cu.registrarInscrip(3, date, "montevideo", "salir", "s1", "ari");
		
		Map<String,SalidaTuristica> salidasDesdeUsu = cu.getSalidasUsu("ari");
		assertTrue(salidasDesdeUsu.containsKey("s1"));
		assertEquals("Funciona dtsalida", cd.encontrarActividad("salir").getSalida("s1").getDTSalida().getCupos(), 5);
		assertEquals("Funciona dtsalida", cd.encontrarActividad("salir").getSalida("s1").getDTSalida().getNombre(), "s1");
		
	}
	
	@Test
	void testgetAvtividadesUsu() {
		cd.altaDepartamento("montevideo", "re lindo", "si");
		LocalDate date2 = LocalDate.of(1995, 7, 31);
		cu.altaProveedor("pepe", "yoana", "aristimuno","pepe@gmail.com", date2, "ventas","link", "taller");
		LocalDateTime date = LocalDateTime.of(1995, 6, 8, 1, 1, 0);
		cd.altaActividad("montevideo", "pepe", "salir", "salida", 2, 350, "montevideo", date2, null);
		cd.aceptarActividad("salir", EstadoActividad.Aceptada);
		DTInfo dti = new DTInfo(date, "plaza cagancha");
		cd.crearSalida("montevideo", "salir", "s1", dti, date, 5);
		LocalDate date3 = LocalDate.of(1995, 6, 8);
		cu.altaTurista("ari", "yoana", "aristimuno","ya@gmail.com", date3, "uruguay", "pass");
		cu.registrarInscrip(3, date, "montevideo", "salir", "s1", "ari");
		
		Map<String,Actividad> actividadesDesdeUsu = cu.getAvtividadesUsu("pepe");
		assertTrue(actividadesDesdeUsu.containsKey("salir"));
	}
	
	@Test
	public void testInfoCategoria() {
		

		ManejadorDepartamento md = ManejadorDepartamento.getInstancia();
		md.setCategoria("Cat1");
		md.setCategoria("Cat2");
		
		cd.altaDepartamento("montevideo", "re lindo", "si");
		LocalDate date2 = LocalDate.of(1995, 7, 31);
		cu.altaProveedor("pepe", "yoana", "aristimuno","pepe@gmail.com", date2, "ventas","link", "abcd");
		LocalDateTime date = LocalDateTime.of(1995, 6, 8, 1, 1, 0);
		cd.altaActividad("montevideo", "pepe", "salir", "salida", 2, 350, "montevideo", date2, null);
		cd.aceptarActividad("salir", EstadoActividad.Aceptada);
		
		cd.agregarActividadACategoria("salir", "Cat1");
		cd.agregarActividadACategoria("salir", "Cat2");
		
		
		assertEquals("Funciona setCat", md.getCategoria("Cat1").getnombre(), "Cat1");
		assertEquals("Funciona getActividad", md.getCategoria("Cat1").getactividades().get("salir").getName(), "salir" );
		assertEquals("Funciona agregarAct", cd.getMapCategorias().size(), 2);
		assertEquals("Funciona act", cd.getMapCategorias().get("Cat1").getnombre(), "Cat1");
		assertEquals("Funciona cat", cd.getMapCategorias().get("Cat1").getactividades().size(), 1);
		assertEquals("Funca  act", cd.getActividadesXCat("Cat1").get("salir").getCategoriasDeActividad().size(), 2 );
		assertEquals("Funk", cd.getMapCategorias().get("Cat2").getactividades().get("salir").getName(), "salir");
		assertTrue(cd.existeCategoria("Cat1"));
		assertTrue( cd.getActividadesXCat("Cat1").get("salir").getName() == "salir");
		
	}
	
	@Test
	public void testGetActividades() {
		
		cd.altaDepartamento("montevideo", "re lindo", "si");
		LocalDate date1 = LocalDate.of(1995, 7, 31);
		cu.altaProveedor("pepe", "yoana", "aristimuno","pepe@gmail.com", date1, "ventas","link", "abcd");
		
		LocalDateTime date2 = LocalDateTime.of(1995, 6, 8, 1, 1, 0);
		cd.altaActividad("montevideo", "pepe", "salir", "salida", 2, 350, "montevideo", date1, null);
		cd.aceptarActividad("salir", EstadoActividad.Aceptada);
		


		cd.altaActividad("montevideo", "pepe", "salir1", "salida", 2, 350, "montevideo", date1, null);
		cd.aceptarActividad("salir1", EstadoActividad.Aceptada);
		


		cu.altaProveedor("pepe", "yoana", "aristimuno","pepe@gmail.com", date1, "ventas","link", "abcd");

		cd.altaActividad("montevideo", "pepe", "salir2", "salida", 2, 350, "montevideo", date1, null);
		cd.aceptarActividad("salir2", EstadoActividad.Aceptada);
		
		cd.altaActividad("montevideo", "pepe", "salir3", "salida", 2, 350, "montevideo", date1, null);
		//cd.aceptarActividad("salir", EstadoActividad.Aceptada);
		
		DTInfo dti = new DTInfo(date2, "plaza cagancha");
		cd.crearSalida("montevideo", "salir", "s1", dti, date2, 5);
		
		
		assertEquals("Funciona agregar", cd.getActividadesAgregadasXDep("montevideo").size() , 3);
		assertEquals("Funciona agregar1", cd.getActividadesXDep("montevideo").size() , 4);
		assertEquals("Funciona agregar2", cd.getActividadesAgregadas().size(), 1);
		assertEquals("Funciona agregar3", cd.getActividadesAceptadas().size(), 3);
		assertEquals("Funciona agregar4", cd.getSalidaNombre("s1").getNombre(), "s1");
		assertEquals("Funciona agregar5", cd.encontrarActividad("salir").getName(), "salir");
		assertTrue(cd.getSalidaXActividad("s1", "salir", "montevideo").getNombre() == "s1");
		
	}
	
	@Test
	public void testGetUsuarios() {
		
		LocalDate date = LocalDate.of(1995, 6, 8);
		cu.altaProveedor("ari", "yoana", "aristimuno","ya@gmail.com", date, "ventas","link", "123");
		
		LocalDate date2 = LocalDate.of(1995, 7, 31);
		cu.altaProveedor("pepe", "yoana", "aristimuno","pepe@gmail.com", date2, "ventas","link", "123ew");
		

		cd.altaActividad("montevideo", "pepe", "salir2", "salida", 2, 350, "montevideo", date, null);
		cd.aceptarActividad("salir2", EstadoActividad.Aceptada);
		
		cd.altaActividad("montevideo", "pepe", "salir3", "salida", 2, 350, "montevideo", date, null);
		cd.aceptarActividad("salir3", EstadoActividad.Aceptada);
		
		assertEquals("Funciona get user map", cu.getUsuario().size(), 2);
		assertEquals("Funciona get  user nick", cu.getUsuario("ari").getNickname(), "ari");
		assertEquals("Funciona get actividades", cu.getActividadesAceptadas("pepe").size(), 2);
		
		
	}
	
	
}
