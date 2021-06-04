package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class DialogConfigurarCantidad extends JDialog implements ActionListener {
	private JLabel lblNewLabel;
	private JTextField txtCantidad;
	private JButton btnAceptar;
	private JButton btnCancelar;

	private void cargarcantidad() {
		
		 Properties properties= new Properties();
		 try {
		      properties.load(new FileInputStream("src/configuracion/datos3.properties"));
		      
		      this.txtCantidad.setText(properties.get("cantidadoptima").toString());
		 }
		 catch (FileNotFoundException e) {
		       // TODO Auto-generated catch block
		       e.printStackTrace();
		 } catch (IOException e) {
		       // TODO Auto-generated catch block
		       e.printStackTrace();
		 }
	}
	private void actualizarcantidad(String c1 ) {
		
		 Properties properties= new Properties();
		 try {
		      properties.load(new FileInputStream("src/configuracion/datos3.properties"));
		      properties.setProperty("cantidadoptima", c1);
		      properties.store(new FileWriter("src/configuracion/datos3.properties"),"");
		      dispose();
		 }
		 catch (FileNotFoundException e) {
		       // TODO Auto-generated catch block
		       e.printStackTrace();
		 } catch (IOException e) {
		       // TODO Auto-generated catch block
		       e.printStackTrace();
		 }
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogConfigurarCantidad dialog = new DialogConfigurarCantidad();
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
	public DialogConfigurarCantidad() {
		setTitle("Configurar cantidad \u00F3ptima");
		setBounds(100, 100, 450, 115);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Cantidad \u00F3ptima de unidades vendidas");
		lblNewLabel.setBounds(10, 11, 242, 14);
		getContentPane().add(lblNewLabel);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(236, 8, 65, 20);
		getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(335, 7, 89, 23);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(335, 41, 89, 23);
		getContentPane().add(btnCancelar);

		cargarcantidad();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		String c1 = this.txtCantidad.getText();
		actualizarcantidad(c1);
	}
}
