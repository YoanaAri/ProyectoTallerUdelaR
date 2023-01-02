
package presentacion;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
//import java.awt.List;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import logica.IControladorDepartamentos;
import logica.IControladorUsuario;
import javax.swing.SpinnerNumberModel;
import com.toedter.calendar.JCalendar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AltaActividadTuristica extends JInternalFrame {
	// Componentes
	private JTextField fieldNombre;
	private Set<String> listaDepartamentos;
	private Set<String> listaCategorias;
	private JTextField fieldCosto;
	private JTextField fieldCiudad;
	private JTextArea fieldDescripcion;
	private IControladorDepartamentos ctrlDepartamento;
	private IControladorUsuario ctrlUsuario;
	private JComboBox comboBoxDepartamento,
			comboBoxProveedor;
	private JSpinner spinHoras;
	private JList<String> listCategorias;
	// Info de la AT
	String name;
	String descripcion;
	int duracion;
	int costo;
	String ciudad;
	int dia, mes,
			anio;
	LocalDate fechaAlta;
	String nameDep,
			nameProv;
	JOptionPane alertaMensaje;
	JInternalFrame esto;

	public AltaActividadTuristica(IControladorDepartamentos icd, IControladorUsuario icu) {
		// LISTA DEPARTAMENTOS
		listaDepartamentos = icd.getSetDepartamentos();

		// LISTA PROVEEDORES
		Set<String> listaProveedores = icu.getSetProveedor();
		String[] proveedores = listaProveedores.toArray(new String[0]);

		// String[] departamentos = listaDepartamentos.toArray(new String[0]);

		esto = this;
		ctrlDepartamento = icd;
		ctrlUsuario = icu;
		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Registrar Actividad Turistica");
		setBounds(10, 40, 585, 359);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{120, 0, 330, 0};
		gridBagLayout.rowHeights = new int[]{14, 95, 14, 0, 0, 130, 33, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Proveedor");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Info Actividad Turistica");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 0;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);

		comboBoxProveedor = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxProveedor = new GridBagConstraints();
		gbc_comboBoxProveedor.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxProveedor.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxProveedor.gridx = 0;
		gbc_comboBoxProveedor.gridy = 1;
		getContentPane().add(comboBoxProveedor, gbc_comboBoxProveedor);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridheight = 5;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 1;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{64, 126, 0};
		gbl_panel.rowHeights = new int[]{20, 85, 30, 20, 20, 32, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		panel.add(lblNombre, gbc_lblNombre);

		fieldNombre = new JTextField();
		GridBagConstraints gbc_fieldNombre = new GridBagConstraints();
		gbc_fieldNombre.anchor = GridBagConstraints.NORTH;
		gbc_fieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldNombre.insets = new Insets(0, 0, 5, 0);
		gbc_fieldNombre.gridx = 1;
		gbc_fieldNombre.gridy = 0;
		panel.add(fieldNombre, gbc_fieldNombre);
		fieldNombre.setColumns(10);

		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.anchor = GridBagConstraints.NORTH;
		gbc_lblDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 0;
		gbc_lblDescripcion.gridy = 1;
		panel.add(lblDescripcion, gbc_lblDescripcion);

		JScrollPane scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_2.gridx = 1;
		gbc_scrollPane_2.gridy = 1;
		panel.add(scrollPane_2, gbc_scrollPane_2);

		fieldDescripcion = new JTextArea();
		scrollPane_2.setViewportView(fieldDescripcion);
		fieldDescripcion.setLineWrap(true);

		JLabel lblDuracion = new JLabel("Duracion");
		GridBagConstraints gbc_lblDuracion = new GridBagConstraints();
		gbc_lblDuracion.anchor = GridBagConstraints.WEST;
		gbc_lblDuracion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDuracion.gridx = 0;
		gbc_lblDuracion.gridy = 2;
		panel.add(lblDuracion, gbc_lblDuracion);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 2;
		panel.add(panel_1, gbc_panel_1);

		spinHoras = new JSpinner();
		spinHoras.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		panel_1.add(spinHoras, "cell 0 0");

		JLabel lblHoras = new JLabel("Horas");
		panel_1.add(lblHoras, "cell 1 0");

		JLabel lblCosto = new JLabel("Costo");
		GridBagConstraints gbc_lblCosto = new GridBagConstraints();
		gbc_lblCosto.anchor = GridBagConstraints.WEST;
		gbc_lblCosto.insets = new Insets(0, 0, 5, 5);
		gbc_lblCosto.gridx = 0;
		gbc_lblCosto.gridy = 3;
		panel.add(lblCosto, gbc_lblCosto);

		fieldCosto = new JTextField();
		GridBagConstraints gbc_fieldCosto = new GridBagConstraints();
		gbc_fieldCosto.anchor = GridBagConstraints.NORTH;
		gbc_fieldCosto.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldCosto.insets = new Insets(0, 0, 5, 0);
		gbc_fieldCosto.gridx = 1;
		gbc_fieldCosto.gridy = 3;
		panel.add(fieldCosto, gbc_fieldCosto);
		fieldCosto.setColumns(10);

		JLabel lblCiudad = new JLabel("Ciudad");
		GridBagConstraints gbc_lblCiudad = new GridBagConstraints();
		gbc_lblCiudad.anchor = GridBagConstraints.WEST;
		gbc_lblCiudad.insets = new Insets(0, 0, 5, 5);
		gbc_lblCiudad.gridx = 0;
		gbc_lblCiudad.gridy = 4;
		panel.add(lblCiudad, gbc_lblCiudad);

		fieldCiudad = new JTextField();
		GridBagConstraints gbc_fieldCiudad = new GridBagConstraints();
		gbc_fieldCiudad.anchor = GridBagConstraints.NORTH;
		gbc_fieldCiudad.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldCiudad.insets = new Insets(0, 0, 5, 0);
		gbc_fieldCiudad.gridx = 1;
		gbc_fieldCiudad.gridy = 4;
		panel.add(fieldCiudad, gbc_fieldCiudad);
		fieldCiudad.setColumns(10);


		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 5;
		panel.add(panel_2, gbc_panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));


		comboBoxDepartamento = new JComboBox<String>();
		comboBoxDepartamento.setEnabled(true);
		GridBagConstraints gbc_comboBoxDepartamento = new GridBagConstraints();
		gbc_comboBoxDepartamento.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxDepartamento.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxDepartamento.gridx = 0;
		gbc_comboBoxDepartamento.gridy = 3;
		getContentPane().add(comboBoxDepartamento, gbc_comboBoxDepartamento);

		JLabel lblCategoria = new JLabel("Categoria");
		GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
		gbc_lblCategoria.anchor = GridBagConstraints.WEST;
		gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategoria.gridx = 0;
		gbc_lblCategoria.gridy = 4;
		getContentPane().add(lblCategoria, gbc_lblCategoria);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 5;
		getContentPane().add(scrollPane, gbc_scrollPane);

		JList<String> listCategorias = new JList<String>();

		listCategorias.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		scrollPane.setRowHeaderView(listCategorias);
		listCategorias.setValueIsAdjusting(true);
		scrollPane.setViewportView(listCategorias);
		listCategorias.setValueIsAdjusting(true);
		listCategorias.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		listCategorias.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				DefaultListModel<String> listmodel;
				String[] s = new String[ctrlDepartamento.getCategorias().size()];
				s = ctrlDepartamento.getCategorias().toArray(s);

				listmodel = new DefaultListModel<String>();

				for (int i = 0; i < s.length; i++) {

					listmodel.addElement(s[i]);

				}

				listCategorias.setModel(listmodel);

				listCategorias.setSelectedIndex(-1);

			}
		});

		/*
		 * listCategorias.addListSelectionListener(new ListSelectionListener() {
		 * public void valueChanged(ListSelectionEvent e) {
		 * 
		 * listCategorias.setSelectedIndex( listCategorias.getSelectedIndex() );
		 * 
		 * } });
		 */

		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 2;
		gbc_panel_3.gridy = 6;
		getContentPane().add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{75, 79, 0};
		gbl_panel_3.rowHeights = new int[]{23, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);

		JButton btnCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 0;
		gbc_btnCancelar.gridy = 0;
		panel_3.add(btnCancelar, gbc_btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clean();
				setVisible(false);
			}
		});

		JButton btnConfirmar = new JButton("Confirmar");
		GridBagConstraints gbc_btnConfirmar = new GridBagConstraints();
		gbc_btnConfirmar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnConfirmar.gridx = 1;
		gbc_btnConfirmar.gridy = 0;
		panel_3.add(btnConfirmar, gbc_btnConfirmar);

		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (verificar() && listCategorias.getSelectedIndex() != -1) {
					name = fieldNombre.getText();
					nameDep = comboBoxDepartamento.getSelectedItem().toString();
					nameProv = comboBoxProveedor.getSelectedItem().toString();

					List<String> categorias = listCategorias.getSelectedValuesList();
					// nameDep = jlistDep.getSelectedValue().toString();

					if (icd.existeActividadEnDepartamento(name, nameDep)) {
						// alertaMensaje = new JOptionPane();
						// alertaMensaje.setMessage("sad");
						// alertaMensaje.showMessageDialog(esto, "Ya existe una
						// Actividad Turistica con ese nombre");
						JOptionPane.showMessageDialog(null, "Ya existe una Actividad Turistica con ese nombre", "Alta Actividad Turistica", JOptionPane.ERROR_MESSAGE);
						fieldNombre.setText("");
					} else {
						boolean flag = true;
						descripcion = fieldDescripcion.getText();
						duracion = (int) spinHoras.getValue();

						// Excepcion por si no se ingresa un numero en el costo
						try {
							costo = Integer.parseInt(fieldCosto.getText());
						} catch (Exception s) {
							// alertaMensaje = new JOptionPane();
							// alertaMensaje.setMessage("sad");
							// alertaMensaje.showMessageDialog(esto, "El costo
							// ingresado no es un n�mero");
							JOptionPane.showMessageDialog(null, "El costo ingresado no es un número", "Alta Actividiad Turistica", JOptionPane.ERROR_MESSAGE);
							flag = false;
						}
						if (flag) {
							ciudad = fieldCiudad.getText();
							// fieldNombre.setText(fechaEnString);
							fechaAlta = LocalDate.now();
							icd.altaActividad(nameDep, nameProv, name, descripcion, duracion, costo, ciudad, fechaAlta, categorias);
							// alertaMensaje.showMessageDialog(esto, "Se ha
							// registrado con exito la Actividad Turistica");
							JOptionPane.showMessageDialog(null, "Se ha registrado con exito la Actividad Turistica", "Alta Actividiad Turistica", JOptionPane.PLAIN_MESSAGE);
							clean();
							setVisible(false);
						}

					}
				} else if (listCategorias.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null, "Se debe seleccionar al menos una Categoria", "Alta Actividiad Turistica", JOptionPane.ERROR_MESSAGE);

				}
			}
		});

		for (int i = 1; i <= 31; i++) {
			// comboDay.addItem(i);
		}
		for (int i = 1; i <= 12; i++) {
			// comboMonth.addItem(i);
		}
		for (int i = 2010; i <= 2025; i++) {
			// comboYear.addItem(i);
		}

	}

	// Verificacion un poco bruta de los campos
	protected boolean verificar() {
		if (fieldCosto.getText().isEmpty() || fieldCiudad.getText().isEmpty() || fieldDescripcion.getText().isEmpty()) {
			// alertaMensaje.showMessageDialog(esto, "Se debe completar todos
			// los campos");
			JOptionPane.showMessageDialog(null, "Se debe completar todos los campos", "Alta Actividiad Turistica", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (comboBoxDepartamento.getSelectedItem() == null || comboBoxProveedor.getSelectedItem() == null) {
			// alertaMensaje.showMessageDialog(esto, "Se debe seleccionar un
			// Proveedor y un Departamento");
			JOptionPane.showMessageDialog(null, "Se debe seleccionar un Proveedor y un Departamento", "Alta Actividiad Turistica", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		/*
		 * if(listCategorias.getSelectedIndex()== -1) {
		 * JOptionPane.showMessageDialog(null,
		 * "Se debe seleccionar al menos una Categoria"
		 * ,"Alta Actividiad Turistica",JOptionPane.ERROR_MESSAGE); return
		 * false; }
		 */
		return true;
	}

	public void clean() {
		fieldNombre.setText("");
		fieldCosto.setText("");
		fieldCiudad.setText("");
		fieldDescripcion.setText("");
		spinHoras.setValue(0);
	}

	public void cargarDepartamentos() {
		DefaultComboBoxModel<String> model;
		String[] s = new String[ctrlDepartamento.getSetDepartamentos().size()];
		s = ctrlDepartamento.getSetDepartamentos().toArray(s);
		model = new DefaultComboBoxModel<String>(s);
		comboBoxDepartamento.setModel(model);
		if (s.length != 0)
			comboBoxDepartamento.setSelectedIndex(0);
	}

	public void cargarProveedores() {
		DefaultComboBoxModel<String> model;
		String[] s = new String[ctrlUsuario.getProveedores().size()];
		s = ctrlUsuario.getProveedores().toArray(s);
		model = new DefaultComboBoxModel<String>(s);
		comboBoxProveedor.setModel(model);
		if (s.length != 0)
			comboBoxProveedor.setSelectedIndex(0);
	}
	public void cargarCategorias() {

		DefaultListModel<String> listmodel;
		String[] s = new String[ctrlDepartamento.getCategorias().size()];
		s = ctrlDepartamento.getCategorias().toArray(s);

		listmodel = new DefaultListModel<String>();

		for (int i = 0; i < s.length; i++) {

			listmodel.addElement(s[i]);

		}

		listCategorias.setModel(listmodel);

		if (s.length != 0)
			listCategorias.setSelectedIndex(0);

	}
}
