package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import logica.*;
import service.DepartamentoService;
import service.DepartamentoServiceService;
import service.DtUsuario;
import service.Usuario;
import service.UsuarioService;
import service.UsuarioServiceService;

/**
 * Servlet implementation class home
 */
@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Home() {
		super();
		/*
		 * Fabrica fab = Fabrica.getInstance(); IControladorDepartamentos ICD =
		 * fab.getIControladorDepartamentos(); IControladorUsuario ICU =
		 * fab.getIControladorUsuario();
		 * 
		 * ICU.altaTurista("lachiqui", "Rosa Maria", "Martinez",
		 * "mirtha.legrand.ok@hotmail.com.ar", LocalDate.of(1927, 2, 23),
		 * "argentina", "awdrg543"); ICU.altaTurista("isabelita", "Elizabeth",
		 * "Windsor", "isabelita@thecrown.co.uk", LocalDate.of(1926, 4, 21),
		 * "inglesa", "r5t6y7u8"); ICU.altaTurista("anibal", "Anibal", "Lecter",
		 * "anibal@fing.edu.uy", LocalDate.of(1937, 12, 31), "lituana",
		 * "edrft543"); ICU.altaTurista("waston", "Emma", "Waston",
		 * "e.waston@gmail.com", LocalDate.of(1990, 4, 15), "inglesa",
		 * "poiuy987"); ICU.altaTurista("elelvis", "Elvis", "Lacio",
		 * "suavemente@hotmail.com", LocalDate.of(1971, 7, 30),
		 * "estadounidense", "45idgaf67"); ICU.altaTurista("eleven11", "Eleven",
		 * "Once", "eleven11@gmail.com", LocalDate.of(2004, 2, 19),
		 * "espaÃ±ola", "xdrgb657"); ICU.altaTurista("bobesponja", "Bob",
		 * "Esponja", "bobesponja@nickelodeon.com", LocalDate.of(1999, 5, 1),
		 * "japonesa", "sbsplol1"); ICU.altaTurista("tony", "Antionio",
		 * "Pachecho", "eltony@manya.org.uy", LocalDate.of(1976, 4, 11),
		 * "uruguaya", "okmnji98"); ICU.altaTurista("chino", "Alvaro", "Recoba",
		 * "chino@trico.org.uy", LocalDate.of(1976, 3, 17), "uruguaya",
		 * "qsxcdw43"); ICU.altaTurista("mastropiero", "Johann", "Sebastian",
		 * "johann.sebastian@gmail.com", LocalDate.of(1922, 2, 7), "austriaco",
		 * "qpwoci586");
		 * 
		 * ICU.altaProveedor("washington", "Washington", "Rocha",
		 * "washington@turismorocha.gub.uy", LocalDate.of(1970, 9, 14),
		 * "Hola! me llamo Washington y soy el encargado del portal de turismo del departamento de Rocha-Uruguay"
		 * , "http://turismorocha.gub.uy/", "asdfg654");
		 * ICU.altaProveedor("eldiez", "Pablo", "Bengoechea",
		 * "eldiez@socfomturriv.org.uy", LocalDate.of(1965, 6, 27),
		 * "Pablo es el presidente de la Sociedad de Fomento Turistico de Rivera (conocida "
		 * + "como Socfomturriv)", "http://wwww.socfomturriv.org.uy/",
		 * "ytrewq10"); ICU.altaProveedor("meche", "Mercedes", "Venn",
		 * "meche@colonia.gub.uy", LocalDate.of(1990, 12, 31),
		 * "Departamento de Turismo Del Departamento de Colonia",
		 * "https://colonia.gub.uy/turismo/", "mnjkiu89");
		 * 
		 * // Datos de prueba ICD.altaDepartamento("Canelones",
		 * "Division Turismo de la Intendencia",
		 * "https://www.imcanelones.gub.uy/es");
		 * ICD.altaDepartamento("Maldonado",
		 * "Division Turismo de la Intendencia",
		 * "https://www.maldonado.gub.uy/"); ICD.altaDepartamento("Rocha",
		 * "La Organizaci´on de Gestión del Destino (OGD) Rocha es un ámbito de articulación público – privada en el sector turístico que integran la Corporación Rochense de Turismo y la Intendencia de Rocha a través de su Dirección de Turismo"
		 * , "http://www.turismorocha.gub.uy/");
		 * ICD.altaDepartamento("Treinta y Tres",
		 * "Division Turismo de la Intendencia",
		 * "https://treintaytres.gub.uy/"); ICD.altaDepartamento("Cerro Largo",
		 * "Division Turismo de la Intendencia",
		 * "https://www.gub.uy/intendencia-cerro-largo/");
		 * ICD.altaDepartamento("Rivera",
		 * "Promociona e implementa proyectos e iniciativas sostenibles de interés tur´ıstico con la participación institucional pública – privada en bien del desarrollo socioeconómico de la comunidad."
		 * , "http://www.rivera.gub.uy/social/turismo/");
		 * ICD.altaDepartamento("Artigas", "Division Turismo de la Intendencia",
		 * "http://www.artigas.gub.uy/"); ICD.altaDepartamento("Salto",
		 * "Division Turismo de la Intendencia", "https://www.salto.gub.uy/");
		 * ICD.altaDepartamento("Paysandu",
		 * "Division Turismo de la Intendencia",
		 * "https://www.paysandu.gub.uy/"); ICD.altaDepartamento("Rio Negro",
		 * "Division Turismo de la Intendencia",
		 * "https://www.rionegro.gub.uy/"); ICD.altaDepartamento("Soriano",
		 * "Division Turismo de la Intendencia", "https://www.soriano.gub.uy/");
		 * ICD.altaDepartamento("Colonia",
		 * "La propuesta del Departamento de Colonia divide en cuatro actos su espectáculo anual. Cada acto tiene su magia. Desde su naturaleza y playas hasta sus tradiciones y el patrimonio mundial. Todo el año se disfruta."
		 * , "https://colonia.gub.uy/turismo/");
		 * ICD.altaDepartamento("San Jose",
		 * "Division Turismo de la Intendencia", "https://sanjose.gub.uy/");
		 * ICD.altaDepartamento("Flores", "Division Turismo de la Intendencia",
		 * "https://flores.gub.uy/"); ICD.altaDepartamento("Florida",
		 * "Division Turismo de la Intendencia", "http://www.florida.gub.uy/");
		 * ICD.altaDepartamento("Lavalleja",
		 * "Division Turismo de la Intendencia",
		 * "http://www.lavalleja.gub.uy/"); ICD.altaDepartamento("Durazno",
		 * "Division Turismo de la Intendencia", "https://durazno.uy/");
		 * ICD.altaDepartamento("Tacuarembe",
		 * "Division Turismo de la Intendencia", "https://tacuarembo.gub.uy/");
		 * ICD.altaDepartamento("Montevideo",
		 * "Division Turismo de la Intendencia",
		 * "https://montevideo.gub.uy/areas-tematicas/turismo");
		 * 
		 * ICD.altaActividad("Rocha", "washington", "Degusta",
		 * "Festival gastronomico de productos locales en Rocha", 3, 800,
		 * "Rocha", LocalDate.of(2022, 7, 20), null);
		 * ICD.aceptarActividad("Degusta", EstadoActividad.Aceptada);
		 * 
		 * ICD.altaActividad("Rocha", "washington", "Teatro con Sabores",
		 * "En el mes aniversario del Club Deportivo Union de Rocha te invitamos a una merienda deliciosa."
		 * , 3, 500, "Rocha", LocalDate.of(2022, 7, 21), null);
		 * ICD.aceptarActividad("Teatro con Sabores", EstadoActividad.Aceptada);
		 * 
		 * ICD.altaActividad("Colonia", "meche",
		 * "Tour por Colonia del Sacramento",
		 * "Con guia especializado y en varios idiomas. Varios circuitos posibles."
		 * , 2, 400, "Colonia del Sacramento", LocalDate.of(2022, 8, 1), null);
		 * ICD.aceptarActividad("Tour por Colonia del Sacramento",
		 * EstadoActividad.Aceptada);
		 * 
		 * ICD.altaActividad("Colonia", "meche",
		 * "Almuerzo en el Real de San Carlos",
		 * "Restaurante en la renovada Plaza de Toros con menú internacional",
		 * 2, 800, "Colonia del Sacramento", LocalDate.of(2022, 8, 1), null);
		 * ICD.aceptarActividad("Almuerzo en el Real de San Carlos",
		 * EstadoActividad.Aceptada);
		 * 
		 * ICD.altaActividad("Rivera", "eldiez",
		 * "Almuerzo en Valle del Lunarejo",
		 * "Almuerzo en la Posada con ticket fijo. Menú que incluye bebida y postre casero."
		 * , 2, 300, "Tranqueras", LocalDate.of(2022, 8, 1), null);
		 * ICD.aceptarActividad("Almuerzo en Valle del Lunarejo",
		 * EstadoActividad.Aceptada);
		 * 
		 * ICD.altaActividad("Rivera", "eldiez",
		 * "Cabalgata en Valle del Lunarejo",
		 * "Cabalgata por el  área protegida. Varios recorridos para elegir.",
		 * 2, 150, "Tranqueras", LocalDate.of(2022, 8, 1), null);
		 * ICD.aceptarActividad("Cabalgata en Valle del Lunarejo",
		 * EstadoActividad.Aceptada);
		 * 
		 * ICD.altaActividad("Colonia", "meche", "Bus turistico Colonia",
		 * "Recorrida por los principales atractivos de la ciudad", 3, 600,
		 * "Colonia del Sacramento", LocalDate.of(2022, 9, 1), null);
		 * ICD.aceptarActividad("Bus turistico Colonia",
		 * EstadoActividad.Agregada);
		 * 
		 * ICD.altaActividad("Colonia", "meche", "Colonia Premium Tour",
		 * "Visita lugares exclusivos y relevantes", 4, 2600,
		 * "Colonia del Sacramento", LocalDate.of(2022, 9, 3), null);
		 * ICD.aceptarActividad("Colonia Premium Tour",
		 * EstadoActividad.Rechazada);
		 * 
		 * ICD.altaActividad("Rocha", "washington",
		 * "Deportes nauticos sin uso de motor",
		 * "kitsurf - windsurf - kayakismo - canotaje en Rocha", 3, 1200,
		 * "Rocha", LocalDate.of(2022, 9, 5), null);
		 * ICD.aceptarActividad("Deportes nauticos sin uso de motor",
		 * EstadoActividad.Agregada);
		 * 
		 * ICD.altaActividad("Rivera", "eldiez", "Descubre Rivera",
		 * "Rivera es un departamento de extraordinaria riqueza natural patrimonial y cultural con una ubicacion geografica privilegiada"
		 * , 2, 650, "Rivera", LocalDate.of(2022, 9, 16), null);
		 * ICD.aceptarActividad("Descubre Rivera", EstadoActividad.Rechazada);
		 * 
		 * /////////////////////////////////////////////
		 * 
		 * /////////////////////////////////////////// // CARGA DE CATEGORIAS
		 * ICD.altaCategoria("Aventura y Deporte");
		 * ICD.altaCategoria("Campo y Naturaleza");
		 * ICD.altaCategoria("Cultura y Patrimonio");
		 * ICD.altaCategoria("Gastronomia");
		 * ICD.altaCategoria("Turismo y Playas");
		 * 
		 * /////////////////////////////////////////// // AGREGAR ACTIVIDAD A
		 * LAS CATEGORIAS
		 * 
		 * ICD.agregarActividadACategoria("Degusta", "Gastronomia");
		 * ICD.agregarActividadACategoria("Teatro con Sabores",
		 * "Cultura y Patrimonio");
		 * ICD.agregarActividadACategoria("Teatro con Sabores", "Gastronomia");
		 * ICD.agregarActividadACategoria("Tour por Colonia del Sacramento",
		 * "Cultura y Patrimonio");
		 * ICD.agregarActividadACategoria("Almuerzo en el Real de San Carlos",
		 * "Gastronomia");
		 * ICD.agregarActividadACategoria("Almuerzo en Valle del Lunarejo",
		 * "Campo y Naturaleza");
		 * ICD.agregarActividadACategoria("Almuerzo en Valle del Lunarejo",
		 * "Gastronomia");
		 * ICD.agregarActividadACategoria("Cabalgata en Valle del Lunarejo",
		 * "Campo y Naturaleza");
		 * ICD.agregarActividadACategoria("Bus turistico Colonia",
		 * "Cultura y Patrimonio");
		 * ICD.agregarActividadACategoria("Colonia Premium Tour",
		 * "Cultura y Patrimonio");
		 * ICD.agregarActividadACategoria("Deportes nauticos sin uso de motor",
		 * "Aventura y Deporte");
		 * ICD.agregarActividadACategoria("Deportes nauticos sin uso de motor",
		 * "Turismo y Playas");
		 * ICD.agregarActividadACategoria("Descubre Rivera",
		 * "Cultura y Patrimonio");
		 * 
		 * /////////////////////////////////////////// // CARGA DE SALIDAS
		 * 
		 * DTInfo dt1 = new DTInfo(LocalDateTime.of(2022, 8, 20, 17, 0),
		 * "Sociedad Agropecuaria de Rocha"); ICD.crearSalida("Rocha",
		 * "Degusta", "Degusta Agosto", dt1, LocalDateTime.of(2022, 07, 21, 0,
		 * 0), 20);
		 * 
		 * DTInfo dt2 = new DTInfo(LocalDateTime.of(2022, 9, 3, 17, 0),
		 * "Sociedad Agropecuaria de Rocha"); ICD.crearSalida("Rocha",
		 * "Degusta", "Degusta Setiembre", dt2, LocalDateTime.of(2022, 7, 22, 0,
		 * 0), 20);
		 * 
		 * DTInfo dt3 = new DTInfo(LocalDateTime.of(2022, 9, 4, 18, 0),
		 * "Club Deportivo Union"); ICD.crearSalida("Rocha",
		 * "Teatro con Sabores", "Teatro con Sabores 1", dt3,
		 * LocalDateTime.of(2022, 7, 23, 0, 0), 30);
		 * 
		 * DTInfo dt4 = new DTInfo(LocalDateTime.of(2022, 9, 11, 18, 0),
		 * "Club Deportivo Union"); ICD.crearSalida("Rocha",
		 * "Teatro con Sabores", "Teatro con Sabores 2", dt4,
		 * LocalDateTime.of(2022, 7, 23, 0, 0), 30);
		 * 
		 * DTInfo dt5 = new DTInfo(LocalDateTime.of(22, 9, 11, 10, 0),
		 * "Encuentro en la base del Faro"); ICD.crearSalida("Colonia",
		 * "Tour por Colonia del Sacramento",
		 * "Tour por Colonia del Sacramento 11-09", dt5, LocalDateTime.of(2022,
		 * 8, 5, 0, 0), 5);
		 * 
		 * DTInfo dt6 = new DTInfo(LocalDateTime.of(2022, 9, 18, 10, 0),
		 * "Encuentro en la base del Faro"); ICD.crearSalida("Colonia",
		 * "Tour por Colonia del Sacramento",
		 * "Tour por Colonia del Sacramento 18-09", dt6, LocalDateTime.of(2022,
		 * 8, 5, 0, 0), 5);
		 * 
		 * DTInfo dt7 = new DTInfo(LocalDateTime.of(2022, 9, 18, 12, 0),
		 * "Restaurante de la Plaza de Toros"); ICD.crearSalida("Colonia",
		 * "Almuerzo en el Real de San Carlos", "Almuerzo 1", dt7,
		 * LocalDateTime.of(2022, 8, 4, 0, 0), 5);
		 * 
		 * DTInfo dt8 = new DTInfo(LocalDateTime.of(2022, 9, 25, 12, 0),
		 * "Restaurante de la Plaza de Toros"); ICD.crearSalida("Colonia",
		 * "Almuerzo en el Real de San Carlos", "Almuerzo 2", dt8,
		 * LocalDateTime.of(2022, 8, 4, 0, 0), 5);
		 * 
		 * DTInfo dt9 = new DTInfo(LocalDateTime.of(2022, 9, 10, 12, 0),
		 * "Posada del Lunarejo"); ICD.crearSalida("Rivera",
		 * "Almuerzo en Valle del Lunarejo", "Almuerzo 3", dt9,
		 * LocalDateTime.of(2022, 8, 15, 0, 0), 4);
		 * 
		 * DTInfo dt10 = new DTInfo(LocalDateTime.of(2022, 8, 15, 12, 0),
		 * "Posada del Lunarejo"); ICD.crearSalida("Rivera",
		 * "Almuerzo en Valle del Lunarejo", "Almuerzo 4", dt10,
		 * LocalDateTime.of(2022, 8, 15, 0, 0), 4);
		 * 
		 * DTInfo dt11 = new DTInfo(LocalDateTime.of(2022, 9, 10, 16, 0),
		 * "Posada del Lunarejo"); ICD.crearSalida("Rivera",
		 * "Cabalgata en Valle del Lunarejo", "Cabalgata 1", dt11,
		 * LocalDateTime.of(2022, 8, 15, 0, 0), 4);
		 * 
		 * DTInfo dt12 = new DTInfo(LocalDateTime.of(2022, 9, 11, 16, 0),
		 * "Posada del Lunarejo"); ICD.crearSalida("Rivera",
		 * "Cabalgata en Valle del Lunarejo", "Cabalgata 2", dt12,
		 * LocalDateTime.of(2022, 8, 15, 0, 0), 4);
		 * 
		 * DTInfo dt13 = new DTInfo(LocalDateTime.of(2022, 10, 30, 17, 0),
		 * "Sociedad Agropecuaria de Rocha"); ICD.crearSalida("Rocha",
		 * "Degusta", "Degusta Octubre", dt13, LocalDateTime.of(2022, 9, 22, 0,
		 * 0), 20);
		 * 
		 * DTInfo dt14 = new DTInfo(LocalDateTime.of(2022, 11, 5, 17, 0),
		 * "Sociedad Agropecuaria de Rocha"); ICD.crearSalida("Rocha",
		 * "Degusta", "Degusta Noviembre", dt14, LocalDateTime.of(2022, 10, 2,
		 * 0, 0), 20);
		 * 
		 * DTInfo dt15 = new DTInfo(LocalDateTime.of(2022, 11, 11, 18, 0),
		 * "Club Deportivo Union"); ICD.crearSalida("Rocha",
		 * "Teatro con Sabores", "Teatro con Sabores 3", dt15,
		 * LocalDateTime.of(2022, 8, 25, 0, 0), 30);
		 * 
		 * DTInfo dt16 = new DTInfo(LocalDateTime.of(2022, 10, 30, 10, 0),
		 * "Encuentro en la base del  Faro"); ICD.crearSalida("Colonia",
		 * "Tour por Colonia del Sacramento",
		 * "Tour por Colonia del Sacramento 30-10", dt16, LocalDateTime.of(2022,
		 * 9, 7, 0, 0), 10);
		 * 
		 * DTInfo dt17 = new DTInfo(LocalDateTime.of(2022, 10, 30, 16, 0),
		 * "Posada del Lunarejo"); ICD.crearSalida("Rivera",
		 * "Cabalgata en Valle del Lunarejo", "Cabalgata Extrema", dt17,
		 * LocalDateTime.of(2022, 9, 15, 0, 0), 4);
		 * 
		 * DTInfo dt18 = new DTInfo(LocalDateTime.of(2022, 10, 30, 12, 0),
		 * "Restaurantte de la Plaza de Toros"); ICD.crearSalida("Colonia",
		 * "Almuerzo en el Real de San Carlos", "Almuerzo en el Real 1", dt18,
		 * LocalDateTime.of(2022, 10, 10, 0, 0), 10);
		 * 
		 * ICU.registrarInscrip(3, LocalDateTime.of(2022, 8, 15, 0, 0), "Rocha",
		 * "Degusta", "Degusta Agosto", "lachiqui"); ICU.registrarInscrip(5,
		 * LocalDateTime.of(2022, 8, 16, 0, 0), "Rocha", "Degusta",
		 * "Degusta Agosto", "elelvis"); ICU.registrarInscrip(3,
		 * LocalDateTime.of(2022, 8, 18, 0, 0), "Colonia",
		 * "Tour por Colonia del Sacramento",
		 * "Tour por Colonia del Sacramento 18-09", "lachiqui");
		 * ICU.registrarInscrip(1, LocalDateTime.of(2022, 8, 19, 0, 0),
		 * "Colonia", "Tour por Colonia del Sacramento",
		 * "Tour por Colonia del Sacramento 18-09", "isabelita");
		 * ICU.registrarInscrip(2, LocalDateTime.of(2022, 8, 19, 0, 0),
		 * "Colonia", "Almuerzo en el Real de San Carlos", "Almuerzo 2",
		 * "mastropiero"); ICU.registrarInscrip(1, LocalDateTime.of(2022, 8, 19,
		 * 0, 0), "Rocha", "Teatro con Sabores", "Teatro con Sabores 1",
		 * "chino"); ICU.registrarInscrip(10, LocalDateTime.of(2022, 8, 20, 0,
		 * 0), "Rocha", "Teatro con Sabores", "Teatro con Sabores 2", "chino");
		 * ICU.registrarInscrip(2, LocalDateTime.of(2022, 8, 20, 0, 0), "Rocha",
		 * "Teatro con Sabores", "Teatro con Sabores 2", "bobesponja");
		 * ICU.registrarInscrip(1, LocalDateTime.of(2022, 8, 21, 0, 0), "Rocha",
		 * "Teatro con Sabores", "Teatro con Sabores 2", "anibal");
		 * ICU.registrarInscrip(11, LocalDateTime.of(2022, 8, 21, 0, 0),
		 * "Rocha", "Degusta", "Degusta Setiembre", "tony");
		 * ICU.registrarInscrip(2, LocalDateTime.of(2022, 10, 3, 0, 0), "Rocha",
		 * "Degusta", "Degusta Noviembre", "lachiqui"); ICU.registrarInscrip(2,
		 * LocalDateTime.of(2022, 10, 3, 0, 0), "Rocha", "Teatro con Sabores",
		 * "Teatro con Sabores 3", "lachiqui"); ICU.registrarInscrip(5,
		 * LocalDateTime.of(2022, 9, 2, 0, 0), "Rocha", "Degusta",
		 * "Degusta Setiembre", "elelvis"); ICU.registrarInscrip(5,
		 * LocalDateTime.of(2022, 9, 2, 0, 0), "Rocha", "Teatro con Sabores",
		 * "Teatro con Sabores 1", "elelvis"); ICU.registrarInscrip(5,
		 * LocalDateTime.of(2022, 9, 3, 0, 0), "Colonia",
		 * "Tour por Colonia del Sacramento",
		 * "Tour por Colonia del Sacramento 11-09", "lachiqui");
		 * ICU.registrarInscrip(5, LocalDateTime.of(2022, 9, 3, 0, 0),
		 * "Colonia", "Almuerzo en el Real de San Carlos", "Almuerzo 1",
		 * "lachiqui"); ICU.registrarInscrip(1, LocalDateTime.of(2022, 9, 5, 0,
		 * 0), "Colonia", "Tour por Colonia del Sacramento",
		 * "Tour por Colonia del Sacramento 18-09", "waston");
		 * ICU.registrarInscrip(1, LocalDateTime.of(2022, 9, 5, 0, 0),
		 * "Colonia", "Almuerzo en el Real de San Carlos", "Almuerzo 2",
		 * "waston"); ICU.registrarInscrip(2, LocalDateTime.of(2022, 10, 2, 0,
		 * 0), "Colonia", "Tour por Colonia del Sacramento",
		 * "Tour por Colonia del Sacramento 30-10", "elelvis");
		 * ICU.registrarInscrip(2, LocalDateTime.of(2022, 10, 11, 0, 0),
		 * "Colonia", "Almuerzo en el Real de San Carlos",
		 * "Almuerzo en el Real 1", "elelvis"); ICU.registrarInscrip(4,
		 * LocalDateTime.of(2022, 10, 12, 0, 0), "Colonia",
		 * "Tour por Colonia del Sacramento",
		 * "Tour por Colonia del Sacramento 30-10", "mastropiero");
		 * 
		 * }
		 */
		/*
		 * DepartamentoServiceService DepService = new
		 * DepartamentoServiceService(); DepartamentoService ICD =
		 * DepService.getDepartamentoServicePort();
		 * 
		 * UsuarioServiceService UsuService = new UsuarioServiceService();
		 * UsuarioService ICU = UsuService.getUsuarioServicePort();
		 * 
		 * ICU.altaTuristaService("lachiqui", "Rosa Maria", "Martinez",
		 * "mirtha.legrand.ok@hotmail.com.ar", LocalDate.of(1927, 2,
		 * 23).toString(), "argentina", "awdrg543");
		 * ICU.altaTuristaService("isabelita", "Elizabeth", "Windsor",
		 * "isabelita@thecrown.co.uk", LocalDate.of(1926, 4, 21).toString(),
		 * "inglesa", "r5t6y7u8"); ICU.altaTuristaService("anibal", "Anibal",
		 * "Lecter", "anibal@fing.edu.uy", LocalDate.of(1937, 12,
		 * 31).toString(), "lituana", "edrft543");
		 * ICU.altaTuristaService("waston", "Emma", "Waston",
		 * "e.waston@gmail.com", LocalDate.of(1990, 4, 15).toString(),
		 * "inglesa", "poiuy987"); ICU.altaTuristaService("elelvis", "Elvis",
		 * "Lacio", "suavemente@hotmail.com", LocalDate.of(1971, 7,
		 * 30).toString(), "estadounidense", "45idgaf67");
		 * ICU.altaTuristaService("eleven11", "Eleven", "Once",
		 * "eleven11@gmail.com", LocalDate.of(2004, 2, 19).toString(),
		 * "espaÃ±ola", "xdrgb657"); ICU.altaTuristaService("bobesponja",
		 * "Bob", "Esponja", "bobesponja@nickelodeon.com", LocalDate.of(1999, 5,
		 * 1).toString(), "japonesa", "sbsplol1");
		 * ICU.altaTuristaService("tony", "Antionio", "Pachecho",
		 * "eltony@manya.org.uy", LocalDate.of(1976, 4, 11).toString(),
		 * "uruguaya", "okmnji98"); ICU.altaTuristaService("chino", "Alvaro",
		 * "Recoba", "chino@trico.org.uy", LocalDate.of(1976, 3, 17).toString(),
		 * "uruguaya", "qsxcdw43"); ICU.altaTuristaService("mastropiero",
		 * "Johann", "Sebastian", "johann.sebastian@gmail.com",
		 * LocalDate.of(1922, 2, 7).toString(), "austriaco", "qpwoci586");
		 * 
		 * ICU.altaProveedorService("washington", "Washington", "Rocha",
		 * "washington@turismorocha.gub.uy", LocalDate.of(1970, 9,
		 * 14).toString(),
		 * "Hola! me llamo Washington y soy el encargado del portal de turismo del departamento de Rocha-Uruguay"
		 * , "http://turismorocha.gub.uy/", "asdfg654");
		 * ICU.altaProveedorService("eldiez", "Pablo", "Bengoechea",
		 * "eldiez@socfomturriv.org.uy", LocalDate.of(1965, 6, 27).toString(),
		 * "Pablo es el presidente de la Sociedad de Fomento Turistico de Rivera (conocida "
		 * + "como Socfomturriv)", "http://wwww.socfomturriv.org.uy/",
		 * "ytrewq10"); ICU.altaProveedorService("meche", "Mercedes", "Venn",
		 * "meche@colonia.gub.uy","1990-12-31",
		 * "Departamento de Turismo Del Departamento de Colonia",
		 * "https://colonia.gub.uy/turismo/", "mnjkiu89");
		 * 
		 * // Datos de prueba ICD.altaDepartamentoService("Canelones",
		 * "Division Turismo de la Intendencia",
		 * "https://www.imcanelones.gub.uy/es");
		 * ICD.altaDepartamentoService("Maldonado",
		 * "Division Turismo de la Intendencia",
		 * "https://www.maldonado.gub.uy/");
		 * ICD.altaDepartamentoService("Rocha",
		 * "La Organizaci´on de Gestión del Destino (OGD) Rocha es un ámbito de articulación público – privada en el sector turístico que integran la Corporación Rochense de Turismo y la Intendencia de Rocha a través de su Dirección de Turismo"
		 * , "http://www.turismorocha.gub.uy/");
		 * ICD.altaDepartamentoService("Treinta y Tres",
		 * "Division Turismo de la Intendencia",
		 * "https://treintaytres.gub.uy/");
		 * ICD.altaDepartamentoService("Cerro Largo",
		 * "Division Turismo de la Intendencia",
		 * "https://www.gub.uy/intendencia-cerro-largo/");
		 * ICD.altaDepartamentoService("Rivera",
		 * "Promociona e implementa proyectos e iniciativas sostenibles de interés tur´ıstico con la participación institucional pública – privada en bien del desarrollo socioeconómico de la comunidad."
		 * , "http://www.rivera.gub.uy/social/turismo/");
		 * ICD.altaDepartamentoService("Artigas",
		 * "Division Turismo de la Intendencia", "http://www.artigas.gub.uy/");
		 * ICD.altaDepartamentoService("Salto",
		 * "Division Turismo de la Intendencia", "https://www.salto.gub.uy/");
		 * ICD.altaDepartamentoService("Paysandu",
		 * "Division Turismo de la Intendencia",
		 * "https://www.paysandu.gub.uy/");
		 * ICD.altaDepartamentoService("Rio Negro",
		 * "Division Turismo de la Intendencia",
		 * "https://www.rionegro.gub.uy/");
		 * ICD.altaDepartamentoService("Soriano",
		 * "Division Turismo de la Intendencia", "https://www.soriano.gub.uy/");
		 * ICD.altaDepartamentoService("Colonia",
		 * "La propuesta del Departamento de Colonia divide en cuatro actos su espectáculo anual. Cada acto tiene su magia. Desde su naturaleza y playas hasta sus tradiciones y el patrimonio mundial. Todo el año se disfruta."
		 * , "https://colonia.gub.uy/turismo/");
		 * ICD.altaDepartamentoService("San Jose",
		 * "Division Turismo de la Intendencia", "https://sanjose.gub.uy/");
		 * ICD.altaDepartamentoService("Flores",
		 * "Division Turismo de la Intendencia", "https://flores.gub.uy/");
		 * ICD.altaDepartamentoService("Florida",
		 * "Division Turismo de la Intendencia", "http://www.florida.gub.uy/");
		 * ICD.altaDepartamentoService("Lavalleja",
		 * "Division Turismo de la Intendencia",
		 * "http://www.lavalleja.gub.uy/");
		 * ICD.altaDepartamentoService("Durazno",
		 * "Division Turismo de la Intendencia", "https://durazno.uy/");
		 * ICD.altaDepartamentoService("Tacuarembe",
		 * "Division Turismo de la Intendencia", "https://tacuarembo.gub.uy/");
		 * ICD.altaDepartamentoService("Montevideo",
		 * "Division Turismo de la Intendencia",
		 * "https://montevideo.gub.uy/areas-tematicas/turismo");
		 * 
		 * ICD.altaActividadService("Rocha", "washington", "Degusta",
		 * "Festival gastronomico de productos locales en Rocha", 3, 800,
		 * "Rocha", LocalDate.of(2022, 7, 20).toString());
		 * ICD.aceptarActividadService("Degusta", "Aceptada");
		 * 
		 * ICD.altaActividadService("Rocha", "washington", "Teatro con Sabores",
		 * "En el mes aniversario del Club Deportivo Union de Rocha te invitamos a una merienda deliciosa."
		 * , 3, 500, "Rocha", LocalDate.of(2022, 7, 21).toString());
		 * ICD.aceptarActividadService("Teatro con Sabores", "Aceptada");
		 * 
		 * ICD.altaActividadService("Colonia", "meche",
		 * "Tour por Colonia del Sacramento",
		 * "Con guia especializado y en varios idiomas. Varios circuitos posibles."
		 * , 2, 400, "Colonia del Sacramento", LocalDate.of(2022, 8,
		 * 1).toString());
		 * ICD.aceptarActividadService("Tour por Colonia del Sacramento",
		 * "Aceptada");
		 * 
		 * ICD.altaActividadService("Colonia", "meche",
		 * "Almuerzo en el Real de San Carlos",
		 * "Restaurante en la renovada Plaza de Toros con menú internacional",
		 * 2, 800, "Colonia del Sacramento", LocalDate.of(2022, 8,
		 * 1).toString());
		 * ICD.aceptarActividadService("Almuerzo en el Real de San Carlos",
		 * "Aceptada");
		 * 
		 * ICD.altaActividadService("Rivera", "eldiez",
		 * "Almuerzo en Valle del Lunarejo",
		 * "Almuerzo en la Posada con ticket fijo. Menú que incluye bebida y postre casero."
		 * , 2, 300, "Tranqueras", LocalDate.of(2022, 8, 1).toString());
		 * ICD.aceptarActividadService("Almuerzo en Valle del Lunarejo",
		 * "Aceptada");
		 * 
		 * ICD.altaActividadService("Rivera", "eldiez",
		 * "Cabalgata en Valle del Lunarejo",
		 * "Cabalgata por el  área protegida. Varios recorridos para elegir.",
		 * 2, 150, "Tranqueras", LocalDate.of(2022, 8, 1).toString());
		 * ICD.aceptarActividadService("Cabalgata en Valle del Lunarejo",
		 * "Aceptada");
		 * 
		 * ICD.altaActividadService("Colonia", "meche", "Bus turistico Colonia",
		 * "Recorrida por los principales atractivos de la ciudad", 3, 600,
		 * "Colonia del Sacramento", LocalDate.of(2022, 9, 1).toString());
		 * ICD.aceptarActividadService("Bus turistico Colonia", "Agregada");
		 * 
		 * ICD.altaActividadService("Colonia", "meche", "Colonia Premium Tour",
		 * "Visita lugares exclusivos y relevantes", 4, 2600,
		 * "Colonia del Sacramento", LocalDate.of(2022, 9, 3).toString());
		 * ICD.aceptarActividadService("Colonia Premium Tour", "Rechazada");
		 * 
		 * ICD.altaActividadService("Rocha", "washington",
		 * "Deportes nauticos sin uso de motor",
		 * "kitsurf - windsurf - kayakismo - canotaje en Rocha", 3, 1200,
		 * "Rocha", LocalDate.of(2022, 9, 5).toString());
		 * ICD.aceptarActividadService("Deportes nauticos sin uso de motor",
		 * "Agregada");
		 * 
		 * ICD.altaActividadService("Rivera", "eldiez", "Descubre Rivera",
		 * "Rivera es un departamento de extraordinaria riqueza natural patrimonial y cultural con una ubicacion geografica privilegiada"
		 * , 2, 650, "Rivera", LocalDate.of(2022, 9, 16).toString());
		 * ICD.aceptarActividadService("Descubre Rivera", "Rechazada");
		 * 
		 * System.out.println(ICD.getDepartamentoXActividadService("Degusta"));
		 * 
		 * /////////////////////////////////////////////
		 * 
		 * /////////////////////////////////////////// // CARGA DE CATEGORIAS
		 * ICD.altaCategoriaService("Aventura y Deporte");
		 * ICD.altaCategoriaService("Campo y Naturaleza");
		 * ICD.altaCategoriaService("Cultura y Patrimonio");
		 * ICD.altaCategoriaService("Gastronomia");
		 * ICD.altaCategoriaService("Turismo y Playas");
		 * System.out.println(ICD.getCategoriasService().getLista().get(4));
		 * 
		 * /////////////////////////////////////////// // AGREGAR ACTIVIDAD A
		 * LAS CATEGORIAS
		 * 
		 * ICD.agregarActividadACategoriaStringService("Degusta",
		 * "Gastronomia");
		 * ICD.agregarActividadACategoriaStringService("Teatro con Sabores",
		 * "Cultura y Patrimonio");
		 * ICD.agregarActividadACategoriaStringService("Teatro con Sabores",
		 * "Gastronomia"); ICD.
		 * agregarActividadACategoriaStringService("Tour por Colonia del Sacramento"
		 * , "Cultura y Patrimonio"); ICD.
		 * agregarActividadACategoriaStringService("Almuerzo en el Real de San Carlos"
		 * , "Gastronomia"); ICD.
		 * agregarActividadACategoriaStringService("Almuerzo en Valle del Lunarejo"
		 * , "Campo y Naturaleza"); ICD.
		 * agregarActividadACategoriaStringService("Almuerzo en Valle del Lunarejo"
		 * , "Gastronomia"); ICD.
		 * agregarActividadACategoriaStringService("Cabalgata en Valle del Lunarejo"
		 * , "Campo y Naturaleza");
		 * ICD.agregarActividadACategoriaStringService("Bus turistico Colonia",
		 * "Cultura y Patrimonio");
		 * ICD.agregarActividadACategoriaStringService("Colonia Premium Tour",
		 * "Cultura y Patrimonio"); ICD.
		 * agregarActividadACategoriaStringService("Deportes nauticos sin uso de motor"
		 * , "Aventura y Deporte"); ICD.
		 * agregarActividadACategoriaStringService("Deportes nauticos sin uso de motor"
		 * , "Turismo y Playas");
		 * ICD.agregarActividadACategoriaStringService("Descubre Rivera",
		 * "Cultura y Patrimonio");
		 * 
		 * /////////////////////////////////////////// // CARGA DE SALIDAS
		 * 
		 * 
		 * ICD.crearSalidaService("Rocha", "Degusta", "Degusta Agosto",
		 * "Sociedad Agropecuaria de Rocha", LocalDateTime.of(2022, 8, 20, 17,
		 * 0).toString(), LocalDateTime.of(2022, 07, 21, 0, 0).toString(), 20);
		 * 
		 * ICD.crearSalidaService("Rocha", "Degusta", "Degusta Setiembre",
		 * "Sociedad Agropecuaria de Rocha", LocalDateTime.of(2022, 9, 3, 17,
		 * 0).toString(), LocalDateTime.of(2022, 7, 22, 0, 0).toString(), 20);
		 * 
		 * ICD.crearSalidaService("Rocha", "Teatro con Sabores",
		 * "Teatro con Sabores 1", "Club Deportivo Union",
		 * LocalDateTime.of(2022, 9, 4, 18, 0).toString(),
		 * LocalDateTime.of(2022, 7, 23, 0, 0).toString(), 30);
		 * 
		 * ICD.crearSalidaService("Rocha", "Teatro con Sabores",
		 * "Teatro con Sabores 2", "Club Deportivo Union",
		 * LocalDateTime.of(2022, 9, 11, 18, 0).toString(),
		 * LocalDateTime.of(2022, 7, 23, 0, 0).toString(), 30);
		 * 
		 * ICD.crearSalidaService("Colonia", "Tour por Colonia del Sacramento",
		 * "Tour por Colonia del Sacramento 11-09",
		 * "Encuentro en la base del Faro", LocalDateTime.of(22, 9, 11, 10,
		 * 0).toString(), LocalDateTime.of(2022, 8, 5, 0, 0).toString(), 5);
		 * 
		 * ICD.crearSalidaService("Colonia", "Tour por Colonia del Sacramento",
		 * "Tour por Colonia del Sacramento 18-09",
		 * "Encuentro en la base del Faro", LocalDateTime.of(2022, 9, 18, 10,
		 * 0).toString(), LocalDateTime.of(2022, 8, 5, 0, 0).toString(), 5);
		 * 
		 * ICD.crearSalidaService("Colonia",
		 * "Almuerzo en el Real de San Carlos", "Almuerzo 1",
		 * "Restaurante de la Plaza de Toros", LocalDateTime.of(2022, 9, 18, 12,
		 * 0).toString(), LocalDateTime.of(2022, 8, 4, 0, 0).toString(), 5);
		 * 
		 * ICD.crearSalidaService("Colonia",
		 * "Almuerzo en el Real de San Carlos", "Almuerzo 2",
		 * "Restaurante de la Plaza de Toros", LocalDateTime.of(2022, 9, 25, 12,
		 * 0).toString(), LocalDateTime.of(2022, 8, 4, 0, 0).toString(), 5);
		 * 
		 * ICD.crearSalidaService("Rivera", "Almuerzo en Valle del Lunarejo",
		 * "Almuerzo 3", "Posada del Lunarejo", LocalDateTime.of(2022, 9, 10,
		 * 12, 0).toString(), LocalDateTime.of(2022, 8, 15, 0, 0).toString(),
		 * 4);
		 * 
		 * ICD.crearSalidaService("Rivera", "Almuerzo en Valle del Lunarejo",
		 * "Almuerzo 4", "Posada del Lunarejo", LocalDateTime.of(2022, 8, 15,
		 * 12, 0).toString().toString(), LocalDateTime.of(2022, 8, 15, 0,
		 * 0).toString(), 4);
		 * 
		 * ICD.crearSalidaService("Rivera", "Cabalgata en Valle del Lunarejo",
		 * "Cabalgata 1", "Posada del Lunarejo", LocalDateTime.of(2022, 9, 10,
		 * 16, 0).toString(), LocalDateTime.of(2022, 8, 15, 0, 0).toString(),
		 * 4);
		 * 
		 * ICD.crearSalidaService("Rivera", "Cabalgata en Valle del Lunarejo",
		 * "Cabalgata 2", "Posada del Lunarejo", LocalDateTime.of(2022, 9, 11,
		 * 16, 0).toString(), LocalDateTime.of(2022, 8, 15, 0, 0).toString(),
		 * 4);
		 * 
		 * ICD.crearSalidaService("Rocha", "Degusta", "Degusta Octubre",
		 * "Sociedad Agropecuaria de Rocha", LocalDateTime.of(2022, 10, 30, 17,
		 * 0).toString(), LocalDateTime.of(2022, 9, 22, 0, 0).toString(), 20);
		 * 
		 * ICD.crearSalidaService("Rocha", "Degusta", "Degusta Noviembre",
		 * "Sociedad Agropecuaria de Rocha", LocalDateTime.of(2022, 11, 5, 17,
		 * 0).toString(), LocalDateTime.of(2022, 10, 2, 0, 0).toString(), 20);
		 * 
		 * ICD.crearSalidaService("Rocha", "Teatro con Sabores",
		 * "Teatro con Sabores 3", "Club Deportivo Union",
		 * LocalDateTime.of(2022, 11, 11, 18, 0).toString(),
		 * LocalDateTime.of(2022, 8, 25, 0, 0).toString(), 30);
		 * 
		 * ICD.crearSalidaService("Colonia", "Tour por Colonia del Sacramento",
		 * "Tour por Colonia del Sacramento 30-10",
		 * "Encuentro en la base del  Faro", LocalDateTime.of(2022, 10, 30, 10,
		 * 0).toString(), LocalDateTime.of(2022, 9, 7, 0, 0).toString(), 10);
		 * 
		 * ICD.crearSalidaService("Rivera", "Cabalgata en Valle del Lunarejo",
		 * "Cabalgata Extrema", "Posada del Lunarejo", LocalDateTime.of(2022,
		 * 10, 30, 16, 0).toString(), LocalDateTime.of(2022, 9, 15, 0,
		 * 0).toString(), 4);
		 * 
		 * ICD.crearSalidaService("Colonia",
		 * "Almuerzo en el Real de San Carlos", "Almuerzo en el Real 1",
		 * "Restaurantte de la Plaza de Toros", LocalDateTime.of(2022, 10, 30,
		 * 12, 0).toString(), LocalDateTime.of(2022, 10, 10, 0, 0).toString(),
		 * 10);
		 * 
		 * ICD.crearSalidaService("Rocha", "Degusta", "Degusta Diciembre",
		 * "Sociedad Agropecuaria de Roccha", LocalDateTime.of(2022, 12, 02, 17,
		 * 20).toString(), LocalDateTime.of(2022, 11, 07, 0, 0).toString(), 20);
		 * 
		 * ICD.crearSalidaService("Rocha", "Teatro con Sabores",
		 * "Teatro con Sabores 4", "Club Deportivo Union",
		 * LocalDateTime.of(2022, 12, 03, 18, 30).toString(),
		 * LocalDateTime.of(2022, 11, 07, 0, 0).toString(), 30);
		 * 
		 * ICU.registrarInscripService(3, LocalDateTime.of(2022, 8, 15, 0,
		 * 0).toString(), "Rocha", "Degusta", "Degusta Agosto", "lachiqui");
		 * ICU.registrarInscripService(5, LocalDateTime.of(2022, 8, 16, 0,
		 * 0).toString(), "Rocha", "Degusta", "Degusta Agosto", "elelvis");
		 * ICU.registrarInscripService(3, LocalDateTime.of(2022, 8, 18, 0,
		 * 0).toString(), "Colonia", "Tour por Colonia del Sacramento",
		 * "Tour por Colonia del Sacramento 18-09", "lachiqui");
		 * ICU.registrarInscripService(1, LocalDateTime.of(2022, 8, 19, 0,
		 * 0).toString(), "Colonia", "Tour por Colonia del Sacramento",
		 * "Tour por Colonia del Sacramento 18-09", "isabelita");
		 * ICU.registrarInscripService(2, LocalDateTime.of(2022, 8, 19, 0,
		 * 0).toString(), "Colonia", "Almuerzo en el Real de San Carlos",
		 * "Almuerzo 2", "mastropiero"); ICU.registrarInscripService(1,
		 * LocalDateTime.of(2022, 8, 19, 0, 0).toString(), "Rocha",
		 * "Teatro con Sabores", "Teatro con Sabores 1", "chino");
		 * ICU.registrarInscripService(10, LocalDateTime.of(2022, 8, 20, 0,
		 * 0).toString(), "Rocha", "Teatro con Sabores", "Teatro con Sabores 2",
		 * "chino"); ICU.registrarInscripService(2, LocalDateTime.of(2022, 8,
		 * 20, 0, 0).toString(), "Rocha", "Teatro con Sabores",
		 * "Teatro con Sabores 2", "bobesponja"); ICU.registrarInscripService(1,
		 * LocalDateTime.of(2022, 8, 21, 0, 0).toString(), "Rocha",
		 * "Teatro con Sabores", "Teatro con Sabores 2", "anibal");
		 * ICU.registrarInscripService(11, LocalDateTime.of(2022, 8, 21, 0,
		 * 0).toString(), "Rocha", "Degusta", "Degusta Setiembre", "tony");
		 * ICU.registrarInscripService(2, LocalDateTime.of(2022, 10, 3, 0,
		 * 0).toString(), "Rocha", "Degusta", "Degusta Noviembre", "lachiqui");
		 * ICU.registrarInscripService(2, LocalDateTime.of(2022, 10, 3, 0,
		 * 0).toString(), "Rocha", "Teatro con Sabores", "Teatro con Sabores 3",
		 * "lachiqui"); ICU.registrarInscripService(5, LocalDateTime.of(2022, 9,
		 * 2, 0, 0).toString(), "Rocha", "Degusta", "Degusta Setiembre",
		 * "elelvis"); ICU.registrarInscripService(5, LocalDateTime.of(2022, 9,
		 * 2, 0, 0).toString(), "Rocha", "Teatro con Sabores",
		 * "Teatro con Sabores 1", "elelvis"); ICU.registrarInscripService(5,
		 * LocalDateTime.of(2022, 9, 3, 0, 0).toString(), "Colonia",
		 * "Tour por Colonia del Sacramento",
		 * "Tour por Colonia del Sacramento 11-09", "lachiqui");
		 * ICU.registrarInscripService(5, LocalDateTime.of(2022, 9, 3, 0,
		 * 0).toString(), "Colonia", "Almuerzo en el Real de San Carlos",
		 * "Almuerzo 1", "lachiqui"); ICU.registrarInscripService(1,
		 * LocalDateTime.of(2022, 9, 5, 0, 0).toString(), "Colonia",
		 * "Tour por Colonia del Sacramento",
		 * "Tour por Colonia del Sacramento 18-09", "waston");
		 * ICU.registrarInscripService(1, LocalDateTime.of(2022, 9, 5, 0,
		 * 0).toString(), "Colonia", "Almuerzo en el Real de San Carlos",
		 * "Almuerzo 2", "waston"); ICU.registrarInscripService(2,
		 * LocalDateTime.of(2022, 10, 2, 0, 0).toString(), "Colonia",
		 * "Tour por Colonia del Sacramento",
		 * "Tour por Colonia del Sacramento 30-10", "elelvis");
		 * ICU.registrarInscripService(2, LocalDateTime.of(2022, 10, 11, 0,
		 * 0).toString(), "Colonia", "Almuerzo en el Real de San Carlos",
		 * "Almuerzo en el Real 1", "elelvis"); ICU.registrarInscripService(4,
		 * LocalDateTime.of(2022, 10, 12, 0, 0).toString(), "Colonia",
		 * "Tour por Colonia del Sacramento",
		 * "Tour por Colonia del Sacramento 30-10", "mastropiero");
		 */
	}

	// -------------------------------------------------------------------------------------------------------------

	public static void initSession(HttpServletRequest request) {
		DepartamentoServiceService DepService = new DepartamentoServiceService();
		DepartamentoService ICD = DepService.getDepartamentoServicePort();

		HttpSession session = request.getSession();
		if (session.getAttribute("estado_sesion") == null) {
			session.setAttribute("estado_sesion", EstadoSesion.NO_LOGIN);
		}
		session.setAttribute("departamentos", new HashSet<String>(ICD.getSetDepartamentosService().getLista()));
		session.setAttribute("categorias", new HashSet<String>(ICD.getCategoriasService().getLista()));
	}

	public static EstadoSesion getEstado(HttpServletRequest request) {
		return (EstadoSesion) request.getSession().getAttribute("estado_sesion");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		initSession(request);
		// TODO Auto-generated method stub
		// System.out.println(getEstado(request));
		UsuarioServiceService UsuService = new UsuarioServiceService();
		UsuarioService ICU = UsuService.getUsuarioServicePort();
		switch (getEstado(request)) {
			case NO_LOGIN :
				// hace que se ejecute el jsp sin cambiar la url
				request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
				break;
			case LOGIN_INCORRECTO :
				// hace que se ejecute el jsp sin cambiar la url
				request.getRequestDispatcher("/WEB-INF/jsp/iniciarSesion.jsp").forward(request, response);
				break;
			case LOGIN_CORRECTO :
				// manda una redirecciÃ³n a otra URL (cambia la URL)
				HttpSession session = request.getSession();
				DtUsuario user = (DtUsuario) session.getAttribute("usuario_logueado");
				String nickUser = user.getNickname();
				response.sendRedirect("/DynamicTurismo.uy/Usuarios?user=" + nickUser);
				break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
