package wliu.happilyeverafter;


import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    
	private TextView mainText;  // Text for top menu
	private RelativeLayout option1;
	private RelativeLayout option2;
	private RelativeLayout option3;
	private RelativeLayout option4;
	private RelativeLayout player1Layout;
	private RelativeLayout player2Layout;
	private RelativeLayout player3Layout;
	private RelativeLayout player4Layout;
	private ImageView player1Image;
	private ImageView player2Image;
	//private ImageView player3Image;
	//private ImageView player4Image;
	private ImageView monster1Image;

	private Random RNG = new Random();	// Random Number Generator used for calculations
	private int randomDmg;	// Calculation for Damage
	private ProgressBar progressBarPlayer1;
	private ProgressBar progressBarPlayer2;
	//private ProgressBar progressBarPlayer3;
	//private ProgressBar progressBarPlayer4;
	private ProgressBar progressBarMonster1;
	private AtomicBoolean isRunning = new AtomicBoolean(false);
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);	// Use main layout
        
        // Main Text for Top Menu
        mainText = (TextView) findViewById(R.id.mainText);
        
        /* Fighting Options on bottom left menu
         * Option 1 = Fight
         * Option 2 = Special (use Gestures to 'cast' spells)
         * Option 3 = Item
         * Option 4 = Run
         * */
        option1 = (RelativeLayout) findViewById(R.id.option1Layout);
        option1.setOnClickListener(this);
        option2 = (RelativeLayout) findViewById(R.id.option2Layout);
        option2.setOnClickListener(this);
        option3 = (RelativeLayout) findViewById(R.id.option3Layout);
        option3.setOnClickListener(this);
        option4 = (RelativeLayout) findViewById(R.id.option4Layout);
        option4.setOnClickListener(this);
        
        /* Player Stats on bottom right menu
         * Player [1, 2, 3, 4] Layout = Name, Current HP, Maximum HP, Progress Bar
         */
        player1Layout = (RelativeLayout) findViewById(R.id.player1Layout);
        player1Layout.setOnClickListener(this);
        player2Layout = (RelativeLayout) findViewById(R.id.player2Layout);
        player2Layout.setOnClickListener(this);
        player3Layout = (RelativeLayout) findViewById(R.id.player3Layout);
        player3Layout.setOnClickListener(this);
        player4Layout = (RelativeLayout) findViewById(R.id.player4Layout);
        player4Layout.setOnClickListener(this);
        progressBarPlayer1 = (ProgressBar) findViewById(R.id.Player1ProgressBar);
        progressBarPlayer2 = (ProgressBar) findViewById(R.id.Player2ProgressBar);
        //progressBarPlayer3 = (ProgressBar) findViewById(R.id.Player3ProgressBar);
        //progressBarPlayer4 = (ProgressBar) findViewById(R.id.Player4ProgressBar);
        player1Image = (ImageView)findViewById(R.id.player1);
        player2Image = (ImageView)findViewById(R.id.player2);
        //player3Image = (ImageView)findViewById(R.id.player1);
        //player4Image = (ImageView)findViewById(R.id.player1);
        
        monster1Image = (ImageView)findViewById(R.id.enemy1);
        progressBarMonster1 = (ProgressBar)findViewById(R.id.Player3ProgressBar);
    }
	
	
	// Handle Progress, update Player Animations - Note: May need to separate each Player and Monster to a separate handler
	Handler handler = new Handler()
	{
		@Override
		public void handleMessage(Message msg)
		{
			//Update Player's Progress Bar
			progressBarPlayer1.incrementProgressBy(5);
			progressBarPlayer2.incrementProgressBy(5);
			//progressBarPlayer3.incrementProgressBy(5);
			//progressBarPlayer4.incrementProgressBy(5);
			progressBarMonster1.incrementProgressBy(5);
			
			if(progressBarPlayer1.getProgress() == 100)
			{	
				player1Image.setBackgroundResource(R.drawable.player1ready2);
				
			}
			if(progressBarPlayer2.getProgress() == 100)
			{	
				player2Image.setBackgroundResource(R.drawable.player2ready2);
			}
			
			/*
			if(progressBarMonster1.getProgress() == 100)
			{
				mainText.setText("Monster is ready to attack");
				
				// Monster Attack Function
				monsterAttack();
			}
			*/
			
		}
	};
	
	// Handle Progress, update Player Animations - Note: May need to separate each Player and Monster to a separate handler
	Handler handler2 = new Handler()
	{
		@Override
		public void handleMessage(Message msg)
		{
			//Update Monster's Progress Bar
			progressBarMonster1.incrementProgressBy(5);
			
			if(progressBarMonster1.getProgress() == 100)
			{
				//mainText.setText("Monster is ready to attack");
				
				// Monster Attack Function
				monsterAttack();
			}
			
		}
	};
	
	public void monsterAttack(){
		// Play animation for monster attacking
		randomDmg = 100 + RNG.nextInt(100);  // Calculations for attack
		mainText.setText("Monster attacks for " + randomDmg + " points of damage");
		
		// Subtract damage from player health
		
		// Check if player died
		
		// Reset Monster's Progress Bar to 0
		progressBarMonster1.setProgress(0);
//		combatTick();
		
	}
	
	public void updatePlayer1()
	{
		if(progressBarPlayer1.getProgress() == 100)
		{	
			player1Image.setBackgroundResource(R.drawable.player1ready2);
			
		}
		
	}
	
	public void updatePlayer2()
	{
		if(progressBarPlayer2.getProgress() == 100)
		{	
			player1Image.setBackgroundResource(R.drawable.player2ready2);
		}
	}
	

	/*
	 * Created On Start
	 * @see android.app.Activity#onStart()
	 */
	public void onStart()
	{
		super.onStart();
		progressBarPlayer1.setProgress(0);
		progressBarPlayer2.setProgress(0);
		//progressBarPlayer3.setProgress(0);
		//progressBarPlayer4.setProgress(0);

		progressBarMonster1.setProgress(0);
		combatTick();
	}
		

	
	public void combatTick()
	{
		// Create new background thread for handling combat 'ticks'
		Thread background = new Thread (new Runnable(){
			public void run(){
				try{
					for (int i=0; i<20 && isRunning.get(); i++){
						Thread.sleep(200);
						handler.sendMessage(handler.obtainMessage());
						
						// Testing second handler for Monster Attacks
						handler2.sendMessage(handler2.obtainMessage());
						
					}
				}
				catch(Throwable t){
					// Just end the background thread
				}
			}
		});
		isRunning.set(true);
		background.start();
	}
	
	public void combatTickMonster()
	{
		// Create new background thread for handling combat 'ticks'
		Thread background = new Thread (new Runnable(){
			public void run(){
				try{
					for (int i=0; i<20 && isRunning.get(); i++){
						Thread.sleep(200);
						handler.sendMessage(handler.obtainMessage());
					}
				}
				catch(Throwable t){
					// Just end the background thread
				}
			}
		});
		isRunning.set(true);
		background.start();
	}

	
	public void onStop(){
		super.onStop();
		isRunning.set(false);
	}
	
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
		
		// Attack Function
		case R.id.option1Layout:
			//mainText.setText("Fighting Function");
			
			// If Player 1 is ready to attack (Progress Bar == 100)
			if(progressBarPlayer1.getProgress()==100)
			{
				
				// Setup Animation for attacking
				player1Image.setBackgroundResource(R.drawable.player1fightanimation);
				AnimationDrawable frameAnimation = (AnimationDrawable) player1Image.getBackground();
				frameAnimation.setOneShot(true);  // Play Animation only once
				
				// Display Animation for attacking
				if(frameAnimation.isRunning())
				{
					frameAnimation.stop();  // Reset animation
					frameAnimation.start(); // Setup animation again
				}
				else
				{
					frameAnimation.start();  // Play animation
				}
				
				
				AnimationSet set = new AnimationSet(true);
				TranslateAnimation anim = new TranslateAnimation(0f, .1f, 0f, .1f);
				set.addAnimation(anim);
				set.setDuration(500);
				set.setInterpolator(new AccelerateInterpolator(1.0f));
				player1Image.startAnimation(set);
				
				
				
				
				
				// Reset Player's Progress Bar to 0
				progressBarPlayer1.setProgress(0);
				
				// Player hitting sound
				// mp = MediaPlayer.create(this, R.raw.mamacita_zero)
				
				// Attack Monster for attack calculation; Static Amount of Damage + Random Amount of Damage
				randomDmg = 3 + RNG.nextInt(6);  // Calculations for attack
				mainText.setText("You attack monster for " + randomDmg + " points of damage");
				
											
				// Function to remove damage from monster's HP
				// Function to check if monster is alive or not

				// New 'Tick' for combat
				combatTick();
				
				
				
				
			}
			else
			{
				mainText.setText("Not ready");
				
			}
			break;
		case R.id.option2Layout:
			mainText.setText("Special Function");
			break;
		case R.id.option3Layout:
			mainText.setText("Use Item Function");
			break;
		case R.id.option4Layout:
			mainText.setText("Run Away Function");
			break;
		case R.id.player1Layout:
			mainText.setText("Player 1 Selected");
			break;
		case R.id.player2Layout:
			mainText.setText("Player 2 Selected");
			break;
		case R.id.player3Layout:
			mainText.setText("Player 3 Selected");
			break;
		case R.id.player4Layout:
			mainText.setText("Player 4 Selected");
			break;
		default:
			break;
		}
	}
    
    
	private void update(){
    
    /*
     * Function: Initialize Environment
     * Function: Load Resources
     * Function: Run Loop()
     * 
     * Loop(){
     *   Update State - Manage state transitions, e.g. is the game over, character select or next level
     *   
     *   Check Input - Any key, scroll or touch from the user; input events come in from the main UI thread
     *     Define a field for the next user input and have the onKeyPressed or onTouchEvent set the next user
     *     action into that field.  Check if that is a valid input given the state of the game (and let the
     *     Physics side handle responding to it
     *   
     *   Update AI - AI will press buttons just like the user does (and let the Physics side handle responding
     *     to it).  For our scenario, will be the Monster's turn to attack
     *   
     *   Update Physics - May or may not be actual physics.  Take into account the last time it was updated,
     *     the current time it is being updated at, the user input and the AI input and determine where
     *     everything needs to be and whether any collisions have occurred.  The meat of the game engine
     *   
     *   Animations - Have the game draw each frame at the right time.  Keeping state fields like isDancing,
     *     danceFrame and lastDanceFrameTime allows for the Animation update to determine if its time to
     *     switch to the next frame.  Actually displaying the change of animation is handled by the video update.
     *     PNGS preferred
     *   
     *   Sound update - Updates handles triggering sounds, stopping sounds, changing volumes and changing the
     *     pitch of sounds.  Use SoundPool or MediaPlayer.  Small, low bitrate OGGs will yield the best
     *     performance results and the best stability.  Release media players and other resources when
     *     the activity is destroyed
     *     
     *   Video update - Takes into account the state of the game, the position of players, scores, statuses,
     *     etc and draws everything to screen.  If using a main loop, you will want to use the SurfaceView
     *     and do a "push" draw.  With other views, the view itself will call the draw operation and the main
     *     loop won't have to do it.  SurfaceView gives the highest frames per second and is more appropriate
     *     for games with animations or moving parts on screen.  All the video update should do is take the
     *     state of the game and draw it for this instance in time.  Any other automation is better handled
     *     by a different update task
     *   
     *   }
     * 
     */
    }  // End update() function




    
    
}


