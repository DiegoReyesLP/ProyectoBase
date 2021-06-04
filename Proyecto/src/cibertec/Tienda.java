package cibertec;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Tienda extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	// Datos mínimos de la primera lavadora
	public static String modelo0 = "WHIRLPOOL WWI16BSBLA";
	public static double precio0 = 999.0;
	public static double fondo0 = 67.0;
	public static double ancho0 = 64.0;
	public static double alto0 = 105.0;
	public static double capacidad0 = 16;
	// Datos mínimos de la segunda lavadora
	public static String modelo1 = "SAMSUNG WA17T6260BW";
	public static double precio1 = 1199.0;
	public static double ancho1 = 63.0;
	public static double alto1 = 108.0;
	public static double fondo1 = 69.0;
	public static double capacidad1 = 17;
	// Datos mínimos de la tercera lavadora
	public static String modelo2 = "MABE LMA72200WDBB1";
	public static double precio2 = 1599.0;
	public static double ancho2 = 68.0;
	public static double alto2 = 109.0;
	public static double fondo2 = 68.0;
	public static double capacidad2 = 22;
	// Datos mínimos de la cuarta lavadora
	public static String modelo3 = "WINIA WLA-195ECG";
	public static double precio3 = 899.0;
	public static double ancho3 = 52.5;
	public static double alto3 = 85.5;
	public static double fondo3 = 53.5;
	public static double capacidad3 = 6.5;
	// Datos mínimos de la quinta lavadora
	public static String modelo4 = "LG TS1604NW";
	public static double precio4 = 1099.0;
	public static double ancho4 = 63.2;
	public static double alto4 = 102.0;
	public static double fondo4 = 67;
	public static double capacidad4 = 17;
	// Porcentajes de descuento
	public static double porcentaje1 = 7.5;
	public static double porcentaje2 = 10.0;
	public static double porcentaje3 = 12.5;
	public static double porcentaje4 = 15.0;
	// Obsequios
	public static String obsequio1 = "Cafetera";
	public static String obsequio2 = "Licuadora";
	public static String obsequio3 = "Extractor";
	// Cantidad óptima de unidades vendidas
	public static int cantidadOptima = 10;
	// Cuota diaria
	public static double cuotaDiaria = 30000;
	
	public static int ventas5=0;
	
	public static void cargardescuentos() {
		
		 Properties properties= new Properties();
		 try {
		      properties.load(new FileInputStream("src/configuracion/datos.properties"));
		      properties.setProperty("descuento1","7.5");
		      properties.setProperty("descuento2","10.0");
		      properties.setProperty("descuento3","12.5");
		      properties.setProperty("descuento4","15.0");
		      properties.store(new FileWriter("src/configuracion/datos.properties"),"");
		 }
		 catch (FileNotFoundException e) {
		       // TODO Auto-generated catch block
		       e.printStackTrace();
		 } catch (IOException e) {
		       // TODO Auto-generated catch block
		       e.printStackTrace();
		 }
	}
	public static void cargarregalos() {
		
		 Properties properties= new Properties();
		 try {
		      properties.load(new FileInputStream("src/configuracion/datos2.properties"));
		      properties.setProperty("regalo1","Cafetera");
		      properties.setProperty("regalo2","Licuadora");
		      properties.setProperty("regalo3","Extractor");
		      properties.store(new FileWriter("src/configuracion/datos2.properties"),"");
		 }
		 catch (FileNotFoundException e) {
		       // TODO Auto-generated catch block
		       e.printStackTrace();
		 } catch (IOException e) {
		       // TODO Auto-generated catch block
		       e.printStackTrace();
		 }
	}
	public static void cargarcantidad() {
		
		 Properties properties= new Properties();
		 try {
		      properties.load(new FileInputStream("src/configuracion/datos3.properties"));
		      properties.setProperty("cantidadoptima","10");
		      properties.store(new FileWriter("src/configuracion/datos3.properties"),"");
		 }
		 catch (FileNotFoundException e) {
		       // TODO Auto-generated catch block
		       e.printStackTrace();
		 } catch (IOException e) {
		       // TODO Auto-generated catch block
		       e.printStackTrace();
		 }
	}
	public static void cargarcuota() {
		
		 Properties properties= new Properties();
		 try {
		      properties.load(new FileInputStream("src/configuracion/datos4.properties"));
		      properties.setProperty("cuotadiaria","30000");
		      properties.store(new FileWriter("src/configuracion/datos4.properties"),"");
		 }
		 catch (FileNotFoundException e) {
		       // TODO Auto-generated catch block
		       e.printStackTrace();
		 } catch (IOException e) {
		       // TODO Auto-generated catch block
		       e.printStackTrace();
		 }
	}
	
	
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;
	private JMenu mnNewMenu_3;
	private JMenu mnNewMenu_4;
	private JMenuItem mniModificarLavadora;
	private JMenuItem mniConsultarLavadora;
	private JMenuItem mniListarLavadoras;
	private JMenuItem mniVender;
	private JMenuItem mntmNewMenuItem_5;
	private JMenuItem mniConfigurarDescuentos;
	private JMenuItem mniConfigurarObsequios;
	private JMenuItem mniConfigurarCantidadOptima;
	private JMenuItem mniConfigurarCuotaDiaria;
	private JMenuItem mniAcercaDeTienda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tienda frame = new Tienda();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tienda() {
		setTitle("Tienda 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 762, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 746, 22);
		contentPane.add(menuBar);
		
		mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Salir");
		mntmNewMenuItem.addActionListener(this);
		mnNewMenu.add(mntmNewMenuItem);
		
		mnNewMenu_1 = new JMenu("Mantenimiento");
		menuBar.add(mnNewMenu_1);
		
		mniConsultarLavadora = new JMenuItem("Consultar lavadora");
		mniConsultarLavadora.addActionListener(this);
		mnNewMenu_1.add(mniConsultarLavadora);
		
		mniModificarLavadora = new JMenuItem("Modificar lavadora");
		mniModificarLavadora.addActionListener(this);
		mnNewMenu_1.add(mniModificarLavadora);
		
		mniListarLavadoras = new JMenuItem("Listar lavadoras");
		mniListarLavadoras.addActionListener(this);
		mnNewMenu_1.add(mniListarLavadoras);
		
		mnNewMenu_2 = new JMenu("Ventas");
		menuBar.add(mnNewMenu_2);
		
		mniVender = new JMenuItem("Vender");
		mniVender.addActionListener(this);
		mnNewMenu_2.add(mniVender);
		
		mntmNewMenuItem_5 = new JMenuItem("Generar reportes");
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		mnNewMenu_3 = new JMenu("Configuracion");
		menuBar.add(mnNewMenu_3);
		
		mniConfigurarDescuentos = new JMenuItem("Configurar descuentos");
		mniConfigurarDescuentos.addActionListener(this);
		mnNewMenu_3.add(mniConfigurarDescuentos);
		
		mniConfigurarObsequios = new JMenuItem("Configurar obsequios");
		mniConfigurarObsequios.addActionListener(this);
		mnNewMenu_3.add(mniConfigurarObsequios);
		
		mniConfigurarCantidadOptima = new JMenuItem("Configurar cantidad \u00F3ptima");
		mniConfigurarCantidadOptima.addActionListener(this);
		mnNewMenu_3.add(mniConfigurarCantidadOptima);
		
		mniConfigurarCuotaDiaria = new JMenuItem("Configurar cuota diaria");
		mniConfigurarCuotaDiaria.addActionListener(this);
		mnNewMenu_3.add(mniConfigurarCuotaDiaria);
		
		mnNewMenu_4 = new JMenu("Ayuda");
		menuBar.add(mnNewMenu_4);
		
		mniAcercaDeTienda = new JMenuItem("Acerca de Tienda");
		mniAcercaDeTienda.addActionListener(this);
		mnNewMenu_4.add(mniAcercaDeTienda);
		
		cargardescuentos();
		cargarregalos();
		cargarcantidad();
		cargarcuota();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mniConfigurarCuotaDiaria) {
			actionPerformedMniConfigurarCuotaDiaria(e);
		}
		if (e.getSource() == mniConfigurarCantidadOptima) {
			actionPerformedMniConfigurarCantidadOptima(e);
		}
		if (e.getSource() == mniConfigurarObsequios) {
			actionPerformedMniConfigurarObsequios(e);
		}
		if (e.getSource() == mniVender) {
			actionPerformedMniVender(e);
		}
		if (e.getSource() == mniConfigurarDescuentos) {
			actionPerformedMniConfigurarDescuentos(e);
		}
		if (e.getSource() == mniListarLavadoras) {
			actionPerformedMniListarLavadoras(e);
		}
		if (e.getSource() == mniModificarLavadora) {
			actionPerformedMniModificarLavadora(e);
		}
		if (e.getSource() == mniConsultarLavadora) {
			actionPerformedMniConsultarLavadora(e);
		}
		if (e.getSource() == mniAcercaDeTienda) {
			actionPerformedMniAcercaDeTienda(e);
		}
		if (e.getSource() == mntmNewMenuItem) {
			actionPerformedMntmNewMenuItem(e);
		}
		
	}
	protected void actionPerformedMntmNewMenuItem(ActionEvent e) {
		int respuesta;
		
		respuesta= JOptionPane.showConfirmDialog(null, "¿Confirme si desea salir?",
				"IMPORTANTE", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (respuesta==0)
		System.exit(0);
	}
	protected void actionPerformedMniAcercaDeTienda(ActionEvent e) {
		DialogAcercaDeTienda d = new DialogAcercaDeTienda();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMniConsultarLavadora(ActionEvent e) {
		DialogConsultarLavadora d = new DialogConsultarLavadora();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMniModificarLavadora(ActionEvent e) {
		DialogModificarLavadora d = new DialogModificarLavadora();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMniListarLavadoras(ActionEvent e) {
		DialogListarLavadoras d = new DialogListarLavadoras();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMniConfigurarDescuentos(ActionEvent e) {
		DialogConfigurarDescuentos d = new DialogConfigurarDescuentos();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMniVender(ActionEvent e) {
		DialogVender d = new DialogVender();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMniConfigurarObsequios(ActionEvent e) {
		DialogConfigurarObsequios d = new DialogConfigurarObsequios();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMniConfigurarCantidadOptima(ActionEvent e) {
		DialogConfigurarCantidad d = new DialogConfigurarCantidad();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMniConfigurarCuotaDiaria(ActionEvent e) {
		DialogConfigurarCuota d = new DialogConfigurarCuota();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
}
