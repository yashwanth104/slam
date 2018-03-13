package com.geekoder.slamee;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Userpass_permit extends Activity {
TextView usrpermit_txt;
EditText password;
Button done;
SharedPreferences pass;
String data2, a;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.userpermit);
	
		
		password=(EditText)findViewById(R.id.password);
		done =(Button)findViewById(R.id.done);
		usrpermit_txt =(TextView)findViewById(R.id.usrpermit_txt);
		pass= getSharedPreferences(Set_password.file3,0);
		
		data2 = pass.getString("password1","0");
	
		if(password.getText().length()>0){
			a =password.getText().toString();
		}
		 done.setText("Next");
		done.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				
				if(data2.equals(a)){
					
					Intent i = new Intent(Userpass_permit.this,Userinfo_change.class);
	                startActivity(i);
	                finish();
					}}	
		
	});
	
		Typeface font = Typeface.createFromAsset (getAssets(),"fonts/funky.ttf");
		password.setTypeface(font);
		done.setTypeface(font);
		usrpermit_txt.setTypeface(font);
		
		
}}
