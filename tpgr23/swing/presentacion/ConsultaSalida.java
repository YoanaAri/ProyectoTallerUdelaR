package presentacion;

import logica.*;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class ConsultaSalida extends JInternalFrame {

	private IControladorDepartamentos controlDep;
	
	private JLabel lblDepartamento, lblActividad, lblSalida, lblNombre, lblValorNombre, lblFechaSalida, lblValorFechaSalida,
					lblSaleDesde, lblValorSaleDesde, lblCupos, lblValorCupos, lblFechaAlta, lblValorFechaAlta;
	
	public JComboBox comboBoxDepartamento, comboBoxActividad, comboBoxSalida;
	
	private JButton btnAceptar;
	
	/**
	 * Launch the application.
	 */
	/* public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaSalida frame = new ConsultaSalida();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public ConsultaSalida(IControladorDepartamentos icd) {
		setResizable(true);
		
		controlDep = icd;
		
		setIconifiable(true);
		setClosable(true);
		setTitle("Consulta de salida turistica");
		setBounds(100, 100, 450, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 121, 58, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		lblDepartamento = new JLabel("Departamento");
		GridBagConstraints gbc_lblDepartamento = new GridBagConstraints();
		gbc_lblDepartamento.anchor = GridBagConstraints.WEST;
		gbc_lblDepartamento.insets = new Insets(0, 0, 5, 5);
		gbc_lblDepartamento.gridx = 1;
		gbc_lblDepartamento.gridy = 1;
		getContentPane().add(lblDepartamento, gbc_lblDepartamento);
		
		//Carga los departamentos al combo box
		comboBoxDepartamento = new JComboBox<String>();
			

		GridBagConstraints gbc_comboBoxDepartamento = new GridBagConstraints();
		gbc_comboBoxDepartamento.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxDepartamento.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxDepartamento.gridx = 1;
		gbc_comboBoxDepartamento.gridy = 2;
		getContentPane().add(comboBoxDepartamento, gbc_comboBoxDepartamento);
		
		lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 2;
		gbc_lblNombre.gridy = 2;
		getContentPane().add(lblNombre, gbc_lblNombre);
		
		lblValorNombre = new JLabel("");
		GridBagConstraints gbc_lblValorNombre = new GridBagConstraints();
		gbc_lblValorNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblValorNombre.insets = new Insets(0, 0, 5, 0);
		gbc_lblValorNombre.gridx = 3;
		gbc_lblValorNombre.gridy = 2;
		getContentPane().add(lblValorNombre, gbc_lblValorNombre);
		
		lblActividad = new JLabel("Actividad");
		GridBagConstraints gbc_lblActividad = new GridBagConstraints();
		gbc_lblActividad.anchor = GridBagConstraints.WEST;
		gbc_lblActividad.insets = new Insets(0, 0, 5, 5);
		gbc_lblActividad.gridx = 1;
		gbc_lblActividad.gridy = 3;
		getContentPane().add(lblActividad, gbc_lblActividad);
		
		lblFechaSalida = new JLabel("Fecha de salida:");
		GridBagConstraints gbc_lblFechaSalida = new GridBagConstraints();
		gbc_lblFechaSalida.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaSalida.gridx = 2;
		gbc_lblFechaSalida.gridy = 3;
		getContentPane().add(lblFechaSalida, gbc_lblFechaSalida);
		
		lblValorFechaSalida = new JLabel("");
		GridBagConstraints gbc_lblValorFechaSalida = new GridBagConstraints();
		gbc_lblValorFechaSalida.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblValorFechaSalida.insets = new Insets(0, 0, 5, 0);
		gbc_lblValorFechaSalida.gridx = 3;
		gbc_lblValorFechaSalida.gridy = 3;
		getContentPane().add(lblValorFechaSalida, gbc_lblValorFechaSalida);
		
		comboBoxActividad = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxActividad = new GridBagConstraints();
		gbc_comboBoxActividad.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxActividad.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxActividad.gridx = 1;
		gbc_comboBoxActividad.gridy = 4;
		getContentPane().add(comboBoxActividad, gbc_comboBoxActividad);
		comboBoxActividad.setEnabled(false);
		
		lblSaleDesde = new JLabel("Sale desde:");
		GridBagConstraints gbc_lblSaleDesde = new GridBagConstraints();
		gbc_lblSaleDesde.insets = new Insets(0, 0, 5, 5);
		gbc_lblSaleDesde.gridx = 2;
		gbc_lblSaleDesde.gridy = 4;
		getContentPane().add(lblSaleDesde, gbc_lblSaleDesde);
		
		lblValorSaleDesde = new JLabel("");
		GridBagConstraints gbc_lblValorSaleDesde = new GridBagConstraints();
		gbc_lblValorSaleDesde.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblValorSaleDesde.insets = new Insets(0, 0, 5, 0);
		gbc_lblValorSaleDesde.gridx = 3;
		gbc_lblValorSaleDesde.gridy = 4;
		getContentPane().add(lblValorSaleDesde, gbc_lblValorSaleDesde);
		
		lblSalida = new JLabel("Salida");
		GridBagConstraints gbc_lblSalida = new GridBagConstraints();
		gbc_lblSalida.anchor = GridBagConstraints.WEST;
		gbc_lblSalida.insets = new Insets(0, 0, 5, 5);
		gbc_lblSalida.gridx = 1;
		gbc_lblSalida.gridy = 5;
		getContentPane().add(lblSalida, gbc_lblSalida);
		
		lblCupos = new JLabel("Cupos totales:");
		GridBagConstraints gbc_lblCupos = new GridBagConstraints();
		gbc_lblCupos.insets = new Insets(0, 0, 5, 5);
		gbc_lblCupos.gridx = 2;
		gbc_lblCupos.gridy = 5;
		getContentPane().add(lblCupos, gbc_lblCupos);
		
		lblValorCupos = new JLabel("");
		GridBagConstraints gbc_lblValorCupos = new GridBagConstraints();
		gbc_lblValorCupos.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblValorCupos.insets = new Insets(0, 0, 5, 0);
		gbc_lblValorCupos.gridx = 3;
		gbc_lblValorCupos.gridy = 5;
		getContentPane().add(lblValorCupos, gbc_lblValorCupos);
		
		comboBoxSalida = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxSalida = new GridBagConstraints();
		gbc_comboBoxSalida.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxSalida.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxSalida.gridx = 1;
		gbc_comboBoxSalida.gridy = 6;
		getContentPane().add(comboBoxSalida, gbc_comboBoxSalida);
		comboBoxSalida.setEnabled(false);
		
		lblFechaAlta = new JLabel("Fecha de alta: ");
		GridBagConstraints gbc_lblFechaAlta = new GridBagConstraints();
		gbc_lblFechaAlta.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaAlta.gridx = 2;
		gbc_lblFechaAlta.gridy = 6;
		getContentPane().add(lblFechaAlta, gbc_lblFechaAlta);
		
		lblValorFechaAlta = new JLabel("");
		GridBagConstraints gbc_lblValorFechaAlta = new GridBagConstraints();
		gbc_lblValorFechaAlta.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblValorFechaAlta.insets = new Insets(0, 0, 5, 0);
		gbc_lblValorFechaAlta.gridx = 3;
		gbc_lblValorFechaAlta.gridy = 6;
		getContentPane().add(lblValorFechaAlta, gbc_lblValorFechaAlta);
		
		
		//Reacciona cuando se elige el departamento
		ActionListener clickDep =new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				clean();
				
				String departamento = (String) comboBoxDepartamento.getSelectedItem();
				
				DefaultComboBoxModel<String> modelAct;
				
				String[] actividades = new String[controlDep.getActividadesXDep(departamento).size()];
				actividades = controlDep.getActividadesXDep(departamento).keySet().toArray(actividades);
				
				modelAct = new DefaultComboBoxModel<String>(actividades);
				comboBoxActividad.setModel(modelAct);
				if(actividades.length != 0) {
					comboBoxActividad.setEnabled(true);
					comboBoxActividad.setSelectedIndex(0);
				}else {
					comboBoxActividad.setEnabled(false);
					comboBoxSalida.setEnabled(false);
				}
											
				//Reacciona cuando se elige la actividad
				comboBoxActividad.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						
						String departamento = (String) comboBoxDepartamento.getSelectedItem();
						
						String actividad = (String) comboBoxActividad.getSelectedItem();
						
						DefaultComboBoxModel<String> modelSal;
						
						String[] salidas = new String[controlDep.getActividadesXDep(departamento).get(actividad).getSalidas().size()];
						salidas = controlDep.getActividadesXDep(departamento).get(actividad).getSalidas().keySet().toArray(salidas);
					
						modelSal = new DefaultComboBoxModel<String>(salidas);
						comboBoxSalida.setModel(modelSal);		
						if(salidas.length != 0) {
							comboBoxSalida.setEnabled(true);
							//comboBoxSalida.setSelectedIndex(0);
							
							comboBoxSalida.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e ) {
									
									String salida = (String) comboBoxSalida.getSelectedItem();
									
									SalidaTuristica dts = controlDep.getActividadesXDep(departamento).get(actividad).getSalida(salida);
									
//									if (dts==null) {
//										System.out.println("error");
//									}
									if(dts != null) {
										lblValorNombre.setText(dts.getNombre());
									
										String fecha = dts.getSalida().getFecha().toString();
										lblValorFechaSalida.setText(fecha);
										lblValorSaleDesde.setText(dts.getSalida().getLugarSalida());
										lblValorCupos.setText(String.valueOf(dts.getCupos()));
									
									
										String fechaAlta = dts.getFechaAlta().toString();
										lblValorFechaAlta.setText(fechaAlta);
									}
								}
							});
							
							
								
						}else {
							comboBoxSalida.setEnabled(false);
						}
					}
				});
				
			}
		};
		
		comboBoxDepartamento.addActionListener(clickDep);
		
		btnAceptar = new JButton("Cancelar");
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.gridx = 3;
		gbc_btnAceptar.gridy = 9;
		getContentPane().add(btnAceptar, gbc_btnAceptar);
		
		btnAceptar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				comboBoxActividad.setEnabled(false);
				comboBoxSalida.setEnabled(false);
				
				setVisible(false);
			}
		});

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
		lblValorNombre.setText("");
		lblValorFechaSalida.setText("");
		lblValorSaleDesde.setText("");
		lblValorCupos.setText("");
		lblValorFechaAlta.setText("");
	}
}
