package Zadanie1;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Transform2D extends JPanel {

	private class Display extends JPanel {
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			g2.translate(300, 300);
			int whichTransform = transformSelect.getSelectedIndex();
			
			Polygon p = new Polygon();
			float kat;
			int katy = 17;
		    for (int i = 0; i < 17; i++)
		    {
		    	kat = (float) (i * 2.0f * Math.PI / katy);
		    	p.addPoint((int)(Math.cos(kat) * 150), (int)(Math.sin(kat) * 150));
		    }
			
			switch (whichTransform) {
			case 1:
				g2.scale(0.5, 0.5);
				break;
			case 2:
				g2.rotate(Math.toRadians(45));
				break;
			case 3:
				g2.rotate(Math.toRadians(180));
				g2.scale(0.5, 0.9);
				float[] map = {-1.0f,0.0f,0.0f,1.0f};
				AffineTransform af = new AffineTransform(map);
				g2.transform(af);
				break;
			case 4:
				g2.shear(0.5, 0.0);
				break;
			case 5:
				g2.translate(0, -230);
				g2.scale(1, 0.5);
				break;
			case 6:
				g2.rotate(Math.toRadians(90));
				g2.shear(0.5, 0.0);
				break;
			case 7:
				g2.rotate(Math.toRadians(-180));
				g2.scale(0.5, 0.9);
				break;
			case 8:
				g2.translate(-50, 100);
				g2.rotate(Math.toRadians(30));
				g2.scale(1, 0.5);
				break;
			case 9:
				g2.translate(100, 0);
				g2.rotate(Math.toRadians(180));
				g2.shear(0.0, 0.5);
				break;
			default:
				break;
			}
			g2.setColor(getForeground().BLUE);
			g2.drawPolygon(p);
			g2.fill(p);
		}
	}

	private Display display;
	private BufferedImage pic;
	private JComboBox<String> transformSelect;

	public Transform2D() throws IOException {
		pic = ImageIO.read(getClass().getClassLoader().getResource("shuttle.jpg"));
		display = new Display();
		display.setBackground(Color.YELLOW);
		display.setPreferredSize(new Dimension(600,600));
		transformSelect = new JComboBox<String>();
		transformSelect.addItem("None");
		for (int i = 1; i < 10; i++) {
			transformSelect.addItem("No. " + i);
		}
		transformSelect.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.repaint();
			}
		});
		setLayout(new BorderLayout(3,3));
		setBackground(Color.GRAY);
		setBorder(BorderFactory.createLineBorder(Color.GRAY,10));
		JPanel top = new JPanel();
		top.setLayout(new FlowLayout(FlowLayout.CENTER));
		top.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		top.add(new JLabel("Transform: "));
		top.add(transformSelect);
		add(display,BorderLayout.CENTER);
		add(top,BorderLayout.NORTH);
	}


	public static void main(String[] args) throws IOException {
		JFrame window = new JFrame("2D Transforms");
		window.setContentPane(new Transform2D());
		window.pack();
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		window.setLocation( (screen.width - window.getWidth())/2, (screen.height - window.getHeight())/2 );
		window.setVisible(true);
	}

}