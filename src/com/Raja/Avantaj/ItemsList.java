package com.Raja.Avantaj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ItemsList extends Activity {

	Button buttonforlogin;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragforlist);
		buttonforlogin = (Button)findViewById(R.id.login);
		buttonforlogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent gotologin = new Intent(ItemsList.this, AvantajSar.class);
				startActivity(gotologin);
			}
		});
		
	}

}
