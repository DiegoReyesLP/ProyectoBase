package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogAcercaDeTienda extends JDialog implements ActionListener {
	private JLabel lblNewLabel;
	private JSeparator separator;
	private JLabel lblAutores;
	private JLabel lblJuanDiegoReyes;
	private JLabel lblLimaPer;
	private JLabel lblLimaPer_1;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogAcercaDeTienda dialog = new DialogAcercaDeTienda();
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
	public DialogAcercaDeTienda() {
		getContentPane().setBackground(new Color(176, 196, 222));
		setModal(true);
		setTitle("Acerca de Tienda");
		setBounds(100, 100, 450, 301);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("TIENDA 1.0");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Segoe UI Light", Font.ITALIC, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 27);
		getContentPane().add(lblNewLabel);
		
		separator = new JSeparator();
		separator.setBounds(10, 49, 414, 2);
		getContentPane().add(separator);
		
		lblAutores = new JLabel("AUTOR");
		lblAutores.setForeground(Color.BLACK);
		lblAutores.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutores.setFont(new Font("Segoe UI Light", Font.BOLD, 14));
		lblAutores.setBounds(10, 60, 414, 27);
		getContentPane().add(lblAutores);
		
		lblJuanDiegoReyes = new JLabel("Juan Diego Reyes Cossi");
		lblJuanDiegoReyes.setBackground(new Color(255, 255, 255));
		lblJuanDiegoReyes.setForeground(Color.BLACK);
		lblJuanDiegoReyes.setHorizontalAlignment(SwingConstants.CENTER);
		lblJuanDiegoReyes.setFont(new Font("Segoe UI Light", Font.BOLD | Font.ITALIC, 16));
		lblJuanDiegoReyes.setBounds(10, 104, 414, 27);
		getContentPane().add(lblJuanDiegoReyes);
		
		lblLimaPer = new JLabel("Lima - Per\u00FA");
		lblLimaPer.setForeground(Color.BLACK);
		lblLimaPer.setHorizontalAlignment(SwingConstants.CENTER);
		lblLimaPer.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblLimaPer.setBounds(10, 163, 414, 27);
		getContentPane().add(lblLimaPer);
		
		lblLimaPer_1 = new JLabel("2021");
		lblLimaPer_1.setForeground(Color.BLACK);
		lblLimaPer_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLimaPer_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		lblLimaPer_1.setBounds(10, 190, 414, 27);
		getContentPane().add(lblLimaPer_1);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(176, 228, 89, 23);
		getContentPane().add(btnCerrar);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}
