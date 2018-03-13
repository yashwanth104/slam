package com.geekoder.slamee;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

public class Slamee_Pic extends Activity {
	ImageView pic;
	@Override
	   protected void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.slamee_pic);
	      
	      pic = (ImageView) findViewById(R.id.imageView1);
	      
	      Bundle extras = getIntent().getExtras();
	      Bitmap bmp = (Bitmap) extras.getParcelable("imagebitmap");

	      pic.setImageBitmap(bmp);
}}
