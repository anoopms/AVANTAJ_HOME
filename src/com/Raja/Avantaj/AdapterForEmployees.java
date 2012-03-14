package com.Raja.Avantaj;

import android.app.Activity;
import android.opengl.Visibility;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class AdapterForEmployees extends BaseAdapter {
	
	
	
	private Activity mContext;
	private String[] employees;
	private String[] employeesdescription;
	private int[] employeephoto = {R.drawable.abhilash, R.drawable.shaiju, R.drawable.safeena, R.drawable.vikas, R.drawable.anooj, R.drawable.christy, R.drawable.misaj, R.drawable.sarith, R.drawable.dora};
	private boolean[] mExpanded = {false,false,false,false,false,false,false,false,false,false,false};
	
	
	public AdapterForEmployees(Activity context, String[] employees, String[] employeesdescription)
	{
		this.mContext = context;
		this.employees = employees;
		this.employeesdescription = employeesdescription;
	}
	
	static class ViewHolder
	{
		ImageView employeephoto;
		TextView employeename;
		TextView employeedescription;
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return employees.length;
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
	
	public void toggle(int position)
	{
		mExpanded[position] = !mExpanded[position];
		notifyDataSetChanged();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View element;
		if(convertView == null)
		{
			convertView = mContext.getLayoutInflater().inflate(R.layout.employeeselementlayout, null);
			ViewHolder mViewHolder1 = new ViewHolder();
			mViewHolder1.employeephoto = (ImageView)convertView.findViewById(R.id.employeephoto);
			mViewHolder1.employeename = (TextView)convertView.findViewById(R.id.employeename);
			mViewHolder1.employeedescription = (TextView)convertView.findViewById(R.id.employeedescription);
			//mViewHolder1.relativelayout = (RelativeLayout)convertView.findViewById(R.id.employeenameanddescription);
			//TextView employeedescription  = new TextView(mContext);
			//employeedescription.setText(employeesdescription[position]);
			//android.widget.RelativeLayout.LayoutParams paramsfordescription = new RelativeLayout.LayoutParams(android.widget.RelativeLayout.LayoutParams.MATCH_PARENT, android.widget.RelativeLayout.LayoutParams.WRAP_CONTENT);
			//paramsfordescription.addRule(RelativeLayout.BELOW, R.id.employeename);
			//paramsfordescription.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
			//employeedescription.setLayoutParams(paramsfordescription);
			convertView.setTag(mViewHolder1);
						
		}
	
		
			ViewHolder mViewHolder2 = (ViewHolder)convertView.getTag();
			mViewHolder2.employeephoto.setImageResource(employeephoto[position]);
			mViewHolder2.employeename.setText(employees[position]);
			mViewHolder2.employeedescription.setText(employeesdescription[position]);
			if(mExpanded[position])
			{
			mViewHolder2.employeedescription.setVisibility(View.VISIBLE);
			}
			else
			{
				mViewHolder2.employeedescription.setVisibility(View.GONE);
			}
			Log.d("in else loop", "boolean: " + String.valueOf(position) + String.valueOf(mExpanded[position]));
			/*element = (employeehorizontalview)convertView;
			element.setImageView(employeephoto[position]);
			element.setemployeeverticalview(new employeeverticalview(mContext, employees[position], employeesdescription[position], mExpanded[position]));*/
			
			
		
		return convertView;
	}
	
	public class employeeverticalview extends LinearLayout
	
	{
		private Activity mContext;
		public TextView employeename;
		private TextView employeedescription;
		
		public employeeverticalview(Activity context, String employeename, String employeedescription, Boolean mExpanded)
		{
			super(context);
			this.mContext = context;
			this.employeename = new TextView(context);
			this.employeename.setText(employeename);
			this.employeename.setGravity(Gravity.CENTER);
			this.employeename.setTextSize(25);
			this.employeedescription = new TextView(context);
			this.employeedescription.setText(employeedescription);
			this.setOrientation(VERTICAL);
			
			LayoutParams params1 = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			this.employeename.setLayoutParams(params1);
			this.addView(this.employeename);
			LayoutParams params2 = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			this.employeedescription.setLayoutParams(params2);
			this.addView(this.employeedescription);
			this.employeedescription.setVisibility(mExpanded ? VISIBLE : GONE);
			
			}
		public void setDescriptionVisibility(boolean mExpanded)
		{
			this.employeedescription.setVisibility(mExpanded ? VISIBLE : GONE);
		}
		
}
	
	public class employeehorizontalview extends LinearLayout
	
	{
		private ImageView employeephoto;
		private LinearLayout employeetitleanddescription;
		public employeehorizontalview(int photoID , Activity context, String employeename, String employeedescription, Boolean mExpanded)
		{
			super(mContext);
			
			this.setOrientation(HORIZONTAL);
			final float scale = getResources().getDisplayMetrics().density;
			int padding_15dp = (int)(15*scale + 0.5f);
			LayoutParams params4 = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
			this.employeetitleanddescription = new employeeverticalview(context, employeename, employeedescription, mExpanded);
			this.employeephoto = new ImageView(context);
			this.employeephoto.setBackgroundResource(photoID);
			employeephoto.setPadding(20,20,20,20);
			this.employeephoto.setLayoutParams(params4);
			this.addView(employeephoto);
			LayoutParams params5 = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			this.employeetitleanddescription.setLayoutParams(params5);
			this.addView(employeetitleanddescription);
		}
		
		public void setImageView(int res)
		{
			this.employeephoto.setBackgroundResource(res);
		}
		public void setemployeeverticalview(employeeverticalview evv)
		{
			this.employeetitleanddescription = evv;
		}
	}

}
