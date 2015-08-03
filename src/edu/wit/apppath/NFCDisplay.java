package edu.wit.apppath;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class NFCDisplay extends Activity implements AsyncResponse{

	private static final String TAG = "DirectionDisplay";
	String thePath;
	TextView outputPath;
	SimpleAdapter adpt;// = new SimpleAdapter(new ArrayList<DirectionStep>(), this);
	Button nfcButton;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_direction_display);
		
		Bundle bundle = this.getIntent().getExtras();
		String startRoom  = bundle.getString("Start");
		String endRoom  = bundle.getString("Destination");
		
		
		startRoom = startRoom.replaceAll("\\s+","");
		endRoom = endRoom.replaceAll("\\s+", "");
		
		startRoom = startRoom.replace("Hall", "");
		endRoom = endRoom.replace("Hall", "");
		
		
		Log.d(TAG, startRoom);
		Log.d(TAG, endRoom);
		
		
	    
        adpt  = new SimpleAdapter(new ArrayList<DirectionStep>(25), this);

        ListView lView = (ListView) findViewById(R.id.directionsList);
         
        lView.setAdapter(adpt);
        
        for(int i =0; i < 10; i++){
        	adpt.add(new DirectionStep("", "", 0));
        }
        
        (new RetrieveDirectionPath()).execute("http://www.bidme.io/path.php?s=" + startRoom + "&e=" + endRoom);
        

			OnClickListener listener = new View.OnClickListener() {
				@Override
				public void onClick(View v) {

					if(findViewById(R.id.nfcButton) == v)
					{
						//Log.d(TAG, lView.getItemAtPosition(0).toString());
						//Intent intent = new Intent();
						//intent.setClass(DirectionDisplay.this, NFC.class);
						
						//startActivity(intent);
					}
				}
			};
			
			nfcButton = (Button)findViewById(R.id.nfcButton);
			nfcButton.setOnClickListener(listener);
	        
            // ListView Item Click Listener
	       /* lView.setOnItemClickListener(new OnItemClickListener() {
 
                  @Override
                  public void onItemClick(AdapterView<?> parent, View view,
                     int position, long id) {
                    
                   // ListView Clicked item index
                   int itemPosition     = position;
                   
                   // ListView Clicked item value
                   String  itemValue    = (String) parent.getItemAtPosition(position);
                      
                    // Show Alert 
                    Toast.makeText(getApplicationContext(),
                      "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                      .show();
                 
                  }
    
             }); */

	       

	}

	
	  private class RetrieveDirectionPath extends AsyncTask<String, Void, List<DirectionStep>> {
		  
		    @Override
		    protected List<DirectionStep> doInBackground(String... params) {
		      String response = "";
		      List<DirectionStep> theDirections = new ArrayList<DirectionStep>(); ;
		        DefaultHttpClient client = new DefaultHttpClient();
		        HttpGet httpGet = new HttpGet(params[0]);
		        try {
		          HttpResponse execute = client.execute(httpGet);
		          InputStream content = execute.getEntity().getContent();
		          Log.d(TAG, "executing");
		          BufferedReader buffer = new BufferedReader(new InputStreamReader(content));
		          String s = "";
		          while ((s = buffer.readLine()) != null) {
		            response += s;
		            Log.d(TAG, "gettting response");
		          }
		        
	            JSONArray arr = new JSONArray(response);
	            Log.d(TAG, "h" + arr.length());
	            for (int i=0; i < arr.length(); i++) {
	                theDirections.add(convertStep(arr.getJSONObject(i)));
	               
	            }
		        } catch (Exception e) {
			          e.printStackTrace();
			    }
		      
		      //This is gonna be a json message
		      
		      return theDirections;
		    }
		    
		    private DirectionStep convertStep(JSONObject obj) throws JSONException {
		    	//Log.d(TAG,obj.getString("floor").toString());
		        String string = obj.getString("string");
		        String building = obj.getString("building");
		        int floor = obj.getInt("floor");
		        
		         
		        return new DirectionStep(string, building, floor);
		    }

		    protected void onPostExecute(List<DirectionStep> result) {
		    	//outputPath.setText(result);
		    	//delegate.processFinish(result);
		    	//findViewById(R.id.directionsList);
		    	adpt.setPathList(result);
		    	adpt.notifyDataSetChanged();
		    	
		    	
		    	Log.d(TAG, result.get(0).getDirection());
		    	Log.d(TAG, "woot");
		    	
		    }
		    
		    @Override
		    protected void onPreExecute() {        
		        super.onPreExecute();
		        Toast.makeText(getApplicationContext(), "Downloading Directions", Toast.LENGTH_SHORT).show();
		                   
		    }
		  }


	@Override
	public void processFinish(String output) {
		
	}
	



}
