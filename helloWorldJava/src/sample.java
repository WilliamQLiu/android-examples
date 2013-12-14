import java.util.*;

public class sample {
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int x=1;
		do{
			try{
				System.out.println("Enter first num");
				int n1 = input.nextInt();
				System.out.println("Enter second num");
				int n2 = input.nextInt();
				int sum = n1/n2;
				System.out.println("The fraction is: " + sum);
				}
			catch(Exception e){  // Broad exception class, catch anything
				System.out.println("Error!!  You can't do that!");
			}
		}while(x==1);
	}
}