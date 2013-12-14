import java.io.*;
import java.lang.*;
import java.util.*;

// Lesson 80 - Create File
public class createfile {
	
	private Formatter x;
	
	public void openFile(){
		try{
			x = new Formatter("chinese.txt");
		}
		catch(Exception e){
			System.out.println("You have an error");
			
		}
	}

	// Add records in
	public void addRecords(){
		x.format("%s %s %s", "26", "Will", "Liu");
	}
	
	// For housekeeping, need to close files or will cause errors later down the road
	public void closeFile(){
		x.close();
	}

}
