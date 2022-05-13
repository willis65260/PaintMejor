package PaintMejor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;



public class ayuda1 extends JPanel implements ActionListener
{
	
	private static final long serialVersionUID = 1L;
	
	JFrame v;
	JPanel panel;
	JPanel contentPane;
	JLabel intro,intro2;
	JTextArea area1,area2, area3;
	JLabel titulo,titulo1;
	JButton cerrar,siguiente;
	PrincTransf2D2 principal;
	ayuda2 ayuda2;
	
	public ayuda1()
	{
		v=new JFrame("Ayuda 1");
		
		v.setResizable(false);
		v.setBounds(100, 100, 480, 504);
		v.setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		v.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(6, 6, 468, 470);
		contentPane.add(panel);
		panel.setLayout(null);
		
		intro = new JLabel("Esta ventana te ayudará a entender un poco más");
		intro.setFont(new Font("Chalkboard SE", Font.PLAIN, 13));
		intro.setBounds(90, 34, 310, 16);
		panel.add(intro);
		
		intro2 = new JLabel("acerca del entorno de trabajo");
		intro2.setFont(new Font("Chalkboard SE", Font.PLAIN, 13));
		intro2.setBounds(146, 49, 191, 16);
		panel.add(intro2);
		
		area1 = new JTextArea();
		area1.setEditable(false);
		area1.setFont(new Font("Chalkboard SE", Font.PLAIN, 13));
		area1.setText("                    Tablero\nEl tablero es el fondo del \nprograma. Cuadriculado\npara la ayuda de un\nadecuado escalonamiento.\n\nSe encuentra una pantalla\ndonde se previsualiza la \nimagen actual. Se actualiza\nen tiempo real.");
		area1.setBounds(6, 80, 211, 167);
		panel.add(area1);
		
		area2 = new JTextArea();
		area2.setEditable(false);
		area2.setFont(new Font("Chalkboard SE", Font.PLAIN, 13));
		area2.setText("                      Mouse\n• Click derecho. Puede restaurar\n   la figura si abre el menú con\n   click derecho en la figura.\n• Arrastrar. Puede mover la\n   figura si da click derecho en\n   la figura y arrastrar.\n• Rueda. Con la rueda del ratón\n   puede ajustar el tamaño de la\n   figura. ");
		area2.setBounds(6, 254, 211, 167);
		panel.add(area2);
		
		area3 = new JTextArea();
		area3.setFont(new Font("Chalkboard SE", Font.PLAIN, 13));
		area3.setText("       Barra lateral de herrramientas\nUn acceso rápido de las herramientas \nque se encuentran en el menu \ndesplegable. La diferencia es que tiene\nvalores definidos. De arriba hacia abajo:\n   •Restaurar. Restaura la figura a la \n     forma original.\n   •Reflexión. Los siguientes 3 son\n     reflexiones. La primera es sobre el \n     eje de las X, la segunda es sobre el \n     eje de las Y y la tercera es sobre el \n     eje XY.\n   •Zoom in y Zoom out. La primera\n     opción incrementa la figura y la \n     segunda la disminuye.\n   •Restauración. La primera opción gira\n     hacia la izquierda y la segunda gira \n     hacia la derecha la figura.\n   •Cerrar. Cierra el programa por \n     completo.\n  \n");
		area3.setEditable(false);
		area3.setBounds(229, 77, 233, 344);
		panel.add(area3);
		
		titulo1 = new JLabel("Tablero");
		titulo1.setBounds(81, 80, 61, 16);
		panel.add(titulo1);
		
		cerrar = new JButton("Cerrar");
		cerrar.setIcon(new ImageIcon(ayuda1.class.getResource("/Unidad2/rec/cerrar.jpeg")));
		cerrar.setFont(new Font("Chalkboard SE", Font.PLAIN, 13));
		cerrar.setBounds(25, 423, 117, 41);
		panel.add(cerrar);
		
		siguiente = new JButton("Siguiente");
		siguiente.setIcon(new ImageIcon(ayuda1.class.getResource("/Unidad2/rec/adelante.png")));
		siguiente.setFont(new Font("Chalkboard SE", Font.PLAIN, 13));
		siguiente.setBounds(331, 423, 117, 41);
		panel.add(siguiente);
		
		titulo = new JLabel("Ayuda");
		titulo.setFont(new Font("Chalkboard SE", Font.PLAIN, 16));
		titulo.setForeground(Color.BLUE);
		titulo.setBounds(223, 6, 45, 16);
		panel.add(titulo);
		
		cerrar.addActionListener(this);
		siguiente.addActionListener(this);
		
		v.setVisible(true);
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new ayuda1();
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==cerrar)
		{
			principal = new PrincTransf2D2();
			v.setVisible(false);
			principal.v.setVisible(true);
		}else if(e.getSource()==siguiente)
		{
			ayuda2 = new ayuda2();
			v.setVisible(false);
			ayuda2.v.setVisible(true);
			
		}
	}
	
}
