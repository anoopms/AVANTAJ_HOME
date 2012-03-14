package com.Raja.Avantaj;







import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import com.Raja.Avantaj.Network.GettingJSONResponse.Download;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;


public class AvantajAnimation extends Activity {
	/** Called when the activity is first created. */
	ImageView leaf1,leaf2,leaf3,company,software;
	
	private Handler handler = new Handler ();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animationsarith);
        leaf1	=	(ImageView) findViewById(R.id.leaf1);    
        TranslateAnimation slide1 = new TranslateAnimation(500, 0, 0,130 );   
        slide1.setDuration(3000);   
        slide1.setFillAfter(true);   
        slide1.setInterpolator(new BounceInterpolator());
        leaf1.startAnimation(slide1);
        leaf2	=	(ImageView) findViewById(R.id.leaf2);
        TranslateAnimation slide2 = new TranslateAnimation(-500, 0, 0,30 );   
        slide2.setDuration(3000);   
        slide2.setFillAfter(true);   
        slide2.setInterpolator(new BounceInterpolator());
        leaf2.startAnimation(slide2);
        leaf3	=	(ImageView) findViewById(R.id.leaf3);
        TranslateAnimation slide3 = new TranslateAnimation(0,0, 0,-65 );   
        slide3.setDuration(3000);   
        slide3.setFillAfter(true);   
        slide3.setInterpolator(new BounceInterpolator());
        leaf3.startAnimation(slide3);
        company	=	(ImageView) findViewById(R.id.company);
        TranslateAnimation rot1 = new TranslateAnimation(500,0,0,-160);   
        rot1.setDuration(3000);   
        rot1.setFillAfter(true);   
        rot1.setInterpolator(new BounceInterpolator());
        company.startAnimation(rot1);
        software	=	(ImageView) findViewById(R.id.solution);
        TranslateAnimation rot2 = new TranslateAnimation(-500,0,0,-310);   
        rot2.setDuration(3000);   
        rot2.setFillAfter(true);   
        rot2.setInterpolator(new BounceInterpolator());
        software.startAnimation(rot2);
       
		
        initialize();
    }
    private void initialize () {
		handler.postDelayed( new Runnable () {
		 
			public void run() {
				
				// Calling the next Activity.
				 Intent intent = new Intent(AvantajAnimation.this, ItemsList.class);
			     startActivity(intent);
			     finish();

			}
			
		}, 6000);
	} 
    
    
      
}
