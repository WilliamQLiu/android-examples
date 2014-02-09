package williamqliu.com.happilyeverafter;



import android.graphics.drawable.AnimationDrawable;
import android.util.Log;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;

public class ChapterOne {
	
	
	public static void animation1Setup() {
		// TODO Auto-generated method stub
		//System.gc();
		
		Storyboard.setupStory(8, 8, 8); // Setup Story Text
		Storyboard.setupAnswerChoices(8, 8, 8, 8, 8, 0); // Setup Answer Choices
		Hero.statsChange(0, 0, 0, 0);
		
		/* Quick Load
		MainActivity.mainImage.setImageResource(R.drawable.scene2animation);
		MainActivity.frameAnimation = (AnimationDrawable) MainActivity.mainImage.getDrawable();
		MainActivity.frameAnimation.start();
		 */

		
		/*
		MainActivity.mainImage.setBackgroundResource(R.drawable.scene2animation);
		MainActivity.frameAnimation = (AnimationDrawable) MainActivity.mainImage.getBackground();
		
		if(MainActivity.frameAnimation.isRunning())
		{
			MainActivity.frameAnimation.stop();	// Reset animation
			MainActivity.frameAnimation.start();  // Setup animation again
		}
		else
		{
		MainActivity.frameAnimation.start();
		}
		*/
		
		
		
		
		/*
		AnimationSet set = new AnimationSet(true);
		TranslateAnimation anim = new TranslateAnimation(0f, .1f, 0f, .1f);
		set.addAnimation(anim);
		set.setDuration(500);
		set.setInterpolator(new AccelerateInterpolator(1.0f));
		MainActivity.mainImage.startAnimation(set);
		*/
		
		MainActivity.mainImage.setBackgroundResource(R.drawable.scene2animation);
		MainActivity.frameAnimation = (AnimationDrawable) MainActivity.mainImage.getBackground();
		MainActivity.frameAnimation.start();
		
	}
	
	
	
	
	
		
		// Setup story text, answer choices
		public static void story1Setup() {
			MainActivity.tv_story1.setText(R.string.Scene1story1);
			MainActivity.tv_story2.setText(R.string.Scene1story2);
			MainActivity.tv_story3.setText(R.string.Scene1story3);
			MainActivity.r_answer1.setText(R.string.Scene1choiceA);
			MainActivity.r_answer2.setText(R.string.Scene1choiceB);
			MainActivity.r_answer3.setText(R.string.Scene1choiceC);
			MainActivity.r_answer4.setText(R.string.Scene1choiceD);
			Storyboard.setupStory(0, 0, 8); // Setup Story Text
			Storyboard.setupAnswerChoices(0, 0, 0, 8, 8, 8); // Setup Answer Choices
			
		}
		
		/*
		public static void story1Progress() {
			//MainActivity.tv_story1.setText(R.string.Scene2story1);
			//MainActivity.tv_story2.setText(R.string.Scene2story2);
			//MainActivity.tv_story3.setText(R.string.Scene2story3);
			Storyboard.setupStory(0, 0, 0); // Setup Story Text
			Storyboard.setupAnswerChoices(8, 8, 8, 8, 8); // Setup Answer Choices
		}*/
		
		public static void story1Progress() {
			
			if (MainActivity.r_checked == MainActivity.r_answer1.getId())
			{
				Log.d("Debug", " story1Progress, r_answer1.isChecked called!");
				//if(MainActivity.changedStatFlag==false)
					//Hero.statsChange(0, 50, 0, 0);
				//story2ASetup();
				Hero.heroName = "Clockwork";
				story2Setup();
			}
			else if	(MainActivity.r_checked == MainActivity.r_answer2.getId())
			{
				Log.d("Debug", " story1Progress, r_answer2.isChecked called!");
				//if(MainActivity.changedStatFlag==false)
					//Hero.statsChange(0, 0, 50, 0);
				//story2BSetup();
				Hero.heroName = "Hal";
				story2Setup();
			}
			else if	(MainActivity.r_checked == MainActivity.r_answer3.getId())
			{
				Log.d("Debug", " story1Progress, r_answer3.isChecked called!");
				//if(MainActivity.changedStatFlag==false)
					//Hero.statsChange(0, 25, 25, 0);
				Hero.heroName = "Dex";
				story2Setup();
			}
			else
			{
				// Issue
				Log.d("Debug", " story1Progress, Issue is called!");
			}
			MainActivity.rg_answers.clearCheck();
			MainActivity.r_answer1.setChecked(true);
		}
		
		public static void story2Setup(){
			
			MainActivity.tv_story1.setText("Hello " + Hero.heroName + "!");
			MainActivity.tv_story2.setText(R.string.Scene2story2);
			MainActivity.tv_story3.setText(R.string.Scene2story3);
			Storyboard.setupStory(0, 0, 0); // Setup Story Text
			Storyboard.setupAnswerChoices(8, 8, 8, 8, 8, 8); // Setup Answer Choices
			Hero.statsChange(0, 0, 0, 0);
			//MainActivity.r_answer1.setText(R.string.Scene2AchoiceA);
			//MainActivity.r_answer2.setText(R.string.Scene2AchoiceB);
			//MainActivity.r_answer3.setText(R.string.Scene2AchoiceC);
			//MainActivity.r_answer4.setText(R.string.Scene2AchoiceD);
		}
		
		/*

		public static void story2ASetup() {
			
			MainActivity.tv_story1.setText(R.string.Scene2Astory1);
			MainActivity.tv_story2.setText(R.string.Scene2Astory2);
			MainActivity.tv_story3.setText(R.string.Scene2Astory3);
			Storyboard.setupStory(0, 0, 0); // Setup Story Text
			Storyboard.setupAnswerChoices(0, 0, 0, 8, 8); // Setup Answer Choices
			//MainActivity.r_answer1.setText(R.string.Scene2AchoiceA);
			//MainActivity.r_answer2.setText(R.string.Scene2AchoiceB);
			//MainActivity.r_answer3.setText(R.string.Scene2AchoiceC);
			//MainActivity.r_answer4.setText(R.string.Scene2AchoiceD);
		}
		
		public static void story2BSetup() {
			MainActivity.tv_story1.setText(R.string.Scene2Bstory1);
			MainActivity.tv_story2.setText(R.string.Scene2Bstory2);
			MainActivity.tv_story3.setText(R.string.Scene2Bstory3);
			Storyboard.setupStory(0, 0, 0); // Setup Story Text
			Storyboard.setupAnswerChoices(8, 8, 8, 8, 8); // Setup Answer Choices
			//MainActivity.r_answer1.setText(R.string.Scene2BchoiceA);
			//MainActivity.r_answer2.setText(R.string.Scene2BchoiceB);
			//MainActivity.r_answer3.setText(R.string.Scene2BchoiceC);
			//MainActivity.r_answer4.setText(R.string.Scene2BchoiceD);
		}
		
		public static void story2CSetup() {
			MainActivity.tv_story1.setText(R.string.Scene2Cstory1);
			MainActivity.tv_story2.setText(R.string.Scene2Cstory2);
			MainActivity.tv_story3.setText(R.string.Scene2Cstory3);
			//MainActivity.r_answer1.setText(R.string.Scene2CchoiceA);
			//MainActivity.r_answer2.setText(R.string.Scene2CchoiceB);
			//MainActivity.r_answer3.setText(R.string.Scene2CchoiceC);
			Storyboard.setupStory(0, 0, 0); // Setup Story Text
			Storyboard.setupAnswerChoices(8, 8, 8, 8, 8); // Setup Answer Choices

		}
		
		*/
		
		public static void story2Progress(){

			story3Setup();

		}
		
		
		/*
		public static void story2Progress() {
			if (MainActivity.r_checked == MainActivity.r_answer1.getId()) {
				story3Setup();
			} else if (MainActivity.r_checked == MainActivity.r_answer2.getId()) {
				story3Setup();
			} else if (MainActivity.r_checked == MainActivity.r_answer3.getId()) {
				story3Setup();
			} else if (MainActivity.r_checked == MainActivity.r_answer4.getId()) {
				story3Setup();
			} else if (MainActivity.r_checked == MainActivity.r_answer1.getId()) {
				story3Setup();
			}
			else{
				story3Setup();
			}
			MainActivity.rg_answers.clearCheck();
			MainActivity.r_answer1.setChecked(true);
		}*/

		public static void story3Setup() {
			MainActivity.tv_story1.setText(R.string.Scene3story1);
			MainActivity.tv_story2.setText(R.string.Scene3story2);
			MainActivity.tv_story3.setText(R.string.Scene3story3);
			MainActivity.r_answer1.setText(R.string.Scene3choiceA);
			MainActivity.r_answer2.setText(R.string.Scene3choiceB);
			MainActivity.r_answer3.setText(R.string.Scene3choiceC);
			//MainActivity.r_answer4.setText(R.string.Scene3choiceD);
			Storyboard.setupStory(0, 0, 0); // Setup Story Text
			Storyboard.setupAnswerChoices(0, 0, 0, 8, 8, 8); // Setup Answer Choices
			Hero.statsChange(0, 0, 0, 0);
		}

		
		public static void story3Progress() {
			Log.d("Debug", " storyCProgress is called!");
			if (MainActivity.r_checked == MainActivity.r_answer1.getId()) {
				story4ASetup();
			} else if (MainActivity.r_checked == MainActivity.r_answer2.getId()) {
				story4BSetup();
			} else if (MainActivity.r_checked == MainActivity.r_answer3.getId()) {
				story4CSetup();
			} 
			//else if (MainActivity.r_checked == MainActivity.r_answer4.getId()) {
			//	story4DSetup();
			//} else if (MainActivity.r_checked == MainActivity.r_answer5.getId()) {
			//	story4ESetup();
			//}
			else {
				//story4Setup();
			}
			MainActivity.rg_answers.clearCheck(); // Clear the checked radio button
			MainActivity.r_answer1.setChecked(true); // Set so that the first answer is default
		}

		public static void story4ASetup() {
			Log.d("Debug", " story4ASetup is called!");
			MainActivity.tv_story1.setText(R.string.Scene4Astory1);
			MainActivity.tv_story2.setText(R.string.Scene4Astory2);
			MainActivity.tv_story3.setText(R.string.Scene4Astory3);
			MainActivity.r_answer1.setText(R.string.Scene4AchoiceA);
			MainActivity.r_answer2.setText(R.string.Scene4AchoiceB);
			//MainActivity.r_answer3.setText(R.string.Scene4AchoiceC);
			//MainActivity.r_answer4.setText(R.string.Scene4AchoiceD);
			Storyboard.setupStory(0, 0, 0); // Setup Story Text
			Storyboard.setupAnswerChoices(0, 0, 8, 8, 8, 8); // Setup Answer Choices
			Hero.statsChange(0, 0, 0, 0);
	
		}
		

		
		public static void story4BSetup() {
			Log.d("Debug", " story4BSetup is called!");
			MainActivity.tv_story1.setText(R.string.Scene4Bstory1);
			MainActivity.tv_story2.setText(R.string.Scene4Bstory2);
			MainActivity.tv_story3.setText(R.string.Scene4Bstory3);
			MainActivity.r_answer1.setText(R.string.Scene4BchoiceA);
			MainActivity.r_answer2.setText(R.string.Scene4BchoiceB);
			MainActivity.r_answer2.setText(R.string.Scene4BchoiceC);
			//MainActivity.r_answer4.setText(R.string.Scene4AchoiceD);
			Storyboard.setupStory(0, 0, 0); // Setup Story Text
			Storyboard.setupAnswerChoices(0, 0, 0, 8, 8, 8); // Setup Answer Choices
			Hero.statsChange(0, 0, 0, 0);
		}
		
		public static void story4CSetup() {
			Log.d("Debug", " story4CSetup is called!");
			MainActivity.tv_story1.setText(R.string.Scene4Cstory1);
			MainActivity.tv_story2.setText(R.string.Scene4Cstory2);
			MainActivity.tv_story3.setText(R.string.Scene4Cstory3);
			MainActivity.r_answer1.setText(R.string.Scene4CchoiceA);
			MainActivity.r_answer2.setText(R.string.Scene4CchoiceB);
			//MainActivity.r_answer3.setText(R.string.Scene4AchoiceC);
			//MainActivity.r_answer4.setText(R.string.Scene4AchoiceD);
			Storyboard.setupStory(0, 0, 0); // Setup Story Text
			Storyboard.setupAnswerChoices(0, 0, 8, 8, 8, 8); // Setup Answer Choices
			Hero.statsChange(0, 0, 0, 0);
		}	

		
		public static void story4AProgress() {
			if (MainActivity.r_checked == MainActivity.r_answer1.getId()) {
				Log.d("Debug", " story4AProgress, Answer1 is called!");
				story4BSetup();
			} else if (MainActivity.r_checked == MainActivity.r_answer2.getId()) {
				Log.d("Debug", " story4AProgress, Answer2 is called!");
				story4CSetup();
			} 
			else {
				//story4Setup();
			}
			MainActivity.rg_answers.clearCheck(); // Clear the checked radio button
			MainActivity.r_answer1.setChecked(true); // Set so that the first answer is default
		}
		
				
		public static void story4Progress(){
		Log.d("Debug", " story4Progress is called!");
		story5Setup();
		
		}
		
		
		public static void story5Setup() {
			Log.d("Debug", " story5Setup is called!");
			MainActivity.tv_story1.setText(R.string.Scene5story1);
			MainActivity.tv_story2.setText(R.string.Scene5story2);
			MainActivity.tv_story3.setText(R.string.Scene5story3);
			MainActivity.r_answer1.setText(R.string.Scene5choiceA);
			MainActivity.r_answer2.setText(R.string.Scene5choiceB);
			//MainActivity.r_answer3.setText(R.string.Scene4AchoiceC);
			//MainActivity.r_answer4.setText(R.string.Scene4AchoiceD);
			Storyboard.setupStory(0, 0, 0); // Setup Story Text
			Storyboard.setupAnswerChoices(0, 0, 8, 8, 8, 8); // Setup Answer Choices
			Hero.statsChange(0, 0, 0, 0);
		}	
		/*
		public static void story4Progress() {

			if (MainActivity.r_checked == MainActivity.r_answer1.getId())
			{
				Log.d("Debug", " story4Progress, r_answer1.isChecked called!");
				story4ASetup();
			}
			else if	(MainActivity.r_checked == MainActivity.r_answer2.getId())
			{
				Log.d("Debug", " story4Progress, r_answer2.isChecked called!");
				story4BSetup();
			}
			else if	(MainActivity.r_checked == MainActivity.r_answer3.getId())
			{
				Log.d("Debug", " story1Progress, r_answer3.isChecked called!");
				story4CSetup();
			}
			else
			{
				// Issue
			}
			MainActivity.rg_answers.clearCheck();
			MainActivity.r_answer1.setChecked(true);

		}
		*/
		


		

}

