import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/*
// Lesson 62 and 63 - JButton
public class Gui extends JFrame{
	
	private JButton reg;
	private JButton custom;
	
	public Gui(){ // Want a constructor so we don't have to call a method in order for Gui to pop up
		super("The title"); // Super allows access to your superclass; we're extending JFrame
		setLayout(new FlowLayout());
		
		reg = new JButton("Reg Button");  // Make buttons like 40 by 40 pixels and use png
		add(reg);
		
		Icon b = new ImageIcon(getClass().getResource("icon1.png"));
		Icon x = new ImageIcon(getClass().getResource("icon2.png"));

		custom = new JButton("Custom", b);
		custom.setRolloverIcon(x);  // Create a rollover image
		add(custom);
		
		HandlerClass handler = new HandlerClass();
		reg.addActionListener(handler);
		custom.addActionListener(handler);
	}
	
	// When a class implements another class, it means that "ActionListener", I'll let you implement my methods
	// but we promise to override your classes
	private class HandlerClass implements ActionListener{
		public void actionPerformed(ActionEvent event){
			JOptionPane.showMessageDialog(null, String.format("%s", event.getActionCommand()));
		}
	}
	
}


// Lesson 64 - JCheckBox
public class Gui extends JFrame{
	private JTextField tf;
	private JCheckBox boldbox;
	private JCheckBox italicbox;
	
	public Gui(){
		super("the title");
		setLayout(new FlowLayout());
		
		tf = new JTextField("This is a sentence", 20);
		tf.setFont(new Font("Serif", Font.PLAIN, 14));
		add(tf);
		
		boldbox = new JCheckBox("bold");
		italicbox = new JCheckBox("italic");
		add(boldbox);
		add(italicbox);
		
		HandlerClass handler = new HandlerClass();
		boldbox.addItemListener(handler);
		italicbox.addItemListener(handler);
	}
	
	// If class is within another class, that class can see all the variables inside
	// If the class is outside the class, cannot see the variables
	private class HandlerClass implements ItemListener(){
		public void itemStateChanged(ItemEvent event){
			Font font = null;
			
			if(boldbox.isSelected() && italicbox.isSelected())
				font = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
			else if(boldbox.isSelected())
				font = new Font("Serif", Font.BOLD, 14);
			else if(italicbox.isSelected())
				font = new Font("Serif", Font.ITALIC, 14);
			else
				font = new Font("Serif", Font.PLAIN, 14);
			
			tf.setFont(font);
		}
	}
}



// Lesson 66 and 67 - JRadioButton

public class Gui extends JFrame{

	private JTextField tf;
	private Font pf;  // Plain Font
	private Font bf;  // Bold Font
	private Font itf; // Italic Font
	private Font bif; // Bold Italic Font
	private JRadioButton pb;  // Plain font
	private JRadioButton bb;  // Bold font
	private JRadioButton ib;  // Italic font
	private JRadioButton bib; // Bold Italic font
	private ButtonGroup group;  // Part of a family so we know which ones are selected/de-selected

	public Gui(){
		super("the title");
		setLayout(new FlowLayout());
		
		tf = new JTextField("My Text goes here", 25);
		add(tf);
		
		pb = new JRadioButton("plain", true);  // True is checked, False is unchecked
		bb = new JRadioButton("bold", true);  // True is checked, False is unchecked
		ib = new JRadioButton("italic", true);  // True is checked, False is unchecked
		bib = new JRadioButton("bold and italic", true);  // True is checked, False is unchecked
		add(pb);
		add(bb);
		add(ib);
		add(bib);
		
		group = new ButtonGroup();
		group.add(pb);
		group.add(bb);
		group.add(ib);
		group.add(bib);
		
		pf = new Font("Serif", Font.PLAIN, 14);
		bf = new Font("Serif", Font.BOLD, 14);
		itf = new Font("Serif", Font.ITALIC, 14);
		bif = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
		tf.setFont(pf);
		
		// Wait for event to happen, pass in font object to constructor
		pb.addItemListener(new HandlerClass(pf));
		bb.addItemListener(new HandlerClass(bf));
		ib.addItemListener(new HandlerClass(itf));
		bib.addItemListener(new HandlerClass(bif));
		
		
	}
	
	private class HandlerClass implements ItemListener{
		private Font font;
		
		// the font object get variable font
		public HandlerClass(Font f){
			font = f;
		}
		
		// sets the font to the font object that was passed in
		public void itemStateChanged(ItemEvent event){
			tf.setFont(font);
		}
		
	}
	
	
}


// Lesson 68 - JComboBox (Drop Down List)
public class Gui extends JFrame{

	private JComboBox box;
	private JLabel picture;
	
	private static String[] filename = {"icon1.png", "icon2.png"};  // Array of File Names
	private Icon[] pics = {new ImageIcon(getClass().getResource(filename[0])), new ImageIcon(getClass().getResource(filename[1]))};  // Array of Pictures

	public Gui(){
		super("The title");
		setLayout(new FlowLayout());
		
		box = new JComboBox(filename);  // Takes File names as the options that are visible to users
		
		box.addItemListener(
				new ItemListener(){
					public void itemStateChanged(ItemEvent event){
						if(event.getStateChange()==ItemEvent.SELECTED)
							picture.setIcon(pics[box.getSelectedIndex()]);
					}
				}
		);
		
		add(box);
		picture = new JLabel(pics[0]);  // Default value
		add(picture);
	}
	
}


// Lesson 70 and 71 - Lists
public class Gui extends JFrame{
	private JList list;  // Made a list
	private static String[] colornames = {"black", "blue", "red", "white"};  // What we see as colors (the text in the list)
	private static Color[] colors = {Color.BLACK, Color.BLUE, Color.RED, Color.WHITE};  // What compiler sees as colors
	
	public Gui(){
		super("title");
		setLayout(new FlowLayout());
		
		list = new JList(colornames);  // Set a list of what users can see
		list.setVisibleRowCount(4);  // What can users see, how many items
		//list.setVisibleRowCount(colornames.length);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Can only select a single item
		add(new JScrollPane(list));  // Made a JScrollPane (which gives a scroll pane if necessary
		
		list.addListSelectionListener(
				new ListSelectionListener(){
					public void valueChanged(ListSelectionEvent event){
						getContentPane().setBackground(colors[list.getSelectedIndex()]);  // What item did we select, then set to corresponding list of colors in the list and sets to background
					}
				}
		);  // Going to make an anonymous listener class
		
	}
}


//Lesson 72 and 73 - Multiple Selection
public class Gui extends JFrame{
	private JList leftlist;
	private JList rightlist;
	private JButton movebutton;
	private static String[] foods = {"bacon", "wings", "ham", "beef"};
	
	public Gui(){
		super("title");
		setLayout(new FlowLayout());
		
		leftlist = new JList(foods);  // JList takes in parameter of an array
		leftlist.setVisibleRowCount(3);
		leftlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);  // Can select multiple items
		add(new JScrollPane(leftlist));
		
		movebutton = new JButton("Move -->");
		movebutton.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						rightlist.setListData(leftlist.getSelectedValues());
					}
				}
		);
		add(movebutton);
		
		rightlist = new JList();
		rightlist.setVisibleRowCount(3);
		rightlist.setFixedCellWidth(100);
		rightlist.setFixedCellHeight(15);
		rightlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // Allows selection of multiple items on the rightlist
		add(new JScrollPane(rightlist));
		
	}
}


// Lesson 74, 75, 76 - Mouse Events
public class Gui extends JFrame{
	private JPanel mousepanel;
	private JLabel statusbar;
	
	public Gui(){  // Setting up constructor
		super("title");
		
		mousepanel = new JPanel();  // Create new Panel
		mousepanel.setBackground(Color.WHITE);  // Set background to white
		add(mousepanel, BorderLayout.CENTER);  // Appears in center of screen and fills screen
		
		statusbar = new JLabel("Default");  // Status bar that says default by default
		add(statusbar, BorderLayout.SOUTH);  // Appear at bottom of screen

		// Need a new handling class
		HandlerClass handler = new HandlerClass();
		mousepanel.addMouseListener(handler);
		mousepanel.addMouseMotionListener(handler);
	}

	// When 'implements', it means that we have to use every method in those methods
	private class HandlerClass implements MouseListener, MouseMotionListener{


		// When mouse is clicked
		@Override
		public void mouseClicked(MouseEvent event) {
			statusbar.setText(String.format("Clicked at %d,%d", event.getX(), event.getY()));
			
		}

		// When mouse enters an area
		@Override
		public void mouseEntered(MouseEvent event) {
			statusbar.setText("The mouse entered the area");
			mousepanel.setBackground(Color.RED);
		}

		// When mouse leaves an area
		@Override
		public void mouseExited(MouseEvent event) {
			statusbar.setText("The mouse has left the area");
			mousepanel.setBackground(Color.WHITE);
		}
		
		// When a mouse is pressed
		@Override
		public void mousePressed(MouseEvent event) {
			statusbar.setText("You pressed down the mouse");
		}

		// When a mouse is released
		@Override
		public void mouseReleased(MouseEvent event) {
			statusbar.setText("You released the button");
		}		
		
		//
		
		// Hold down the mouse button while moving
		@Override
		public void mouseDragged(MouseEvent event) {
			statusbar.setText("You are dragging the mouse");
		}
		
		// Move the mouse while not holding down any buttons
		@Override
		public void mouseMoved(MouseEvent event) {
			statusbar.setText("You are moving the mouse");
			
		}
		
	}
}


// Lesson 77 - Adapter Classes (to save time); Already implements an interface and overrides it with a method body that is a blank body that does nothing
// When inheriting from an adapter class, you only have to override the methods that you need; don't have to override all of them (just the ones you need) 
// The ones that aren't overridden are blank
public class Gui extends JFrame{
	private String details;
	private JLabel statusbar;
	
	public Gui(){
		super("turtle");
		
		statusbar = new JLabel("This is default");
		add(statusbar, BorderLayout.SOUTH);
		addMouseListener(new Mouseclass());
		
	}
	
	// Adapter classes allow you to overwrite only the methods you want
	private class Mouseclass extends MouseAdapter{
		public void mouseClicked(MouseEvent event){
			details = String.format("You clicked %d ", event.getClickCount());
		
			if(event.isMetaDown()) // In order to distinguish type of mouse (there's a lot of different kinds, one, two, three, etc.)
				details += "with right mouse button";
			else if(event.isAltDown())
				details += "with center mouse button";
			else
				details += "with left mouse button";
			
			statusbar.setText(details);
		}
	}
}
*/

