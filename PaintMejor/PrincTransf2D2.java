package PaintMejor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

public class PrincTransf2D2 extends JPanel implements ActionListener, MouseWheelListener,KeyListener {

	
	private static final long serialVersionUID = 1L;
	JFrame v;
	Figura2D2 F;
	JButton bEsc, bDef, bRes, bRot, bTras, bRefx, bRefy, bRefxy;
	JMenuBar barraM;
	JMenu Menu1, Menu2, Menu3, subMenu3, subMenu23, Menu4;
	JMenuItem opcRest, opcEsc, opcRot, opcDef, opcRef, opcTras, opcSalir, opcDes, opcAyu, aniEsc, aniRotD, aniRotI,
			  aniRef, aniRefx, aniRefy, aniRefxy, aniTras, aniChair, figuraUno,figuraDos,popRes;
	JToolBar barraH;
	JPopupMenu popup;
	int FiguraActual;
	Image imFondo;
	boolean bandera = false;
	static boolean mover = false;
	ayuda1 ayuda1;
	autores autores;
	teclas teclas;

	@SuppressWarnings("deprecation")
	
	public void crearMenu() {
		FiguraActual = 1;
		barraM = new JMenuBar();
		v.setJMenuBar(barraM);
		Menu1 = new JMenu("Transforamciones");
		Menu2 = new JMenu("Acerca de...");
		Menu3 = new JMenu("Animaciones");
		subMenu3 = new JMenu("Reflexiones");
		subMenu23 = new JMenu("Rotaciones");
		Menu4 = new JMenu("Figuras");
		
		barraM.add(Menu1);
		barraM.add(Menu3);
		barraM.add(Menu4);
		barraM.add(Menu2);

		opcRest = new JMenuItem("Restaurar");
		opcRest.setMnemonic('R');
		opcRest.setToolTipText("Restaura la figura a la original");
		URL rutaIm = getClass().getResource("/Unidad2/rec/rest.png");
		opcRest.setIcon(new ImageIcon(rutaIm));
		opcRest.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_MASK));

		opcEsc = new JMenuItem("Escalar");
		opcEsc.setMnemonic('E');
		opcEsc.setToolTipText("Escala la figura al tamaño deseado");
		rutaIm = getClass().getResource("/Unidad2/rec/escala.png");
		opcEsc.setIcon(new ImageIcon(rutaIm));
		opcEsc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.ALT_MASK));

		opcDef = new JMenuItem("Deformar");
		opcDef.setMnemonic('D');
		opcDef.setToolTipText("Deforma la figura al tamaño deseado");
		rutaIm = getClass().getResource("/Unidad2/rec/defo.gif");
		opcDef.setIcon(new ImageIcon(rutaIm));
		opcDef.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.ALT_MASK));

		opcRef = new JMenuItem("Refleccion");
		opcRef.setMnemonic('F');
		opcRef.setToolTipText("Reflecciona la imagen");
		rutaIm = getClass().getResource("/Unidad2/rec/refle1.png");
		opcRef.setIcon(new ImageIcon(rutaIm));
		opcRef.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.ALT_MASK));

		opcTras = new JMenuItem("Trasladar");
		opcTras.setMnemonic('T');
		opcTras.setToolTipText("Traslada la imagen a un punto");
		rutaIm = getClass().getResource("/Unidad2/rec/mov.png");
		opcTras.setIcon(new ImageIcon(rutaIm));
		opcTras.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.ALT_MASK));

		Menu1.add(opcRest);
		Menu1.add(opcEsc);
		opcRot = new JMenuItem("Rotacion");
		opcRot.setMnemonic('I');
		opcRot.setToolTipText("Rota la figuara en el sentido deseado");
		rutaIm = getClass().getResource("/Unidad2/rec/rotar.png");
		opcRot.setIcon(new ImageIcon(rutaIm));
		opcRot.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.ALT_MASK));

		Menu1.add(opcRot);
		Menu1.add(opcDef);
		Menu1.add(opcRef);
		Menu1.add(opcTras);
		Menu1.addSeparator();

		opcSalir = new JMenuItem("Salir");
		opcSalir.setMnemonic('X');
		opcSalir.setToolTipText("Adioooooos");
		rutaIm = getClass().getResource("/Unidad2/rec/cerrar.jpeg");
		opcSalir.setIcon(new ImageIcon(rutaIm));
		Menu1.add(opcSalir);
		opcSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK));

		// Menu Items Menu 3

		aniEsc = new JMenuItem("Escalamiento");
		aniEsc.setToolTipText("Animacion de escalar la figura");
		Menu3.add(aniEsc);
//		opcAyu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.ALT_MASK));

		aniRotD = new JMenuItem("RotacionD");
		aniRotD.setToolTipText("Rotacion en el sentido de las manecillas del reloj");
		subMenu23.add(aniRotD);
//		opcAyu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.ALT_MASK));

		aniRotI = new JMenuItem("RotacionI");
		aniRotI.setToolTipText("Rotacion en contra del sentido de las manecillas del reloj");
		subMenu23.add(aniRotI);

		Menu3.add(subMenu23);
//		opcAyu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.ALT_MASK));

		// Otro menu aniRef
		aniRefx = new JMenuItem("Reflexion x");
		aniRefx.setToolTipText("Pone un espejo en la coordenada x ");
		subMenu3.add(aniRefx);

		aniRefy = new JMenuItem("Reflexion y");
		aniRefy.setToolTipText("Pone un espejo en la coordenada y ");
		subMenu3.add(aniRefy);

		aniRefxy = new JMenuItem("Reflexion xy");
		aniRefxy.setToolTipText("Pone un espejo en la coordenada xy");
		subMenu3.add(aniRefxy);

		Menu3.add(subMenu3);

		aniTras = new JMenuItem("Traslacion");
		aniTras.setToolTipText("Mueve la figura al punto x,y tomando en cuenta el origen");
		Menu3.add(aniTras);
//		opcAyu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.ALT_MASK));

		aniChair = new JMenuItem("Deformacion");
		aniChair.setToolTipText("Deforma");
		Menu3.add(aniChair);
//		opcAyu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.ALT_MASK));

		figuraUno = new JMenuItem("Figura 1");
		figuraUno.setToolTipText("Cambia a la figura 1");
		Menu4.add(figuraUno);
//		opcAyu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.ALT_MASK));

		figuraDos = new JMenuItem("Figura 2");
		figuraDos.setToolTipText("Cambia a la figura 2");
		Menu4.add(figuraDos);
		
		opcDes = new JMenuItem("Autores");
		opcDes.setMnemonic('A');
		opcDes.setToolTipText("Acerca de los creadores");
		rutaIm = getClass().getResource("/Unidad2/rec/trifuerza.png");
		opcDes.setIcon(new ImageIcon(rutaIm));
		opcDes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_MASK));

		opcAyu = new JMenuItem("Ayuda");
		opcAyu.setMnemonic('1');
		opcAyu.setToolTipText("Traslada la imagen a un punto");
		rutaIm = getClass().getResource("/Unidad2/rec/ayuda.png");
		opcAyu.setIcon(new ImageIcon(rutaIm));
		Menu2.add(opcDes);
		Menu2.add(opcAyu);
		opcAyu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.ALT_MASK));
		
		//Agregar el popupmenu
		popup = new JPopupMenu(); 
		popRes=new JMenuItem("Restaurar");
		addPopup(this,popup);
		//popup.setVisible(true);
		popup.add(popRes);
		
//		addMouseListener(new MouseAdapter() {
//			
//			
//			@Override
//			public void mousePressed(MouseEvent e) {
//				 int cx=e.getX();
//	                int cy=e.getY();
//	                Point pfx=F.obtCoordXFigura();
//	                Point pfy=F.obtCoordYFigura();
//	                if(cx < pfx.x && e.getClickCount()>=2)
//	                    F.RotacionConPuntoH(5);
//	                else
//	                    if(cx > pfx.y && e.getClickCount()>=2)
//	                        F.RotacionSenPuntoH(5);
//	                if((cx>pfx.x && cx<pfx.y)&&(cy>pfy.x && cy<pfy.y))
//	                    mover=true;
//	                else
//	                    mover=false;
//	                repaint();
//				
//			}	
//			
//		});
//		
		popRes.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				F.Restaurar();
				F.DEFINIR_FIGURA(FiguraActual);
				repaint();
				
			}
		});
		
		// Fondo
		rutaIm = getClass().getResource("/Unidad2/rec/fondoa.jpeg");
		imFondo = new ImageIcon(rutaIm).getImage();

		// Eventos Menu
		opcSalir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		opcEsc.addActionListener(this);
		opcRest.addActionListener(this);
		opcRot.addActionListener(this);
		opcDef.addActionListener(this);
		opcRef.addActionListener(this);
		opcTras.addActionListener(this);
		opcAyu.addActionListener(this);
		opcDes.addActionListener(this);
		aniEsc.addActionListener(this);
		aniRotD.addActionListener(this);
		aniRotI.addActionListener(this);
		aniRefy.addActionListener(this);
		aniRefx.addActionListener(this);
		aniRefxy.addActionListener(this);
		aniTras.addActionListener(this);
		aniChair.addActionListener(this);
		
		figuraUno.addActionListener(this);
		figuraDos.addActionListener(this);
		
		v.setFocusable(true);
		v.addKeyListener(this);
			
		
		//popRes.addActionListener(this);
	}



	



	public void crearBarraH() {
		barraH = new JToolBar("Operaciones", JToolBar.VERTICAL);
		URL ruta = getClass().getResource("/Unidad2/rec/rest.png");
		Action A3 = new AbstractAction("", new ImageIcon(ruta)) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent arg0) {
				F.Restaurar();
				F.DEFINIR_FIGURA(FiguraActual);
				repaint();
			}
		};

		A3.putValue(Action.SHORT_DESCRIPTION, "Restaura a la figura original");
		JButton bA3 = new JButton(A3);
		barraH.add(bA3);

		////////////////////////////////////////////////////////////////////////////

		ruta = getClass().getResource("/Unidad2/rec/refx.png");
		Action A4 = new AbstractAction("", new ImageIcon(ruta)) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent arg0) {

				F.refleccionPuntoH(1, -1);
				;
				repaint();
			}
		};

		A4.putValue(Action.SHORT_DESCRIPTION, "Reflexion sobre el eje de las x");
		JButton bA4 = new JButton(A4);
		barraH.add(bA4);

////////////////////////////////////////////////////////////////////////////

		ruta = getClass().getResource("/Unidad2/rec/refy.png");
		Action A5 = new AbstractAction("", new ImageIcon(ruta)) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent arg0) {

				F.refleccionPuntoH(-1, 1);
				;
				repaint();
			}
		};

		A5.putValue(Action.SHORT_DESCRIPTION, "Reflexion sobre el eje de las y");
		JButton bA5 = new JButton(A5);
		barraH.add(bA5);

////////////////////////////////////////////////////////////////////////////

		ruta = getClass().getResource("/Unidad2/rec/refxy.png");
		Action A6 = new AbstractAction("", new ImageIcon(ruta)) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent arg0) {

				F.refleccionPuntoH(-1, -1);
				repaint();
			}
		};

		A6.putValue(Action.SHORT_DESCRIPTION, "Reflexion sobre el eje de las xy");
		JButton bA6 = new JButton(A6);
		barraH.add(bA6);

////////////////////////////////////////////////////////////////////////////

		ruta = getClass().getResource("/Unidad2/rec/zoomin.png");
		Action A7 = new AbstractAction("", new ImageIcon(ruta)) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent arg0) {

				F.escalarPuntoH(1.1);
				repaint();
			}
		};

		A7.putValue(Action.SHORT_DESCRIPTION, "Incrementa el tamaño de la figura una cantidad definida");
		JButton bA7 = new JButton(A7);
		barraH.add(bA7);

////////////////////////////////////////////////////////////////////////////

		ruta = getClass().getResource("/Unidad2/rec/zoomout.png");
		Action A8 = new AbstractAction("", new ImageIcon(ruta)) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent arg0) {

				F.escalarPuntoH(.9);
				repaint();
			}
		};

		A8.putValue(Action.SHORT_DESCRIPTION, "Disminuye el tamaño de la figura una cantidad definida");
		JButton bA8 = new JButton(A8);
		barraH.add(bA8);

////////////////////////////////////////////////////////////////////////////

		ruta = getClass().getResource("/Unidad2/rec/rotari.png");
		Action A1 = new AbstractAction("", new ImageIcon(ruta)) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent arg0) {

				F.RotacionConPuntoH(5);
				repaint();
			}
		};

		A1.putValue(Action.SHORT_DESCRIPTION, "Rota 5 grados a la izquierda");
		JButton bA1 = new JButton(A1);
		barraH.add(bA1);
		v.add(barraH, BorderLayout.EAST);

////////////////////////////////////////////////////////////////////////////

		ruta = getClass().getResource("/Unidad2/rec/rotard.png");
		Action A2 = new AbstractAction("", new ImageIcon(ruta)) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent arg0) {

				F.RotacionSenPuntoH(5);
				repaint();
			}
		};

		A2.putValue(Action.SHORT_DESCRIPTION, "Rota 5 grados a la derecha");
		JButton bA2 = new JButton(A2);
		barraH.add(bA2);
		barraH.setFloatable(false);
		v.add(barraH, BorderLayout.EAST);

////////////////////////////////////////////////////////////////////////////

		ruta = getClass().getResource("/Unidad2/rec/cerrar.jpeg");
		Action A9 = new AbstractAction("", new ImageIcon(ruta)) {

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent arg0) {

				System.exit(0);
			}
		};

		A9.putValue(Action.SHORT_DESCRIPTION, "Adioooooooooos y gracias");
		JButton bA9 = new JButton(A9);
		barraH.add(bA9);
	}

	public PrincTransf2D2() {
		v = new JFrame("Transmormaciones en 2D");
		v.setSize(1000, 600);
		setSize(1000, 600);
		v.setLocationRelativeTo(this);
		v.setResizable(false);

		crearMenu();
		crearBarraH();

		v.add(this);

		F = new Figura2D2(FiguraActual);

		addMouseWheelListener(this);
		addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {
				int cx = e.getX();
				int cy = e.getY();
				Point pfx = F.obtCoordXFigura();
				Point pfy = F.obtCoordYFigura();
				if (cx < pfx.x && e.getClickCount() >= 2)
					F.RotacionConPuntoH(5);
				else if (cx > pfx.y && e.getClickCount() >= 2)
					F.RotacionSenPuntoH(5);
				if ((cx > pfx.x && cx < pfx.y) && (cy > pfy.x && cy < pfy.y))
					mover = true;
				else
					mover = false;
				//System.out.println(e.getButton());
				// System.out.println(mover);
				repaint();
			}
		});

		addMouseMotionListener(new MouseMotionAdapter() {

			public void mouseDragged(MouseEvent e) {
				int cx = e.getX();
				int cy = e.getY();

				if (mover) {
					int pcx = (int) F.figura[0].x;
					int pcy = (int) F.figura[0].y;
					int tx = cx - pcx;
					int ty = cy - pcy;
					F.TraslacionO(tx, ty);
					repaint();
				}
			}
		});

//		v.setEnabled(false);
//		new PanelAnimacion("Hola jotos", v, 1);

		v.setVisible(true);
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int maxx = getWidth();
		int maxy = getHeight();
		// F.DibujarVecUni(g);
		// F.DibujarVecBid(g);
		g.drawImage(imFondo, 0, 0, maxx, maxy, this);
		g.fillRect(maxx - 300, maxy - 200, 300, 200);
		F.DibujarVecPuntos(g);
		F.mapeoVentana(maxx, maxx - 300, getHeight(), maxy - 200, getWidth(), getHeight(), g);
//		F.DibujarPanel(bandera);
//		repaint(); <-- se buguea
//		F.mapeoVentana(maxx, maxx-300, getHeight(), maxy-200, getWidth(), getHeight(), g);
	}

	public static void main(String[] args) {
		new PrincTransf2D2();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == opcEsc) {
			double res = new cDialogEscalar(PrincTransf2D2.this, true).mostrar();
			F.escalarPuntoH(res);
		} else if (e.getSource() == opcRest) {
			F.Restaurar();
			F.DEFINIR_FIGURA(FiguraActual);
			//
		} else if (e.getSource() == opcRot) {
			double res[] = new cDialogoRotacion(PrincTransf2D2.this, true).mostrar();
			if (res != null) {
				if (res[0] == 0) {
					F.RotacionConPuntoH((int) res[1]);
				} else {
					F.RotacionSenPuntoH((int) res[1]);
				}
			}
		}else 

		// Animaciones en el Menu3

		if (e.getSource() == aniEsc) {

			v.setEnabled(false);
			new PanelAnimacion("Animacion Escalamiento", v, 1, FiguraActual);

		} else if (e.getSource() == aniRotD) {

			v.setEnabled(false);
			new PanelAnimacion("Animacion de Rotación a la derecha", v, 2, FiguraActual);

		} else if (e.getSource() == aniRotI) {

			v.setEnabled(false);
			new PanelAnimacion("Animacion de Rotación a la izquierda", v, 3, FiguraActual);

		} else if (e.getSource() == aniRefx) {

			v.setEnabled(false);
			new PanelAnimacion("Animación Reflexión con respecto a la X", v, 4, FiguraActual);

		} else if (e.getSource() == aniRefy) {

			v.setEnabled(false);
			new PanelAnimacion("Animación Reflexión con respecto a la Y", v, 5, FiguraActual);

		} else if (e.getSource() == aniRefxy) {

			v.setEnabled(false);
			new PanelAnimacion("Animación Reflexión con respecto a la XY", v, 6, FiguraActual);

		} else if (e.getSource() == aniTras) {

			v.setEnabled(false);
			new PanelAnimacion("Animación de traslación", v, 7, FiguraActual);

		} else if (e.getSource() == aniChair) {

			v.setEnabled(false);
			new PanelAnimacion("Animación con deformación", v, 8, FiguraActual);

		}  else if (e.getSource() == figuraUno) {

			FiguraActual=1;
			F.DEFINIR_FIGURA(FiguraActual);
			repaint();

		}  else if (e.getSource() == figuraDos) {

			FiguraActual=2;
			F.DEFINIR_FIGURA(FiguraActual);
			repaint();
			
		}else if(e.getSource()==opcAyu)
		{
			ayuda1 = new ayuda1();
			ayuda1.v.setVisible(true);
			v.setVisible(false);
		}else if (e.getSource()==opcDes)
		{
			autores = new autores();
			autores.v.setVisible(true);
			
		}else if(e.getSource() == opcDef)
		{
			cDialogoDeformar res = new cDialogoDeformar(PrincTransf2D2.this, true);
			res.mostrar();
			F.deformarPuntoH(res.cantDef1,res.cantDef2);
		}else if(e.getSource() == opcRef)
		{
			double[] res = new cDialogoReflexion(PrincTransf2D2.this,true).mostrar();
			if (res != null) {
				if (res[0] == 0) {
					F.refleccionPuntoH((int)res[1],(int)res[2]);
				} else if (res[0] == 1)
				{
					F.refleccionPuntoH((int)res[1],(int)res[2]);
				}else if (res[0] == 2)
				{
					F.refleccionPuntoH((int)res[1],(int)res[2]);
				}else {
					System.out.println("Algo salio bien mal we");
				}
			}
		}else if(e.getSource() == opcTras)
		{
			cDialogoTrasladar res = new cDialogoTrasladar(PrincTransf2D2.this, true);
			res.mostrar();
			F.TraslacionO((int)res.cantTras1,(int)res.cantTras2);
		}
		repaint();
	}

	public void mouseWheelMoved(MouseWheelEvent e) {
		int sentRueda = e.getWheelRotation();
		if (sentRueda < 0) {// arriba
			F.escalarPuntoH(.995);
		} else {
			// abajo
			F.escalarPuntoH(1.005);
		}
		repaint();
	}


	private static void addPopup(Component component, final JPopupMenu popup) {
        component.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    if(mover) {
                    showMenu(e);
                    }
                }
            }
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    if(mover) {
                    showMenu(e);
                    }
                }
            }
            private void showMenu(MouseEvent e) {
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        });
    }

	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
		teclas = new teclas();
		if(e.getKeyCode()==KeyEvent.VK_F1){
			teclas.v.setVisible(true);
		}
	}

	public void keyReleased(KeyEvent e) 
	{
		
	}
}
