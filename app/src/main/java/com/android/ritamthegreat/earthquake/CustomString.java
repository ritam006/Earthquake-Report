package com.android.ritamthegreat.earthquake;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import java.text.DecimalFormat;

/**
 * Created by Ritam Mallick on 02-01-2017.
 */

public class CustomString{

    private String url;
    private Double magnitude;
    private String[]  str=new String[6];
    public CustomString(String str1,Double mag,String str2,String str3,String str4,String str5){
        DecimalFormat formatter=new DecimalFormat("0.0");
        magnitude=mag;
        str[0]=formatter.format(mag);
        str[1]=str2;
        str[2]=str3;
        str[3]=str4;
        str[4]=str5;
        url=str1;
    }
    public Double getMagnitude(){
        return magnitude;
    }

    public String getString(int index){
        return str[index];
    }


    public String getURL(){
        return url;
    }
}
