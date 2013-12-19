package map.emulator.android;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Help extends Activity {
	
	private TextView Text;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help);
		
		Text = new TextView(this);
		Text =(TextView) findViewById(R.id.text);
		
		Text.setText("This is a small guide to help you use this software.\n" +
				     "\nTo get information from the markers all you have to do is click on them easy as that."+
				"\n\nTo change location to a previous hosts just click on the previous games button and\nthen click on the button that represents your desired location" +
				     "\nTo use the diary just click the options menu button at top right of screen its the 3 dots, use this to select diary." + 
				"\n\nTo use the diary just select the venue and then enter your text about it and then click add the date and type are added automatically." + 
				     "\nTo enter a location just enter a lat and lng like 22.3 and then press the button and this will take you to the location." +
				"\n\nIt is also possible to get your current location by pressing the gps button on the first screen, there is also buttons to zoom in and out there too " +
				     "\n\nTo go back to the application just press the back button on your device.");
		
	}



}
