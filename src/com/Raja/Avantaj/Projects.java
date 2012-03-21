package com.Raja.Avantaj;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
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
		super.onCreateView(inflater, container, savedInstanceState);
		View  tablayout = inflater.inflate(R.layout.projects, container,false);
		mTabHost = (TabHost)tablayout.findViewById(android.R.id.tabhost);
		mTabHost.setup();
		mTabHost.addTab(mTabHost.newTabSpec("tab1").setIndicator("WEB").setContent(R.id.webprojects));
		mTabHost.addTab(mTabHost.newTabSpec("tab2").setIndicator("ANDROID").setContent(R.id.androidprojects));
		mTabHost.addTab(mTabHost.newTabSpec("tab3").setIndicator("IPHONE").setContent(R.id.iphoneprojects));
		mTabHost.setOnTabChangedListener(this);
		mTabHost.setCurrentTab(0);
		
		return tablayout;
	}


	@Override
	public void onTabChanged(String tabId) {
		// TODO Auto-generated method stub
		
		FragmentTransaction FrgTra = getFragmentManager().beginTransaction();
		Log.d("came in tab changed", "came in tab changed");
		
		if(tabId.equals("tab1"))
		{
			
			if(getFragmentManager().findFragmentByTag(tabId) == null)
			{
				Log.d("came to web tab","came to web tab");
				FrgTra.replace(R.id.webprojects, new ProjectsListFragment("WEB"), tabId).commit();
				      
			}
		}
		
		if(tabId.equals("tab2"))
		{
			
			if(getFragmentManager().findFragmentByTag(tabId) == null)
			{
				Log.d("came to android tab","came to android tab");
				FrgTra.replace(R.id.androidprojects, new ProjectsListFragment("ANDROID"), tabId).commit();
			}
		}
		
		if(tabId.equals("tab3"))
		{
			
			if(getFragmentManager().findFragmentByTag(tabId) == null)
			{
				Log.d("came to iphone tab","came to iphone tab");
				FrgTra.replace(R.id.iphoneprojects, new ProjectsListFragment("IPHONE"), tabId).commit();
			}
		}
		
	}

}
