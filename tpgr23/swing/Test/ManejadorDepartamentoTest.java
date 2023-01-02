package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import logica.Departamento;
import logica.ManejadorDepartamento;

public class ManejadorDepartamentoTest {

	@Test
	public void testInfoDepartamento() {
		ManejadorDepartamento md = ManejadorDepartamento.getInstancia();
		Departamento dep = new Departamento("testInfoDep", "Descripcion", "URL");
		md.addDepartamento(dep);
		Departamento dep2 = md.getDepartamento("testInfoDep");
		assertEquals("Funciona getDesc", dep2.getDescripcion(), "Descripcion");
		assertEquals("Funciona getUrl", dep2.getUrl(), "URL");
	}

}
