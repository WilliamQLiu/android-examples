package com.wliu.quiz3;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	private TextView countView;
	private TextView javaPropertiesView;
    private Button incrementButton;		// Can also say private android.widget.Button buttonName;
    private Button decrementButton;
    private Button resetButton;
    private int count=0;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        setTitle("Quiz3 App Title Bar");
        
        countView = (TextView) findViewById(R.id.countView);
        countView.setText("The count is " + count);

        incrementButton = (Button) findViewById(R.id.incrementButton);
        incrementButton.setOnClickListener(this);
        
        decrementButton = (Button) findViewById(R.id.decrementButton);
        decrementButton.setOnClickListener(this);

        resetButton = (Button) findViewById(R.id.resetButton);
        resetButton.setOnClickListener(this);
        
        javaPropertiesView = (TextView) findViewById(R.id.javaPropertiesView);
        javaPropertiesView.setText("TextView for Java Properties\n" + 
        		System.getProperty("java.vm.name") + "\n" + 
        		System.getProperty("java.vm.vendor") + "\n" +
        		System.getProperty("os.name") + "\n" +
        		System.getProperty("os.arch") + "\n" +
        		System.getProperty("os.version") + "\n");
        
    }
    
    
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.incrementButton:
			count++;
			break;
		case R.id.decrementButton:
			count--;
			break;
		case R.id.resetButton:
			count = 0;
			break;
		default:	// Do nothing
			break;
		}
		countView.setText("count = " + count);	
				
	}
}