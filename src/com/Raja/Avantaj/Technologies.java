package com.Raja.Avantaj;

import android.app.ListFragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Technologies extends ListFragment {
	
	
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		String[] technologies = getActivity().getResources().getStringArray(R.array.technologies);
		String[] technologydetails = getActivity().getResources().getStringArray(R.array.technologydetails);
		setListAdapter(new AdapterForTechnologies(getActivity(), technologies, technologydetails));
		
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		((AdapterForTechnologies)getListAdapter()).toggle(position);
		
	}

}
