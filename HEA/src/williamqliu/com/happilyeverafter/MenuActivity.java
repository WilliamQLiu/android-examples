package williamqliu.com.happilyeverafter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends Activity implements OnClickListener {

	TextView mainText;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menumain);

		Button startButton = (Button) findViewById(R.id.buttonStart);
		startButton.setOnClickListener(this);

		Button helpButton = (Button) findViewById(R.id.buttonHelp);
		helpButton.setOnClickListener(this);

		mainText = (TextView) findViewById(R.id.textViewMain);

	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.buttonStart:
			// Start Game
			try {
				mainText.setText("Starting Game");
				Intent chapterOneActivity = new Intent("williamqliu.com.happilyeverafter.ChapterOneActivity");
				startActivity(chapterOneActivity);  // Start activity

			} catch (IllegalStateException e) {
				e.printStackTrace();
			}
			break;
		case R.id.buttonHelp:
			// Help Menu
			try {
				mainText.setText("Help Menu");
				setContentView(R.layout.menuhelp);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			}
			break;
		default:
			// Do Nothing

		}
	}

}
