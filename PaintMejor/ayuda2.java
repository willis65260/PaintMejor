package PaintMejor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class ayuda2 extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	JFrame v;
	JPanel contentPane,exterior,interior,izquierda,derecha;
	JLabel titulo,intro,intro2,tmenu;
	JTextArea area1,area2;
	JButton anterior,cerrar;
	ayuda1 ayuda1;
	PrincTransf2D2 principal;
	
	public ayuda2()
	{
		v=new JFrame("Ayuda 2");
		v.setResizable(false);
		v.setBounds(100, 100, 500, 727);
		v.setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		v.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		exterior = new JPanel();
		exterior.setBounds(6, 6, 488, 693);
		contentPane.add(exterior);
		exterior.setLayout(null);
		
		titulo = new JLabel("Ayuda");
		titulo.setFont(new Font("Chalkboard SE", Font.PLAIN, 16));
		titulo.setForeground(Color.BLUE);
		titulo.setBounds(202, 6, 72, 16);
		exterior.add(titulo);
		
		intro = new JLabel("Esta ventana te ayudará a entender un poco más");
		intro.setFont(new Font("Chalkboard SE", Font.PLAIN, 13));
		intro.setBounds(78, 23, 303, 16);
		exterior.add(intro);
		
		intro2 = new JLabel("  acerca del menú de herramientas.");
		intro2.setFont(new Font("Chalkboard SE", Font.PLAIN, 13));
		intro2.setBounds(114, 34, 219, 16);
		exterior.add(intro2);
		
		tmenu = new JLabel("Menú de Herramientas");
		tmenu.setFont(new Font("Chalkboard SE", Font.PLAIN, 13));
		tmenu.setForeground(Color.RED);
		tmenu.setBounds(156, 51, 141, 16);
		exterior.add(tmenu);
		
		interior = new JPanel();
		interior.setBounds(0, 79, 476, 540);
		exterior.add(interior);
		interior.setLayout(null);
		
		izquierda = new JPanel();
		izquierda.setBounds(6, 6, 249, 525);
		interior.add(izquierda);
		izquierda.setLayout(null);
		
		area1 = new JTextArea();
		area1.setBackground(Color.PINK);
		area1.setFont(new Font("Chalkboard SE", Font.PLAIN, 13));
		area1.setEditable(false);
		area1.setText("Se encuentra en la parte superior \nde la pantalla. Consta de 4 menús\n(cada opción tiene una ayuda \nrápida con el cursor) que \ndespliegan herramientas.\n  -> Transformaciones. Cada  opción \n   cuenta con pantallas extras para \n   ingresar los datos correspondientes \n   a  excepción de \"Restaurar\".\n Las opciones son:\n   •Restaurar. Restaura la  figura a la \n    forma original.\n   •Escalar. Ventana donde se pone el \n     numero.\n   •Rotación. Ventana donde  se indica \n     el numero de rotación y el grado.\n   •Deformar. Ventana donde  te pide \n     los 2 valores a deformar\n   •Reflexión. Ventana donde se indica \n     el tipo de reflexión que  se requiere.\n   •Trasladar. Ventana donde se indica \n     a que coordenadas se debe mover.\n   •Salir. Opción para salir\n     directamente del programa.");
		area1.setBounds(6, 6, 243, 517);
		izquierda.add(area1);
		
		derecha = new JPanel();
		derecha.setBounds(254, 6, 216, 525);
		interior.add(derecha);
		derecha.setLayout(null);
		
		area2 = new JTextArea();
		area2.setBackground(Color.CYAN);
		area2.setFont(new Font("Chalkboard SE", Font.PLAIN, 13));
		area2.setEditable(false);
		area2.setText("-> Animaciones. Cada opción te \nmuestra una previsualización de \nla figura con la que trabajas. \nMencionar que se encuentra \ntodos las operaciones como \nopción. La ventana principal no\nse habilitará si una ventana de \nanimación se encuentra \nhabilitada.\n\n-> Figuras. Menú que te muestra\nlas 2 figuras disponibles. para\naplicarle las operaciones, basta \ncon pulsar cual opción quieres \npara cambiar de figura.\n\n-> Acerca de... \n     •Autores. Ventana donde te \n      muestra los desarrolladores\n      de esta maravillosa \n      aplicación.\n     •Ayuda. Ventana qeu trata de\n     resolver dudas acerca de como\n     funciona el programa. Contiene\n     un botón que te lleva a la\n     siguiente página de ayuda.");
		area2.setBounds(6, 6, 210, 518);
		derecha.add(area2);
		
		anterior = new JButton("Anterior");
		anterior.setIcon(new ImageIcon(ayuda2.class.getResource("/Unidad2/rec/atras.png")));
		anterior.setBounds(28, 631, 117, 54);
		exterior.add(anterior);
		
		cerrar = new JButton("Cerrar");
		cerrar.setIcon(new ImageIcon(ayuda2.class.getResource("/Unidad2/rec/cerrar.jpeg")));
		cerrar.setBounds(337, 631, 117, 54);
		exterior.add(cerrar);
		
		anterior.addActionListener(this);
		cerrar.addActionListener(this);
		
		v.setVisible(true);
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new ayuda2();
	}

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==anterior)
		{
			ayuda1 = new ayuda1();
			ayuda1.v.setVisible(true);
			v.setVisible(false);
		}else if(e.getSource()==cerrar)
		{
			principal = new PrincTransf2D2();
			principal.v.setVisible(true);
			v.setVisible(false);
		}
	}
}
