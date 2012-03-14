package com.Raja.Avantaj;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AdapterForMenuItems extends BaseAdapter {
	
	private Activity mContext;
	private String[] menuitems;
		
		public AdapterForMenuItems(Activity context, String[] menuitems)
	{
		this.mContext = context;
		this.menuitems = menuitems;
	}
		
		static class ViewHolder
		{
			ImageView imageview;
			TextView textview;
		}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return menuitems.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder mViewHolder1 = new ViewHolder();
		if(convertView == null)
		{
		convertView = mContext.getLayoutInflater().inflate(R.layout.menuitemelementlayout, null);
	//	RelativeLayout parent1 = (RelativeLayout)convertView.findViewById(R.id.parent);
		
	//	mViewHolder1.imageview = (ImageView)convertView.findViewById(R.id.ourlogo);
		mViewHolder1.textview = (TextView)convertView.findViewById(R.id.menuitemtext);
		convertView.setTag(mViewHolder1);
		}
		else
		{
			 mViewHolder1 = (ViewHolder)convertView.getTag(); 
		}
		//mViewHolder1.imageview.setImageResource(R.drawable.smalllogo);
		mViewHolder1.textview.setText(menuitems[position]);
		mViewHolder1.textview.setCompoundDrawablesWithIntrinsicBounds(R.drawable.smalllogo, 0, 0, 0);
		mViewHolder1.textview.setCompoundDrawablePadding(10);
		return convertView;
		
	}

}
