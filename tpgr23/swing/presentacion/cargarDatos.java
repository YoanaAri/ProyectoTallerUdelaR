package presentacion;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.JOptionPane;

import logica.*;

public class cargarDatos {
 

	public cargarDatos(IControladorUsuario icu, IControladorDepartamentos icd) {
		
		//CARGA DE USUARIOS

		icu.altaTurista("lachiqui", "Rosa MarÃ­a", "MartÃ­nez", "mirtha.legrand.ok@hotmail.com", LocalDate.of(1927, 2,23), "argentina", "awdrg543");
		icu.altaTurista("isabelita", "Elizabeth", "Windsor", "isabelita@thecrown.co.uk", LocalDate.of(1926, 4, 21), "inglesa", "r5t6y7u8");
		icu.altaTurista("anibal", "AnÃ­bal", "Lecter", "anibal@fing.edu.uy", LocalDate.of(1937, 12, 31), "lituana", "edrft543");
		icu.altaTurista("waston", "Emma", "Waston", "e.waston@gmail.com", LocalDate.of(1990, 4, 15), "inglesa", "poiuy987");
		icu.altaTurista("elelvis", "Elvis", "Lacio", "suavemente@hotmail.com", LocalDate.of(1971, 7, 30), "estadounidense", "45idgaf67");
		icu.altaTurista("eleven11", "Eleven", "Once", "eleven11@gmail.com", LocalDate.of(2004, 2, 19), "espaÃ±ola", "xdrgb657");
		icu.altaTurista("bobesponja", "Bob", "Esponja", "bobesponja@nickelodeon.com", LocalDate.of(1999, 5, 1), "japonesa", "sbsplol1");
		icu.altaTurista("tony", "Antionio", "Pachecho", "eltony@manya.org.uy", LocalDate.of(1976, 4, 11), "uruguaya", "okmnji98");
		icu.altaTurista("chino", "Alvaro", "Recoba", "chino@trico.org.uy", LocalDate.of(1976, 3, 17), "uruguaya", "qsxcdw43");
		icu.altaTurista("mastropiero", "Johann", "Sebastian", "johann.sebastian@gmail.com", LocalDate.of(1922, 2, 7), "austriaco", "qpwoci586");
		
		icu.altaProveedor("washington", "Washington", "Rocha", "washington@turismorocha.gub.uy", LocalDate.of(1970, 9, 14),
				"Hola! me llamo Washington y soy el encargado del portal de turismo del departamento de Rocha-Uruguay",
				"http://turismorocha.gub.uy/", "asdfg654");
		icu.altaProveedor("eldiez", "Pablo", "Bengoechea", "eldiez@socfomturriv.org.uy", LocalDate.of(1965, 6, 27),
				"Pablo es el presidente de la Sociedad de Fomento Turistico de Rivera (conocida "
				+ "como Socfomturriv)", "http://wwww.socfomturriv.org.uy/", "ytrewq10");
		icu.altaProveedor("meche", "Mercedes", "Venn", "meche@colonia.gub.uy", LocalDate.of(1990, 12, 31), 
				"Departamento de Turismo Del Departamento de Colonia", "https://colonia.gub.uy/turismo/", "mnjkiu89");
		
		///////////////////////////
	
		//CARGA DE DEPARTAMENTOS
		
		icd.altaDepartamento("Canelones", "Division Turismo de la Intendencia", "https://www.imcanelones.gub.uy/es");
		icd.altaDepartamento("Maldonado", "Division Turismo de la Intendencia", "https://www.maldonado.gub.uy/");
		icd.altaDepartamento("Rocha", "La Organizacion de Gestion del Destino\n"
				+ "(OGD) Rocha es un  ambito de articulacion\n"
				+ "publico â€“ privada en el sector turÄ±stico que in-\n"
				+ "tegran la Corporacion Rochense de Turismo\n"
				+ "y la Intendencia de Rocha a traves de su Di-\n"
				+ "reccion de Turismo.", "www.turismorocha.gub.uy");
		icd.altaDepartamento("Treinta y Tres", "Division Turismo de la Intendencia", "https://treintaytres.gub.uy/");
		icd.altaDepartamento("Cerro Largo", "Division Turismo de la Intendencia ", "https://www.gub.uy/intendencia-\n"
				+ "cerro-largo/");
		icd.altaDepartamento("Rivera", "Promociona e implementa proyectos e iniciati-\n"
				+ "vas sostenibles de interes turÄ±stico con la par-\n"
				+ "ticipacion institucional publica â€“ privada en\n"
				+ "bien del desarrollo socioeconomico de la co-\n"
				+ "munidad.", "www.rivera.gub.uy/social/turismo/");
		icd.altaDepartamento("Artigas", "Division Turismo de la Intendencia ", "http://www.artigas.gub.uy");
		icd.altaDepartamento("Salto", "Division Turismo de la Intendencia", "https://www.salto.gub.uy");
		icd.altaDepartamento("Paysandu", "Division Turismo de la Intendencia ", "https://www.paysandu.gub.uy");
		icd.altaDepartamento("Rio Negro", "Division Turismo de la Intendencia", "https://www.rionegro.gub.uy");
		icd.altaDepartamento("Soriano", "Division Turismo de la Intendencia", "https://www.soriano.gub.uy");
		icd.altaDepartamento("Colonia", "La propuesta del Departamento de Colonia\n"
				+ "divide en cuatro actos su espectaculo anual.\n"
				+ "Cada acto tiene su magia. Desde su naturaleza\n"
				+ "y playas hasta sus tradiciones y el patrimonio\n"
				+ "mundial. Todo el anio se disfruta.", "https://colonia.gub.uy/turismo/");
		icd.altaDepartamento("San Jose", "Division Turismo de la Intendencia ", "https://sanjose.gub.uy");
		icd.altaDepartamento("Flores", "Division Turismo de la Intendencia", "https://flores.gub.uy");
		icd.altaDepartamento("Florida", "Division Turismo de la Intendencia ", "http://www.florida.gub.uy");
		icd.altaDepartamento("Lavalleja", "Division Turismo de la Intendencia", "http://www.lavalleja.gub.uy");
		icd.altaDepartamento("Durazno", "Division Turismo de la Intendencia", "https://durazno.uy");
		icd.altaDepartamento("Tacuarembo", "Division Turismo de la Intendencia", "https://tacuarembo.gub.uy");
		icd.altaDepartamento("Montevideo", "Division Turismo de la Intendencia", "https://montevideo.gub.uy/areas-\n"
				+ "tematicas/turismo");
		
		
		/////////////////////////////////////////////
		// CARGA DE ACTIVIDADES
		
		icd.altaActividad("Rocha", "washington", "Degusta", "Festival gastronomico de productos locales en Rocha", 3, 800, "Rocha", LocalDate.of(2022, 7, 20), null);
		icd.aceptarActividad("Degusta", EstadoActividad.Aceptada);
		
		icd.altaActividad("Rocha", "washington", "Teatro con Sabores", "En el mes aniversario del Club Deportivo Union de Rocha te invitamos a una merienda deliciosa.", 3, 500, "Rocha", LocalDate.of(2022, 7, 21), null);
		icd.aceptarActividad("Teatro con Sabores", EstadoActividad.Aceptada);
		
		icd.altaActividad("Colonia", "meche", "Tour por Colonia del Sacramento", "Con guia especializado y en varios idiomas. Varios circuitos posibles.", 2, 400, "Colonia del Sacramento", LocalDate.of(2022, 8, 1), null);
		icd.aceptarActividad("Tour por Colonia del Sacramento", EstadoActividad.Aceptada);
		
		icd.altaActividad("Colonia","meche", "Almuerzo en el Real de San Carlos", "Restaurante en la renovada Plaza de Toros con men Ì�u internacional", 2, 800, "Colonia del Sacramento", LocalDate.of(2022, 8, 1), null);
		icd.aceptarActividad("Almuerzo en el Real de San Carlos", EstadoActividad.Aceptada);
		
		icd.altaActividad("Rivera", "eldiez", "Almuerzo en Valle del Lunarejo", "Almuerzo en la Posada con ticket fijo. Men Ì�u que incluye bebida y postre casero.", 2, 300, "Tranqueras", LocalDate.of(2022, 8, 1), null);
		icd.aceptarActividad("Almuerzo en Valle del Lunarejo", EstadoActividad.Aceptada);
		
		icd.altaActividad("Rivera", "eldiez", "Cabalgata en Valle del Lunarejo", "Cabalgata por el  Ì�area protegida. Varios recorridos para elegir.", 2, 150, "Tranqueras", LocalDate.of(2022, 8, 1), null);
		icd.aceptarActividad("Cabalgata en Valle del Lunarejo", EstadoActividad.Aceptada);
		
		icd.altaActividad("Colonia", "meche", "Bus turistico Colonia", "Recorrida por los principales atractivos de la ciudad" , 3, 600, "Colonia del Sacramento" ,LocalDate.of(2022, 9, 1), null);
		icd.aceptarActividad("Bus turistico Colonia", EstadoActividad.Agregada);
		
		icd.altaActividad("Colonia", "meche", "Colonia Premium Tour","Visita lugares exclusivos y relevantes" , 4, 2600, "Colonia del Sacramento", LocalDate.of(2022, 9, 3), null);
		icd.aceptarActividad("Colonia Premium Tour", EstadoActividad.Rechazada);
		
		icd.altaActividad("Rocha", "washington", "Deportes nauticos sin uso de motor", "kitsurf - windsurf - kayakismo - canotaje en Rocha", 3, 1200, "Rocha", LocalDate.of(2022, 9, 5), null);
		icd.aceptarActividad("Deportes nauticos sin uso de motor", EstadoActividad.Agregada);
		
		icd.altaActividad("Rivera", "eldiez", "Descubre Rivera", "Rivera es un departamento de extraordinaria riqueza natural patrimonial y cultural con una ubicacion geografica privilegiada", 2, 650, "Rivera", LocalDate.of(2022, 9, 16), null);
		icd.aceptarActividad("Descubre Rivera", EstadoActividad.Rechazada);
		
		///////////////////////////////////////////
		//CARGA DE CATEGORIAS
		icd.altaCategoria("Aventura y Deporte");
		icd.altaCategoria("Campo y Naturaleza");
		icd.altaCategoria("Cultura y Patrimonio");
		icd.altaCategoria("Gastronomia");
		icd.altaCategoria("Turismo y Playas");
		
		
		///////////////////////////////////////////
		//AGREGAR ACTIVIDAD A LAS CATEGORIAS
		
		icd.agregarActividadACategoria("Degusta", "Gastronomia");
		icd.agregarActividadACategoria("Teatro con Sabores", "Cultura y Patrimonio");
		icd.agregarActividadACategoria("Teatro con Sabores", "Gastronomia");
		icd.agregarActividadACategoria("Tour por Colonia del Sacramento", "Cultura y Patrimonio");
		icd.agregarActividadACategoria("Almuerzo en el Real de San Carlos", "Gastronomia");
		icd.agregarActividadACategoria("Almuerzo en Valle del Lunarejo", "Campo y Naturaleza");
		icd.agregarActividadACategoria("Almuerzo en Valle del Lunarejo", "Gastronomia");
		icd.agregarActividadACategoria("Cabalgata en Valle del Lunarejo", "Campo y Naturaleza");
		icd.agregarActividadACategoria("Bus turistico Colonia", "Cultura y Patrimonio");
		icd.agregarActividadACategoria("Colonia Premium Tour", "Cultura y Patrimonio");
		icd.agregarActividadACategoria("Deportes nauticos sin uso de motor", "Aventura y Deporte");
		icd.agregarActividadACategoria("Deportes nauticos sin uso de motor", "Turismo y Playas");
		icd.agregarActividadACategoria("Descubre Rivera", "Cultura y Patrimonio");
		
		///////////////////////////////////////////
		//CARGA DE SALIDAS
		
		DTInfo dt1 = new DTInfo(LocalDateTime.of(2022, 8, 20, 17, 0), "Sociedad Agropecuaria de Rocha");
		icd.crearSalida("Rocha", "Degusta", "Degusta Agosto", dt1, LocalDateTime.of(2022, 07, 21, 0, 0), 20);
		
		DTInfo dt2 = new DTInfo(LocalDateTime.of(2022, 9, 3, 17, 0), "Sociedad Agropecuaria de Rocha");
		icd.crearSalida("Rocha", "Degusta", "Degusta Setiembre", dt2, LocalDateTime.of(2022, 7, 22, 0, 0), 20);
		
		DTInfo dt3 = new DTInfo(LocalDateTime.of(2022, 9, 4, 18, 0), "Club Deportivo Union");
		icd.crearSalida("Rocha", "Teatro con Sabores", "Teatro con Sabores 1", dt3, LocalDateTime.of(2022, 7, 23, 0, 0), 30);
		
		DTInfo dt4 = new DTInfo(LocalDateTime.of(2022, 9, 11, 18, 0), "Club Deportivo Union");
		icd.crearSalida("Rocha", "Teatro con Sabores", "Teatro con Sabores 2", dt4, LocalDateTime.of(2022, 7, 23, 0, 0), 30);
		
		DTInfo dt5 = new DTInfo(LocalDateTime.of(22, 9, 11, 10, 0), "Encuentro en la base del Faro");
		icd.crearSalida("Colonia", "Tour por Colonia del Sacramento", "Tour por Colonia del Sacramento 11-09", dt5, LocalDateTime.of(2022, 8, 5, 0, 0), 5);
		
		DTInfo dt6 = new DTInfo(LocalDateTime.of(2022, 9, 18, 10, 0), "Encuentro en la base del Faro");
		icd.crearSalida("Colonia", "Tour por Colonia del Sacramento", "Tour por Colonia del Sacramento 18-09", dt6, LocalDateTime.of(2022, 8, 5, 0, 0), 5);
		
		DTInfo dt7 = new DTInfo(LocalDateTime.of(2022, 9, 18, 12, 0), "Restaurante de la Plaza de Toros");
		icd.crearSalida("Colonia", "Almuerzo en el Real de San Carlos", "Almuerzo 1", dt7, LocalDateTime.of(2022, 8, 4, 0, 0), 5);
		
		DTInfo dt8 = new DTInfo(LocalDateTime.of(2022, 9, 25, 12, 0), "Restaurante de la Plaza de Toros");
		icd.crearSalida("Colonia", "Almuerzo en el Real de San Carlos", "Almuerzo 2", dt8, LocalDateTime.of(2022, 8, 4, 0, 0), 5);
		
		DTInfo dt9 = new DTInfo(LocalDateTime.of(2022, 9, 10, 12, 0), "Posada del Lunarejo");
		icd.crearSalida("Rivera", "Almuerzo en Valle del Lunarejo", "Almuerzo 3", dt9, LocalDateTime.of(2022, 8, 15, 0, 0), 4);
		
		DTInfo dt10 = new DTInfo(LocalDateTime.of(2022, 8, 15, 12, 0), "Posada del Lunarejo");
		icd.crearSalida("Rivera", "Almuerzo en Valle del Lunarejo", "Almuerzo 4", dt10, LocalDateTime.of(2022, 8, 15, 0, 0), 4);
		
		DTInfo dt11 = new DTInfo(LocalDateTime.of(2022, 9, 10, 16, 0), "Posada del Lunarejo");
		icd.crearSalida("Rivera", "Cabalgata en Valle del Lunarejo", "Cabalgata 1", dt11, LocalDateTime.of(2022, 8, 15, 0, 0), 4);
		
		DTInfo dt12 = new DTInfo(LocalDateTime.of(2022, 9, 11, 16, 0), "Posada del Lunarejo");
		icd.crearSalida("Rivera", "Cabalgata en Valle del Lunarejo", "Cabalgata 2", dt12, LocalDateTime.of(2022, 8, 15, 0, 0), 4);
		
		DTInfo dt13 = new DTInfo(LocalDateTime.of(2022, 10, 30, 17, 0), "Sociedad Agropecuaria de Rocha");
		icd.crearSalida("Rocha", "Degusta", "Degusta Octubre", dt13, LocalDateTime.of(2022, 9, 22, 0, 0), 20);
		
		DTInfo dt14 = new DTInfo(LocalDateTime.of(2022, 11, 5, 17, 0), "Sociedad Agropecuaria de Rocha");
		icd.crearSalida("Rocha", "Degusta", "Degusta Noviembre", dt14, LocalDateTime.of(2022, 10, 2, 0, 0), 20);
		
		DTInfo dt15 = new DTInfo(LocalDateTime.of(2022, 11, 11, 18, 0), "Club Deportivo Union");
		icd.crearSalida("Rocha", "Teatro con Sabores", "Teatro con Sabores 3", dt15, LocalDateTime.of(2022, 8, 25, 0, 0), 30);
		
		DTInfo dt16 = new  DTInfo(LocalDateTime.of(2022, 10, 30, 10, 0), "Encuentro en la base del  Faro");
		icd.crearSalida("Colonia", "Tour por Colonia del Sacramento", "Tour por Colonia del Sacramento 30-10", dt16, LocalDateTime.of(2022, 9, 7, 0, 0), 10);
		
		DTInfo dt17 = new DTInfo(LocalDateTime.of(2022, 10, 30, 16, 0), "Posada del Lunarejo");
		icd.crearSalida("Rivera", "Cabalgata en Valle del Lunarejo", "Cabalgata Extrema", dt17, LocalDateTime.of(2022, 9, 15, 0, 0), 4);
		
		DTInfo dt18 = new DTInfo(LocalDateTime.of(2022, 10, 30, 12, 0), "Restaurantte de la Plaza de Toros");
		icd.crearSalida("Colonia", "Almuerzo en el Real de San Carlos", "Almuerzo en el Real 1", dt18, LocalDateTime.of(2022, 10, 10, 0, 0), 10);
		
		DTInfo dt19 = new DTInfo(LocalDateTime.of(2022, 12, 02, 17,20), "Sociedad Agropecuaria de Roccha");
		icd.crearSalida("Rocha", "Degusta", "Degusta Diciembre", dt19 , LocalDateTime.of(2022, 11, 07, 0, 0), 20);
		
		DTInfo dt20 = new DTInfo(LocalDateTime.of(2022, 12, 03, 18, 30), "Club Deportivo Union");
		icd.crearSalida("Rocha", "Teatro con Sabores","Teatro con Sabores 4", dt20 ,LocalDateTime.of(2022, 11, 07, 0, 0), 30);
		

		icu.registrarInscrip(3, LocalDateTime.of(2022, 8, 15, 0, 0), "Rocha", "Degusta", "Degusta Agosto", "lachiqui");
		icu.registrarInscrip(5, LocalDateTime.of(2022, 8, 16, 0, 0), "Rocha", "Degusta", "Degusta Agosto", "elelvis");
		icu.registrarInscrip(3, LocalDateTime.of(2022, 8, 18, 0, 0), "Colonia", "Tour por Colonia del Sacramento", "Tour por Colonia del Sacramento 18-09", "lachiqui");
		icu.registrarInscrip(1, LocalDateTime.of(2022, 8, 19, 0, 0), "Colonia", "Tour por Colonia del Sacramento", "Tour por Colonia del Sacramento 18-09", "isabelita");
		icu.registrarInscrip(2, LocalDateTime.of(2022, 8, 19, 0, 0), "Colonia", "Almuerzo en el Real de San Carlos", "Almuerzo 2", "mastropiero");
		icu.registrarInscrip(1, LocalDateTime.of(2022, 8, 19, 0, 0), "Rocha", "Teatro con Sabores", "Teatro con Sabores 1", "chino");
		icu.registrarInscrip(10, LocalDateTime.of(2022, 8, 20, 0, 0), "Rocha", "Teatro con Sabores", "Teatro con Sabores 2", "chino");
		icu.registrarInscrip(2, LocalDateTime.of(2022, 8, 20, 0, 0), "Rocha", "Teatro con Sabores", "Teatro con Sabores 2", "bobesponja");
		icu.registrarInscrip(1, LocalDateTime.of(2022, 8, 21, 0, 0), "Rocha", "Teatro con Sabores", "Teatro con Sabores 2", "anibal");
		icu.registrarInscrip(11, LocalDateTime.of(2022, 8, 21, 0, 0), "Rocha", "Degusta", "Degusta Setiembre", "tony");
		icu.registrarInscrip(2, LocalDateTime.of(2022, 10, 3, 0, 0), "Rocha", "Degusta", "Degusta Noviembre", "lachiqui");
		icu.registrarInscrip(2, LocalDateTime.of(2022, 10, 3, 0, 0), "Rocha", "Teatro con Sabores", "Teatro con Sabores 3", "lachiqui");
		icu.registrarInscrip(5, LocalDateTime.of(2022, 9, 2, 0, 0), "Rocha", "Degusta", "Degusta Setiembre", "elelvis");
		icu.registrarInscrip(5, LocalDateTime.of(2022, 9, 2, 0, 0), "Rocha", "Teatro con Sabores", "Teatro con Sabores 1", "elelvis");
		icu.registrarInscrip(5, LocalDateTime.of(2022, 9, 3, 0, 0), "Colonia", "Tour por Colonia del Sacramento", "Tour por Colonia del Sacramento 11-09", "lachiqui");
		icu.registrarInscrip(5, LocalDateTime.of(2022, 9, 3, 0, 0), "Colonia", "Almuerzo en el Real de San Carlos", "Almuerzo 1", "lachiqui");
		icu.registrarInscrip(1, LocalDateTime.of(2022, 9, 5, 0, 0), "Colonia", "Tour por Colonia del Sacramento", "Tour por Colonia del Sacramento 18-09", "waston");
		icu.registrarInscrip(1, LocalDateTime.of(2022, 9, 5, 0, 0), "Colonia", "Almuerzo en el Real de San Carlos", "Almuerzo 2", "waston");
		icu.registrarInscrip(2, LocalDateTime.of(2022, 10, 2, 0, 0), "Colonia", "Tour por Colonia del Sacramento", "Tour por Colonia del Sacramento 30-10", "elelvis");
		icu.registrarInscrip(2, LocalDateTime.of(2022, 10, 11, 0, 0), "Colonia", "Almuerzo en el Real de San Carlos", "Almuerzo en el Real 1", "elelvis");
		icu.registrarInscrip(4, LocalDateTime.of(2022, 10, 12, 0, 0), "Colonia", "Tour por Colonia del Sacramento", "Tour por Colonia del Sacramento 30-10", "mastropiero");
		
		
		/////////////////////////////////////////////
	
		JOptionPane.showMessageDialog(null, "Los datos han sido cargados exitosamente","Carga de Datos",JOptionPane.PLAIN_MESSAGE);
	}
	
	
}
