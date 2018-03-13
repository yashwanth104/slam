package com.geekoder.slamee;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class List_View extends Activity {

	 List<Slamee> slamees;
	    ListView ListView1;
	    byte[] imageName;
	    Bitmap theImage;
	    DatabaseHandler dbHandler;
	    ArrayAdapter<Slamee> adapter;
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.listview);
	        slamees = new ArrayList<Slamee>();
	        ListView1 = (ListView) findViewById(R.id.listview);
	        dbHandler = new DatabaseHandler(getApplicationContext());
	        
	        slamees.addAll(dbHandler.getAllSlamees());
	        populateList();
	        
	        
	        ListView1.setOnItemClickListener(new OnItemClickListener(){

				public void onItemClick(AdapterView<?> parent, View v, int position,
						long id) {
					// TODO Auto-generated method stub
					Slamee currentslamee = slamees.get(position);
					// convert byte to bitmap
					imageName = currentslamee.getImage();
					Log.d("Before Send:****", imageName + "-" );
					ByteArrayInputStream imageStream = new ByteArrayInputStream(
							imageName);
					theImage = BitmapFactory.decodeStream(imageStream);
					Intent i = new Intent(List_View.this,Slamee_View.class);
					i.putExtra("name",currentslamee.getName());
					i.putExtra("nick", currentslamee.getNick());
					i.putExtra("phone",currentslamee.getPhone());
					i.putExtra("day",currentslamee.getday());
					i.putExtra("month",currentslamee.getmonth());
					i.putExtra("year",currentslamee.getyear());
					i.putExtra("phone",currentslamee.getPhone());
					i.putExtra("fb",currentslamee.getfb());
					i.putExtra("hobby",currentslamee.gethobby());
					i.putExtra("dear",currentslamee.getdear());
					i.putExtra("place",currentslamee.getplace());
					i.putExtra("scrt",currentslamee.getscrt());
					i.putExtra("live",currentslamee.getlive());
					i.putExtra("love",currentslamee.getlove());
					i.putExtra("dream",currentslamee.getdream());
					i.putExtra("inspire",currentslamee.getinspire());
					i.putExtra("you",currentslamee.getyou());
					i.putExtra("msg",currentslamee.getmsg());
					i.putExtra("imagename", theImage);
					startActivity(i);
					
					overridePendingTransition(R.anim.from_middle, R.anim.to_middle);
				}});
	        
}
	 private void populateList() {
	        adapter = new ContactListAdapter();
	        ListView1.setAdapter(adapter);
	        
	    }
	 public class ContactListAdapter extends ArrayAdapter<Slamee> {
	  public ContactListAdapter() {
	   super (List_View.this, R.layout.listview_item, slamees);
	        }
	  @Override
	 public View getView(int position, View view, ViewGroup parent) {
         if (view == null)
             view = getLayoutInflater().inflate(R.layout.listview_item, parent, false);
            
         Slamee currentslamee = slamees.get(position);
         //display name in list item
         TextView name = (TextView) view.findViewById(R.id.contactName);
         name.setText(currentslamee.getName());
         //dispaly image in list item
         ImageView ivContactImage = (ImageView) view.findViewById(R.id.user_logo);
         byte[] outImage=currentslamee.getImage();
         ByteArrayInputStream imageStream = new ByteArrayInputStream(outImage);
         Bitmap theImage = BitmapFactory.decodeStream(imageStream);
         ivContactImage.setImageBitmap(theImage);
         String a = "shiva";
           if(currentslamee.getName().equals(a)){
        	   adapter.remove(adapter.getItem(position));
        	   adapter.notifyDataSetChanged();
        	   adapter.notifyDataSetInvalidated();
        	 // populateList();
           }
         //background of list view
         LinearLayout bga = (LinearLayout)view.findViewById(R.id.bg);
         
        String bg1 = currentslamee.getback();
        if(bg1.equals("0") ){
        	bga.setBackgroundResource(R.drawable.listbg1);
        }else if (bg1.equals("1")){
        	 bga.setBackgroundResource(R.drawable.listbg2);
        }else if(bg1.equals("2")){
        	 bga.setBackgroundResource(R.drawable.listbg3);
        }
         return view;
     }
 }


}
