package PaintMejor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class autores extends JPanel
{

	private static final long serialVersionUID = 1L;
	
	JFrame v;
	JPanel contentPane,panel;
	JLabel titulo;
	JTextArea area1;
	JLabel footer;
	
	public autores()
	{
		v=new JFrame("Desarolladores");
		
		v.setResizable(false);
		v.setBounds(100, 100, 310, 141);
		v.setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		v.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(6, 6, 298, 107);
		contentPane.add(panel);
		panel.setLayout(null);
		
		titulo = new JLabel("Desarrolladores");
		titulo.setBounds(96, 5, 99, 16);
		panel.add(titulo);
		
		area1 = new JTextArea();
		area1.setEditable(false);
		area1.setText("José Eduardo Poo Tapía\nJuan Pablo Valencia Cortez");
		area1.setBounds(51, 33, 195, 41);
		panel.add(area1);
		
		footer = new JLabel("©Todos los derechos reservados.");
		footer.setBounds(40, 86, 220, 16);
		panel.add(footer);
		
		v.setVisible(true);
		v.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new autores();
	}

}
