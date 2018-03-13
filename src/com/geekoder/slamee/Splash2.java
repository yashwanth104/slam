package com.geekoder.slamee;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Splash2 extends Activity {
	 private static int SPLASH_TIME_OUT = 2000;
	public static String file = "splashcond";
	SharedPreferences splash;
	SharedPreferences passcond;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	splash= getSharedPreferences(file,0);
	String data1 = splash.getString("splash","0");
	
	passcond= getSharedPreferences(Security.file1,0);
    
	if (data1.equals("1")){
		setContentView(R.layout.splash2);

        new Handler().postDelayed(new Runnable() {
 
            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */
        	
            @Override
            public void run() {
            	String data2 = passcond.getString("passcond","0");
                // This method will be executed once the timer is over
                // Start your app main activity
            	if(data2.equals("3")){
                Intent ai = new Intent(Splash2.this,Home_page.class);
                Splash2.this.startActivity(ai);
                finish();
                }else if(data2.equals("1")){
                	 Intent bi = new Intent(Splash2.this, Pass_login.class);
                	 Splash2.this.startActivity(bi);
                     finish();
                }else if(data2.equals("2")){
                	 Intent ci = new Intent(Splash2.this, Pic_login.class);
                	 Splash2.this.startActivity(ci);
                     finish();
                }
            }
        }, SPLASH_TIME_OUT);
        
        TextView Splashtxt = (TextView)findViewById(R.id.splash2_txt);
        Typeface funky = Typeface.createFromAsset(getAssets(),"fonts/funky.ttf");
        Splashtxt.setTypeface(funky);
        
	}else {
		setContentView(R.layout.splash2_intro);
		
		Button b1= (Button)findViewById(R.id.button1);
		b1.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				//button clicked
				
			Intent nextIntent = new Intent(Splash2.this,Tutorial.class);
			Splash2.this.startActivity(nextIntent);
			
		}
		});
	}
	
}
}