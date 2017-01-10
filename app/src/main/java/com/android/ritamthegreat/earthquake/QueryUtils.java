package com.android.ritamthegreat.earthquake;

/**
 * Created by Ritam Mallick on 03-01-2017.
 */



        import android.util.Log;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;
        import java.text.SimpleDateFormat;
        import java.util.ArrayList;
        import java.util.Date;

/**
 * Helper methods related to requesting and receiving earthquake data from USGS.
 */
public final class QueryUtils {


    /**
     * Create a private constructor because no one should ever create a {@link QueryUtils} object.
     * This class is only meant to hold static variables and methods, which can be accessed
     * directly from the class name QueryUtils (and an object instance of QueryUtils is not needed).
     */
    private QueryUtils() {
    }

    /**
     * Return a list of {@link CustomString} objects that has been built up from
     * parsing a JSON response.
     */
    public static ArrayList<CustomString> extractEarthquakes(String SAMPLE_JSON_RESPONSE) {

        // Create an empty ArrayList that we can start adding earthquakes to
        ArrayList<CustomString> earthquakes = new ArrayList<>();

        // Try to parse the SAMPLE_JSON_RESPONSE. If there's a problem with the way the JSON
        // is formatted, a JSONException exception object will be thrown.
        // Catch the exception so the app doesn't crash, and print the error message to the logs.
        try {

            // TODO: Parse the response given by the SAMPLE_JSON_RESPONSE string and
            // build up a list of Earthquake objects with the corresponding data.

            JSONObject root=new JSONObject(SAMPLE_JSON_RESPONSE);

            JSONArray features=root.getJSONArray("features");

            for(int i=0;i<features.length();i++){
                JSONObject quake=features.getJSONObject(i);
                JSONObject properties=quake.getJSONObject("properties");
                Double magnitude=properties.getDouble("mag");
                String place=properties.getString("place");
                String[] loc=place.split("of");
                String offset;
                String primaryLocation;
                if(loc.length==1){
                    offset="Near the,";
                    primaryLocation=loc[0];
                }
                else{
                    offset=loc[0]+"of";
                    primaryLocation=loc[1];
                }
                String url=properties.getString("url");
                long time=properties.getLong("time");
                Date date=new Date(time);
                SimpleDateFormat dateFormat=new SimpleDateFormat("dd'th' MMM, yyyy");
                SimpleDateFormat timeFormat=new SimpleDateFormat("hh:mm a");
                String strDate=dateFormat.format(date);
                String strTime=timeFormat.format(date);
                earthquakes.add(new CustomString(url,magnitude,offset,primaryLocation,strTime,strDate));
            }

        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
        }

        // Return the list of earthquakes
        return earthquakes;
    }

}
