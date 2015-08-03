package edu.wit.apppath;

import java.util.HashMap;

import com.polites.android.GestureImageView;

import edu.wit.apppath.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class NFCLocation extends Activity {
	
	GestureImageView mapFloor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nfclocation);
		mapFloor = (GestureImageView)findViewById(R.id.image);
		
		Bundle bundle = this.getIntent().getExtras();
		String chosenFloor  = bundle.getString("Floor");
		HashMap<String, Integer> floors = new HashMap<String, Integer>();
		
		floors.put("Ground Floor", R.drawable.png_ground);
		floors.put("Floor 1", R.drawable.png_first);
		floors.put("Floor 2", R.drawable.png_second);
		floors.put("Floor 3", R.drawable.png_third);
		
		Integer finalChosenFloor = floors.get(chosenFloor);
		
		mapFloor.setImageResource(finalChosenFloor);
		
	}
}
