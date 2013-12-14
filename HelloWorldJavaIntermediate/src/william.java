import java.awt.Dimension;
import java.awt.Graphics;
import java.util.*;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
public class william {
	
	public static void main(String args[]){


		// Lesson 1 - Common String Methods
		String[] words = {"funk", "chunk", "furry", "baconator"};
		
		// Starts with
		for(String w:words){
			if(w.startsWith("fu"))
				System.out.println(w + " starts with fu");
		}
		
		// Ends with
		for(String w:words){
			if(w.endsWith("unk"))
				System.out.println(w + " ends with unk");
		}
		// End Lesson 1
		
		// Lesson 2 - More String Methods
		String s = "William liu was here";
		System.out.println(s.indexOf('l')); // Find first index of and return it, returns 2 for 'l'
		System.out.println(s.indexOf('l', 4)); // Find first index of starting at 3
		System.out.println(s.indexOf('x'));  // If char isn't in there, returns -1
		
		String a = "Bacon ";
		String b = "Monster";
		
		System.out.println(a + b);  // Returns "Bacon Monster"
		System.out.println(a.concat(b));  // Can also concatenate using this method, returns "Bacon Monster"
	
		System.out.println(a.replace('B', 'F'));  // Bacon returns as Facon

		System.out.println(b.toUpperCase());	// Monster turns to MONSTER
		System.out.println(b.toLowerCase());	// Monster turns to monster
		System.out.println(b.trim());	// Removes spaces
		// End Lesson 2
		
		
	}
	
}
*/

/*
// Lesson 3 - Recursion
// Is a method that calls itself (e.g. Factorial; 5! = 5 * 4 * 3 * 2 * 1 = 120)
public class william {
	
	public static void main(String args[]){
		
	}
	
	// Return factorial of a number
	public static long fact(long n){
		
		if(n <= 1)	// Method calls itself until the base case (1! = 1)
			return 1;
		else
			return n * fact(n-1);  // Calling itself
	
	}
}
*/
/*
// Lesson 4 - Collections
// Similar to arrays, but instead of setting a set list, it dynamically changes size
public class william {
	
	public static void main(String args[]){
		
		String[] things={"eggs", "lasers", "hats", "bacon"};  // An array of things
		List<String> list1 = new ArrayList<String>();
		
		// Add array items to list
		for(String x: things)
			list1.add(x);
		
		String[] morethings = {"lasters", "hats"};
		List<String> list2 = new ArrayList<String>();
		
		// Add array items to list
		for(String y: morethings)
			list2.add(y);
		
		// Print out list1 - should print out all the items in list1
		for(int i=0; i<list1.size();i++){  // Get size of list, then loop through
			System.out.printf("%s ", list1.get(i));  // Get item at index i
		}
		
		// Edit list1 - should remove all items from list2 from list1
		editlist(list1, list2);
		System.out.println();
		
		// Print out list1
		for(int i=0; i<list1.size();i++){  // Get size of list, then loop through
			System.out.printf("%s ", list1.get(i));  // Get item at index i
		}
	}
	
	public static void editlist(Collection<String> l1, Collection<String> l2){
		Iterator<String> it = l1.iterator(); // Iterators go through things item by item
		
		// Goes through all items (using iterator), loops through item to item and if l2 is in l1, remove it
		while(it.hasNext()){
			if(l2.contains(it.next()))
				it.remove();
		}
	}
}
*/
/*  // Lesson 7 - Lists
public class william{
	public static void main(String[] args){
		
		String[] things = {"apples", "noobs", "bacon", "pwnage", "awesome", "norwahls"};  // Setup an array of things
		List<String> list1 = new LinkedList<String>();
		
		for(String x: things)
			list1.add(x);  // Populate list1 with everything in String array things
		
		String[] things2 = {"sausage", "bacon", "goats", "harrypotter"};
		List<String> list2 = new LinkedList<String>();
		for(String y: things2)
			list1.add(y);  // Populate list2 with everything in String array things2
		
		list1.addAll(list2);
		list2 = null;
		
		printMe(list1);
		removeStuff(list1, 2, 5);
		printMe(list1);
		reverseMe(list1);
	}
	
	// printMe method
	private static void printMe(List<String> l){
		for(String b : l)
			System.out.printf("%s ", b);
		System.out.println();
	}
	
	// removeStuff method
	private static void removeStuff(List<String> l, int from, int to){
		l.subList(from, to).clear();  // Remove from 'from' to 'to in the list
	}
	
	// reverseMe
	private static void reverseMe(List<String> l){
		ListIterator<String> bobby = l.listIterator(l.size());  // Sets new ListIterator at the end of current ListIterator
		while(bobby.hasPrevious())  // True until last element
			System.out.printf("%s ", bobby.previous());
	}
}
*/

/*
// Lesson 8 - Converting Lists to Arrays and vice-versa
public class william{
	public static void main(String[] args){
		
		String[] stuff = {"babies", "watermelon", "melons", "fudge"};
		LinkedList<String> thelist = new LinkedList<String>(Arrays.asList(stuff));  // asList is a built in method; changed array into a list
		// You want to change an array into a list so you can use list methods on it
		
		thelist.add("pumpkin");  // Normally adds to the end of list
		thelist.addFirst("firstthing");  // method to add to first of arrays
		
		// Can convert a list back to an array
		stuff = thelist.toArray(new String[thelist.size()]);  // Convert list back to an array
		
		for(String x : stuff)
			System.out.printf("%s ", x);
	}
}
*/
/*
// Lesson 9 - Collections methods (sort)
public class william{
	public static void main(String[] args){
		
		String[] crap = {"apples", "lemons", "geese", "bacon", "youtube"};
		List<String> l1 = Arrays.asList(crap);  // Convert string array to List
		
		Collections.sort(l1);  // Sorts it alphabetically
		System.out.printf("%s \n", l1);  // Can put an entire list as a string and will print it all out
		
		Collections.sort(l1, Collections.reverseOrder());
		System.out.printf("%s \n", l1);  // Can put an entire list as a string and will print it all out

	}
}
*/

/*
// Lesson 10 and 11 - Collections methods (reverse and copy)
public class william{
	public static void main(String[] args){
		
		// Create an array and convert to list
		Character[] ray = {'p', 'w', 'n'};
		
		List<Character> l = Arrays.asList(ray);  // Convert array into a list
		System.out.println("List is: ");
		output(l);
		
		// Reverse and Print out the list
		Collections.reverse(l);
		System.out.println("After reverse: ");
		output(l);
		
		// Create a new array and a new list
		Character[] newRay = new Character[3];
		List<Character> listCopy = Arrays.asList(newRay);
		
		// Copy contents of list into listCopy
		Collections.copy(listCopy, l);
		System.out.println("Copy of list: ");
		output(listCopy);
		
		// Fill collection with crap
		Collections.fill(l, 'X');  // Two parameters, what collection and with what
		System.out.println("After filling the list: ");
		output(l);
		
	}
	
	public static void output(List<Character> thelist)
	{
		for(Character thing:thelist)
			System.out.printf("%s ", thing);
		System.out.println("\n");
	}
}
*/

/*
// Lesson 13 - More Collections methods
public class william{
	public static void main(String args[]){
		
		// Create an array that holds string data
		String[] stuff = {"bacon", "cheese", "sausage", "beef"};
		List<String> list1 = Arrays.asList(stuff);
		
		ArrayList<String> list2 = new ArrayList<String>();  // New array list, but nothing in it
		list2.add("youtube");
		list2.add("google");
		list2.add("reddit");
		list2.add("digg");
		
		// Print out list
		for(String x:list2)
			System.out.printf("%s ", x);
		
		Collections.addAll(list2, stuff);  // Takes all of the elements from stuff and adds to list2
		System.out.println();
		
		// Print out list
		for(String x:list2)
			System.out.printf("%s ", x);
		System.out.println();
		
		System.out.println(Collections.frequency(list2, "digg"));  // Returns the int frequency of how often something appears
		
		// disjoint method compares two lists, returns true if there is no items in common, returns false if there is a common item
		boolean tof = Collections.disjoint(list1, list2);
		System.out.println(tof);
		
		if(tof)
			System.out.println("These lists do not have anything in common!");
		else
			System.out.println("These lists do have something in common!");			
		
		
	}
}
*/
/*
// Lesson 14 - Stacks, push, pop
public class william{
	public static void main(String[] args){
		
		Stack<String> stack = new Stack<String>();
		stack.push("bottom");  // Push adds to stack
		printStack(stack);
		stack.push("second");  // Push adds to stack
		printStack(stack);
		stack.push("third");  // Push adds to stack
		printStack(stack);
		
		stack.pop();
		printStack(stack);
		stack.pop();
		printStack(stack);
		stack.pop();
		printStack(stack);
	}
	
	public static void printStack(Stack<String> s){
		if(s.isEmpty())
			System.out.println("There is nothing in the stack ");
		else
			System.out.printf("%s TOP\n", s);
	}
}
*/

/*
// Lesson 15 - Queues
public class william{
	public static void main(String[] args){
		
		PriorityQueue<String> q = new PriorityQueue<String>();
		
		q.offer("first");  // Pass in item
		q.offer("second");  // Pass in item
		q.offer("third");  // Pass in item
		
		// Queues work in that first item has higher priority than others
		System.out.printf("%s ", q);
		System.out.println();
		
		System.out.printf("%s ", q.peek());  // Takes a look at the element with highest priority
		System.out.println();
		
		
		// Usually want to remove element with highest priority
		q.poll();  // Removes highest priority item
		System.out.printf("%s ", q);  // Takes a look at queue
		System.out.println();

		
	}
}
*/

/*
// Lesson 16 - Hashsets
// Sets - cannot contain duplicate items
// Hashsets - takes a list, removes duplicates, returns enhanced collection
public class william{
	public static void main(String[] args){
		
		String[] things = {"bacon", "apple", "ham", "beef", "pork", "bacon", "apple"};
		List<String> list = Arrays.asList(things);  // Change array to collections/list
		
		System.out.printf("%s ", list);
		System.out.println();
		
		Set<String> set = new HashSet<String>(list);
		System.out.printf("%s ", set);
		
	}
}
*/

/*
// Lesson 17 and 18 - Generic Methods
// 'Generic' is a way to prevent overloaded methods
// Instead of having 10 overloaded methods of different data types
// If there is a generic method and overloaded methods, will take overloaded first
public class william{
	public static void main(String[] args){
		
		Integer[] iray = {1,2,3,4};
		Character[] cray = {'w','i','l','l','i','a','m'};
		
		printMe(iray);
		printMe(cray);
	}
	
	// Overloaded Method for integers
	//public static void printMe(Integer[] i){
	//	for(Integer x:i)
	//		System.out.printf("%s ", x);
	//	System.out.println();
	//}
	
	// Overloaded Method for characters
	//public static void printMe(Character[] i){
	//	for(Character x:i)
	//		System.out.printf("%s ", x);
	//	System.out.println();
	//}
	
	// Generic Method
	public static <T> void printMe(T[] x){  // Takes a generic T array, treats it as x
		for(T w:x)
			System.out.printf("%s", w);
		System.out.println();
		
	}
}
*/
/*
// Lesson 19 - Generic Return Types
// Create a generic method that takes 3 generic items and returns the maximum
public class william{
	public static void main(String[] args){
		
		System.out.println(max(23, 42, 1));
		System.out.println(max("apples", "tots", "chicken"));  // returns tots as max because of ASC values for character 't' > 'c' > 'a'
		
	}
	
	public static <T extends Comparable<T>> T max(T a, T b, T c){  // Can only use objects that extend Comparable and returning type T (generic) data
		T m = a;  // m will be the maximum variable
		
		if(b.compareTo(a) > 0)  // Returns a negative, 0 (equal), or positive number
			m = b;
		if(c.compareTo(m) > 0)  // Returns a negative, 0 (equal), or positive number
			m = b;
		
		return m;
	}
}
*/
/*
// Lesson 20 - Introduction to Applets
// Most common use of Java, uses java through an Internet Browser
// Lesson 21 - How to put an Applet on a website; put class on web site
// create an html file (add tags in there as <applet> and </applet>
// E.g. <applet code = "william.class" width = "400" height = "100"> </applet>

public class william extends JApplet{  // JApplet has the methods we need
	public void paint(Graphics g){
		super.paint(g);
		g.drawString("Wow this actually worked", 25, 25);
	}
}
*/

/*
// Lesson 22 - init for Applets
// Applets don't need a main window because they operate in the browser
public class william extends JApplet{  // JApplet has the methods we need
	
	private double sum;
	
	public void init(){  // init - initializes
		String fn = JOptionPane.showInputDialog("Enter first number");
		String sn = JOptionPane.showInputDialog("Enter second number");
		
		// Convert strings to doubles
		double n1 = Double.parseDouble(fn);
		double n2 = Double.parseDouble(sn);
		
		sum = n1 + n2;
		
	}
	
	public void paint(Graphics g){
		super.paint(g);
		g.drawString("The sum is: " + sum, 25, 30);
	}
}
*/

/*
// Lesson 24 - Creating an Oval with slider
public class william extends JPanel{
	
	// Lesson 25 - Finishing the Oval Slider Program
		public static void main(String[] args){
		
		TheWindow w = new TheWindow();
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setSize(230, 280);
	}
	// End Lesson 25
	
	private int d = 10;
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.fillOval(10, 10, d, d);
	}
	
	public void setD(int newD){
		d = (newD >= 0 ? newD : 10 );  // Pass in a newD, if that is greater than 0, then use, or else don't use
		repaint();  // Calls paint component method
	}
	
	// From layout manager, returns preferred dimensions
	public Dimension getPreferredSize(){
		return new Dimension(200, 200);
	}
	
	// From layout manager, returns minimum size
	public Dimension getMinimumSize(){
		return getPreferredSize();
	}
	
}
*/


// Lesson 26 - Learning about Threads
public class william{
	
	// Lesson 27 - Implementing Threads
	public static void main(String[] args){
		Thread t1 = new Thread(new myThread("one"));
		Thread t2 = new Thread(new myThread("two"));
		Thread t3 = new Thread(new myThread("three"));
		Thread t4 = new Thread(new myThread("four"));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		// Results are all run at different (random) times
	}
		
}