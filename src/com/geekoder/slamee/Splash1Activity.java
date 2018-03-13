package com.geekoder.slamee;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;

public class Splash1Activity extends Activity {
		 private static int SPLASH_TIME_OUT = 2000;
			@Override
			protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				setContentView(R.layout.splash1);

		        new Handler().postDelayed(new Runnable() {
		 
		            /*
		             * Showing splash screen with a timer. This will be useful when you
		             * want to show case your app logo / company
		             */
		 
		            @Override
		            public void run() {
		                // This method will be executed once the timer is over
		                // Start your app main activity
		                Intent i = new Intent(Splash1Activity.this, Splash2.class);
		                startActivity(i);
		 
		                // close this activity
		                finish();
		            }
		        }, SPLASH_TIME_OUT);
			}
}