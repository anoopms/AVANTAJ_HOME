package com.Raja.Avantaj;

import android.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.Toast;

public class ContactUs extends Fragment {



	Button mapus;
	View v;
	Fragment frag1=new MapFragment();

	/* (non-Javadoc)
	 * @see android.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		 v = inflater.inflate(R.layout.contactus, container, false);
		 TranslateAnimation slide = new TranslateAnimation(900,0,0,0);
			slide.setDuration(600);
			v.startAnimation(slide);
		intilize();
		return v;
	}

	// add a button to display the map
	private void intilize() {
		// TODO Auto-generated method stub
		mapus =(Button) v.findViewById(R.id.map);
		mapus.setOnClickListener(btnOnClickListener);
				
	}
	
	Button.OnClickListener btnOnClickListener = new Button.OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			/*Toast.makeText(getActivity(),"Why didn't come", Toast.LENGTH_LONG).show();
			Intent intent=new Intent(v.getContext(),MapUs.class);
			ContactUs.this.startActivity(intent);*/
			Toast.makeText(getActivity(), "No Option", Toast.LENGTH_LONG).show();
			FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
			//frag1 = new MapFragment(); 
			if(frag1.isAdded())
		    {
		        Log.d("fff", "Show() BFrag");
		        fragmentTransaction.show(frag1);   
		    }
			else
		    {
		        Log.d("sss", "Replacing AFrag -> BFrag");
		        //frag1 = new MapFragment(); 
		        fragmentTransaction.replace(R.id.layoutfordetails, frag1);	
		    }

		    // Keep the transaction in the back stack so it will be reversed when backbutton is pressed
		    fragmentTransaction.addToBackStack(null);	
			
			/* if(getFragmentManager().findFragmentByTag("MapFragment")==null)
			{	
				Log.d("in  null","in null" );
				frag1 = new MapFragment(); 
				fragmentTransaction.replace(R.id.layoutfordetails, frag1,"MapFragment");	
				//fragmentTransaction.addToBackStack("MapFragment");
			}
			 

				else
				{
					Log.d("in not null","in not null" );
					//frag1=new MapFragment();
					//Fragment f11 = getFragmentManager().findFragmentByTag("MapFragment");
					fragmentTransaction.remove(getFragmentManager().findFragmentByTag("MapFragment"));
					//fragmentTransaction.replace(R.id.layoutfordetails, frag1,"MapFragment");
					fragmentTransaction.replace(R.id.layoutfordetails, frag1,"MapFragment");
				
					fragmentTransaction.addToBackStack("MapFragment");
				}
			 	//fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
*/			 	fragmentTransaction.commit();
		}
		
	};


}
