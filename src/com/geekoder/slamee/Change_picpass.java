package com.geekoder.slamee;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Change_picpass extends Activity {
	LinearLayout p1,p2,p3,p4;
	Button login, reset;
	String passw , data1;
	SharedPreferences pass;
	TextView txt ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.set_picpassword);
		
		
		pass= getSharedPreferences(Set_password.file3,0);
		
		data1 = pass.getString("password1","0");
    login = (Button)findViewById(R.id.login);
    reset = (Button)findViewById(R.id.reset);
    p1 = (LinearLayout)findViewById(R.id.box1);
    p2 = (LinearLayout)findViewById(R.id.box2);
    p3 = (LinearLayout)findViewById(R.id.box3);
    p4 = (LinearLayout)findViewById(R.id.box4);

 login.setText("Next");
    
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
    
    
    login.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
			
			if(passw != null && passw.equals(data1)){
				
				SharedPreferences.Editor editor = pass.edit();
		    	editor.putString("password1",passw);
		    	editor.commit();
		    	Intent i = new Intent(Change_picpass.this,Security.class);
                startActivity(i);
                finish();
			}
			
			
		}
    	
    });
    
    
    
}
}
