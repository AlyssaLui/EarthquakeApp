package com.example.android.quakereport;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.graphics.drawable.GradientDrawable;

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
        DecimalFormat formatter = new DecimalFormat("0.0");
        String output = formatter.format(currentEarthquake.getMagnitude());
        magTextView.setText(output);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        //Location
        TextView offsetTextView = (TextView) listItemView.findViewById(R.id.offset);
        TextView locTextView = (TextView) listItemView.findViewById(R.id.location);
        String location = currentEarthquake.getCity();
        String offset = "";
        String city = "";
        int index = location.indexOf("of");
        if(index != -1){
            offset = location.substring(0, index+2);
            city = location.substring(index+2);
        }
        else{
            city = "Near the " + location;
        }

        offsetTextView.setText(offset);
        locTextView.setText(city);


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

    private int getMagnitudeColor(double mag){
        int color;
        int roundedMag = (int)Math.floor(mag);
        switch (roundedMag){
            case 1:
                color = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;
            case 2:
                color = ContextCompat.getColor(getContext(), R.color.magnitude2);
                break;
            case 3:
                color = ContextCompat.getColor(getContext(), R.color.magnitude3);
                break;
            case 4:
                color = ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;
            case 5:
                color = ContextCompat.getColor(getContext(), R.color.magnitude5);
                break;
            case 6:
                color = ContextCompat.getColor(getContext(), R.color.magnitude6);
                break;
            case 7:
                color = ContextCompat.getColor(getContext(), R.color.magnitude7);
                break;
            case 8:
                color = ContextCompat.getColor(getContext(), R.color.magnitude8);
                break;
            case 9:
                color = ContextCompat.getColor(getContext(), R.color.magnitude9);
                break;
            default:
                color = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
                break;

        }
        return color;
    }
}
