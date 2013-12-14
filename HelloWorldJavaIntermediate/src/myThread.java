import java.util.Random;



// Lesson 26 - Learning about Threads
	//Runnable interface contains run() method
	public class myThread implements Runnable{
		String name;
		int time;
		Random r = new Random();
		
		public myThread(String x){
			name = x;
			time = r.nextInt(999);  // Time is between 0 and 1 second
		}
			
		// When you start the thread, the run method runs
		public void run(){
			try{
				System.out.printf("%s is sleeping for %d\n", name, time);
				Thread.sleep(time);
			}catch(Exception e){}
				
		}
	}

