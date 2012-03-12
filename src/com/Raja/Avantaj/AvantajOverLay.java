package com.Raja.Avantaj;

import java.util.ArrayList;
import java.util.List;

import android.graphics.drawable.Drawable;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class AvantajOverLay extends ItemizedOverlay<OverlayItem> {
	private List<OverlayItem> items=new ArrayList<OverlayItem>();
	private Drawable marker=null;
	public AvantajOverLay(Drawable marker) {
	super(marker);
	this.marker=marker;
	boundCenterBottom(marker);
	items.add(new OverlayItem(new GeoPoint((int)(8.532138 * 1E6),(int)(76.961583 * 1E6)), "Avantaj", "Avantaj Softwares Private Limited"));
	items.add(new OverlayItem(new GeoPoint((int)(9.939248 * 1E6),(int)(76.259625 * 1E6)), "Avantaj", "Avantaj Softwares Private Limited"));
	populate();
	}
	@Override
	protected OverlayItem createItem(int i) {
	return(items.get(i));
	}
	@Override
	protected boolean onTap(int i) {
	//Toast.makeText(NooYawk.this,
	items.get(i).getSnippet();
	//Toast.LENGTH_SHORT).show();
	return(true);
	}
	@Override
	public int size() {
	return(items.size());
	}
	}
