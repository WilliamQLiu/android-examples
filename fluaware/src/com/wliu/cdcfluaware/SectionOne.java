package com.wliu.cdcfluaware;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

// 'Section One' is for "What is the Flu - Learn Flu Facts"
public class SectionOne extends Activity {

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sectionone);
		
		TabHost tabHost=(TabHost)findViewById(R.id.tabhost);
		tabHost.setup();

		// Setup Tab 1
		TabSpec spec1=tabHost.newTabSpec("WHAT");
		spec1.setContent(R.id.tab1);
		spec1.setIndicator("WHAT",getResources().getDrawable(R.drawable.section1tab1));
		//spec1.setIndicator("",getResources().getDrawable(R.drawable.icon));
		//spec1.setIndicator("Step 1");

		// Setup Tab 2
		TabSpec spec2=tabHost.newTabSpec("WHO?");
		spec2.setContent(R.id.tab2);
		spec2.setIndicator("WHO",getResources().getDrawable(R.drawable.section1tab2));
		//spec2.setIndicator("Step 2");
		
		// Setup Tab 3
		TabSpec spec3=tabHost.newTabSpec("HIGH RISK");
		spec3.setContent(R.id.tab3);
		spec3.setIndicator("HIGH RISK",getResources().getDrawable(R.drawable.section1tab3risk));
		//spec3.setIndicator("Step 3");
		
		// Setup Tab 4
		TabSpec spec4=tabHost.newTabSpec("SICK");
		spec4.setContent(R.id.tab4);
		spec4.setIndicator("SICK",getResources().getDrawable(R.drawable.section1tab4blue));
		//spec3.setIndicator("Step 3");

		// Add tabs
		tabHost.getTabWidget().setDividerDrawable(R.drawable.line);
		//tabHost.getTabWidget().setBackgroundColor(Color.parseColor("#D6C7B5")); //Change Background

		tabHost.addTab(spec1);
		tabHost.addTab(spec2);
		tabHost.addTab(spec3);
		tabHost.addTab(spec4);
		
	}
}
