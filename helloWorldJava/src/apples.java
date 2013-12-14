import java.io.File;
import java.util.EnumSet;
import java.util.Formatter;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class apples {
	public static void main(String args[]){
		
		/*
		
		System.out.print("Hello.  ");  // Print without the line spacing
		System.out.println("What is your Hero's name?"); // Can print line to a database or network, etc.  Right now just printing to a system
		
		Scanner heroName = new Scanner(System.in);  // Get input from user, hold in myScanner variable
		System.out.println(heroName.nextLine()); // .nextLine waits for user input before proceeding
		
		int con, hp, level;
		con = 5;
		level = 1;
		hp = con * 10;
		// double = 3.15... 
		// % is the modulus, the remainder
		
		System.out.println(hp);
		
		
		// Takes a variable and compares it to certain requirements (fancy if-else)
		switch(level){
		case 1:
			System.out.println("You are a noob");
			break;
		case 2:
			System.out.println("You are still a noob");
			break;
		case 3:
			System.out.println("Not a noob");
			break;
		default:
			System.out.println("I don't know your level");
			break;
		}
		
		// While Loop
		int counter = 10;
		while (counter < 10){
			System.out.println(counter);
			counter++;
		}
		
		// Classes
		//tuna tunaObject = new tuna();
		//tunaObject.simpleMessage();
		
		// Detailed Classes
		//Scanner input = new Scanner(System.in);
		//tuna tunaObject2 = new tuna();
		//System.out.println("Enter your name here:");
		//String name = input.nextLine(); // Used for inputting Strings
		//tunaObject2.simpleMessage(name);
		
		
		// Classes
		//tuna tunaObject = new tuna();
		//tunaObject.simpleMessage();
		//Scanner input = new Scanner(System.in);
		
		// First Girlfriend
		//System.out.println("Enter name of first girlfriend here: ");
		//String temp = input.nextLine();
		//tunaObject.setName(temp);
		//tunaObject.saying();
		
		// Conditional Operators
		int age = 21;
		System.out.println(age > 50 ? "You are old" : "You are young");

		int grade;
		Scanner input = new Scanner(System.in);
		grade = input.nextInt();	// Gets the next input of Int
	
		// Math functions called using Math.  (e.g. Math.pow(x, y))
		
		// Random Number Generator
		Random dice = new Random();
		int number = dice.nextInt(6);  // Goes from 0 through 5
		System.out.println(number);
		
		// Arrays
		int myArrayFirst[] = new int[10];
		myArrayFirst[0] = 1;
		myArrayFirst[1] = 2;
		myArrayFirst[9] = 12102;
		System.out.println(myArrayFirst[9]);
		
		int myArraySecond[] = {1, 2, 3, 4, 5};
		System.out.println(myArraySecond[2]);  // Displays 3

		// More Arrays - See Index and Values
		System.out.println("Index\tValues");
		int myArrayThird[]={10, 20, 30, 40, 50};
		for(int myCounter=0; myCounter<myArrayThird.length; myCounter++){
			System.out.println(myCounter + "\t" + myArrayThird[counter]);
		}
		
		
		// Capturing Frequency of Elements of an Array (6 sided die)
		int freq[] = new int[7];
		Random rand = new Random();  // Import random number generator
		for(int roll=1; roll<1000; roll++){
			++freq[1+rand.nextInt(6)];  // Rolled 1 + (0 through 5)
		}
		System.out.println("Face\tFrequency");
		for(int face=1; face<freq.length; face++){	// Output dice and frequency
			System.out.println(face+"\t"+freq[face]);
		}
		
		// Enhanced For Loop
		int myArrayFifth[]={3,4,5,6,7};
		int total=0;
		for(int x: myArrayFifth){
			total+=x;  // Adds up all of the numbers in the array
		}
		System.out.println(total);
		
		// 32 - Using Arrays in Methods
		int myArraySixth[]={3,4,5,6,7};
		change(myArraySixth);  // Calling Method to change Array
		for(int y:myArraySixth){	// Print out Array
			System.out.println(y);
		}
		
		// 33/34 - Multidimensional Arrays
		int myArraySeventh[][]={{8,9,10,11},{12,13,14,15}};  // Array with two rows, 4 columns each
		// How to call single elements => myArraySeventh[0][1]
		int myArrayEight[][]={{30,31,32,33},{43},{4,5,6}};  // Array with three rows, different column lengths
		System.out.println("This is the first array");
		display(myArraySeventh);
		
		System.out.println("This is the second array");
		display(myArrayEight);
		
		
		// 35 - Variable Length Arguments
		System.out.println("Average is: " + average(10,20,10));
		

		
		// Lesson 36
		tuna tunaObject = new tuna();
		System.out.println(tunaObject.toMilitary());
		tunaObject.setTime(13, 39, 59);
		System.out.println(tunaObject.toMilitary());
		System.out.println(tunaObject.toStandardTime());
		
		// Lesson 38 - Public, Private, and this
		//tuna tunaObject = new tuna();
		//tunaObject.test = 10;  // Can access variables from another class by making public
		
		// Lesson 43
		potpie potpieObject = new potpie(4,5,6);
		tuna tunaObject = new tuna("William", potpieObject);
		
		System.out.println(tunaObject);
		
		// Lesson 44 - Build an enhanced for loop to loop through the enumeration's automatic built in array (through .values())
		for(tuna people: tuna.values())	// .values() is a static method that 
		{
			System.out.printf("%s\t%s\t%s\n", people, people.getDesc(), people.getYear());
		}
		
		System.out.println("\n And now for the range of constants\n");
		for(tuna people: EnumSet.range(tuna.sara, tuna.monica))  // EnumSet.range lets you loop through a subset of the Enum
			System.out.printf("%s\t%s\t%s\n", people, people.getDesc(), people.getYear());
		
		
		// Lesson 46 - Static (static variables are available even when you don't have an object - won't change from object to object)
		tuna member1 = new tuna("Megan", "Fox");
		tuna member2 = new tuna("Natalie", "Portman");
		tuna member3 = new tuna("Zoey", "Deschanel");
		
		System.out.println(tuna.getMembers());  // Don't need to have a separate or a specific object, can call directly since it won't change from object to object
		System.out.println();
		System.out.println(member2.getFirst());
		System.out.println(member2.getLast());
		System.out.println(member2.getMembers());  // Members is a static, which means its shared between all objects
		
		
		// Lesson 48 - final (can't chnage later)
		tuna tunaObject = new tuna(10);  // sets a final object setting int of 10
		for(int i=0; i<5; i++){
			tunaObject.add();
			System.out.printf("%s", tunaObject);
		}
		
		
		// Lesson 49 - Inheritance
		tuna tunaObject = new tuna();
		potpie potpieObject = new potpie();
		tunaObject.eat();
		potpieObject.eat();
		
		
		// Lesson 50 - Graphical User Interface GUI; Very Basic
		// Uses import javax.swing.JOptionPane
		String fn = JOptionPane.showInputDialog("Enter first number"); // showInputDialog only shows Strings
		String sn = JOptionPane.showInputDialog("Enter second number");

		// Need to convert the showInputDialog input (from String to Int)
		int num1 = Integer.parseInt(fn);
		int num2 = Integer.parseInt(fn);
		int sum = num1 + num2;
		
		JOptionPane.showMessageDialog(null, "The answer is: " +sum, "My Title Bar", JOptionPane.PLAIN_MESSAGE);  // Where on screen, component, title bar, message prompt
		
		// Lesson 51 - More GUI - JFrame
		tuna tunaObject = new tuna();
		tunaObject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // When you hit X, it'll close correctly
		tunaObject.setSize(350, 100);  // Set Size
		tunaObject.setVisible(true);  // Can see
		
		
		// Lesson 55 - Polymorphism
		// Anything that inherits from the 
		food bucky[] = new food[2];  // Food type can hold objects of tuna and potpie since tuna and potpie extends food
		bucky[0] = new potpie();
		bucky[1] = new tuna();
		
		// Can use Polymorphic Arrays
		for(int x=0; x<2; ++x)
			bucky[x].eat();  // Loops through each of the objects (first potpie, then tuna) and calls the eat object
		
	
		// Lesson 56 - Polymorphic Arguments
		// Can pass in classes and subclasses into 
		fatty bucky = new fatty();
		food fo = new food();  // Need to create a food object because fatty object takes in a food object
		food po = new potpie();

		bucky.digest(fo);  
		bucky.digest(po);  // Can pass in subclass arguments as well
		
		
		// Lesson 57 - Overriding Rules
		// For polymorphism and overriding a method, must have the same arguments and return types as the superclass
		// Overload is different than override; overload is the same method name, but different arguments
		
		
		// Lesson 63 - JButton
		Gui go = new Gui();
		go.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // So program can exit on close
		go.setSize(400, 300);
		go.setVisible(true);
		
		
		// Lesson 78 - File Class
		// Uses 'import java.io.File;'
		File x = new File("C:/test/greg.txt");  // Be careful, \ is an escape sequence character, like in \t
		
		if(x.exists())
			System.out.println(x.getName() + "exist!");
		else
			System.out.println("This does not exist!");

		
		// Lesson 79 - Creating Files
		// Uses import java.util.*;
		final Formatter x;  // Formatter variable outputs strings to a file (printf, but to a file)
		
		try{
			x = new Formatter("fred.txt");  // If no file, will automatically create for you
			System.out.println("You created a file");
		}
		catch(Exception e){
			System.out.println("You got an error");
		}
		
		// Lesson 80 - Writing to Files
		createfile g= new createfile();
		g.openFile();
		g.addRecords();
		g.closeFile();
		
		
		// Lesson 81 - Reading from Files
		readfile r = new readfile();
		r.openFile();
		r.readFile();
		r.closeFile();
		
		
		// Lesson 83 - FlowLayout
		Layout l = new Layout();
		l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		l.setSize(300, 100);
		l.setVisible(true);
		
		
		// Lesson 84 - Drawing Graphics
		JFrame f = new JFrame("Title");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Peach p = new Peach();
		f.add(p);
		f.setSize(400, 250);
		f.setVisible(true);
		
		
		// Lesson 87 - Series Finale
		String a = "apples";
		String b = "bucky";
		String c = "BUCKY";
		System.out.println(a.length());
		
		if(a.equals("apples")){  // Can't use == signs because it might not be the same object
			System.out.println("It equals apples");
		}
		
		if(b.equalsIgnoreCase(c)){
			System.out.println("Bucky Matches");
		}
		*/
				
	} // End of main
	
	// 32 - Method for "Using Arrays in Methods"
	//public static void change(int x[]){  // Building a method that takes a parameter of one variable (an array)
	//	for(int counter=0;counter<x.length;counter++){
	//		x[counter]+=5; // Adding 5 to each element in the array
	//	}
	//}
	
	
	// 33/34 - Table for Multidimensional Arrays
	//public static void display(int x[][]){
	//	for(int row=0;row<x.length;row++){  // First takes row number - goes through rows
	//		for(int column=0;column<x[row].length;column++){  // Then takes column element in rows
	//			System.out.print(x[row][column]+"\t");
	//		}
	//		System.out.println();
	//	}
	//}
	
	// 35 - Variable Length Arguments
	//public static double average(int...numbers){  // Add ... if unknown number of arguments
	//	double total=0;
	//	for(int x:numbers)
	//		total+=x;
	//	return total/numbers.length;
	//}
	
	
	
	
}
