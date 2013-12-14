import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

// Lesson 83 - FlowLayout
public class Layout extends JFrame{
	
	private JButton lb;  // Left button
	private JButton cb;
	private JButton rb;
	private FlowLayout layout;
	private Container container;
	
	public Layout(){
		super("the title");
		layout = new FlowLayout();
		container = getContentPane();  // Get bulk of the window
		setLayout(layout);  // set layout as the new FlowLayout
		
		// Left stuff in here
		lb = new JButton("left");  // Left button
		add(lb);
		lb.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						layout.setAlignment(FlowLayout.LEFT); // Takes entire layout and changes it to left alignment
						layout.layoutContainer(container);
					}
				}
		);
		
		// Center stuff in here
		cb = new JButton("center");  // Center button
		add(cb);
		cb.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						layout.setAlignment(FlowLayout.CENTER); // Takes entire layout and changes it to center alignment
						layout.layoutContainer(container);
					}
				}
		);
		
		// Right stuff in here
		rb = new JButton("right");  // Right button
		add(rb);
		rb.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						layout.setAlignment(FlowLayout.RIGHT); // Takes entire layout and changes it to right alignment
						layout.layoutContainer(container);
					}
				}
		);


	}
	
}
