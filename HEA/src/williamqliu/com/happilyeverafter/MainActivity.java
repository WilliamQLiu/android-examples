package williamqliu.com.happilyeverafter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView loadingText;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menuloading);

		// ourSong = MediaPlayer.create(MainActivity.this,
		// R.raw.mystartingsound);
		// ourSong.start();

		// Initialize variables
		loadingText = (TextView) findViewById(R.id.textViewLoading);

		// Setting up a Thread to wait for 5 seconds, then switch activities
		Thread timer = new Thread() {
			// Thread looks for a method named run()
			public void run() {
				// Try to do a function, catches an InterruptedException, and
				// does finally
				try {
					// Sleep for 1000 milliseconds = 1 seconds
					sleep(1000);
					/*
					loadingText.setText("5");
					sleep(200);
					loadingText.setText("4");
					sleep(200);
					loadingText.setText("3");
					sleep(200);
					loadingText.setText("2");
					sleep(200);
					loadingText.setText("1");
					sleep(200);
					*/

				} catch (InterruptedException e) {
					// For Debugging, prints the Stack
					e.printStackTrace();
				} finally {
					// Create Intent - to open the Action under
					// AndroidManifest.xml
					Intent openMenuActivity = new Intent(
							"williamqliu.com.happilyeverafter.MenuActivity");

					// Start an activity
					startActivity(openMenuActivity);
				}
			}
		};

		// From Thread class, start the Thread
		timer.start();
	}

	// If paused, finishes loading and exits
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		// ourSong.release(); // Release resources
		finish(); // Stop the Activity
	}

}