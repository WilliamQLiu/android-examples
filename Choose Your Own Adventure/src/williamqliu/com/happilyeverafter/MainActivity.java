package williamqliu.com.happilyeverafter;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;



//public class MainActivity extends Activity implements OnClickListener {
public class MainActivity extends Activity implements View.OnClickListener{
/** Called when the activity is first created. */

	// Static fields so we can access in another class
	public static TextView tv_appname, tv_storyboard;
	public static TextView tv_story1, tv_story2, tv_story3;
	public static TextView tv_stat1, tv_stat2, tv_stat3, tv_stat4;
	public static RadioGroup rg_answers;
	public static RadioButton r_answer1, r_answer2, r_answer3, r_answer4,
			r_answer5;
	public static Button b_Next;
	public static int storyline;
	public static int setupStory1, setupStory2, setupStory3;
	public static int setupAnswer1, setupAnswer2, setupAnswer3, setupAnswer4, setupAnswer5;
	public static boolean changedStatFlag;
	public static int r_checked, choice1, choice2, choice3, choice4, choice5;
	public static ChapterOne myChapterOne = new ChapterOne(); // Setup Chapter
																// One
	public static Storyboard myStoryboard = new Storyboard(); // Setup
																// Storyboard
	public static Hero myHero = new Hero(); // Setup Player stats
	//public static Toast myToast;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); // Always call the superclass first
		Log.d("Debug", "onCreate has been called!");
	}

	// Setup variables
	public void initialize() {

		tv_appname = (TextView) findViewById(R.id.tvAppName);
		tv_storyboard = (TextView) findViewById(R.id.tvStoryboard);
		

		// Story text boxes
		tv_story1 = (TextView) findViewById(R.id.tv_story1);
		tv_story2 = (TextView) findViewById(R.id.tv_story2);
		tv_story3 = (TextView) findViewById(R.id.tv_story3);


		// Find out when Radio Group changes
		r_answer1 = (RadioButton) findViewById(R.id.r_answer1);
		r_answer1.setOnClickListener(this);
		r_answer2 = (RadioButton) findViewById(R.id.r_answer2);
		r_answer2.setOnClickListener(this);
		r_answer3 = (RadioButton) findViewById(R.id.r_answer3);
		r_answer3.setOnClickListener(this);
		r_answer4 = (RadioButton) findViewById(R.id.r_answer4);
		r_answer4.setOnClickListener(this);
		r_answer5 = (RadioButton) findViewById(R.id.r_answer5);
		r_answer5.setOnClickListener(this);
		rg_answers = (RadioGroup) findViewById(R.id.rg_answers);
		rg_answers.setOnClickListener(this);
		

		
		b_Next = (Button) findViewById(R.id.b_Next);
		b_Next.setOnClickListener(this);
		tv_stat1 = (TextView) findViewById(R.id.tvStat1Num);
		tv_stat2 = (TextView) findViewById(R.id.tvStat2Num);
		tv_stat3 = (TextView) findViewById(R.id.tvStat3Num);
		
		
		//Typeface myTypeFace = Typeface.createFromAsset(getAssets(), "fonts/CharlemagneBold.otf");
		//Typeface myTypeFace = Typeface.createFromAsset(getAssets(), "fonts/final_fantasy_36_font.ttf");
		//Typeface myTypeFace = Typeface.createFromAsset(getAssets(), "fonts/Oxygen.otf");
		Typeface myTypeFace = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
		Typeface myHeaderTypeFace = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Medium.ttf");
		
		//TypeFace
		tv_appname.setTypeface(myHeaderTypeFace);
		tv_storyboard.setTypeface(myHeaderTypeFace);	
		tv_story1.setTypeface(myTypeFace);
		tv_story2.setTypeface(myTypeFace);
		tv_story3.setTypeface(myTypeFace);	
		r_answer1.setTypeface(myTypeFace);
		r_answer2.setTypeface(myTypeFace);	
		r_answer3.setTypeface(myTypeFace);
		r_answer4.setTypeface(myTypeFace);
		r_answer5.setTypeface(myTypeFace);	

		tv_stat1.setTypeface(myTypeFace);
		tv_stat2.setTypeface(myTypeFace);	
		tv_stat3.setTypeface(myTypeFace);
		
			

	}
	

	// Setup onClick
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {

		case R.id.b_Next: {
			MainActivity.storyline++;
			MainActivity.r_checked = rg_answers.getCheckedRadioButtonId();
			myStoryboard.storyIncrement();
			break;
		}
		}
	}


	@Override
	public void onResume() {
		super.onResume();
		Log.d("Debug", "onResume has been called!");
		setContentView(R.layout.main); // Set View
		initialize(); // Sets up blank fields
		SharedPreferences settings = getPreferences(0);
		int temp = settings.getInt("storylineKey", 0);

		// First time initializing
		if (temp == 0) {
			Log.d("Debug", " onResume, temp == 0 has been called!");
			MainActivity.storyline = 0;
			Hero.initializeStats(); // Update stats
			ChapterOne.story1Setup();
		} else if (temp >= 1 && temp < 10) {
			Log.d("Debug", " onResume, temp >= 1 has been called!");
			MainActivity.storyline = settings.getInt("storylineKey", 0);
			MainActivity.tv_story1.setText(settings.getString("story1Key",
					"Error"));
			MainActivity.tv_story2.setText(settings.getString("story2Key",
					"Error"));
			MainActivity.tv_story3.setText(settings.getString("story3Key",
					"Error"));
			MainActivity.r_answer1.setText(settings.getString("choice1Key",
					"Error"));
			MainActivity.r_answer2.setText(settings.getString("choice2Key",
					"Error"));
			MainActivity.r_answer3.setText(settings.getString("choice3Key",
					"Error"));
			MainActivity.r_answer4.setText(settings.getString("choice4Key",
					"Error"));
			MainActivity.r_answer5.setText(settings.getString("choice5Key",
					"Error"));

			

			// Setup to display correct number of story text
			settings.getInt("setupStory1Key", MainActivity.setupStory1);
			settings.getInt("setupStory2Key", MainActivity.setupStory2);
			settings.getInt("setupStory3Key", MainActivity.setupStory3);
			Storyboard.setupStory(setupStory1, setupStory2, setupStory3);

			// Setup to display correct number of answer choices
			settings.getInt("setupAnswer1Key", MainActivity.setupAnswer1);
			settings.getInt("setupAnswer2Key", MainActivity.setupAnswer2);
			settings.getInt("setupAnswer3Key", MainActivity.setupAnswer3);
			settings.getInt("setupAnswer4Key", MainActivity.setupAnswer4);
			settings.getInt("setupAnswer5Key", MainActivity.setupAnswer5);
			Storyboard.setupAnswerChoices(setupAnswer1, setupAnswer2, setupAnswer3, setupAnswer4, setupAnswer5);

			MainActivity.r_checked = settings.getInt("lastCheckedKey", -1);
			
			
			MainActivity.changedStatFlag=true;  // Make stats changeable again
			Hero.stat1 = settings.getInt("stat1Key", 100);
			Hero.stat2 = settings.getInt("stat2Key", 100);
			Hero.stat3 = settings.getInt("stat3Key", 100);
			Hero.stat4 = settings.getInt("stat4Key", 100);
			Hero.statsChange(0, 0, 0, 0);
			
			myStoryboard.storyIncrement();
			
		} else {
			Log.d("Debug", " onResume, temp > 10 has been called!");
		}

		// Allows you to save and retrieve persistent
		// key-value pairs of primitive data types (boolean, floats, ints,
		// longs, and strings - This data will persist across user sessions
		// (even if application is killed)

	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.d("Debug", "onStart has been called!");
	}

	@Override
	public void onPause() {
		super.onPause();
		Log.d("Debug", "onPause has been called!");

		SharedPreferences settings = getPreferences(0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putInt("storylineKey", storyline);
		editor.putInt("stat1Key", Hero.stat1);
		editor.putInt("stat2Key", Hero.stat2);
		editor.putInt("stat3Key", Hero.stat3);
		editor.putInt("stat4Key", Hero.stat4);
		editor.putString("story1Key", MainActivity.tv_story1.getText()
				.toString());
		editor.putString("story2Key", MainActivity.tv_story2.getText()
				.toString());
		editor.putString("story3Key", MainActivity.tv_story3.getText()
				.toString());
		editor.putString("choice1Key", MainActivity.r_answer1.getText()
				.toString());
		editor.putString("choice2Key", MainActivity.r_answer2.getText()
				.toString());
		editor.putString("choice3Key", MainActivity.r_answer3.getText()
				.toString());
		editor.putString("choice4Key", MainActivity.r_answer4.getText()
				.toString());
		editor.putString("choice5Key", MainActivity.r_answer5.getText()
				.toString());
		
		editor.putInt("lastCheckedKey", r_checked);  // Put in int of last checked variable

		editor.putBoolean("changedStatFlag", true);

		editor.putInt("setupStory1Key", MainActivity.setupStory1);
		editor.putInt("setupStory2Key", MainActivity.setupStory2);
		editor.putInt("setupStory3Key", MainActivity.setupStory3);
		
		editor.putInt("setupAnswer1Key", MainActivity.setupAnswer1);
		editor.putInt("setupAnswer2Key", MainActivity.setupAnswer2);
		editor.putInt("setupAnswer3Key", MainActivity.setupAnswer3);
		editor.putInt("setupAnswer4Key", MainActivity.setupAnswer4);
		editor.putInt("setupAnswer5Key", MainActivity.setupAnswer5);
		
		editor.commit();

	}

	@Override
	protected void onDestroy() {
		// The activity is about to be destroyed.
		super.onDestroy();
		Log.d("Debug", "onDestroy has been called!");
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// Display in menu
		super.onCreateOptionsMenu(menu);
		// menu.add("Code by William Liu");
		MainActivity.storyline = 0;
		Hero.initializeStats(); // Update stats
		MainActivity.changedStatFlag=false;
		ChapterOne.story1Setup();
		myStoryboard.storyIncrement();
		return true;

	}





}