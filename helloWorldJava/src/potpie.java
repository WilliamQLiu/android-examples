

/* 	// Lesson 42, 43
public class potpie {
	
	private int month;
	private int day;
	private int year;
	
	public potpie(int m, int d, int y){  // Creating public constructor, method has same name as class and no return type
		month = m;
		day = d;
		year = y;
		
		System.out.printf("The constructor for this is %s\n", this);  // keyword 'this' is the reference to whatever object we just built/current object, which is a string
	}
	
	public String toString(){	// Must be named toString; anytime you want to change an object to a String
		return String.format("%d/%d/%d", month, day, year);  // Common date format
	}
	
	
	
}

// Lesson 49 -Inheritance
public class potpie extends food{
	
}

// Lesson 55 - Polymorphism
public class potpie extends food{
	void eat()
	{
		System.out.println("This potpie is great");
	}
}
*/