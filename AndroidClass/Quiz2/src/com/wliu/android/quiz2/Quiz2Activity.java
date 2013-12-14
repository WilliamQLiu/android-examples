package com.wliu.android.quiz2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import java.util.Date;

public class Quiz2Activity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textView = new TextView(this);
        
        //Timing Test
        long startTime = 0;
        long endTime = 0;
        long differenceTime = 0;
        
        startTime = System.nanoTime(); // Set start time
        endTime = System.nanoTime(); // Set end time
        differenceTime = endTime - startTime; // Find difference
        //End Timing Test
        
        String s1 = "Quiz2 by William Liu\nDate: " + new Date().toString();  //String to display for Quiz2
        String s2 = "\n" + "This took " + differenceTime + " nano seconds to run.";
        
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);  // Hides Title Bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);  // Hides Status Bar

        //textView.setTextColor(-65536); // Display in Red
        textView.setTextSize(15); // Change Text Size to X pixels
        textView.setText(s1); // Display for Quiz2
        textView.append(s2); // Display Timing
        textView.setTextColor(-256); // Display in Yellow
        setContentView(textView);
        
    }
}