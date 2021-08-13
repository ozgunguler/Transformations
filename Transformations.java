package labwork6;
// Solution to Exercises 4.1

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.event.*; 
import java.awt.geom.Line2D;

public class Transformations extends Frame implements ActionListener, MouseListener
{
	static final int windowWidth = 800;
	static final int windowHeight = 800;
	

	 // Initialize coordinates of the triangle
	 int[] x = {500,700,600};
	 int[] y = {300,300,100}; 
	 
	 public static void main(String[] argv)
	 {
		Transformations tr = new Transformations();
		tr.setSize(windowWidth,windowHeight);
		//tr.setTitle("The first Java 2D program");
		tr.setVisible(true);
			
	}
	 
	public Transformations() {
	setTitle("Transformations");
	MenuBar menu_bar = new MenuBar();
		
	Menu def = new Menu("File");
	def.add(new MenuItem("Set Default"));
	def.addActionListener(this);
	menu_bar.add(def);
	setMenuBar(menu_bar);
	
    Panel panel=new Panel();  
    panel.setBounds(0,40,windowWidth,40);  
	
	Button button_s = new Button();
	button_s.setLabel("Translate Up");
	button_s.addActionListener(this);
	
	Button button_b = new Button();
	button_b.addActionListener(this);
	button_b.setLabel("Translate Down");
	
	Button button_c = new Button();
	button_c.addActionListener(this);
	button_c.setLabel("Translate Right");
	panel.add(button_s);
	panel.add(button_b);
	panel.add(button_c);
	
	Button button_d = new Button();
	button_d.addActionListener(this);
	button_d.setLabel("Translate Left");
	panel.add(button_s);
	panel.add(button_b);
	panel.add(button_c);
	panel.add(button_d);
	
	Button button_e = new Button();
	button_e.addActionListener(this);
	button_e.setLabel("Reflect X");
	panel.add(button_s);
	panel.add(button_b);
	panel.add(button_c);
	panel.add(button_d);
	panel.add(button_e);
	
	Button button_f = new Button();
	button_f.addActionListener(this);
	button_f.setLabel("Reflect Y");
	panel.add(button_s);
	panel.add(button_b);
	panel.add(button_c);
	panel.add(button_d);
	panel.add(button_e);
	panel.add(button_f);

	panel.setBackground(Color.darkGray); 
	add(panel);
	setLayout(null);
	addWindowListener(new MyFinishWindow());
	addMouseListener(this);
	setBackground(Color.pink);
	
	}

	public void paint(Graphics g)
	{
		
		Graphics2D g2d = (Graphics2D) g;
		 g2d.setColor(Color.WHITE);
		//x,y,x,y
		Line2D lin = new Line2D.Float(this.getWidth()/2, 0, this.getWidth()/2, this.getHeight());
		// Line2D lin = new Line2D.Float(400, 0, 400, 800);
		 g2d.draw(lin);
		 Line2D lin2 = new Line2D.Float(0, this.getHeight()/2, this.getWidth(), this.getHeight()/2);
		// Line2D lin2 = new Line2D.Float(0, 400, 800, 400);
		 g2d.draw(lin2);
		 g2d.setColor(Color.darkGray);
		 g2d.fillPolygon(x, y, 3);
		    
	}
	
	public class MyFinishWindow extends WindowAdapter
	   {
	     public void windowClosing(WindowEvent e)
	     {
	       System.exit(0);
	     }
	   }
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String str = arg0.getActionCommand();
		
		if(str.equals("Translate Up")) {
			
			System.out.println("Button 1 clicked.");	
			for (int i=0; i<3;i++) {
			y[i] = y[i]- 30;
			}
			repaint();
		}
		else if(str.equals("Translate Down")) {

			System.out.println("Button 2 clicked.");		
			for (int i=0; i<3;i++) {
			y[i] = y[i]+ 30;
			}
			repaint();
		}
		else if(str.equals("Translate Right")) {

			System.out.println("Button 3 clicked.");	
			for (int i=0; i<3;i++) {
				x[i] = x[i]+ 30;
				}
				repaint();
		}
		else if(str.equals("Translate Left")) {

			System.out.println("Button 4 clicked.");
			for (int i=0; i<3;i++) {
				x[i] = x[i]- 30;
				}
				repaint();
		}
		else if(str.equals("Reflect X")) {

			System.out.println("Button 5 clicked.");
				for (int i=0; i<3;i++) {
				int num = y[i];
				num = (this.getHeight()-num*2)+num;
				y[i]=num;					
				}
			
			repaint();
			}
		
		else if(str.equals("Reflect Y")) {

			System.out.println("Button 6 clicked.");	
			for(int i=0; i<3; i++) {
			int num= x[i];
			num = (this.getWidth()-num*2)+num;
			x[i] = num;
			}
			
			repaint();
			
		} else if(str.equals("Set Default")) {
			System.out.println("Defaults.");
			x[0]= 500;
			x[1]= 700;
			x[2]= 600;
			y[0]= 300;
			y[1]= 300;
			y[2]= 100;
			repaint();
		}
	}
	public void mouseClicked(MouseEvent arg0) {
		int x = arg0.getX();
		int y = arg0.getY();
		repaint();
		// TODO Auto-generated method stub
		
	}
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
