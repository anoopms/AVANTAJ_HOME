package com.Raja.Avantaj;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

public class Projects extends Fragment implements OnTabChangeListener {
	
	private int mCurrentTab;
	private TabHost mTabHost; 
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View  tablayout = inflater.inflate(R.layout.projects, null);
		mTabHost = (TabHost)tablayout.findViewById(android.R.id.tabhost);
		final View v1 = tablayout.findViewById(R.id.webprojects);
		final View v2 = tablayout.findViewById(R.id.androidprojects);
		final View v3 = tablayout.findViewById(R.id.iphoneprojects);
		mTabHost.addTab(mTabHost.newTabSpec("tab1").setIndicator("WEB").setContent(new TabHost.TabContentFactory() {
			
			
			public View createTabContent(String tag) {
				// TODO Auto-generated method stub
				return v1;
			}
		}));
		mTabHost.addTab(mTabHost.newTabSpec("tab2").setIndicator("ANDROID").setContent(new TabHost.TabContentFactory() {
			
			@Override
			public View createTabContent(String tag) {
				// TODO Auto-generated method stub
				return v2;
			}
		}));
		mTabHost.addTab(mTabHost.newTabSpec("tab3").setIndicator("IPHONE").setContent(new TabHost.TabContentFactory() {
			
			@Override
			public View createTabContent(String tag) {
				// TODO Auto-generated method stub
				return v3;
			}
		}));
			
		
		return tablayout;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		setRetainInstance(true);
		mTabHost.setOnTabChangedListener(this);
		mTabHost.setCurrentTab(mCurrentTab);
	}

	@Override
	public void onTabChanged(String tabId) {
		// TODO Auto-generated method stub
		
		FragmentTransaction FrgTra = getFragmentManager().beginTransaction();
		
		if(tabId.equals("WEB"))
		{
			if(getFragmentManager().findFragmentByTag(tabId) == null)
			{
				FrgTra.replace(R.id.webprojects, new ProjectsListFragment("WEB"), tabId).commit();
				      
			}
		}
		
		if(tabId.equals("ANDROID"))
		{
			if(getFragmentManager().findFragmentByTag(tabId) == null)
			{
				FrgTra.replace(R.id.androidprojects, new ProjectsListFragment("ANDROID"), tabId).commit();
			}
		}
		
		if(tabId.equals("IPHONE"))
		{
			if(getFragmentManager().findFragmentByTag(tabId) == null)
			{
				FrgTra.replace(R.id.iphoneprojects, new ProjectsListFragment("IPHONE"), tabId).commit();
			}
		}
		
	}

}
