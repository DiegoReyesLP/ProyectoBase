package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class DialogListarLavadoras extends JDialog implements ActionListener {
	private JTextArea txtS;
	private JButton btnCerrar;
	private JButton btnListar;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogListarLavadoras dialog = new DialogListarLavadoras();
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
	public DialogListarLavadoras() {
		setTitle("Listar Lavadoras");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 216);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(130, 238, 89, 23);
		getContentPane().add(btnCerrar);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setBounds(229, 238, 89, 23);
		getContentPane().add(btnListar);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
	}
	protected void actionPerformedBtnListar(ActionEvent e) {
		txtS.setText("LISTADO DE LAVADORAS \n");
		
		txtS.append("\n Modelo     : " + Tienda.modelo0);
		txtS.append("\n Precio     : " + Tienda.precio0);
		txtS.append("\n Profundidad: " + Tienda.fondo0);
		txtS.append("\n Ancho      : " + Tienda.ancho0);
		txtS.append("\n Alto       : " + Tienda.alto0);
		txtS.append("\n Capacidad  : " + Tienda.capacidad0);
		txtS.append("\n");
		
		txtS.append("\n Modelo     : " + Tienda.modelo1);
		txtS.append("\n Precio     : " + Tienda.precio1);
		txtS.append("\n Profundidad: " + Tienda.fondo1);
		txtS.append("\n Ancho      : " + Tienda.ancho1);
		txtS.append("\n Alto       : " + Tienda.alto1);
		txtS.append("\n Capacidad  : " + Tienda.capacidad1);
		txtS.append("\n");
		
		txtS.append("\n Modelo     : " + Tienda.modelo2);
		txtS.append("\n Precio     : " + Tienda.precio2);
		txtS.append("\n Profundidad: " + Tienda.fondo2);
		txtS.append("\n Ancho      : " + Tienda.ancho2);
		txtS.append("\n Alto       : " + Tienda.alto2);
		txtS.append("\n Capacidad  : " + Tienda.capacidad2);
		txtS.append("\n");
		
		txtS.append("\n Modelo     : " + Tienda.modelo3);
		txtS.append("\n Precio     : " + Tienda.precio3);
		txtS.append("\n Profundidad: " + Tienda.fondo3);
		txtS.append("\n Ancho      : " + Tienda.ancho3);
		txtS.append("\n Alto       : " + Tienda.alto3);
		txtS.append("\n Capacidad  : " + Tienda.capacidad3);
		txtS.append("\n");
		
		txtS.append("\n Modelo     : " + Tienda.modelo4);
		txtS.append("\n Precio     : " + Tienda.precio4);
		txtS.append("\n Profundidad: " + Tienda.fondo4);
		txtS.append("\n Ancho      : " + Tienda.ancho4);
		txtS.append("\n Alto       : " + Tienda.alto4);
		txtS.append("\n Capacidad  : " + Tienda.capacidad4);
		txtS.append("\n");
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}
