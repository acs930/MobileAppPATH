package edu.wit.apppath;

import java.util.HashMap;
import com.polites.android.GestureImageView;
import edu.wit.apppath.R.drawable;
import edu.wit.apppath.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Map extends Activity {
	GestureImageView mapFloor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		mapFloor = (GestureImageView)findViewById(R.id.image);
		
		Bundle bundle = this.getIntent().getExtras();
		String chosenFloor  = bundle.getString("Floor");
		HashMap<String, Integer> floors = new HashMap<String, Integer>();
		
		floors.put("Ground Floor", R.drawable.main_building_floor0);
		floors.put("Floor 1", R.drawable.main_building_floor1);
		floors.put("Floor 2", R.drawable.main_building_floor2);
		floors.put("Floor 3", R.drawable.main_building_floor3);
		
		Integer finalChosenFloor = floors.get(chosenFloor);
		
		mapFloor.setImageResource(finalChosenFloor);
		
	}
}
