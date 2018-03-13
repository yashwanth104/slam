package com.geekoder.slamee;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class Userpic_permit extends Activity {
	LinearLayout p1,p2,p3,p4;
	Button login , reset;
	String passw;
	SharedPreferences pass;
	String data2;
	
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.pic_login);

		    login = (Button)findViewById(R.id.login);
		    reset = (Button)findViewById(R.id.reset);
		    p1 = (LinearLayout)findViewById(R.id.box1);
		    p2 = (LinearLayout)findViewById(R.id.box2);
		    p3 = (LinearLayout)findViewById(R.id.box3);
		    p4 = (LinearLayout)findViewById(R.id.box4);
		   
		    
		    pass= getSharedPreferences(Set_password.file3,0);
		    reset.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
	               passw = null;
					
				}});
		    p1.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View arg0) {
					passw = passw+"1";
					
				}});
		    p2.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View arg0) {
					passw = passw +"2";
					
				}});
		    p3.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View arg0) {
					passw = passw +"3";
				}});
		    p4.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View arg0) {
					passw = passw +"4";
					
				}});
		  
		    login.setText("Next");
			
		    
		    login.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					data2 = pass.getString("password1","0");
					if(passw != null){
					if(data2.equals(passw)){
						
						Intent i = new Intent(Userpic_permit.this,Userinfo_change.class);
		                startActivity(i);
		                finish();
						}}
				
			}});

	}}

