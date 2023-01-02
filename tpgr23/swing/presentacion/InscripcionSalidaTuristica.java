package presentacion;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;

import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.time.format.DateTimeFormatter;

import logica.*;
import java.util.*;
import java.awt.List;
import java.awt.FlowLayout;
import com.toedter.calendar.JDateChooser;

public class InscripcionSalidaTuristica extends JInternalFrame {
	
	private IControladorDepartamentos controlDep;
	
	private IControladorUsuario controlUser;
	private JLabel lblDepartamento, lblActividad;
	private JComboBox comboBoxDepartamento, comboBoxActividad;
	private JButton btnConfirmar, btnCancelar;
	private JLabel lblSalidaTuristica;
	private JComboBox comboBoxSalida;
	private JLabel lblTuristas;
	private JLabel lblCantidad;
	private JLabel lblFecha;
	private JSpinner spinnerCant;
	private JButton btnConfirm;
	private JButton btnCancel;
	private Set<String> listaTuristas;
	
	String departamento;
	String actividad;
	String salidaTuristica;
	String turista;
	int cantidad;
	LocalDateTime date;
	JOptionPane alert;
	JInternalFrame inscripcion;
	private JComboBox comboBoxTurista;
	private JPanel panel;
	private JDateChooser dateChooser;
	//private JSpinner spinnerHora;
	//private JSpinner spinnerMinuto;
	private JLabel dosPuntos;
	

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
	public InscripcionSalidaTuristica(IControladorDepartamentos icd, IControladorUsuario icu) {
		setResizable(true);
		
		controlDep = icd;
		controlUser =icu;
		inscripcion = this;
		
		setIconifiable(true);
		setClosable(true);
		setTitle("Inscripcion a salida turistica");
		setBounds(100, 100, 450, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {10, 10, 10, 10, 10, 10};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 26, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		lblDepartamento = new JLabel("Departamento");
		GridBagConstraints gbc_lblDepartamento = new GridBagConstraints();
		gbc_lblDepartamento.insets = new Insets(0, 0, 5, 5);
		gbc_lblDepartamento.gridx = 1;
		gbc_lblDepartamento.gridy = 1;
		getContentPane().add(lblDepartamento, gbc_lblDepartamento);
		
		comboBoxDepartamento = new JComboBox<String>();
		
		DefaultComboBoxModel<String> model;
		
		String[] s = new String[controlDep.getSetDepartamentos().size()];
				
		s = controlDep.getSetDepartamentos().toArray(s);
	
		model = new DefaultComboBoxModel<String>(s);
		
		lblActividad = new JLabel("Actividad");
		GridBagConstraints gbc_lblActividad = new GridBagConstraints();
		gbc_lblActividad.insets = new Insets(0, 0, 5, 5);
		gbc_lblActividad.gridx = 2;
		gbc_lblActividad.gridy = 1;
		getContentPane().add(lblActividad, gbc_lblActividad);
		
		lblSalidaTuristica = new JLabel("Salidas Turisticas");
		GridBagConstraints gbc_lblSalidaTuristica = new GridBagConstraints();
		gbc_lblSalidaTuristica.insets = new Insets(0, 0, 5, 5);
		gbc_lblSalidaTuristica.gridx = 3;
		gbc_lblSalidaTuristica.gridy = 1;
		getContentPane().add(lblSalidaTuristica, gbc_lblSalidaTuristica);
		comboBoxDepartamento.setModel(model);
		
		GridBagConstraints gbc_comboBoxDepartamento = new GridBagConstraints();
		gbc_comboBoxDepartamento.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxDepartamento.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxDepartamento.gridx = 1;
		gbc_comboBoxDepartamento.gridy = 2;
		getContentPane().add(comboBoxDepartamento, gbc_comboBoxDepartamento);
		
		comboBoxActividad = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxActividad = new GridBagConstraints();
		gbc_comboBoxActividad.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxActividad.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxActividad.gridx = 2;
		gbc_comboBoxActividad.gridy = 2;
		getContentPane().add(comboBoxActividad, gbc_comboBoxActividad);
		comboBoxActividad.setEnabled(false);
		
		comboBoxSalida = new JComboBox<String>();
		comboBoxSalida.setEnabled(false);
		GridBagConstraints gbc_comboBoxSalida = new GridBagConstraints();
		gbc_comboBoxSalida.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxSalida.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxSalida.gridx = 3;
		gbc_comboBoxSalida.gridy = 2;
		getContentPane().add(comboBoxSalida, gbc_comboBoxSalida);
		
		listaTuristas = icu.getTuristas();
        String[] turistas = listaTuristas.toArray(new String[0]);
		lblTuristas = new JLabel("Turistas");
		GridBagConstraints gbc_lblTuristas = new GridBagConstraints();
		gbc_lblTuristas.insets = new Insets(0, 0, 5, 5);
		gbc_lblTuristas.gridx = 1;
		gbc_lblTuristas.gridy = 3;
		getContentPane().add(lblTuristas, gbc_lblTuristas);
		
		comboBoxTurista = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxTurista = new GridBagConstraints();
		gbc_comboBoxTurista.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxTurista.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxTurista.gridx = 1;
		gbc_comboBoxTurista.gridy = 4;
		getContentPane().add(comboBoxTurista, gbc_comboBoxTurista);
		
		lblCantidad = new JLabel("Cantidad Turistas");
		lblCantidad.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints gbc_lblCantidad = new GridBagConstraints();
		gbc_lblCantidad.anchor = GridBagConstraints.WEST;
		gbc_lblCantidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblCantidad.gridx = 2;
		gbc_lblCantidad.gridy = 4;
		getContentPane().add(lblCantidad, gbc_lblCantidad);
		
		spinnerCant = new JSpinner();
		spinnerCant.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		GridBagConstraints gbc_spinnerCant = new GridBagConstraints();
		gbc_spinnerCant.anchor = GridBagConstraints.WEST;
		gbc_spinnerCant.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerCant.gridx = 3;
		gbc_spinnerCant.gridy = 4;
		getContentPane().add(spinnerCant, gbc_spinnerCant);
		
		lblFecha = new JLabel("Fecha");
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.anchor = GridBagConstraints.WEST;
		gbc_lblFecha.fill = GridBagConstraints.VERTICAL;
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 2;
		gbc_lblFecha.gridy = 5;
		getContentPane().add(lblFecha, gbc_lblFecha);
		
		btnConfirm = new JButton("Confirmar");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 3;
		gbc_panel.gridy = 5;
		getContentPane().add(panel, gbc_panel);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("DD MM YYYY");
		panel.add(dateChooser);
		
		//spinnerHora = new JSpinner();
		//spinnerHora.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		//panel.add(spinnerHora);
		
		//dosPuntos = new JLabel(":");
		//panel.add(dosPuntos);
		
		//spinnerMinuto = new JSpinner();
		//spinnerMinuto.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		//panel.add(spinnerMinuto);
		GridBagConstraints gbc_btnConfirm = new GridBagConstraints();
		gbc_btnConfirm.insets = new Insets(0, 0, 5, 5);
		gbc_btnConfirm.gridx = 2;
		gbc_btnConfirm.gridy = 7;
		getContentPane().add(btnConfirm, gbc_btnConfirm);
		
		btnCancel = new JButton("Cancelar");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancel.gridx = 3;
		gbc_btnCancel.gridy = 7;
		getContentPane().add(btnCancel, gbc_btnCancel);
		
		ActionListener cerrar = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				formCleaner();
				comboBoxSalida.setEnabled(false);
				setVisible(false);
			}
		};
		
		btnCancel.addActionListener(cerrar);
		
		ActionListener clickDep =new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String departamento = (String) comboBoxDepartamento.getSelectedItem();
				DefaultComboBoxModel<String> modelAct;

				
				String[] actividades = new String[controlDep.getActividadesXDep(departamento).size()];
				actividades = controlDep.getActividadesXDep(departamento).keySet().toArray(actividades);
				
				modelAct = new DefaultComboBoxModel<String>(actividades);
				comboBoxActividad.setModel(modelAct);
								
				if (actividades.length != 0) {
					comboBoxActividad.setSelectedIndex(0);
					comboBoxActividad.setEnabled(true);
				}
				else {
					comboBoxActividad.setEnabled(false);
					comboBoxSalida.setEnabled(false);
				}
				
				comboBoxActividad.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						String act = (String) comboBoxActividad.getSelectedItem();
						String departamento = (String) comboBoxDepartamento.getSelectedItem();
						DefaultComboBoxModel<String> modelSal;		
						LocalDateTime now = LocalDateTime.now();
						String [] salidas = new String[controlDep.getSalidasXFecha(departamento, act, now ).size()];
						salidas = controlDep.getSalidasXFecha(departamento, act, now ).keySet().toArray(salidas);					
						modelSal = new DefaultComboBoxModel<String>(salidas);
						comboBoxSalida.setModel(modelSal);
						if(salidas.length != 0) {
							comboBoxSalida.setEnabled(true);
							spinnerCant.setEnabled(true);
							//spinnerMinuto.setEnabled(true);
							//spinnerHora.setEnabled(true);

						}else {
							comboBoxSalida.setEnabled(false);							
						}
						
					}
				});
			}
		};
		
		comboBoxDepartamento.addActionListener(clickDep);
		
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(formCompleto()) {
					departamento = comboBoxDepartamento.getSelectedItem().toString();
					actividad = comboBoxActividad.getSelectedItem().toString();
					salidaTuristica = comboBoxSalida.getSelectedItem().toString();
					cantidad = (Integer) spinnerCant.getValue();
					int diaSalida = dateChooser.getJCalendar().getDayChooser().getDay();
					int mesSalida = dateChooser.getJCalendar().getMonthChooser().getMonth();
					int anioSalida = dateChooser.getJCalendar().getYearChooser().getYear();
					date = LocalDateTime.of(anioSalida, mesSalida+1, diaSalida, 0, 0); 
					turista = comboBoxTurista.getSelectedItem().toString();
					int cuposDisp = icd.getActividadesXDep(departamento).get(actividad).getSalida(salidaTuristica).getCuposRestantes();
					//LocalDateTime fechaSalida = LocalDateTime.of(anioSalida, mesSalida + 1, diaSalida, (int) spinnerHora.getValue(), (int) spinnerMinuto.getValue()); 
					if(cantidad > cuposDisp) {
						JOptionPane.showMessageDialog(null, "Cantidad de cupos no disponible", "inscripcion", JOptionPane.ERROR_MESSAGE);
					}
					else if (icu.existeInscrip(salidaTuristica, turista)) {
						JOptionPane.showMessageDialog(null, "El turista ya esta registrado en la salida", "inscripcion", JOptionPane.ERROR_MESSAGE); 
					}
///////////////////////////////////////////////////////
					else if (date.isAfter(icd.getSalidaXActividad(salidaTuristica, actividad, departamento).getFechaSalida())) {
						JOptionPane.showMessageDialog(null, "La inscripción es posterior a la fecha de la salida", "inscripcion", JOptionPane.ERROR_MESSAGE); 
					}
					else {
						icu.registrarInscrip(cantidad, date, departamento, actividad, salidaTuristica, turista);
						icd.getActividadesXDep(departamento).get(actividad).getSalida(salidaTuristica).setCuposRestantes(cantidad);
						JOptionPane.showMessageDialog(null, "La inscripcion ha sido exitosa","inscripcion",JOptionPane.PLAIN_MESSAGE);
						formCleaner();
						comboBoxSalida.setEnabled(false);
						setVisible(false);
					}
				}
				else {
					alert = new JOptionPane();
					alert.showMessageDialog(null, "Por favor complete todos los campos", "inscripcion" , JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
		protected boolean formCompleto() {
			int cantTuris = (Integer) spinnerCant.getValue();
			if(comboBoxDepartamento.getSelectedIndex() == -1 || comboBoxActividad.getSelectedIndex() == -1  || comboBoxSalida.getSelectedIndex() == -1 || comboBoxTurista.getSelectedIndex() == -1 || cantTuris == 0) {
				return false;
			}
			else {			
				return true;
			}
		};
		
		protected void formCleaner() {
			spinnerCant.setValue(0);
			if(comboBoxActividad.getItemCount() != 0) {				
				comboBoxActividad.setSelectedIndex(0);
			}
			if(comboBoxSalida.getItemCount() != 0) {				
				comboBoxSalida.setSelectedIndex(0);				
			}
			
		};
		
		public void cargarDepartamentos() {
			DefaultComboBoxModel<String> model;
			String[] s = new String[controlDep.getSetDepartamentos().size()];	
			s = controlDep.getSetDepartamentos().toArray(s);
			model = new DefaultComboBoxModel<String>(s);
			comboBoxDepartamento.setModel(model);
			if (s.length != 0) comboBoxDepartamento.setSelectedIndex(0);
		}
		
		public void cargarTuristas() {
			DefaultComboBoxModel<String> model;
			String[] s = new String[controlUser.getTuristas().size()];	
			s = controlUser.getTuristas().toArray(s);
			model = new DefaultComboBoxModel<String>(s);
			comboBoxTurista.setModel(model);
			if (s.length != 0) comboBoxTurista.setSelectedIndex(0);
		}
}
