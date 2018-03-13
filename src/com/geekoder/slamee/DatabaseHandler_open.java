package com.geekoder.slamee;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler_open extends SQLiteOpenHelper {

	 private static final int DATABASE_VERSION_1 = 2;

	    private static final String DATABASE_NAME_1 = "SlameeManager1",
	    TABLE_CONTACTS_1 = "slamees",
	    KEY_ID_1 = "id1",
	    KEY_NAME_1 = "name1",
	    KEY_NICK_1 = "nick1",
	    KEY_DAY_1 = "day1",
	    KEY_MONTH_1 = "month1",
	    KEY_YEAR_1="year1",
	    KEY_BACK_1 = "back1",
	    KEY_PHONE_1 = "phone1",
	    KEY_FB_1 = "fb1",
	    KEY_HOBBY_1 = "hobby1",
	    KEY_DEAR_1   = "dear1",
	    KEY_PLACE_1 = "place1",
	    KEY_SCRT_1 = "scrt1",
	    KEY_LIVE_1 = "live1",
	    KEY_LOVE_1 = "love1",
	    KEY_DREAM_1 = "dream1",
	    KEY_INSPIRE_1 = "inspire1",
	    KEY_YOU_1 = "you1",
	    KEY_MSG_1 = "msg1",
	    //KEY_SIGN_1 = "sign1",
	   KEY_IMAGE_1 = "image1";

	    public DatabaseHandler_open(Context context) {
	        super(context, DATABASE_NAME_1, null, DATABASE_VERSION_1);
	    }

	    @Override
	    public void onCreate(SQLiteDatabase db) {
	        db.execSQL("CREATE TABLE " + TABLE_CONTACTS_1 + "(" + KEY_ID_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME_1 + " TEXT," + KEY_NICK_1 + " TEXT," + KEY_DAY_1 + " TEXT," + KEY_MONTH_1 + " TEXT,"+ KEY_YEAR_1 + " TEXT,"+ KEY_BACK_1 + " TEXT,"+ KEY_PHONE_1 + " TEXT,"+ KEY_FB_1+ " TEXT,"+ KEY_HOBBY_1 + " TEXT," + KEY_DEAR_1 + " TEXT,"+ KEY_PLACE_1 + " TEXT,"+ KEY_SCRT_1 + " TEXT,"+ KEY_LIVE_1 + " TEXT,"+ KEY_LOVE_1 + " TEXT,"+ KEY_DREAM_1+ " TEXT,"+ KEY_INSPIRE_1 + " TEXT,"+ KEY_YOU_1 + " TEXT,"+ KEY_MSG_1 + " TEXT,"+  KEY_IMAGE_1 + "  BLOB)");
	    }

	    @Override
	    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS_1);

	        onCreate(db);
	    }

	    public void createContact(Slamee slam) {
	        SQLiteDatabase db = getWritableDatabase();

	        ContentValues values = new ContentValues();

	        values.put(KEY_NAME_1, slam.getName());
	        values.put(KEY_NICK_1, slam.getNick());
	        values.put(KEY_DAY_1, slam.getday());
	        values.put(KEY_MONTH_1, slam.getmonth());
	        values.put(KEY_YEAR_1, slam.getyear());
	        values.put(KEY_PHONE_1, slam.getPhone());
	        values.put(KEY_FB_1, slam.getfb());
	        values.put(KEY_HOBBY_1, slam.gethobby());
	        values.put(KEY_DEAR_1, slam.getdear());
	        values.put(KEY_PLACE_1, slam.getplace());
	        values.put(KEY_SCRT_1, slam.getscrt());
	        values.put(KEY_LIVE_1, slam.getlive());
	        values.put(KEY_LOVE_1, slam.getlove());
	        values.put(KEY_DREAM_1, slam.getdream());
	        values.put(KEY_INSPIRE_1, slam.getinspire());
	        values.put(KEY_YOU_1, slam.getyou());
	        values.put(KEY_MSG_1, slam.getmsg());
	        values.put(KEY_IMAGE_1, slam.getImage());
            values.put(KEY_BACK_1, slam.getback());
           // values.put(KEY_SIGN_1, slam.getSign());
	        db.insert(TABLE_CONTACTS_1, null, values);
	        db.close();
	    }

	    public Slamee getContact(int id) {
	        SQLiteDatabase db = getReadableDatabase();

	        Cursor cursor = db.query(TABLE_CONTACTS_1, new String[] { KEY_ID_1, KEY_NAME_1, KEY_NICK_1, KEY_DAY_1, KEY_MONTH_1, KEY_YEAR_1, KEY_BACK_1,KEY_PHONE_1, KEY_FB_1, KEY_HOBBY_1, KEY_DEAR_1, KEY_PLACE_1, KEY_SCRT_1, KEY_LIVE_1, KEY_LOVE_1, KEY_DREAM_1, KEY_INSPIRE_1, KEY_YOU_1, KEY_MSG_1, KEY_IMAGE_1 }, KEY_ID_1 + "=?", new String[] { String.valueOf(id) }, null, null, null, null );

	        if (cursor != null)
	            cursor.moveToFirst();

	        Slamee contact = new Slamee(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),cursor.getString(5), cursor.getString(6),  cursor.getString(7),  cursor.getString(8),  cursor.getString(9),  cursor.getString(10),  cursor.getString(11),  cursor.getString(12),  cursor.getString(13),  cursor.getString(14),  cursor.getString(15),  cursor.getString(16),  cursor.getString(17), cursor.getString(18), cursor.getBlob(19)); 
	        db.close();
	        cursor.close();
	        return contact;
	    }

	    public void deleteContact(Slamee slam) {
	        SQLiteDatabase db = getWritableDatabase();
	        db.delete(TABLE_CONTACTS_1, KEY_ID_1 + "=?", new String[] { String.valueOf(slam.getId()) });
	        db.close();
	    }

	    public int getContactCount() {
	        SQLiteDatabase db = getReadableDatabase();
	        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_CONTACTS_1, null);
	        int count = cursor.getCount();
	        db.close();
	        cursor.close();

	        return count;
	    }

	    public int updateContact(Slamee slam) {
	        SQLiteDatabase db = getWritableDatabase();

	        ContentValues values = new ContentValues();

	        values.put(KEY_NAME_1, slam.getName());
	        values.put(KEY_NICK_1, slam.getNick());
	        values.put(KEY_DAY_1, slam.getday());
	        values.put(KEY_MONTH_1, slam.getmonth());
	        values.put(KEY_YEAR_1, slam.getyear());
	        values.put(KEY_BACK_1, slam.getback());
	        values.put(KEY_PHONE_1, slam.getPhone());
	        values.put(KEY_FB_1, slam.getfb());
	        values.put(KEY_HOBBY_1, slam.gethobby());
	        values.put(KEY_DEAR_1, slam.getdear());
	        values.put(KEY_PLACE_1, slam.getplace());
	        values.put(KEY_SCRT_1, slam.getscrt());
	        values.put(KEY_LIVE_1, slam.getlive());
	        values.put(KEY_LOVE_1, slam.getlove());
	        values.put(KEY_DREAM_1, slam.getdream());
	        values.put(KEY_INSPIRE_1, slam.getinspire());
	        values.put(KEY_YOU_1, slam.getyou());
	        values.put(KEY_MSG_1, slam.getmsg());
	       // values.put(KEY_SIGN_1, slam.getSign());
	        values.put(KEY_IMAGE_1, slam.getImage());

	        int rowsAffected = db.update(TABLE_CONTACTS_1, values, KEY_ID_1 + "=?", new String[] { String.valueOf(slam.getId()) });
	        db.close();

	        return rowsAffected;
	    }

	    public List<Slamee> getAllSlamees() {
	        List<Slamee> slamees1 = new ArrayList<Slamee>();


	        SQLiteDatabase db = getWritableDatabase();
	        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_CONTACTS_1, null);

	        if (cursor.moveToFirst()) {
	            do {
	            	slamees1.add(new Slamee(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getString(10), cursor.getString(11), cursor.getString(12), cursor.getString(13), cursor.getString(14), cursor.getString(15), cursor.getString(16), cursor.getString(17), cursor.getString(18), cursor.getBlob(19)));
	            
	            }
	            while (cursor.moveToNext());
	        }
	        cursor.close();
	        db.close();
	        return slamees1;
	    }
	}
