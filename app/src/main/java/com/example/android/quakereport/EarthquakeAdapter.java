package com.example.android.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake>{
    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes){
        super(context, 0, earthquakes);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        //Get the current earthquake
        Earthquake currentEarthquake = getItem(position);
        //Get the part of the view for the magnitude
        TextView magTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        //Set textview content
        magTextView.setText(currentEarthquake.getMagnitude());

        //Get the part of the view for the location
        TextView locTextView = (TextView) listItemView.findViewById(R.id.city);
        //Set textview content
        locTextView.setText(currentEarthquake.getCity());

        //Get the part of the view for the date
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        //Set textview content
        dateTextView.setText(currentEarthquake.getDate());

        return listItemView;
    }
}
