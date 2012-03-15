package com.Raja.Avantaj;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
/**
 * Added comment
 * @author user2
 *
 */
public class AdapterForClients extends BaseAdapter {

	/**
	 * A new comment
	 */
	private Activity mcontext;
	private int[] clientlogos = {R.drawable.client1, R.drawable.client2, R.drawable.client3, R.drawable.client4, R.drawable.client5, R.drawable.client6};
	
	public AdapterForClients(Activity context)
	{
		this.mcontext = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return clientlogos.length;
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
		
		ImageView imageview;
		
		if(arg1 == null)
		{
			imageview = new ImageView(mcontext);
			imageview.setLayoutParams(new GridView.LayoutParams(85,85));
			imageview.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageview.setPadding(8, 8, 8, 8);

		}
		else
		{
		imageview = (ImageView)arg1;
		}
		imageview.setImageResource(clientlogos[arg0]);
		return imageview ;
	}

}
