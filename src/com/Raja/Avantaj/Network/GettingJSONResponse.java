package com.Raja.Avantaj.Network;

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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.Raja.Avantaj.R;

import android.app.Activity;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GettingJSONResponse extends Activity {

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	Button downloadbutton;
	TextView results;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.download);
		downloadbutton = (Button)findViewById(R.id.download);
		results = (TextView)findViewById(R.id.results);
		DataInsertionPoint insertion = new DataInsertionPoint(GettingJSONResponse.this);
		downloadjsonresponse();
		downloadbutton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
				//JSONObject jsnobject = new JSONObject();
				
			}
		});
		
	}
	
	
	
	public class Download extends AsyncTask<String, Void, String>
	{
		
		private String[] Technologies1;
		private String[] TechnologyDescription1;

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			StringBuilder stringbuilder = new StringBuilder();
			HttpClient client = new DefaultHttpClient();
			HttpGet url = new HttpGet(params[0]);
			try
			{
				HttpResponse response = client.execute(url);
				HttpEntity entity = response.getEntity();
				InputStream stream = entity.getContent();
				BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
				String line ;
				while((line = reader.readLine()) != null)
				{
					stringbuilder.append(line);
				}
			}
			
			catch(ClientProtocolException e)
			{
				Log.d("error in clientprotocol", "error");
				e.printStackTrace();
			}
			catch(IOException e)
			{
				Log.d("error in IO", "error");
				e.printStackTrace();
			}
			return stringbuilder.toString();
			
			
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			DataInsertionPoint insertion = new DataInsertionPoint(GettingJSONResponse.this);
			try {
				JSONObject jsonobject = new JSONObject(result);
				JSONArray raja = jsonobject.getJSONArray("Technologies");
				//String raja = jsonobject.getJSONArray("Technologies").getJSONObject(0).getString("desc");
				//Log.d("desc:", raja);
				Technologies1 = new String[raja.length()];
				TechnologyDescription1 = new String[raja.length()];
				for(int i=0; i<raja.length();i++)
				{
					
					Technologies1[i] = raja.getJSONObject(i).getString("name");
					TechnologyDescription1[i] = raja.getJSONObject(i).getString("desc");
					Log.d("technology :", raja.getJSONObject(i).getString("name"));
					Log.d("technologydescription :", raja.getJSONObject(i).getString("desc"));
				}
				for(int i1=0; i1<raja.length(); i1++)
				{
					
					insertion.DataInsertionMethod(Technologies1[i1], TechnologyDescription1[i1]);
				}
				Cursor c = insertion.getCursor();
				c.moveToFirst();
				c.getColumnIndex(DataBase1.COLUMN_TECHNOLOGY);
				c.getColumnIndex(DataBase1.COLUMN_TECHNOLOGYDETAILS);
				while(!c.isAfterLast())
				{
					results.append(c.getString(c.getColumnIndex(DataBase1.COLUMN_TECHNOLOGY)));
					
					results.append(c.getString(c.getColumnIndex(DataBase1.COLUMN_TECHNOLOGYDETAILS)));
				}
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Log.d("desc:", "error");
			}
			//results.setText(result);
		}
		
		}
	
	public void downloadjsonresponse()
	{
		Download jsonresponse = new Download();
		jsonresponse.execute("http://www.avantajsoftwares.com/result.json");
	
	}

}
