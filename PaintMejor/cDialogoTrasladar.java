package PaintMejor;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.*;

public class cDialogoTrasladar extends JDialog
{

	private static final long serialVersionUID = 1L;
	
	double cantTras1=0.0,cantTras2=0.0;
	JLabel et1,et2,et3;
	JTextField ct1,ct2;
	JButton aceptar,cancelar;
	
	public cDialogoTrasladar(PrincTransf2D2 v,boolean modal)
	{
		super(v.v,modal);
		setTitle("Trasladar figura");
		setSize(810,60);
		setLayout(new FlowLayout());
		setLocationRelativeTo(this);
		URL ruta=getClass().getResource("/Unidad2/rec/mov.png");
		et1=new JLabel(new ImageIcon(ruta));
		et2=new JLabel("Cantidad a trasladar 1: ");
		ct1=new JTextField(10);
		et3=new JLabel("Cantidad a trasladar 2: ");
		ct2=new JTextField(10);
		aceptar=new JButton("Aceptar");
		cancelar=new JButton("Cancelar");
		add(et1);add(et2);add(ct1);add(et3);add(ct2);add(aceptar);add(cancelar);
		
		aceptar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String res=ct1.getText();
				String res1=ct2.getText();
				try 
				{
					cantTras1=Double.parseDouble(res);
					cantTras2=Double.parseDouble(res1);
				}catch(NumberFormatException a)
				{
					cantTras1=1.0;
					cantTras2=1.0;
				}
				setVisible(false);
				dispose();
			}
		});
		
		cancelar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				cantTras1=1;
				cantTras2=1;
				setVisible(false);
				dispose();
				
			}
		});
		
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	}
	
	public double mostrar()
	{
		setVisible(true);
		return cantTras1;
	}
	
}
