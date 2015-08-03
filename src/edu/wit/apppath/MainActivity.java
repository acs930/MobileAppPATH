package edu.wit.apppath;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import edu.wit.apppath.R;

public class MainActivity extends Activity {

	private Button mapButton, dirButton, nfcButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		OnClickListener listener = new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				if(findViewById(R.id.map) == v)
				{
					Intent intent = new Intent();
					intent.setClass(MainActivity.this, FloorSelect.class);
					startActivity(intent);
				}
				else if(findViewById(R.id.direction) == v)
				{
					Intent intent = new Intent();
					intent.setClass(MainActivity.this, Directions.class);
					startActivity(intent);
				}
				else if (findViewById(R.id.nfc) == v)
				{
					Intent intent = new Intent();
					intent.setClass(MainActivity.this, NFC.class);
					startActivity(intent);
				}
				
			}
		};
		
		mapButton = (Button)findViewById(R.id.map);
		dirButton = (Button)findViewById(R.id.direction);
		nfcButton = (Button)findViewById(R.id.nfc);
		
		mapButton.setOnClickListener(listener);
		dirButton.setOnClickListener(listener);
		nfcButton.setOnClickListener(listener);
		
		
	}
}

