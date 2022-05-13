package PaintMejor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

public class cDialogoDeformar extends JDialog
{

	private static final long serialVersionUID = 1L;
	
	double cantDef1=0.0,cantDef2=0.0;
	JLabel et1,et2,et3;
	JTextField ct1,ct2;
	JButton aceptar,cancelar;
	
	
	public cDialogoDeformar(PrincTransf2D2 v,boolean modal)
	{
		super(v.v,modal);
		setTitle("Deformar figura");
		setSize(850,60);
		setLayout(new FlowLayout());
		setLocationRelativeTo(this);
		URL ruta=getClass().getResource("/Unidad2/rec/deformar.jpeg");
		et1=new JLabel(new ImageIcon(ruta));
		et2=new JLabel("Cantidad a deformar 1: ");
		ct1=new JTextField(10);
		et3=new JLabel("Cantidad a deformar 2: ");
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
					cantDef1=Double.parseDouble(res);
					cantDef2=Double.parseDouble(res1);
				}catch(NumberFormatException a)
				{
					cantDef1=1.0;
					cantDef2=1.0;
				}
				setVisible(false);
				dispose();
			}
		});
		
		cancelar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				cantDef1=1.0;
				cantDef2=1.0;
				setVisible(false);
				dispose();
			}
		});
		
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	}
	
	public double mostrar()
	{
		setVisible(true);
		return cantDef1;
	}

}
