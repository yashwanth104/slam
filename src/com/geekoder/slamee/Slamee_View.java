package com.geekoder.slamee;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.ImageView;

public class Slamee_View extends Activity {

	 TextView name, nick,dob,phone,facebook,hobby,dear,favplace,sharescrt,live,love,dream,inspiration,youme,msg;
	   int day=0,month=0;
	   ImageView pic,zodiac;
	   Bitmap theImage;
	   @Override
	   protected void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.slamee_view);
	      
	      
	      name = (TextView) findViewById(R.id.name);
	        nick = (TextView) findViewById(R.id.n_name);
	        dob= (TextView) findViewById(R.id.dob);
	        phone = (TextView) findViewById(R.id.contact_num);
	        facebook = (TextView) findViewById(R.id.fbid);
	        hobby = (TextView) findViewById(R.id.hobby);
	        dear = (TextView) findViewById(R.id.drst_frnd);
	        favplace = (TextView) findViewById(R.id.fvrt_place);
	        sharescrt = (TextView) findViewById(R.id.share_scrt);
	        live = (TextView) findViewById(R.id.i_cant);
	        love = (TextView) findViewById(R.id.in_love);
	        dream = (TextView) findViewById(R.id.dream);
	        inspiration = (TextView) findViewById(R.id.inspire);
	        youme = (TextView) findViewById(R.id.you_me);
	        msg = (TextView) findViewById(R.id.message);
	        pic = (ImageView) findViewById(R.id.image);
	        zodiac = (ImageView)findViewById(R.id.Zodaic);
	        
	        //get image
	      theImage = (Bitmap)getIntent().getParcelableExtra("imagename");
	      //display image
	      pic.setImageBitmap(theImage);
	      
	      //get name
	     String slameename = getIntent().getStringExtra("name");
	     //display name
	      name.setText(slameename);
	      
	      //get nick
	      String slameenick = getIntent().getStringExtra("nick");
	      //display nick
	      nick.setText(slameenick);
	      
	      //get day
	      String slameeday = getIntent().getStringExtra("day");
	      //get month
	      String slameemonth = getIntent().getStringExtra("month");
	      //get year
	      String slameeyear = getIntent().getStringExtra("year");
	      //display date of birth
          dob.setText(slameeday+"/"+slameemonth+"/"+slameeyear);
	      
	      
	      //-------------zodiac condition----------
	      
	      //converting strings into ints of day and month
	      if(slameeday.length()>0)
	  		day= Integer.parseInt(slameeday.toString());
	      if(slameemonth.length()>0)
	  		month= Integer.parseInt(slameemonth.toString());
	      
	      //display zodiac sign according to date od birth
	      
	      if(month==3 && day>=21 && day<=31 || month ==4 && day>=1 && day<=19 ){
	    	  zodiac.setImageResource(R.drawable.aries);
	      }else if (month ==4 && day>=20 && day<=30 || month == 5 &&day>=1 && day<=20){
	    	  zodiac.setImageResource(R.drawable.taurus);
	      }else if(month == 5 && day>=21 && day<=31 || month ==6 && day>=1 && day<=20){
	    	  zodiac.setImageResource(R.drawable.gemini);
	      }else if (month ==6 && day>=21 && day<=30 || month == 7 && day>=1 && day<=22){
	    	  zodiac.setImageResource(R.drawable.cancer);
	      }else if (month ==7 && day>=23 && day<=31 || month ==8 && day>=1 && day<=22){
	    	  zodiac.setImageResource(R.drawable.leo);
	      }else if(month ==8 && day>=23 && day<=31 || month ==9 && day>=1 && day<=22){
	    	  zodiac.setImageResource(R.drawable.virgo);
	      }else if(month==9 && day>=23 &&day<=30 || month == 10 && day>=1 && day<=22 ){
	    	  zodiac.setImageResource(R.drawable.libra);
	      }else if(month ==10 && day>=23 && day<=31 || month == 11 && day>=1 && day<=21){
	    	  zodiac.setImageResource(R.drawable.scorpio);
	      }else if (month == 11 && day>=22 && day<=30 || month ==12 && day>=1 && day <=21){
	    	  zodiac.setImageResource(R.drawable.sagittarius);
	      }else if(month ==12 && day>=22 && day<=31 || month == 1 && day>=1 && day<=19){
	    	  zodiac.setImageResource(R.drawable.capricorn);
	      }else if(month == 1 && day>=20 && day<=31 || month ==2 && day>=1 && day<=18){
	    	  zodiac.setImageResource(R.drawable.aquarius);
	      }else if(month ==2 && day>=19 && day<=29 ||month ==3 && day>=1 && day<=20){
	    	  zodiac.setImageResource(R.drawable.pisces);
	      }
	      
	      //get phone number
	      String slameephone = getIntent().getStringExtra("phone");
	      //display phone number
	      phone.setText(slameephone);
	      
	      //phone intent
	      
	      phone.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					String slameephone = getIntent().getStringExtra("phone");
					
					Intent intent = new Intent(Intent.ACTION_DIAL);
					intent.setData(Uri.parse("tel:"+slameephone));
					startActivity(intent); 
					
				}
		    	  
		      });
	      
	      //get fb
	      String slameefb = getIntent().getStringExtra("fb");
	      //display fb
	      facebook.setText(slameefb);
	      
	      //fb intent
	      facebook.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 String slameefb = getIntent().getStringExtra("fb");
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse("https://www."+slameefb));
				startActivity(i);
				
			}
	    	  
	      });
	      //get hobby
	      String slameehobby = getIntent().getStringExtra("hobby");
	      //display hobby
	      hobby.setText(slameehobby);
	      
	      //get dear
	      String slameedear = getIntent().getStringExtra("dear");
	      //display dear
	      dear.setText(slameedear);
	      
	      //get place
	      String slameeplace = getIntent().getStringExtra("place");
	      //display place
	      favplace.setText(slameeplace);
	      
	      //get scrt
	      String slameescrt = getIntent().getStringExtra("scrt");
	      //display scrt
	      sharescrt.setText(slameescrt);
	      
	      //get live
	      String slameelive = getIntent().getStringExtra("live");
	      //display live 
	      live.setText(slameelive);
	      
	      //get love
	      String slameelove = getIntent().getStringExtra("love");
	      //display love
	      love.setText(slameelove);
	      
	      //get dream
	      String slameedream = getIntent().getStringExtra("dream");
	      //display dream
	      dream.setText(slameedream);
	      
	      //get inspiration
	      String slameeinspire = getIntent().getStringExtra("inspire");
	      //display inspiration
	      inspiration.setText(slameeinspire);
	      
	      //get you to me
	      String slameeyou = getIntent().getStringExtra("you");
	      //display you to me
	      youme.setText(slameeyou);
	      
	    //get message
	      String slameemsg = getIntent().getStringExtra("msg");
	      //display message
	      msg.setText(slameemsg);
	      
	      
	      pic.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent(Slamee_View.this,Slamee_Pic.class);
				pic.buildDrawingCache();
				Bitmap image= pic.getDrawingCache();
				Bundle extras = new Bundle();
				extras.putParcelable("imagebitmap", image);
				i.putExtras(extras);		
				startActivity(i);
				
			}});
	      
	      
}}
