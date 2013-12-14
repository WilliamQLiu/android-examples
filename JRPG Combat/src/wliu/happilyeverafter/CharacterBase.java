package wliu.happilyeverafter;

import android.R.string;

public class CharacterBase {
	
	private String profession;
	/*
	 * Profession affects base statistics and specials
	 */
		
	private int strength;
	/* Strength affects base damage, chance to block
	 * Strength affects ability to upgrade gear
	 */
	
	private int dexterity;
	/* Dexterity affects accuracy to hit, deal a critical hit, evade an attack
	 * Accuracy is capped at 99%
	 * Evasion is capped at 99%
	 */
	
	private int stamina;
	/* Stamina affects hit points
	 */
	
	private int speed;
	/*
	 * Speed affects how quickly it takes before it's your move
	 */

	private int currentHitPoints;
	/* Current Hit Points - Once you reach 0, you die.  Important Stuff
	 */
	
	private int maximumHitPoints;
	/* Maximum Hit Points 
	 */

	
	private int physicalDefense;
	/*
	 * Determines the mitigation of damage from Physical Attacks
	 */
	
	private int magicalDefense;
	/*
	 * Determines the mitigation of damage from Magical Attacks
	 */
	
	private int experiencePoints;
	/*
	 * Experience Points are gained to raise the character's level
	 */
	
	private int level;
	/*
	 * Determines the character's level
	 */
	
	
	// Create method 
	private void setLevel(int experiencePoints)
	{
		/*
		 * Level Up if Experience Points reach a certain point
		 * */
		if ((experiencePoints > 1) && (experiencePoints <100))
		{
			// Level 1
			level = 1;
		}
		else if((experiencePoints >= 100) && (experiencePoints <1000))
		{
			// Level 2
			level = 2;
		}
		else if((experiencePoints >= 5000) && (experiencePoints <25000))
		{
			// Level 3
			level = 3;
		}
		else if((experiencePoints >= 25000) && (experiencePoints <100000))
		{
			// Level 4
			level = 4;
		}
		else if(experiencePoints >=100000)
		{
			// level 5
			level = 5;
		}
		else
		{
			// Default Catch
		}
	}
	

	// Constructor used to create and initialize an object - Named the same as the class and may include parameters
	// Setting default stats for a base character
	CharacterBase(string profession, int level){
		profession = null;
		strength = 1;
		dexterity = 1;
		stamina = 1;
		speed = 1;
		maximumHitPoints = 1;
		currentHitPoints = maximumHitPoints;
		physicalDefense = 1;
		magicalDefense = 1;
		experiencePoints = 1;
		level = 1;
	}
	
	
	
	

}
