package com.Raja.Avantaj;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragForDetails1 extends Fragment {
	Button b;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.d("i came here", "done");
		View v = inflater.inflate(R.layout.details1, container, false);
		b = (Button)v.findViewById(R.id.b1);
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.d("Button clicked in diff frag", "done");
				getFragmentManager().popBackStackImmediate();
			}
		});
		
		return v;
	}
	

}
