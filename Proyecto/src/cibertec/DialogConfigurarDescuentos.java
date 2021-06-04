package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.io.FileWriter;

public class DialogConfigurarDescuentos extends JDialog implements ActionListener {
	private JLabel lblNewLabel;
	private JLabel lblA;
	private JLabel lblA_1;
	private JLabel lblMasDe;
	private JTextField txtde1a5;
	private JTextField txtde6a10;
	private JTextField txtde11a15;
	private JTextField txtmasde15;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JButton btnAceptar;
	private JButton btnCancelar;
	
	private void cargardescuentos() {
		
		 Properties properties= new Properties();
		 try {
		      properties.load(new FileInputStream("src/configuracion/datos.properties"));
		      
		      this.txtde1a5.setText(properties.get("descuento1").toString());
		      this.txtde6a10.setText(properties.get("descuento2").toString());
		      this.txtde11a15.setText(properties.get("descuento3").toString());
		      this.txtmasde15.setText(properties.get("descuento4").toString());
		 }
		 catch (FileNotFoundException e) {
		       // TODO Auto-generated catch block
		       e.printStackTrace();
		 } catch (IOException e) {
		       // TODO Auto-generated catch block
		       e.printStackTrace();
		 }
	}
	private void actualizardescuentos(String d1,String d2,String d3,String d4 ) {
		
		 Properties properties= new Properties();
		 try {
		      properties.load(new FileInputStream("src/configuracion/datos.properties"));
		      properties.setProperty("descuento1", d1);
		      properties.setProperty("descuento2", d2);
		      properties.setProperty("descuento3", d3);
		      properties.setProperty("descuento4", d4);
		      properties.store(new FileWriter("src/configuracion/datos.properties"),"");
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
					DialogConfigurarDescuentos dialog = new DialogConfigurarDescuentos();
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
	public DialogConfigurarDescuentos() {
		setTitle("Configurar porcentajes de descuento");
		setBounds(100, 100, 450, 199);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("1 a 5 unidades");
		lblNewLabel.setBounds(10, 11, 109, 14);
		getContentPane().add(lblNewLabel);
		
		lblA = new JLabel("6 a 10 unidades");
		lblA.setBounds(10, 47, 109, 14);
		getContentPane().add(lblA);
		
		lblA_1 = new JLabel("11 a 15 unidades");
		lblA_1.setBounds(10, 88, 109, 14);
		getContentPane().add(lblA_1);
		
		lblMasDe = new JLabel("M\u00E1s de 15 unidades");
		lblMasDe.setBounds(10, 129, 136, 14);
		getContentPane().add(lblMasDe);
		
		txtde1a5 = new JTextField();
		txtde1a5.setBounds(127, 7, 109, 20);
		getContentPane().add(txtde1a5);
		txtde1a5.setColumns(10);
		
		txtde6a10 = new JTextField();
		txtde6a10.setColumns(10);
		txtde6a10.setBounds(127, 43, 109, 20);
		getContentPane().add(txtde6a10);
		
		txtde11a15 = new JTextField();
		txtde11a15.setColumns(10);
		txtde11a15.setBounds(127, 84, 109, 20);
		getContentPane().add(txtde11a15);
		
		txtmasde15 = new JTextField();
		txtmasde15.setColumns(10);
		txtmasde15.setBounds(127, 125, 109, 20);
		getContentPane().add(txtmasde15);
		
		lblNewLabel_1 = new JLabel("%");
		lblNewLabel_1.setBounds(246, 11, 28, 14);
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("%");
		lblNewLabel_2.setBounds(247, 47, 28, 14);
		getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("%");
		lblNewLabel_3.setBounds(247, 88, 28, 14);
		getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("%");
		lblNewLabel_4.setBounds(247, 129, 28, 14);
		getContentPane().add(lblNewLabel_4);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(335, 7, 89, 23);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(335, 43, 89, 23);
		getContentPane().add(btnCancelar);

		cargardescuentos();
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
		String d1 = this.txtde1a5.getText();
		String d2 = this.txtde6a10.getText();
		String d3 = this.txtde11a15.getText();
		String d4 = this.txtmasde15.getText();
		actualizardescuentos(d1,d2,d3,d4);
		
	}

}
