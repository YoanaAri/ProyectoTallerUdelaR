package presentacion;

import logica.*;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import com.toedter.calendar.JCalendar;
import java.awt.FlowLayout;
import com.toedter.calendar.JDateChooser;

public class AltaSalidaTuristica extends JInternalFrame {

	private IControladorDepartamentos controlDep;

	private JTextField textFieldNombre,
			textFieldLugarSalida;

	private JLabel lblDepartamento,
			lblActividad,
			lblNombre,
			lblSaleDesde,
			lblFecha,
			lblCupos;

	private JComboBox comboBoxDepartamento,
			comboBoxActividad;

	private JSpinner spinnerCupos;

	private JButton btnConfirmar,
			btnCancelar;
	private JLabel lblNewLabel;
	private JSpinner spinner;

	private JPanel panel;
	private JDateChooser dateChooser;
	private JSpinner spinnerHora;
	private JSpinner spinnerMinuto;
	private JLabel dosPuntos;
	private JPanel panel_1;
	private JDateChooser dateChooser_1;
	private JSpinner spinnerHora_1;
	private JSpinner spinnerMinuto_1;
	private JLabel dosPuntos_1;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { AltaSalidaTuristica2 frame = new
	 * AltaSalidaTuristica2(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public AltaSalidaTuristica(IControladorDepartamentos icd) {
		setResizable(true);

		controlDep = icd;

		setIconifiable(true);
		setClosable(true);
		setTitle("Alta de salida turistica");
		setBounds(100, 100, 450, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 0, 0, 0, 10, 10};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);

		lblDepartamento = new JLabel("Departamento");
		GridBagConstraints gbc_lblDepartamento = new GridBagConstraints();
		gbc_lblDepartamento.anchor = GridBagConstraints.WEST;
		gbc_lblDepartamento.insets = new Insets(0, 0, 5, 5);
		gbc_lblDepartamento.gridx = 1;
		gbc_lblDepartamento.gridy = 1;
		getContentPane().add(lblDepartamento, gbc_lblDepartamento);

		lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 3;
		gbc_lblNombre.gridy = 1;
		getContentPane().add(lblNombre, gbc_lblNombre);

		textFieldNombre = new JTextField();
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.anchor = GridBagConstraints.WEST;
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNombre.gridx = 4;
		gbc_textFieldNombre.gridy = 1;
		getContentPane().add(textFieldNombre, gbc_textFieldNombre);
		textFieldNombre.setColumns(20);
		textFieldNombre.setEnabled(false);

		// Carga los departamentos al combo box
		comboBoxDepartamento = new JComboBox<String>();

		DefaultComboBoxModel<String> model;

		String[] s = new String[controlDep.getSetDepartamentos().size()];

		s = controlDep.getSetDepartamentos().toArray(s);

		model = new DefaultComboBoxModel<String>(s);
		comboBoxDepartamento.setModel(model);

		GridBagConstraints gbc_comboBoxDepartamento = new GridBagConstraints();
		gbc_comboBoxDepartamento.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxDepartamento.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxDepartamento.gridx = 1;
		gbc_comboBoxDepartamento.gridy = 2;
		getContentPane().add(comboBoxDepartamento, gbc_comboBoxDepartamento);

		lblFecha = new JLabel("Fecha:");
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 3;
		gbc_lblFecha.gridy = 2;
		getContentPane().add(lblFecha, gbc_lblFecha);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 4;
		gbc_panel.gridy = 2;
		getContentPane().add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		dateChooser = new JDateChooser();
		panel.add(dateChooser);

		spinnerHora = new JSpinner();
		spinnerHora.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		panel.add(spinnerHora);

		dosPuntos = new JLabel(":");
		panel.add(dosPuntos);

		spinnerMinuto = new JSpinner();
		spinnerMinuto.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		panel.add(spinnerMinuto);

		lblActividad = new JLabel("Actividad");
		GridBagConstraints gbc_lblActividad = new GridBagConstraints();
		gbc_lblActividad.insets = new Insets(0, 0, 5, 5);
		gbc_lblActividad.anchor = GridBagConstraints.WEST;
		gbc_lblActividad.gridx = 1;
		gbc_lblActividad.gridy = 3;
		getContentPane().add(lblActividad, gbc_lblActividad);

		lblSaleDesde = new JLabel("Sale desde:");
		GridBagConstraints gbc_lblSaleDesde = new GridBagConstraints();
		gbc_lblSaleDesde.anchor = GridBagConstraints.EAST;
		gbc_lblSaleDesde.insets = new Insets(0, 0, 5, 5);
		gbc_lblSaleDesde.gridx = 3;
		gbc_lblSaleDesde.gridy = 3;
		getContentPane().add(lblSaleDesde, gbc_lblSaleDesde);

		textFieldLugarSalida = new JTextField();
		GridBagConstraints gbc_textFieldLugarSalida = new GridBagConstraints();
		gbc_textFieldLugarSalida.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldLugarSalida.anchor = GridBagConstraints.WEST;
		gbc_textFieldLugarSalida.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldLugarSalida.gridx = 4;
		gbc_textFieldLugarSalida.gridy = 3;
		getContentPane().add(textFieldLugarSalida, gbc_textFieldLugarSalida);
		textFieldLugarSalida.setColumns(20);
		textFieldLugarSalida.setEnabled(false);

		comboBoxActividad = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxActividad = new GridBagConstraints();
		gbc_comboBoxActividad.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxActividad.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxActividad.gridx = 1;
		gbc_comboBoxActividad.gridy = 4;
		getContentPane().add(comboBoxActividad, gbc_comboBoxActividad);
		comboBoxActividad.setEnabled(false);

		lblCupos = new JLabel("Cupos:");
		GridBagConstraints gbc_lblCupos = new GridBagConstraints();
		gbc_lblCupos.insets = new Insets(0, 0, 5, 5);
		gbc_lblCupos.gridx = 3;
		gbc_lblCupos.gridy = 4;
		getContentPane().add(lblCupos, gbc_lblCupos);

		spinnerCupos = new JSpinner();
		spinnerCupos.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		GridBagConstraints gbc_spinnerCupos = new GridBagConstraints();
		gbc_spinnerCupos.ipadx = 15;
		gbc_spinnerCupos.anchor = GridBagConstraints.WEST;
		gbc_spinnerCupos.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerCupos.gridx = 4;
		gbc_spinnerCupos.gridy = 4;
		getContentPane().add(spinnerCupos, gbc_spinnerCupos);
		spinnerCupos.setEnabled(false);

		ActionListener clickDep = new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String departamento = (String) comboBoxDepartamento.getSelectedItem();

				DefaultComboBoxModel<String> modelAct;

				String[] actividades = new String[controlDep.getActividadesAgregadasXDep(departamento).size()];
				actividades = controlDep.getActividadesAgregadasXDep(departamento).keySet().toArray(actividades);

				modelAct = new DefaultComboBoxModel<String>(actividades);
				comboBoxActividad.setModel(modelAct);

				comboBoxActividad.setEnabled(true);

				comboBoxActividad.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

						textFieldNombre.setEnabled(true);
						textFieldLugarSalida.setEnabled(true);
						spinnerHora.setEnabled(true);
						spinnerMinuto.setEnabled(true);
						dateChooser.setEnabled(true);
						spinnerCupos.setEnabled(true);

					}
				});
			}
		};

		comboBoxDepartamento.addActionListener(clickDep);

		btnConfirmar = new JButton("Confirmar");
		GridBagConstraints gbc_btnConfirmar = new GridBagConstraints();
		gbc_btnConfirmar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnConfirmar.insets = new Insets(0, 0, 5, 0);
		gbc_btnConfirmar.gridx = 4;
		gbc_btnConfirmar.gridy = 7;
		getContentPane().add(btnConfirmar, gbc_btnConfirmar);

		btnConfirmar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String dep = (String) comboBoxDepartamento.getSelectedItem();

				String act = (String) comboBoxActividad.getSelectedItem();

				registrarSalidaTuristica(e, controlDep, dep, act);
			}
		});

		btnCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancelar.gridx = 4;
		gbc_btnCancelar.gridy = 8;
		getContentPane().add(btnCancelar, gbc_btnCancelar);

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
				setVisible(false);
			}
		});

	}

	protected void registrarSalidaTuristica(ActionEvent act, IControladorDepartamentos controlDep, String dep, String actividad) {

		String nombreSalida = textFieldNombre.getText();

		if (controlDep.existeSalida(nombreSalida)) {
			JOptionPane.showMessageDialog(this, "Ya existe una salida con el nombre ingresado", "Registrar salida", JOptionPane.ERROR_MESSAGE);
			textFieldNombre.setText("");
			return;
		}

		String lugarSalida = textFieldLugarSalida.getText();
		int cupos = (int) spinnerCupos.getValue();

		int diaSalida = dateChooser.getJCalendar().getDayChooser().getDay();
		int mesSalida = dateChooser.getJCalendar().getMonthChooser().getMonth();
		int anioSalida = dateChooser.getJCalendar().getYearChooser().getYear();
		LocalDateTime fechaSalida = LocalDateTime.of(anioSalida, mesSalida + 1, diaSalida, (int) spinnerHora.getValue(), (int) spinnerMinuto.getValue());

		
		LocalDateTime fechaAlta = LocalDateTime.now();

		DTInfo dti = new DTInfo(fechaSalida, lugarSalida);

		if (!checkFormulario()) {
			return;
		}

		controlDep.crearSalida(dep, actividad, nombreSalida, dti, fechaAlta, cupos);
		limpiarFormulario();
		// JOptionPane.showMessageDialog(this, "Se ha registrado la salida.");
		JOptionPane.showMessageDialog(null, "Se ha registrado la salida", "Alta Salida Turistica", JOptionPane.PLAIN_MESSAGE);

		setVisible(false);
	}

	private boolean checkFormulario() {
		String nombre = textFieldNombre.getText();
		String lugar = textFieldLugarSalida.getText();
		int diaSalida = dateChooser.getJCalendar().getDayChooser().getDay();
		int mesSalida = dateChooser.getJCalendar().getMonthChooser().getMonth();
		int anioSalida = dateChooser.getJCalendar().getYearChooser().getYear();
		LocalDateTime fechaSalida = LocalDateTime.of(anioSalida, mesSalida + 1, diaSalida, (int) spinnerHora.getValue(), (int) spinnerMinuto.getValue());

		if (nombre.isEmpty() || lugar.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacios.", "Registrar Salida Turistica", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (fechaSalida.isBefore(LocalDateTime.now())) {
			JOptionPane.showMessageDialog(null, "La fecha de salida no puede ser previa al dia de hoy.", "Registrar Salida Turistica", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	public void limpiarFormulario() {
		textFieldNombre.setText("");
		textFieldLugarSalida.setText("");
		spinnerCupos.setValue(1);

	}

	public void cargarDepartamentos() {
		DefaultComboBoxModel<String> model;
		String[] s = new String[controlDep.getSetDepartamentos().size()];
		s = controlDep.getSetDepartamentos().toArray(s);
		model = new DefaultComboBoxModel<String>(s);
		comboBoxDepartamento.setModel(model);
		if (s.length != 0)
			comboBoxDepartamento.setSelectedIndex(0);
	}

	public void clean() {
		textFieldNombre.setText("");
		textFieldLugarSalida.setText("");
	}

}
