package williamqliu.com.happilyeverafter;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
public class StatsPage extends Activity implements OnClickListener{

	public static TextView tv_story1, tv_story2, tv_story3, tv_story4, tv_story5;
	public static TextView tv_text1, tv_text2, tv_text3, tv_text4, tv_text5;
	public static TextView tv_lowtext1, tv_lowtext2, tv_lowtext3, tv_lowtext4;
	public static Button myButton;
	public static ImageView imageHeroIcon;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.statspage);
		initialize();
	}
	
	public void initialize() {

		Log.d("Setup", "initialize has been called!");
		// Story text boxes
		tv_text1 = (TextView) findViewById(R.id.tv_text1);
		tv_text2 = (TextView) findViewById(R.id.tv_text2);
		tv_text3 = (TextView) findViewById(R.id.tv_text3);
		tv_text4 = (TextView) findViewById(R.id.tv_text4);
		tv_text5 = (TextView) findViewById(R.id.tv_text5);
		
		tv_lowtext1 = (TextView) findViewById(R.id.tv_lowtext1);
		tv_lowtext2 = (TextView) findViewById(R.id.tv_lowtext2);
		tv_lowtext3 = (TextView) findViewById(R.id.tv_lowtext3);
		tv_lowtext4 = (TextView) findViewById(R.id.tv_lowtext4);


		//Image
		imageHeroIcon = (ImageView) findViewById(R.id.imageHeroIcon);
		
		// Button
		myButton = (Button) findViewById(R.id.b_Back);
		myButton.setOnClickListener(this);
		
		StatsPage.tv_text1.setText(Hero.heroName.toString());
		StatsPage.tv_text2.setText(("Health: " + Hero.stat1 + "  ").toString());
		StatsPage.tv_text3.setText(("Alignment: " + Hero.stat2  + "  ").toString());
		StatsPage.tv_text4.setText(("Style: " + Hero.stat3  + "  ").toString());
		StatsPage.tv_text5.setText(("Power: " + Hero.stat4  + "  ").toString());
		
		
		StatsPage.tv_lowtext1.setText("Human Race".toString());
		StatsPage.tv_lowtext2.setText("Population:".toString());
		StatsPage.tv_lowtext3.setText("Highest Comfort:".toString());
		StatsPage.tv_lowtext4.setText("Most Destructive Weapon:".toString());
		
		
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		//Log.d("Debug", "Click has been called!");
		switch (v.getId()) {
		
		case R.id.b_Back: {
			Log.d("Debug", "Back Button has been called!");
            Intent intent = new Intent();
            setResult(RESULT_OK, intent);
			finish();
			//super.onDestroy();
		}
		}
	}
}
