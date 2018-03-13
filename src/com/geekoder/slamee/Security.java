package com.geekoder.slamee;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;

public class Security extends Activity {
	RadioButton none,normal,pic;
	public static String file1 = "passcondition";
	SharedPreferences passcond;
	SharedPreferences splash;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.security);
		
		splash= getSharedPreferences(Splash2.file,0);
		passcond= getSharedPreferences(file1,0);
		
		
		
		none= (RadioButton)findViewById(R.id.none);
		normal=(RadioButton)findViewById(R.id.password);
		pic= (RadioButton)findViewById(R.id.picpassword);
		
		Button next =(Button)findViewById(R.id.next);
		next.setOnClickListener(new  OnClickListener() {
			public void onClick(View V){
				if(none.isChecked()){
					SharedPreferences.Editor editor = passcond.edit();
				editor.putString("passcond","3");
				editor.commit();
				
				String somesplash = "1";
				SharedPreferences.Editor editor1 = splash.edit();
			editor1.putString("splash",somesplash);
			editor1.commit();
				
				 Intent i = new Intent(Security.this,Home_page.class);
	                startActivity(i);
	                finish();
				}else if (normal.isChecked()){
					
					 Intent i = new Intent(Security.this,Set_password.class);
		                startActivity(i);
		                finish();
				}else if(pic.isChecked()){
					
					Intent i = new Intent(Security.this,Set_picpassword.class);
	                startActivity(i);
	                finish();
				}
				
				
				
			}
		});
		
	}
}
