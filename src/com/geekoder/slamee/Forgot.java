package com.geekoder.slamee;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Forgot extends Activity {
	
	TextView next , question;
	EditText answer;
	String q,a;
	SharedPreferences Question,Answer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.forgot);
		// finding elements
				next = (TextView)findViewById(R.id.next);
				question = (TextView)findViewById(R.id.questiontxt);
				answer = (EditText)findViewById(R.id.answer_edit);
				
		//getting question
		Question= getSharedPreferences(User_info.file5,0);
	q = Question.getString("question","0");
	
	//set question to question txt
	question.setText(q);
		//getting answer
		Answer = getSharedPreferences(User_info.file6 , 0);
		a = Answer.getString("answer","0");
		
		
		
		next.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if(answer.getText().length()>0 && a.equals(answer.getText().toString())){
					
					Intent i = new Intent(Forgot.this,Security.class);
		            startActivity(i);
		            finish();
					
				}else{
					Toast.makeText(getApplicationContext(),"Wrong Answer", Toast.LENGTH_SHORT).show();
				}
			}
			
			
		});
		
		
}}
