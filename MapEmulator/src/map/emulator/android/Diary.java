package map.emulator.android;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ArrayAdapter;

public class Diary extends Activity implements OnClickListener, OnKeyListener,OnItemSelectedListener, OnItemLongClickListener {
	
	ArrayAdapter<String> Entrys,Venue;
	 
	 
	private Button Back, AddEntry;
	private EditText Entry;
	private TextView Text;
	private ListView EntryList;
	private Date dates;
	private Spinner VenueSpinner;
	private String venue;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.diary);
		
		Back = (Button) findViewById(R.id.back);
		AddEntry = (Button) findViewById(R.id.AddEntry);
		Entry = (EditText) findViewById(R.id.diaryEntry);
		Text = (TextView) findViewById(R.id.textView1);
	    EntryList = (ListView)findViewById(R.id.listView1);
		
		Back.setOnClickListener(this);
		AddEntry.setOnClickListener(this);
		
		VenueSpinner = (Spinner) findViewById(R.id.Vspinner);
		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Venues, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		VenueSpinner.setAdapter(adapter);
		
		VenueSpinner.setOnItemSelectedListener(this);
		
		
        
		
		
		Venue = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
		Entrys = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
		EntryList.setAdapter(Venue);
		EntryList.setAdapter(Entrys);
		
	}
	private void addEntry(String item){

		DateFormat dateFormat = new SimpleDateFormat("EEEE/dd/MMMM HH:mm");
        
 	    
        Calendar cal = Calendar.getInstance();
		
	if (item.length()>0){
			this.Entrys.add(dateFormat.format(cal.getTime())+ "\n \n" + "I Visited the " + venue +"\n" + item);
			this.Entrys.notifyDataSetChanged();
			this.Entry.setText("\n ");
			
		}
	
	}
	
	@Override
	public void onClick(View V) {
		// TODO Auto-generated method stub
		
	if(V == this.AddEntry){
			this.addEntry(this.Entry.getText().toString());
			//this.addEntry(this.venue);
		}
	if (V == Back){
		
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
	}
	
	 public boolean onKey(View v, int keyCode, KeyEvent event) {

	        if (event.getAction()==KeyEvent.ACTION_DOWN &&   
	                keyCode==KeyEvent.KEYCODE_DPAD_CENTER)
	            this.addEntry(this.Entry.getText().toString());
	        

	        return false;
	   }
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		if (VenueSpinner.getSelectedItem().toString().equals("SECC"))
	    {
	        venue = "SECC";
	    }
		if (VenueSpinner.getSelectedItem().toString().equals("Barry Buddon Shooting Centre"))
	    {
			venue = "Barry Buddon Shooting Centre";
	    }
		if (VenueSpinner.getSelectedItem().toString().equals("Celtic Park"))
	    {
			venue = "Celtic Park";
	    }
		if (VenueSpinner.getSelectedItem().toString().equals("Cathkin Braes Mountain Bike Trails"))
	    {
			venue = "Cathkin Braes Mountain Bike Trails";
	    }
		if (VenueSpinner.getSelectedItem().toString().equals("Velodrome"))
	    {
			venue = "Velodrome";
	    }
		if (VenueSpinner.getSelectedItem().toString().equals("National Hockey Centre"))
	    {
			venue = "National Hockey Centre";
	    }
		if (VenueSpinner.getSelectedItem().toString().equals("Hampden Park"))
	    {
			venue = "Hampden Park";
	    }
		if (VenueSpinner.getSelectedItem().toString().equals("Ibrox Stadium"))
	    {
			venue = "Ibrox Stadium";
	    }
		if (VenueSpinner.getSelectedItem().toString().equals("Kelvingrove Lawn Bowls Centre"))
	    {
			venue = "Kelvingrove Lawn Bowls Centre";
	    }
		if (VenueSpinner.getSelectedItem().toString().equals("Scotstoun Sports Campus"))
	    {
			venue = "Scotstoun Sports Campus";
	    }
		if (VenueSpinner.getSelectedItem().toString().equals("Tollcross International Swimming Centre"))
	    {
			venue = "Tollcross International Swimming Centre";
	    }
		if (VenueSpinner.getSelectedItem().toString().equals("Strathclyde Country Park"))
	    {
	       venue = "Strathclyde Country Park";
	    }
		if (VenueSpinner.getSelectedItem().toString().equals("Royal Commonwealth"))
	    {
			venue = "Royal Commonwealth";
	    }
	}
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View V, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		//Entrys.remove(venue);
		//Entry.remove(item);
		
		return false;
	}

}
