package com.Raja.Avantaj;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MapFragment extends Fragment {
	public static MapView map;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.mapfragment, container, false);
		return v;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		if(map==null)
		{
			 map = new MapView(getActivity(), "0LYqpa9x_HkkUzATV8Rt5MHwhUuvm7sbnxsvZWQ");
		}
		map.setClickable(true);
		map.getController().setCenter(new GeoPoint((int)(8.532138 * 1E6),(int)(76.961583 * 1E6)));
		map.getController().setZoom(9);
		map.setBuiltInZoomControls(true);
		Drawable marker=getResources().getDrawable(R.drawable.balloon);
		marker.setBounds(0, 0, marker.getIntrinsicWidth(),
				marker.getIntrinsicHeight());
		map.getOverlays().add(new AvantajOverLay(marker));
		MyLocationOverlay me=new MyLocationOverlay(getActivity(), map);
		map.getOverlays().add(me);
		((ViewGroup)getView()).addView(map);
	}

}
