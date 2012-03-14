package com.Raja.Avantaj;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * @author user5
 *
 */
public class ContactUs extends Fragment {
	Button mapus;
	View v;
	/* (non-Javadoc)
	 * @see android.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		 v = inflater.inflate(R.layout.contactus, container, false);
		intilize();
		return v;
	}
	// add a button to display the map
	private void intilize() {
		// TODO Auto-generated method stub
		mapus = (Button)v.findViewById(R.id.map);
		mapus.setOnClickListener(btnOnClickListener);
				
	}
	Button.OnClickListener btnOnClickListener = new Button.OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Toast.makeText(getActivity(),"Why didn't come", Toast.LENGTH_LONG).show();
			MapUs mapUs = new MapUs();
			FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
			fragmentTransaction.replace(R.id.layoutfordetails, mapUs);
			fragmentTransaction.commit();
		}
		
	};

}
