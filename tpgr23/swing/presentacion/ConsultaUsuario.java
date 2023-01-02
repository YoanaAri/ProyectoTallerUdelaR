
package presentacion;
import logica.*;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class ConsultaUsuario extends JInternalFrame {
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldFechaNac;
	private JTextField textFieldCorreo;
	private JTextField textFieldNacionalidad;
	private IControladorUsuario controlUsu;
	private IControladorDepartamentos controlDep;
	private JComboBox comboBoxUsuario;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { ConsultaUsuario2 frame = new
	 * ConsultaUsuario2(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public ConsultaUsuario(IControladorUsuario usu, IControladorDepartamentos dep) {
		setResizable(true);

		controlUsu = usu;
		controlDep = dep;
		setClosable(true);
		setTitle("Consulta de usuario");
		setBounds(100, 100, 720, 383);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 170, 0, 0, 156, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);

		JLabel lblUsuario = new JLabel("Usuario:");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.WEST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 1;
		gbc_lblUsuario.gridy = 1;
		getContentPane().add(lblUsuario, gbc_lblUsuario);

		JLabel lblNacionalidad = new JLabel("Nacionalidad:");
		GridBagConstraints gbc_lblNacionalidad = new GridBagConstraints();
		gbc_lblNacionalidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblNacionalidad.gridx = 4;
		gbc_lblNacionalidad.gridy = 1;
		getContentPane().add(lblNacionalidad, gbc_lblNacionalidad);
		lblNacionalidad.show(false);

		comboBoxUsuario = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxUsuario = new GridBagConstraints();
		gbc_comboBoxUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxUsuario.ipadx = 99;
		gbc_comboBoxUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxUsuario.gridx = 1;
		gbc_comboBoxUsuario.gridy = 2;
		getContentPane().add(comboBoxUsuario, gbc_comboBoxUsuario);

		textFieldNacionalidad = new JTextField();
		textFieldNacionalidad.setEditable(false);
		GridBagConstraints gbc_textFieldNacionalidad = new GridBagConstraints();
		gbc_textFieldNacionalidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNacionalidad.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNacionalidad.gridx = 4;
		gbc_textFieldNacionalidad.gridy = 2;
		getContentPane().add(textFieldNacionalidad, gbc_textFieldNacionalidad);
		textFieldNacionalidad.setColumns(10);
		textFieldNacionalidad.show(false);

		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 3;
		getContentPane().add(lblNombre, gbc_lblNombre);

		JLabel lblActividadesTuristicas = new JLabel("Actividades turisticas:");
		GridBagConstraints gbc_lblActividadesTuristicas = new GridBagConstraints();
		gbc_lblActividadesTuristicas.anchor = GridBagConstraints.WEST;
		gbc_lblActividadesTuristicas.insets = new Insets(0, 0, 5, 5);
		gbc_lblActividadesTuristicas.gridx = 3;
		gbc_lblActividadesTuristicas.gridy = 3;
		getContentPane().add(lblActividadesTuristicas, gbc_lblActividadesTuristicas);
		lblActividadesTuristicas.show(false);

		JLabel lblSalidasTuristicas = new JLabel("Salidas turisticas:");
		GridBagConstraints gbc_lblSalidasTuristicas = new GridBagConstraints();
		gbc_lblSalidasTuristicas.insets = new Insets(0, 0, 5, 5);
		gbc_lblSalidasTuristicas.gridx = 4;
		gbc_lblSalidasTuristicas.gridy = 3;
		getContentPane().add(lblSalidasTuristicas, gbc_lblSalidasTuristicas);
		lblSalidasTuristicas.show(false);

		textFieldNombre = new JTextField();
		textFieldNombre.setEditable(false);
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNombre.gridx = 1;
		gbc_textFieldNombre.gridy = 4;
		getContentPane().add(textFieldNombre, gbc_textFieldNombre);
		textFieldNombre.setColumns(10);

		JComboBox comboBoxActividades = new JComboBox<String>();
		comboBoxActividades.setEnabled(false);
		GridBagConstraints gbc_comboBoxActividades = new GridBagConstraints();
		gbc_comboBoxActividades.ipadx = 99;
		gbc_comboBoxActividades.anchor = GridBagConstraints.WEST;
		gbc_comboBoxActividades.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxActividades.gridx = 3;
		gbc_comboBoxActividades.gridy = 4;
		getContentPane().add(comboBoxActividades, gbc_comboBoxActividades);
		comboBoxActividades.show(false);

		JComboBox comboBoxSalidas = new JComboBox<String>();
		comboBoxSalidas.setEnabled(false);
		GridBagConstraints gbc_comboBoxSalidas = new GridBagConstraints();
		gbc_comboBoxSalidas.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxSalidas.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxSalidas.gridx = 4;
		gbc_comboBoxSalidas.gridy = 4;
		getContentPane().add(comboBoxSalidas, gbc_comboBoxSalidas);
		comboBoxSalidas.show(false);

		JLabel lblApellido = new JLabel("Apellido:");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.anchor = GridBagConstraints.WEST;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 1;
		gbc_lblApellido.gridy = 5;
		getContentPane().add(lblApellido, gbc_lblApellido);

		JLabel lblDescripcin = new JLabel("Descripción:");
		GridBagConstraints gbc_lblDescripcin = new GridBagConstraints();
		gbc_lblDescripcin.anchor = GridBagConstraints.WEST;
		gbc_lblDescripcin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcin.gridx = 3;
		gbc_lblDescripcin.gridy = 5;
		getContentPane().add(lblDescripcin, gbc_lblDescripcin);
		lblDescripcin.show(false);

		JLabel lblLink = new JLabel("Link:");
		GridBagConstraints gbc_lblLink = new GridBagConstraints();
		gbc_lblLink.anchor = GridBagConstraints.WEST;
		gbc_lblLink.insets = new Insets(0, 0, 5, 5);
		gbc_lblLink.gridx = 4;
		gbc_lblLink.gridy = 5;
		getContentPane().add(lblLink, gbc_lblLink);
		lblLink.show(false);

		textFieldApellido = new JTextField();
		textFieldApellido.setEditable(false);
		GridBagConstraints gbc_textFieldApellido = new GridBagConstraints();
		gbc_textFieldApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldApellido.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldApellido.gridx = 1;
		gbc_textFieldApellido.gridy = 6;
		getContentPane().add(textFieldApellido, gbc_textFieldApellido);
		textFieldApellido.setColumns(10);

		JTextArea textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setLineWrap(true);
		textAreaDescripcion.setWrapStyleWord(true);
		textAreaDescripcion.setEditable(false);
		GridBagConstraints gbc_textAreaDescripcion = new GridBagConstraints();
		gbc_textAreaDescripcion.gridheight = 5;
		gbc_textAreaDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaDescripcion.fill = GridBagConstraints.BOTH;
		gbc_textAreaDescripcion.gridx = 3;
		gbc_textAreaDescripcion.gridy = 6;
		getContentPane().add(textAreaDescripcion, gbc_textAreaDescripcion);
		textAreaDescripcion.show(false);

		JTextArea textAreaLink = new JTextArea();
		textAreaLink.setLineWrap(true);
		textAreaLink.setWrapStyleWord(true);
		textAreaLink.setEditable(false);
		GridBagConstraints gbc_textAreaLink = new GridBagConstraints();
		gbc_textAreaLink.gridheight = 3;
		gbc_textAreaLink.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaLink.fill = GridBagConstraints.BOTH;
		gbc_textAreaLink.gridx = 4;
		gbc_textAreaLink.gridy = 6;
		getContentPane().add(textAreaLink, gbc_textAreaLink);
		textAreaLink.show(false);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		GridBagConstraints gbc_lblFechaDeNacimiento = new GridBagConstraints();
		gbc_lblFechaDeNacimiento.anchor = GridBagConstraints.WEST;
		gbc_lblFechaDeNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeNacimiento.gridx = 1;
		gbc_lblFechaDeNacimiento.gridy = 7;
		getContentPane().add(lblFechaDeNacimiento, gbc_lblFechaDeNacimiento);

		textFieldFechaNac = new JTextField();
		textFieldFechaNac.setEditable(false);
		GridBagConstraints gbc_textFieldFechaNac = new GridBagConstraints();
		gbc_textFieldFechaNac.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldFechaNac.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldFechaNac.gridx = 1;
		gbc_textFieldFechaNac.gridy = 8;
		getContentPane().add(textFieldFechaNac, gbc_textFieldFechaNac);
		textFieldFechaNac.setColumns(10);

		JLabel lblCorreoElectrnico = new JLabel("Correo electrónico:");
		GridBagConstraints gbc_lblCorreoElectrnico = new GridBagConstraints();
		gbc_lblCorreoElectrnico.anchor = GridBagConstraints.WEST;
		gbc_lblCorreoElectrnico.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreoElectrnico.gridx = 1;
		gbc_lblCorreoElectrnico.gridy = 9;
		getContentPane().add(lblCorreoElectrnico, gbc_lblCorreoElectrnico);

		textFieldCorreo = new JTextField();
		textFieldCorreo.setEditable(false);
		GridBagConstraints gbc_textFieldCorreo = new GridBagConstraints();
		gbc_textFieldCorreo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCorreo.gridx = 1;
		gbc_textFieldCorreo.gridy = 10;
		getContentPane().add(textFieldCorreo, gbc_textFieldCorreo);
		textFieldCorreo.setColumns(10);

		JButton btnCerrar = new JButton("Cerrar");
		GridBagConstraints gbc_btnCerrar = new GridBagConstraints();
		gbc_btnCerrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCerrar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCerrar.gridx = 4;
		gbc_btnCerrar.gridy = 12;
		getContentPane().add(btnCerrar, gbc_btnCerrar);

		ActionListener clickC = new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				comboBoxActividades.show(false);
				comboBoxSalidas.show(false);
				lblActividadesTuristicas.setVisible(false);
				lblSalidasTuristicas.setVisible(false);
				textAreaDescripcion.setVisible(false);
				textAreaLink.setVisible(false);

				textFieldNombre.setText("");
				textFieldApellido.setText("");
				textFieldCorreo.setText("");
				textFieldFechaNac.setText("");
				textFieldNacionalidad.setText("");
				textFieldNacionalidad.show(false);
				lblNacionalidad.show(false);

				lblDescripcin.show(false);
				lblLink.show(false);
				textAreaDescripcion.setText("");
				textAreaLink.setText("");

				show(false);

				Main.ConsulSTFrame.comboBoxDepartamento.setEnabled(true);
				// Main.ConsulSTFrame.comboBoxActividad.setEnabled(true);
				// Main.ConsulSTFrame.comboBoxSalida.setEnabled(true);
				Main.ConsulATFrame.comboBoxDepartamento.setEnabled(true);
				// Main.ConsulATFrame.comboBoxActividad.setEnabled(true);
			}
		};

		btnCerrar.addActionListener(clickC);

		ActionListener clickU = new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String usuario = (String) comboBoxUsuario.getSelectedItem();
				Usuario user = controlUsu.getUsuario(usuario);
				String nombre = user.getnombre();
				String apellido = user.getapellido();
				String correo = user.getMail();
				LocalDate fecha = user.getFecha();

				if (user.getClass() == Turista.class) {
					String nacionalidad = ((Turista) user).getnacionalidad();
					textFieldNacionalidad.setText(nacionalidad);
					lblNacionalidad.show(true);
					textFieldNacionalidad.show(true);

					lblActividadesTuristicas.show(false);
					lblDescripcin.show(false);
					lblLink.show(false);

					textAreaDescripcion.show(false);
					textAreaLink.show(false);
					comboBoxActividades.show(false);

				} else {

					String Descripcion = ((Proveedor) user).getdescripcion();
					textAreaDescripcion.setText(Descripcion);
					String Link = ((Proveedor) user).getLink();
					textAreaLink.setText(Link);
					DefaultComboBoxModel<String> modelAct;
					String[] actividades = new String[controlUsu.getAvtividadesUsu(usuario).size()];
					actividades = controlUsu.getAvtividadesUsu(usuario).keySet().toArray(actividades);
					modelAct = new DefaultComboBoxModel<String>(actividades);
					comboBoxActividades.setModel(modelAct);
					comboBoxActividades.setEnabled(true);

					lblActividadesTuristicas.show(true);
					lblDescripcin.show(true);
					lblLink.show(true);

					textAreaDescripcion.show(true);
					textAreaLink.show(true);
					comboBoxActividades.show(true);

					lblNacionalidad.show(false);
					textFieldNacionalidad.show(false);
				}

				textFieldNombre.setText(nombre);
				textFieldApellido.setText(apellido);
				textFieldFechaNac.setText(fecha.toString());
				textFieldCorreo.setText(correo);

				DefaultComboBoxModel<String> model2;
				String[] salidas = new String[controlUsu.getSalidasUsu(usuario).size()];
				salidas = controlUsu.getSalidasUsu(usuario).keySet().toArray(salidas);
				model2 = new DefaultComboBoxModel<String>(salidas);

				// JComboBox comboBoxSalidasT = new JComboBox(salidas);
				comboBoxSalidas.setModel(model2);
				comboBoxSalidas.setEnabled(true);

				lblSalidasTuristicas.show(true);
				comboBoxSalidas.show(true);

			}
		};

		comboBoxUsuario.addActionListener(clickU);

		ActionListener clickA = new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String act = (String) comboBoxActividades.getSelectedItem();

				Main.ConsulATFrame.cargarDepartamentos();
				Main.ConsulATFrame.comboBoxDepartamento.setSelectedItem(controlDep.getDepartamentoXActividad(act));
				Main.ConsulATFrame.comboBoxActividad.setSelectedItem(act);
				Main.ConsulATFrame.setVisible(true);
				Main.ConsulATFrame.comboBoxDepartamento.setEnabled(false);
				Main.ConsulATFrame.comboBoxActividad.setEnabled(false);
			}
		};

		comboBoxActividades.addActionListener(clickA);

		ActionListener clickS = new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String sal = (String) comboBoxSalidas.getSelectedItem();
				String act = controlDep.getActividadXSalida(sal);

				Main.ConsulSTFrame.cargarDepartamentos();
				Main.ConsulSTFrame.comboBoxDepartamento.setSelectedItem(controlDep.getDepartamentoXActividad(act));
				Main.ConsulSTFrame.comboBoxActividad.setSelectedItem(act);
				Main.ConsulSTFrame.comboBoxSalida.setSelectedItem(sal);
				Main.ConsulSTFrame.setVisible(true);
				Main.ConsulSTFrame.comboBoxDepartamento.setEnabled(false);
				Main.ConsulSTFrame.comboBoxActividad.setEnabled(false);
				Main.ConsulSTFrame.comboBoxSalida.setEnabled(false);
			}
		};

		comboBoxSalidas.addActionListener(clickS);

	}

	public void cargarUsuarios() {
		DefaultComboBoxModel<String> model;
		String[] s = new String[controlUsu.getUsuario().size()];
		s = controlUsu.getUsuario().keySet().toArray(s);
		model = new DefaultComboBoxModel<String>(s);
		comboBoxUsuario.setModel(model);
	}

}
