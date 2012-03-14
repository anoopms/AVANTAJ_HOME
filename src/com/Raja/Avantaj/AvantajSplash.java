package com.Raja.Avantaj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class AvantajSplash extends Activity {
	
	private Handler handler = new Handler();
	ImageView logo, title ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		logo = (ImageView)findViewById(R.id.logo);
		title = (ImageView)findViewById(R.id.title);
		Animation a  = AnimationUtils.loadAnimation(this, R.anim.animation1);
		Animation a1  = AnimationUtils.loadAnimation(this, R.anim.animation2);
		a.reset();
		a1.reset();
		logo.clearAnimation();
		logo.startAnimation(a);
		title.clearAnimation();
		title.startAnimation(a1);
		handler.postDelayed(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Intent togotomenulist = new Intent(AvantajSplash.this, ItemsList.class);
				startActivity(togotomenulist);
				finish();
			}
			
		}, 4000);
	}

}
