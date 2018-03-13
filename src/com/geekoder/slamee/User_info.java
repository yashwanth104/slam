package com.geekoder.slamee;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class User_info extends Activity implements OnItemSelectedListener {
	TextView textView1,textView2,questiontxt;
	EditText username,answer_edit,question_edit;
	Button next;
	Spinner question;
	int count = 0;
 private String[] Questions =  {"What is your name?" ,"What is your pet name?","Who is your inspiration?","Write your own question"};
	public static String file4 = "username";
	SharedPreferences name , Question,Answer;
	public static String file5 = "question";
	public static String file6 = "answer";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.userinfo);
		name= getSharedPreferences(file4,0);
		
		Question= getSharedPreferences(file5,0);
		
		Answer = getSharedPreferences(file6 , 0);
		question_edit = (EditText)findViewById(R.id.question_edit);
		questiontxt = (TextView)findViewById(R.id.questiontxt);
		answer_edit = (EditText)findViewById(R.id.answer_edit);
		username=(EditText)findViewById(R.id.username);
		next = (Button)findViewById(R.id.next);
		textView1 = (TextView)findViewById(R.id.textView1);
		textView2 = (TextView)findViewById(R.id.textView2);
		question = (Spinner)findViewById(R.id.question);
		 ArrayAdapter<String> adapter_state = new ArrayAdapter<String>(this,
				    android.R.layout.simple_spinner_item, Questions);
	  adapter_state.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				  
	question.setAdapter(adapter_state);
	 question.setOnItemSelectedListener(this);
	 question_edit.setVisibility(View.GONE);
	 questiontxt.setVisibility(View.GONE);
	
	 
	 
		next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if(username.getText().length()>0 && answer_edit.getText().length() > 0){
					//save name
					SharedPreferences.Editor editor = name.edit();
			    	editor.putString("Username",username.getText().toString());
			    	editor.commit();
			    	// save answer
			    	SharedPreferences.Editor editor1 = Answer.edit();
			    	editor1.putString("answer",answer_edit.getText().toString());
			    	editor1.commit();
			    	if (count ==1){
			    		SharedPreferences.Editor editor2 = Question.edit();
				    	editor2.putString("question",question_edit.getText().toString());
				    	editor2.commit();
			    	}
			    	Intent i = new Intent(User_info.this,Security.class);
	                startActivity(i);
	                finish();
					
				}
			}
			
		});
	Typeface font = Typeface.createFromAsset(getAssets(), "fonts/funky.ttf");
	textView1.setTypeface(font);
	textView2.setTypeface(font);
	username.setTypeface(font);
	next.setTypeface(font);
	
}
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int position,
			long arg3) {
		// TODO Auto-generated method stub
	     if (position == 0){
	    	 //save question 
	    	 SharedPreferences.Editor editorq = Question.edit();
		    	editorq.putString("question","What is your name?");
		    	editorq.commit();
	     }else if (position ==1){
	    	 // save question
	    	 SharedPreferences.Editor editorq = Question.edit();
		    	editorq.putString("question","What is your pet name?");
		    	editorq.commit();
	     }else if (position == 2){
	    	 //save question
	    	 SharedPreferences.Editor editorq = Question.edit();
		    	editorq.putString("question","Who is your inspiration?");
		    	editorq.commit();
	    	 
	     }else if(position == 3){
	    	 // question edit visible
			 questiontxt.setVisibility(View.VISIBLE);
			 question_edit.setVisibility(View.VISIBLE);
			 count = 1;
		 }
		
	}
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}}
