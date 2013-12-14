package williamqliu.com.happilyeverafter;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class Animations extends Animation{

	public void setupHero(){
		ImageView heroImage = (ImageView) findViewById(R.id.heroimage);
		heroImage.setBackgroundResource(R.drawable.heroimage);

		// Setup Animation for attacking
		heroImage.setBackgroundResource(R.drawable.heroimage);
		AnimationDrawable frameAnimation = (AnimationDrawable) heroImage
				.getBackground();
		frameAnimation.setOneShot(true); // Play Animation only once

		// Display Animation for attacking
		if (frameAnimation.isRunning()) {
			frameAnimation.stop(); // Reset animation
			frameAnimation.start(); // Setup animation again
		} else {
			frameAnimation.start(); // Play animation
		}

		AnimationSet set = new AnimationSet(true);
		TranslateAnimation anim = new TranslateAnimation(0f, .1f, 0f, .1f);
		set.addAnimation(anim);
		set.setDuration(500);
		set.setInterpolator(new AccelerateInterpolator(1.0f));
		heroImage.startAnimation(set);
		
	}
	
}
