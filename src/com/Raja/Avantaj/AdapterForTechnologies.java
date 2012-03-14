package com.Raja.Avantaj;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AdapterForTechnologies extends BaseAdapter {
	
	private Activity mContext;
	private String[] technologies, technologydetails; 
	private Boolean[] mExpanded = {false, false, false, false, false, false};
	
	public AdapterForTechnologies( Activity context, String[] technologies, String[] technologydetails)
	{
		
		
		mContext = context;
		this.technologies = technologies;
		this.technologydetails = technologydetails;
		
	}
	
	static class ViewHolder
	{
		public TextView technology;
		public TextView technologydetail;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return technologies.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		TechnologyLinearLayout convertView;
				
		if(arg1 == null)
			{
			
			convertView = new TechnologyLinearLayout(mContext, technologies[arg0], technologydetails[arg0], mExpanded[arg0]);
			
			}
		else
		{
			convertView = (TechnologyLinearLayout)arg1;
			convertView.setTechnologyName(technologies[arg0]);
			convertView.setTechnologyDetail(technologydetails[arg0]);
			convertView.setTechnologyDetailVisibility(mExpanded[arg0]);
		}
		
		
		return convertView;
	}
	
	public void toggle(int position)
	{
		mExpanded[position] = !mExpanded[position];
		notifyDataSetChanged();
	}
	
	public class TechnologyLinearLayout extends LinearLayout
	{
		private TextView TechnologyName;
		private TextView TechnologyDetail;

		public TechnologyLinearLayout(Context context, String technologyname, String technologydetail,boolean mExpanded) {
			super(context);
			// TODO Auto-generated constructor stub
			TechnologyName = new TextView(context);
			TechnologyDetail = new TextView(context);
			TechnologyName.setText(technologyname);
			TechnologyName.setGravity(Gravity.CENTER);
			TechnologyDetail.setText(technologydetail);
			TechnologyName.setTypeface(null,Typeface.BOLD);
			TechnologyName.setTextSize(30);
			this.setOrientation(VERTICAL);
			LayoutParams params1 = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			TechnologyName.setLayoutParams(params1);
			this.addView(TechnologyName);
			this.setBackgroundDrawable(getResources().getDrawable(R.drawable.listviewroundedcorners));
			this.setMinimumHeight(100);
			LayoutParams params2 = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			TechnologyDetail.setLayoutParams(params2);
			this.addView(TechnologyDetail);
			this.TechnologyDetail.setVisibility(mExpanded ? VISIBLE : GONE);
		}
		
		public void setTechnologyName(String technologyname)
		{
			this.TechnologyName.setText(technologyname);
		}
		
		public void setTechnologyDetail(String technologydetail)
		{
			this.TechnologyDetail.setText(technologydetail);
		}
		
		public void setTechnologyDetailVisibility(boolean mExpanded)
		{
			this.TechnologyDetail.setVisibility(mExpanded ? VISIBLE : GONE);
		}
		
	}
	
	

}
