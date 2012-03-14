package com.Raja.Avantaj;




import java.util.Timer;
import java.util.TimerTask;




import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AvantajSar extends Activity {
    /** Called when the activity is first created. */
	Button signin;
	TimerTask someTask;
	final Handler handler = new Handler();
	Timer t = new Timer();
	private ProgressDialog signInProgressDialog;
	EditText username,password;
	String PASSWORD = "avantaj";
 	String USERNAME	="avantaj";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        initialize();
    }
    private void initialize () {
        
    	signin		=	(Button) findViewById(R.id.btn_signIn);
    	signin.setOnClickListener(signInListener);

    	signInProgressDialog =	new ProgressDialog(this);
    	signInProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
    	signInProgressDialog.setMessage("SignIn. Please wait..");
    	signInProgressDialog.setCancelable(true);
    	signInProgressDialog.setIndeterminate(true);

    	username	=	(EditText) findViewById(R.id.login_emailedittext);
    	password	=	(EditText) findViewById(R.id.login_passwordEditText);
    	
    }
    private OnClickListener signInListener = new OnClickListener() {
        public void onClick(View v) {
        	signInProgressDialog.show();
        	dismissProgressDialog();
        	 
        }
    };
		private void dismissProgressDialog() {
			// TODO Auto-generated method stub
			someTask = new TimerTask() {
		        public void run() {
		                handler.post(new Runnable() {
		                        public void run() {
		                        	 signInProgressDialog.dismiss();
		                        if(password.getText().toString().compareTo(PASSWORD)==0&&
		                        		username.getText().toString().compareToIgnoreCase(USERNAME)==0)	{
		                        	//Intent intent = new Intent(AvantajSar.this, FragmentHolderActivity.class);
		               		        //startActivity(intent);	
		                        }else{
		                        	Toast.makeText(AvantajSar.this, "User Name or Password incorrect. Please try again!", 1000).show();
		                        }
		                        
		                        }
		               });
		        }};


		    t.schedule(someTask, 300); 
    }
}