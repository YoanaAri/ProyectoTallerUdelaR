package presentacion;
import logica.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import logica.Fabrica;
import logica.IControladorUsuario;
import logica.IControladorDepartamentos;

import javax.swing.JMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Service.Publicador;
import Service.Publicador;
public class Main {
	private JFrame frmGestionTurismo;
	private IControladorUsuario ICU;
	private IControladorDepartamentos ICD;
	private AceptarRechazarActividad AcepRecActFrame;
	private AltaUsuario AltaUsuarioFrame;
	private AltaDepartamento AltaDepFrame;
	private AltaActividadTuristica AltaActiTurFrame;
	private AltaSalidaTuristica AltaSTFrame;
	private InscripcionSalidaTuristica InscSTFrame;
	public static ConsultaActividadTuristica ConsulATFrame;
	public static ConsultaSalida ConsulSTFrame;
	private ConsultaSalida ConsultaSTFrame;
	private ConsultaUsuario ConsultaUFrame;
	private cargarDatos CargarDatos;
	private AltaCategoria AltaCategoriaFrame;
	
	
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main window = new Main();
                    window.frmGestionTurismo.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public Main() {
        initialize();
        try {
			Publicador.publicar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //Inicializacion
        Fabrica fabrica = Fabrica.getInstance();
        ICU = fabrica.getIControladorUsuario();
        ICD = fabrica.getIControladorDepartamentos();
        
        frmGestionTurismo.getContentPane().setLayout(null);
        frmGestionTurismo.setSize(800, 600);
        
        AltaUsuarioFrame = new AltaUsuario(ICU);
        AltaUsuarioFrame.setVisible(false);
        frmGestionTurismo.getContentPane().add(AltaUsuarioFrame);
        
        AcepRecActFrame = new AceptarRechazarActividad(ICD);
        AcepRecActFrame.setVisible(false);
        frmGestionTurismo.getContentPane().add(AcepRecActFrame);

        AltaActiTurFrame = new AltaActividadTuristica(ICD, ICU);
        AltaActiTurFrame.setVisible(false);
        frmGestionTurismo.getContentPane().add(AltaActiTurFrame);
        AltaActiTurFrame.setSize(600, 500);

        AltaSTFrame = new AltaSalidaTuristica(ICD);
        AltaSTFrame.setVisible(false);
        frmGestionTurismo.getContentPane().add(AltaSTFrame);

        InscSTFrame = new InscripcionSalidaTuristica(ICD, ICU);
        InscSTFrame.setVisible(false);
        frmGestionTurismo.getContentPane().add(InscSTFrame);

        ConsulATFrame = new ConsultaActividadTuristica(ICD);
        ConsulATFrame.setVisible(false);
        frmGestionTurismo.getContentPane().add(ConsulATFrame);

        ConsulSTFrame = new ConsultaSalida(ICD);
        ConsulSTFrame.setVisible(false);
        frmGestionTurismo.getContentPane().add(ConsulSTFrame);

        ConsultaUFrame = new ConsultaUsuario(ICU, ICD);
        ConsultaUFrame.setVisible(false);
        frmGestionTurismo.getContentPane().add(ConsultaUFrame);

        AltaCategoriaFrame = new AltaCategoria(ICD);
        AltaCategoriaFrame.setVisible(false);
        frmGestionTurismo.getContentPane().add(AltaCategoriaFrame);

        

    }
    
    private void initialize() {
    	frmGestionTurismo = new JFrame();
		frmGestionTurismo.setTitle("Gestion Turismo");
		frmGestionTurismo.setBounds(100, 100, 450, 400);
		frmGestionTurismo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmGestionTurismo.setJMenuBar(menuBar);
		
		JMenu menuSistema = new JMenu("Sistema");
	    menuBar.add(menuSistema);
		
		JMenuItem menuSalir = new JMenuItem("Salir");
		menuSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frmGestionTurismo.setVisible(false);
                frmGestionTurismo.dispose();
            }
        });
        menuSistema.add(menuSalir);
        
        JMenu menuUsuarios = new JMenu("Usuarios");
        menuBar.add(menuUsuarios);
        
        JMenu menuActividades = new JMenu("Actividades");
        menuBar.add(menuActividades);
        
        JMenuItem menuItemCargaDatos = new JMenuItem("Cargar Datos");
        menuItemCargaDatos.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CargarDatos = new cargarDatos(ICU, ICD);
        		
        	}
        });

        JMenuItem menuItemAltaUsuario = new JMenuItem("Registrar Usuario");
        menuItemAltaUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//            	AltaUsuarioFrame = new AltaUsuario(ICU);
//            	frmGestionTurismo.getContentPane().add(AltaUsuarioFrame);
            	AltaUsuarioFrame.setVisible(true);
            }
        });
        
        JMenuItem menuItemAltaAT = new JMenuItem("Registrar Actividad Turistica");
        menuItemAltaAT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                AltaActiTurFrame = new AltaActividadTuristica(ICD, ICU);
//                frmGestionTurismo.getContentPane().add(AltaActiTurFrame);
            	AltaActiTurFrame.cargarDepartamentos();
            	AltaActiTurFrame.cargarProveedores();
            	//AltaActiTurFrame.cargarCategorias();
                AltaActiTurFrame.setVisible(true);
            }
        });
        
        JMenuItem menuItemAcepRec = new JMenuItem("Aceptar/Rechazar Actividad Turistica");
        menuItemAcepRec.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                AltaActiTurFrame = new AltaActividadTuristica(ICD, ICU);
//                frmGestionTurismo.getContentPane().add(AltaActiTurFrame);
            	
            	AcepRecActFrame.setVisible(true);
            	AcepRecActFrame.cargarActividades();
            }
        });
        
        
        JMenuItem menuItemAltaST = new JMenuItem("Registrar Salida Turistica");
        menuItemAltaST.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//            	AltaSTFrame = new AltaSalidaTuristica(ICD);
//            	frmGestionTurismo.getContentPane().add(AltaSTFrame);
            	AltaSTFrame.cargarDepartamentos();
            	AltaSTFrame.setVisible(true);
            }
        });
        /*
        JMenuItem menuItemAltaDep = new JMenuItem("Registrar Departamento");
        menuItemAltaDep.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AltaDepFrame = new AltaDepartamento(ICD);
            }
        });
        */
        JMenuItem menuItemInscST = new JMenuItem("Inscripcion Salida Turistica");
        menuItemInscST.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//            	InscSTFrame = new InscripcionSalidaTuristica(ICD, ICU);
//                frmGestionTurismo.getContentPane().add(InscSTFrame);
            	InscSTFrame.cargarDepartamentos();
            	InscSTFrame.cargarTuristas();
                InscSTFrame.setVisible(true);
            }
        });
        JMenu menuConsultas = new JMenu("Consultas");
        menuBar.add(menuConsultas);
        
        JMenuItem menuItemConsultaAT = new JMenuItem("Actividades Turisticas");
        menuItemConsultaAT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//            	ConsulATFrame = new ConsultaActividadTuristica(ICD);
//                frmGestionTurismo.getContentPane().add(ConsulATFrame);
            	ConsulATFrame.panel.setVisible(false);
            	ConsulATFrame.cargarDepartamentos();
                ConsulATFrame.setVisible(true);
            }
        });
        
        
        ;
        
        JMenuItem menuItemConsultaST = new JMenuItem("Salidas Turisticas");
        menuItemConsultaST.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//            	ConsulSTFrame = new ConsultaSalida(ICD);
//                frmGestionTurismo.getContentPane().add(ConsulSTFrame);
            	ConsulSTFrame.cargarDepartamentos();
                ConsulSTFrame.setVisible(true);
            }
        });
        
        JMenuItem menuItemeConsultaU = new JMenuItem("Consulta Usuario");
        menuItemeConsultaU.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//            	ConsultaUFrame = new ConsultaUsuario(ICU);
//                frmGestionTurismo.getContentPane().add(ConsultaUFrame);
            	//ConsultaUFrame.clean();
            	ConsultaUFrame.cargarUsuarios();
                ConsultaUFrame.setVisible(true);
            }
        });
        
        JMenuItem menuItemAltaCategoria = new JMenuItem("Alta Categoria");
        menuItemAltaCategoria.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AltaCategoriaFrame.setVisible(true);
        	}
        });
        
        
        menuUsuarios.add(menuItemAltaUsuario);
        menuActividades.add(menuItemAcepRec);
        menuActividades.add(menuItemAltaAT);
        //menuActividades.add(menuItemAltaDep);
        menuActividades.add(menuItemAltaST);
        menuActividades.add(menuItemAltaCategoria);
        
        menuActividades.add(menuItemInscST);
        menuConsultas.add(menuItemConsultaAT);
        menuConsultas.add(menuItemConsultaST);
        
        menuConsultas.add(menuItemeConsultaU);
        menuSistema.add(menuItemCargaDatos);
    }
}
