package williamqliu.com.happilyeverafter;

import android.util.Log;
import android.widget.Toast;

public class ChapterOne {
		
		// Setup story text, answer choices
		public static void story1Setup() {
			MainActivity.tv_story1.setText(R.string.AA_story1);
			MainActivity.tv_story2.setText(R.string.AA_story2);
			MainActivity.tv_story3.setText(R.string.AA_story3);
			MainActivity.r_answer1.setText(R.string.AA_choice1);
			MainActivity.r_answer2.setText(R.string.AA_choice2);
			MainActivity.r_answer3.setText(R.string.AA_choice3);
			Storyboard.setupStory(0, 0, 0); // Setup Story Text
			Storyboard.setupAnswerChoices(0, 0, 0, 8, 8); // Setup Answer Choices
			
		}
	
		public static void story1Progress() {

			if (MainActivity.r_checked == MainActivity.r_answer1.getId())
			{
				Log.d("Debug", " story1Progress, r_answer1.isChecked called!");
				if(MainActivity.changedStatFlag==false)
					Hero.statsChange(0, 50, 0, 0);
				story2ASetup();
			}
			else if	(MainActivity.r_checked == MainActivity.r_answer2.getId())
			{
				Log.d("Debug", " story1Progress, r_answer2.isChecked called!");
				if(MainActivity.changedStatFlag==false)
					Hero.statsChange(0, 0, 50, 0);
				story2BSetup();
			}
			else if	(MainActivity.r_checked == MainActivity.r_answer3.getId())
			{
				Log.d("Debug", " story1Progress, r_answer3.isChecked called!");
				if(MainActivity.changedStatFlag==false)
					Hero.statsChange(0, 25, 25, 0);
				story2CSetup();
			}
			else
			{
				// Issue
			}
			MainActivity.rg_answers.clearCheck();
			MainActivity.r_answer1.setChecked(true);

		}

		public static void story2ASetup() {
			MainActivity.tv_story1.setText(R.string.AB_storyA1);
			MainActivity.tv_story2.setText(R.string.AB_storyA2);
			MainActivity.tv_story3.setText(R.string.AB_storyA3);
			Storyboard.setupStory(0, 0, 0); // Setup Story Text
			Storyboard.setupAnswerChoices(8, 8, 8, 8, 8); // Setup Answer Choices
			//MainActivity.r_answer1.setText(R.string.AB_choiceA1);
			//MainActivity.r_answer2.setText(R.string.AB_choiceA2);
			//MainActivity.r_answer3.setText(R.string.AB_choiceA3);
		}
		
		public static void story2BSetup() {
			MainActivity.tv_story1.setText(R.string.AB_storyB1);
			MainActivity.tv_story2.setText(R.string.AB_storyB2);
			MainActivity.tv_story3.setText(R.string.AB_storyB3);
			Storyboard.setupStory(0, 0, 0); // Setup Story Text
			Storyboard.setupAnswerChoices(8, 8, 8, 8, 8); // Setup Answer Choices

		}
		
		public static void story2CSetup() {
			MainActivity.tv_story1.setText(R.string.AB_storyC1);
			MainActivity.tv_story2.setText(R.string.AB_storyC2);
			MainActivity.tv_story3.setText(R.string.AB_storyC3);
			//MainActivity.r_answer1.setText(R.string.AB_choiceC1);
			//MainActivity.r_answer2.setText(R.string.AB_choiceC2);
			//MainActivity.r_answer3.setText(R.string.AB_choiceC3);
			Storyboard.setupStory(0, 0, 0); // Setup Story Text
			Storyboard.setupAnswerChoices(8, 8, 8, 8, 8); // Setup Answer Choices

		}
		
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
		}

		public static void story3Setup() {

			MainActivity.tv_story1.setText(R.string.AC_story1);
			MainActivity.tv_story2.setText(R.string.AC_story2);
			MainActivity.tv_story3.setText(R.string.AC_story3);
			MainActivity.r_answer1.setText(R.string.AC_choice1);
			MainActivity.r_answer2.setText(R.string.AC_choice2);
			MainActivity.r_answer3.setText(R.string.AC_choice3);
			Storyboard.setupStory(0, 0, 0); // Setup Story Text
			Storyboard.setupAnswerChoices(0, 0, 8, 8, 8); // Setup Answer Choices

			
			Hero.statsChange(0, 0, 0, 0);


		}

		public static void story3Progress() {
			if (MainActivity.r_checked == MainActivity.r_answer1.getId()) {
				story4Setup();
			} else if (MainActivity.r_checked == MainActivity.r_answer2.getId()) {
				story4Setup();
			} else if (MainActivity.r_checked == MainActivity.r_answer3.getId()) {
				story4Setup();
			} else if (MainActivity.r_checked == MainActivity.r_answer4.getId()) {
				story4Setup();
			} else if (MainActivity.r_checked == MainActivity.r_answer5.getId()) {
				story4Setup();
			}
			else {
				story4Setup();
			}
			MainActivity.rg_answers.clearCheck(); // Clear the checked radio button
			MainActivity.r_answer1.setChecked(true); // Set so that the first answer is default

		}

		public static void story4Setup() {
			MainActivity.tv_story1.setText(R.string.AD_story1);
			MainActivity.tv_story2.setText(R.string.AD_story2);
			MainActivity.tv_story3.setText(R.string.AD_story3);
			MainActivity.r_answer1.setText(R.string.AD_choice1);
			MainActivity.r_answer2.setText(R.string.AD_choice2);
			MainActivity.r_answer3.setText(R.string.AD_choice3);
			MainActivity.r_answer4.setText(R.string.AD_choice4);
			Storyboard.setupStory(0, 0, 0); // Setup Story Text
			Storyboard.setupAnswerChoices(0, 0, 0, 8, 8); // Setup Answer Choices

			Hero.statsChange(0, 0, 0, 0);
		}

		public static void story4Progress() {

			//MainActivity.storyline++;
		}

}
