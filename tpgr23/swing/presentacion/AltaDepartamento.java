package presentacion;
import javax.swing.*;
import logica.*;
import java.awt.event.*;
import java.util.Scanner;

public class AltaDepartamento extends JInternalFrame {
	JInternalFrame activo = this;
	String name, descripcion, url;
    Scanner sc = new Scanner(System.in);
	public AltaDepartamento(IControladorDepartamentos ICD) {
        boolean flag = true;

        while (flag) {
	        System.out.print("Ingrese Nombre de Departamento:");
	        name = sc.nextLine();
	        flag = ICD.existeDepartamento(name);
	        if (flag) {
	        	System.out.println("Ya existe un Departamento con ese nombre");
	        }
	        if (name.isBlank()) {
	        	System.out.println("No se puede dejar este campo vacio");
	        	flag = true;
	        }


        }
        System.out.printf("%n");
        flag = true;
        
        while(flag) {
        	System.out.print("Ingrese Descripcion de Departamento:");
        	descripcion = sc.nextLine();
        	flag = (descripcion.isBlank());
        	if (flag) {
	        	System.out.println("No se puede dejar este campo vacio");
        	}
        }
        System.out.printf("%n");
        flag = true;
        
		while (flag) {
        	System.out.print("Ingrese URL de Departamento:");
        	url = sc.nextLine();
        	flag = (url.isBlank());
        	if (flag) {
	        	System.out.println("No se puede dejar este campo vacio");
        	}
        }
        System.out.printf("%n");
        
        ICD.altaDepartamento(name, descripcion, url);
        System.out.println("Se ha registrado con Exito el Departamento");

        
	}
	

}
