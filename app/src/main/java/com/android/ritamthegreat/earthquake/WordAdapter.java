package com.android.ritamthegreat.earthquake;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ritam Mallick on 02-01-2017.
 */

public class WordAdapter extends ArrayAdapter<CustomString> {

    public WordAdapter(Context context, ArrayList<CustomString> list){
        super(context,0,list);

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.custom_list_view, parent, false);
        }

        CustomString str=getItem(position);
        TextView text1=(TextView)view.findViewById(R.id.mag);
        text1.setText(str.getString(0));
        GradientDrawable circle=(GradientDrawable)text1.getBackground();
        circle.setColor(getMagnitudeColor(str.getMagnitude()));
        TextView text2=(TextView)view.findViewById(R.id.location_offset);
        text2.setText(str.getString(1));
        TextView text3=(TextView)view.findViewById(R.id.primary_location);
        text3.setText(str.getString(2));
        TextView text4=(TextView)view.findViewById(R.id.time);
        text4.setText(str.getString(3));
        TextView text5=(TextView)view.findViewById(R.id.date);
        text5.setText(str.getString(4));

        return view;
    }

    public int getMagnitudeColor(Double magnitude){
        int magnitudeColorId;
        int mag=(int)Math.floor(magnitude);
        switch(mag){
            case 0:magnitudeColorId=ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;
            case 1:magnitudeColorId=ContextCompat.getColor(getContext(), R.color.magnitude2);
                break;
            case 2:magnitudeColorId=ContextCompat.getColor(getContext(), R.color.magnitude3);
                break;
            case 3:magnitudeColorId=ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;
            case 4:magnitudeColorId=ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;
            case 5:magnitudeColorId=ContextCompat.getColor(getContext(), R.color.magnitude5);
                break;
            case 6:magnitudeColorId=ContextCompat.getColor(getContext(), R.color.magnitude6);
                break;
            case 7:magnitudeColorId=ContextCompat.getColor(getContext(), R.color.magnitude7);
                break;
            case 8:magnitudeColorId=ContextCompat.getColor(getContext(), R.color.magnitude8);
                break;
            case 9:magnitudeColorId=ContextCompat.getColor(getContext(), R.color.magnitude9);
                break;
            default:magnitudeColorId=0;
        }
        return magnitudeColorId;
    }


}
