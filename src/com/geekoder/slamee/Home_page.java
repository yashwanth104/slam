package com.geekoder.slamee;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class Home_page extends Activity {
	TextView view,create,welcome,fb,info,logo;
	ImageView settings;
	SharedPreferences name;
	String data2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_page);

		
	  name= getSharedPreferences(User_info.file4,0);
      view = (TextView)findViewById(R.id.viewbtn);
      logo = (TextView)findViewById(R.id.Logo);
      create = (TextView)findViewById(R.id.createbtn);
      settings = (ImageView)findViewById(R.id.settings);
      welcome = (TextView)findViewById(R.id.welcomeuser);
      fb= (TextView)findViewById(R.id.fb);
      info = (TextView)findViewById(R.id.info);
      data2 = name.getString("Username","0");
      welcome.setText("Hello, "+data2);
     settings.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				
			Intent nextIntent = new Intent(Home_page.this,Settings.class);
			Home_page.this.startActivity(nextIntent);			
		}
		});
     
     view.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				
			Intent nextIntent = new Intent(Home_page.this,List_View.class);
			Home_page.this.startActivity(nextIntent);			
		}
		});
     create.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				
			Intent nextIntent = new Intent(Home_page.this,Create_Slamee.class);
			Home_page.this.startActivity(nextIntent);
			
		}
		});
		
     fb.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				 String fb = "https://www.facebook.com/Geekoder";
				 Intent i = new Intent(Intent.ACTION_VIEW);
					i.setData(Uri.parse(fb));
					startActivity(i);
					
		}
		});
     
     info.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				
			Intent nextIntent = new Intent(Home_page.this,Info.class);
			Home_page.this.startActivity(nextIntent);			
		}
		});
 	Typeface font = Typeface.createFromAsset (getAssets(),"fonts/funky.ttf");
 	create.setTypeface(font);
 	view.setTypeface(font);
 	fb.setTypeface(font);
 	info.setTypeface(font);
 	logo.setTypeface(font);
 	welcome.setTypeface(font);
 	}
}