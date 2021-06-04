package cibertec;

import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogConfigurarCuota extends JDialog implements ActionListener {
	private JLabel lblNewLabel;
	private JTextField txtCuota;
	private JButton btnAceptar;
	private JButton btnCerrar;
	
	private void cargarcuota() {
		
		 Properties properties= new Properties();
		 try {
		      properties.load(new FileInputStream("src/configuracion/datos4.properties"));
		      
		      this.txtCuota.setText(properties.get("cuotadiaria").toString());
		 }
		 catch (FileNotFoundException e) {
		       // TODO Auto-generated catch block
		       e.printStackTrace();
		 } catch (IOException e) {
		       // TODO Auto-generated catch block
		       e.printStackTrace();
		 }
	}
	private void actualizarcuota(String c1 ) {
		
		 Properties properties= new Properties();
		 try {
		      properties.load(new FileInputStream("src/configuracion/datos4.properties"));
		      properties.setProperty("cuotadiaria", c1);
		      properties.store(new FileWriter("src/configuracion/datos4.properties"),"");
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
					DialogConfigurarCuota dialog = new DialogConfigurarCuota();
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
	public DialogConfigurarCuota() {
		setTitle("Configurar cuota diaria");
		setBounds(100, 100, 450, 114);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Cuota diaria esperada (S/.)");
		lblNewLabel.setBounds(10, 11, 179, 14);
		getContentPane().add(lblNewLabel);
		
		txtCuota = new JTextField();
		txtCuota.setBounds(199, 8, 86, 20);
		getContentPane().add(txtCuota);
		txtCuota.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(323, 7, 89, 23);
		getContentPane().add(btnAceptar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(323, 41, 89, 23);
		getContentPane().add(btnCerrar);

		cargarcuota();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		String c1 = this.txtCuota.getText();
		actualizarcuota(c1);
	}
}
