package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogModificarLavadora extends JDialog implements ActionListener {
	private JLabel lblNewLabel;
	private JLabel lblPrecios;
	private JLabel lblAnchocm;
	private JLabel lblAltocm;
	private JLabel lblFondocm;
	private JLabel lblC;
	private JComboBox cboModelo;
	private JTextField txtPrecio;
	private JTextField txtAncho;
	private JTextField txtAlto;
	private JTextField txtFondo;
	private JTextField txtCapacidad;
	private JButton btnCerrar;
	private JButton btnGuardar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogModificarLavadora dialog = new DialogModificarLavadora();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DialogModificarLavadora() {
		setModal(true);
		setTitle("Consultar Lavadora");
		setBounds(100, 100, 450, 248);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Modelo");
		lblNewLabel.setBounds(10, 25, 107, 14);
		getContentPane().add(lblNewLabel);
		
		lblPrecios = new JLabel("Precio (S/)");
		lblPrecios.setBounds(10, 53, 107, 14);
		getContentPane().add(lblPrecios);
		
		lblAnchocm = new JLabel("Ancho (cm)");
		lblAnchocm.setBounds(10, 75, 107, 14);
		getContentPane().add(lblAnchocm);
		
		lblAltocm = new JLabel("Alto(cm)");
		lblAltocm.setBounds(10, 100, 107, 14);
		getContentPane().add(lblAltocm);
		
		lblFondocm = new JLabel("Fondo (cm)");
		lblFondocm.setBounds(10, 128, 107, 14);
		getContentPane().add(lblFondocm);
		
		lblC = new JLabel("Capacidad (Kg)");
		lblC.setBounds(10, 153, 107, 14);
		getContentPane().add(lblC);
		
		cboModelo = new JComboBox();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"WHIRLPOOL WWI16BSBLA", "SAMSUNG WA17T6260BW", "MABE LMA72200WDBB1", "WINIA WLA-195ECG", "LG TS1604NW"}));
		cboModelo.setBounds(107, 21, 152, 22);
		getContentPane().add(cboModelo);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(107, 50, 86, 20);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtAncho = new JTextField();
		txtAncho.setColumns(10);
		txtAncho.setBounds(107, 72, 86, 20);
		getContentPane().add(txtAncho);
		
		txtAlto = new JTextField();
		txtAlto.setColumns(10);
		txtAlto.setBounds(107, 97, 86, 20);
		getContentPane().add(txtAlto);
		
		txtFondo = new JTextField();
		txtFondo.setColumns(10);
		txtFondo.setBounds(107, 125, 86, 20);
		getContentPane().add(txtFondo);
		
		txtCapacidad = new JTextField();
		txtCapacidad.setColumns(10);
		txtCapacidad.setBounds(107, 150, 86, 20);
		getContentPane().add(txtCapacidad);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(319, 21, 89, 23);
		getContentPane().add(btnCerrar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(319, 49, 89, 23);
		getContentPane().add(btnGuardar);
		
		actionPerformedCboModelo();

	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
		if (e.getSource() == cboModelo) {
			actionPerformedCboModelo();
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	protected void actionPerformedCboModelo() {
		//Declaracion de variables
			int modelo;
			double precio, ancho, alto, fondo, capacidad;
		
		// Ingreso de datos
			modelo = cboModelo.getSelectedIndex();
			
		//Proceso de Calculo
			precio=0.0;
			ancho=0.0;
			alto=0.0;
			fondo=0.0;
			capacidad=0.0;
			
			switch(modelo) {
				case 0:
					precio = Tienda.precio0;
					ancho = Tienda.ancho0;
					alto = Tienda.alto0;
					fondo = Tienda.fondo0;
					capacidad = Tienda.capacidad0;
					break;
				case 1:
					precio = Tienda.precio1;
					ancho = Tienda.ancho1;
					alto = Tienda.alto1;
					fondo = Tienda.fondo1;
					capacidad = Tienda.capacidad1;
					break;
				case 2:
					precio = Tienda.precio2;
					ancho = Tienda.ancho2;
					alto = Tienda.alto2;
					fondo = Tienda.fondo2;
					capacidad = Tienda.capacidad2;
					break;
				case 3:
					precio = Tienda.precio3;
					ancho = Tienda.ancho3;
					alto = Tienda.alto3;
					fondo = Tienda.fondo3;
					capacidad = Tienda.capacidad3;
					break;
				case 4:
					precio = Tienda.precio4;
					ancho = Tienda.ancho4;
					alto = Tienda.alto4;
					fondo = Tienda.fondo4;
					capacidad = Tienda.capacidad4;
					break;
			}
			
		//Salida de datos
			txtPrecio.setText(String.valueOf(precio));
			txtAncho.setText(String.valueOf(ancho));
			txtAlto.setText(String.valueOf(alto));
			txtFondo.setText(String.valueOf(fondo));
			txtCapacidad.setText(String.valueOf(capacidad));
			
		
	}
	protected void actionPerformedBtnGuardar(ActionEvent e) {
	//Declaracion de variables
		int modelo;
		double precio, ancho, alto, fondo, capacidad;
	
	// Ingreso de datos
		modelo = cboModelo.getSelectedIndex();
		
	//Proceso de Calculo
		precio = Double.valueOf(txtPrecio.getText());
		ancho = Double.valueOf(txtAncho.getText());
		alto = Double.valueOf(txtAlto.getText());
		fondo = Double.valueOf(txtFondo.getText());
		capacidad = Double.valueOf(txtCapacidad.getText());
		
		switch(modelo) {
			case 0:
				Tienda.precio0 =precio;
				Tienda.ancho0=ancho;
				Tienda.alto0=alto ;
				Tienda.fondo0=fondo ;
				Tienda.capacidad0=capacidad;
				break;
			case 1:
				Tienda.precio1 =precio;
				Tienda.ancho1=ancho;
				Tienda.alto1=alto ;
				Tienda.fondo1=fondo ;
				Tienda.capacidad1=capacidad;
				break;
			case 2:
				Tienda.precio2 =precio;
				Tienda.ancho2=ancho;
				Tienda.alto2=alto ;
				Tienda.fondo2=fondo ;
				Tienda.capacidad2=capacidad;
				break;
			case 3:
				Tienda.precio3 =precio;
				Tienda.ancho3=ancho;
				Tienda.alto3=alto ;
				Tienda.fondo3=fondo ;
				Tienda.capacidad3=capacidad;
				break;
			case 4:
				Tienda.precio4 =precio;
				Tienda.ancho4=ancho;
				Tienda.alto4=alto ;
				Tienda.fondo4=fondo ;
				Tienda.capacidad4=capacidad;
				break;
		}
		
		dispose();
	}
}
