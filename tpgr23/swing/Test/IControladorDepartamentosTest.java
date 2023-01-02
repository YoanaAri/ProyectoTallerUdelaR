package Test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.junit.Test;

import logica.Actividad;
import logica.DTInfo;
import logica.Fabrica;
import logica.IControladorDepartamentos;
import logica.IControladorUsuario;
import logica.Proveedor;

public class IControladorDepartamentosTest {
	//Objetos para Testear
	IControladorDepartamentos icd = Fabrica.getInstance().getIControladorDepartamentos();
	IControladorUsuario icu = Fabrica.getInstance().getIControladorUsuario();
	DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd"); 
	DateTimeFormatter df2 = DateTimeFormatter.ofPattern("yyyyMMddmmss"); 
	LocalDate fechaAlta = LocalDate.parse("20220829", df);
	LocalDateTime fechaAlta2 = LocalDateTime.now();
	DTInfo info = new DTInfo(fechaAlta2, "DTInfoLugar");
	
	Actividad acti = new Actividad("ActividadNombre", "ActividadDescripcion", 12, 12, "ActividadCiudad", fechaAlta);
	@Test
	public void testAltaDepartamento() {
		icd.altaDepartamento("DepartamentoNombre", "DepartamentoDescripcion", "DepartamentoURL");
		assertTrue("Funciona Alta Departamento", icd.existeDepartamento("DepartamentoNombre"));
		assertFalse("Funciona Alta Departamento", icd.existeDepartamento("DepartamentoNoExistente"));
	}

	@Test
	public void testGetSetDepartamentos() {
		int tamanio = 1;
		for (int i = 1; i < 2000; i++) {
			icd.altaDepartamento("DepartamentoNombre" + i, "DepartamentoDescripcion", "DepartamentoURL");
			tamanio = i;
		}
		assertTrue("Obtener Set Departamentos funciona", icd.getSetDepartamentos().size() >= tamanio);
	}

	@Test
	public void testAltaActividad() {
		icd.altaDepartamento("DepAltaAT", "DepartamentoDescripcion", "DepartamentoURL");
		icu.altaProveedor("ProveedorAltaAT", "ProveedorNombre", "ProveedorApellido", "ProveedorCorreo", fechaAlta, "ProveedorDesc", "ProveedorLink", "pass");
		icd.altaActividad("DepAltaAT", "ProveedorAltaAT", "ActividadNombre", "DescripcionNombre", 12, 12, "Ciudad", fechaAlta, null);
		Map<String, Actividad> actividadesPorDep = icd.getActividadesXDep("DepAltaAT");
		assertEquals("Alta Actividad funciona", "ActividadNombre", actividadesPorDep.get("ActividadNombre").getName());
	}

	@Test
	public void testExisteActividadEnDepartamento() {
		icd.altaDepartamento("DepATEnDep", "DepartamentoDescripcion", "DepartamentoURL");
		icu.altaProveedor("ProveedorATEnDep", "ProveedorNombre", "ProveedorApellido", "ProveedorCorreo", fechaAlta, "ProveedorDesc", "ProveedorLink", "abcd");
		icd.altaActividad("DepATEnDep", "ProveedorATEnDep", "ActividadEnDep", "DescripcionNombre", 12, 12, "Ciudad", fechaAlta, null);
		assertEquals("Funciona Dep para Actividad", "DepATEnDep", icd.getDepartamentoXActividad("ActividadEnDep"));
		assertTrue("Funciona Existe AT en Departamento si existe", icd.existeActividadEnDepartamento("ActividadEnDep", "DepATEnDep"));
		assertFalse("Funciona Existe AT en Departamento si no existe", icd.existeActividadEnDepartamento("ActividadEnDep", "DepATEnDep23"));
	}

	@Test
	public void testCrearSalida() {
		icd.altaDepartamento("DepCrearSalida", "DepartamentoDescripcion", "DepartamentoURL");
		icu.altaProveedor("ProveedorCrearSalida", "ProveedorNombre", "ProveedorApellido", "ProveedorCorreo", fechaAlta, "ProveedorDesc", "ProveedorLink", "taller");
		icd.altaActividad("DepCrearSalida", "ProveedorCrearSalida", "ActividadNombre", "DescripcionNombre", 12, 12, "Ciudad", fechaAlta, null);
		icd.altaActividad("DepCrearSalida", "ProveedorCrearSalida", "ActividadNombre2", "DescripcionNombre", 12, 12, "Ciudad", fechaAlta, null);
		
		info.setFecha(fechaAlta2);
		info.setLugarSalida("mi casa");
		
		icd.crearSalida("DepCrearSalida", "ActividadNombre", "Salida", info, fechaAlta2, 2);
		icd.crearSalida("DepCrearSalida", "ActividadNombre", "Salida2", info, fechaAlta2, 2);
		assertEquals("Funciona testCrearSalida", "ActividadNombre", icd.getActividadXSalida("Salida"));
		assertEquals("Funciona testCrearSalida", "Salida", icd.getActividadesXDep("DepCrearSalida").get("ActividadNombre").getSalida("Salida").getNombre());
		assertTrue("Funciona existeSalida", icd.existeSalida("Salida"));
		assertEquals("Funciona SalidasXActi", icd.getSalidaXActividadDepto("DepCrearSalida", "ActividadNombre").size(), 2);
		
		Proveedor prov = (Proveedor) icu.getUsuario("ProveedorCrearSalida");
		assertTrue( prov.getSalidas().get("Salida").getNombre()=="Salida" );
		assertTrue( prov.getdescripcion()== "ProveedorDesc");
		assertTrue ( prov.getLink()=="ProveedorLink");
		assertTrue( info.getFecha().equals(fechaAlta2));
		assertTrue( info.getLugarSalida()=="mi casa");
	}
}
