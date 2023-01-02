package presentacion;

import java.awt.EventQueue;
import java.util.*;
import java.awt.GridBagConstraints;
import java.time.*;

import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import logica.*;
import java.awt.GridLayout;

public class ConsultaActividadTuristica extends JInternalFrame {
	
	private IControladorDepartamentos controlDep;
	
	private JTextField textFieldNombre, textFieldLugarSalida;
	
	private JLabel lblDepartamento, lblActividad, lblNombre, lblSaleDesde, lblFecha, lblCupos;
	
	public JComboBox comboBoxDepartamento, comboBoxActividad;
	
	private JSpinner spinnerFecha, spinnerCupos;
	
	private JButton btnConfirmar, btnCancelar;
	public JPanel panel;
	private JLabel lblNombreAct;
	private JLabel lblDescAct;
	private JLabel lblDuracionAct;
	private JLabel lblCostAct;
	private JLabel lblCiudadAct;
	private JLabel lblFechaAlta;
	private JLabel lblSalidasAct;
	private JTextField nombreAct;
	private JTextField duracionAct;
	private JTextField ciudadAct;
	private JTextField fechaAltaAct;
	private JTextField costoAct;
	private JComboBox comboBoxSalida;
	//private DatosSalidaTuristica DatosSTFrame;
	private JButton btnVerSalida;
	private JTextArea descripcionAct;
	private JScrollPane scrollPane;
	private JList<String> listCategorias;
	private JLabel lblNewLabel;
	
	

	/**
	 * Launch the application.
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InscripcionSalidaTuristica frame = new InscripcionSalidaTuristica();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 * Create the frame.
	 */
	public ConsultaActividadTuristica(IControladorDepartamentos icd) {
		setResizable(true);
		
		controlDep = icd;
		
		setIconifiable(true);
		setClosable(true);
		setTitle("Consulta de Actividad Turistica");
		setBounds(100, 100, 450, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {16, 104, 256, 10};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		//label "Departamento"
		
		lblDepartamento = new JLabel("Departamento");
		GridBagConstraints gbc_lblDepartamento = new GridBagConstraints();
		gbc_lblDepartamento.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblDepartamento.insets = new Insets(0, 0, 5, 5);
		gbc_lblDepartamento.gridx = 1;
		gbc_lblDepartamento.gridy = 1;
		getContentPane().add(lblDepartamento, gbc_lblDepartamento);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.ipadx = 99;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridheight = 9;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 1;
		getContentPane().add(panel, gbc_panel);
		panel.setVisible(false);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 103, 0, 0};
		gbl_panel.rowHeights = new int[]{29, 29, 29, 29, 29, 29, 29, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblNombreAct = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombreAct = new GridBagConstraints();
		gbc_lblNombreAct.fill = GridBagConstraints.VERTICAL;
		gbc_lblNombreAct.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreAct.gridx = 0;
		gbc_lblNombreAct.gridy = 0;
		panel.add(lblNombreAct, gbc_lblNombreAct);
		
		nombreAct = new JTextField();
		nombreAct.setEditable(false);
		GridBagConstraints gbc_nombreAct = new GridBagConstraints();
		gbc_nombreAct.gridwidth = 2;
		gbc_nombreAct.fill = GridBagConstraints.BOTH;
		gbc_nombreAct.insets = new Insets(0, 0, 5, 0);
		gbc_nombreAct.gridx = 1;
		gbc_nombreAct.gridy = 0;
		panel.add(nombreAct, gbc_nombreAct);
		nombreAct.setColumns(10);
		
		lblDescAct = new JLabel("Descripcion");
		GridBagConstraints gbc_lblDescAct = new GridBagConstraints();
		gbc_lblDescAct.fill = GridBagConstraints.VERTICAL;
		gbc_lblDescAct.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescAct.gridx = 0;
		gbc_lblDescAct.gridy = 1;
		panel.add(lblDescAct, gbc_lblDescAct);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		panel.add(scrollPane, gbc_scrollPane);
		
		descripcionAct = new JTextArea();
		descripcionAct.setLineWrap(true);
		scrollPane.setViewportView(descripcionAct);
		descripcionAct.setEditable(false);
		
		lblDuracionAct = new JLabel("Duracion");
		GridBagConstraints gbc_lblDuracionAct = new GridBagConstraints();
		gbc_lblDuracionAct.fill = GridBagConstraints.VERTICAL;
		gbc_lblDuracionAct.insets = new Insets(0, 0, 5, 5);
		gbc_lblDuracionAct.gridx = 0;
		gbc_lblDuracionAct.gridy = 2;
		panel.add(lblDuracionAct, gbc_lblDuracionAct);
		
		duracionAct = new JTextField();
		duracionAct.setEditable(false);
		GridBagConstraints gbc_duracionAct = new GridBagConstraints();
		gbc_duracionAct.gridwidth = 2;
		gbc_duracionAct.fill = GridBagConstraints.BOTH;
		gbc_duracionAct.insets = new Insets(0, 0, 5, 0);
		gbc_duracionAct.gridx = 1;
		gbc_duracionAct.gridy = 2;
		panel.add(duracionAct, gbc_duracionAct);
		duracionAct.setColumns(10);
		
		lblCostAct = new JLabel("Costo");
		GridBagConstraints gbc_lblCostAct = new GridBagConstraints();
		gbc_lblCostAct.fill = GridBagConstraints.VERTICAL;
		gbc_lblCostAct.insets = new Insets(0, 0, 5, 5);
		gbc_lblCostAct.gridx = 0;
		gbc_lblCostAct.gridy = 3;
		panel.add(lblCostAct, gbc_lblCostAct);
		
		costoAct = new JTextField();
		costoAct.setEditable(false);
		GridBagConstraints gbc_costoAct = new GridBagConstraints();
		gbc_costoAct.gridwidth = 2;
		gbc_costoAct.fill = GridBagConstraints.BOTH;
		gbc_costoAct.insets = new Insets(0, 0, 5, 0);
		gbc_costoAct.gridx = 1;
		gbc_costoAct.gridy = 3;
		panel.add(costoAct, gbc_costoAct);
		costoAct.setColumns(10);
		
		lblCiudadAct = new JLabel("Ciudad");
		GridBagConstraints gbc_lblCiudadAct = new GridBagConstraints();
		gbc_lblCiudadAct.fill = GridBagConstraints.VERTICAL;
		gbc_lblCiudadAct.insets = new Insets(0, 0, 5, 5);
		gbc_lblCiudadAct.gridx = 0;
		gbc_lblCiudadAct.gridy = 4;
		panel.add(lblCiudadAct, gbc_lblCiudadAct);
		
		ciudadAct = new JTextField();
		ciudadAct.setEditable(false);
		GridBagConstraints gbc_ciudadAct = new GridBagConstraints();
		gbc_ciudadAct.gridwidth = 2;
		gbc_ciudadAct.fill = GridBagConstraints.BOTH;
		gbc_ciudadAct.insets = new Insets(0, 0, 5, 0);
		gbc_ciudadAct.gridx = 1;
		gbc_ciudadAct.gridy = 4;
		panel.add(ciudadAct, gbc_ciudadAct);
		ciudadAct.setColumns(10);
		
		lblFechaAlta = new JLabel("Fecha Alta");
		GridBagConstraints gbc_lblFechaAlta = new GridBagConstraints();
		gbc_lblFechaAlta.fill = GridBagConstraints.VERTICAL;
		gbc_lblFechaAlta.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaAlta.gridx = 0;
		gbc_lblFechaAlta.gridy = 5;
		panel.add(lblFechaAlta, gbc_lblFechaAlta);
		
		fechaAltaAct = new JTextField();
		fechaAltaAct.setEditable(false);
		GridBagConstraints gbc_fechaAltaAct = new GridBagConstraints();
		gbc_fechaAltaAct.gridwidth = 2;
		gbc_fechaAltaAct.fill = GridBagConstraints.BOTH;
		gbc_fechaAltaAct.insets = new Insets(0, 0, 5, 0);
		gbc_fechaAltaAct.gridx = 1;
		gbc_fechaAltaAct.gridy = 5;
		panel.add(fechaAltaAct, gbc_fechaAltaAct);
		fechaAltaAct.setColumns(10);
		
		lblSalidasAct = new JLabel("Salidas");
		GridBagConstraints gbc_lblSalidasAct = new GridBagConstraints();
		gbc_lblSalidasAct.fill = GridBagConstraints.VERTICAL;
		gbc_lblSalidasAct.insets = new Insets(0, 0, 0, 5);
		gbc_lblSalidasAct.gridx = 0;
		gbc_lblSalidasAct.gridy = 6;
		panel.add(lblSalidasAct, gbc_lblSalidasAct);
		
		comboBoxSalida = new JComboBox();
		GridBagConstraints gbc_comboBoxSalida = new GridBagConstraints();
		gbc_comboBoxSalida.insets = new Insets(0, 0, 0, 5);
		gbc_comboBoxSalida.fill = GridBagConstraints.BOTH;
		gbc_comboBoxSalida.gridx = 1;
		gbc_comboBoxSalida.gridy = 6;
		panel.add(comboBoxSalida, gbc_comboBoxSalida);
		
		btnVerSalida = new JButton("Ver salida");
		GridBagConstraints gbc_btnVerSalida = new GridBagConstraints();
		gbc_btnVerSalida.gridx = 2;
		gbc_btnVerSalida.gridy = 6;
		panel.add(btnVerSalida, gbc_btnVerSalida);
		btnVerSalida.setEnabled(false);
		
		
//		DefaultComboBoxModel<String> model;
//		
//		String[] s = new String[controlDep.getSetDepartamentos().size()];
//				
//		s = controlDep.getSetDepartamentos().toArray(s);
//	
//		model = new DefaultComboBoxModel<String>(s);
//		
//		//Combobox que muestra los departamentos
//		
//		comboBoxDepartamento.setModel(model);
		
		comboBoxDepartamento = new JComboBox<String>();
		
		GridBagConstraints gbc_comboBoxDepartamento = new GridBagConstraints();
		gbc_comboBoxDepartamento.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxDepartamento.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxDepartamento.gridx = 1;
		gbc_comboBoxDepartamento.gridy = 2;
		getContentPane().add(comboBoxDepartamento, gbc_comboBoxDepartamento);
		
		
		
		
		
		//Label "Actividad"
		
		lblActividad = new JLabel("Actividad");
		GridBagConstraints gbc_lblActividad = new GridBagConstraints();
		gbc_lblActividad.insets = new Insets(0, 0, 5, 5);
		gbc_lblActividad.anchor = GridBagConstraints.WEST;
		gbc_lblActividad.gridx = 1;
		gbc_lblActividad.gridy = 3;
		getContentPane().add(lblActividad, gbc_lblActividad);
		
		//combobox que mustra las actividades
		
		comboBoxActividad = new JComboBox();
		GridBagConstraints gbc_comboBoxActividad = new GridBagConstraints();
		gbc_comboBoxActividad.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxActividad.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxActividad.gridx = 1;
		gbc_comboBoxActividad.gridy = 4;
		getContentPane().add(comboBoxActividad, gbc_comboBoxActividad);
		comboBoxActividad.setEnabled(false);
		
		lblNewLabel = new JLabel("Categorias");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 5;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		listCategorias = new JList<String>();
		listCategorias.setEnabled(false);
		GridBagConstraints gbc_listCategorias = new GridBagConstraints();
		gbc_listCategorias.gridheight = 4;
		gbc_listCategorias.insets = new Insets(0, 0, 5, 5);
		gbc_listCategorias.fill = GridBagConstraints.BOTH;
		gbc_listCategorias.gridx = 1;
		gbc_listCategorias.gridy = 6;
		getContentPane().add(listCategorias, gbc_listCategorias);
		
		
		
		//Evento de seleccionar Departamento
		
		ActionListener clickDep =new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				clean();
				
				String departamento = (String) comboBoxDepartamento.getSelectedItem();
				
				DefaultComboBoxModel modelAct;
				
				
				String[] actividades = new String[controlDep.getActividadesXDep(departamento).size()];
				actividades = controlDep.getActividadesXDep(departamento).keySet().toArray(actividades);
				
				modelAct = new DefaultComboBoxModel(actividades);
				
				comboBoxActividad.setModel(modelAct);
				if(actividades.length != 0) {
					comboBoxActividad.setEnabled(true);
					comboBoxActividad.setSelectedIndex(0);
				}else {
					comboBoxActividad.setEnabled(false);
					panel.setVisible(false);
				}				
			}
		};
		
		//Evento de seleccionar Actividad Turistica
		
		ActionListener clickAct =new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String actividad = (String) comboBoxActividad.getSelectedItem();
				String departamento = (String) comboBoxDepartamento.getSelectedItem();
				
				//tengo que usar get de todos los atributos de Actividad y mostrarlos
				
				DefaultListModel<String> listmodel;
        		String[] s = new String[controlDep.getActividadesXDep(departamento).get(actividad).getCategoriasDeActividad().size()];
        		s = controlDep.getActividadesXDep(departamento).get(actividad).getCategoriasDeActividad().toArray(s);
        		
        		listmodel = new DefaultListModel<String>();
        		
        		for (int i = 0; i < s.length; i++) {
        			
        			listmodel.addElement(s[i]);

        		}
        		
        		listCategorias.setModel(listmodel);
        		
        		listCategorias.setSelectedIndex(-1);
				
				nombreAct.setText(actividad);;
				
				String desc = controlDep.getActividadesXDep(departamento).get(actividad).getDescripcion();
				int dur = controlDep.getActividadesXDep(departamento).get(actividad).getDuracion();
				int cost = controlDep.getActividadesXDep(departamento).get(actividad).getCosto();
				String ciud = controlDep.getActividadesXDep(departamento).get(actividad).getCiudad();
				LocalDate alta = controlDep.getActividadesXDep(departamento).get(actividad).getFechaAlta();
				
				descripcionAct.setText(desc);
				duracionAct.setText(String.valueOf(dur));
				costoAct.setText(String.valueOf(cost));
				ciudadAct.setText(ciud);
								
				fechaAltaAct.setText(alta.toString());
				
				//y despues tengo que usar getSalidas para mostrar todas las salidas y abrir otro JInternalFrame que muestre
				//los datos de la salida seleccionada
				
				DefaultComboBoxModel<String> modelSal;
				
				String[] salidas = new String[controlDep.getActividadesXDep(departamento).get(actividad).getSalidas().size()];
				salidas = controlDep.getActividadesXDep(departamento).get(actividad).getSalidas().keySet().toArray(salidas);
			
				modelSal = new DefaultComboBoxModel<String>(salidas);
				comboBoxSalida.setModel(modelSal);
				if(salidas.length !=0) {
					comboBoxSalida.setEnabled(true);
					btnVerSalida.setEnabled(true);
					
				}else {
					comboBoxSalida.setEnabled(false);	
					btnVerSalida.setEnabled(false);
					
				}
				panel.setVisible(true);
				
			}
		};
		
		//Evento de seleccionar Salida Turistica
		
		ActionListener clickSal =new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				btnVerSalida.setEnabled(true);
				
			}
		};
		
		ActionListener verSal = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				String actividad = (String) comboBoxActividad.getSelectedItem();
//				String departamento = (String) comboBoxDepartamento.getSelectedItem();
//				String salida = (String) comboBoxSalida.getSelectedItem();
//				
//				DTSalida dts = controlDep.getActividadesXDep(departamento).get(actividad).getSalida(salida).getDTSalida();
//
//				String fechaSalida =  String.valueOf(dts.getSalida().getFecha().getDayOfMonth()) + "/" + 
//						String.valueOf(dts.getSalida().getFecha().getMonthValue()) + "/" + 
//						String.valueOf(dts.getSalida().getFecha().getYear()).substring(1) + "  " + 
//						String.valueOf(dts.getSalida().getFecha().getHour()) + ":" + 
//						String.valueOf(dts.getSalida().getFecha().getMinute());
//				
//				String fechaAlta =  String.valueOf(dts.getFechaAlta().getDayOfMonth()) + "/" + 
//						String.valueOf(dts.getFechaAlta().getMonthValue()) + "/" + 
//						String.valueOf(dts.getFechaAlta().getYear()).substring(1) + "  " + 
//						String.valueOf(dts.getFechaAlta().getHour()) + ":" + 
//						String.valueOf(dts.getFechaAlta().getMinute());
//				
//				String datosSalida =    "Nombre: " + salida + "\n" + 
//										"Fecha de salida: " + fechaSalida + "\n" + 
//										"Sale desde: " + dts.getSalida().getLugarSalida() + "\n" + 
//										"Cupos: " + String.valueOf(dts.getCupos()) + "\n" + 
//										"Fecha de alta: " + fechaAlta;
//				
//				JOptionPane.showMessageDialog(btnVerSalida, datosSalida);
				
				String sali = (String) comboBoxSalida.getSelectedItem();
				Main.ConsulSTFrame.cargarDepartamentos();
				String activ = controlDep.getActividadXSalida(sali);
				Main.ConsulSTFrame.comboBoxDepartamento.setSelectedItem(controlDep.getDepartamentoXActividad(activ));
				Main.ConsulSTFrame.comboBoxDepartamento.setEnabled(false);
				Main.ConsulSTFrame.comboBoxActividad.setSelectedItem(activ);
				Main.ConsulSTFrame.comboBoxActividad.setEnabled(false);
				Main.ConsulSTFrame.comboBoxSalida.setSelectedItem(sali);
				Main.ConsulSTFrame.comboBoxSalida.setEnabled(false);
				Main.ConsulSTFrame.toFront();
				toBack();
				Main.ConsulSTFrame.setVisible(true);
				
				/*DatosSTFrame = new DatosSalidaTuristica(icd, dts.getNombre(), fechaSalida, dts.getSalida().getLugarSalida(), String.valueOf(dts.getCupos()), fechaAlta);
				Main.frmGestionTurismo.getContentPane().add(DatosSTFrame);
                DatosSTFrame.setVisible(true);
                setVisible(false);
                DatosSTFrame.toFront();
                setVisible(true);
                try {
					DatosSTFrame.setSelected(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				
			}
		};
		
		
		
		
		
		
		
		
		
		comboBoxActividad.addActionListener(clickAct);
		comboBoxDepartamento.addActionListener(clickDep);
		comboBoxSalida.addActionListener(clickSal);
		btnVerSalida.addActionListener(verSal);
	}
	
	public void cargarDepartamentos() {
		DefaultComboBoxModel<String> model;
		String[] s = new String[controlDep.getSetDepartamentos().size()];	
		s = controlDep.getSetDepartamentos().toArray(s);
		model = new DefaultComboBoxModel<String>(s);
		comboBoxDepartamento.setModel(model);
		if (s.length != 0) comboBoxDepartamento.setSelectedIndex(0);
	}
	
	public void clean() {
		nombreAct.setText("");
		descripcionAct.setText("");
		duracionAct.setText("");
		costoAct.setText("");
		ciudadAct.setText("");
		fechaAltaAct.setText("");
	}
	
	

}
