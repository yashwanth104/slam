package com.geekoder.slamee;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Pass_login extends Activity {
	EditText pass_txt;
	ImageView login ;
	TextView   username , forgot;
	SharedPreferences name;
	SharedPreferences pass;
   String a;
   String data2 , data3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_page);
		
		forgot = (TextView)findViewById(R.id.forgot);
		pass_txt=(EditText)findViewById(R.id.login_passtxt);
		login =(ImageView)findViewById(R.id.login);
		 username = (TextView)findViewById(R.id.login_username);
		pass= getSharedPreferences(Set_password.file3,0);
		name= getSharedPreferences(User_info.file4,0);
		data2 = pass.getString("password1","0");
		 data3 = name.getString("Username","0");
		 username.setText("Hello, "+data3);
		
		
		login.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				if(pass_txt.getText().length()>0){
					a =pass_txt.getText().toString();
				}
				if(data2.equals(a)){
					
					Intent i = new Intent(Pass_login.this,Home_page.class);
	                startActivity(i);
	                finish();
					}else {
						Intent i = new Intent(Pass_login.this,Home_page_open.class);
		                startActivity(i);
						}	
					}
		
	});
		
		
		forgot.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent f = new Intent(Pass_login.this,Forgot.class);
				startActivity(f);
				
			}
			
		});
			
	}}




