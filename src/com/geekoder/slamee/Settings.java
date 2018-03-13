package com.geekoder.slamee;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Settings extends Activity {
TextView cgpass,cgname,textView1 ;
SharedPreferences passcond;
String data2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
	
		cgpass = (TextView)findViewById(R.id.cgpass);
		cgname =  (TextView)findViewById(R.id.cgname);
		textView1 = (TextView)findViewById(R.id.textView1);
		
		passcond= getSharedPreferences(Security.file1,0);
		
		data2 = passcond.getString("passcond","0");
		
		
		if(data2.equals("3")){
			cgpass.setText("Create Password");
		}
	cgname.setOnClickListener(new OnClickListener () {
		@Override
		public void onClick(View v) {
			if(data2.equals("3")){
			Intent i = new Intent(Settings.this,Userinfo_change.class);
            startActivity(i);
            finish();
			}else if (data2.equals("1")){
				Intent i = new Intent(Settings.this,Userpass_permit.class);
	            startActivity(i);
	            finish();
				
			}else if(data2.equals("2")){
				Intent i = new Intent(Settings.this,Userpic_permit.class);
	            startActivity(i);
	            finish();
			}
			
		}});
	
	cgpass.setOnClickListener(new OnClickListener () {
		@Override
		public void onClick(View v) {
			if(data2.equals("1")){
			Intent i = new Intent(Settings.this,Change_pass.class);
            startActivity(i);
            finish();
			}else if(data2.equals("2")){
				
				Intent i = new Intent(Settings.this,Change_picpass.class);
	            startActivity(i);
	            finish();
			}else if (data2.equals("3")){
				Intent i = new Intent(Settings.this,Security.class);
	            startActivity(i);
	            finish();
			}
			
		}});
	Typeface font = Typeface.createFromAsset (getAssets(),"fonts/funky.ttf");
	cgpass.setTypeface(font);
	cgname.setTypeface(font);
	textView1.setTypeface(font);
}}
