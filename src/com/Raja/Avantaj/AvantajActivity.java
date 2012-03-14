package com.Raja.Avantaj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AvantajActivity extends Activity {
    /** Called when the activity is first created. */
	Button gotomenu;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        gotomenu = (Button)findViewById(R.id.button1);
        gotomenu.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent(AvantajActivity.this, ItemsList.class);
				startActivity(i);
			}
		});
    }
}