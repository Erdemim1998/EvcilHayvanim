package com.example.evcilhayvanim;

import android.os.AsyncTask;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class GetNearbyPlacesData extends AsyncTask<Object,String,String> {
    String googlePlacesData;
    GoogleMap mMap;
    String url;
    @Override
    protected String doInBackground(Object... objects) {
        mMap=(GoogleMap)objects[0];
        url=(String)objects[1];
        DownloadUrl downloadUrl=new DownloadUrl();
        try {
            googlePlacesData=downloadUrl.readUrl(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return googlePlacesData;
    }

    @Override
    protected void onPostExecute(String s) {
        List<HashMap<String,String>> nearbyPlaceList;
        DataParser dataParser=new DataParser();
        nearbyPlaceList=dataParser.parse(s);
        showNearbyPlaces(nearbyPlaceList);
    }

    public void showNearbyPlaces(List<HashMap<String,String>> nearbyPlaceList){
        for(int i=0;i<nearbyPlaceList.size();i++){
            MarkerOptions markerOptions=new MarkerOptions();
            HashMap<String,String> googlePlace=nearbyPlaceList.get(i);
            String placeName=googlePlace.get("place_name");
            String vicinity=googlePlace.get("vicinity");
            double latitude=Double.parseDouble(Objects.requireNonNull(googlePlace.get("lat")));
            double longitude=Double.parseDouble(Objects.requireNonNull(googlePlace.get("lng")));
            LatLng latLng=new LatLng(latitude,longitude);
            markerOptions.position(latLng);
            markerOptions.title(placeName+" : "+vicinity);
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
            mMap.addMarker(markerOptions);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,15));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
        }
    }
}