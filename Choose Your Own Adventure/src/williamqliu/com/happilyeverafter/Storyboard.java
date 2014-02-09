package williamqliu.com.happilyeverafter;

import android.content.Intent;
import android.os.Handler;

public class Storyboard {

	// Setup visibility of the story text (0=Visible, 4=Invisible, 8=Gone)
	public static void setupStory(int first, int second, int third) {

		// Save values and prepare for onPause()
		MainActivity.setupStory1 = first;
		MainActivity.setupStory2 = second;
		MainActivity.setupStory3 = third;
		
		// Set visibility of story text fields
		MainActivity.tv_story1.setVisibility(first);
		MainActivity.tv_story2.setVisibility(second);
		MainActivity.tv_story3.setVisibility(third);
	}

	// Setup visibility of the answer choices (0=Visible, 4=Invisible, 8=Gone)
	public static void setupAnswerChoices(int first, int second, int third,
			int fourth, int fifth, int sixth) {
		
		// Save values and prepare for onPause()
		MainActivity.setupAnswer1 = first;
		MainActivity.setupAnswer2 = second;
		MainActivity.setupAnswer3 = third;
		MainActivity.setupAnswer4 = fourth;
		MainActivity.setupAnswer5 = fifth;
		MainActivity.setupAnswer6 = sixth;
		
		// Set visibility of answer text fields
		MainActivity.r_answer1.setVisibility(first);
		MainActivity.r_answer2.setVisibility(second);
		MainActivity.r_answer3.setVisibility(third);
		MainActivity.r_answer4.setVisibility(fourth);
		MainActivity.r_answer5.setVisibility(fifth);
		MainActivity.mainImage.setVisibility(sixth);
		MainActivity.r_answer1.setChecked(true); // Reset Default choice to
													// First Answer
	}
	
	
	public void scrollTopPage(){
		// Function to reset Scroll View back to the top of the page
		MainActivity.myScrollView.post(new Runnable(){
			public void run()
			{
				MainActivity.myScrollView.scrollTo(0, 0);
			}
		});
	}
	
	

	public void storyIncrement() {

		switch (MainActivity.storyline) {
		case 0: {
			//MainActivity.changedStatFlag=false;
			scrollTopPage();
			ChapterOne.story1Setup();
			break;
		}
		
		// Chapter 1 - Hello <Name>!
		case 1: {
			scrollTopPage();
			ChapterOne.story1Progress();
			break;
				
		}

		// Play Animation
		case 2: {
			scrollTopPage();
			ChapterOne.animation1Setup();
			break;
		}
		
		case 3: {
			scrollTopPage();
			ChapterOne.story2Progress();
			break;
		}
		
		case 4: {
			scrollTopPage();
			ChapterOne.story3Progress();
			break;
		}
		
		case 5: {
			scrollTopPage();
			ChapterOne.story4Progress();
			break;
		}
			
			
		/*	
		 * case 1: {
		
			//Switches to text
			//Working using ChapterOne.story1Progress();
			ChapterOne.story1Progress();
			break;
		}
		case 2: {
			ChapterOne.story2Progress();
			break;
		}
		case 3: {
			ChapterOne.story3Progress();
			break;
		}
		case 4: {
			ChapterOne.story4Progress();
			break;
		}
		*/
			
		}
	}

}
