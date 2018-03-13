package com.geekoder.slamee;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class Set_picpassword extends Activity {
	LinearLayout p1,p2,p3,p4;
	Button login,reset;
	String passw;
	SharedPreferences pass;
	public static String file1 = "passcondition";
	SharedPreferences passcond;
	SharedPreferences splash;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.set_picpassword);
		
		splash= getSharedPreferences(Splash2.file,0);
		passcond= getSharedPreferences(file1,0);
		
		pass= getSharedPreferences(Set_password.file3,0);
    login = (Button)findViewById(R.id.login);
    reset = (Button)findViewById(R.id.reset);
    p1 = (LinearLayout)findViewById(R.id.box1);
    p2 = (LinearLayout)findViewById(R.id.box2);
    p3 = (LinearLayout)findViewById(R.id.box3);
    p4 = (LinearLayout)findViewById(R.id.box4);
    
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
			
			if(passw != null){
				SharedPreferences.Editor editor1 = passcond.edit();
				editor1.putString("passcond","2");
				editor1.commit();
				SharedPreferences.Editor editor = pass.edit();
		    	editor.putString("password1",passw);
		    	editor.commit();
		    	
		    	String somesplash = "1";
				SharedPreferences.Editor editor2 = splash.edit();
			editor2.putString("splash",somesplash);
			editor2.commit();
		    	Intent i = new Intent(Set_picpassword.this,Home_page.class);
                startActivity(i);
                finish();
			}
			
			
		}
    	
    });
    
    
    
}

}
