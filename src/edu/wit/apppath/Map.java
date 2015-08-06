package edu.wit.apppath;

import java.util.HashMap;

import com.polites.android.GestureImageView;

import edu.wit.apppath.R.drawable;
import edu.wit.apppath.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
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
		String chosenFloor;
		
		Bundle bundle = this.getIntent().getExtras();
		if(bundle.get("Building") != null)
		{
			chosenFloor = bundle.getString("Building") + bundle.getString("Floor");
			Log.d("MapActivity",chosenFloor);
			
		}
		else{
			chosenFloor  = bundle.getString("Floor");
		}
		HashMap<String, Integer> floors = new HashMap<String, Integer>();
		
		floors.put("Ground Floor", R.drawable.main_building_floor0);
		floors.put("Floor 1", R.drawable.main_building_floor1);
		floors.put("Floor 2", R.drawable.main_building_floor2);
		floors.put("Floor 3", R.drawable.main_building_floor3);
		floors.put("DobbsGround Floor", R.drawable.dobbs_00);
		floors.put("DobbsFloor 1", R.drawable.dobbs_01);
		floors.put("DobbsFloor 2", R.drawable.dobbs_02);
		floors.put("DobbsFloor 3", R.drawable.dobbs_03);
		floors.put("KingmanGround Floor", R.drawable.kingman_01);
		floors.put("KingmanFloor 1", R.drawable.kingman_02);
		floors.put("RubensteinFloor 2", R.drawable.rubenstein_00);
		floors.put("RubensteinFloor 3", R.drawable.rubenstein_01);
		floors.put("RubensteinGround Floor", R.drawable.rubenstein_02);
		floors.put("WatsonGround Floor", R.drawable.watson_00);
		floors.put("WatsonFloor 1", R.drawable.watson_01);
		floors.put("WatsonFloor 2", R.drawable.watson_02);
		floors.put("WentworthGround Floor", R.drawable.wentworth_00);
		floors.put("WentworthFloor 1", R.drawable.wentworth_01);
		floors.put("WentworthFloor 2", R.drawable.wentworth_02);
		floors.put("WentworthFloor 3", R.drawable.wentworth_03);
		floors.put("WillistonGround Floor", R.drawable.williston_00);
		floors.put("WillistonFloor 1", R.drawable.williston_01);
		floors.put("WillistonFloor 2", R.drawable.williston_02);
		floors.put("WillistonFloor 3", R.drawable.williston_03);
		floors.put("WillsonFloor 1", R.drawable.wilson_01);
		floors.put("WillsonFloor 2", R.drawable.wilson_02);
		

			Integer finalChosenFloor = floors.get(chosenFloor);
		
		
		mapFloor.setImageResource(finalChosenFloor);
		
	}
}
