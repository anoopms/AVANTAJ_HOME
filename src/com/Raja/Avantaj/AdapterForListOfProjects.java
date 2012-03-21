package com.Raja.Avantaj;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterForListOfProjects extends BaseAdapter {
	
	private String[] project, projectdescription, link;
	private Activity mContext ;
	public AdapterForListOfProjects(Activity context, String[] project, String[] projectdescription, String[] link)
	{
		
		this.mContext = context;
		this.project = project;
		this.projectdescription = projectdescription;
		this.link = link;
		for(String s: this.project)
		{
			Log.d("project", s);
		}
		
	}
	
	static class ViewHolder
	{
		ImageView projectLogo;
		TextView projectTitle;
		TextView projectDescription;
		TextView projectLink;
	}


	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		Log.d("came for length", "done");
		return this.project.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		Log.d("came here", "came here");
		if(arg1 == null)
		{
			
			arg1 = mContext.getLayoutInflater().inflate(R.layout.projectselementlayout, null);
			ViewHolder mViewHolder = new ViewHolder();
			mViewHolder.projectLogo = (ImageView)arg1.findViewById(R.id.projectlogo);
			mViewHolder.projectTitle = (TextView)arg1.findViewById(R.id.projecttitle);
			mViewHolder.projectDescription = (TextView)arg1.findViewById(R.id.projectdescription);
			mViewHolder.projectLink = (TextView)arg1.findViewById(R.id.projectlink);
			arg1.setTag(mViewHolder);
			
		}
		
		ViewHolder mViewHolder1 = (ViewHolder)arg1.getTag();
		mViewHolder1.projectTitle.setText(project[arg0]);
		mViewHolder1.projectDescription.setText(projectdescription[arg0]);
		mViewHolder1.projectLink.setText(link[arg0]);
		
		return arg1;
	}

}
