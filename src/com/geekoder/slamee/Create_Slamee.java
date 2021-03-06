package com.geekoder.slamee;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.Toast;

public class Create_Slamee extends Activity {
	RadioButton a,b,d;
	EditText name , nick,dob,phone,facebook,hobby,dear,favplace,sharescrt,live,love,dream,inspiration,youme,msg;
	int mDay=0,mMonth=0,mYear=0 ;
	String day = "0",month="0",year="000",back = "0";
    ImageView image , signature,bgn;
    Button save,datepick;
	 List<Slamee> slamees = new ArrayList<Slamee>();
    byte imageInByte[] ,signatureByte[];
	byte[] background;
    private static final int CAMERA_REQUEST = 1;
    private static final int PICK_FROM_GALLERY = 2;
    DatabaseHandler dbHandler;
    static final int DATE_PICKER_ID = 1111; 
    final Context context = this;
    Bitmap theImage;
    private DrawingView drawView;
    ScrollView s;
    LinearLayout container,layoutbg;
    @TargetApi(Build.VERSION_CODES.HONEYCOMB) @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_slamee);
        
        layoutbg=(LinearLayout)findViewById(R.id.layout);
       s =(ScrollView)findViewById(R.id.bgback);
        bgn = (ImageView)findViewById(R.id.bgn);
        a = (RadioButton)findViewById(R.id.heart);
        b = (RadioButton)findViewById(R.id.star);
        d = (RadioButton)findViewById(R.id.shock);
        save =(Button) findViewById(R.id.save);
        datepick =(Button) findViewById(R.id.date);
        name = (EditText) findViewById(R.id.name);
        nick = (EditText) findViewById(R.id.n_name);
        dob =(EditText) findViewById(R.id.dob);
        phone = (EditText) findViewById(R.id.contact_num);
        facebook = (EditText) findViewById(R.id.fbid);
        hobby = (EditText) findViewById(R.id.hobby);
        dear = (EditText) findViewById(R.id.drst_frnd);
        favplace = (EditText) findViewById(R.id.fvrt_place);
        sharescrt = (EditText) findViewById(R.id.share_scrt);
        live = (EditText) findViewById(R.id.i_cant);
        love = (EditText) findViewById(R.id.in_love);
        dream = (EditText) findViewById(R.id.dream);
        inspiration = (EditText) findViewById(R.id.inspire);
        youme = (EditText) findViewById(R.id.you_me);
        msg = (EditText) findViewById(R.id.message);
        image = (ImageView) findViewById(R.id.image);
        signature = (ImageView)findViewById(R.id.sign);
        
        dbHandler = new DatabaseHandler(getApplicationContext());
        save.setEnabled(false);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.no_user_logo);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
       imageInByte = stream.toByteArray();
       signatureByte = stream.toByteArray();
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DATE);
       
        dob.setEnabled(false);
     
       signature.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			// TODO Auto-generated method stub
			 final Dialog dialog = new Dialog(context ,android.R.style.Theme_Translucent_NoTitleBar);
			 dialog.setContentView(R.layout.signature);
			 ImageButton newbtn = (ImageButton)dialog.findViewById(R.id.new_btn);
			 ImageButton savebtn = (ImageButton)dialog.findViewById(R.id.save_btn);
			 ImageButton colorbtn = (ImageButton)dialog.findViewById(R.id.color_btn);
			 drawView = (DrawingView)dialog.findViewById(R.id.drawing);
         newbtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				AlertDialog.Builder newDialog = new AlertDialog.Builder(Create_Slamee.this);
				newDialog.setTitle("New drawing");
			    newDialog.setMessage("Start new drawing (you will lose the current drawing)?");
				newDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
				        public void onClick(DialogInterface dialog, int which){
				          drawView.startNew();
					    dialog.dismiss();
										}
									});
					   newDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
							public void onClick(DialogInterface dialog, int which){
							dialog.cancel();
										}});
									newDialog.show();
			}
        	 
         });

         savebtn.setOnClickListener(new OnClickListener(){

 			
			//@SuppressWarnings("deprecation")
			@SuppressLint("NewApi") @Override
 			public void onClick(View v) {
 				// TODO Auto-generated method stub
				Bitmap bottomImage = BitmapFactory.decodeResource(getResources(), R.drawable.bg);
 				drawView.setDrawingCacheEnabled(true);
 				drawView.buildDrawingCache();
 				
 				Bitmap result = Bitmap.createBitmap(s.getWidth(), s.getHeight(), Bitmap.Config.RGB_565);
 				Bitmap si = drawView.getDrawingCache();
 				Canvas comboImage = new Canvas(result);
 				comboImage.drawBitmap(bottomImage, 0f, 0f, null);
 				comboImage.drawBitmap(si, 0f, 200f, null);
 				@SuppressWarnings("deprecation")
				Drawable drawable = new BitmapDrawable(result); 
 				layoutbg.setBackground(drawable);
 			
 				//s.setImageBitmap(result);
 				
 			/*	ByteArrayOutputStream stream = new ByteArrayOutputStream();
 				bottomImage.compress(Bitmap.CompressFormat.PNG, 100, stream);
 				background = stream.toByteArray();*/
 				//bgn.setImageBitmap(bottomImage);
 				dialog.cancel();
 			}
         	 
          });
         colorbtn.setOnClickListener(new OnClickListener(){

 			@Override
 			public void onClick(View v) {
 				// TODO Auto-generated method stub
 				
 				
 				
 			}
         	 
          });
         
         
				dialog.show();
			
			
		}
	});
        
        datepick.setOnClickListener(new OnClickListener(){

			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(DATE_PICKER_ID);
				
	            
	            
			}
        });
       a.setChecked(true);
      
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	 if(a.isChecked()){
                 	back = "0";
                 }
                 if(b.isChecked()){
                 	back = "1";
                 }
                 if(d.isChecked()){
                 	back = "2";
                 }
                Slamee contact = new Slamee(dbHandler.getContactCount(), String.valueOf(name.getText()),String.valueOf(nick.getText()),String.valueOf(mDay),String.valueOf(mMonth),String.valueOf(mYear),String.valueOf(back),String.valueOf(phone.getText()), String.valueOf(facebook.getText()), String.valueOf(hobby.getText()), String.valueOf(dear.getText()), String.valueOf(favplace.getText()), String.valueOf(sharescrt.getText()), String.valueOf(live.getText()), String.valueOf(love.getText()), String.valueOf(dream.getText()), String.valueOf(inspiration.getText()), String.valueOf(youme.getText()), String.valueOf(msg.getText()), imageInByte);
                if (!contactExists(contact) ) {
                    dbHandler.createContact(contact);
                    slamees.add(contact);
                    Toast.makeText(getApplicationContext(), String.valueOf(name.getText()) + " has been added to your Slamees!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Create_Slamee.this,Home_page.class);
    	            startActivity(i);
    	            finish();
                    return;
                }else if ( mYear ==0 && mMonth ==0 && mDay ==0){
                	Toast.makeText(getApplicationContext()," Invalid Date of Birth.Please Enter the Correct.", Toast.LENGTH_SHORT).show();
               
                } else
                	{
                	 Toast.makeText(getApplicationContext(), String.valueOf(name.getText()) + " already exists. Please use a different name.", Toast.LENGTH_SHORT).show();
                	}
                	}
        });

        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                save.setEnabled(String.valueOf(name.getText()).trim().length() > 0);
        }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
          
        
        
        final String[] option = new String[] { "Take from Camera",
        "Select from Gallery" };


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        android.R.layout.select_dialog_item, option);
        builder.setTitle("Select Option");
        builder.setAdapter(adapter, new DialogInterface.OnClickListener() {

        public void onClick(DialogInterface dialog, int which) {
        // TODO Auto-generated method stub
        Log.e("Selected Item", String.valueOf(which));
        if (which == 0) {
        callCamera();
        }
        if (which == 1) {
        callGallery();
        }

        }
        });
        final AlertDialog dialog = builder.create();
                image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    	dialog.show();
                           }});
	}
    
    private boolean contactExists(Slamee contact) {
        String name = contact.getName();
        int contactCount = slamees.size();

        for (int i = 0; i < contactCount; i++) {
            if (name.compareToIgnoreCase(slamees.get(i).getName()) == 0)
                return true;
        }
        return false;
    }
    public void onActivityResult(int reqCode, int resCode, Intent data) {
        if (resCode == RESULT_OK) {
        	switch (reqCode){
        	case CAMERA_REQUEST:

        		Bundle extras = data.getExtras();

        		if (extras != null) {
        		Bitmap yourImage = extras.getParcelable("data");
        		// convert bitmap to byte
        		ByteArrayOutputStream stream = new ByteArrayOutputStream();
        		yourImage.compress(Bitmap.CompressFormat.PNG, 100, stream);
        		 imageInByte = stream.toByteArray();
        		 image.setImageBitmap(yourImage);
        		Log.e("output before conversion", imageInByte.toString());

        		}
        		break;
        		case PICK_FROM_GALLERY:
        		Bundle extras2 = data.getExtras();

        		if (extras2 != null) {
        		Bitmap yourImage = extras2.getParcelable("data");
        		 image.setImageBitmap(yourImage);
        		// convert bitmap to byte
        		ByteArrayOutputStream stream = new ByteArrayOutputStream();
        		yourImage.compress(Bitmap.CompressFormat.PNG, 100, stream);
        		imageInByte = stream.toByteArray();
        		Log.e("output before conversion", imageInByte.toString());
        		
        		}

        		break;
        		
        		
        		}
        	}
            
        }
    
	// open camera 
	
    
    public void callCamera() {
    	Intent Intent = new Intent();
    	//android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
    	Intent.setAction(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
    	Intent.putExtra("crop", "true");
    	Intent.putExtra("aspectX", 0);
    	Intent.putExtra("aspectY", 0);
    	Intent.putExtra("outputX", 200);
    	Intent.putExtra("outputY", 150);
    	startActivityForResult(Intent, 1);

    	}

    	
    // open gallery 
    	

    	public void callGallery() {
    	Intent intent = new Intent();
    	intent.setType("image/*");
    	intent.setAction(Intent.ACTION_GET_CONTENT);
    	intent.putExtra("crop", "true");
    	intent.putExtra("aspectX", 0);
    	intent.putExtra("aspectY", 0);
    	intent.putExtra("outputX", 200);
    	intent.putExtra("outputY", 150);
    	intent.putExtra("return-data", true);
    	startActivityForResult(
    	Intent.createChooser(intent, "Complete action using"),
    	2);

    	}
    	 private DatePickerDialog.OnDateSetListener pDateSetListener =
    	            new DatePickerDialog.OnDateSetListener() {
    	 
    	                public void onDateSet(DatePicker view, int year, 
    	                                      int monthOfYear, int dayOfMonth) {
    	                    mYear = year;
    	                    mMonth = monthOfYear+1;
    	                    mDay = dayOfMonth;
    	                    //display date of birth in edittext
    	                    dob.setText(mDay+"/"+mMonth+"/"+mYear);
    	                   
    	                }
    	            };
    	            @Override
    	            protected Dialog onCreateDialog(int id) {
    	                switch (id) {
    	                case DATE_PICKER_ID:
    	                    return new DatePickerDialog(this, 
    	                                pDateSetListener,
    	                                mYear, mMonth, mDay);
    	                }
    	                return null;
    	            }

    
    }