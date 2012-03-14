package com.Raja.Avantaj;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

public class Clients extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.clients, container, false);
		GridView gridview = (GridView)v.findViewById(R.id.gridview);
		gridview.setAdapter(new AdapterForClients(getActivity()));
		return v;
	}

}
