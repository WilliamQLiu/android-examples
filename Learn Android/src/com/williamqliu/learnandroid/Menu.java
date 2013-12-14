package com.williamqliu.learnandroid;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

	String classes[] = { "MainActivity", "TextPlay", "Email", "Camera", "Data",
			"Example", "Example" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Menu.this,
				android.R.layout.simple_expandable_list_item_1, classes));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String cheese = classes[position]; // Look at classes array at position

		try {

			// Creates a class variable for the MainActivity class
			// Class ourClass =
			// Class.forName("com.williamqliu.learnandroid.MainActivity");
			Class ourClass = Class.forName("com.williamqliu.learnandroid."
					+ cheese);
			Intent ourIntent = new Intent(Menu.this, ourClass);
			startActivity(ourIntent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater blowUp = getMenuInflater();
		blowUp.inflate(R.menu.cool_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Two items -
		switch (item.getItemId()) {
		case R.id.aboutUs:
			Intent i = new Intent("com.williamqliu.learnandroid.ABOUTUS");
			startActivity(i);
			break;
		case R.id.preferences:
			Intent p = new Intent("com.williamqliu.learnandroid.PREFS");
			startActivity(p);
			break;
		case R.id.exit:
			finish();
			break;

		}
		return false; // Return false to continue
	}

}
