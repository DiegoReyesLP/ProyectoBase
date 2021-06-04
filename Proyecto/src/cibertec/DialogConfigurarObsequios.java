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

public class DialogConfigurarObsequios extends JDialog implements ActionListener {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txt1;
	private JTextField txt2a5;
	private JTextField txt6amas;
	private JButton btnAceptar;
	private JButton btnCancelar;

	private void cargarregalos() {
		
		 Properties properties= new Properties();
		 try {
		      properties.load(new FileInputStream("src/configuracion/datos2.properties"));
		      
		      this.txt1.setText(properties.get("regalo1").toString());
		      this.txt2a5.setText(properties.get("regalo2").toString());
		      this.txt6amas.setText(properties.get("regalo3").toString());
		 }
		 catch (FileNotFoundException e) {
		       // TODO Auto-generated catch block
		       e.printStackTrace();
		 } catch (IOException e) {
		       // TODO Auto-generated catch block
		       e.printStackTrace();
		 }
	}
	private void actualizarregalos(String r1,String r2,String r3 ) {
		
		 Properties properties= new Properties();
		 try {
		      properties.load(new FileInputStream("src/configuracion/datos2.properties"));
		      properties.setProperty("regalo1", r1);
		      properties.setProperty("regalo2", r2);
		      properties.setProperty("regalo3", r3);
		      properties.store(new FileWriter("src/configuracion/datos2.properties"),"");
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
					DialogConfigurarObsequios dialog = new DialogConfigurarObsequios();
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
	public DialogConfigurarObsequios() {
		setTitle("Configurar obsequios");
		setBounds(100, 100, 450, 133);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("1 unidad");
		lblNewLabel.setBounds(10, 11, 92, 14);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("2 a 5 unidades");
		lblNewLabel_1.setBounds(10, 36, 92, 14);
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("6 a m\u00E1s unidades");
		lblNewLabel_2.setBounds(10, 61, 92, 14);
		getContentPane().add(lblNewLabel_2);
		
		txt1 = new JTextField();
		txt1.setBounds(136, 8, 86, 20);
		getContentPane().add(txt1);
		txt1.setColumns(10);
		
		txt2a5 = new JTextField();
		txt2a5.setBounds(136, 33, 86, 20);
		getContentPane().add(txt2a5);
		txt2a5.setColumns(10);
		
		txt6amas = new JTextField();
		txt6amas.setBounds(136, 58, 86, 20);
		getContentPane().add(txt6amas);
		txt6amas.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(319, 7, 89, 23);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(319, 32, 89, 23);
		getContentPane().add(btnCancelar);

		cargarregalos();
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
		String r1 = this.txt1.getText();
		String r2 = this.txt2a5.getText();
		String r3 = this.txt6amas.getText();
		actualizarregalos(r1,r2,r3);
	}
}
