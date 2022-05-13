package PaintMejor;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.*;

public class cDialogoReflexion extends JDialog
{

	private static final long serialVersionUID = 1L;
	
	double argRef[];
	JLabel et1,et2,et3;
	JRadioButton rb1,rb2,rb3;
	ButtonGroup bg;
	JButton aceptar,cancelar;
	
	public cDialogoReflexion(PrincTransf2D2 v,boolean modal)
	{
		super(v.v,modal);
		setTitle("Reflexiona figuras en X, Y o XY");
		setSize(450,60);
		setLayout(new FlowLayout());
		setLocationRelativeTo(this);
		URL ruta=getClass().getResource("/Unidad2/rec/refx.png");
		et1=new JLabel(new ImageIcon(ruta));
		ruta=getClass().getResource("/Unidad2/rec/refy.png");
		et2=new JLabel(new ImageIcon(ruta));
		ruta=getClass().getResource("/Unidad2/rec/refxy.png");
		et3=new JLabel(new ImageIcon(ruta));
		bg=new ButtonGroup();
		rb1=new JRadioButton("",true);
		rb2=new JRadioButton();
		rb3=new JRadioButton();
		bg.add(rb1);bg.add(rb2);bg.add(rb3);
		aceptar=new JButton("Aceptar");
		cancelar=new JButton("Cancelar");
		add(et1);add(rb1);add(et2);
		add(rb2);add(et3);add(rb3);
		add(aceptar);add(cancelar);
		
		aceptar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				argRef=new double[3];
				if(rb1.isSelected()) 
				{
					argRef[0]=0;
					argRef[1]=1;
					argRef[2]=-1;
				}else if(rb2.isSelected())
				{
					argRef[0]=1;
					argRef[1]=-1;
					argRef[2]=1;
				}else if(rb3.isSelected())
				{
					argRef[0]=2;
					argRef[1]=-1;
					argRef[2]=-1;
				}
				setVisible(false);
				dispose();
					
			}
		});
		
		cancelar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				argRef=null;
				setVisible(false);
				dispose();
			}
		});
		
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	}
	
	public double[] mostrar()
	{
		setVisible(true);
		return argRef;
	}
	
}
