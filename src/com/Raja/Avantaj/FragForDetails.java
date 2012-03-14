package com.Raja.Avantaj;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragForDetails extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.details, container, false);
		return view;
	}
	
	public void setText(String s)
	{
		Log.d("came to set", "came to set");
		TextView tv =  (TextView)getView().findViewById(R.id.detailsText);
		tv.setText(s);
	}

	

}
