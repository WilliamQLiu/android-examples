import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
/*
// Lesson 24 - 
public class TheWindow extends JFrame {
	
	private JSlider slider;
	private william myPanel;  // Calls panel from william class
	
	public TheWindow(){
		super("The Title");
		myPanel = new william();
		myPanel.setBackground(Color.ORANGE);

		// Setup slider and properties
		slider = new JSlider(SwingConstants.HORIZONTAL, 0, 200, 10);
		slider.setMajorTickSpacing(10);
		slider.setPaintTicks(true);
		
		slider.addChangeListener(
				new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						myPanel.setD(slider.getValue());  // Get value from slider and paint on screen
					}
				}
		);
		
		add(slider, BorderLayout.SOUTH);
		add(myPanel, BorderLayout.CENTER);

		
	}

}

*/