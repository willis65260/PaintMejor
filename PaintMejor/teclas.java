package PaintMejor;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class teclas extends JPanel
{

	private static final long serialVersionUID = 1L;
	
	JFrame v;
	JPanel panel,panel_1;
	JPanel contentPane;
	JTextArea area1;
	
	public teclas()
	{
		v=new JFrame("Teclas Aceleradoras");
		v.setResizable(false);
		v.setBounds(100, 100, 206, 267);
		v.setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		v.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(6, 6, 193, 230);
		contentPane.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(6, 6, 178, 215);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		area1 = new JTextArea();
		area1.setEditable(false);
		area1.setBackground(Color.GREEN);
		area1.setText("     Teclas Rápidas\n-> Restaurar (Alt+R)\n-> Escalar      (Alt+E)\n-> Rotación    (Alt+I)\n-> Deformar   (Alt+D)\n-> Reflexión    (Alt+F)\n-> Trasladar    (Alt+T)\n-> Autores       (Alt+A)\n-> Ayuda         (Alt+1)\n-> Cerrar App  (Alt+X)");
		area1.setFont(new Font("Chalkboard SE", Font.PLAIN, 13));
		area1.setBounds(6, 6, 162, 202);
		panel_1.add(area1);
		
		v.setVisible(true);
		v.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new teclas();
	}

}
