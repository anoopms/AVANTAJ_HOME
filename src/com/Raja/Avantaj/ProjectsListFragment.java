package com.Raja.Avantaj;

import android.app.ListFragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class ProjectsListFragment extends ListFragment {
	
	String technologyinprojectslistfragment;

	/* (non-Javadoc)
	 * @see android.app.ListFragment#onListItemClick(android.widget.ListView, android.view.View, int, long)
	 */
	
	private String[] project, projectdescription, link ;
	
	public ProjectsListFragment(String technology)
	{
		this.technologyinprojectslistfragment = technology;
		
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		 Resources res = getResources();
		if(technologyinprojectslistfragment.equals("WEB"))
		{
			Log.d("came for web string initialisation", "came for string initialisation");
			project = res.getStringArray(R.array.webprojects);
			projectdescription = res.getStringArray(R.array.webprojectsdescription);
			link = res.getStringArray(R.array.webprojectslinks);
		}
		
		if(technologyinprojectslistfragment.equals("IPHONE"))
		{
			Log.d("came for iphone string initialisation", "came for string initialisation");
			project = res.getStringArray(R.array.iphoneprojects);
			projectdescription = res.getStringArray(R.array.iphoneprojectsdescription);
			link = res.getStringArray(R.array.iphoneprojectslinks);
		}
		
		if(technologyinprojectslistfragment.equals("ANDROID"))
		{
			Log.d("came for android string initialisation", "came for string initialisation");
			project = res.getStringArray(R.array.androidprojects);
			projectdescription = res.getStringArray(R.array.androidprojectsdescription);
			link = res.getStringArray(R.array.androidprojectslinks);
		}
		setListAdapter(new AdapterForListOfProjects(getActivity(), project, projectdescription, link));
	}

	/* (non-Javadoc)
	 * @see android.app.Fragment#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

	}

	

}
