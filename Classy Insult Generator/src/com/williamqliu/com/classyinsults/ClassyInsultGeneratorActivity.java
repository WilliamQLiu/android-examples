package com.williamqliu.com.classyinsults;

import java.util.Random;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts.People;
import android.provider.Contacts.Phones;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.PhoneLookup;
import android.provider.SyncStateContract.Constants;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

public class ClassyInsultGeneratorActivity extends Activity implements
		OnClickListener {
	/** Called when the activity is first created. */

	TextView tvStep1, tvStep2, tvStep3, tvInsultList;
	Button btPrevious, btNext, btSend, btBrowse;
	EditText atContactName;
	// Random Number Generator Seed used for calculations
	Random RNG = new Random();
	int randomNumber;
	String currentInsult = "", currentContact = "";


	private static final int CONTACT_ACTIVITY = 100;
	private static final int PICK_CONTACT = 0;
	// Request code for the contact picker activity
	private static final int PICK_CONTACT_REQUEST = 1;
	private static final int CONTACT_PICKER_RESULT = 1001;

	/**
	 * An SDK-specific instance of {@link ContactAccessor}. The activity does
	 * not need to know what SDK it is running in: all idiosyncrasies of
	 * different SDKs are encapsulated in the implementations of the
	 * ContactAccessor class.
	 */
	ContentResolver myresolver;

	// Array of Insults
	String insultArray[] = {
			"You have all the virtues I dislike and none of the vices I admire.",
			"I have never killed a man, but I would read your obituary with great pleasure.",
			"You have never been known to use a word that might send a reader to the dictionary.",
			"Do you really think big emotions come from big words?",
			"IÕve had a perfectly wonderful evening, but this wasnÕt it.",
			"I won't attend your funeral, but I will send a nice letter saying I approved of it.",
			"I feel so miserable without you; it's almost like having you here.",
			"I've just learned about your illness.  I hope it's nothing trivial.",
			"You are not only dull yourself; you are the cause of dullness in others.",
			"You are simply a shiver looking for a spine to run up.",
			"You have delusions of adequacy.",
			"Why do you sit there looking like an envelope without any address on it?",
			"Your mother should have thrown you away and kept the stork.",
			"There's nothing wrong with you that reincarnation won't cure.",
			"You have the attention span of a lightning bolt.",
			"Every time you open your mouth you subtract from the sum of human knowledge.",
			"You inherited some good instincts from your Quaker forebears, but by diligent hard work, you overcame them.",
			"It's great that you love nature in spite of what it did to you.",
			"You can compress the most words into the smallest idea of anyone I know.",
			"You use statistics as a drunk man uses lamp-posts - for support rather than illumination.",
			"You have Van Gogh's ear for music.",
			"Some cause happiness wherever they go; you, whenever you go.",
			"You are a modest little person with much to be modest about.",
			"I can explain it to you, but I cannot understand it for you.",
			"Your mother was a hamster and your father smelt of elderberries.",
			"I may be drunk, but in the morning I will be sober and you will still be ugly.",
			"You were born ignorant and have been losing ground ever since.",
			"Your birth certificate is an apology from the condom factory.",
			"We all sprang from apes, but you didn't spring far enough.",
			"You must be the arithmetic man; you add trouble, subtract pleasure, divide attention, and multiple ignorance."

	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		initializeVars(); // Initialize Variables Method
		generateRandomInsult(); // Generate Random Insult

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		menu.add("Art by Dora Chin | Code by William Liu");
		// Display in menu
		return true;
	}

	private void generateRandomInsult() {
		// Generate Random Insult

		// Create Seed based on array length
		randomNumber = RNG.nextInt(insultArray.length);

		// Convert seed to Number and set to Array
		tvInsultList.setText(insultArray[randomNumber].toString());

		// Set random message to current Insult
		currentInsult = insultArray[randomNumber].toString();
	}

	private void initializeVars() {
		// Method to initialize variables to layout

		tvStep1 = (TextView) findViewById(R.id.tvStep1);
		tvStep2 = (TextView) findViewById(R.id.tvStep2);
		tvStep3 = (TextView) findViewById(R.id.tvStep3);
		tvInsultList = (TextView) findViewById(R.id.tvInsultList);
		btPrevious = (Button) findViewById(R.id.btPrevious);
		btPrevious.setOnClickListener(this);
		btNext = (Button) findViewById(R.id.btNext);
		btNext.setOnClickListener(this);
		btSend = (Button) findViewById(R.id.btSend);
		btSend.setOnClickListener(this);
		btBrowse = (Button) findViewById(R.id.btBrowse);
		btBrowse.setOnClickListener(this);
		atContactName = (EditText) findViewById(R.id.atContactName);

	}

	// OnClickListener
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.atContactName:
			currentContact = atContactName.getText().toString();

			// Previous Button changes text to previous joke
			break;
		case R.id.btPrevious:
			// Toast.makeText(this, "Test Button Previous",
			// Toast.LENGTH_SHORT).show();
			if (randomNumber > 0) {
				randomNumber--;
			} else if (randomNumber == 0) {
				randomNumber = insultArray.length - 1;
			}
			// Convert seed to number and set to array
			tvInsultList.setText(insultArray[randomNumber].toString());
			currentInsult = insultArray[randomNumber].toString();
			break;

		// Next Button changes text to next joke
		case R.id.btNext:
			// Toast.makeText(this, "Test Button Next",
			// Toast.LENGTH_SHORT).show();
			if (randomNumber < insultArray.length - 1) {
				randomNumber++;
			} else if (randomNumber == insultArray.length - 1) {
				randomNumber = 0;
			}
			// Convert seed to number and set to array
			tvInsultList.setText(insultArray[randomNumber].toString());
			currentInsult = insultArray[randomNumber].toString();
			break;
		case R.id.btSend: // Submit button to send email
			currentContact = atContactName.getText().toString();
			currentInsult = insultArray[randomNumber].toString();

			if (currentContact.length() == 0) {
				Toast.makeText(getApplicationContext(),
						"Please enter a phone number", Toast.LENGTH_LONG)
						.show();
			} else {
				try {
					SmsManager sm = SmsManager.getDefault();
					sm.sendTextMessage(currentContact, null, currentInsult,
							null, null);
					Toast.makeText(getApplicationContext(), "Insult Sent!",
							Toast.LENGTH_LONG).show();

				} catch (Throwable t) {
					Toast.makeText(getApplicationContext(),
							"Error sending insult, check connection ",
							Toast.LENGTH_SHORT).show();
				}
			}
			break;

		case R.id.btBrowse:

			// Intent contactPickerIntent = new Intent(Intent.ACTION_PICK,
			// Contacts.CONTENT_URI);
			// startActivityForResult(contactPickerIntent,
			// CONTACT_PICKER_RESULT);

			Intent intent = new Intent(Intent.ACTION_PICK, Phones.CONTENT_URI);
			startActivityForResult(intent, PICK_CONTACT);

			break;
		default:
			// Nothing
			break;
		}

	}

	/*
	 * protected void onActivityResult(int requestCode, int resultCode, Intent
	 * data) {
	 * 
	 * try { Uri result = data.getData(); //Log.v(DEBUG_TAG,
	 * "Got a contact result: " + result.toString());
	 * 
	 * // get the contact id from the Uri String id =
	 * result.getLastPathSegment();
	 * 
	 * cursor = getContentResolver().query( Phone.CONTENT_URI, null,
	 * Phone.CONTACT_ID + "=?", new String[]{id}, null);
	 * 
	 * // query for everything email cursor =
	 * getContentResolver().query(Phone.CONTENT_URI, null, Phone.CONTACT_ID +
	 * "=?", new String[] { id }, null);
	 * 
	 * int emailIdx = cursor.getColumnIndex(Phone.DATA);
	 * 
	 * // let's just get the first email if (cursor.moveToFirst()) { email =
	 * cursor.getString(emailIdx); //Log.v(DEBUG_TAG, "Got email: " + email); }
	 * else { //Log.w(DEBUG_TAG, "No results"); } } catch (Exception e) {
	 * //Log.e(DEBUG_TAG, "Failed to get email data", e); } finally { if (cursor
	 * != null) { cursor.close(); } EditText emailEntry = (EditText)
	 * findViewById(R.id.invite_email); emailEntry.setText(email); if
	 * (email.length() == 0) { Toast.makeText(this,
	 * "No email found for contact.", Toast.LENGTH_LONG).show(); }
	 * 
	 * }
	 * 
	 * break; }
	 * 
	 * } else { Log.w(DEBUG_TAG, "Warning: activity result not ok");
	 */

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			switch (requestCode) {
			case (PICK_CONTACT):
				Cursor cursor = null;
				String myPhone = "";
				try {
					// if (resultCode == Activity.RESULT_OK) {
					Uri myResult = data.getData();
					// get the contact id from the Uri, getLastPathSegment()
					// removes
					// content://... information
					String id = myResult.getLastPathSegment();

					atContactName.setText(id.toString());

					// Query for all phone information
					//cursor = getContentResolver().query(Phone.CONTENT_URI,
					//		null, Phone.CONTACT_ID + "=?", new String[] { id },
					//		null);
					

					// Alternatively, use the Uri method to produce the base URI.
					// It takes a string rather than an integer.
					Uri myPerson = Uri.withAppendedPath(People.CONTENT_URI, id);
					
					String[] projection = new String[] {
                            //People._ID,
                            //People._COUNT,
                            //People.NAME,
                            People.NUMBER
                         };
					
					
					// Then query for this specific record:
					cursor  = managedQuery(myPerson, projection, null, null, null);
					//cursor.moveToFirst();					
					//String message = cursor.getString(cursor.getColumnIndex(Phone.NUMBER));
					//atContactName.setText(message);
					
					myPhone = cursor.getString(cursor.getColumnIndex(Phone.NUMBER));
					atContactName.setText(myPhone);
					
					
					//int phoneIdx = cursor.getColumnIndex(Phone.DATA);
					/*
					
					int phoneIdx = cursor.getColumnIndex(Phone.NUMBER);

					// let's just get the first email
					if (cursor.moveToFirst()) {
						myPhone = cursor.getString(phoneIdx);
						
						// Log.v(DEBUG_TAG, "Got email: " + email);
					} else {
						// Log.w(DEBUG_TAG, "No results");
					}
					*/

				}

				catch (Exception e) {
					// Log.e(DEBUG_TAG, "Failed to get email data", e);
				} finally {
					if (cursor != null) {
						//atContactName.setText(myPhone);
						cursor.close();
					}

					if (myPhone.length() == 0) {
						Toast.makeText(this, "No phone found for contact.",
								Toast.LENGTH_LONG).show();
					}

				}
				// String phoneNumber = Uri.decode(myResult.toString());
				// Uri uri =
				// Uri.withAppendedPath(PhoneLookup.CONTENT_FILTER_URI,
				// Uri.encode(phoneNumber));
				// atContactName.setText(ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE);

				// Uri uri = People.CONTENT_URI;
				// atContactName.setText(data.getDataString());
				// myresolver.query(uri, null, null, null, null);
				// atContactName.setText(my_uri.toString());
				// query(uri, new String[]{PhoneLookup.DISPLAY_NAME,...

				break;
			}
		}
	}

}