package edu.wit.apppath;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class SimpleAdapter extends ArrayAdapter<DirectionStep>{
	private static final String TAG = "SimpleAdapter";
    private List<DirectionStep> pathList;
    private Context context;
         
    public SimpleAdapter(List<DirectionStep> itemList, Context ctx) {
        super(ctx, android.R.layout.simple_list_item_1, itemList);
        this.pathList = itemList;
        this.context = ctx;        
    }
    
    public List<DirectionStep> getPathList() {
        return pathList;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         
        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_item, null);
        }
         Log.d(TAG,""+position);
         Log.d(TAG,"r"+pathList.size());

        DirectionStep c = pathList.get(position);
        TextView text = (TextView) v.findViewById(R.id.string);
        text.setText(c.getDirection());
 
        /*TextView text1 = (TextView) v.findViewById(R.id.building);
        text1.setText(c.getBuilding());
 
        TextView text2 = (TextView) v.findViewById(R.id.floor);
        text2.setText(c.getFloor());*/
 
        return v;
         
    }
 
    public void setPathList(List<DirectionStep> pathList) {
    	//this.pathList.clear();
    	for(int i =0; i < pathList.size(); i++){
    		this.pathList.set(i, pathList.get(i));
    	}

    }

}
