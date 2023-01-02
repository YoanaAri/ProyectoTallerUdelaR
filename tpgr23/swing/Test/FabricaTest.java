package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import logica.Fabrica;
import logica.IControladorDepartamentos;
import logica.IControladorUsuario;

public class FabricaTest {

	@Test
	public void testFabrica() {
		IControladorDepartamentos icd = Fabrica.getInstance().getIControladorDepartamentos();
		assertFalse("ICD generado correctamente", icd == null);
		
		IControladorUsuario icu = Fabrica.getInstance().getIControladorUsuario();
		assertFalse("ICU generado correctamente", icu == null);
	}

}
