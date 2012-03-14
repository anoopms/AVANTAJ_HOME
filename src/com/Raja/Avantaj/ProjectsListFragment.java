package com.Raja.Avantaj;

import android.app.ListFragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class ProjectsListFragment extends ListFragment {

	/* (non-Javadoc)
	 * @see android.app.ListFragment#onListItemClick(android.widget.ListView, android.view.View, int, long)
	 */
	private Resources res = getResources();
	private String[] project, projectdescription, link ;
	
	public ProjectsListFragment(String technology)
	{
		if(technology.equals("WEB"))
		{
			project = res.getStringArray(R.array.webprojects);
			projectdescription = res.getStringArray(R.array.webprojectsdescription);
			link = res.getStringArray(R.array.webprojectslinks);
		}
		
		if(technology.equals("IPHONE"))
		{
			project = res.getStringArray(R.array.iphoneprojects);
			projectdescription = res.getStringArray(R.array.iphoneprojectsdescription);
			link = res.getStringArray(R.array.iphoneprojectslinks);
		}
		
		if(technology.equals("ANDROID"))
		{
			project = res.getStringArray(R.array.androidprojects);
			projectdescription = res.getStringArray(R.array.androidprojectsdescription);
			link = res.getStringArray(R.array.androidprojectslinks);
		}
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
	}

	/* (non-Javadoc)
	 * @see android.app.Fragment#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new AdapterForListOfProjects(getActivity(), project, projectdescription, link));
	}

	

}
