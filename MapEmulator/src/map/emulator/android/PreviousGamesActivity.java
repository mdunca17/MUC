package map.emulator.android;


import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class PreviousGamesActivity extends Activity implements OnClickListener {
	
	private ImageButton DelhiButton, MelbourneButton, ManchesterButton,KLumpurButton,VictoriaButton,AucklandButton,
				   EdinburghButton,BrisbaneButton,EdmontonButton,ChristchurchButton, BackToGlasgow;
	private String PreGame, Delhi;
	
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_previous_games);
		//sets up the intent to get information for previous games location
		Intent intent = getIntent();
		
		
		DelhiButton = (ImageButton) findViewById(R.id.Delhi);
		MelbourneButton = (ImageButton) findViewById(R.id.Melbourne);
		ManchesterButton = (ImageButton) findViewById(R.id.Manchester);
		KLumpurButton = (ImageButton) findViewById(R.id.KualaLumpur);
		VictoriaButton = (ImageButton) findViewById(R.id.Victoria);
		AucklandButton = (ImageButton) findViewById(R.id.Auckland);
		EdinburghButton = (ImageButton) findViewById(R.id.Edinburgh);
		BrisbaneButton = (ImageButton) findViewById(R.id.Brisbane);
		EdmontonButton = (ImageButton) findViewById(R.id.Edmonton);
		ChristchurchButton = (ImageButton) findViewById(R.id.Christchurch);
		BackToGlasgow = (ImageButton) findViewById(R.id.Back);
		
		DelhiButton.setOnClickListener(this);
		MelbourneButton.setOnClickListener(this);
		ManchesterButton.setOnClickListener(this);
		KLumpurButton.setOnClickListener(this);
		VictoriaButton.setOnClickListener(this);
		AucklandButton.setOnClickListener(this);
		EdinburghButton.setOnClickListener(this);
		BrisbaneButton.setOnClickListener(this);
		EdmontonButton.setOnClickListener(this);
		ChristchurchButton.setOnClickListener(this);
		BackToGlasgow.setOnClickListener(this);
		
	}

	public void onClick(View v) {
	
		// if button pressed put information for Delhi in Intent the start main activity
		if (v == DelhiButton) {

			Intent intent = new Intent(v.getContext(), MainActivity.class);

			intent.putExtra("Pickedlocation", "Delhi");
			intent.putExtra("PickedTitle","Delhi");
			intent.putExtra("LocSnippet", "India, Delhi, 2010, Scotland won 26 Medals at these games");
			
			startActivityForResult(intent, 0);

		}
		// if button pressed put information for Melbourne in Intent
        if (v == MelbourneButton) {

			Intent intent = new Intent(v.getContext(), MainActivity.class);

			intent.putExtra("Pickedlocation", "Melbourne");
			intent.putExtra("PickedTitle","Melbourne");
			intent.putExtra("LocSnippet", "Australia, Melbourne, 2006, Scotland won 29 Medals at these games");
			startActivityForResult(intent, 0);

		}
        // if button pressed put information for Manchester in Intent
        if (v == ManchesterButton) {
			
			Intent intent = new Intent(v.getContext(), MainActivity.class);

			intent.putExtra("Pickedlocation", "Manchester");
			intent.putExtra("PickedTitle","Manchester");
			intent.putExtra("LocSnippet","England, Manchester, 2002, Scotland won 29 Medals at these games");
			startActivityForResult(intent, 0);

		}
        // if button pressed put information for Kuala Lumpur in Intent
        if (v == KLumpurButton) {

			Intent intent = new Intent(v.getContext(), MainActivity.class);

			intent.putExtra("Pickedlocation", "Kuala");
			intent.putExtra("PickedTitle","Kuala Lumpur");
			intent.putExtra("LocSnippet", "Malaysia,Kuala Lumpur, 1998, Scotland won 12 Medals at these games");
			startActivityForResult(intent, 0);

		}
        // if button pressed put information for Victoria in Intent
        if (v == VictoriaButton) {

			Intent intent = new Intent(v.getContext(), MainActivity.class);

			intent.putExtra("Pickedlocation", "Victoria");
			intent.putExtra("PickedTitle","Victoria");
			intent.putExtra("LocSnippet", "Canada, Victoria, 1994, Scotland won 20 Medals at these games");
			startActivityForResult(intent, 0);

		} 
        // if button pressed put information for Auckland in Intent
        if (v == AucklandButton) {

			Intent intent = new Intent(v.getContext(), MainActivity.class);

			intent.putExtra("Pickedlocation", "Auckland");
			intent.putExtra("PickedTitle","Auckland");
			intent.putExtra("LocSnippet", "New Zealand, Auckland, 1990, Scotland won 22 Medals at these games");
			startActivityForResult(intent, 0);

		}
        // if button pressed put information for Edinburgh in Intent
        if (v == EdinburghButton) {

			Intent intent = new Intent(v.getContext(), MainActivity.class);

			intent.putExtra("Pickedlocation", "Edinburgh");
			intent.putExtra("PickedTitle","Edinburgh");
			intent.putExtra("LocSnippet","Scotland, Edinburgh, 1986, Scotland won 33 Medals at these games");
			startActivityForResult(intent, 0);

		} 
        if (v == BrisbaneButton) {

			Intent intent = new Intent(v.getContext(), MainActivity.class);

			intent.putExtra("Pickedlocation", "Brisbane");
			intent.putExtra("PickedTitle","Brisbane");
			intent.putExtra("LocSnippet", "Australia, Brisbane, 1982, Scotland won 26 Medals at these games");
			startActivityForResult(intent, 0);

		} 
        if (v == EdmontonButton) {

			Intent intent = new Intent(v.getContext(), MainActivity.class);

			intent.putExtra("Pickedlocation", "Edmonton");
			intent.putExtra("PickedTitle","Edmonton");
			intent.putExtra("LocSnippet", "Canada, Edmonton, 1978, Scotland won 14 Medals at these games");
			startActivityForResult(intent, 0);

		} 
        if (v == ChristchurchButton) {

			Intent intent = new Intent(v.getContext(), MainActivity.class);

			intent.putExtra("Pickedlocation", "Christchurch");
			intent.putExtra("PickedTitle","Christchurch");
			intent.putExtra("LocSnippet", "New Zealand, Christchurch, 1974, Scotland won 19 Medals at these games");
			startActivityForResult(intent, 0);

		} 
        if (v == BackToGlasgow) {

			Intent intent = new Intent(v.getContext(), MainActivity.class);

			intent.putExtra("Pickedlocation", "Glasgow");
			
			startActivityForResult(intent, 0);

		} 
        
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.previous_games, menu);
		return true;
	}

}
