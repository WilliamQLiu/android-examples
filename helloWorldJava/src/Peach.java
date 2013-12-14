import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
// Lesson 84 - Drawing Graphics
public class Peach extends JPanel{
	
	public void paintComponent(Graphics g){
		super.paintComponents(g);  // Call superclass that we need to use
		this.setBackground(Color.WHITE);  // White background
		
		g.setColor(Color.BLUE);
		g.fillRect(25, 25, 100, 30);  // Draws a solid rectangle starting from top left
		
		g.setColor(new Color(190, 81, 215));  // Make sure no values over 255, R G B
		g.fillRect(25, 65, 100, 30); // Draws a solid rectangle
		
		g.setColor(Color.RED);
		g.drawString("Here is some text", 25, 120);
	}
}


// Lesson 85 - JColorChooser
public class Peach extends JFrame{
	private JButton b;
	private Color color = Color.WHITE;
	private JPanel panel;
	
	public Peach(){
		super("The title");
		panel = new JPanel();
		panel.setBackground(color);  // Setting background to color variable
		
		b = new JButton("Choose a color");
		b.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						color = JColorChooser.showDialog(null, "Pick your color", color);  // First parameter is the positioning (if null, shows in center), new dialog box appears (what dialog), initial color selected
						if(color==null)  // If no choice, then white
							color=(Color.WHITE);
					
						panel.setBackground(color);  // Change color of background
					}
				}
		);
		
		add(panel, BorderLayout.CENTER);  // BorderLayout.Center means panel appears in center of screen
		add(b, BorderLayout.SOUTH);	// Button appears in south
		setSize(425, 150);
		setVisible(true);
		
	}
}



// Lesson 86 - Draw More Stuff
public class Peach extends JPanel{
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		
		g.setColor(Color.BLUE);
		g.drawLine(10, 25, 200, 45);
		
		g.setColor(Color.RED);
		g.drawRect(10, 55, 100, 30);
		
		// Same as Rect, but rounds your corners
		g.setColor(Color.GREEN);
		g.fillOval(10, 95, 100, 30);
		
		// Kinda 3D
		g.setColor(Color.ORANGE);
		g.fill3DRect(10, 160, 100, 50, true);  // 3D Look?
		
	}
}

*/