package com.example.android.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;

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

        //Magnitude
        TextView magTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        magTextView.setText(currentEarthquake.getMagnitude());

        //Location
        TextView locTextView = (TextView) listItemView.findViewById(R.id.city);
        locTextView.setText(currentEarthquake.getCity());

        //Date
        Date dateObj = new Date(currentEarthquake.getTime());

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM DD, yyyy");
        String dateToDisplay = dateFormat.format(dateObj);

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        dateTextView.setText(dateToDisplay);
        //dateTextView.setText(currentEarthquake.getDate());

        //Time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);

        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        String formattedTime = timeFormat.format(dateObj);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);


        return listItemView;
    }
}
