package Test;
import java.time.*;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;

import org.junit.Test;

import logica.Actividad;
import logica.DTInfo;

public class ActividadTest {
	
	DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd"); 
	DateTimeFormatter df2 = DateTimeFormatter.ofPattern("yyyyMMddmmss"); 
	LocalDate fechaAlta = LocalDate.parse("20220829", df);
	LocalDateTime fechaAlta2 = LocalDateTime.now();
	DTInfo info = new DTInfo(fechaAlta2, "DTInfoLugar");
	Actividad acti = new Actividad("ActividadNombre", "ActividadDescripcion", 12, 12, "ActividadCiudad", fechaAlta);
	@Test
	public void testActividad() {
		Actividad acti2 =  new Actividad("ActividadNombre", "ActividadDescripcion", 12, 12, "ActividadCiudad", fechaAlta);
		assertEquals("El constructor funciona", acti.getName(), acti2.getName());
	}

	@Test
	public void testGets() {
		assertEquals("Obtener el Nombre de Actividad Funciona", "ActividadNombre", acti.getName());
		assertEquals("Obtener la Desc de Actividad Funciona", "ActividadDescripcion", acti.getDescripcion());
		assertEquals("Obtener la Duracion de Actividad Funciona", 12, acti.getDuracion());
		assertEquals("Obtener el Costo de Actividad Funciona", 12, acti.getCosto());
		assertEquals("Obtener la Ciudad de Actividad Funciona", "ActividadCiudad", acti.getCiudad());
		assertEquals("Obtener la Fecha", fechaAlta, acti.getFechaAlta());
		
	}

	@Test
	public void testAltaSalida() {
		acti.altaSalida("SalidaNombre", info, fechaAlta2, 12);
		assertEquals("Alta Salida funciona", acti.getSalida("SalidaNombre").getNombre(), "SalidaNombre");
	}

	@Test
	public void testExisteSalida() {
		acti.altaSalida("SalidaNombre", info, fechaAlta2, 12);
		assertTrue("Existe Salida funciona", acti.existeSalida("SalidaNombre"));
	}

	@Test
	public void testGetSalidas() {
		acti.altaSalida("SalidaNombre2", info, fechaAlta2, 12);
		acti.altaSalida("SalidaNombre3", info, fechaAlta2, 12);
		acti.altaSalida("SalidaNombre4", info, fechaAlta2, 12);
		assertTrue("GetSalidas funciona", acti.getSalidas().size() >= 3);
	}


}
