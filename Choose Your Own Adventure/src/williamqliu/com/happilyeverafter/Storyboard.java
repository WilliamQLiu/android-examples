package williamqliu.com.happilyeverafter;

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
			int fourth, int fifth) {
		
		// Save values and prepare for onPause()
		MainActivity.setupAnswer1 = first;
		MainActivity.setupAnswer2 = second;
		MainActivity.setupAnswer3 = third;
		MainActivity.setupAnswer4 = fourth;
		MainActivity.setupAnswer5 = fifth;
		
		// Set visibility of answer text fields
		MainActivity.r_answer1.setVisibility(first);
		MainActivity.r_answer2.setVisibility(second);
		MainActivity.r_answer3.setVisibility(third);
		MainActivity.r_answer4.setVisibility(fourth);
		MainActivity.r_answer5.setVisibility(fifth);
		MainActivity.r_answer1.setChecked(true); // Reset Default choice to
													// First Answer
	}

	public void storyIncrement() {

		switch (MainActivity.storyline) {
		case 0: {
			MainActivity.changedStatFlag=false;
			ChapterOne.story1Setup();
			break;
		}
		case 1: {
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
		}
	}

}
