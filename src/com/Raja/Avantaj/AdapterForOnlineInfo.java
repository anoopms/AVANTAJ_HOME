package com.Raja.Avantaj;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AdapterForOnlineInfo extends BaseAdapter {
	
	private String[] technologies, technologydescription;
	private Activity mContext;
	private Boolean[] mExpanded = {false, false, false, false, false, false};
	
	public AdapterForOnlineInfo(Activity context, String[] Technologies, String[] Technologydescription)
	{
		this.mContext = context;
		this.technologies = Technologies;
		this.technologydescription = Technologydescription;
		Log.d("technologieslength", String.valueOf(technologies.length));
		Log.d("technologydescriptionlength", String.valueOf(technologydescription.length));
	}
	
	static class ViewHolder
	{
		TextView technology;
		TextView technologydescription;
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return technologies.length;
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
		if(arg1 == null)
		{
		arg1 = mContext.getLayoutInflater().inflate(R.layout.onlineinfoelementlayout, null);
		ViewHolder mViewHolder1 = new ViewHolder();
		mViewHolder1.technology = (TextView)arg1.findViewById(R.id.technology);
		mViewHolder1.technologydescription = (TextView)arg1.findViewById(R.id.technologydescription);
		arg1.setTag(mViewHolder1);
		}
		ViewHolder mViewHolder2 = (ViewHolder)arg1.getTag();
		mViewHolder2.technology.setText(technologies[arg0]);
		mViewHolder2.technologydescription.setText(technologydescription[arg0]);
		
		return arg1;
	}

}
