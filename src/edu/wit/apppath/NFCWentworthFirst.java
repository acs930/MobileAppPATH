package edu.wit.apppath;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import edu.wit.apppath.R;

public class NFCWentworthFirst extends Activity implements OnItemSelectedListener {

	String startRoom = "Wentworth001";
	String endRoom;
	private static final String TAG = "NFCWentworthFirst";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nfcwentworth_first);
		
		Log.d(TAG, "Im in");
		
		//setting up spinners
		//Spinner startSpinner = (Spinner) findViewById(R.id.start_spinner);
		
		// Create an ArrayAdapter using the string array and a default spinner layout
		//ArrayAdapter<CharSequence> startAdapter = ArrayAdapter.createFromResource(this,R.array.room_arrays, android.R.layout.simple_spinner_item);
		ArrayAdapter<CharSequence> endAdapter = ArrayAdapter.createFromResource(this, R.array.room_arrays, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		//startAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		endAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		//startSpinner.setAdapter(startAdapter);
		//startSpinner.setOnItemSelectedListener(this);
		
		Spinner endSpinner = (Spinner) findViewById(R.id.end_spinner);
		endSpinner.setAdapter(endAdapter);
		endSpinner.setOnItemSelectedListener(this);
		
		OnClickListener listener = new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				if(findViewById(R.id.button1) == v)
				{
					Intent intent = new Intent();
					intent.setClass(NFCWentworthFirst.this, DirectionDisplay.class);
					
					Bundle bundle = new Bundle();
					bundle.putString("Start", startRoom);
					bundle.putString("Destination", endRoom);
					
					Log.d(TAG, "HelloWorld");
					intent.putExtras(bundle);
					startActivity(intent);
				}
			}
		};
		
		Button selectButton = (Button)findViewById(R.id.button1);
		selectButton.setOnClickListener(listener);
	}
	
    public void onItemSelected(AdapterView<?> parent, View view, 
            int pos, long id) {
        // An item was selected. You can retrieve the selected item using
    	switch(parent.getId())
    	{
    	case R.id.start_spinner:
    		startRoom = parent.getItemAtPosition(pos).toString();
    		break;
    	case R.id.end_spinner:
    		endRoom = parent.getItemAtPosition(pos).toString();
    		break;
    	}
        // Toast.makeText(parent.getContext(), parent.getItemAtPosition(pos).toString(), Toast.LENGTH_LONG).show();      
    }
    
	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}
}
