package PaintMejor;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class PanelAnimacion extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	Figura2D2 figura;
	JFrame V;
	JFrame padre;
	String titulo;
	Thread Hilo;
	HiloDeAnimacion HDAnimacion;
	int f;

	// mandar tambien la accion a realizar
	public PanelAnimacion(String titulo, JFrame padre, int numeroT, int f) {
		this.titulo = titulo;
		this.padre = padre;
		this.f = f;
		V = new JFrame();
		V.setSize(550, 350);
		V.setTitle(titulo);

		figura = new Figura2D2(f);
		HDAnimacion = new HiloDeAnimacion(figura, this, numeroT, f);
//		Hilo.notifyAll();
		V.setLocationRelativeTo(padre);

		setSize(550, 350);
		setLocation(0, 0);
		V.add(this);
		V.setVisible(true);
		V.setLocationRelativeTo(padre);
		V.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Hilo = new Thread(HDAnimacion);
		Hilo.start();
		V.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				// profe porfavor no nos pregunte que hace esto
				// no servia y le puse metodos a lo sonzo y sirvio
				// asi lo dejaremos gracias :D
				try {
					try {
						Hilo.stop();
						Hilo.wait();
						Hilo.interrupt();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} catch (Exception e) {
					padre.setEnabled(true);
					HDAnimacion.parar = false;
					V.dispose();
				}

			}
		});
		V.setAlwaysOnTop(true);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		if (f == 1)
			g.translate(-100, -250);
		else
			g.translate(80, -170);
		figura.DibujarVecPuntos(g);
//		figura.RotacionSenPuntoH(45);
		// hacer una figura animacion y un resetFiguraAnimacion();
	}
}

class HiloDeAnimacion implements Runnable {
	Figura2D2 figura;
	JPanel panel;
	boolean parar = true;
	int t;
	int f;

	public HiloDeAnimacion(Figura2D2 figura, JPanel panel, int t, int f) {

		this.figura = figura;
		this.panel = panel;
		this.t = t;
		this.f = f;
	}

	@Override
	public void run() {
		figura.escalarPuntoH(.05);
		while (parar) {
			AplicarTransformaionContinua(t);
		}

	}

	public void alto() {
		parar = false;
	}

	// 0.- Escalamiento SIUUU
	// 1.- RotacionD SIUUU
	// 2.- RotacionI SIUUU
	// 3.- Reflexion SIUUU
	// 4.- Traslacion SIUUU
	// 5.- Shear SIUUU

	public void AplicarTransformaionContinua(int transformacion) {

		if (transformacion == 1) {// Escalamiento
//			figura.escalarPuntoH(2);
			while (parar) {
				try {
					figura.DEFINIR_FIGURA(f);
					figura.escalarPuntoH(.5);
					panel.repaint();
					Thread.sleep(1000);

					figura.DEFINIR_FIGURA(f);
					figura.escalarPuntoH(.05);
					panel.repaint();
					Thread.sleep(1000);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (!parar)
					break;
			}
		} else if (transformacion == 2) {// RotacionD? pero el profe dijo que la derecha se hacia con la izquierda y
											// viceversa asi que ya no se cual es cual
			for (int i = 0; i < 360; i += 5) {
				try {
					figura.RotacionSenPuntoH(i);
					panel.repaint();

					System.out.println(parar);
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (!parar)
					break;
				figura.DEFINIR_FIGURA(f);
				figura.escalarPuntoH(.5);
			}
		} else if (transformacion == 3) {// RotacionI
			for (int i = 0; i < 360; i += 5) {
				try {
					figura.RotacionConPuntoH(i);
					panel.repaint();

					System.out.println(parar);
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (!parar)
					break;
				figura.DEFINIR_FIGURA(f);
				figura.escalarPuntoH(.5);
			}
		} else if (transformacion == 4) {// Reflexion x

			while (parar) {
				try {
					figura.DEFINIR_FIGURA(f);
					figura.escalarPuntoH(.5);
					figura.refleccionPuntoH(1, -1);
					panel.repaint();
					Thread.sleep(1000);

					figura.DEFINIR_FIGURA(f);
					figura.escalarPuntoH(.5);
					panel.repaint();
					Thread.sleep(1000);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (!parar)
					break;
			}

		} else if (transformacion == 5) {// Reflexion y
			while (parar) {
				try {
					figura.DEFINIR_FIGURA(f);
					figura.escalarPuntoH(.5);
					figura.refleccionPuntoH(-1, 1);
					panel.repaint();
					Thread.sleep(1000);

					figura.DEFINIR_FIGURA(f);
					figura.escalarPuntoH(.5);
					panel.repaint();
					Thread.sleep(1000);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (!parar)
					break;
			}
		} else if (transformacion == 6) {// Reflexion xy
			while (parar) {
				try {
					figura.DEFINIR_FIGURA(f);
					figura.escalarPuntoH(.5);
					figura.refleccionPuntoH(-1, -1);
					panel.repaint();
					Thread.sleep(1000);

					figura.DEFINIR_FIGURA(f);
					figura.escalarPuntoH(.5);
					panel.repaint();
					Thread.sleep(1000);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (!parar)
					break;
			}
		} else if (transformacion == 7) {// traslacion
			while (parar) {
				try {
					figura.DEFINIR_FIGURA(f);
					figura.escalarPuntoH(.5);
					figura.TraslacionO(-100, 0);
					panel.repaint();
					Thread.sleep(1000);

					figura.DEFINIR_FIGURA(f);
					figura.escalarPuntoH(.5);
					figura.TraslacionO(50, 0);
					panel.repaint();
					Thread.sleep(1000);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (!parar)
					break;
			}
		} else if (transformacion == 8) {// Deformacion o shear
			while (parar) {
				try {
					figura.DEFINIR_FIGURA(f);
					figura.escalarPuntoH(.5);
					figura.deformarPuntoH(.5, .5);
					panel.repaint();
					Thread.sleep(1000);

					figura.DEFINIR_FIGURA(f);
					figura.escalarPuntoH(.5);
//					figura.TraslacionO(50, 0);
					panel.repaint();
					Thread.sleep(1000);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (!parar)
					break;
			}
		} else {
			System.out.println("Algo salio mal carnalito");
		}
	}

}
