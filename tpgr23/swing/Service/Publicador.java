package Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Publicador {
	public static void publicar() throws IOException {
		try {
			InputStream input = new FileInputStream(System.getProperty("user.home")+File.separator+".turismoUy"+File.separator+"config.properties");
			Properties propiedades = new Properties();
			propiedades.load(input);
			String puertoDep =(String) propiedades.get("puertoDep");
			String puertoDepM =(String) propiedades.get("puertoDepM");
			String puertoUsu =(String) propiedades.get("puertoUsu");
			String puertoUsuM =(String) propiedades.get("puertoUsuM");
			DepartamentoService WebServiceDep= new DepartamentoService();
			UsuarioService WebServiceUsu= new UsuarioService();
			String urlDep="http://localhost:"+puertoDep+"/DepartamentoService";
			String urlUsu="http://localhost:"+puertoUsu+"/UsuarioService";
			String urlDepM="http://localhost:"+puertoDepM+"/DepartamentoService";
			String urlUsuM="http://localhost:"+puertoUsuM+"/UsuarioService";
			WebServiceDep.publicar(urlDep);
			WebServiceUsu.publicar(urlUsu);
			WebServiceDep.publicar(urlDepM);
			WebServiceUsu.publicar(urlUsuM);
		
		
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			DepartamentoService WebServiceDep= new DepartamentoService();
			UsuarioService WebServiceUsu= new UsuarioService();
			String urlDep="http://localhost:8969/DepartamentoService";
			String urlUsu="http://localhost:7969/UsuarioService";
			String urlDepM="http://localhost:8970/DepartamentoService";
			String urlUsuM="http://localhost:7970/UsuarioService";
			WebServiceDep.publicar(urlDep);
			WebServiceUsu.publicar(urlUsu);
			WebServiceDep.publicar(urlDepM);
			WebServiceUsu.publicar(urlUsuM);
		}
		//crearProp.crear();
		
		
	}

}
