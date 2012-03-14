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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListFragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

public class OnlineInfo extends ListFragment {
	
	public static String result;
	public String[] Technologies1;
	public String[] TechnologyDescription1;

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 downloadjsonresponse();
		 
		
		
	}
	
	 public class Download extends AsyncTask<String, Void, String>
		{

	
			@Override
			protected String doInBackground(String... params) {
				// TODO Auto-generated method stub
				StringBuilder stringbuilder = new StringBuilder();
				HttpClient client = new DefaultHttpClient();
				HttpGet url = new HttpGet(params[0]);
				try
				{
					Log.d("in background", "in background");
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
				
				OnlineInfo.result = result;
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
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Log.d("desc:", "error");
				}
				setListAdapter(new AdapterForOnlineInfo(getActivity(), OnlineInfo.this.Technologies1, OnlineInfo.this.TechnologyDescription1));
				
				
			}
			
			}
	 
	 public void downloadjsonresponse()
		{
			Download jsonresponse = new Download();
			jsonresponse.execute("http://www.avantajsoftwares.com/result.json");
		
		}

	    



}
