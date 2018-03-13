package com.geekoder.slamee;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Set_password extends Activity {
	EditText pass_input;
	Button done;
	public static String file3 = "password";
	SharedPreferences pass;
	public static String file1 = "passcondition";
	SharedPreferences passcond;
	SharedPreferences splash;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.set_password);
		pass_input=(EditText)findViewById(R.id.set_passtxt);
		done = (Button)findViewById(R.id.done);
		
		splash= getSharedPreferences(Splash2.file,0);
	
		
		passcond= getSharedPreferences(file1,0);
		pass= getSharedPreferences(file3,0);
		
		
		done.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				if(pass_input.getText().length()>0){
					SharedPreferences.Editor editor1 = passcond.edit();
					editor1.putString("passcond","1");
					editor1.commit();
					
					SharedPreferences.Editor editor = pass.edit();
			    	editor.putString("password1",pass_input.getText().toString());
			    	editor.commit();
			    	
			    	String somesplash = "1";
					SharedPreferences.Editor editor2 = splash.edit();
				editor2.putString("splash",somesplash);
				editor2.commit();
					
				
			    	Intent i = new Intent(Set_password.this,Home_page.class);
	                startActivity(i);
	                finish();
				}
					
				
			}
		});
		
		
}

}
