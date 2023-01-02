/*package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.*;
import java.time.format.*;

import logica.IControladorUsuario;
import java.awt.Dimension;

public class AltaUsuario extends JInternalFrame {
   
	private IControladorUsuario controlUser;	
	
	private JTextField textFieldNickname;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldMail;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textFieldNacionalidad;
	private JTextField textFieldDescripcion;
	private JTextField textFieldLink;
	private JComboBox comboBoxDia;
	private JComboBox comboBoxMes;
	private JComboBox comboBoxAnio;
	
	String nickname;
	String name;
	String lastName;
	String mail;
	String nationality;
	String description;
	String link;
	int dia;
	int mes;
	int anio;
	String sdia;
	String smes;
	String sanio;
	JOptionPane alert;
	JInternalFrame esto;
	

	public AltaUsuario(IControladorUsuario icu) {
		controlUser = icu;
		esto = this;
		
        setTitle("Registrar Usuario");

		setBounds(100, 100, 450, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
	
		
		JLabel lblNickname = new JLabel("Nickname");
		GridBagConstraints gbc_lblNickname = new GridBagConstraints();
		gbc_lblNickname.insets = new Insets(0, 0, 5, 5);
		gbc_lblNickname.anchor = GridBagConstraints.WEST;
		gbc_lblNickname.gridx = 0;
		gbc_lblNickname.gridy = 0;
		getContentPane().add(lblNickname, gbc_lblNickname);
		
		textFieldNickname = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		getContentPane().add(textFieldNickname, gbc_textField);
		textFieldNickname.setColumns(10);
		
		JLabel lblName = new JLabel("Nombre");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 1;
		getContentPane().add(lblName, gbc_lblName);
		
		textFieldNombre = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		getContentPane().add(textFieldNombre, gbc_textField_1);
		textFieldNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.anchor = GridBagConstraints.ABOVE_BASELINE_LEADING;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 0;
		gbc_lblApellido.gridy = 2;
		getContentPane().add(lblApellido, gbc_lblApellido);
		
		textFieldApellido = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 2;
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 2;
		getContentPane().add(textFieldApellido, gbc_textField_2);
		textFieldApellido.setColumns(10);
		
		JLabel lblMail = new JLabel("Mail");
		GridBagConstraints gbc_lblMail = new GridBagConstraints();
		gbc_lblMail.anchor = GridBagConstraints.WEST;
		gbc_lblMail.insets = new Insets(0, 0, 5, 5);
		gbc_lblMail.gridx = 0;
		gbc_lblMail.gridy = 3;
		getContentPane().add(lblMail, gbc_lblMail);
		
		textFieldMail = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 2;
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 3;
		getContentPane().add(textFieldMail, gbc_textField_3);
		textFieldMail.setColumns(10);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 4;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNacimiento = new JLabel("Fecha de Nacimiento");
		GridBagConstraints gbc_lblNacimiento = new GridBagConstraints();
		gbc_lblNacimiento.insets = new Insets(0, 0, 0, 5);
		gbc_lblNacimiento.anchor = GridBagConstraints.EAST;
		gbc_lblNacimiento.gridx = 0;
		gbc_lblNacimiento.gridy = 0;
		panel.add(lblNacimiento, gbc_lblNacimiento);
		
		comboBoxDia = new JComboBox();
		comboBoxDia.setPreferredSize(new Dimension(10, 21));
		comboBoxDia.setMaximumSize(new Dimension(16000, 32767));
		comboBoxDia.setMaximumRowCount(31);
		GridBagConstraints gbc_comboBoxDia = new GridBagConstraints();
		gbc_comboBoxDia.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxDia.insets = new Insets(0, 0, 0, 5);
		gbc_comboBoxDia.gridx = 1;
		gbc_comboBoxDia.gridy = 0;
		panel.add(comboBoxDia, gbc_comboBoxDia);
		for (int i=1; i<=31; i++) {
			comboBoxDia.addItem(i);
		}
		
		comboBoxMes = new JComboBox();
		comboBoxMes.setPreferredSize(new Dimension(10, 21));
		comboBoxMes.setMaximumSize(new Dimension(16000, 32767));
		comboBoxMes.setMaximumRowCount(12);
		GridBagConstraints gbc_comboBoxMes = new GridBagConstraints();
		gbc_comboBoxMes.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxMes.insets = new Insets(0, 0, 0, 5);
		gbc_comboBoxMes.gridx = 2;
		gbc_comboBoxMes.gridy = 0;
		panel.add(comboBoxMes, gbc_comboBoxMes);
		for (int i=1; i<=12; i++) {
			comboBoxMes.addItem(i);
		}
		
		comboBoxAnio = new JComboBox();
		comboBoxAnio.setPreferredSize(new Dimension(10, 21));
		comboBoxAnio.setMaximumSize(new Dimension(16000, 32767));
		comboBoxAnio.setMaximumRowCount(2022);
		GridBagConstraints gbc_comboBoxAnio = new GridBagConstraints();
		gbc_comboBoxAnio.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxAnio.gridx = 3;
		gbc_comboBoxAnio.gridy = 0;
		panel.add(comboBoxAnio, gbc_comboBoxAnio);
		for (int i=1900; i<=2022; i++) {
			comboBoxAnio.addItem(i);
		}
		
		JRadioButton rdbtnTurista = new JRadioButton("Turista");
		buttonGroup.add(rdbtnTurista);
		GridBagConstraints gbc_rdbtnTurista = new GridBagConstraints();
		gbc_rdbtnTurista.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnTurista.gridx = 1;
		gbc_rdbtnTurista.gridy = 5;
		getContentPane().add(rdbtnTurista, gbc_rdbtnTurista);
		rdbtnTurista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNacionalidad.setEnabled(true);
				textFieldDescripcion.setEnabled(false);
				textFieldLink.setEnabled(false);
			}});
		
		JRadioButton rdbtnPorveedor = new JRadioButton("Proveedor");
		buttonGroup.add(rdbtnPorveedor);
		GridBagConstraints gbc_rdbtnPorveedor = new GridBagConstraints();
		gbc_rdbtnPorveedor.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnPorveedor.gridx = 2;
		gbc_rdbtnPorveedor.gridy = 5;
		getContentPane().add(rdbtnPorveedor, gbc_rdbtnPorveedor);
		rdbtnPorveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNacionalidad.setEnabled(false);
				textFieldDescripcion.setEnabled(true);
				textFieldLink.setEnabled(true);
			}});
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad Turista");
		GridBagConstraints gbc_lblNacionalidad = new GridBagConstraints();
		gbc_lblNacionalidad.anchor = GridBagConstraints.WEST;
		gbc_lblNacionalidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblNacionalidad.gridx = 0;
		gbc_lblNacionalidad.gridy = 6;
		getContentPane().add(lblNacionalidad, gbc_lblNacionalidad);
		
				
				textFieldNacionalidad = new JTextField();
				GridBagConstraints gbc_textField_4 = new GridBagConstraints();
				gbc_textField_4.insets = new Insets(0, 0, 5, 0);
				gbc_textField_4.gridwidth = 2;
				gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_4.gridx = 1;
				gbc_textField_4.gridy = 6;
				getContentPane().add(textFieldNacionalidad, gbc_textField_4);
				textFieldNacionalidad.setColumns(10);
				textFieldNacionalidad.setEnabled(false);
		
		JLabel lblDescripcion = new JLabel("Descripcion General");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.anchor = GridBagConstraints.WEST;
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 0;
		gbc_lblDescripcion.gridy = 7;
		getContentPane().add(lblDescripcion, gbc_lblDescripcion);
		
		textFieldDescripcion = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.gridwidth = 2;
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 7;
		getContentPane().add(textFieldDescripcion, gbc_textField_5);
		textFieldDescripcion.setColumns(10);
		textFieldDescripcion.setEnabled(false);
		
		JLabel lblLink = new JLabel("Link");
		GridBagConstraints gbc_lblLink = new GridBagConstraints();
		gbc_lblLink.anchor = GridBagConstraints.WEST;
		gbc_lblLink.insets = new Insets(0, 0, 5, 5);
		gbc_lblLink.gridx = 0;
		gbc_lblLink.gridy = 8;
		getContentPane().add(lblLink, gbc_lblLink);
		
		textFieldLink = new JTextField();
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 0);
		gbc_textField_6.gridwidth = 2;
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 1;
		gbc_textField_6.gridy = 8;
		getContentPane().add(textFieldLink, gbc_textField_6);
		textFieldLink.setColumns(10);
		textFieldLink.setEnabled(false);
		
		JButton btnConfirmar = new JButton("Confirmar");
		GridBagConstraints gbc_btnConfirmar = new GridBagConstraints();
		gbc_btnConfirmar.insets = new Insets(0, 0, 0, 5);
		gbc_btnConfirmar.gridx = 1;
		gbc_btnConfirmar.gridy = 9;
		getContentPane().add(btnConfirmar, gbc_btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.gridx = 2;
		gbc_btnCancelar.gridy = 9;
		getContentPane().add(btnCancelar, gbc_btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                formCleaner();
                setVisible(false);
            }
        });
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(formCompleto()) {
					nickname = textFieldNickname.getText();
					mail = textFieldMail.getText();
					name = textFieldNombre.getText();
					lastName = textFieldApellido.getText();
					dia = (int) comboBoxDia.getSelectedItem();
					mes = (int) comboBoxMes.getSelectedItem();
					anio = (int) comboBoxAnio.getSelectedItem();
					String sDate = String.valueOf(anio * 10000 + mes * 100 + dia);
					DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");
					LocalDate date = LocalDate.parse(sDate,df);
					if(icu.existeNickname(nickname)) {
						alert = new JOptionPane();
						alert.showMessageDialog(esto, "El nickname ya esta en uso");
					}
					else if (icu.existeMail(mail)) {
						alert = new JOptionPane();
						alert.showMessageDialog(esto, "El mail ya esta en uso");
					}
					else{
						if(rdbtnTurista.isSelected()==true) {
							nationality = textFieldNacionalidad.getText();
							icu.AltaTurista(nickname, name, lastName, mail, date, nationality);
						}
						else {
							description = textFieldDescripcion.getText();
							link = textFieldLink.getText();
							icu.AltaProveedor(nickname, name, lastName, mail, date, description, link);
							
						}
						formCleaner();
						alert = new JOptionPane();
						alert.showMessageDialog(esto, "El usuario ha sido ingresado exitosamente");
					}
				}
				alert = new JOptionPane();
				alert.showMessageDialog(esto, "Por favor complete todos los campos");
			}
		});
	}
	protected void formCleaner() {
		textFieldNickname.setText("");
		textFieldNombre.setText("");
		textFieldApellido.setText("");
		textFieldMail.setText("");
		textFieldNacionalidad.setText("");
		textFieldDescripcion.setText("");
		textFieldLink.setText("");	
	};
	protected boolean formCompleto() {
		if(textFieldNickname.getText().isEmpty() || textFieldNombre.getText().isEmpty() || textFieldApellido.getText().isEmpty() || (textFieldNacionalidad.getText().isEmpty() && textFieldDescripcion.getText().isEmpty())||(comboBoxDia.getSelectedItem().toString().isEmpty() && comboBoxMes.getSelectedItem().toString().isEmpty() && comboBoxAnio.getSelectedItem().toString().isEmpty())) {
			return false;
		}
		else {			
			return true;
		}
	};
}
=======*/
package presentacion;

import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.*;
import java.time.format.*;
import java.util.Arrays;

import logica.IControladorUsuario;
import java.awt.Dimension;
import com.toedter.calendar.JDateChooser;

public class AltaUsuario extends JInternalFrame {
   
	private IControladorUsuario controlUser;	
	private JTextField textFieldNickname;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldMail;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textFieldNacionalidad;
	private JTextField textFieldDescripcion;
	private JTextField textFieldLink;
	
	String nickname;
	String name;
	String lastName;
	String mail;
	String nationality;
	String description;
	String link;
	int dia;
	int mes;
	int anio;
	JOptionPane alert;
	JInternalFrame altaUser;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	

	public AltaUsuario(IControladorUsuario icu) {
		setResizable(true);
		controlUser = icu;
		 altaUser= this;
		 
		setIconifiable(true);
		setClosable(true);
        setTitle("Registrar Usuario");

		setBounds(100, 100, 450, 331);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
	
		
		JLabel lblNickname = new JLabel("Nickname");
		GridBagConstraints gbc_lblNickname = new GridBagConstraints();
		gbc_lblNickname.insets = new Insets(0, 0, 5, 5);
		gbc_lblNickname.anchor = GridBagConstraints.WEST;
		gbc_lblNickname.gridx = 0;
		gbc_lblNickname.gridy = 0;
		getContentPane().add(lblNickname, gbc_lblNickname);
		
		textFieldNickname = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		getContentPane().add(textFieldNickname, gbc_textField);
		textFieldNickname.setColumns(10);
		
		JLabel lblName = new JLabel("Nombre");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 1;
		getContentPane().add(lblName, gbc_lblName);
		
		textFieldNombre = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		getContentPane().add(textFieldNombre, gbc_textField_1);
		textFieldNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.anchor = GridBagConstraints.ABOVE_BASELINE_LEADING;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 0;
		gbc_lblApellido.gridy = 2;
		getContentPane().add(lblApellido, gbc_lblApellido);
		
		textFieldApellido = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 2;
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 2;
		getContentPane().add(textFieldApellido, gbc_textField_2);
		textFieldApellido.setColumns(10);
		
		JLabel lblMail = new JLabel("Mail");
		GridBagConstraints gbc_lblMail = new GridBagConstraints();
		gbc_lblMail.anchor = GridBagConstraints.WEST;
		gbc_lblMail.insets = new Insets(0, 0, 5, 5);
		gbc_lblMail.gridx = 0;
		gbc_lblMail.gridy = 3;
		getContentPane().add(lblMail, gbc_lblMail);
		
		textFieldMail = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 2;
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 3;
		getContentPane().add(textFieldMail, gbc_textField_3);
		textFieldMail.setColumns(10);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 4;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNacimiento = new JLabel("Fecha de Nacimiento");
		GridBagConstraints gbc_lblNacimiento = new GridBagConstraints();
		gbc_lblNacimiento.insets = new Insets(0, 0, 0, 5);
		gbc_lblNacimiento.anchor = GridBagConstraints.EAST;
		gbc_lblNacimiento.gridx = 0;
		gbc_lblNacimiento.gridy = 0;
		panel.add(lblNacimiento, gbc_lblNacimiento);
		
		JDateChooser dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.gridwidth = 2;
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 2;
		gbc_dateChooser.gridy = 0;
		panel.add(dateChooser, gbc_dateChooser);
		
		JRadioButton rdbtnTurista = new JRadioButton("Turista");
		rdbtnTurista.setSelected(true);
		buttonGroup.add(rdbtnTurista);
		GridBagConstraints gbc_rdbtnTurista = new GridBagConstraints();
		gbc_rdbtnTurista.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnTurista.gridx = 1;
		gbc_rdbtnTurista.gridy = 5;
		getContentPane().add(rdbtnTurista, gbc_rdbtnTurista);
		rdbtnTurista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNacionalidad.setEnabled(true);
				textFieldDescripcion.setEnabled(false);
				textFieldLink.setEnabled(false);
			}});
		
		JRadioButton rdbtnPorveedor = new JRadioButton("Proveedor");
		buttonGroup.add(rdbtnPorveedor);
		GridBagConstraints gbc_rdbtnPorveedor = new GridBagConstraints();
		gbc_rdbtnPorveedor.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnPorveedor.gridx = 2;
		gbc_rdbtnPorveedor.gridy = 5;
		getContentPane().add(rdbtnPorveedor, gbc_rdbtnPorveedor);
		rdbtnPorveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNacionalidad.setEnabled(false);
				textFieldDescripcion.setEnabled(true);
				textFieldLink.setEnabled(true);
			}});
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad Turista");
		GridBagConstraints gbc_lblNacionalidad = new GridBagConstraints();
		gbc_lblNacionalidad.anchor = GridBagConstraints.WEST;
		gbc_lblNacionalidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblNacionalidad.gridx = 0;
		gbc_lblNacionalidad.gridy = 6;
		getContentPane().add(lblNacionalidad, gbc_lblNacionalidad);
		
				
				textFieldNacionalidad = new JTextField();
				GridBagConstraints gbc_textField_4 = new GridBagConstraints();
				gbc_textField_4.insets = new Insets(0, 0, 5, 0);
				gbc_textField_4.gridwidth = 2;
				gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_4.gridx = 1;
				gbc_textField_4.gridy = 6;
				getContentPane().add(textFieldNacionalidad, gbc_textField_4);
				textFieldNacionalidad.setColumns(10);
				textFieldNacionalidad.setEnabled(false);
		
		JLabel lblDescripcion = new JLabel("Descripcion General");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.anchor = GridBagConstraints.WEST;
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 0;
		gbc_lblDescripcion.gridy = 7;
		getContentPane().add(lblDescripcion, gbc_lblDescripcion);
		
		textFieldDescripcion = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.gridwidth = 2;
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 7;
		getContentPane().add(textFieldDescripcion, gbc_textField_5);
		textFieldDescripcion.setColumns(10);
		textFieldDescripcion.setEnabled(false);
		
		JLabel lblLink = new JLabel("Link");
		GridBagConstraints gbc_lblLink = new GridBagConstraints();
		gbc_lblLink.anchor = GridBagConstraints.WEST;
		gbc_lblLink.insets = new Insets(0, 0, 5, 5);
		gbc_lblLink.gridx = 0;
		gbc_lblLink.gridy = 8;
		getContentPane().add(lblLink, gbc_lblLink);
		
		textFieldLink = new JTextField();
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 0);
		gbc_textField_6.gridwidth = 2;
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 1;
		gbc_textField_6.gridy = 8;
		getContentPane().add(textFieldLink, gbc_textField_6);
		textFieldLink.setColumns(10);
		textFieldLink.setEnabled(false);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.anchor = GridBagConstraints.WEST;
		gbc_lblContrasea.gridx = 0;
		gbc_lblContrasea.gridy = 9;
		getContentPane().add(lblContrasea, gbc_lblContrasea);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 2;
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 9;
		getContentPane().add(passwordField, gbc_passwordField);
		
		JLabel lblConfirmarContrasea = new JLabel("Confirmar Contrase\u00F1a");
		GridBagConstraints gbc_lblConfirmarContrasea = new GridBagConstraints();
		gbc_lblConfirmarContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfirmarContrasea.anchor = GridBagConstraints.WEST;
		gbc_lblConfirmarContrasea.gridx = 0;
		gbc_lblConfirmarContrasea.gridy = 10;
		getContentPane().add(lblConfirmarContrasea, gbc_lblConfirmarContrasea);
		
		passwordField_1 = new JPasswordField();
		GridBagConstraints gbc_passwordField_1 = new GridBagConstraints();
		gbc_passwordField_1.gridwidth = 2;
		gbc_passwordField_1.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField_1.gridx = 1;
		gbc_passwordField_1.gridy = 10;
		getContentPane().add(passwordField_1, gbc_passwordField_1);
		
		JButton btnConfirmar = new JButton("Confirmar");
		GridBagConstraints gbc_btnConfirmar = new GridBagConstraints();
		gbc_btnConfirmar.insets = new Insets(0, 0, 0, 5);
		gbc_btnConfirmar.gridx = 1;
		gbc_btnConfirmar.gridy = 11;
		getContentPane().add(btnConfirmar, gbc_btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.gridx = 2;
		gbc_btnCancelar.gridy = 11;
		getContentPane().add(btnCancelar, gbc_btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                formCleaner();
                setVisible(false);
            }
        });
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(formCompleto()) {
					nickname = textFieldNickname.getText();
					mail = textFieldMail.getText();
					name = textFieldNombre.getText();
					lastName = textFieldApellido.getText();
					int dia = dateChooser.getJCalendar().getDayChooser().getDay();
					int mes = dateChooser.getJCalendar().getMonthChooser().getMonth() + 1;
					int anio = dateChooser.getJCalendar().getYearChooser().getYear();
					String sDate = String.valueOf(anio * 10000 + mes * 100 + dia);
					DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");
					LocalDate date = LocalDate.parse(sDate,df);
					if(icu.existeNickname(nickname)) {
						//alert = new JOptionPane();
						//alert.showMessageDialog(altaUser, "El nickname ya esta en uso");
						JOptionPane.showMessageDialog(null, "El nickname ya esta en uso", "Registrar Usuario", JOptionPane.ERROR_MESSAGE);

					}
					else if (icu.existeMail(mail)) {
						//alert = new JOptionPane();
						//alert.showMessageDialog(altaUser, "El mail ya esta en uso");
						JOptionPane.showMessageDialog(null, "El mail ya esta en uso", "Registrar Usuario", JOptionPane.ERROR_MESSAGE);
					}
					else if(!Arrays.equals(passwordField_1.getPassword(), passwordField.getPassword())) {
						passwordField_1.setText("");
						passwordField.setText("");
						JOptionPane.showMessageDialog(null, "La contraseña debe ser la misma en ambos campos", "Registrar Usuario", JOptionPane.ERROR_MESSAGE);
					}
					else if(passwordField_1.getPassword().length == 0) {
						JOptionPane.showMessageDialog(null, "Debe ingresar una contraseña", "Registrar Usuario", JOptionPane.ERROR_MESSAGE);
					}
					else{
						if(rdbtnTurista.isSelected()==true) {
							nationality = textFieldNacionalidad.getText();
							String pass= passwordField_1.getText();
							icu.altaTurista(nickname, name, lastName, mail, date, nationality,pass);
						}
						else {
							description = textFieldDescripcion.getText();
							link = textFieldLink.getText();
							String pass= passwordField_1.getText();
							icu.altaProveedor(nickname, name, lastName, mail, date, description, link,pass);
							
						}
						formCleaner();
						//alert = new JOptionPane();
						//alert.showMessageDialog(altaUser, "El usuario ha sido ingresado exitosamente");
						JOptionPane.showMessageDialog(null, "El usuario ha sido ingresado exitosamente", "Registrar Usuario", JOptionPane.PLAIN_MESSAGE);
						setVisible(false);
					}
				}
				else {
					//alert = new JOptionPane();
					//alert.showMessageDialog(altaUser, "Por favor complete todos los campos");
					JOptionPane.showMessageDialog(null, "Por favor complete todos los campos", "Registrar Usuario", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
	}
	protected void formCleaner() {
		textFieldNickname.setText("");
		textFieldNombre.setText("");
		textFieldApellido.setText("");
		textFieldMail.setText("");
		textFieldNacionalidad.setText("");
		textFieldDescripcion.setText("");
		textFieldLink.setText("");
		passwordField_1.setText("");
		passwordField.setText("");
	};
	protected boolean formCompleto() {
		if(textFieldNickname.getText().isEmpty() || textFieldNombre.getText().isEmpty() || textFieldApellido.getText().isEmpty() || (textFieldNacionalidad.getText().isEmpty() && textFieldDescripcion.getText().isEmpty())) {
			return false;
		}
		else {			
			return true;
		}
	};
}

