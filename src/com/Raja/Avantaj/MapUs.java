package com.Raja.Avantaj;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MapUs extends Fragment {
	private MapView mapView;
	private MapController mapController;
	private View v;
	int lat,lon;
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			View v = inflater.inflate(R.layout.mapus, container, false);
			intilize();
			return v;
		}

		private void intilize() {
			// TODO Auto-generated method stub
			mapView = (MapView)v. findViewById(R.id.mv);
			mapView.setBuiltInZoomControls(true);
			mapView.setTraffic(true);
			mapController = mapView.getController();
			mapController.setZoom(14); // Zoon 1 is world view
			//locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
			lat=(int)(8.531401 * 1E6);
			lon=(int)(76.961964 * 1E6);
			GeoPoint point = new GeoPoint(lat, lon);
			mapController.animateTo(point);
		}
	

}
