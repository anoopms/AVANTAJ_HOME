package com.Raja.Avantaj;

import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


public class FragForList extends ListFragment {

	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		String[] menuitems = getResources().getStringArray(R.array.menuitems);
		setListAdapter(new AdapterForMenuItems(getActivity(), menuitems));
		//setListAdapter(ArrayAdapter.createFromResource(getActivity().getApplicationContext(), R.array.menuitems, R.layout.element));
		
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		FragmentTransaction ftrns = getFragmentManager().beginTransaction();
		switch(position)
		{
		
		case 0:
			
			Technologies fragment7 = new Technologies();
			ftrns.replace(R.id.layoutfordetails, fragment7);
			//ftrns.add(R.id.layoutfordetails, fragment10);
			ftrns.addToBackStack(null); 
			ftrns.commit();
			break;
			
		case 1:
			
			Clients fragment13 = new Clients();
			ftrns.replace(R.id.layoutfordetails, fragment13);
			//ftrns.add(R.id.layoutfordetails, fragment10);
			ftrns.addToBackStack(null); 
			ftrns.commit();
			break;
			
		case 2:
			
			Projects fragment6 = new Projects();
			ftrns.replace(R.id.layoutfordetails, fragment6);
			//ftrns.add(R.id.layoutfordetails, fragment10);
			ftrns.addToBackStack(null); 
			ftrns.commit();
			break;
		
		case 3:
			
			Employees fragment17 = new Employees();
			ftrns.replace(R.id.layoutfordetails, fragment17);
			//ftrns.add(R.id.layoutfordetails, fragment10);
			ftrns.addToBackStack(null); 
			ftrns.commit();
			break;
			
		case 4:
			
			Owners fragment20 = new Owners();
			ftrns.replace(R.id.layoutfordetails, fragment20);
			//ftrns.add(R.id.layoutfordetails, fragment10);
			ftrns.addToBackStack(null); 
			ftrns.commit();
			break;
		
		case 6:
			
			ContactUs fragment9 = new ContactUs();
			ftrns.replace(R.id.layoutfordetails, fragment9);
			//ftrns.add(R.id.layoutfordetails, fragment10);
			ftrns.addToBackStack(null); 
			ftrns.commit();
			break;
		
		case 7:
			
				RequestQuotes fragment11 = new RequestQuotes();
				ftrns.replace(R.id.layoutfordetails, fragment11);
				//ftrns.add(R.id.layoutfordetails, fragment11);
				ftrns.addToBackStack(null); 
				ftrns.commit();
				break;
		  
		case 8:
			
			OnlineInfo fragment30 = new OnlineInfo();
			
			ftrns.replace(R.id.layoutfordetails, fragment30);
			//ftrns.add(R.id.layoutfordetails, fragment10);
			ftrns.addToBackStack(null); 
			ftrns.commit();
			break;
	

		
		}
	}
	
}
