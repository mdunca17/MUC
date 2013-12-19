package map.emulator.android;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemSelectedListener, LocationListener {
	
	private GoogleMap SECC,BarBUD,CelticPark,CathkinBraes,Velodrome, 
	IntHockey, Hampden, Ibrox,KelvingroveBowls,Scoutstoun,Tollcross,Strathclyde,Edinburgh;
	private static String location,title,snippet,UserL,UserL2, provider;
	private LocationManager locationManager;
	private int mapType,loc;
	private LatLng no2;
	//private LatLng DelhiPos;
	private GoogleMap Map;
	private Spinner spinner;
	private EditText UserLocation,UserLocation2;
	private Button UserLoc; 
    private Location UserLo;
    private TextView latituteField, longitudeField;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//sets up widgets
		latituteField = (TextView) findViewById(R.id.TextView02);
	    longitudeField = (TextView) findViewById(R.id.TextView04);
		
		spinner = (Spinner) findViewById(R.id.spinner);
		UserLocation = (EditText)findViewById(R.id.UserLocation);
		UserLocation2 = (EditText)findViewById(R.id.UserLocation2);
		UserLoc = (Button)findViewById(R.id.Userloc);
		
		
		
		// Get the location manager
	    locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
	    // Define the criteria how to select the locatioin provider -> use
	    // default
	    Criteria criteria = new Criteria();
	    provider = locationManager.getBestProvider(criteria, false);
	    Location locationGPS = locationManager.getLastKnownLocation(provider);
	    
	 // Initialize the location fields
	    if (locationGPS != null) {
	      System.out.println("Provider " + provider + " has been selected.");
	      onLocationChanged(locationGPS);
	    }
		//on click for the enter location button
		UserLoc.setOnClickListener(
				new View.OnClickListener() {
					
					@Override
					public void onClick(View View) {
						//sets strings from the 
						UserL = (UserLocation.getText().toString());
						UserL2 = (UserLocation2.getText().toString());
						// takes the 2 doubles from the edit texts 
						double no2 = Double.parseDouble(UserL);
						double no = Double.parseDouble(UserL2);
						if (View == UserLoc)
						{
							// moves the camera to the location entered by using 2 doubles as lat and lng
							LatLng pos = new LatLng (no2,no);
							Map.moveCamera(CameraUpdateFactory.newLatLngZoom(pos,10));
						     //adds marker to the new location
							Map.addMarker(new MarkerOptions()
							   .title("Your Entered Location")
							   .position(pos));
						}
					}
					
				});
		
		// sets up spinner
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.View_types, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		
		spinner.setOnItemSelectedListener(this);
		
		// sets up Map
		Map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		//Map.setMapType(loc);
		Map.setMyLocationEnabled(true);
		Map.getUiSettings().setZoomControlsEnabled(true);
		Map.getUiSettings().setMyLocationButtonEnabled(true);
		
		// gets the intent to get the information required to set up the new map locations and markers
		Intent intent = getIntent();
		location = intent.getStringExtra("Pickedlocation");
		snippet = intent.getStringExtra("LocSnippet");
		title = intent.getStringExtra("PickedTitle");
		// if location not null go into loop
		if(location != null)
		{
			// delhi map values and marker
		if(location.equals("Delhi") ){
			LatLng pos = new LatLng (28.61, 77.23);
			Map.moveCamera(CameraUpdateFactory.newLatLngZoom(pos,10));
			
			
			
			Map.addMarker(new MarkerOptions()
			   .icon(BitmapDescriptorFactory.fromResource(R.drawable.delhii))
			   .title(title)
			   .snippet(snippet)
			   .position(pos));
			
		}
		
		// melbourne map values and marker
		if(location.equals("Melbourne") ){
				LatLng pos = new LatLng (-37.813611, 144.963056);
				Map.moveCamera(CameraUpdateFactory.newLatLngZoom(pos,10));
			     
				Map.addMarker(new MarkerOptions()
				.icon(BitmapDescriptorFactory.fromResource(R.drawable.melbournei))
				   .title(title)
				   .snippet(snippet)
				   .position(pos));
			}
		// manchester map values and marker
		if(location.equals("Manchester") ){
				LatLng pos = new LatLng (53.466667, -2.233333);
				Map.moveCamera(CameraUpdateFactory.newLatLngZoom(pos,10));
			     
				Map.addMarker(new MarkerOptions()
				.icon(BitmapDescriptorFactory.fromResource(R.drawable.manchesteri))
				   .title(title)
				   .snippet(snippet)
				   .position(pos));
			}
		// Kuala Lumpur map values and marker
		if(location.equals("Kuala") ){
			LatLng pos = new LatLng (3.1475, 101.693333);
			Map.moveCamera(CameraUpdateFactory.newLatLngZoom(pos,10));
		     
			Map.addMarker(new MarkerOptions()
			.icon(BitmapDescriptorFactory.fromResource(R.drawable.kualai))
			   .title(title)
			   .snippet(snippet)
			   .position(pos)); 
		}
		// Victoria map values and marker
		if(location.equals("Victoria") ){
			LatLng pos = new LatLng (48.428611, -123.365556);
			Map.moveCamera(CameraUpdateFactory.newLatLngZoom(pos,10));
		     
			Map.addMarker(new MarkerOptions()
			.icon(BitmapDescriptorFactory.fromResource(R.drawable.victoriai))
			   .title(title)
			   .snippet(snippet)
			   .position(pos));
		}
		// Auckland map values and marker
		if(location.equals("Auckland") ){
			LatLng pos = new LatLng (-36.840417, 174.739869);
			Map.moveCamera(CameraUpdateFactory.newLatLngZoom(pos,10));
		     
			Map.addMarker(new MarkerOptions()
			.icon(BitmapDescriptorFactory.fromResource(R.drawable.aucklandi))
			   .title(title)
			   .snippet(snippet)
			   .position(pos));
		}
		// Edinburgh map values and marker
		if(location.equals("Edinburgh") ){
			LatLng pos = new LatLng (55.939, -3.172);
			Map.moveCamera(CameraUpdateFactory.newLatLngZoom(pos,10));
		     
			Map.addMarker(new MarkerOptions()
			.icon(BitmapDescriptorFactory.fromResource(R.drawable.edinburghi))
			   .title(title)
			   .snippet(snippet)
			   .position(pos));
		}
		// Brisbane map values and marker
		if(location.equals("Brisbane") ){
			LatLng pos = new LatLng (-27.467917, 153.027778);
			Map.moveCamera(CameraUpdateFactory.newLatLngZoom(pos,10));
		     
			Map.addMarker(new MarkerOptions()
			.icon(BitmapDescriptorFactory.fromResource(R.drawable.brisbanei))
			   .title(title)
			   .snippet(snippet)
			   .position(pos));
		}
		// Edmonton map values and marker
		if(location.equals("Edmonton") ){
			LatLng pos = new LatLng (53.533333, -113.5);
			Map.moveCamera(CameraUpdateFactory.newLatLngZoom(pos,10));
		     
			Map.addMarker(new MarkerOptions()
			.icon(BitmapDescriptorFactory.fromResource(R.drawable.edmontoni))
			   .title(title)
			   .snippet(snippet)
			   .position(pos));
		}
		// Christchurch map values and marker
		if(location.equals("Christchurch") ){
			LatLng pos = new LatLng (-43.53, 172.620278);
			Map.moveCamera(CameraUpdateFactory.newLatLngZoom(pos,10));
		     
			Map.addMarker(new MarkerOptions()
			.icon(BitmapDescriptorFactory.fromResource(R.drawable.christchurchi))
			   .title(title)
			   .snippet(snippet)
			   .position(pos));
		}
		if(location.equals("Glasgow") ){
			LatLng pos = new LatLng (55.8580, -4.2590);
			Map.moveCamera(CameraUpdateFactory.newLatLngZoom(pos,10));
		     
		
		}
		}
		
		
		
		
		
		// Marker values and location for SECC
		SECC = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		SECC.addMarker(new MarkerOptions()
		      .position(new LatLng(55.8607,-4.2871))
		      .title("Scottish Exhibition and Conference Centre")
		      .snippet("Address: Exhibition Way, Glasgow G3 8YW, United Kingdom  Events : Boxing, Gymnastics, Judo, Netball, Wrestling and Weightlifting")
		      .icon(BitmapDescriptorFactory.fromResource(R.drawable.weight)));
		// Marker values and location for Barry Buddon shooting centre
		BarBUD = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		BarBUD.addMarker(new MarkerOptions()
		      .position(new LatLng(56.499,-2.7543))
		      .title("Barry Buddon Shooting Centre")
		      .snippet("Address: Barry Angus, Dundee, United Kingdom   Events : Shooting")
		      .icon(BitmapDescriptorFactory.fromResource(R.drawable.shooting)));
		// Marker values and location for celtic park
		CelticPark = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		CelticPark.addMarker(new MarkerOptions()
		      .position(new LatLng(55.8497,-4.2055))
		      .title("Celtic Park")
		      .snippet("Address: Celtic Park, Glasgow,G40 3RE,United Kingdom  Events : Opening Ceremony")
		      .icon(BitmapDescriptorFactory.fromResource(R.drawable.stadium)));
		// Marker values and location for Cathkin Braes Mountain bike trails
		CathkinBraes = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		CathkinBraes.addMarker(new MarkerOptions()
		      .position(new LatLng(55.79434,-4.2193))
		      .title("Cathkin Braes Mountain Bike Trails")
		      .snippet("Address: Cathkin Braes Country Park, Cathkin Road ,Glasgow G45, United Kingdom  Events : Mountain Bike")
		      .icon(BitmapDescriptorFactory.fromResource(R.drawable.bicycle)));
		// Marker values and location for Veldrome
		Velodrome = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		Velodrome.addMarker(new MarkerOptions()
		      .position(new LatLng(55.847,-4.2076))
		      .title("Emirates Arena including the Sir Chris Hoy Velodrome")
		      .snippet("Address: 1000 London Rd, Glasgow G40 3HY, United Kingdom Events : Cycling and Badminton")
		      .icon(BitmapDescriptorFactory.fromResource(R.drawable.cycling)));
		// Marker values and location for National Hockey Centre
		IntHockey = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		IntHockey.addMarker(new MarkerOptions()
		      .position(new LatLng(55.8447,-4.2193))
		      .title("Glasgow National Hockey Centre")
		      .snippet("Address: Glasgow Green, Glasgow G1 5DB, United Kingdom Events : Hockey")
		      .icon(BitmapDescriptorFactory.fromResource(R.drawable.fieldhockey)));
		// Marker values and location for Hampden park
		Hampden = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		Hampden.addMarker(new MarkerOptions()
		      .position(new LatLng(55.8255,-4.2520))
		      .title("Hampden Park")
		      .snippet("Address: Letherby Dr, Glasgow G42 9BA, United Kingdom Events : Atheltics")
		      .icon(BitmapDescriptorFactory.fromResource(R.drawable.athletics)));
		// Marker values and location for Ibrox Stadium
		Ibrox = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		Ibrox.addMarker(new MarkerOptions()
		      .position(new LatLng(55.853,-4.309))
		      .title("Ibrox Stadium")
		      .snippet("Address: 150 Edmiston Dr, Glasgow, Lanarkshire G51 2XD, United Kingdom Events : Rugby Sevens")
		      .icon(BitmapDescriptorFactory.fromResource(R.drawable.rugbysevens)));
		// Marker values and location for Kelvingrove park Bowling Green
		KelvingroveBowls = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		KelvingroveBowls.addMarker(new MarkerOptions()
		      .position(new LatLng(55.867,-4.2871))
		      .title("Kelvingrove Lawn Bowls Centre")
		      .snippet("Address: Kelvingrove Park Bowling Green, Kelvin Way, Glasgow, G3 7TA, United Kingdom Events : Lawn Bowls")
		      .icon(BitmapDescriptorFactory.fromResource(R.drawable.bowl)));
		// Marker values and location for Scoutstoun
		Scoutstoun = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		Scoutstoun.addMarker(new MarkerOptions()
		      .position(new LatLng(55.8813,-4.3405))
		      .title("Scotstoun Sports Campus")
		      .snippet("Address: 72 Duncan Ave, Glasgow, Glasgow City G14 9HD, United Kingdom Events : Squash and TableTennis")
		      .icon(BitmapDescriptorFactory.fromResource(R.drawable.tabletennis)));
		// Marker values and location for Tollcross Swimming Centre
		Tollcross = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		Tollcross.addMarker(new MarkerOptions()
		      .position(new LatLng(55.845,-4.177))
		      .title("Tollcross International Swimming Centre")
		      .snippet("Address: 367 Wellshot Rd, Glasgow G32 7QP, United Kingdom Events : Swimming")
		      .icon(BitmapDescriptorFactory.fromResource(R.drawable.swimming)));
		// Marker values and location for Strathclyde country park
		Strathclyde = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		Strathclyde.addMarker(new MarkerOptions()
		      .position(new LatLng(55.7971971,-4.0342997))
		      .title("Strathclyde Country Park")
		      .snippet("Address: Strathclyde Country Park, 366 Hamilton Road, Motherwell ML1 3ED, United Kingdom Events : Triathlon")
		      .icon(BitmapDescriptorFactory.fromResource(R.drawable.triathlon)));
		// Marker values and location for Royal commonwealth pool
		Edinburgh = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		Edinburgh.addMarker(new MarkerOptions()
		      .position(new LatLng(55.939,-3.172))
		      .title("Royal Commonwealth Pool")
		      .snippet("Address: 21 Dalkeith Rd, Edinburgh, Midlothian EH16 5BB, United Kingdom Events : Diving")
		      .icon(BitmapDescriptorFactory.fromResource(R.drawable.diving)));
		
		
		
		
		}
	
	// Starts previousGamesActivity when a button is pressed by sending a message
	public void sendMessage(View View){
		
		Intent intent = new Intent(this, PreviousGamesActivity.class);
		startActivity(intent);
	}
	
	// Creates a options menu to hold the two buttons for help and diary
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	// Gets the item that is selected by id
    public boolean onOptionsItemSelected(MenuItem item)
    {
    	switch (item.getItemId()){
    	case R.id.Diary:
    		startActivity(new Intent(this, Diary.class));
    	return true;
    	case R.id.Help:
    		startActivity(new Intent(this, Help.class));
    	return true;
    	default:
    		return super.onOptionsItemSelected(item);
    	}
    }
    //checks what item is selected for the spinner and changes map to which ever one that is
	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int pos,
			long id) {
		
		
		//
		if (spinner.getSelectedItem().toString().equals("Normal"))
	    {
			//changes map type to normal
			Map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			
	    }
		if (spinner.getSelectedItem().toString().equals("Hybrid"))
		{
			//changes map type to hybrid
			Map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
			
		}
		if (spinner.getSelectedItem().toString().equals("Satellite"))
		{
			//changes map type to satellite
			Map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
			
		}
		if (spinner.getSelectedItem().toString().equals("Terrain"))
		{
			//changes map type to terrain
			Map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
			
		}
		
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		
		
	}
	/* Request updates at startup */
	  @Override
	  protected void onResume() {
	    super.onResume();
	    locationManager.requestLocationUpdates(provider, 400, 1, this);
	  }

	  /* Remove the locationlistener updates when Activity is paused */
	  @Override
	  protected void onPause() {
	    super.onPause();
	    locationManager.removeUpdates(this);
	  }
	  //sets the lat and lng of device
	  @Override
	  public void onLocationChanged(Location location) {
	    int lat = (int) (location.getLatitude());
	    int lng = (int) (location.getLongitude());
	    //latituteField.setText(String.valueOf(lat));
	    //longitudeField.setText(String.valueOf(lng));
	  }


	  @Override
	  public void onProviderDisabled(String provider) {
	    Toast.makeText(this, "Disabled provider " + provider,
	        Toast.LENGTH_SHORT).show();
	  }


	@Override
	  public void onProviderEnabled(String provider) {
	    Toast.makeText(this, "Enabled new provider " + provider,
	        Toast.LENGTH_SHORT).show();

	  }


	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}

}
