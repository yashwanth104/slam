package com.geekoder.slamee;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
//comment add
public class Change_pass extends Activity {
TextView chng_hdr,chng_old_passtxt;
EditText chng_old_pass;
Button change;
String oldpassword , data2 ;
SharedPreferences pass;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.changepass);
		
		chng_old_pass = (EditText)findViewById(R.id.chng_old_pass);
		change = (Button)findViewById(R.id.change);
        chng_hdr =(TextView)findViewById(R.id.Chng_hdr);
		chng_old_passtxt =(TextView)findViewById(R.id.chng_old_passtxt);
		pass= getSharedPreferences(Set_password.file3,0);
		
		data2 = pass.getString("password1","0");
		
		if(chng_old_pass.getText().length()>0){
			oldpassword = chng_old_pass.getText().toString();
		}
		
		 change.setText("Next");
		change.setOnClickListener(new OnClickListener () {
			@Override
			public void onClick(View v) {
				if(data2.equals(chng_old_pass.getText().toString())){
					
				Intent i = new Intent(Change_pass.this,Security.class);
	            startActivity(i);
	            finish();
				}
				
			}});
		
		Typeface font = Typeface.createFromAsset (getAssets(),"fonts/funky.ttf");
		change.setTypeface(font);
		chng_hdr.setTypeface(font);
		chng_old_passtxt.setTypeface(font);
		chng_old_pass.setTypeface(font);
}}
