package presentacion;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import logica.EstadoActividad;
import logica.IControladorDepartamentos;

public class AceptarRechazarActividad extends JInternalFrame {

	private IControladorDepartamentos ctrlDepartamento;
	private JComboBox<String> ComboBox; 
	private String nameAct;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public AceptarRechazarActividad(IControladorDepartamentos ctrlDepartamento) {
		
		this.ctrlDepartamento = ctrlDepartamento;
		
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setTitle("Aceptar o Rechazar Actividad Turistica");
		setBounds(100, 100, 450, 169);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Actividad Turistica");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.ABOVE_BASELINE_LEADING;
		gbc_lblNewLabel.gridwidth = 4;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		ComboBox = new JComboBox<String>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 3;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 5;
		gbc_comboBox.gridy = 1;
		getContentPane().add(ComboBox, gbc_comboBox);
		
		JButton btnNewButton = new JButton("Rechazar");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 6;
		gbc_btnNewButton.gridy = 3;
		getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public  void actionPerformed(ActionEvent e) {
				if(ComboBox.getSelectedItem()==null) {
					JOptionPane.showMessageDialog(null, "Se debe seleccionar una Actividad", "Alta Actividiad Turistica", JOptionPane.ERROR_MESSAGE);
				}else {
					nameAct=ComboBox.getSelectedItem().toString();
					ctrlDepartamento.aceptarActividad(nameAct, EstadoActividad.Rechazada);
					setVisible(false);
					ComboBox.removeAllItems();
				}
				
			}
		});
		
		
		
		JButton btnNewButton_1 = new JButton("Aceptar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ComboBox.getSelectedItem()==null) {
					JOptionPane.showMessageDialog(null, "Se debe seleccionar una Actividad","Aceptar/Rechazar Actividad",JOptionPane.ERROR_MESSAGE);
				}else {
					nameAct=ComboBox.getSelectedItem().toString();
					ctrlDepartamento.aceptarActividad(nameAct, EstadoActividad.Aceptada);
					setVisible(false);
					ComboBox.removeAllItems();
				}
				
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridx = 7;
		gbc_btnNewButton_1.gridy = 3;
		getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);

	}
	
	public void cargarActividades() {
		DefaultComboBoxModel<String> model;
		if ( ! ctrlDepartamento.getActividadesAgregadas().isEmpty()  ) {
			String[] s = new String[ ctrlDepartamento.getActividadesAgregadas().keySet().size() ];	
			s = ctrlDepartamento.getActividadesAgregadas().keySet().toArray(s);
			model = new DefaultComboBoxModel<String>(s);
			ComboBox.setModel(model);
					
			
		} else {
			JOptionPane.showMessageDialog(null, "No hay actividades esperando ser aceptadas","Aceptar/Rechazar Actividad",JOptionPane.ERROR_MESSAGE);
			
		}
	}

}
