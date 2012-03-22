package com.Raja.Avantaj;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.GridView;

public class Clients extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.clients, container, false);
		GridView gridview = (GridView)v.findViewById(R.id.gridview);
		TranslateAnimation slide = new TranslateAnimation(900,0,0,0);
		slide.setDuration(600);
		gridview.startAnimation(slide);
		gridview.setAdapter(new AdapterForClients(getActivity()));
		return v;
	}

}
