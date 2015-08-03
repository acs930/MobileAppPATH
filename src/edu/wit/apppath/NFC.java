package edu.wit.apppath;

import android.app.Activity;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import edu.wit.apppath.R;

public class NFC extends Activity implements OnItemSelectedListener {
	
	String chosenFloor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nfc);

		NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(this);

		if (nfcAdapter != null && nfcAdapter.isEnabled()) {
			Toast.makeText(this, "NFC available!", Toast.LENGTH_LONG).show();
		} else {
			Toast.makeText(this, "NFC not available!", Toast.LENGTH_LONG).show();
		}
		
		Spinner spinner = (Spinner) findViewById(R.id.floor_spinner);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.floor_array, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);
		
		OnClickListener listener = new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				if(findViewById(R.id.button1) == v)
				{
					Intent intent = new Intent();
					intent.setClass(NFC.this, NFCLocation.class);
					
					Bundle bundle = new Bundle();
					bundle.putString("Floor", chosenFloor);
					
					intent.putExtras(bundle);
					startActivity(intent);
				}
			}
		};
		
		Button nextButton = (Button)findViewById(R.id.button1);
		nextButton.setOnClickListener(listener);
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}
	
	public void onItemSelected(AdapterView<?> parent, View view, 
            int pos, long id) {
        // An item was selected. You can retrieve the selected item using
         Toast.makeText(parent.getContext(), parent.getItemAtPosition(pos).toString(), Toast.LENGTH_LONG).show(); 
         chosenFloor = parent.getItemAtPosition(pos).toString();
    }

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}
}
