package williamqliu.com.happilyeverafter;


public class Hero{


	//public int stats[] = { 100, 100, 100, 100 }; 
	public static int stat1, stat2, stat3, stat4;
	public static String heroName = "Unnamed Robot";
	
	// Create a constructor to initialize variables
	public static void initializeStats() 
	{
		Hero.heroName = "Unnamed Robot";
		Hero.stat1 = 100;  // Stat1
		Hero.stat2 = 100;  // Stat2
		Hero.stat3 = 100;  // Stat3
		Hero.stat4 = 100;  // Stat4

		statsChange(0,0,0,0);  // Set Text to display
	}
	
	// Pass int 
	public static void statsChange(int temp_stat1, int temp_stat2, int temp_stat3, int temp_stat4) {
		Hero.stat1 += temp_stat1;
		Hero.stat2 += temp_stat2;
		Hero.stat3 += temp_stat3;
		Hero.stat4 += temp_stat4;
		
		//MainActivity.tv_stat1.setText(("Hero (Lawful)  ").toString());
		//MainActivity.tv_stat2.setText(("Strength " + Hero.stat2 + "  ").toString());
		//MainActivity.tv_stat3.setText(("Dexterity " + Hero.stat3  + "  ").toString());
		//MainActivity.tv_stat3.setText(("Alignment " + Hero.stat3  + "  ").toString());
		
		//MainActivity.tv_stat4.setText((" " + MainActivity.storyline).toString());
		MainActivity.tv_storyboard.setText(("- Chapter " + MainActivity.storyline).toString());
	}
	
	// Pass int of what_stat, compare it to the int of compared_value	
	public static boolean statsCheck(int what_stat, int compared_value) {
		if(what_stat == 1 && stat1 > compared_value)
			return true;
		else if(what_stat == 2 && stat2 > compared_value)
			return true;
		else if(what_stat == 3 && stat3 > compared_value)
			return true;
		else if(what_stat == 4 && stat4 > compared_value)
			return true;
		else return false;
	}
}
