package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogVender extends JDialog implements ActionListener {
	private JLabel lblNewLabel;
	private JLabel lblPrecios;
	private JLabel lblCantidad;
	private JComboBox cboModelo;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	private JButton btnVender;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogVender dialog = new DialogVender();
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
	public DialogVender() {
		setModal(true);
		setTitle("Vender");
		setBounds(100, 100, 511, 361);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Modelo");
		lblNewLabel.setBounds(10, 25, 86, 14);
		getContentPane().add(lblNewLabel);
		
		lblPrecios = new JLabel("Precio (S/.)");
		lblPrecios.setBounds(10, 64, 86, 14);
		getContentPane().add(lblPrecios);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 102, 86, 14);
		getContentPane().add(lblCantidad);
		
		cboModelo = new JComboBox();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"WHIRLPOOL WWI16BSBLA", "SAMSUNG WA17T6260BW", "MABE LMA72200WDBB1", "WINIA WLA-195ECG", "LG TS1604NW"}));
		cboModelo.setBounds(94, 21, 204, 22);
		getContentPane().add(cboModelo);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(94, 61, 86, 20);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(94, 99, 86, 20);
		getContentPane().add(txtCantidad);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 138, 475, 173);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		btnVender = new JButton("Vender");
		btnVender.addActionListener(this);
		btnVender.setBounds(378, 21, 89, 23);
		getContentPane().add(btnVender);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(378, 55, 89, 23);
		getContentPane().add(btnCerrar);

		mostrarPrecio();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVender) {
			actionPerformedBtnVender(e);
		}
		if (e.getSource() == cboModelo) {
			actionPerformedCboModelo(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	protected void actionPerformedCboModelo(ActionEvent e) {
		mostrarPrecio();
	}
	
	void mostrarPrecio() {
		int indice = 0;
		indice = cboModelo.getSelectedIndex();
		modelo = cboModelo.getSelectedItem().toString();
		switch(indice) {
			case 0:
				precio = Tienda.precio0;
				break;
			case 1:
				precio = Tienda.precio1;
				break;
			case 2:
				precio = Tienda.precio2;
				break;
			case 3:
				precio = Tienda.precio3;
				break;
			case 4:
				precio = Tienda.precio4;
				break;
				
		}
		txtPrecio.setText(String.valueOf(precio));
	}
	
	protected void actionPerformedBtnVender(ActionEvent e) {
		vender();
	}
	
	//----------------------------------------------------------------
	//Declaracion de variables GLOBALES
	 double precio, TotalVentas;
	 String modelo;
	 
	 
	//Ingreso de datos
	int leerCantidad() {
		return Integer.parseInt(txtCantidad.getText());
	}	
	
	//Proceso de calculo
	double obtenerDescuento(int cantidad) {
		double pdescuento = 0.0;
		if (cantidad>0 && cantidad<6)
			pdescuento = Tienda.porcentaje1;
		else
			if (cantidad>6 && cantidad<11)
				pdescuento = Tienda.porcentaje2;
			else
				if (cantidad>10 && cantidad<16)
					pdescuento = Tienda.porcentaje3;
				else
						pdescuento = Tienda.porcentaje4;
		return pdescuento/100;
	}
	
	String obtenerObsequio(int cantidad) {
		String obsequio = "";
		if (cantidad == 1)
			obsequio = Tienda.obsequio1;
		else
			if(cantidad>1 && cantidad < 6)
				obsequio = Tienda.obsequio2;
			else
				obsequio = Tienda.obsequio3;
		return obsequio;
	}
	
	//Salida de resultados 
	void mostrarResultados(int cantidad, double icompra, double idescuento, double ipagar, String obsequio) {
		txtS.setText("BOLETA DE VENTA \n");
		imprimir("");
		
		imprimir("Modelo               :" + modelo );
		imprimir("Precio               :" + precio);
		imprimir("Cantidad             :" + cantidad);
		imprimir("Importe de Compra    :" + icompra);
		imprimir("Importe Descuento    :" + idescuento);
		imprimir("Importe pagar        :" + ipagar);
		imprimir("Obsequio             :" + obsequio);
		
	}
	
	void imprimir(String cadena) {
		txtS.append(cadena + "\n");
	}
	
	
	
	void vender( ) {
		//Declaracion de variables
		int cantidad;
		double icompra, idescuento, ipagar, pdescuento;
		String obsequio;
		//Ingreso de datos
		cantidad = leerCantidad();
		
		//Proceso de calculo
		icompra = cantidad * precio;
		pdescuento = obtenerDescuento(cantidad);
		idescuento = icompra * pdescuento;
		ipagar = icompra - idescuento;
		obsequio = obtenerObsequio(cantidad);
		
		TotalVentas += ipagar;
		
		//Salida de resultados
		mostrarResultados(cantidad,icompra,idescuento,ipagar,obsequio);
		
		mostrarNVentas();
		
	}
	
	
	void mostrarNVentas() {
		Tienda.ventas5++;
		
		if (Tienda.ventas5==5) 
		{
			JOptionPane.showMessageDialog(null, "Venta Nro. :" + Tienda.ventas5 +
												"\nImporte total general acumulado : S/. " + TotalVentas, "Avance de ventas", JOptionPane.QUESTION_MESSAGE);
			Tienda.ventas5=0;
		}
			
	}
	
	
}
