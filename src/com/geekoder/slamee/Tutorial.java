package com.geekoder.slamee;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Tutorial extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tutorial);
		
		
		Button b1= (Button)findViewById(R.id.password);
		b1.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
			Intent nextIntent = new Intent(Tutorial.this,User_info.class);
			Tutorial.this.startActivity(nextIntent);
				
		}
		});
	}
}
