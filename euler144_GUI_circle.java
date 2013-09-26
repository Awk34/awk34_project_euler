/*
 * Andrew Koroluk
 */

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.awt.RenderingHints;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JApplet;
import javax.swing.JFrame;

public class euler144_GUI_circle extends JApplet implements Runnable {
	private static final long serialVersionUID = 8448434994100300609L;
	static int w = 300;
	static int h = 2*w;
	static int var = (h-20)/20;

    public static void main(String[] args) {    	
        JFrame f = new JFrame("Project Euler #144 - by Andrew Koroluk");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });
        JApplet applet = new euler144_GUI_circle();
        f.getContentPane().add("Center", applet);
        applet.init();
        f.pack();
        f.setSize(new Dimension(w+25,h+50));
        f.setResizable(false);
        f.setVisible(true);
        try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
    }
	public void paint(Graphics g) {
		while(true) {
			Graphics2D g2 = (Graphics2D) g;
			//g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.draw(new Ellipse2D.Double(5, 8, w-10, h-20));
	
			double x1 = 0;
			double y1 = 10.1;
			double x2 = 1.4;
			double y2 = -9.6;
			//int ans=1;
			g2.draw(new Line2D.Double(w/2-x1*var, h/2-y1*var, w/2-x2*var, h/2-y2*var));
	
			while(true) {
				double m0 = (y2-y1)/(x2-x1);
				double m1 = deriv(x2,y2);
				double tempX=x2, tempY=y2;
				double X = (m0-m1)/(1+m0*m1);
				double m2 = (m1-X)/(1+X*m1);
	
				double b = (y2-m2*x2);
				x2 = quadratic(m2, b, x2);
				y2 = m2*x2 + b;
				x1=tempX;
				y1=tempY;
	
				g2.draw(new Line2D.Double(w/2-x1*var, h/2-y1*var, w/2-x2*var, h/2-y2*var));
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	
				if(y2>0 && x2>-.01 && x2<.01) break;
				//ans++;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
			//System.out.println(ans);
		}
	}
	static double deriv(double x, double y) {
		return -x/y;
	}
	static double quadratic(double m2, double n, double x2) {
		double a = 4 + m2*m2;
		double b = 2*m2*n;
		double c = n*n - 100;

		double ans1 =  (-b + Math.sqrt(b*b - 4*a*c))/(2*a);
		double ans2 =  (-b - Math.sqrt(b*b - 4*a*c))/(2*a);
	    double dx1 = x2 - ans1;
        double dx2 = x2 - ans2;
        dx1 = dx1>0 ? dx1 : -dx1;
        dx2 = dx2>0 ? dx2 : -dx2;

        if(dx1>dx2) return ans1;
        else return ans2;
	}
	@Override
	public void run() {
		
	}
}