package com.wliu.cdcfluaware;



import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;


import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;

public class SectionFour extends MapActivity {
	
	private MapView myMap = null;
	private LocationManager locManager;
	private LocationListener locListener;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sectionfour);
		
		initMap();
		initLocationManager();	
		initFluLocations();  // Find Nearest Flu Locations
		
		/*    	
		//Test
		Geocoder geocoder = new Geocoder(this, Locale.getDefault());
		double lat = 0;
		double lng = 0;
		try {
			List<Address> addresses = geocoder.getFromLocation(lat, lng, 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.v("Map Activity", "Lat " + lat + " Lng" + lng);
		Toast.makeText(getApplicationContext(), "Lat " + lat + " Lng" + lng, Toast.LENGTH_SHORT).show();
		//End Test*/
			
	}
	
	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	
	// Setup Map
	private void initMap() {
    	// Initialize the map and enables built in Zoom Controls
       
		myMap = (MapView) findViewById(R.id.mapview);  // Set MapView
        myMap.setBuiltInZoomControls(true);  // Allows zooming in and out of map
        myMap.getController().setZoom(14);  // Set initial zoom level
        
        //myMap.displayZoomControls(true);	// Display the zoom controls by default
        //myMap.getController().setZoom(10);  // Set initial zoom level
		
	}
	
	// Get Location
	private void initLocationManager() {
    	//Initializes the Location Manager
		locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		
		locListener = new LocationListener() {
			public void onLocationChanged(Location newLocation){
				//createAndShowMyItemizedOverlay(newLocation);
			}
			public void onProviderDisabled(String arg0){
			}
			public void onProviderEnabled(String arg0){
			}
			public void onStatusChanged(String arg0, int arg1, Bundle arg2){
			}
		};
		locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locListener);
		

	}
	
	// Get closest Flu Locations
	private void initFluLocations() {
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=flu immunization"));
    	//Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?saddr=&daddr=flu vaccination"));
    	startActivity(intent);
    	//myMap.getController().setZoom(10);
    	
	}

	@Override
	public void onResume()
	{
		super.onResume();
		//myLocOverlay.enableCompass();
		
	}
	
	@Override
	public void onPause()
	{
		super.onPause();
		//myLocOverlay.disableCompass();
	}
	
    @Override
    protected void onStart() {
        super.onStart();
        // The activity is about to become visible.
    }
    @Override
    protected void onStop() {
        super.onStop();
        // The activity is no longer visible (it is now "stopped")
        locManager.removeUpdates(locListener);
        //locManager.removeUpdates(myLocOverlay);
        this.finish();

        
    }
	
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // The activity is about to be destroyed.
        locManager.removeUpdates(locListener);
        this.finish();
        
		//Intent myIntent = new Intent(SectionFour.this, MainActivity.class);
		//SectionFour.this.startActivity(myIntent);
        
        //locManager.removeUpdates(locListener);
        //locManager.removeUpdates(myLocOverlay);
        
        
    }
    
    /*
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (Integer.parseInt(android.os.Build.VERSION.SDK) < 5
                && keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {
            //Log.d("CDA", "onKeyDown Called");
            onBackPressed();
        }

        return super.onKeyDown(keyCode, event);
    } 
    
    @Override
    public void onBackPressed(){
		Intent myIntent = new Intent(SectionFour.this, MainActivity.class);
		SectionFour.this.startActivity(myIntent);
    	
    	return;
    }
	*/

	
}