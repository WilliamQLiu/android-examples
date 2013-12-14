import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

// Public means anything else can use this class
// Private means other classes can't modify methods, only these methods in same class can use these variables
// Do not use same names in local variables as methods
// Will use local variables first, but if you want to use method variables, use this.hour or this.minute, etc.

/*
public class tuna {
	
	
	// No main class, does not run unless called upon
	public void simpleMessage(){
		System.out.println("My Tuna Message");
	}
	
	// Takes arguments (extra data that the system needs)
	public void simpleMessage(String name){
		System.out.println("Hello " + name);
	}
	
	
	
	// First Girlfriend
	private String girlName;
	public void setName(String name){
		girlName = name;
	}
	
	public String getName(){
		return girlName;
	}
	
	public void saying(){
		System.out.printf("Your first girlfriend was %s", getName());
	}
	// End First Girlfriend
	
	// Constructors - Allows you to initialize variables as soon as you create an object
	// method name is the exact same as the class name
	//public tuna(String name){
	//	girlName = name;
	//}
	
	// Lesson 36 - Time Class
	private int hour;
	private int minute;
	private int second;
	public int test;

	public void setTime(int h, int m, int s){
		hour = (h>=0 && h<24 ? h : 0);  // Is this a valid time, if not, then 0
		minute = (m>=0 && h<60 ? m : 0);
		second = (s>=0 && s<60 ? s : 0);
		
	}
	
	public String toMilitary(){
		return String.format("%02d:%02d:%02d", hour, minute, second); // Display Strings at two decimal places
	}
	
	public String toStandardTime(){
		return String.format("%02d:%02d:%02d %s", ((hour==0||hour==12)?12:hour%12), minute, second, (hour<12)? "am":"pm");
	}
	
	// Lesson 39 - Multiple Constructors with different number of arguments (Overloading constructors)
	private int hour;
	private int minute;
	private int second;
	
	public tuna(){
		this(0,0,0); // Invoke constructor again with three arguments of 0
	}
	public tuna(int h){  // Just one argument
		this(h,0,0);
	}
	public tuna(int h, int m){
		this(h,m,0);
	}
	public tuna(int h, int m, int s){
		setTime(h,m,s);
	}
	
	public void setTime(int h, int m, int s){
		setHour(h);
		setMinute(m);
		setSecond(s);
	}
	
	public void setHour(int h){
		hour = ((h>=0 && h<24) ? h:0);  // If checks out as a valid hour, set h, otherwise 0
		
	}
	public void setMinute(int m){
		hour = ((m>=0 && m<60) ? m:0);  // If checks out as a valid minute, set m, otherwise 0
		
	}
	public void setSecond(int s){
		hour = ((s>=0 && s<60) ? s:0);  // If checks out as a valid second, set s, otherwise 0
		
	}
	
	// hour, minute, and second were private values (now we want them public so we use get methods)
	public int getHour(){
		return hour;
	}
	public int getMinute(){
		return minute;
	}
	public int getSecond(){
		return second;
	}
	public String toMilitary(){
		return String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());
	}
	
	
	// Lesson 43 - Composition
	private String name;
	private potpie birthday;  // Reference to a potpie object
	
	public tuna(String theName, potpie theDate){
		name = theName;
		birthday = theDate;
	}
	
	public String toString(){  // Can pass in a regular string or pass in an object
		return String.format("My name is %s, my birthday is %s", name, birthday);
	}

}

// Lesson 44 - Enumerations are constants that are also objects
public enum tuna{
	william("me", "26"),
	adrienne("nice", "22"),
	sara("hot", "29"),
	christina("cute", "23"),
	monica("athletic", "23");
	
	private final String desc;
	private final String year;
	
	// Type name of class and two variables
	tuna(String description, String birthday){
		desc = description;
		year = birthday;
	}
	
	public String getDesc(){
		return desc;
	}
	
	public String getYear(){
		return year;
	}
}

// Lesson 46 - Static
public class tuna{
	private String first;
	private String last;
	private static int members = 0;  // Means that all members can see the static variable
	
	public tuna(String fn, String ln){
		first = fn;
		last = ln;
		members++;
		System.out.printf("Constructor for %s %s, members in the club: %d \n", first, last, members);
	}
	
	public String getFirst(){
		return first;
	}
	public String getLast(){
		return last;
	}
	public static int getMembers(){
		return members;
	}
	
}

// Lesson 48
public class tuna{
	private int sum;
	private final int NUMBER;  // final does not allow you to change the variable throughout the program, can only be declared once
	
	public tuna(int x){
		NUMBER = x;
	}
	
	public void add(){
		sum+=NUMBER;
	}
	
	public String toString(){  // Remember this function has to be called toString()
		return String.format("sum = %d\n", sum);
	}
	
}


// Lesson 49 - Inheritance - Only public methods can be inherited
// You can extend off a class that extends off another class
// For example, if tuna extends potpie, potpie extends food, then tuna has public methods from food
public class tuna extends food{
	
	public void eat(){  // You can override the function by creating it again
		System.out.println("New food method from Tuna!");
	}
}



// Lesson 51 - GUI with JFrame
// Uses import java.awt.FlowLayout (Keep putting stuff to the right until no more space, then next line)
// Uses import javax.swing.JFame (Gives the basic windows features, i.e. Close, Minimize, Maximize)
// Uses import javax.swing.JLabel (Output text and images onto the screen)
public class tuna extends JFrame{
	private JLabel item1;
	
	public tuna(){
		super("The title bar");  // Setup title bar
		setLayout(new FlowLayout());  // setLayout and FlowLayout from imported functions; setup default layout

		item1 = new JLabel("This is a sentence");
		item1.setToolTipText("This is going to show up on hover");
		add(item1);
	}
	
}


// Lesson 52, 53 - Event Handling and ActionListener
// Uses import java.awt.FlowLayout;
// Uses import java.awt.event.ActionListener;
// Uses import java.awt.event.ActionEvent;
// Uses import java.swing.Jframe;
// Uses import java.swing.JTextField;
// Uses import java.swing.JPasswordField;
// Uses import java.swing.JOptionPane;
public class tuna extends JFrame{
	
	private JTextField item1;
	private JTextField item2;
	private JTextField item3;
	private JPasswordField passwordField;
	
	public tuna(){
		super("This is my title");
		setLayout(new FlowLayout());
		
		item1 = new JTextField(10);
		add(item1);
		
		item2 = new JTextField("Enter text here: ");
		add(item2);
		
		item3 = new JTextField("Uneditable", 20);
		item3.setEditable(false);
		add(item3);
		
		passwordField = new JPasswordField("Password");
		add(passwordField);
		
		thehandler handler = new thehandler();  // We'll build an action listener class
		item1.addActionListener(handler);
		item2.addActionListener(handler);
		item3.addActionListener(handler);
		passwordField.addActionListener(handler);
		
				
	}
	
	// When you build a class within a class, the class inside inherits all of the stuff from the outside class
	// The class that handles the events
	private class thehandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			String string = "";
			
			if(event.getSource()==item1)  // If they clicked Enter on Text Field 1
				string = String.format("Field 1: %s", event.getActionCommand()); // event.getActionCommand() gets the text from that location
			else if (event.getSource()==item2)
				string = String.format("Field 2: %s", event.getActionCommand()); // event.getActionCommand() gets the text from that location
			else if (event.getSource()==item3)
				string = String.format("Field 3: %s", event.getActionCommand()); // event.getActionCommand() gets the text from that location
			else if (event.getSource()==passwordField)
				string = String.format("Password field is: %s", event.getActionCommand());
			
			JOptionPane.showMessageDialog(null, string);
		}
		

		
	}

}


public class tuna extends food{
	
	void eat(){
		System.out.println("this tuna is great");
	}
}

*/
